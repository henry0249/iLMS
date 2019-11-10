package com.hanthink.sw.model;

import com.hotent.base.core.model.AbstractModel;

public class SwDemondOrderDetailModel extends AbstractModel<String>{

	/**  
	 * <p>Description: long</p>  
	 * @author linzhuo  
	 * @date 2019年3月13日
	 * @version 1.0  
	 */  
	private static final long serialVersionUID = -2099774086303773592L;
	private String id;
	private String purchaseNo;//订单号
	private String purchaseRowNo;//订单行号
	private String partNo;//零件号
	private String partName;//零件名称
	private String partShortNo;//简号
	private String standPackage;//包装数
	private String standartPackage;
	private String boxesNum;//箱数
	private String cancelNum;//取消数量
	private String totalRecQty;//收货数量
	private String receiveStatus;//收获状态
	private String totalDelivQty;//累计发货
	private String tempDelivQty;//本次发货
	
	private String supplierNo;//供应商编号
	private String supFactory; //出货地
	private String supplierName; //供应商名
	private String orderNo;//订单号
	private String orderDate;//订购日期
	private String arriveDate;//到货日期
	private String depotNo;//仓库编码
	private String printStatus;//打印状态
	private String downloadStatus;//下载状态
	private String deliveryStatus;//发货状态
	private String orderType;//订单类型
	private String standardPackage;//包装数
	private String receiveDate;//收货日期
	private String preparePerson;//拣货工程
	private String distriPerson;//配送工程
	private String unloadPort;//卸货口
	private String timeStart;
	private String timeEnd;
	private String  printTime;//打印时间
	
	private String requireNum;
	private String prepareProductSeqno;
	private String location;
	private String orderTimeHhmi;
	private String orderTimeYmd;
	private String kbzs;
	private String distriProductSeqno;
	private String arriveTime;
	private String purchaseOrderno;
	private String arriveProductSeqno;
	private String hmsOrder;//dms订单号
	private String  recAddress;//
	private String  recTel;
	private String  orderQty;
	private String   spType;
	private String orderTypeName;
	private String rowId;
	private String pageCount;
	
	private String orderUnit;//单位
	private String zkFlag;//是否直捆
	private String prepareAddress;//拣货地址
	private String labelCount;//订单标签张数
	private String orderQity;
	
	
	private String deliveryNo;//发货单号
	private String updateUser;//更新用户
	
	
	private String lastFive;
	
	private String factoryCode;
	
	private String purchaseNoArr;//订单号数组
	
	private String currentQty;
	private Object QRCode;
	private Object QR_INFOS;
	/**下载状态1：已下载**/
	public static String DOWNLOAD_STATUS_YES = "1";
	
	/**下载状态**/
	private String downloadStatusYes;
	private String planPickUpTimeStr;//取货时间
	private String planPickUpTimeStrStart;//取货时间
	private String planPickUpTimeStrEnd;//取货时间
	
	private String printUser;//打印人
	private String printUserIp;//打印人IP
	
	//****************标签属性*******************************
	/**
	 * uuid
	 */
	protected String uuid;
	
	/**
	 * 拣货地址
	 */
	protected String storage;
	
	/**
	 * 用户ID
	 */
	protected String userId;
	
	/**
	 * 用户类型
	 */
	protected String userType;
	
	/**
	 * 车间
	 */
	protected String workcenter;
	
	/**
	 * 收容数
	 */
	protected String srs;
	
	/**
	 * 订单行号
	 */
	protected String orderRowNo;
	
	/**
	 * 标签行号
     */
	protected String labelRowno; 
	
	
	/**
	 * 信息点
     */
	protected String planCode; 
	
	/**
	 * 信息点描述
	 */
	protected String planCodeDesc;
	
	protected Object logoImg;
	/**
	 * 出货仓库
     */
	protected String shipDepot; 
	
	/**
	 * 到货仓库
     */
	protected String arrDepot; 
	
	/**
	 * 配送包装数
     */
	protected String distriPackage; 
	
	/**
	 * 下线批次产品流水号
     */
	protected String kbProductSeqno; 
	
