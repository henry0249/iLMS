package com.hanthink.jit.model;
import com.hotent.base.core.model.AbstractModel;


 /**
  * <pre> 
  * 描述：实际过点批次 实体对象
  * 作者:lz
  * 日期:2018-10-09 13:58:27
  * </pre>
  */
public class JitRealKbBatchModel extends AbstractModel<String>{
	
	/**  
	 * <p>Description: long</p>  
	 * @author linzhuo  
	 * @date 2018年10月9日
	 * @version 1.0  
	 */  
	private static final long serialVersionUID = -1660324181775751046L;

	/**
	 * 主表  实际过点批次表
	 */
	/**
	 * 信息点
     */
	private String planCode; 
	
	/**
	 * 产品订单号
     */
	private String orderId; 
	
	/**
	 * 实际看板时间   */
	private java.util.Date realKbTime; 
	
	/**
	 * 实际看板时间   */
	private String realKbTimeStr; 
	
	/**
	 * 实际看板时间(开始)   */
	private String realKbTimeStrStart; 
	
	/**
	 * 实际看板时间(结束）  */
	private String realKbTimeStrEnd; 
	
	
	/**
	 * 看板批次产品流水号    */
	private String realKbProductSeqno; 
	
	/**
	 * 最后经过工位
     */
	private java.util.Date creationTime;

	/**
	 * 副表  车序表
	 */
	/**
	 * VIN
     */
	private String vin;
	
	/**
	 * 下线批次
     */
	private String sortid;
	
	/**
	 * 信息点过点时间
     */
	private String passTime;
	
	/**
	 * 副表  监控看板表
	 */
	/**
	 * 过点工位
     */
	private String stationCode;
	
	/**
	 * 副表  数据字典表
	 */
	/**
	 * 信息点描述
     */
	private String planCodeDesc;
	
	
	/**
	 * 主表  实际过点批次表
	 */
	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public java.util.Date getRealKbTime() {
		return realKbTime;
	}

	public void setRealKbTime(java.util.Date realKbTime) {
		this.realKbTime = realKbTime;
	}

	public String getRealKbTimeStr() {
		return realKbTimeStr;
	}

	public void setRealKbTimeStr(String realKbTimeStr) {
		this.realKbTimeStr = realKbTimeStr;
	}
	
	public String getRealKbTimeStrStart() {
		return realKbTimeStrStart;
	}

	public void setRealKbTimeStrStart(String realKbTimeStrStart) {
		this.realKbTimeStrStart = realKbTimeStrStart;
	}

	public String getRealKbTimeStrEnd() {
		return realKbTimeStrEnd;
	}

	public void setRealKbTimeStrEnd(String realKbTimeStrEnd) {
		this.realKbTimeStrEnd = realKbTimeStrEnd;
	}

	public String getRealKbProductSeqno() {
		return realKbProductSeqno;
	}

	public void setRealKbProductSeqno(String realKbProductSeqno) {
		this.realKbProductSeqno = realKbProductSeqno;
	}

	public java.util.Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(java.util.Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * 副表  车序表
	 */
	public String getSortid() {
		return sortid;
	}

	public void setSortid(String sortid) {
		this.sortid = sortid;
	}

	public String getPassTime() {
		return passTime;
	}

	public void setPassTime(String passTime) {
		this.passTime = passTime;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	
	/**
	 * 副表  监控看板表
	 */
	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	
	/**
	 * 副表  数据字典表
	 */
	public String getPlanCodeDesc() {
		return planCodeDesc;
	}

	public void setPlanCodeDesc(String planCodeDesc) {
		this.planCodeDesc = planCodeDesc;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
	
}