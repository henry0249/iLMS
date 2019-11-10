<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/commons/include/html_doctype.html" %>
<html ng-app="app">
	<head>
		<%@include file="/commons/include/ngEdit.jsp" %>
		<script type="text/javascript" src="${ctx}/js/sys/properties/sysProperties/sysPropertiesGetController.js"></script>
	</head>
	<body class="easyui-layout" ng-controller="ctrl">
		<!-- 顶部按钮 -->
		<div class="toolbar-panel">
			<div class="buttons">
				<a class="btn btn-primary btn-sm fa-back" onClick="HT.window.closeEdit();"><span>返回</span></a>
			</div>
		</div>
		<form name="form" ht-load="getJson?id=${param.id}"   ng-model="data">
		<table class="table-form"   cellspacing="0">
					<tr>								
						<th>参数名:</th>
						<td> {{data.name }}</td>
					</tr>
					<tr>								
						<th>别名:</th>
						<td> {{data.alias }}</td>
					</tr>
					<tr>								
						<th>分组:</th>
						<td> {{data.group }}</td>
					</tr>
					<tr>								
						<th>参数值:</th>
						<td> {{data.value }}</td>
					</tr>
					<tr>								
						<th>描述:</th>
						<td> {{data.description }}</td>
					</tr>
					<tr>								
						<th>创建时间:</th>
						<td> {{data.createTime | date :'yyyy-MM-dd'}}</td>
					</tr>
		</table>
		
		
		</form>
	</body>
</html>