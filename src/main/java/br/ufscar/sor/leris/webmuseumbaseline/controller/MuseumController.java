package br.ufscar.sor.leris.webmuseumbaseline.controller;

import org.springframework.stereotype.Controller;

/**
 *
 * @author Guilherme Gois
 */
@Controller
public class MuseumController {/*
    MuseumService service = new MuseumService();

    @RequestMapping("Museum")
    public ModelAndView showAllMuseums() {
        ModelAndView mav = new ModelAndView("management/museum/list");

        mav.add("museums", service.listMuseums());

        return mav;
    }

    @RequestMapping("Museum/Add")
    public ModelAndView addMuseum(String name, Long[] scenariosId) {
        ModelAndView mav = null;
        MuseumBuilder museumBuilder = new MuseumBuilder();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            for (Long sid : scenariosId)
                museumBuilder.withScenario(ScenarioController.service.findById(sid));
            service.createMuseum(museumBuilder.build(name));

            mav = new ModelAndView("management/success");
            stringBuilder.append("Museum (");
            stringBuilder.append(name);
            stringBuilder.append(") added with successs!");
            mav.add("message", stringBuilder.toString());
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return mav;
    }

    @RequestMapping("Museum/Edit")
    public ModelAndView getMuseumById(Long id) {
        ModelAndView mav = null;

        Museum mo = service.findById(id);
        if (mo == null) {
            mav = new ModelAndView("management/error");
            mav.add("title", "Can't retrive museological museum data.");
            mav.add("message", "Doesn't not exist a museological museum with id = " + id);
        } else {
            mav = new ModelAndView("management/museum/edit");
            mav.add("museum", mo);
        }

        return mav;
    }

    @RequestMapping("Museum/Update")
    public ModelAndView updateMuseum(Long id, String name, String type, String url) {
        ModelAndView mav = null;

        try {
            Museum mo = null;

            if (type.equals("museum"))
                mo = service.findById();
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return mav;
    }

    @RequestMapping("Museum/Delete")
    public ModelAndView deleteMuseum(Long id) {
        try {
            service.deleteMuseum(id);
        } catch (Exception exception) {
            mav = new ModelAndView("management/error");
            mav.add("title", "An internal error occurred.");
            mav.add("message", exception.getMessage());
        }

        return showAllMuseums();
    }
*/    
}
