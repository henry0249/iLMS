//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.10.26 at 07:21:56 下午 CST 
//


package com.hotent.bpmx.core.defxml.entity.ext;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;all>
 *         &lt;element name="extProperties" type="{http://www.jee-soft.cn/bpm}extProperties"/>
 *         &lt;element ref="{http://www.jee-soft.cn/bpm}varDefs" minOccurs="0"/>
 *         &lt;element name="extNodes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="userNode" type="{http://www.jee-soft.cn/bpm}userNode" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="signNode" type="{http://www.jee-soft.cn/bpm}signNode" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="baseNode" type="{http://www.jee-soft.cn/bpm}baseNode" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.jee-soft.cn/bpm}extPlugins" minOccurs="0"/>
 *         &lt;element name="boList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="boDef" type="{http://www.jee-soft.cn/bpm}boDef" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="saveMode" type="{http://www.jee-soft.cn/bpm}boSaveMode" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="globalForm" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="form" type="{http://www.jee-soft.cn/bpm}formExt" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="mobileForm" type="{http://www.jee-soft.cn/bpm}mobileForm" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="instForm" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="form" type="{http://www.jee-soft.cn/bpm}formExt" maxOccurs="unbounded" minOccurs="0"/>
 *                   &lt;element name="mobileForm" type="{http://www.jee-soft.cn/bpm}mobileForm" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "extProcess")
public class ExtProcess {

    @XmlElement(required = true)
    protected ExtProperties extProperties;
    protected VarDefs varDefs;
    protected ExtProcess.ExtNodes extNodes;
    protected ExtPlugins extPlugins;
    protected ExtProcess.BoList boList;
    protected ExtProcess.GlobalForm globalForm;
    protected ExtProcess.InstForm instForm;

    /**
     * Gets the value of the extProperties property.
     * 
     * @return
     *     possible object is
     *     {@link ExtProperties }
     *     
     */
    public ExtProperties getExtProperties() {
        return extProperties;
    }

    /**
     * Sets the value of the extProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtProperties }
     *     
     */
    public void setExtProperties(ExtProperties value) {
        this.extProperties = value;
    }

    /**
     * Gets the value of the varDefs property.
     * 
     * @return
     *     possible object is
     *     {@link VarDefs }
     *     
     */
    public VarDefs getVarDefs() {
        return varDefs;
    }

    /**
     * Sets the value of the varDefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link VarDefs }
     *     
     */
    public void setVarDefs(VarDefs value) {
        this.varDefs = value;
    }

    /**
     * Gets the value of the extNodes property.
     * 
     * @return
     *     possible object is
     *     {@link ExtProcess.ExtNodes }
     *     
     */
    public ExtProcess.ExtNodes getExtNodes() {
        return extNodes;
    }

    /**
     * Sets the value of the extNodes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtProcess.ExtNodes }
     *     
     */
    public void setExtNodes(ExtProcess.ExtNodes value) {
        this.extNodes = value;
    }

    /**
     * 流程扩展插件
     * 
     * @return
     *     possible object is
     *     {@link ExtPlugins }
     *     
     */
    public ExtPlugins getExtPlugins() {
        return extPlugins;
    }

    /**
     * Sets the value of the extPlugins property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtPlugins }
     *     
     */
    public void setExtPlugins(ExtPlugins value) {
        this.extPlugins = value;
    }

    /**
     * Gets the value of the boList property.
     * 
     * @return
     *     possible object is
     *     {@link ExtProcess.BoList }
     *     
     */
    public ExtProcess.BoList getBoList() {
        return boList;
    }

    /**
     * Sets the value of the boList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtProcess.BoList }
     *     
     */
    public void setBoList(ExtProcess.BoList value) {
        this.boList = value;
    }

    /**
     * Gets the value of the globalForm property.
     * 
     * @return
     *     possible object is
     *     {@link ExtProcess.GlobalForm }
     *     
     */
    public ExtProcess.GlobalForm getGlobalForm() {
        return globalForm;
    }

    /**
     * Sets the value of the globalForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtProcess.GlobalForm }
     *     
     */
    public void setGlobalForm(ExtProcess.GlobalForm value) {
        this.globalForm = value;
    }

    /**
     * Gets the value of the instForm property.
     * 
     * @return
     *     possible object is
     *     {@link ExtProcess.InstForm }
     *     
     */
    public ExtProcess.InstForm getInstForm() {
        return instForm;
    }

    /**
     * Sets the value of the instForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtProcess.InstForm }
     *     
     */
    public void setInstForm(ExtProcess.InstForm value) {
        this.instForm = value;
    }


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
     *         &lt;element name="boDef" type="{http://www.jee-soft.cn/bpm}boDef" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *       &lt;attribute name="saveMode" type="{http://www.jee-soft.cn/bpm}boSaveMode" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "boDef"
    })
    public static class BoList {

        @XmlElement(required = true)
        protected List<BoDef> boDef;
        @XmlAttribute
        protected BoSaveMode saveMode;

        /**
         * Gets the value of the boDef property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the boDef property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBoDef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BoDef }
         * 
         * 
         */
        public List<BoDef> getBoDef() {
            if (boDef == null) {
                boDef = new ArrayList<BoDef>();
            }
            return this.boDef;
        }

        /**
         * Gets the value of the saveMode property.
         * 
         * @return
         *     possible object is
         *     {@link BoSaveMode }
         *     
         */
        public BoSaveMode getSaveMode() {
            return saveMode;
        }

        /**
         * Sets the value of the saveMode property.
         * 
         * @param value
         *     allowed object is
         *     {@link BoSaveMode }
         *     
         */
        public void setSaveMode(BoSaveMode value) {
            this.saveMode = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="userNode" type="{http://www.jee-soft.cn/bpm}userNode" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="signNode" type="{http://www.jee-soft.cn/bpm}signNode" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="baseNode" type="{http://www.jee-soft.cn/bpm}baseNode" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "userNodeOrSignNodeOrBaseNode"
    })
    public static class ExtNodes {

        @XmlElements({
            @XmlElement(name = "signNode", type = SignNode.class),
            @XmlElement(name = "userNode", type = UserNode.class),
            @XmlElement(name = "baseNode", type = BaseNode.class)
        })
        protected List<Object> userNodeOrSignNodeOrBaseNode;

        /**
         * Gets the value of the userNodeOrSignNodeOrBaseNode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the userNodeOrSignNodeOrBaseNode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUserNodeOrSignNodeOrBaseNode().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SignNode }
         * {@link UserNode }
         * {@link BaseNode }
         * 
         * 
         */
        public List<Object> getUserNodeOrSignNodeOrBaseNode() {
            if (userNodeOrSignNodeOrBaseNode == null) {
                userNodeOrSignNodeOrBaseNode = new ArrayList<Object>();
            }
            return this.userNodeOrSignNodeOrBaseNode;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="form" type="{http://www.jee-soft.cn/bpm}formExt" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="mobileForm" type="{http://www.jee-soft.cn/bpm}mobileForm" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "formOrMobileForm"
    })
    public static class GlobalForm {

        @XmlElements({
            @XmlElement(name = "mobileForm", type = MobileForm.class),
            @XmlElement(name = "form", type = FormExt.class)
        })
        protected List<Form> formOrMobileForm;

        /**
         * Gets the value of the formOrMobileForm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the formOrMobileForm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFormOrMobileForm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MobileForm }
         * {@link FormExt }
         * 
         * 
         */
        public List<Form> getFormOrMobileForm() {
            if (formOrMobileForm == null) {
                formOrMobileForm = new ArrayList<Form>();
            }
            return this.formOrMobileForm;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="form" type="{http://www.jee-soft.cn/bpm}formExt" maxOccurs="unbounded" minOccurs="0"/>
     *         &lt;element name="mobileForm" type="{http://www.jee-soft.cn/bpm}mobileForm" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "formOrMobileForm"
    })
    public static class InstForm {

        @XmlElements({
            @XmlElement(name = "form", type = FormExt.class),
            @XmlElement(name = "mobileForm", type = MobileForm.class)
        })
        protected List<Form> formOrMobileForm;

        /**
         * Gets the value of the formOrMobileForm property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the formOrMobileForm property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFormOrMobileForm().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FormExt }
         * {@link MobileForm }
         * 
         * 
         */
        public List<Form> getFormOrMobileForm() {
            if (formOrMobileForm == null) {
                formOrMobileForm = new ArrayList<Form>();
            }
            return this.formOrMobileForm;
        }

    }

}