	/**
	 * 发车批次产品流水号
     */
	protected String dispatchProductSeqno; 
	
	/**
	 * 发货批次产品流水号
     */
	protected String deliveryProductSeqno;  

	/**
	 * 装配批次产品流水号
	 */
	protected String assembleProductSeqno;
	
	/**
	 * 下线时间
     */
	protected String kbTime; 
	
	/**
	 * 备件时间
     */
	protected String prepareTime; 
	
	/**
	 * 发车时间
     */
	protected String dispatchTime; 
	
	/**
	 * 发货时间
     */
	protected String deliveryTime; 
	
	/**
	 * 配送时间
     */
	protected String distriTime; 
	
	/**
	 * 备件批次
     */
	protected String prepareBatchNo; 
	
	/**
	 * 备件批次至
	 */
	protected String prepareBatchNoTo;
	
	/**
	 * 下线批次
     */
	protected String kbBatchNo; 
	
	/**
	 * 创建时间
     */
	protected String creationTime; 
	
	/**
	 * 接口处理标志位0：未处理1：已处理     
	 */
	protected String dealFlag; 
	
	/**
	 * 接口处理时间
     */
	protected String dealTime; 
	
	/**
	 * 装配时间     
	 */
	protected String assembleTime; 
	
	/**
	 * 创建日期至
	 */
	protected String creationTimeTo;
	
	/**
	 * 装车代码
	 */
	protected String unloadCode;

	/**
	 * 看板名称
	 */
	protected String kbName;

	
	/**
	 * 标签张数
	 */
	protected String labelPageNum;
	
	/**水印标识**/
	protected String syFlag;
	
	/**零件名称**/
	protected String partNameCn;
	/**需求人**/
	protected String demander;
	/**部门**/
	protected String demandDepartment;
	/**用途**/
	protected String use;
	/**联系电话**/
	protected String conNumber;
	
	/**最后修改人**/
	protected String lastModifiedUser;
	
	/**
	 * insert by luoxianqin
	 */
	protected String creationUser;
	protected String code;
	
	public String getDownloadStatusYes() {
		return downloadStatusYes;
	}

	public void setDownloadStatusYes(String downloadStatusYes) {
		this.downloadStatusYes = downloadStatusYes;
	}

	public String getPurchaseNoArr() {
		return purchaseNoArr;
	}

	public void setPurchaseNoArr(String purchaseNoArr) {
		this.purchaseNoArr = purchaseNoArr;
	}

