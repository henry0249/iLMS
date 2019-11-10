package com.hanthink.sw.model;

import com.hotent.base.api.model.ResultMessage;
import com.hotent.base.core.model.AbstractModel;

/**  
* <p>Title: SwDemandForecastModel.java</p>  
* <p>Description: 预测数据查询model</p>  
* <p>Company: hanthink</p>  
* @author luoxq  
* @date 2018年10月16日 下午4:48:02 
*/ 
public class SwDemandForecastModel extends AbstractModel<String>{
	
	private static final long serialVersionUID = -128138912445826459L;
	/**id**/
	private String id;
	/**工厂**/
	private String factoryCode;
	/**预测类型**/
	private String foreType;
	/**版本**/
	private String version;
	/**发布状态**/
	private String releaseStatus;
	/**反馈状态**/
	private String feedbackStatus;
	/**反馈时间**/
	private String feedbackTime;
	/**反馈内容**/
	private String feedbackRemark;
	/**需求发货日期**/
	private String planDelivery;
	/**到货日期**/
	private String arriveTime;
	/**需求到货日期(查询条件开始)**/
	private String arriveStarTime;
	/**需求到货日期(查询条件结束)**/
	private String arriveEndTime;
	/**开始日期**/
	private String  startDate;
	/**结束日期**/
	private String endDate;
	/**生产阶段**/
	private String phase;
	/**公司**/
	private String company;
	/**卸货口**/
	private String unloadPort;
	/**零件号**/
	private String partNo;
	/**简号**/
	private String partShortNo;
	/**零件名称**/
	private String partName;
	/**零件单位**/
	private String partUnit;
	/**需求数量**/
	private String orderQty;
	/**供应商代码**/
	private String supplierNo;
	/**供应商名称**/
	private String supplierName;
	/**出货地址**/
	private String supFactoryAddr;
	/**出货地代码**/
	private String supFactory;
	/**车型**/
	private String modelCode;
	/**订单物流模式**/
	private String logisticsMode;
	/**下载状态**/
	private String downloadStatus;
	/**下载日期**/
	private String downloadTime;
	/**创建人**/
	private String creationUser;
	/**最后修改人**/
	private String lastModifiedUser;
	/**创建时间**/
	private String creationTime;
	/**零件名称**/
	private String partNameCn;
	/**N+1月份**/
	private String month;
	/**N+1 TTL**/
	private String firstMonthTTL;
	/**N+2 TTL**/
	private String secondMonthTTL;
	/**N+3 TTL**/
	private String thirdMonthTTL;
	/**N+1_01**/
	private String firstDayTotal;
	/**N+1_02**/
	private String secondDayTotal;
	/**N+1_03**/
	private String thirdDayTotal;
	/**N+4_04**/
	private String fourthDayTotal;
	/**N+3_29**/
	private String thirdMonthDayOneTotal;
	/**N+3_30**/
	private String thirdMonthDayTwoTotal;
	/**N+3_31**/
	private String thirdMonthDayThreeTotal;
	
	/**N+1月**/
	private String monthOne;
	/**N+2月**/
	private String monthTwo;
	/**N+3月**/
	private String monthThree;
	

	
	/**用户类型(0：广新用户  1：供应商用户**/
	private String userType;
	
	/**用户账号**/
	private String account;
	/**用户ID**/
	private String userId;
	
	
	/**返回的信息**/
	private ResultMessage message;
	
	private String value;
	private String label;
	
	/**发布月份**/
	private String publishMonth;
	
	/**对象月份**/
	private String objMonth;
	
