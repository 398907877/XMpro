<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/fileDownWarrants.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>扫描件上传</title>
</head>
<script type="text/javascript">
//清空
function clears(){
	$("#scanType").val("");
	//清空JSP页面时间控件显示的值
	//$("#inTimeStart_input").val("");	
	//$("#inTimeEnd_input").val("");

	
	$id("operationTime").value="";
	
	$("#operationTime_input").val("");
	//清空传入后台的时间控件的值
	//$name("upload").value = "";
	$name("scan.operationTime").value = "";

	// 删除tabtest里所有行
	var tb=document.getElementById("tabtest");
	var i="";
	var rowNum=tb.rows.length;
    for (i=0;i<rowNum;i++)
    {
        tb.deleteRow(i);
        rowNum=rowNum-1;
        i=i-1;
    };
	
}


var rowId = 0;
function addFile(tabid,varName){
    var tab,row,td,fName,fId,tdStr;
    var zs=$("#tabtest tbody tr").length;
    tab = $id(tabid);
    if (zs>=10){
    	alert("新增扫描件不能超过10个");
    	return false;
    }
    fName = varName;
    fId = varName+rowId;
    row =  tab.insertRow();
    row.id = "fileRow"+rowId;
    td = row.insertCell(); 
    
    tdStr="<input type=\"file\" name=\""+fName+"\" id=\""+fId+"\" onchange=\"CheckUpLoadFile(this,2);\" size='70' class=smallInput validateAttr=\"allowNull=false\">";
    tdStr += "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
    td.innerHTML = tdStr;
    rowId = rowId+1;    
}


  function delTr(id){
	$("#"+id).remove();
  }

	/*
	 * 功能：图片上传
	 */
	function scanImport(){
		
		if($id("operationTime").value =="" ||$id("operationTime").value==null){
			alert('请选择操作日期');
			return;

		}
		if( $name("upload") ==null){
			alert('请选择你要导入的扫描件');
			return;
		}
		var frm = $id("importFormForType");
		var excelFile = $name("upload").value;
		
		
		//alert(excelFile);
		if (excelFile=="") {
			alert('请选择你要导入的扫描件');
			return;
		}
		
		excelFile = excelFile.substr(excelFile.lastIndexOf("\\") + 1);
		frm.action = "/mortgage/scanManagementAction_addScan.action";
		frm.submit();

		clears();
	}

</script>
<body leftmargin="0" rightmargin="0" topmargin="0">
<h:form id="importFormForType" name="importFormForType" method="post" enctype="multipart/form-data" target="tempFrame">
	<table align="center" border="0" width="100%" class="form_table">
		
			 <tr>
				<td class="form_label" align="right" width="30%">
					操作日期：
				</td>
				<td class="form_label" style="text-align: left;">
					<w:date format="yyyy-MM-dd"submitFormat="yyyyMMdd" id="operationTime" name="scan.operationTime" property="scan.operationTime" />
				</td>
			</tr>
			 
			<tr> 
				<td class="form_label" align="right" width="30%">
					扫描件种类：
				</td>
				<td class="form_label" style="text-align: left;">
					<d:select id="scanType" dictTypeId="SCAN_TYPE" name="scan.scanType" property="scan.scanType"  style="width:150px"></d:select>
				</td>
			</tr>
			<!-- <tr>
				<td class="form_label" align="center" width="30%">
					扫描文件：
				</td>
				<td class="form_label" style="text-align: left;">
					<input type="file" name="upload" multiple="multiple">
					<font style="color: red">(说明：最多上传10张照片)</font>
					
				</td>
			</tr>-->
			<tr id="rowFile">
		     	<td class="form_label" align="right">上传扫描件：</td>
		     	<td colspan="3">
						<input type="button" onclick="addFile('tabtest','upload');return false;" value="新增扫描件" 
							style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
						<font style="color: red">(说明：最多上传10个扫描件)</font>
						<br/>
						<table border=0 id="tabtest">
						</table>
		     	</td>
		     </tr>
			<tr>
				<td colSpan="4" align="center">
					<input class="button" type="button" value='上传' onclick="scanImport();"/><!-- 导入 -->
					<input class="button" type="button" value='清空' onclick="clears();"/><!-- 重置 -->
				</td>
			 </tr>
		</table>
		<iframe id="tempFrame" name="tempFrame" style="display: none;"></iframe>
	</h:form>
	<br>
</body>
</html>