<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin1/component.jsp" %>
<%@page import="java.util.*"%>
<h:css href="/css/style1/style-custom.css"/>
<%
	//获取标签中使用的国际化资源信息
	String dict_import  = com.eos.foundation.eoscommon.ResourcesMessageUtil.getI18nResourceMessage("DictManager_l_dict_type_import");  //业务字典导入
	String dict_item_label  = com.eos.foundation.eoscommon.ResourcesMessageUtil.getI18nResourceMessage("DictManager_l_dict_item_import");  //业务字典导入
%>
<html>
<head>
<title><b:message key="DictManager_l_dict_import"></b:message><b:message key="OperatorManager_l_manager"></b:message></title><!-- 业务字典导入管理 -->
</head>
<script language="JavaScript" type="text/javascript">
//清空
function clears(){
	$("#scanType").val("");
	//清空JSP页面时间控件显示的值
	$("#inTimeStart_input").val("");
	$("#inTimeEnd_input").val("");
	//清空传入后台的时间控件的值
	$name("upload").value = "";

	
	//$(':input','#scanQuery').not(':button,:submit,#pageLeng')
	//.val("")
	//.removeAttr("checked");
	
}

	/*
	 * 功能：图片上传
	 */
	function dictImportForType(){
		var frm = $id("importFormForType");
		var excelFile = $name("upload").value;
		if (excelFile=="") {
			alert('请选择你要导入的扫描件');
			return;
		}
		var fileType="";
		if (excelFile.lastIndexOf(".")!=-1) {
			fileType = (excelFile.substring(excelFile.lastIndexOf("."),excelFile.length)).toLowerCase();
			var re= /.jpg$/;
			if (!re.test(fileType))
			{
				alert('请选择JPG文件');
				return;
			}
		}else{
			alert('文件出现异常，请重试');
			return;
		}
		
		excelFile = excelFile.substr(excelFile.lastIndexOf("\\") + 1);
		frm.action = "/mortgage/scanManagementAction_addScan.action";
		frm.submit();
	}

	/*
	  * 功能：初始化页面
	  */
     function custInit(){
     	//初始化页面按钮样式
     	initButtonStyle();
     }
</script>
<body leftmargin="0" rightmargin="0" topmargin="0">
	<!-- 业务字典导入 -->
	<table align="center" border="0" width="100%" class="form_table">
		<tr>
			<td  colSpan="4" class="eos-panel-title">
				扫描件上传
			</td>
		</tr>
		<h:form id="importFormForType" action="/mortgage/scanManagementAction_addScan.action" method="post" enctype="multipart/form-data" target="tempFrame">
			<!-- <tr>
				<td class="form_label" align="center" width="30%">
					操作日期：
				</td>
				<td class="form_label" style="text-align: left;">
					<w:date format="yyyy-MM-dd"submitFormat="yyyyMMdd" id="operationTime" name="scan.operationTime" property="scan.operationTime" />
				</td>
			</tr>
			 -->
			<tr>
				<td class="form_label" align="center" width="30%">
					扫描件种类：
				</td>
				<td class="form_label" style="text-align: left;">
					<d:select id="scanType" dictTypeId="SCAN_TYPE" name="scan.scanType" property="scan.scanType" nullLabel="请选择" style="width:150px"></d:select>
				</td>
			</tr>
			<tr>
				<td class="form_label" align="center" width="30%">
					扫描文件：
				</td>
				<td class="form_label" style="text-align: left;">
					<input type="file" name="upload" size="60" multiple="multiple"><font style="color: red;">*请上传合适的JPG照片</font>
				</td>
			</tr>
			<tr>
				<td colSpan="4" align="center">
					<input class="button" type="button" value='上传' onclick="dictImportForType();"/><!-- 导入 -->
					<input class="button" type="button" value='清空' onclick="clears();"/><!-- 重置 -->
				</td>
			 </tr>
		</h:form>
		<iframe id="tempFrame" name="tempFrame" style="display: none;"></iframe>
	</table>
	<br>
</body>
</html>
<script>
	//初始化页面按钮样式
    eventManager.add(window,"load",custInit);
</script>