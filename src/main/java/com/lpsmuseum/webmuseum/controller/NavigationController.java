package com.lpsmuseum.webmuseum.controller;

import com.lpsmuseum.behaviour.museum.navigation.AleatoryNavigation;
import com.lpsmuseum.behaviour.museum.navigation.GuidedNavigation;
import com.lpsmuseum.behaviour.museum.navigation.Node;
import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.service.ChallengePastPresentService;
import com.lpsmuseum.service.ChallengeService;
import com.lpsmuseum.service.MuseumService;
import com.lpsmuseum.service.ScenarioService;
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

    private static Node noatual;
    private static int indexAtual;

    @RequestMapping("navigation")
    public ModelAndView chooseMuseum() {
        ModelAndView mv = new ModelAndView("navigation/choose");
        mv.addObject("museums", new MuseumService().listMuseum());
        return mv;
    }

    @RequestMapping("navigation/navigate")
    public ModelAndView navigateMuseum(Long id, String navigationMode) {
        ModelAndView mv = null;
        if (null != navigationMode) {
            switch (navigationMode) {
                case "Aleatory":
                    mv = new ModelAndView("navigation/aleatory");
                    break;
                case "Guided":
                    mv = new ModelAndView("navigation/guided");
                    break;
            }
        }
        if (mv != null)
            mv.addObject("museum", new MuseumService().findById(id));
        return mv;
    }

    @RequestMapping("navigation/aleatory")
    public ModelAndView aleatorio() {
        indexAtual = 0;
        noatual = new AleatoryNavigation().getNavigation(new ScenarioService().listScenarios());
        ModelAndView mv = new ModelAndView("navigation/aleatory");
        Scenario scenario = noatual.getNeighbors().get(indexAtual).getScenario();
        mv.addObject("scenario", scenario);
        List<Challenge> challenges = new ChallengeService().listChallenges();
        challenges.addAll(new ChallengePastPresentService().listChallenges());
        boolean hasChallenge = false;
        for (Challenge challenge : challenges) {
            if (challenge.getScenario().getId().equals(scenario.getId())) {
                hasChallenge = true;
                break;
            }
        }
        mv.addObject("hasChallenge", hasChallenge);
        mv.addObject("museum", new MuseumService().listMuseum().get(0));
        return mv;
    }

    @RequestMapping("navigation/guided")
    public ModelAndView guiado() {
        indexAtual = 0;
        noatual = new GuidedNavigation().getNavigation(new ScenarioService().listScenarios());
        ModelAndView mv = new ModelAndView("navigation/guided");
        Scenario scenario = noatual.getNeighbors().get(indexAtual).getScenario();
        mv.addObject("scenario", scenario);
        List<Challenge> challenges = new ChallengeService().listChallenges();
        challenges.addAll(new ChallengePastPresentService().listChallenges());
        boolean hasChallenge = false;
        for (Challenge challenge : challenges) {
            if (challenge.getScenario().getId().equals(scenario.getId())) {
                hasChallenge = true;
                break;
            }
        }
        mv.addObject("hasChallenge", hasChallenge);
        mv.addObject("museum", new MuseumService().listMuseum().get(0));
        return mv;
    }

    @RequestMapping("navigation/next")
    public ModelAndView avancar() {
        ModelAndView mv = new ModelAndView("navigation/scenario");
        indexAtual++;
        if (indexAtual >= noatual.getNeighbors().size()) {
            indexAtual = 0;
        }
        Scenario scenario = noatual.getNeighbors().get(indexAtual).getScenario();
        mv.addObject("scenario", scenario);
        List<Challenge> challenges = new ChallengeService().listChallenges();
        boolean hasChallenge = false;
        for (Challenge challenge : challenges) {
            if (challenge.getScenario().equals(scenario.getId())) {
                hasChallenge = true;
                break;
            }
        }
        mv.addObject("hasChallenge", hasChallenge);
        return mv;
    }

    @RequestMapping("navigation/back")
    public ModelAndView voltar() {
        ModelAndView mv = new ModelAndView("navigation/scenario");
        indexAtual--;
        if (indexAtual < 0) {
            indexAtual = noatual.getNeighbors().size() - 1;
        }
        Scenario scenario = noatual.getNeighbors().get(indexAtual).getScenario();
        mv.addObject("scenario", scenario);
        List<Challenge> challenges = new ChallengeService().listChallenges();
        boolean hasChallenge = false;
        for (Challenge challenge : challenges) {
            if (challenge.getScenario().equals(scenario.getId())) {
                hasChallenge = true;
                break;
            }
        }
        mv.addObject("hasChallenge", hasChallenge);
        return mv;
    }

    @RequestMapping("navigation/challenge")
    public ModelAndView desafio(Long scenarioId) {
        ModelAndView mv = new ModelAndView("navigation/challenge");
        List<Challenge> challenges = new ChallengeService().listChallenges();
        for (Challenge challenge : challenges) {
            if (challenge.getScenario().equals(scenarioId)) {
                mv.addObject("challenge", challenge);
                break;
            }
        }
        mv.addObject("scenarioId", scenarioId);
        return mv;
    }
}
