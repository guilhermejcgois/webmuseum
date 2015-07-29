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

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author 111598
 * @param <T>
 */
public class JAXB<T> {
    
    private Class classe;
    
    public JAXB(Class classe){
        this.classe = classe;
    }

    public String objectToXml(T object) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classe);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        StringWriter stringWriter = new StringWriter();
        marshaller.marshal(object, stringWriter);
        return stringWriter.toString();
    }

    public T xmlToObject(String xml) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(classe);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        T object = (T) jaxbUnmarshaller.unmarshal(new StringReader(xml));
        return object;
    }
}
