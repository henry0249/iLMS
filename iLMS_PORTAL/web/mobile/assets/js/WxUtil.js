var HtUtil={};
/**
 * 设置缓存。
 */
HtUtil.set=function(key,value){
	localStorage[key]=value;
}

/**
 * 获取缓存
 */
HtUtil.get=function(key){
	return localStorage[key];
}

/**
 * 删除缓存
 */
HtUtil.clean=function(key){
	localStorage.rmStorage(key);
}

/**
 * 设置缓存，value 为JSON对象。
 */
HtUtil.setJSON=function(key,value){
	var json=JSON.stringify(value)
	localStorage[key]=json;
}

/**
 * 根据键获取json对象。
 */
HtUtil.getJSON=function(key){
	var json=localStorage[key];
	if(json==undefined) return null;
	return JSON.parse(json);
}

HtUtil.getParameters=function(){
	var locUrl =decodeURI( window.location.search.substr(1));
	var aryParams=locUrl.split("&");
	var json={};
	for(var i=0;i<aryParams.length;i++){
		var pair=aryParams[i];
		var aryEnt=pair.split("=");
		var key=aryEnt[0];
		var val=aryEnt[1];
		if(json[key]){
			json[key]=json[key] +"," + val;
		}
		else{
			json[key]=val;
		}
		return json;
	}
}

/**
 * 根据参数名称，获取上下文中的参数。
 */
HtUtil.getParameter=function(name){
	var locUrl = decodeURI( window.location.search.substr(1));
	var aryParams=locUrl.split("&");
	var rtn="";
	for(var i=0;i<aryParams.length;i++){
		var pair=aryParams[i];
		var aryEnt=pair.split("=");
		var key=aryEnt[0];
		var val=aryEnt[1];
		if(key!=name) continue;
		if(rtn==""){
			rtn=val;
		}
		else{
			rtn+="," + val;
		}
	}
	return rtn;
}




/**
 * 构造popupDialog
 * @param url 远程访问地址
 * @param dialogId dialog类型 eg:orgDialog,UserDialog
 */
function createPopupDialog(conf,dialogId){
	var title=conf.title || "对话框";
	var iframeId ="dialogId_"+Math.random(1000);
	conf.iframeId = iframeId;
	
	var dialog =$("#"+dialogId);
	 /*已经存在重新创建。手机端不考虑弹出框再弹出*/
	/*var scope = dialog.jiframe[0].contentWindow.getData(); 或者不消除拿到scope恢复回显数据**/
	if(dialog.length>0){
		dialog.remove();
	}
	//将html 添加至页面中
	var w=window.innerWidth;
	var h=window.innerHeight-50;
	var iframe ='<iframe  src="'+conf.url+'" id="'+iframeId+'" style="height:'+h+'px;width:'+w+'px;border:none;"></iframe>';
	var popup ='<div class="popup" tabindex="-1" id="'+dialogId+'">\
	  				<div class="am-modal-dialog">\
					<header class="bar bar-nav">\
						<a href="#" class="pull-right close-popup fa fa-close icon-button"></a>\
						<span class="title">'+title+'</span>\
				    </header>\
	    			<div class="content">\
					'+iframe+'\
				    </div>\
				  </div>\
				</div>';
	
	$(".page").after(popup);
	
	var popupDialog =$.popup($("#"+dialogId));
	//赋值
	conf.closeDialog=function(){$.closeModal(popupDialog)};
	document.getElementById(iframeId).contentWindow.dialogConf=conf;
}

$(function(){
	$.ajaxSetup({complete:function(xhr, status){
		if(xhr&&xhr.responseText  ){
			var obj=eval("("+xhr.responseText+")");
			if(obj!=undefined && obj.cause=="nologin"){
				var url=__ctx +"/weixin/login.html";
				
				createPopupDialog({url:url},"loginFormDialog");
			}
		}
	}
	});
});

Date.prototype.Format = function(fmt){ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "h+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 

// 登陆
var toLogin = function(){
	window.location.href = __ctx+'/mobile/login.html';
}


/**
 * 外部JS和angular 交互类。
 * 主要包括两个方法：
 * 1.获取当前上下文的scope。
 * 2.设置修改后的scope。
 */
var AngularUtil={};

/**
 * 获取当前Angularjs scope 。
 */
AngularUtil.getScope=function(){
	return angular.element($("[ng-controller]")[0]).scope();
}

/**
 * 保存外部js对scope的修改。
 */
AngularUtil.setData=function(scope){
	!scope.$$phase && scope.$digest();
};


/**
 * 获取当前环境中的 service
 * serviceName：指定的服务名称。
 * 这里需要注意的是，只能获取当前ng-controller注入模块中的service。
 */
AngularUtil.getService = function(serviceName){
	if(!this.$injector){
		this.$injector =angular.element($("[ng-controller]")).injector();
	}
	if(this.$injector.has(serviceName)) {
		return this.$injector.get(serviceName);
	}
	else {
		alert(serviceName+"angular环境中没有找到该service！");
	}
};
/**
 * 根据jquery表达式获取指定元素上的控件值。
 * 比如:获取id为 userId的控件的值。
 * var userId=CustForm.getModelVal("#userId");
 */
AngularUtil.getModelVal = function(element){
	var inputCtrl = $(element).data("$ngModelController");
	return inputCtrl.$modelValue;
};