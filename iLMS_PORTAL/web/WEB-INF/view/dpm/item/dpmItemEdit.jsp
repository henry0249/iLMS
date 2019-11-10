<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html ng-app="app">
<head>
<%@include file="/commons/include/ngEdit.jsp"%>
<script type="text/javascript">
	var app = angular.module('app', ['formDirective','arrayToolService']);
	app.controller("ctrl", [ '$scope', 'baseService','ArrayToolService', function($scope, baseService,ArrayTool) {
		$scope.ArrayTool = ArrayTool;
		
		var data={
			
		}
		
		$scope.addRow=function(classVar){
			$scope.data[classVar +"List"].push(angular.copy(obj[classVar]))
		}
		
	}]);
</script>
<script type="text/javascript">
	var id = "${param.id}";
	$(function() {
		if(!$.isEmpty(id)){
			$('#itemCode').attr('disabled',true);
		}
	});
	
	/**
	* 禁止空格输入
	* @param e
	* @returns {Boolean}
	*/
	function banInputSapce(e)
	{
		var keynum;
		if(window.event) // IE
		{
			keynum = e.keyCode
		}else if(e.which) // Netscape/Firefox/Opera
		{
			keynum = e.which
		}if(keynum == 32){
			return false;
		}
		return true;
	} 
</script>
</head>
<body ng-controller="ctrl">
	<!-- 顶部按钮 -->
	<div class="toolbar-panel">
		<div class="buttons">
			<a class="btn btn-sm btn-primary fa-save" ng-model="data" ng-disabled="btnDisable.save" ht-save="${ctx}/dpm/item/save"><span>保存</span></a> 
			<a class="btn btn-sm btn-primary fa-back" onClick="HT.window.closeEdit(true);"><span>返回</span></a>
		</div>
	</div>
	<div id="tabUser" class="easyui-tabs" style="width: 100%; height: 100%;">
		<div title="基础信息" style="padding: 10px;">
			<form name="form" method="post" ht-load="${ctx}/dpm/item/curdgetJson?id=${param.id}" ng-model="data">
				<table class="table-form" cellspacing="0">
					<tr>
						<th><span>不良品项目代码:</span><span class="required">*</span></th>
						<td><input class="inputText" id="itemCode" type="text" ng-model="data.itemCode" ht-validate="{required:true,maxlength:20}" /></td>
					</tr>
					<tr>
						<th><span>不良品项目名称:</span><span class="required">*</span></th>
						<td><input class="inputText" type="text" ng-model="data.itemName" ht-validate="{required:true,maxlength:16}" /></td>
					</tr>
					<tr>
						<th><span>不良品描述:</span></th>
						<td><input class="inputText" type="text" ng-model="data.itemDesc" ht-validate="{required:false,maxlength:50}" /></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>