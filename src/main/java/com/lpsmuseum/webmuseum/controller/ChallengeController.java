/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.service.ChallengeService;
import com.lpsmuseum.service.ScenarioService;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Realtime
 */
@Controller
public class ChallengeController {

    private ChallengeService service;

    public ChallengeController() {
        service = new ChallengeService();
    }

    @RequestMapping("challenge")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("challenge/list");
        ArrayList<Challenge> c = service.listChallenges();
        mv.addObject("list", c);
        return mv;
    }

    @RequestMapping("challenge/create")
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("challenge/form");

        ArrayList<Scenario> scenarios = new ScenarioService().listScenarios();
        mv.addObject("scenarios", scenarios);
        return mv;
    }

    @RequestMapping("challenge/add")
    public String addChallenge(String description, String answer, Long scenarioId) {

        Challenge chal = new Challenge();
        chal.setDescription(description);
        chal.setAnswer(answer);
        chal.setScenario(new ScenarioService().findById(scenarioId));
        
        try {
            service.createChallenge(chal);
        } catch (Exception ex) {
            Logger.getLogger(ChallengeController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/challenge";
    }

    @RequestMapping("challenge/edit")
    public ModelAndView edit(Long id) throws Exception {
        ModelAndView mv = new ModelAndView("challenge/edit");
        mv.addObject("challenge", service.findById(id));
        ArrayList<Scenario> scenarios = new ScenarioService().listScenarios();
        mv.addObject("scenarios", scenarios);

        return mv;
    }

    @RequestMapping("challenge/delete")
    public String delete(Long id) {
        service.deleteChallenge(id);
        return "forward:/challenge";
    }

    @RequestMapping("challenge/save")
    public String editChallenge(Long challengeId, String descricao, String resposta, Long scenarioId) {

        try {
            Challenge chal = service.findById(challengeId);
            chal.setDescription(descricao);
            chal.setAnswer(resposta);
            chal.setScenario(new ScenarioService().findById(scenarioId));
        
            service.editChallenge(chal);
        } catch (Exception ex) {
            Logger.getLogger(ScenarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "redirect:/challenge";
    }
}
