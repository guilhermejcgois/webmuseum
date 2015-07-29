/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lpsmuseum.webmuseum.dto;

/**
 *
 * @author 111690
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 111598
 */
@XmlRootElement
public class Score {

    private String nome;
    private int pontuacao;

    public Score(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    public Score() {
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    @XmlElement
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the pontuacao
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * @param pontuacao the pontuacao to set
     */
    @XmlElement
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
