<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>零件剩余量主数据导入</title>
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
					<a class="btn btn-sm btn-primary fa-refresh" href="javascript:void(0)" onclick="refreshDataFn()" >
						<span>刷新</span>
					</a>
					<a class="btn btn-sm btn-primary fa-save" href="javascript:void(0)" onclick="isImportFn()" >
						<span>确定导入</span>
					</a>
					<a class="btn btn-primary btn-sm fa-sign-out"  href="javascript:void(0)" onclick="downloadDataFn()">
						<span>数据导出</span>
					</a>
					<a class="btn btn-primary btn-sm fa-sign-in"  href="javascript:void(0)" onclick="downloadTemplateFn()">
						<span>模板下载</span>
					</a>
					<a class="btn btn-primary btn-sm fa-back" onClick="HT.window.closeEdit(true,'grid');">
						<span>返回</span>
					</a>
				</div>
				<div class="tools">
					<a href="javascript:;" class="collapse">
						<i class=" fa  fa-angle-double-up"></i>
					</a>
				</div>
			</div>
			<div class="toolbar-body">
				<form style="margin-top:10px;" id="importForm" method="post" enctype="multipart/form-data">
					<table class="table-form" cellspacing="0">
						<tr>
							<th>
								<span style="font-size:12pt;font-weight:normal">选择文件:</span>
							</th>
							<td>
								<input type="file" size="40" name="file" id="file" accept=".xls,.xlsx" class="inputText input-wh-9" />
							</td>
							<td>
								<a class="btn btn-sm btn-primary fa-sign-in" href="javascript:void(0)" onclick="importFileFn()" >
									<span>文件导入</span>
								</a>
							</td>
						<!-- 	<td>
								<a class="btn btn-sm btn-primary fa-sign-in" href="javascript:void(0)" onclick="importFileFn2()" >
									<span>文件导入(大数量)</span>
								</a>
							</td> -->
						</tr>
					</table>
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
	loadGrid();
});

function refreshDataFn(){
	loadGrid();
}

function downloadTemplateFn(){
	var downurl = encodeURI(encodeURI(__ctx + '/comm/comm/downloadExcelModel?fileName=零件剩余量主数据导入模板.xlsx'));
	$('#downloadiframe').attr('src', downurl);
}

var isimport = false;
function importFileFn(){
	var frm = $('#importForm').form();
	var file = $("#file").val();
	if (file == "") {
		$.topCall.warn(htmsg.pub.notFindFileWarn);
		return;
	}
	frm.ajaxForm({
		success : function(responseText) {
			var resultMessage = new com.hotent.form.ResultMessage(responseText);
			var msg = JSON.parse(resultMessage.getMessage());
			var showMsg = msg['log'] == null || msg['log'] == '' ? msg['console'] : msg['log'];
			var flag = msg['flag'];
			showMsg = showMsg == null || showMsg == '' ? htmsg.pub.importSuccess : showMsg;
			if (resultMessage.isSuccess()) {
				$.topCall.closeProgress();
				loadGrid();
				$.topCall.success(showMsg, function() {
					if(flag == 1){
						isimport = true;
					}
				});
			}else if (resultMessage.getResult() == 0) {
				$.topCall.closeProgress();
				$.topCall.error(showMsg);
			} else {
				$.topCall.closeProgress();
				$.topCall.confirm("提示",showMsg,
					function(r) {
						if (!r) return;
						$('#importForm').attr("action", __ctx + "/mp/mpResidual/importMpResidualModel");
						$('#importForm').submit();
					}
				);
			}
		}
	});
	$.topCall.progress();
	$('#importForm').attr("action", __ctx + "/mp/mpResidual/importMpResidualModel");
	$('#importForm').submit();
}

