//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.09.18 at 01:47:04 下午 CST 
//


package com.hotent.bpmx.plugin.core.task.entity;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hotent.bpmx.plugin.core.task.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hotent.bpmx.plugin.core.task.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskAction }
     * 
     */
    public TaskAction createTaskAction() {
        return new TaskAction();
    }

    /**
     * Create an instance of {@link TaskActions }
     * 
     */
    public TaskActions createTaskActions() {
        return new TaskActions();
    }

}
