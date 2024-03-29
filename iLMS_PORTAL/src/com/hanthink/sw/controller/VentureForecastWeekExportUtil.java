package com.hanthink.sw.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import com.hanthink.sw.manager.SwVentureForecastWeekManager;
import com.hanthink.sw.manager.SwVentureForecastWeekManager;
import com.hanthink.sw.model.SwVentureForecastModel;
import com.hanthink.util.excel.ExcelExportUtil;
import com.hanthink.util.excel.ExcelUtil;
import com.hotent.base.db.mybatis.domain.DefaultPage;
import com.hotent.base.db.mybatis.domain.PageList;

/**
 * 
 * @Desc		: 周预测数据导出工具类
 * @FileName	: DemandForecastExportUtil.java
 * @CreateOn	: 2018年11月12日 下午3:39:46
 * @author 		: ZUOSL
 *
 * @ChangeList
 * Date				Version		Editor		Reasons
 * 
 */
public class VentureForecastWeekExportUtil  extends ExcelExportUtil {
	
	private SwVentureForecastWeekManager manager;
	private String startMonthStr;
	private String endMonthStr;
//	private String supplierNo;
//	private String releaseStatus;
	private SwVentureForecastModel model;
	
	public VentureForecastWeekExportUtil(SwVentureForecastWeekManager manager,
			String startMonthStr, String endMonthStr, SwVentureForecastModel model){
		this.manager = manager;
		this.startMonthStr = startMonthStr;
		this.endMonthStr = endMonthStr;
//		this.supplierNo = model.getSupplierNo();
//		this.releaseStatus = model.getReleaseStatus();
		this.model = model;
	}

	@Override
	public PageList<Object> queryDataFromDB(int page) {
		
		return null;
	}
	
	/**
	 * 分页查询导出数据
	 * @param pageNum
	 * @return
	 * @author ZUOSL	
	 * @DATE	2018年11月12日 下午3:49:56
	 */
	private PageList<Map<String, Object>> queryDemandForecastDataFromDB(int pageNum) {
		DefaultPage page = new DefaultPage();
		page.setPage(pageNum);
		page.setLimit(pageSize);
		return manager.queryVentureForecastWeekExportDataByPage(startMonthStr, endMonthStr, model, page);
	}
	
	@Override
	public void showChange(Object vo) {
		
	}
	
