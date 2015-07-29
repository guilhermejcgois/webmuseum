package com.lpsmuseum.webmuseum.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lpsmuseum.dto.Annotation;
import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.object.Text;
import com.lpsmuseum.service.AnnotationService;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import java.text.DateFormat;
import java.util.List;

@Controller
public class MuseologicalObjectController {

	private MuseologicalObjectService service = new MuseologicalObjectService();

	@RequestMapping("object/create")
	public ModelAndView form() {
		return new ModelAndView("object/form");
	}
	
	@RequestMapping("object")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView("object/list");
		List<MuseologicalObject> objects = service.listObjects();
		mv.addObject("list", objects);
                // TODO Distinção entre tipos, objeto, imagem e texto
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
	
	@RequestMapping("object/add")
	public ModelAndView addObject(String name, String date, String url) {
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		ModelAndView mv;
		MuseologicalObject obj;

		try {
			c.setTime(sdf.parse(date));
			if (url.isEmpty()) {
				obj = (Text) new MuseologicalObjectBuilder().build(name, c, new Text());
			} else {
				Image img = new Image();
				img.setUrlAddress(url);
				obj = (Image) new MuseologicalObjectBuilder().build(name, c, img);
			}
			mv = new ModelAndView("object/created");
			mv.addObject("object", obj);
			mv.addObject("format", sdf);
		} catch (ParseException e) {
			e.printStackTrace();
			mv = new ModelAndView("object/error");
		}
		return mv;
	}
	
	@RequestMapping("object/edit")
	public ModelAndView editObject(Long id) {
		ModelAndView mv = new ModelAndView("object/edit");
		mv.addObject("object", service.findById(id));
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		mv.addObject("format", sdf);
		return mv;
	}
	
	@RequestMapping("object/delete")
	public String delete(Long id){
		// NOTE Não trabalhamos com anotações, se preocupar com elas não é desnecessário?
		AnnotationService annotationService = new AnnotationService();
		ArrayList<Annotation> annotations = annotationService.listByObject(id);
		if (annotations != null && annotations.size() > 0)
			for (Annotation a : annotations)
				annotationService.deleteAnnotation(a.getId());
		
		new MuseologicalObjectService().deleteObject(id);
		return "redirect:/object";
	}
	
	@RequestMapping("object/update")
	public String update(Long id, String name, String date) {
		MuseologicalObjectService service = new MuseologicalObjectService();
		MuseologicalObject object = service.findById(id);
		object.setName(name);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			c.setTime(sdf.parse(date));
		} catch (ParseException e) {
			return "redirect:/object/error";
		}
		object.setDate(c);
		service.editObject(object);		
		return "redirect:/object";
	}
}