	public String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}

	public String getLastFive() {
		return lastFive;
	}

	public void setLastFive(String lastFive) {
		this.lastFive = lastFive;
	}

	public String getDeliveryNo() {
		return deliveryNo;
	}

	public void setDeliveryNo(String deliveryNo) {
		this.deliveryNo = deliveryNo;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getLabelCount() {
		return labelCount;
	}

	public void setLabelCount(String labelCount) {
		this.labelCount = labelCount;
	}

	public String getPrepareAddress() {
		return prepareAddress;
	}

	public void setPrepareAddress(String prepareAddress) {
		this.prepareAddress = prepareAddress;
	}

	public String getZkFlag() {
		return zkFlag;
	}

	public void setZkFlag(String zkFlag) {
		this.zkFlag = zkFlag;
	}

	public String getOrderUnit() {
		return orderUnit;
	}

	public void setOrderUnit(String orderUnit) {
		this.orderUnit = orderUnit;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getOrderTypeName() {
		return orderTypeName;
	}

	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

	public String getRecAddress() {
		return recAddress;
	}

	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}

	public String getRecTel() {
		return recTel;
	}

	public void setRecTel(String recTel) {
		this.recTel = recTel;
	}

	public String getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(String orderQty) {
		this.orderQty = orderQty;
	}

	public String getHmsOrder() {
		return hmsOrder;
	}

	public void setHmsOrder(String dmsOrder) {
		this.hmsOrder = dmsOrder;
	}

	public String getPrintTime() {
		return printTime;
	}

	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}

	public String getRequireNum() {
		return requireNum;
	}

	public void setRequireNum(String requireNum) {
		this.requireNum = requireNum;
	}

	public String getPrepareProductSeqno() {
		return prepareProductSeqno;
	}

	public void setPrepareProductSeqno(String prepareProductSeqno) {
		this.prepareProductSeqno = prepareProductSeqno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrderTimeHhmi() {
		return orderTimeHhmi;
	}

	public void setOrderTimeHhmi(String orderTimeHhmi) {
		this.orderTimeHhmi = orderTimeHhmi;
	}

	public String getOrderTimeYmd() {
		return orderTimeYmd;
	}

	public void setOrderTimeYmd(String orderTimeYmd) {
		this.orderTimeYmd = orderTimeYmd;
	}

	public String getKbzs() {
		return kbzs;
	}

	public void setKbzs(String kbzs) {
		this.kbzs = kbzs;
	}

	public String getDistriProductSeqno() {
		return distriProductSeqno;
	}

	public void setDistriProductSeqno(String distriProductSeqno) {
		this.distriProductSeqno = distriProductSeqno;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}

	

	public String getPurchaseOrderno() {
		return purchaseOrderno;
	}

	public void setPurchaseOrderno(String purchaseOrderno) {
		this.purchaseOrderno = purchaseOrderno;
	}

	public String getArriveProductSeqno() {
		return arriveProductSeqno;
	}

	public void setArriveProductSeqno(String arriveProductSeqno) {
		this.arriveProductSeqno = arriveProductSeqno;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getPreparePerson() {
		return preparePerson;
	}

	public void setPreparePerson(String preparePerson) {
		this.preparePerson = preparePerson;
	}

	public String getDistriPerson() {
		return distriPerson;
	}

	public void setDistriPerson(String distriPerson) {
		this.distriPerson = distriPerson;
	}

	public String getUnloadPort() {
		return unloadPort;
	}

	public void setUnloadPort(String unloadPort) {
		this.unloadPort = unloadPort;
	}

	public String getReceiveDate() {
		return receiveDate;
	}

	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}

	

	@Override
	public void setId(String id) {
		this.id = id;
		
	}

	@Override
	public String getId() {
		return id;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public String getPurchaseRowNo() {
		return purchaseRowNo;
	}

	public void setPurchaseRowNo(String purchaseRowNo) {
		this.purchaseRowNo = purchaseRowNo;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartShortNo() {
		return partShortNo;
	}

	public void setPartShortNo(String partShortNo) {
		this.partShortNo = partShortNo;
	}

//	public String getStandPackage() {
//		return standPackage;
//	}
//
//	public void setStandPackage(String standPackage) {
//		this.standPackage = standPackage;
//	}

	public String getBoxesNum() {
		return boxesNum;
	}

	public void setBoxesNum(String boxesNum) {
		this.boxesNum = boxesNum;
	}

	public String getCancelNum() {
		return cancelNum;
	}

	public void setCancelNum(String cancelNum) {
		this.cancelNum = cancelNum;
	}

	public String getTotalRecQty() {
		return totalRecQty;
	}

	public void setTotalRecQty(String totalRecQty) {
		this.totalRecQty = totalRecQty;
	}

	public String getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
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

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getDepotNo() {
		return depotNo;
	}

	public void setDepotNo(String depotNo) {
		this.depotNo = depotNo;
	}

	public String getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(String printStatus) {
		this.printStatus = printStatus;
	}

	public String getDownloadStatus() {
		return downloadStatus;
	}

	public void setDownloadStatus(String downloadStatus) {
		this.downloadStatus = downloadStatus;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	
	public String getTotalDelivQty() {
		return totalDelivQty;
	}

	public void setTotalDelivQty(String totalDelivQty) {
		this.totalDelivQty = totalDelivQty;
	}

	public String getTempDelivQty() {
		return tempDelivQty;
	}

	public void setTempDelivQty(String tempDelivQty) {
		this.tempDelivQty = tempDelivQty;
	}
	
	public String getStandardPackage() {
		return standardPackage;
	}

	public void setStandardPackage(String standardPackage) {
		this.standardPackage = standardPackage;
	}

	public String getSupFactory() {
		return supFactory;
	}

	public void setSupFactory(String supFactory) {
		this.supFactory = supFactory;
	}

	public String getStandPackage() {
		return standPackage;
	}

	public void setStandPackage(String standPackage) {
		this.standPackage = standPackage;
	}

	public String getStandartPackage() {
		return standartPackage;
	}

	public void setStandartPackage(String standartPackage) {
		this.standartPackage = standartPackage;
	}

	public String getOrderQity() {
		return orderQity;
	}

	public void setOrderQity(String orderQity) {
		this.orderQity = orderQity;
	}


	public Object getQRCode() {
		return QRCode;
	}

	public void setQRCode(Object qRCode) {
		QRCode = qRCode;
	}

	public Object getQR_INFOS() {
		return QR_INFOS;
	}

	public void setQR_INFOS(Object qR_INFOS) {
		QR_INFOS = qR_INFOS;
	}

	public String getPlanPickUpTimeStr() {
		return planPickUpTimeStr;
	}

	public void setPlanPickUpTimeStr(String planPickUpTimeStr) {
		this.planPickUpTimeStr = planPickUpTimeStr;
	}

	public String getPlanPickUpTimeStrStart() {
		return planPickUpTimeStrStart;
	}

	public void setPlanPickUpTimeStrStart(String planPickUpTimeStrStart) {
		this.planPickUpTimeStrStart = planPickUpTimeStrStart;
	}

	public String getPlanPickUpTimeStrEnd() {
		return planPickUpTimeStrEnd;
	}

	public void setPlanPickUpTimeStrEnd(String planPickUpTimeStrEnd) {
		this.planPickUpTimeStrEnd = planPickUpTimeStrEnd;
	}

	public String getPrintUser() {
		return printUser;
	}

	public void setPrintUser(String printUser) {
		this.printUser = printUser;
	}

	public String getPrintUserIp() {
		return printUserIp;
	}

	public void setPrintUserIp(String printUserIp) {
		this.printUserIp = printUserIp;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getWorkcenter() {
		return workcenter;
	}

	public void setWorkcenter(String workcenter) {
		this.workcenter = workcenter;
	}

	public String getSrs() {
		return srs;
	}

	public void setSrs(String srs) {
		this.srs = srs;
	}

	public String getOrderRowNo() {
		return orderRowNo;
	}

	public void setOrderRowNo(String orderRowNo) {
		this.orderRowNo = orderRowNo;
	}

	public String getLabelRowno() {
		return labelRowno;
	}

	public void setLabelRowno(String labelRowno) {
		this.labelRowno = labelRowno;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getPlanCodeDesc() {
		return planCodeDesc;
	}

	public void setPlanCodeDesc(String planCodeDesc) {
		this.planCodeDesc = planCodeDesc;
	}

	public String getShipDepot() {
		return shipDepot;
	}

	public void setShipDepot(String shipDepot) {
		this.shipDepot = shipDepot;
	}

	public String getArrDepot() {
		return arrDepot;
	}

	public void setArrDepot(String arrDepot) {
		this.arrDepot = arrDepot;
	}

	public String getDistriPackage() {
		return distriPackage;
	}

	public void setDistriPackage(String distriPackage) {
		this.distriPackage = distriPackage;
	}

	public String getKbProductSeqno() {
		return kbProductSeqno;
	}

	public void setKbProductSeqno(String kbProductSeqno) {
		this.kbProductSeqno = kbProductSeqno;
	}

	public String getDispatchProductSeqno() {
		return dispatchProductSeqno;
	}

	public void setDispatchProductSeqno(String dispatchProductSeqno) {
		this.dispatchProductSeqno = dispatchProductSeqno;
	}

	public String getDeliveryProductSeqno() {
		return deliveryProductSeqno;
	}

	public void setDeliveryProductSeqno(String deliveryProductSeqno) {
		this.deliveryProductSeqno = deliveryProductSeqno;
	}

	public String getAssembleProductSeqno() {
		return assembleProductSeqno;
	}

	public void setAssembleProductSeqno(String assembleProductSeqno) {
		this.assembleProductSeqno = assembleProductSeqno;
	}

	public String getKbTime() {
		return kbTime;
	}

	public void setKbTime(String kbTime) {
		this.kbTime = kbTime;
	}

	public String getPrepareTime() {
		return prepareTime;
	}

	public void setPrepareTime(String prepareTime) {
		this.prepareTime = prepareTime;
	}

	public String getDispatchTime() {
		return dispatchTime;
	}

	public void setDispatchTime(String dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getDistriTime() {
		return distriTime;
	}

	public void setDistriTime(String distriTime) {
		this.distriTime = distriTime;
	}

	public String getPrepareBatchNo() {
		return prepareBatchNo;
	}

	public void setPrepareBatchNo(String prepareBatchNo) {
		this.prepareBatchNo = prepareBatchNo;
	}

	public String getPrepareBatchNoTo() {
		return prepareBatchNoTo;
	}

	public void setPrepareBatchNoTo(String prepareBatchNoTo) {
		this.prepareBatchNoTo = prepareBatchNoTo;
	}

	public String getKbBatchNo() {
		return kbBatchNo;
	}

	public void setKbBatchNo(String kbBatchNo) {
		this.kbBatchNo = kbBatchNo;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getDealFlag() {
		return dealFlag;
	}

	public void setDealFlag(String dealFlag) {
		this.dealFlag = dealFlag;
	}

	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}

	public String getAssembleTime() {
		return assembleTime;
	}

	public void setAssembleTime(String assembleTime) {
		this.assembleTime = assembleTime;
	}

	public String getCreationTimeTo() {
		return creationTimeTo;
	}

	public void setCreationTimeTo(String creationTimeTo) {
		this.creationTimeTo = creationTimeTo;
	}

	public String getUnloadCode() {
		return unloadCode;
	}

	public void setUnloadCode(String unloadCode) {
		this.unloadCode = unloadCode;
	}

	public String getKbName() {
		return kbName;
	}

	public void setKbName(String kbName) {
		this.kbName = kbName;
	}

	public String getLabelPageNum() {
		return labelPageNum;
	}

	public void setLabelPageNum(String labelPageNum) {
		this.labelPageNum = labelPageNum;
	}

	public String getSyFlag() {
		return syFlag;
	}

	public void setSyFlag(String syFlag) {
		this.syFlag = syFlag;
	}

	public Object getLogoImg() {
		return logoImg;
	}

	public void setLogoImg(Object logoImg) {
		this.logoImg = logoImg;
	}

	public String getPartNameCn() {
		return partNameCn;
	}

	public void setPartNameCn(String partNameCn) {
		this.partNameCn = partNameCn;
	}

	public String getDemander() {
		return demander;
	}

	public void setDemander(String demander) {
		this.demander = demander;
	}

	public String getDemandDepartment() {
		return demandDepartment;
	}

	public void setDemandDepartment(String demandDepartment) {
		this.demandDepartment = demandDepartment;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getConNumber() {
		return conNumber;
	}

	public void setConNumber(String conNumber) {
		this.conNumber = conNumber;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public String getCurrentQty() {
		return currentQty;
	}

	public void setCurrentQty(String currentQty) {
		this.currentQty = currentQty;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public void setCreationUser(String creationUser) {
		this.creationUser = creationUser;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
//	@Override
//	public String toString() {
//		return "SwDemondOrderDetailModel [id=" + id + ", purchaseNo=" + purchaseNo + ", purchaseRowNo=" + purchaseRowNo
//				+ ", partNo=" + partNo + ", partName=" + partName + ", partShortNo=" + partShortNo + ", orderQity="
//				+ orderQity + ", standPackage=" + standPackage + ", boxesNum=" + boxesNum + ", cancelNum=" + cancelNum
//				+ ", totalRecQty=" + totalRecQty + ", receiveStatus=" + receiveStatus + ", supplierNo=" + supplierNo
//				+ ", supplierName=" + supplierName + ", orderNo=" + orderNo + ", orderDate=" + orderDate
//				+ ", arriveDate=" + arriveDate + ", depotNo=" + depotNo + ", printStatus=" + printStatus
//				+ ", downloadStatus=" + downloadStatus + ", deliveryStatus=" + deliveryStatus + ", orderType="
//				+ orderType + "]";
//	}


//
	
	
	
	
	
	

}
