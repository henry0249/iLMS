<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>发现区域维护</title>
<%@include file="/commons/include/list.jsp"%>
<script type="text/javascript" src="${ctx}/js/hotent/index/bootstrap-dialog.min.js"></script>
<script>


</script>
</head>
<body>
	<div class="easyui-layout" fit="true" scroll="no">
		<div id="gridSearch" class="toolbar-search ">
			<div class="toolbar-head">
				<!-- 顶部按钮 -->
				<div class="buttons">
					<a class="btn btn-sm btn-primary fa-search" onclick="findOut()">
						<span>搜索</span>
					</a>
					<a href="javascript:;" class="btn btn-sm btn-primary fa-rotate-left">
						<span>重置</span>
					</a>
					<a class="btn btn-sm btn-primary fa-add" id="add"  onclick="openDetail('','add')">
						<span>添加</span>
					</a>
					 <a class="btn btn-sm btn-primary fa-remove"  action="/dpm/area/remove">
						<span>删除</span>
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
						<li><span>发现区域代码:</span>
						<select id="seaFormAreaCode" class="inputText" name="areaCode"></select>
						</li>
						<li><span>车间:</span>
						<select id="seaFormWorkcenter" class="inputText" name="workcenter"></select>
						</li>
					    <li><span>发现区域名称:</span>
					    <input id="areaName" class="inputText" type="text" name="areaName"></li>
					</ul>
				</form>
			</div>
		</div>
		<div id="grid" class="my-easyui-datagrid" ></div>
	</div>
	<iframe id="downloadiframe" style="display:none;"></iframe>
</body>
</html>
<script>
	$(function() {
		loadGrid(null);
		
		//发现区域下拉框
		HtUtil.loadComboBox({
			url:__ctx+"/dpm/area/getUnloadCode",
			dictArr:[{
				el : '#seaFormAreaCode',
				addBlank : true
			}]
		});

		//车间下拉框
 		HtUtil.loadComboBox({
			url:__ctx+"/dpm/area/getUnloadWorkcenter",
			dictArr:[{
				el : '#seaFormWorkcenter',
				addBlank : true
			}]
		}); 
	});
		
	function openDetail(id, action) {
		var title = action == "edit" ? "编辑" : action == "add" ? "添加" : "查看";
		action = action == "edit" ? "Edit" : action == "add" ? "Edit" : "Get";
		var url = __ctx + "/dpm/area/dpmArea" + action + "";
		if(!$.isEmpty(id)){
			url+='?id=' + id ;
		}
		HT.window.openEdit(url, title, action, 'grid', 580, 350, null, null, id, false);
	}

	function findOut(){
		var onclickUrl = encodeURI( __ctx + "/dpm/area/curdlistJson");
		loadGrid(onclickUrl);
	}
	
	 function loadGrid(onclickUrl) {
		$('#grid').datagrid($.extend($defaultOptions,{
			url : onclickUrl,
			idField : "id",
			sortName : 'ID',
			sortOrder : 'desc',
			columns : [ [
			{field : 'id',sortName : "id",checkbox : true},     
			{field : 'workcenterName',sortName : "workcenterName",title : '车间',width : 150,align : 'center',sortable : 'true'}, 
			{field : 'areaCode',sortName : "areaCode",title : '发现区域代码',width : 130,align : 'center',sortable : 'true'},
			{field : 'areaName',sortName : "areaName",title : '发现区域名称',width : 130,align : 'center',sortable : 'true'},
			{field : 'areaDesc',sortName : "areaDesc",title : '发现区域描述',width : 130,align : 'center',sortable : 'true'},
			{field : 'wareCode',sortName : "wareCode",title : '仓库代码',width : 130,align : 'center',sortable : 'true'},
			{field : 'wareName',sortName : "wareName",title : '仓库名称',width : 130,align : 'center',sortable : 'true'}, 
			{
				field : 'colManage',
				title : '操作',
				align : 'center',
				formatter : function(value, row, index) {
					var result = "<a class='btn btn-default fa fa-edit' onClick='openDetail(\""+ row.id + "\",\"edit\");' herf='javascript:void(0)'>编辑</a>";
					result += "<a class='btn btn-default fa fa-detail' onClick='openDetail(\"" + row.id + "\",\"get\");' herf='javascript:void(0)'>明细</a>";
					result += "<a class='rowInLine btn btn-default fa fa-remove' action='/dpm/area/remove?id=" + row.id + "' herf='javascript:void(0)'>删除</a>";
					
					return result;
				}
			} ] ],
			autoScroll: true,
			onLoadSuccess : function() {
				handGridLoadSuccess();
			}
		}));
	} 
	
	
</script>