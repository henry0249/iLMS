//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.26 at 07:21:56 下午 CST 
//


package com.hotent.bpmx.core.defxml.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tAssignment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tAssignment">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/BPMN/20100524/MODEL}tBaseElement">
 *       &lt;sequence>
 *         &lt;element name="from" type="{http://www.omg.org/spec/BPMN/20100524/MODEL}tExpression"/>
 *         &lt;element name="to" type="{http://www.omg.org/spec/BPMN/20100524/MODEL}tExpression"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tAssignment", propOrder = {
    "from",
    "to"
})
public class Assignment
    extends BaseElement
{

    @XmlElement(required = true)
    protected Expression from;
    @XmlElement(required = true)
    protected Expression to;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setFrom(Expression value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setTo(Expression value) {
        this.to = value;
    }

}
