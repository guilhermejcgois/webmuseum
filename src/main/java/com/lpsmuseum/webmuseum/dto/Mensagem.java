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
public class Mensagem {

    private int status;
    private String mensagem;

    public Mensagem(int status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }
    
    public Mensagem() {
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    @XmlElement
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    @XmlElement
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
