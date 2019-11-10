//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.06 at 03:52:33 下午 CST 
//


package com.hotent.bpmx.plugin.task.tasknotify.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.jee-soft.cn/bpm/plugins/userCalc/base}userRule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="msgTypes" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="subTypeKey" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userRule"
})
@XmlRootElement(name = "notify", namespace = "http://www.jee-soft.cn/bpm/plugins/task/baseNotify")
public class Notify {

    @XmlElement(namespace = "http://www.jee-soft.cn/bpm/plugins/userCalc/base")
    protected List<UserRule> userRule;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String msgTypes;
    @XmlAttribute
    @XmlSchemaType(name = "anySimpleType")
    protected String subTypeKey;

    /**
     * Gets the value of the userRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserRule }
     * 
     * 
     */
    public List<UserRule> getUserRule() {
        if (userRule == null) {
            userRule = new ArrayList<UserRule>();
        }
        return this.userRule;
    }

    /**
     * Gets the value of the msgTypes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgTypes() {
        return msgTypes;
    }

    /**
     * Sets the value of the msgTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgTypes(String value) {
        this.msgTypes = value;
    }

    /**
     * Gets the value of the subTypeKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTypeKey() {
        return subTypeKey;
    }

    /**
     * Sets the value of the subTypeKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTypeKey(String value) {
        this.subTypeKey = value;
    }

}
