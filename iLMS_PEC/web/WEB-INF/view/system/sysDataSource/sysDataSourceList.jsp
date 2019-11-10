<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据源列表</title>
<%@include file="/commons/include/list.jsp"%>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div data-options="region:'center',border:false">
			<!-- 顶部查询操作 -->
			<div id="gridSearch" class="toolbar-search ">
					<div class="toolbar-head">
						<!-- 顶部按钮 -->
						<div class="buttons">
							<a class="btn btn-primary  btn-sm fa-search" href="javaScript:void(0)">
								<span>搜索</span>
							</a>
							<a class="btn btn-primary btn-sm fa-add" href="javaScript:void(0)" onClick='openDetail("","add")'>
								<span>添加</span>
							</a>
							<a class="btn btn-primary btn-sm fa-remove" href="javaScript:void(0)" action="/system/sysDataSource/remove">
								<span>删除</span>
							</a>
							<a href="javaScript:void(0)" class="btn btn-sm btn-primary fa-rotate-left">
								<span>重置</span>
							</a>
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse">
								<i class=" fa  fa-angle-double-up"></i>
							</a>
						</div>
					</div>
					<div class="toolbar-body">
						<form id="searchForm" class="search-form">
							<ul>
								<li class="mar-l-20">
									<span>名称:</span>
									<input class="inputText" type="text" name="Q^name_^SL">
								</li>
							</ul>
						</form>
					</div>
			</div>
			<div id="grid" class="my-easyui-datagrid"></div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function() {
		loadGrid();
	});
	function openDetail(id, action) {
		var title = action == "sysDataSourceEdit" ? "编辑数据源" : action == "add" ? "添加数据源" : "查看数据源";
		action = action == "add" ? "sysDataSourceEdit" : action;
		var url = action;
		if (id && id != "") {
			url += "?id=" + id;
		}
		HT.window.openEdit(url, title, action, 'grid', 500, 500, null, null, id, true);
	}
	
	function loadGrid() {
		$('#grid').datagrid($.extend($defaultOptions,{
			url : __ctx + "/system/sysDataSource/listJson",
			idField : "id",
			sortName : 'id_',
			sortOrder : 'desc',
			columns : [ [ 
				{
					field : 'id',
					sortName : "id_",
					checkbox : true
				}, {
					field : 'name',
					sortName : "name_",
					title : '名称',
					width : 200,
					align : 'center',
					sortable : 'true'
				}, {
					field : 'alias',
					sortName : "alias_",
					title : '别名',
					width : 200,
					align : 'center',
					sortable : 'true'
				} ,
				{
					field : 'enabled',
					title : '是否可用',
					width : 200,
					align : 'center',
					formatter:function(value,row,index){
	                 	var arr=[{'key':'1','value':'是','css':'green'},{'key':'0','value':'否','css':'red'}];
	                 	return Object.formatItemValue(arr,value);
	             	}
				},{
					field : 'initOnStart',
					title : '启动装载',
					width : 200,
					align : 'center',
					formatter:function(value,row,index){
	                 	var arr=[{'key':'1','value':'是','css':'green'},{'key':'0','value':'否','css':'red'}];
	                 	return Object.formatItemValue(arr,value);
	             	}
				}, {
					field : 'colManage',
					title : '操作',
					align : 'center',
					formatter : function(value, row, index) {
						var result = "";
						result += "<a class='btn btn-default fa fa-edit' onClick='openDetail(" + row.id + ",\"sysDataSourceEdit\")' herf='javaScript:void(0)'>编辑</a>";
						return result;
					}
				} ] ]
		}));
	}
</script>