function importFileFn2(){
	var frm = $('#importForm').form();
	var file = $("#file").val();
	if (file == "") {
		$.topCall.warn(htmsg.pub.notFindFileWarn);
		return;
	}
	frm.ajaxForm({
		success : function(responseText) {
			var resultMessage = new com.hotent.form.ResultMessage(responseText);
			var msg = JSON.parse(resultMessage.getMessage());
			var showMsg = msg['log']==null||msg['log']==''?msg['console']:msg['log'];
			showMsg = showMsg==null||showMsg==''?"导入成功！":showMsg;
			if (resultMessage.isSuccess()) {
				$.topCall.closeProgress();
				$.topCall.success(showMsg, function() {
					isimport = true;
					loadGrid();
				});
			}else if (resultMessage.getResult() == 0) {
				$.topCall.closeProgress();
				$.topCall.error(showMsg);
			} else {
				$.topCall.closeProgress();
				$.topCall.confirm("提示",showMsg,
					function(r) {
						if (!r) return;
						$('#importForm').attr("action", __ctx + "/mp/mpResidual/importMpResidualModel2");
						$('#importForm').submit();
					}
				);
			}
		}
	});
	$.topCall.progress();
	$('#importForm').attr("action", __ctx + "/mp/mpResidual/importMpResidualModel2");
	$('#importForm').submit();
}

function isImportFn(){
	if(!isimport){
		$.topCall.error("文件未导入或无正确数据!");
		return;
	}
	
	var waittingDialog= BootstrapDialog.waitting('正在执行，请等待...');
	var url=__ctx + "/mp/mpResidual/isImport";
    $.post(url,function(data){
        var obj = new com.hotent.form.ResultMessage(data);
        if(obj.isSuccess()){
        	loadGrid();
        	isimport = false;
            $.topCall.success("确定导入执行成功","提示信息");
            waittingDialog.close();
        }else{
            $.topCall.alert("确定导入执行失败",obj.data.cause);
	        waittingDialog.close();
        }
    });
}

function downloadDataFn(){
	var downurl = encodeURI(__ctx + '/mp/mpResidual/exportTempData');
	$('#downloadiframe').attr('src', downurl);
}
	
function loadGrid() {
	$('#grid').datagrid($.extend($defaultOptions,{
		url :  __ctx + "/mp/mpResidual/curdlistImportTempJson",
		idField : "id",
		sortName : 'ID',
		sortOrder : 'desc',
		columns : [ [
		{field : 'id',sortName : "ID",checkbox : true},     
		{field : 'partNo',sortName : "PART_NO",title : '零件编号',width : 130,align : 'center',sortable : 'true'},
		{field : 'supplierNo',sortName : "SUPPLIER_NO",title : '供应商代码',width : 150,align : 'center',sortable : 'true'}, 
		{field : 'supFactory',sortName : "SUP_FACTORY",title : '出货地',width : 150,align : 'center',sortable : 'true'}, 
		{field : 'unloadPort',sortName : "UNLOAD_PORT",title : '计算队列',width : 130,align : 'center',sortable : 'true'}, 
		{field : 'manuResidual',sortName : "MANU_RESIDUAL",title : '手工调整余量',width : 130,align : 'center',sortable : 'true'}, 
		{field : 'codeValueNameC',sortName : "codeValueNameC",title : '导入状态',width : 100,align : 'center',sortable : 'true',
			 formatter:function(value,row,index){
				if('未导入' == value){
					return '<span style="color:red;">未导入</span>';
				}else if('已导入' == value){
					return '<span style="color:green;">已导入</span>';
				}
				return value;
			} 
		},
		{field : 'codeValueNameB',sortName : "codeValueNameB",title : '校验结果',width : 130,align : 'center',sortable : 'true',
			 formatter:function(value,row,index){
				if('有错误' == value){
					return '<span style="color:red;">有错误</span>';
				}else if('正确' == value){
					return '<span style="color:green;">正确</span>';
				}
			} 
		},
		{field : 'checkInfo',sortName : "checkInfo",title : '校验信息',width : 300,align : 'center',sortable : 'true'}
		 ] ]
	}));
}
</script>