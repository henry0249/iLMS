package com.hanthink.gps.pkg.vo;

import java.io.Serializable;

public class PkgPartVo implements Serializable{
	
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -1379824435264297751L;
	/**逻辑主键**/
	private String id;
	/**工厂代码**/
	private String factoryCode;
	/**车型**/
	private String carType;
	/**工程**/
    private String project;
    /**零件号**/
    private String partNo;
    /**零件名称**/
    private String partNameCn;
    /**零件担当**/
    private String partRespUser;
    /**供应商代码**/
    private String supplierNo;
    /**供应商名称**/
    private String supplierName;
    /**留用新设**/
    private String status;
    /**联系电话**/
    private String telNo;
    /**c创建人**/
    private String createUser;
    /**最后修改人**/
    private String lastModifiedUser;
    
    private String value;
    private String label;
    
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getLastModifiedUser() {
		return lastModifiedUser;
	}
	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFactoryCode() {
		return factoryCode;
	}
	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPartRespUser() {
		return partRespUser;
	}
	public void setPartRespUser(String partRespUser) {
		this.partRespUser = partRespUser;
	}
	public String getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getPartNameCn() {
		return partNameCn;
	}
	public void setPartNameCn(String partNameCn) {
		this.partNameCn = partNameCn;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
