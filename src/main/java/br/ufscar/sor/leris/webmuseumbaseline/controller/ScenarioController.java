package br.ufscar.sor.leris.webmuseumbaseline.controller;

import org.springframework.stereotype.Controller;

/**
 *
 * @author Guilherme Gois
 */
@Controller
public class ScenarioController {/*
    ScenarioService scenarioService = new ScenarioService();
    ThemeService themeService = new ThemeService();

    @RequestMapping("Scenario")
    public ModelAndView showAllScenarios() {
        ModelAndView mav = new ModelAndView("management/scenario/list");

        mav.add("objects", scenarioService.listScenarios());

        return mav;
    }

    @RequestMapping("Scenario/Add")
    public ModelAndView addScenario(String name, Long themeId, Long[] objectsId) {
        ModelAndView mav = null;
        ScenarioBuilder scenarioBuilder = new ScenarioBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        try {
	        for (Long oid : objectsId)
	        	scenarioBuilder.withObject(MuseologicalObjectController.service.findById(oid));
	        scenarioService.createScenario(scenarioBuilder.withTheme(themeService.findById(themeId)).build(name));

	        mav = new ModelAndView("management/success");
	        stringBuilder.append("Scenario (");
	        stringBuilder.append(name);
	        stringBuilder.append(") added with success!");
	        mav.add("message", stringBuilder.toString());
	    } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return mav;
    }

    @RequestMapping("Scenario/Edit")
    public ModelAndView getScenarioById(Long id) {
        ModelAndView mav = null;

        Scenario s = scenarioService.findById(id);
        if (s == null) {
            mav = new ModelAndView("management/error");
        } else {
            mav = new ModelAndView("management/scenario/edit");
            mav.add("object", s);
        }

        return mav;
    }

    @RequestMapping("Scenario/Update")
    public ModelAndView updateScenario(Long id, String name, String type, String url) {
        ModelAndView mav = null;

        try {
            Scenario s = null;

            if (type.equals("object"))
                s = scenarioService.findById();
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return mav;
    }

    @RequestMapping("Scenario/Delete")
    public ModelAndView deleteScenario(Long id) {
    	try {
        	scenarioService.deleteObject(id);
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return showAllObjects();
    }
*/    
}
