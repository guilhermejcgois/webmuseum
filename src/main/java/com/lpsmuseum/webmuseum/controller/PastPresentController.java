/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.dto.object.Image;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ChallengePastPresent;
import com.lpsmuseum.service.ChallengePastPresentService;
import com.lpsmuseum.service.ImageService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author USER
 */
@Controller
public class PastPresentController {

    @RequestMapping("pastpresent")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("pastpresent/list");
        List<Challenge> list = new ChallengePastPresentService().listChallenges();
        List<ChallengePastPresent> challenges = new ArrayList<>();
        for (Challenge challenge : list) {
            if (challenge instanceof ChallengePastPresent) {
                challenges.add((ChallengePastPresent) challenge);
            }
        }
        mv.addObject("challenges", challenges);
        return mv;
    }

    @RequestMapping("pastpresent/create")
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("pastpresent/form");
        mv.addObject("list", new ImageService().listObjects());
        return mv;
    }

    @RequestMapping("pastpresent/add")
    public ModelAndView addPresentPast(String id_objectquestion, String id_objectanswer, String[] imageAlternativas) throws Exception {
        ModelAndView mv = new ModelAndView("pastpresent");
        ChallengePastPresentService s = new ChallengePastPresentService();
        ChallengePastPresent c = new ChallengePastPresent();

        Image imgQuestion = (Image) new ImageService().findById(Long.parseLong(id_objectquestion));
        c.setImageQuestion(imgQuestion);

        c.setImageAnswer((Image) new ImageService().findById(Long.parseLong(id_objectanswer)));

        for (int i = 0; i < imageAlternativas.length; i++) {
            c.getImagesAlternativas().add((Image) new ImageService().findById(Long.parseLong(imageAlternativas[i])));
        }

        s.createChallengePastPresent(c);

        return mv;
    }

    @RequestMapping("pastpresent/edit")
    public ModelAndView edit(Long id) {
        ModelAndView mv = new ModelAndView("pastpresent/edit");
        mv.addObject("list", new ImageService().listObjects());
        mv.addObject("challenge", new ChallengePastPresentService().findById(id));
        return mv;
    }

    @RequestMapping("pastpresent/update")
    public ModelAndView updatePresentPast(Long id, String id_objectquestion, String id_objectanswer, String[] imageAlternativas) throws Exception {
        ModelAndView mv = new ModelAndView("pastpresent");
        ChallengePastPresentService s = new ChallengePastPresentService();
        ChallengePastPresent c = new ChallengePastPresentService().findById(id);

        Image imgQuestion = (Image) new ImageService().findById(Long.parseLong(id_objectquestion));
        c.setImageQuestion(imgQuestion);

        c.setImageAnswer((Image) new ImageService().findById(Long.parseLong(id_objectanswer)));

        for (int i = 0; i < imageAlternativas.length; i++) {
            c.getImagesAlternativas().add((Image) new ImageService().findById(Long.parseLong(imageAlternativas[i])));
        }

        s.editChallengePastPresent(c);

        return mv;
    }

    @RequestMapping("pastpresent/delete")
    public String delete(Long id) {
        new ChallengePastPresentService().deleteChallengePastPresent(id);
        return "redirect:/pastpresent";
    }
}
