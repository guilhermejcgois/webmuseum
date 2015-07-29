/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.webmuseum.view;

import com.lpsmuseum.dto.Scenario;
import com.lpsmuseum.dto.scenario.Challenge;
import com.lpsmuseum.dto.scenario.ChallengeNormal;
import com.lpsmuseum.dto.scenario.ChallengePresent;
import com.lpsmuseum.dto.scenario.ScenarioChallenge;
import com.lpsmuseum.service.ScenarioService;
import java.util.ArrayList;

/**
 *
 * @author ljaccao
 */
public class ScenarioView {
    public static ChallengePresent getChallenge(String id,String index)
    {
        Scenario scn=new ScenarioService().findById(new Long(Integer.parseInt(id)));
        if(scn instanceof ScenarioChallenge)
        {
            ScenarioChallenge scc=(ScenarioChallenge)scn;
            int i=Integer.parseInt(index);
            Challenge ch=scc.getChallenges().get(i);
            if(ch instanceof ChallengePresent)
            {
                return (ChallengePresent)ch;
            }
        }
        return null;
    }
    public static String getJSON(String id)
    {
        ArrayList<Scenario> lst=new ScenarioService().listScenarios();
        Long lid=new Long(Integer.parseInt(id));
        for (Scenario scn : lst) {
            if(scn.getId().equals(lid))
            {
                return getJSONScenarioChallenge(scn);
            }
        }
        return "not found";
    }
    // Retorna a String com o JSON do ScenarioChallenge
    public static String getJSONScenarioChallenge(Object obj)
    {
        String out="null";
        if(obj instanceof ScenarioChallenge)
        {
            out="{challenges:[";
            ScenarioChallenge sc=(ScenarioChallenge)obj;
            for (Challenge ch : sc.getChallenges())
            {
                if(ch instanceof ChallengePresent)
                {
                    ChallengePresent cp=(ChallengePresent)ch;
                    if(!out.endsWith("[")){out+=",";}
                    out+="{question:'"+cp.getQuestion()+"'";
                    out+=",answer:'"+cp.getAnswer()+"'";
                    out+=",alternatives:[";
                    for(String st:cp.getAlternatives())
                    {
                        if(!out.endsWith("[")){out+=",";}
                        out+="'"+st+"'";
                    }
                    out+="]}";
                }
            }
            out+="]}";
        }
        return(out);
    }
}