	/**
	 * 导出格式与数据特殊需求，需自定义导出方法
	 * @param excelExtName
	 * @param request
	 * @param response
	 * @param exportFileName
	 * @throws IOException
	 * @author ZUOSL	
	 * @DATE	2018年11月12日 下午3:41:40
	 */
	public void exportDemandForecastExcel(String excelExtName, HttpServletRequest request, HttpServletResponse response,
			String exportFileName) throws IOException{
    	
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
    	
		if(null != excelExtName){
			excelExtName = excelExtName.toLowerCase();
		}
		
		Workbook workbook = null;
		if(ExcelUtil.EXCEL_XLS.equals(excelExtName)){
			workbook = new HSSFWorkbook();
			if(!exportFileName.endsWith(ExcelUtil.EXCEL_XLS)){
				exportFileName = exportFileName + ExcelUtil.EXCEL_XLS;
			}
		}else{
			workbook = new SXSSFWorkbook(2000);
			if(!exportFileName.endsWith(ExcelUtil.EXCEL_XLSX)){
				exportFileName = exportFileName + ExcelUtil.EXCEL_XLSX;
			}
		}
		
		String downName = null;
    	try {
    		if (request.getHeader("user-agent").toLowerCase().contains("msie")
    				|| request.getHeader("user-agent").toLowerCase().contains("like gecko") ) {
			downName = URLEncoder.encode(exportFileName, "UTF-8");
    	}else{
    		downName = new String(exportFileName.getBytes("UTF-8"), "ISO_8859_1");
    	}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error(e.toString());
		}
        
		response.setHeader("Content-disposition", "attachment; filename=" + downName);
    	
    	Sheet sheet = workbook.createSheet();

        //表头样式
        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFillForegroundColor((short) 70); 
        headStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headStyle.setBorderRight(CellStyle.BORDER_THIN);
        headStyle.setBorderTop(CellStyle.BORDER_THIN);
        headStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headStyle.setRotation((short)90);

        //表头字体
        Font headFont = workbook.createFont();
        headFont.setFontHeightInPoints((short) 11);
//        headFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        headStyle.setFont(headFont);

        //内容样式
        CellStyle columnStyle = workbook.createCellStyle();
        columnStyle.setFillPattern(CellStyle.NO_FILL);//(HSSFCellStyle.SOLID_FOREGROUND);
        columnStyle.setBorderBottom(CellStyle.BORDER_THIN);
        columnStyle.setBorderLeft(CellStyle.BORDER_THIN);
        columnStyle.setBorderRight(CellStyle.BORDER_THIN);
        columnStyle.setBorderTop(CellStyle.BORDER_THIN);
        columnStyle.setAlignment(CellStyle.ALIGN_LEFT);
        columnStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        //内容字体
        Font columnFont = workbook.createFont();
        columnFont.setFontHeightInPoints((short) 11);
        columnFont.setBoldweight(Font.BOLDWEIGHT_NORMAL);
        columnStyle.setFont(columnFont);
        
        //生成字段信息
        List<String> headerList = new ArrayList<String>();
        List<String> columnList = new ArrayList<String>();
        List<Integer> widthList = new ArrayList<Integer>();
        genHeaderInfo(headerList, columnList, widthList);
        String[] headers = new String[headerList.size()];
        for(int i = 0; i < headerList.size(); i ++){
        	headers[i] = headerList.get(i);
        }
        String[] columns = new String[columnList.size()];
        for(int i = 0; i < columnList.size(); i ++){
        	columns[i] = columnList.get(i);
        }
        int[] widths = new int[widthList.size()];
        for(int i = 0; i < widthList.size(); i ++){
        	widths[i] = widthList.get(i).intValue();
        }

        //表头
    	Row row = sheet.createRow(0);
    	row.setHeight((short) 1440);
    	for (int i = 0; i < headers.length; i++) {
    		Cell cell = row.createCell(i);
    		cell.setCellStyle(headStyle);
    		XSSFRichTextString text = new XSSFRichTextString(headers[i]);
    		cell.setCellValue(text);
    		sheet.setColumnWidth(i, widths[i] * 45);
    	}
    	
    	PageList<Map<String, Object>> qPageList = null;
    	int queryCount = 1;
    	
    	do {
    		qPageList = this.queryDemandForecastDataFromDB(queryCount);
    		queryCount ++;
    		
    		if(null != qPageList && 0 < qPageList.size()){
    			List<Map<String, Object>> list = qPageList;
    			
    			for (int i = 0; i < list.size(); i++) {
    				Map<String, Object> vo = list.get(i);
    				this.showChange(vo); // 数据显示转换
    				
    				row = sheet.createRow((queryCount-2)*pageSize+i+1);
    	    		row.setHeight((short) 360);
    	    		
    	    		for (int k = 0; k < columns.length; k++) {
    	    			Cell cell = row.createCell(k);
    	    			cell.setCellStyle(columnStyle);
    	    			
//    	    			Class<? extends Object> voClass = vo.getClass();
						try {
//							Method getMethod = voClass.getMethod("get"+columns[k].substring(0,1).toUpperCase()+columns[k].substring(1));
//							Object cellValue = getMethod.invoke(vo);
							
							Object cellValue = vo.get(columns[k]);
							if(cellValue instanceof Integer){
								cell.setCellValue(((Integer)cellValue).intValue());
							}else if(cellValue instanceof Long ){
								cell.setCellValue(((Long)cellValue).intValue());
							}else if(cellValue == null ){
								cell.setCellValue("");
							}else{
								cell.setCellValue(String.valueOf(cellValue));
							}

						} catch (Exception e) {
							log.error(e.toString());
							e.printStackTrace();
						}
    	    		}
    			}
    		}
    		
		} while (null != qPageList && 0 < qPageList.size());
    	
    	try {
			OutputStream out = response.getOutputStream();
			workbook.write(out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
    	
    }

	/**
	 * 拼接导出字段信息
	 * @param headerList
	 * @param columnList
	 * @param widthList
	 * @author ZUOSL	
	 * @DATE	2018年11月12日 下午4:07:55
	 */
	private void genHeaderInfo(List<String> headerList, List<String> columnList, List<Integer> widthList) {
		
		SimpleDateFormat sdfym = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfHym = new SimpleDateFormat("yyMM");
		SimpleDateFormat sdfHymd = new SimpleDateFormat("yyMM_dd");
		
		String smonth = this.startMonthStr;
		String emonth = this.endMonthStr;
		String sday = smonth ;
		String eday = null;
		Date smonthdate = null;
		Date emonthdate = null;
		Date sdaydate = null;
		Date edaydate = null;
		Calendar cal = Calendar.getInstance();
		try {
			smonthdate = sdfym.parse(smonth);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException("日期格式错误");
		}
		if(null == emonth){
			cal.setTime(smonthdate);
			cal.add(Calendar.DAY_OF_MONTH, 28);
			emonth = sdfym.format(cal.getTime());
		}
		try {
			emonthdate = sdfymd.parse(emonth);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException("日期格式错误");
		}
		cal.setTime(emonthdate);
//		cal.add(Calendar.MONTH, 1);
//		cal.add(Calendar.DAY_OF_YEAR, -1);
		eday = sdfymd.format(cal.getTime());
		try {
			sdaydate = sdfymd.parse(sday);
			edaydate = sdfymd.parse(eday);
		} catch (ParseException e) {
			e.printStackTrace();
			new RuntimeException("日期格式错误");
		}
		
		//添加固定字段
		headerList.add("零件号");
        columnList.add("PART_NO");
        widthList.add(150);
        headerList.add("简号");
        columnList.add("PART_SHORT_NO");
        widthList.add(80);
        headerList.add("零件名称");
        columnList.add("PART_NAME_CN");
        widthList.add(150);

        headerList.add("W周时间范围");
        columnList.add("OBJ_WEEK");
        widthList.add(80);
        headerList.add("提前取货时间(天)");
        columnList.add("ADVANCE_TIME");
        widthList.add(80);
//        headerList.add("车型");
//        columnList.add("MODEL_CODE");
//        widthList.add(40);
//		headerList.add("发布版本");
//        columnList.add("VERSION");
//        widthList.add(60);
        headerList.add("供应商代码");
        columnList.add("SUPPLIER_NO");
        widthList.add(40);
//        headerList.add("出货地代码");
//        columnList.add("SUP_FACTORY");
//        widthList.add(40);
        headerList.add("供应商名称");
        columnList.add("SUPPLIER_NAME");
        widthList.add(150);
        headerList.add("W周");
        columnList.add("WEEK_ONE");
        widthList.add(40);
        headerList.add("W+1周");
        columnList.add("WEEK_TWO");
        widthList.add(40);
        headerList.add("W+2周");
        columnList.add("WEEK_THREE");
        widthList.add(40);
        headerList.add("W+3周");
        columnList.add("WEEK_FOUR");
        widthList.add(40);
        
        //日明细
		Date curDay = sdaydate;
		do{
//			System.out.println(sdfHymd.format(curDay));
			headerList.add(sdfHymd.format(curDay)); //1905_01
			columnList.add("DAY" + sdfHymd.format(curDay)); //DAY1905_01
			widthList.add(40);
			cal.setTime(curDay);
			cal.add(Calendar.DAY_OF_YEAR, 1);
			curDay = cal.getTime();
		}while(curDay.getTime() <= edaydate.getTime());
        
        
//        headerList.add("发布状态");
//        columnList.add("RELEASE_STATUS");
//        widthList.add(40);
        
        headerList.add("生产阶段");
        columnList.add("PHASE");
        widthList.add(40);

	}

	public static void main(String[] args) {
		SimpleDateFormat sdfym = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");
		String smonth = "2019-12";
		String emonth = null;
		String sday = smonth + "-01";
		String eday = null;
		Date smonthdate = null;
		Date emonthdate = null;
		Date sdaydate = null;
		Date edaydate = null;
		Calendar cal = Calendar.getInstance();
		try {
			smonthdate = sdfym.parse(smonth);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException("格式错误");
		}
		if(null == emonth){
			cal.setTime(smonthdate);
			cal.add(Calendar.MONTH, 2);
			emonth = sdfym.format(cal.getTime());
		}
		
		System.out.println("emonth:"+emonth);
		try {
			emonthdate = sdfym.parse(emonth);
		} catch (Exception e) {
			e.printStackTrace();
			new RuntimeException("格式错误");
		}
		cal.setTime(emonthdate);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		eday = sdfymd.format(cal.getTime());
		System.out.println("eday:"+eday);
		
		Date curMonth = smonthdate;
		do{
			System.out.println(sdfym.format(curMonth));
			cal.setTime(curMonth);
			cal.add(Calendar.MONTH, 1);
			curMonth = cal.getTime();
		}while(curMonth.getTime() <= emonthdate.getTime());
		
		try {
			sdaydate = sdfymd.parse(sday);
			edaydate = sdfymd.parse(eday);
			Date curDay = sdaydate;
			do{
				System.out.println(sdfymd.format(curDay));
				cal.setTime(curDay);
				cal.add(Calendar.DAY_OF_YEAR, 1);
				curDay = cal.getTime();
			}while(curDay.getTime() <= edaydate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
}

