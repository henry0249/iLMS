<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springsecurity.org/jsp"%>
<html>
<head>
<title>厂外同步指示票明细</title>
<%@include file="/commons/include/list.jsp"%>
<script type="text/javascript" src="${ctx}/js/hotent/index/bootstrap-dialog.min.js"></script>
</head>
<body>
	<!-- 顶部按钮 -->
	<div class="toolbar-panel">
		<div class="buttons">
			<a class="btn btn-sm btn-primary fa-back" onClick="HT.window.closeEdit(true);"><span>返回</span></a>
		</div>
	</div>
	<div class="easyui-layout" fit="true" scroll="no">
		<div data-options="region:'north',split:true" style="background-color: #F5F5F5;height:30px;" >
			<div class="container-fluid" style="margin-top: 3px;">
				<div class="row">
					  <div class="col-md-3"><span>指示票号:</span><span id="insNo"></span></div>
					  <div class="col-md-3"><span>零件组名称:</span><span id="partgroupName"></span></div>
					  <div class="col-md-3"><span>出货批次:</span><span id="deliveryProductSeqno"></span></div>
					  <div class="col-md-3"><span>到货批次:</span><span id="arriveProductSeqno"></span></div>
				</div>
			</div>
		</div>
		<div data-options="region:'center',split:true">
			<div id="grid_detail" class="my-easyui-datagrid"></div>
		</div>
	</div>
</body>
</html>
<script>
	$(function() {
		var insNo = getQueryVariable("insNo");
		$("#insNo").text(insNo);
		var partgroupName = getQueryVariable("partgroupName"); 
		$("#partgroupName").text(partgroupName);
		var deliveryProductSeqno = getQueryVariable("deliveryProductSeqno");
		$("#deliveryProductSeqno").text(deliveryProductSeqno);
		var arriveProductSeqno = getQueryVariable("arriveProductSeqno"); 
		$("#arriveProductSeqno").text(arriveProductSeqno);
		loadGrid(insNo);
		
	});
	
	//js获取url参数
	function getQueryVariable(variable){
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(pair[0] == variable){return pair[1];}
       }
       return("");
	}
	
	//厂外同步指示票
	function loadGrid(insNo){
		$('#grid_detail').datagrid($.extend($defaultOptions,{
			url :  __ctx + "/jiso/ins/queryJisoInsDetailPageByInsNo?insNo=" + insNo,
			striped : true,
			fitColumns : false,
			columns : [ [
				{field : 'passTime',sortName : "passTime",title : 'PA OFF时间',width : 130,align : 'center',sortable : 'true'}, 
				{field : 'wcSeqno',sortName : "wcSeqno",title : '车身序号',width : 130,align : 'center',sortable : 'true'},
				{field : 'vin',sortName : "vin",title : 'VIN',width : 200,align : 'center',sortable : 'true'}, 
				{field : 'partMark',sortName : "partMark",title : '记号',width : 130,align : 'center',sortable : 'true'}, 
				{field : 'partShortNo',sortName : "partShortNo",title : '零件简号',width : 130,align : 'center',sortable : 'true'}, 
				{field : 'partNo',sortName : "partNo",title : '零件编号',width : 130,align : 'center',sortable : 'true'},
				{field : 'partName',sortName : "partName",title : '零件名称',width : 150,align : 'center',sortable : 'true'},
				{field : 'requireNum',sortName : "requireNum",title : '数量',width : 100,align : 'center',sortable : 'true'}
			 ] ]
		}));
		
	}
</script>