package br.ufscar.sor.leris.webmuseumbaseline.controller;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.builders.MuseologicalObjectBuilder;
import java.util.Calendar;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Guilherme Gois
 */
@Controller
public class MuseologicalObjectController {/*
    MuseologicalObjectService service = new MuseologicalObjectService();

    @RequestMapping("Museological Object")
    public ModelAndView showAllObjects() {
        ModelAndView mav = new ModelAndView("management/museologicalObject/list");

        mav.addObject("objects", service.listObjects());

        return mav;
    }

    @RequestMapping("Museological Object/Add")
    public ModelAndView addObject(String name, String urlImage, String urlText) {
        ModelAndView mav = null;
        MuseologicalObjectBuilder objectBuilder = new MuseologicalObjectBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        if (urlText != null && !urlText.isEmpty()) {
            service.createObject(objectBuilder.build(name, Calendar.getInstance()));

            mav = new ModelAndView("management/success");
            stringBuilder.append("Museological Object (");
            stringBuilder.append(name);
            stringBuilder.append(") added with success!");
            mav.addObject("message", stringBuilder.toString());

            return mav;
        }

        try {
            if (urlImage != null && !urlImage.isEmpty()) {
                service.createObject(objectBuilder.withURL(urlImage).buildImage(name, Calendar.getInstance()));

                stringBuilder.append("Image ");
            }
            if (urlText != null && !urlText.isEmpty()) {
                service.createObject(objectBuilder.withURL(urlText).buildText(name, Calendar.getInstance()));

                if (stringBuilder.length() == 0)
                    stringBuilder.append("Text ");
                else
                    stringBuilder.append("and Text ");
            } else {
                stringBuilder.append("for ");
            }
            stringBuilder.append("museological Object (");
            stringBuilder.append(name);
            stringBuilder.append(") added with success!");

            mav = new ModelAndView("management/success");
            mav.addObject("message", stringBuilder.toString());
        } catch (FormatNotSupportedException exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "Stated format is not supported.");
            mav.add("message", exception.getMessage());
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return mav;
    }

    @RequestMapping("Museological Object/Edit")
    public ModelAndView getObjectById(Long id) {
        ModelAndView mav = null;

        MuseologicalObject mo = service.findById(id);
        if (mo == null) {
            mav = new ModelAndView("management/error");
            mav.add("title", "Can't retrive museological object data.");
            mav.add("message", "Doesn't not exist a museological object with id = " + id);
        } else {
            mav = new ModelAndView("management/museologicalObject/edit");
            mav.add("object", mo);
        }

        return mav;
    }

    @RequestMapping("Museological Object/Update")
    public ModelAndView updateObject(Long id, String name, String type, String url) {
        ModelAndView mav = null;

        try {
            MuseologicalObject mo = null;

            if (type.equals("object"))
                mo = service.findById();
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return mav;
    }

    @RequestMapping("Museological Object/Delete")
    public ModelAndView deleteObject(Long id) {
        try {
            service.deleteObject(id);
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return showAllObjects();
    }
*/    
}
