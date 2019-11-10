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
import javax.xml.bind.annotation.XmlType;


/**
 * 会签节点配置，继承自userNode
 * 
 * <p>Java class for signNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;group ref="{http://www.jee-soft.cn/bpm}signNodeElements"/>
 *       &lt;attGroup ref="{http://www.jee-soft.cn/bpm}baseNodeAttr"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signNode", propOrder = {
    "varDefs",
    "extPlugins",
    "form",
    "mobileForm",
    "subProcessForm",
    "transformRules",
    "buttons",
    "signSetting",
    "scripts",
    "propers",
    "subTableRights",
    "formInitSetting"
})
public class SignNode {

    protected VarDefs varDefs;
    protected ExtPlugins extPlugins;
    protected Form form;
    protected MobileForm mobileForm;
    protected SubProcessForm subProcessForm;
    protected TransformRules transformRules;
    protected Buttons buttons;
    @XmlElement(required = true)
    protected SignNode.SignSetting signSetting;
    protected Scripts scripts;
    protected Propers propers;
    protected SubTableRights subTableRights;
    protected FormInitSetting formInitSetting;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute(required = true)
    protected NodeType nodeType;
    @XmlAttribute(required = true)
    protected String bpmnElement;
    @XmlAttribute
    protected String description;

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
     * 流程节点扩展插件
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
     * Gets the value of the form property.
     * 
     * @return
     *     possible object is
     *     {@link Form }
     *     
     */
    public Form getForm() {
        return form;
    }

    /**
     * Sets the value of the form property.
     * 
     * @param value
     *     allowed object is
     *     {@link Form }
     *     
     */
    public void setForm(Form value) {
        this.form = value;
    }

    /**
     * Gets the value of the mobileForm property.
     * 
     * @return
     *     possible object is
     *     {@link MobileForm }
     *     
     */
    public MobileForm getMobileForm() {
        return mobileForm;
    }

    /**
     * Sets the value of the mobileForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link MobileForm }
     *     
     */
    public void setMobileForm(MobileForm value) {
        this.mobileForm = value;
    }

    /**
     * Gets the value of the subProcessForm property.
     * 
     * @return
     *     possible object is
     *     {@link SubProcessForm }
     *     
     */
    public SubProcessForm getSubProcessForm() {
        return subProcessForm;
    }

    /**
     * Sets the value of the subProcessForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubProcessForm }
     *     
     */
    public void setSubProcessForm(SubProcessForm value) {
        this.subProcessForm = value;
    }

    /**
     * Gets the value of the transformRules property.
     * 
     * @return
     *     possible object is
     *     {@link TransformRules }
     *     
     */
    public TransformRules getTransformRules() {
        return transformRules;
    }

    /**
     * Sets the value of the transformRules property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransformRules }
     *     
     */
    public void setTransformRules(TransformRules value) {
        this.transformRules = value;
    }

    /**
     * Gets the value of the buttons property.
     * 
     * @return
     *     possible object is
     *     {@link Buttons }
     *     
     */
    public Buttons getButtons() {
        return buttons;
    }

    /**
     * Sets the value of the buttons property.
     * 
     * @param value
     *     allowed object is
     *     {@link Buttons }
     *     
     */
    public void setButtons(Buttons value) {
        this.buttons = value;
    }

    /**
     * Gets the value of the signSetting property.
     * 
     * @return
     *     possible object is
     *     {@link SignNode.SignSetting }
     *     
     */
    public SignNode.SignSetting getSignSetting() {
        return signSetting;
    }

    /**
     * Sets the value of the signSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignNode.SignSetting }
     *     
     */
    public void setSignSetting(SignNode.SignSetting value) {
        this.signSetting = value;
    }

    /**
     * Gets the value of the scripts property.
     * 
     * @return
     *     possible object is
     *     {@link Scripts }
     *     
     */
    public Scripts getScripts() {
        return scripts;
    }

    /**
     * Sets the value of the scripts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Scripts }
     *     
     */
    public void setScripts(Scripts value) {
        this.scripts = value;
    }

    /**
     * Gets the value of the propers property.
     * 
     * @return
     *     possible object is
     *     {@link Propers }
     *     
     */
    public Propers getPropers() {
        return propers;
    }

    /**
     * Sets the value of the propers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propers }
     *     
     */
    public void setPropers(Propers value) {
        this.propers = value;
    }

    /**
     * Gets the value of the subTableRights property.
     * 
     * @return
     *     possible object is
     *     {@link SubTableRights }
     *     
     */
    public SubTableRights getSubTableRights() {
        return subTableRights;
    }

    /**
     * Sets the value of the subTableRights property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubTableRights }
     *     
     */
    public void setSubTableRights(SubTableRights value) {
        this.subTableRights = value;
    }

    /**
     * Gets the value of the formInitSetting property.
     * 
     * @return
     *     possible object is
     *     {@link FormInitSetting }
     *     
     */
    public FormInitSetting getFormInitSetting() {
        return formInitSetting;
    }

    /**
     * Sets the value of the formInitSetting property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormInitSetting }
     *     
     */
    public void setFormInitSetting(FormInitSetting value) {
        this.formInitSetting = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the nodeType property.
     * 
     * @return
     *     possible object is
     *     {@link NodeType }
     *     
     */
    public NodeType getNodeType() {
        return nodeType;
    }

    /**
     * Sets the value of the nodeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link NodeType }
     *     
     */
    public void setNodeType(NodeType value) {
        this.nodeType = value;
    }

    /**
     * Gets the value of the bpmnElement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBpmnElement() {
        return bpmnElement;
    }

    /**
     * Sets the value of the bpmnElement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBpmnElement(String value) {
        this.bpmnElement = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     *       &lt;all>
     *         &lt;element name="signRule">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="decideType" use="required" type="{http://www.jee-soft.cn/bpm}decideType" />
     *                 &lt;attribute name="voteType" use="required" type="{http://www.jee-soft.cn/bpm}voteType" />
     *                 &lt;attribute name="voteAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="followMode" use="required" type="{http://www.jee-soft.cn/bpm}followMode" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="privilege" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="members" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *                           &lt;/sequence>
     *                           &lt;attribute name="mode" use="required" type="{http://www.jee-soft.cn/bpm}privilegeMode" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
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
    public static class SignSetting {

        @XmlElement(required = true)
        protected SignNode.SignSetting.SignRule signRule;
        protected SignNode.SignSetting.Privilege privilege;

        /**
         * Gets the value of the signRule property.
         * 
         * @return
         *     possible object is
         *     {@link SignNode.SignSetting.SignRule }
         *     
         */
        public SignNode.SignSetting.SignRule getSignRule() {
            return signRule;
        }

        /**
         * Sets the value of the signRule property.
         * 
         * @param value
         *     allowed object is
         *     {@link SignNode.SignSetting.SignRule }
         *     
         */
        public void setSignRule(SignNode.SignSetting.SignRule value) {
            this.signRule = value;
        }

        /**
         * Gets the value of the privilege property.
         * 
         * @return
         *     possible object is
         *     {@link SignNode.SignSetting.Privilege }
         *     
         */
        public SignNode.SignSetting.Privilege getPrivilege() {
            return privilege;
        }

        /**
         * Sets the value of the privilege property.
         * 
         * @param value
         *     allowed object is
         *     {@link SignNode.SignSetting.Privilege }
         *     
         */
        public void setPrivilege(SignNode.SignSetting.Privilege value) {
            this.privilege = value;
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
         *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="members" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
         *                 &lt;/sequence>
         *                 &lt;attribute name="mode" use="required" type="{http://www.jee-soft.cn/bpm}privilegeMode" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "item"
        })
        public static class Privilege {

            protected List<SignNode.SignSetting.Privilege.Item> item;

            /**
             * Gets the value of the item property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the item property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItem().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link SignNode.SignSetting.Privilege.Item }
             * 
             * 
             */
            public List<SignNode.SignSetting.Privilege.Item> getItem() {
                if (item == null) {
                    item = new ArrayList<SignNode.SignSetting.Privilege.Item>();
                }
                return this.item;
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
             *         &lt;element name="members" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
             *       &lt;/sequence>
             *       &lt;attribute name="mode" use="required" type="{http://www.jee-soft.cn/bpm}privilegeMode" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "members"
            })
            public static class Item {

                @XmlElement(required = true)
                protected Object members;
                @XmlAttribute(required = true)
                protected PrivilegeMode mode;

                /**
                 * Gets the value of the members property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Object }
                 *     
                 */
                public Object getMembers() {
                    return members;
                }

                /**
                 * Sets the value of the members property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Object }
                 *     
                 */
                public void setMembers(Object value) {
                    this.members = value;
                }

                /**
                 * Gets the value of the mode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link PrivilegeMode }
                 *     
                 */
                public PrivilegeMode getMode() {
                    return mode;
                }

                /**
                 * Sets the value of the mode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link PrivilegeMode }
                 *     
                 */
                public void setMode(PrivilegeMode value) {
                    this.mode = value;
                }

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
         *       &lt;attribute name="decideType" use="required" type="{http://www.jee-soft.cn/bpm}decideType" />
         *       &lt;attribute name="voteType" use="required" type="{http://www.jee-soft.cn/bpm}voteType" />
         *       &lt;attribute name="voteAmount" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="followMode" use="required" type="{http://www.jee-soft.cn/bpm}followMode" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class SignRule {

            @XmlAttribute(required = true)
            protected DecideType decideType;
            @XmlAttribute(required = true)
            protected VoteType voteType;
            @XmlAttribute(required = true)
            protected int voteAmount;
            @XmlAttribute(required = true)
            protected FollowMode followMode;

            /**
             * Gets the value of the decideType property.
             * 
             * @return
             *     possible object is
             *     {@link DecideType }
             *     
             */
            public DecideType getDecideType() {
                return decideType;
            }

            /**
             * Sets the value of the decideType property.
             * 
             * @param value
             *     allowed object is
             *     {@link DecideType }
             *     
             */
            public void setDecideType(DecideType value) {
                this.decideType = value;
            }

            /**
             * Gets the value of the voteType property.
             * 
             * @return
             *     possible object is
             *     {@link VoteType }
             *     
             */
            public VoteType getVoteType() {
                return voteType;
            }

            /**
             * Sets the value of the voteType property.
             * 
             * @param value
             *     allowed object is
             *     {@link VoteType }
             *     
             */
            public void setVoteType(VoteType value) {
                this.voteType = value;
            }

            /**
             * Gets the value of the voteAmount property.
             * 
             */
            public int getVoteAmount() {
                return voteAmount;
            }

            /**
             * Sets the value of the voteAmount property.
             * 
             */
            public void setVoteAmount(int value) {
                this.voteAmount = value;
            }

            /**
             * Gets the value of the followMode property.
             * 
             * @return
             *     possible object is
             *     {@link FollowMode }
             *     
             */
            public FollowMode getFollowMode() {
                return followMode;
            }

            /**
             * Sets the value of the followMode property.
             * 
             * @param value
             *     allowed object is
             *     {@link FollowMode }
             *     
             */
            public void setFollowMode(FollowMode value) {
                this.followMode = value;
            }

        }

    }

}
