//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 03:52:27 下午 CST 
//


package com.hotent.bpmx.plugin.execution.procnotify.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for abstractLogic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="abstractLogic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="logicCal" use="required" type="{http://www.jee-soft.cn/bpm/plugins/userCalc/base}logicCalType" />
 *       &lt;attribute name="extract" use="required" type="{http://www.jee-soft.cn/bpm/plugins/userCalc/base}extractType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractLogic", namespace = "http://www.jee-soft.cn/bpm/plugins/userCalc/base")
public class AbstractLogic {

    @XmlAttribute(required = true)
    protected LogicCalType logicCal;
    @XmlAttribute(required = true)
    protected ExtractType extract;

    /**
     * Gets the value of the logicCal property.
     * 
     * @return
     *     possible object is
     *     {@link LogicCalType }
     *     
     */
    public LogicCalType getLogicCal() {
        return logicCal;
    }

    /**
     * Sets the value of the logicCal property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogicCalType }
     *     
     */
    public void setLogicCal(LogicCalType value) {
        this.logicCal = value;
    }

    /**
     * Gets the value of the extract property.
     * 
     * @return
     *     possible object is
     *     {@link ExtractType }
     *     
     */
    public ExtractType getExtract() {
        return extract;
    }

    /**
     * Sets the value of the extract property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtractType }
     *     
     */
    public void setExtract(ExtractType value) {
        this.extract = value;
    }

}