	/**周度预测字段**************************************************************/
	/**发布周**/
	private String publishWeek;
	/**对象周**/
	private String objWeek;
	/**W周**/
	private String week;
	/**W+1**/
	private String weekOne;
	/**W+2**/
	private String weekTwo;
	/**W+3**/
	private String weekThree;
	/**w+4**/
	private String weekFour;
	/**提前取货时间**/
	private String advanceTime;
	
	
	/**********************************************/
	/**最小日期**/
	private String minDate;
	/**最大日期**/
	private String maxDate;
	/**父级件**/
	private String pSupplier;

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
	public ResultMessage getMessage() {
		return message;
	}
	public void setMessage(ResultMessage message) {
		this.message = message;
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
	public String getForeType() {
		return foreType;
	}
	public void setForeType(String foreType) {
		this.foreType = foreType;
	}
	public String getPlanDelivery() {
		return planDelivery;
	}
	public void setPlanDelivery(String planDelivery) {
		this.planDelivery = planDelivery;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPhase() {
		return phase;
	}
	public void setPahse(String phase) {
		this.phase = phase;
	}
	public String getUnloadPort() {
		return unloadPort;
	}
	public void setUnloadPort(String unloadPort) {
		this.unloadPort = unloadPort;
	}
	public String getPartNo() {
		return partNo;
	}
	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}
	public String getPartUnit() {
		return partUnit;
	}
	public void setPartUnit(String partUnit) {
		this.partUnit = partUnit;
	}
	public String getOrderQty() {
		return orderQty;
	}
	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}
	public String getSupplierNo() {
		return supplierNo;
	}
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupFactoryAddr() {
		return supFactoryAddr;
	}
	public void setSupFactoryAddr(String supFactoryAddr) {
		this.supFactoryAddr = supFactoryAddr;
	}
	public String getSupFactory() {
		return supFactory;
	}
	public void setSupFactory(String supFactory) {
		this.supFactory = supFactory;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public String getDownloadStatus() {
		return downloadStatus;
	}
	public void setDownloadStatus(String downloadStatus) {
		this.downloadStatus = downloadStatus;
	}
	public String getDownloadTime() {
		return downloadTime;
	}
	public void setDownloadTime(String downloadTime) {
		this.downloadTime = downloadTime;
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
	public String getReleaseStatus() {
		return releaseStatus;
	}
	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	public String getFeedbackStatus() {
		return feedbackStatus;
	}
	public void setFeedbackStatus(String feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	public String getArriveStarTime() {
		return arriveStarTime;
	}
	public void setArriveStarTime(String arriveStarTime) {
		this.arriveStarTime = arriveStarTime;
	}

	public String getArriveEndTime() {
		return arriveEndTime;
	}
	public void setArriveEndTime(String arriveEndTime) {
		this.arriveEndTime = arriveEndTime;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getLogisticsMode() {
		return logisticsMode;
	}
	public void setLogisticsMode(String logisticsMode) {
		this.logisticsMode = logisticsMode;
	}
	public String getPartShortNo() {
		return partShortNo;
	}
	public void setPartShortNo(String partShortNo) {
		this.partShortNo = partShortNo;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getFeedbackRemark() {
		return feedbackRemark;
	}
	public void setFeedbackRemark(String feedbackRemark) {
		this.feedbackRemark = feedbackRemark;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getPartNameCn() {
		return partNameCn;
	}
	public void setPartNameCn(String partNameCn) {
		this.partNameCn = partNameCn;
	}
	public String getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getFirstMonthTTL() {
		return firstMonthTTL;
	}
	public void setFirstMonthTTL(String firstMonthTTL) {
		this.firstMonthTTL = firstMonthTTL;
	}
	public String getSecondMonthTTL() {
		return secondMonthTTL;
	}
	public void setSecondMonthTTL(String secondMonthTTL) {
		this.secondMonthTTL = secondMonthTTL;
	}
	public String getThirdMonthTTL() {
		return thirdMonthTTL;
	}
	public void setThirdMonthTTL(String thirdMonthTTL) {
		this.thirdMonthTTL = thirdMonthTTL;
	}
	public String getFirstDayTotal() {
		return firstDayTotal;
	}
	public void setFirstDayTotal(String firstDayTotal) {
		this.firstDayTotal = firstDayTotal;
	}
	public String getSecondDayTotal() {
		return secondDayTotal;
	}
	public void setSecondDayTotal(String secondDayTotal) {
		this.secondDayTotal = secondDayTotal;
	}
	public String getThirdDayTotal() {
		return thirdDayTotal;
	}
	public void setThirdDayTotal(String thirdDayTotal) {
		this.thirdDayTotal = thirdDayTotal;
	}
	public String getFourthDayTotal() {
		return fourthDayTotal;
	}
	public void setFourthDayTotal(String fourthDayTotal) {
		this.fourthDayTotal = fourthDayTotal;
	}
	public String getThirdMonthDayOneTotal() {
		return thirdMonthDayOneTotal;
	}
	public void setThirdMonthDayOneTotal(String thirdMonthDayOneTotal) {
		this.thirdMonthDayOneTotal = thirdMonthDayOneTotal;
	}
	public String getThirdMonthDayTwoTotal() {
		return thirdMonthDayTwoTotal;
	}
	public void setThirdMonthDayTwoTotal(String thirdMonthDayTwoTotal) {
		this.thirdMonthDayTwoTotal = thirdMonthDayTwoTotal;
	}
	public String getThirdMonthDayThreeTotal() {
		return thirdMonthDayThreeTotal;
	}
	public void setThirdMonthDayThreeTotal(String thirdMonthDayThreeTotal) {
		this.thirdMonthDayThreeTotal = thirdMonthDayThreeTotal;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getMonthOne() {
		return monthOne;
	}
	public void setMonthOne(String monthOne) {
		this.monthOne = monthOne;
	}
	public String getMonthTwo() {
		return monthTwo;
	}
	public void setMonthTwo(String monthTwo) {
		this.monthTwo = monthTwo;
	}
	public String getMonthThree() {
		return monthThree;
	}
	public void setMonthThree(String monthThree) {
		this.monthThree = monthThree;
	}
	public String getPublishMonth() {
		return publishMonth;
	}
	public void setPublishMonth(String publishMonth) {
		this.publishMonth = publishMonth;
	}
	public String getObjMonth() {
		return objMonth;
	}
	public void setObjMonth(String objMonth) {
		this.objMonth = objMonth;
	}
	public String getWeekOne() {
		return weekOne;
	}
	public void setWeekOne(String weekOne) {
		this.weekOne = weekOne;
	}
	public String getWeekTwo() {
		return weekTwo;
	}
	public void setWeekTwo(String weekTwo) {
		this.weekTwo = weekTwo;
	}
	public String getWeekThree() {
		return weekThree;
	}
	public void setWeekThree(String weekThree) {
		this.weekThree = weekThree;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	public String getWeekFour() {
		return weekFour;
	}
	public void setWeekFour(String weekFour) {
		this.weekFour = weekFour;
	}
	public String getPublishWeek() {
		return publishWeek;
	}
	public void setPublishWeek(String publishWeek) {
		this.publishWeek = publishWeek;
	}
	public String getObjWeek() {
		return objWeek;
	}
	public void setObjWeek(String objWeek) {
		this.objWeek = objWeek;
	}
	public String getAdvanceTime() {
		return advanceTime;
	}
	public void setAdvanceTime(String advanceTime) {
		this.advanceTime = advanceTime;
	}
	public String getMinDate() {
		return minDate;
	}
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}
	public String getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getpSupplier() {
		return pSupplier;
	}
	public void setpSupplier(String pSupplier) {
		this.pSupplier = pSupplier;
	}

	
	
}
