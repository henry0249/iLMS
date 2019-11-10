package com.hanthink.sw.model;


/**
* <p>Title: SwSupplierGroupModelImport.java<／p>
* <p>Description: <／p>
* <p>Company: hanthink<／p>
* @author luoxq
* @date 2018年10月13日
*/

public class SwSupplierGroupModelImport extends SwSupplierGroupModel{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5554052069975934492L;
	/** 导入UUID */
	private String uuid;
	/** 检查结果(0错误;1：通过;2:重复存在) */
	private String checkResult;
	/** 检查结果信息 */
	private String checkInfo;
	/** 导入状态 */
	private String importStatus;
	/**导入类型   新增|更新**/
	private String opeType;
		
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getCheckResult() {
		return checkResult;
	}
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}
	public String getCheckInfo() {
		return checkInfo;
	}
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}
	public String getImportStatus() {
		return importStatus;
	}
	public void setImportStatus(String importStatus) {
		this.importStatus = importStatus;
	}
    
	public String getOpeType() {
		return opeType;
	}
	public void setOpeType(String opeType) {
		this.opeType = opeType;
	}
	
	/**
     * 供应商分组导入数据检查
     * @param vo
     * @author luoxq  2018-10-13
     */
    public static void checkImportData(SwSupplierGroupModelImport m) {
        StringBuffer checkInfo = new StringBuffer();
        
        if(m.getGroupName() == null || "".equals(m.getGroupName())){
            checkInfo.append("分组名称为空;");
        }
        if(m.getSupplierNo() == null || "".equals(m.getSupplierNo())){
            checkInfo.append("供应商代码为空;");
        }
        if(checkInfo == null || "".equals(checkInfo.toString())){
            m.setCheckResult("1");
            m.setCheckInfo("");
        }else{
            m.setCheckResult("0");
            m.setCheckInfo(checkInfo.toString());
        }
    }
}
