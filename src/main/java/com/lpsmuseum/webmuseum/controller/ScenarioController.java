package com.lpsmuseum.webmuseum.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lpsmuseum.dto.MuseologicalObject;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Theme;
import com.lpsmuseum.service.MuseologicalObjectService;
import com.lpsmuseum.service.ScenarioService;
import com.lpsmuseum.service.ThemeService;
import com.lpsmuseum.service.builders.ScenarioBuilder;

@Controller
public class ScenarioController {

    @RequestMapping("scenario")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("scenario/list");
        ArrayList<Scenario> sc = new ScenarioService().listScenarios();
        mv.addObject("list", sc);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.clone();
        mv.addObject("format", sdf);
        return mv;
    }

    @RequestMapping("scenario/create")
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("scenario/form");
        List<MuseologicalObject> obj = new MuseologicalObjectService()
                .listObjects();
        mv.addObject("objects", obj);
        List<Theme> themes = new ThemeService().listThemes();
        mv.addObject("themes", themes);
        return mv;
    }

    @RequestMapping("scenario/add")
    public ModelAndView addScenario(String name, String theme, String[] objects) {
        ModelAndView mv;
        try {
            ScenarioBuilder builder = new ScenarioBuilder();
            if (objects != null && objects.length > 0) {
                for (String object : objects) {
                    builder.withObject(new MuseologicalObjectService()
                            .findById(new Long(object)));
                }
            }
            Theme t = new ThemeService().findById(new Long(theme));
            Scenario scenario = builder.withTheme(t).build(name);
            mv = new ModelAndView("scenario/created");
            mv.addObject("scenario", scenario);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            mv.addObject("format", sdf);
        } catch (Exception e) {
            e.printStackTrace();
            mv = new ModelAndView("scenario/error");
            mv.addObject("exception", e);
        }
        return mv;
    }

    @RequestMapping("scenario/edit")
    public ModelAndView edit(Long id) {
        ModelAndView mv = new ModelAndView("scenario/edit");
        Scenario scenario = new ScenarioService().findById(id);
        mv.addObject("scenario", scenario);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        mv.addObject("format", sdf);
        ArrayList<MuseologicalObject> obj = new MuseologicalObjectService()
                .listObjects();
        mv.addObject("objects", obj);
        ArrayList<Theme> themes = new ThemeService().listThemes();
        mv.addObject("themes", themes);
        return mv;
    }

    @RequestMapping("scenario/delete")
    public String delete(Long id) {
        new ScenarioService().deleteScenario(id);
        return "redirect:/scenario";
    }

    @RequestMapping("scenario/update")
    public String update(Long id, String name, Long theme,
            String[] objects) {
        try {
            ScenarioService service = new ScenarioService();
            id.byteValue();
            Scenario scenario = service.findById(id);
            scenario.setName(name);
            if (objects != null && objects.length > 0) {
                scenario.getObjects().clear();
                MuseologicalObject o = null;
                for (String object : objects) {
                    o = new MuseologicalObjectService().findById(new Long(object));
                    scenario.getObjects().add(o);
                }
            } else {
                scenario.getObjects().clear();
            }
            scenario.setTheme(new ThemeService().findById(theme));
            service.editScenario(scenario);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/scenario/error";
        }
        return "redirect:/scenario";
    }
}
