//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 03:52:33 下午 CST 
//


package com.hotent.bpmx.plugin.task.tasknotify.entity;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hotent.bpmx.plugin.task.tasknotify.entity package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hotent.bpmx.plugin.task.tasknotify.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskNotify }
     * 
     */
    public TaskNotify createTaskNotify() {
        return new TaskNotify();
    }

    /**
     * Create an instance of {@link UserRule }
     * 
     */
    public UserRule createUserRule() {
        return new UserRule();
    }

    /**
     * Create an instance of {@link AbstractLogic }
     * 
     */
    public AbstractLogic createAbstractLogic() {
        return new AbstractLogic();
    }

    /**
     * Create an instance of {@link OnCreate }
     * 
     */
    public OnCreate createOnCreate() {
        return new OnCreate();
    }

    /**
     * Create an instance of {@link Notify }
     * 
     */
    public Notify createNotify() {
        return new Notify();
    }

    /**
     * Create an instance of {@link OnComplete }
     * 
     */
    public OnComplete createOnComplete() {
        return new OnComplete();
    }

}
