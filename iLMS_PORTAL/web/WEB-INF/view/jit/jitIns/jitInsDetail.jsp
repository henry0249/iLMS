<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springsecurity.org/jsp"%>
<html>
<head>
<title>拉动配送单明细查询</title>
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
					  <div class="col-md-3"><span>物流单号:</span><span id="orderNo"></span></div>
					  <div class="col-md-3"><span>配送单号:</span><span id="insNo"></span></div>
					  <div class="col-md-3"><span>备件批次:</span><span id="prepareBatchNo"></span></div>
					  <div class="col-md-3"><span>仓库代码:</span><span id="shipDepot"></span></div>
				</div>
			</div>
		</div>
		<div data-options="region:'center',split:true">
			<div id="grid" class="my-easyui-datagrid"></div>
		</div>
	</div>
</body>
</html>
<script>
	$(function() {
		var orderNo = getQueryVariable("orderNo");
		$("#orderNo").text(orderNo);
		var insNo = getQueryVariable("insNo");
		$("#insNo").text(insNo);
		var prepareBatchNo = getQueryVariable("prepareBatchNo");
		$("#prepareBatchNo").text(prepareBatchNo);
		var shipDepot = getQueryVariable("shipDepot");
		$("#shipDepot").text(shipDepot);
		
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
		$('#grid').datagrid($.extend($defaultOptions,{
			url :  __ctx + "/jit/jitIns/queryJitInsDetailPage?insNo=" + insNo,
			striped : true,
			fitColumns : false,
			columns : [ [
				{field : 'insNo',sortName : "insNo",title : '配送单号',width : 130,align : 'center',sortable : 'true'}, 
				{field : 'location',sortName : "location",title : '落点',width : 130,align : 'center',sortable : 'true'},
				{field : 'partNo',sortName : "partNo",title : '零件编号',width : 200,align : 'center',sortable : 'true'}, 
				{field : 'partShortNo',sortName : "partShortNo",title : '零件简号',width : 130,align : 'center',sortable : 'true'}, 
				{field : 'partName',sortName : "partName",title : '零件名称',width : 130,align : 'center',sortable : 'true'},
				{field : 'requireNum',sortName : "requireNum",title : '配送量',width : 130,align : 'center',sortable : 'true'}, 
				{field : 'storage',sortName : "storage",title : '拣货地址',width : 150,align : 'center',sortable : 'true'}
			 ] ]
		}));
		
	}
</script>