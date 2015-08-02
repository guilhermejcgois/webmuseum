package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Museum;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.service.ChallengePastPresentService;
import com.lpsmuseum.service.ChallengeService;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.ScenarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Realtime
 */
@Controller
public class NavigationController {

    private Museum museum;
    private List<Challenge> challenges;
    private List<Challenge> allChallenges;
    private Node noatual;
    private int indexAtual;

    public NavigationController() {
        challenges = new ArrayList<>();
        allChallenges = new ChallengeService().listChallenges();
        allChallenges.addAll(new ChallengePastPresentService().listChallenges());
    }

    @RequestMapping("navigation")
    public ModelAndView chooseMuseum() {
        ModelAndView mv = new ModelAndView("navigation/choose");
        mv.addObject("museums", new MuseumService().listMuseum());
        return mv;
    }

    @RequestMapping("navigation/navigate")
    public ModelAndView navigateMuseum(Long id, String navigationMode) {
        ModelAndView mv = new ModelAndView("navigation/scenario");
        
        museum = new MuseumService().findById(id);
        indexAtual = 0;
        if (null != navigationMode) {
            switch (navigationMode) {
                case "Aleatory":
                    noatual = new AleatoryNavigation().getNavigation(museum.getScenarios());
                case "Guided":
                    noatual = new GuidedNavigation().getNavigation(museum.getScenarios());
            }
        }
        
        mv.addObject("scenario", noatual.getNeighbors().get(indexAtual).getScenario());
        mv.addObject("hasChallenge", hasChallenges());
        mv.addObject("museum", museum.getName());
        mv.addObject("scenario", noatual.getScenario());
        
        return mv;
    }

    @RequestMapping("navigation/next")
    public ModelAndView avancar() {
        ModelAndView mv = new ModelAndView("navigation/scenario");
        
        noatual = noatual.getNeighbor().getNeighbor();
        
        mv.addObject("scenario", noatual.getScenario());
        mv.addObject("hasChallenge", hasChallenges());
        mv.addObject("museum", museum.getName());
        mv.addObject("scenario", noatual.getScenario());
        
        return mv;
    }

    @RequestMapping("navigation/back")
    public ModelAndView voltar() {
        ModelAndView mv = new ModelAndView("navigation/scenario");
        
        noatual = noatual.doBacktrack().doBacktrack();
        
        mv.addObject("scenario", noatual.getScenario());
        mv.addObject("hasChallenge", hasChallenges());
        mv.addObject("museum", museum.getName());
        mv.addObject("scenario", noatual.getScenario());
        
        return mv;
    }

    @RequestMapping("navigation/challenge")
    public ModelAndView desafio() {
        ModelAndView mv = new ModelAndView("navigation/challenge");
        
        mv.addObject("challenge", challenges.get(0));
        mv.addObject("scenarioId", noatual.getScenario().getId());
        return mv;
    }
    
    private boolean hasChallenges() {
        if (!challenges.isEmpty())
            challenges.clear();
        
        for (Challenge challenge : allChallenges)
            if (challenge.getScenario().getId().equals(noatual.getScenario().getId()))
                challenges.add(challenge);
        
        return !challenges.isEmpty();
    }
}
