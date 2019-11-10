<#setting number_format="0">
<br>
	<div class="div-block" type="subGroup" tableName="${table.name}" path="${table.path}" <#if table.relation=='onetoone'>initdata="true"</#if> ng-if="!permission.table.${table.name}.hidden">
		<div class="block-title">
			<span class="form-title">${table.desc} </span>
			<#if table.relation!='onetoone'>
				<a style="color:#fff;" href="###" class="btn-add" ng-click="add('${table.path}')" ng-if="permission.table.${table.name}.add">添加</a>
			</#if>
		</div>
		<div class="div-form" ng-repeat="item in data.${table.path} track by $index">
			<#if table.relation!='onetoone'><a class="subFieldList floatTools" ng-click="remove('${table.path}',$index)" ng-if="permission.table.${table.name}.del" >
				<span class="fa fa-delete actionBtn block-delete" title="移除"></span>
			</a></#if>
			<table class="table-form">
			<#assign index=1>
			<#list fieldList as field>
				<#if field.isSeparator && field.separatorTitle!="">
					<tr>
						<td colspan="6" class="grid-groupTitle">${field.separatorTitle}</td>
					</tr>
				</#if> 
			
				<#if index==1>
				<tr>
				</#if>
					<th width="10%" ng-if="permission.fields.${table.name}.${field.name}!='n'">${field.desc}</th>
					<td width="23%" ng-if="permission.fields.${table.name}.${field.name}!='n'" ${getColspan(index,field_has_next,field.isSeparator)}><@input field=field isSub=true/></td>
				<#if field.isSeparator==true || !field_has_next || index==3>
				</tr>
				<#assign index=0>
				</#if> 
				<#assign index=index+1>
				
				
			</#list>
			</table>
		</div>
		<div ng-if="!data.${table.path}.length &&permission.table.${table.name}.add && !permission.table.${table.name}.required" class="nodata">
			请添加 ${table.desc}数据
		</div>
		<div ng-if="permission.table.${table.name}.required && !data.${table.path}.length"  class="nodata">
			至少添加一行${table.desc}数据！
			<input type="hidden" ng-model="data.${table.path}" ht-validate="{required:true}" />
		</div>
	</div>
<br>  




<#function getColspan index,hasNext,isSeparator>
	<#assign rtn="">
		 <#if (!hasNext || isSeparator==true) && index !=3>
			<#assign rtn="colspan='"+((3-index)*2+1)+"'"> 
		</#if>
<#return rtn>
</#function> 