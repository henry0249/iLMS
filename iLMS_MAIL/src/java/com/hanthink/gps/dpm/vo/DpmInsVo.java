package com.hanthink.gps.dpm.vo;

import java.io.Serializable;


public class DpmInsVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8343157931662659881L;
	
	/**不良品状态 0：未提交**/
	public static final String INS_STATUS_UNSUBMIT = "0";
	/**打印状态 1：已打印**/
	public static final String PRINT_STATUS = "1";
	/**审核通过**/
	public static final String CHECK_STATUS_PASS = "2";
	
	/**订单行号**/
	public static final String ROW_NO_STRING = "10";
	
	/**例外订单处理标识,**/
	public static final String FALG	= "1";
	
	/**写入接口表订单类型 02：例外订单**/
	public static final String ORDER_TYPE = "02";
	/**是否是审核人 1:是**/
	public static final String IS_CHECKER = "1";
	
	/**不良品类型 1：材料不良**/
	public static final String DPM_TYPE_CB = "1";
	/**不良品类型 2：加工不良**/
	public static final String DPM_TYPE_JB = "2";
	/**与erp接口移动类型 161：材料不良**/
	public static final String TRAN_TYPE_CB = "161";
	/**与erp接口移动类型 551：加工不良**/
	public static final String TRAN_TYPE_JB = "551";

	
	private String rowNo ;
	
	private String flag;
	
	private String orderType;
	/**id**/
	private String id;
	
	private String insStatusUnsbmit;
	
	/**是否是审核人**/
	private String isChecker;
	/**审核意见**/
	private String checkRemark;
	
	/**申请单号**/
	private String applyNo; 
	
	/**工厂代码**/
	private String factoryCode;
	
	/**不良品类型**/
	private String dpmType; 
	
	/**不良品类型明细界面显示名称**/
	private String dpmTypeName;

	/**车型**/
	private String modelCode; 
	
	/**申请科室**/
	private String applyDep;
	
	/****/
	
	/**填单日**/
	private String insDate;
	
	/**填单日（开始）（默认为当前日期）**/
	private String insDateStart; 
	
	/**填单日（结束）**/
	private String insDateEnd;
	
	/**零件编号**/
	private String partNo; 
	
	/**零件简号**/
	private String partShortNo;
	
	/**零件中文名称**/
	private String partNameCn;
	
	/**供应商代码**/
	private String supplierNo; 
	
	/**供应商名称**/
	private String supplierName;
	
	/**供应商联系方式**/
	private String telNo;
	
	/**供应商担当**/
	private String contact;
	
	/**发现区域**/
	private String discoArea; 
	
	/**不良品项目代码**/
	private String dpmCode; 
	
	/**不良描述**/
	private String dpmDesc;
	
	/**不良品数量**/
	private String dpmNum; 
	
	/**责任部门编号**/
	private String respDep; 
	
	/**处理结果**/
	private String dealResult;
	
	/**处理结果明细界面显示名称**/
	private String dealResultName;
	
	/**单据状态（0：未提交
	1：已提交
	2：审核通过
	3：驳回"）**/
	private String insStatus;
	
	/**单据状态明细界面显示名称**/
	private String insStatusName;
	
	/**打印状态（0：未打印
	1：已打印）**/
	private String printStatus; 
	
	/**打印人**/
	private String printUser;
	
	/**订单生成状态（0：未生成
	1：已生成）**/
	private String orderStatus; 
	
	/**计算订单号**/
	private String calOrderNo; 
	
	/**配送单号**/
	private String deliveryOrderNo; 
	
	/**是否紧急**/
	private String isUrgent;
	
	/**手工例外生成状态（0：未生成
	1：已生成）**/
	private String excepStatus;
	
	/**手工例外订单号**/
	private String excepOrderNo;
	
	/**发送ERP状态（0：未发送
	1：已发送）**/
	private String sendStatus; 
	
	/**审核日期**/
	private String checkDate;
	
	/**审核人**/
	private String checkUser;
	
	/**备注**/
	private String remark;
	
	/**仓库**/
	private String orderDepot;
	
	/**出货地**/
	private String supFactory;
	
	/**到货时间**/
	private String arriveDate;
	
	/**创建人**/
	private String creationUser;
	
	/**最后修改人**/
	private String lastModifiedUser;
	
	/**弹窗key**/
	private String value;
	
	/**弹窗value**/
	private String label;
	/**用户账号**/
	private String account;
	/**确认时间**/
	private String confirmDate;
	/**确认人员**/
	private String cnfirmUser;
	/**确认人员所属部门**/
	private String name;
	/**责任反馈记录确认人员信息**/
	private String feedbackRemark;
	private String dpmTypeCb;
	
	private String dpmTypeJb;
	
	private String dealResultFp;
	
	private String dealResultBf;

	private String dpmName;
	
	/**申请人**/
	private String applyUser;
	
	/**统计需要审核的条数**/
	private String count;
	
	private String mail;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDpmTypeCb() {
		return dpmTypeCb;
	}

	public void setDpmTypeCb(String dpmTypeCb) {
		this.dpmTypeCb = dpmTypeCb;
	}

	public String getDpmTypeJb() {
		return dpmTypeJb;
	}

	public void setDpmTypeJb(String dpmTypeJb) {
		this.dpmTypeJb = dpmTypeJb;
	}

	public String getDealResultFp() {
		return dealResultFp;
	}

	public void setDealResultFp(String dealResultFp) {
		this.dealResultFp = dealResultFp;
	}
	

	public String getDealResultBf() {
		return dealResultBf;
	}

	public void setDealResultBf(String dealResultBf) {
		this.dealResultBf = dealResultBf;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}

	public String getDpmType() {
		return dpmType;
	}

	public void setDpmType(String dpmType) {
		this.dpmType = dpmType;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getApplyDep() {
		return applyDep;
	}

	public void setApplyDep(String applyDep) {
		this.applyDep = applyDep;
	}

	public String getInsDate() {
		return insDate;
	}

	public void setInsDate(String insDate) {
		this.insDate = insDate;
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

	public String getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(String isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getInsDateStart() {
		return insDateStart;
	}

	public void setInsDateStart(String insDateStart) {
		this.insDateStart = insDateStart;
	}

	public String getInsDateEnd() {
		return insDateEnd;
	}

	public void setInsDateEnd(String insDateEnd) {
		this.insDateEnd = insDateEnd;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartShortNo() {
		return partShortNo;
	}

	public void setPartShortNo(String partShortNo) {
		this.partShortNo = partShortNo;
	}

	public String getPartNameCn() {
		return partNameCn;
	}

	public void setPartNameCn(String partNameCn) {
		this.partNameCn = partNameCn;
	}

	public String getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}

	public String getDiscoArea() {
		return discoArea;
	}

	public void setDiscoArea(String discoArea) {
		this.discoArea = discoArea;
	}

	public String getDpmCode() {
		return dpmCode;
	}

	public void setDpmCode(String dpmCode) {
		this.dpmCode = dpmCode;
	}

	public String getDpmDesc() {
		return dpmDesc;
	}

	public void setDpmDesc(String dpmDesc) {
		this.dpmDesc = dpmDesc;
	}

	public String getDpmNum() {
		return dpmNum;
	}

	public void setDpmNum(String dpmNum) {
		this.dpmNum = dpmNum;
	}

	public String getRespDep() {
		return respDep;
	}

	public void setRespDep(String respDep) {
		this.respDep = respDep;
	}

	public String getDealResult() {
		return dealResult;
	}

	public void setDealResult(String dealResult) {
		this.dealResult = dealResult;
	}

	public String getInsStatus() {
		return insStatus;
	}

	public void setInsStatus(String insStatus) {
		this.insStatus = insStatus;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getCalOrderNo() {
		return calOrderNo;
	}

	public void setCalOrderNo(String calOrderNo) {
		this.calOrderNo = calOrderNo;
	}

	public String getDeliveryOrderNo() {
		return deliveryOrderNo;
	}

	public void setDeliveryOrderNo(String deliveryOrderNo) {
		this.deliveryOrderNo = deliveryOrderNo;
	}

	public String getExcepStatus() {
		return excepStatus;
	}

	public void setExcepStatus(String excepStatus) {
		this.excepStatus = excepStatus;
	}

	public String getExcepOrderNo() {
		return excepOrderNo;
	}

	public void setExcepOrderNo(String excepOrderNo) {
		this.excepOrderNo = excepOrderNo;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDpmTypeName() {
		return dpmTypeName;
	}

	public void setDpmTypeName(String dpmTypeName) {
		this.dpmTypeName = dpmTypeName;
	}

	public String getInsStatusName() {
		return insStatusName;
	}

	public void setInsStatusName(String insStatusName) {
		this.insStatusName = insStatusName;
	}

	public String getDealResultName() {
		return dealResultName;
	}

	public void setDealResultName(String dealResultName) {
		this.dealResultName = dealResultName;
	}

	public String getSupFactory() {
		return supFactory;
	}

	public void setSupFactory(String supFactory) {
		this.supFactory = supFactory;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getOrderDepot() {
		return orderDepot;
	}

	public void setOrderDepot(String orderDepot) {
		this.orderDepot = orderDepot;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getCnfirmUser() {
		return cnfirmUser;
	}

	public void setCnfirmUser(String cnfirmUser) {
		this.cnfirmUser = cnfirmUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFeedbackRemark() {
		return feedbackRemark;
	}

	public void setFeedbackRemark(String feedbackRemark) {
		this.feedbackRemark = feedbackRemark;
	}

	public String getPrintUser() {
		return printUser;
	}

	public void setPrintUser(String printUser) {
		this.printUser = printUser;
	}

	public String getRowNo() {
		return rowNo;
	}

	public void setRowNo(String rowNo) {
		this.rowNo = rowNo;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getInsStatusUnsbmit() {
		return insStatusUnsbmit;
	}

	public void setInsStatusUnsbmit(String insStatusUnsbmit) {
		this.insStatusUnsbmit = insStatusUnsbmit;
	}

	public String getIsChecker() {
		return isChecker;
	}

	public void setIsChecker(String isChecker) {
		this.isChecker = isChecker;
	}

	public String getCheckRemark() {
		return checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}

	public String getDpmName() {
		return dpmName;
	}

	public void setDpmName(String dpmName) {
		this.dpmName = dpmName;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	}
