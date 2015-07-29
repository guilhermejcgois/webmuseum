package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.behaviour.museum.Navigation;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.ScenarioService;
import com.lpsmuseum.service.builders.MuseumBuilder;
import java.text.ParseException;

@Controller
public class MuseumController {
    
    MuseumService service = new MuseumService();
    
    @RequestMapping("/")
    public ModelAndView startApp() {
        return new ModelAndView("index");
    }

    @RequestMapping("museum")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("museum/list");
        mv.addObject("list", service.listMuseum());
        return mv;
    }

    @RequestMapping("museum/create")
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("museum/form");
        mv.addObject("scenarios", new ScenarioService().listScenarios());
        return mv;
    }

    @RequestMapping("museum/edit")
    public ModelAndView edit(Long id) {
        ModelAndView mv = new ModelAndView("museum/edit");
        mv.addObject("museum", service.findById(id));
        return mv;
    }

    @RequestMapping("museum/delete")
    public String delete(Long id) {
        service.deleteMuseum(id);
        return "redirect:/museum";
    }

    @RequestMapping("museum/add")
    public ModelAndView addMuseum(String name, Long[] scenarios) throws Exception {
        ModelAndView mv;
        try {
            MuseumBuilder builder = new MuseumBuilder();
            if (scenarios != null)
                for (Long scenario : scenarios)
                    builder.withScenario(new ScenarioService().findById(scenario));
            mv = new ModelAndView("museum/created");
            mv.addObject("museum", builder.build(name));
        } catch (ParseException e) {
            mv = new ModelAndView("museum/error");
        }
        return mv;
    }
    
    @RequestMapping("museum/update")
    public String update(Long id, String name) {
        Museum museum = service.findById(id);
        museum.setName(name);
        try {
            service.editMuseum(museum);
        } catch (Exception ex) {
            return "redirect:/museum/error";
        }
        return "redirect:/museum";
    }

    @RequestMapping("present")
    public ModelAndView listPresent() {
        ModelAndView mv = new ModelAndView("museum/Present");

        return mv;
    }
}
