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
public class MessageStatus {
    private final long status;
    private final String message;

    public MessageStatus(long status, String message) {
        this.status = status;
        this.message = message;
    }

    public long getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
    
}
