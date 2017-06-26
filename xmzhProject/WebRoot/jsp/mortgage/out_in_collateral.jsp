<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>出入库处理</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/mortgage/mortgageReserveAction_outInCollateral.action"  enctype="multipart/form-data" method="post" >
		<h:hidden id="id" property="mortgageReserveOut.warrantsId"  />
		<h:hidden id="operatingId" property="mortgageReserveOut.operatingId"  />
		<h:hidden id="outInType" property="mortgageReserveOut.outInType"  />
		<h:hidden id="logRemark" property="mortgageReserveOut.logRemark"  />
		<table align="center" border="0" width="100%" class="form_table">
			<tr>	
				<td class="form_label" align="right" width="30%">操作事项：</td>
				<td colspan="1" width="60%">
				<d:select id="operatingMatters" dictTypeId="OPERATING_MORTGAGE_TYPE"  property="mortgageReserveOut.operatingMatters"  nullLabel="请选择" extAttr="validateAttr='allowNull=false'" /><font style="color: red">*</font>
				</td>			
			</tr>
			<tr>
				<td class="form_label" align="right" width="30%">交接人：</td>
				<td colspan="1" width="60%">
				<h:text id="nextName"   property="mortgageReserveOut.nextName" validateAttr="allowNull=false;"/><font style="color: red">*</font>
				<d:select id="proNextName" dictTypeId="MORTGAGE_NEXT_NAME"  property="mortgageReserveOut.proNextName" nullLabel="合作岗" onchange="changeNextNmae(this.value)"   />
				</td>					
			</tr>
			<tbody id="out_log">
			<tr>			
				<td class="form_label" align="right" width="30%">外借数量：</td>
				<td colspan="1" width="60%">
				<h:text id="borrowerNums" size="5"  property="mortgageReserveOut.borrowerNums" validateAttr="allowNull=false;type=naturalNumber;"/><font style="color: red">*</font>
				</td>				
			</tr>
			</tbody>
			<tbody id="in_log" style="display: none">
			<tr>			
				<td class="form_label" align="right" width="30%">外借数量：</td>
				<td colspan="1" width="60%">
				<b:write  property="mortgageReserveOut.insertTime" />&nbsp;&nbsp;<d:write  dictTypeId="OPERATING_MORTGAGE_TYPE" property="mortgageReserveOut.inBorrowerLogInfo"/>&nbsp;&nbsp;<b:write  property="mortgageReserveOut.inBorrowerNums" />本
				</td>				
			</tr>
			</tbody>
			<!-- 
			<tbody id="out_log">
			<tr>			
				<td class="form_label" align="right" width="30%">出库记录：</td>
				<td colspan="1" width="60%">
				<d:select id="outBorrowerLog" dictTypeId="OUT_BORROWER_LOG"  property="mortgageReserveOut.outBorrowerLog"   nullLabel="请选择" />
				</td>				
			</tr>
			</tbody>
			<tbody id="in_log" style="display: none">
			<tr>			
				<td class="form_label" align="right" width="30%">入库记录：</td>
				<td colspan="1" width="60%">
				<d:select id="inBorrowerLog" dictTypeId="IN_BORROWER_LOG"  property="mortgageReserveOut.inBorrowerLog"   nullLabel="请选择" />
				</td>				
			</tr>
			 -->
			</tbody>
			<tr>
				<td class="form_label" align="right" width="15%">备注信息：</td>
				<td colspan="3" width="30%">
				<h:textarea rows="5"  cols="30"   property="mortgageReserveOut.remark" />
				</td>					
			</tr>
			<tr>
				<td colspan="4" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
			
		</table>
	</h:form>
<script type="text/javascript">
 window.onload = function () {
     var param=$id("outInType").value;
         init(param);
        };


	function init(val){
	       if(val=="1"){
	        $("#out_log").show();
	        $("#in_log").hide();
	       }else if(val=="2"){
	       $("#operatingMatters option[value='3']").remove(); 
	       $("#operatingMatters option[value='4']").remove(); 
	       $("#borrowerNums").val("0"); 
	        $("#in_log").show();
	        $("#out_log").hide();
	       }
	  
	
	}
function changeNextNmae(param){
  if(param!="产权人"){
    $("#nextName").val(param);
  }else{
    $("#nextName").val("");
  }
}
function save(){
	 var frm=$name("data_form");
	   
	if(!checkForm(frm)){
			 return ;
		 }
		ajaxsubmitO();
		
	}


	function ajaxsubmitO() {
		maskTop();
		var options = {
			type : "post",
			cache : "false",
			success : function(data) {
				try {
					if (data.indexOf("success") >= 0) {
						alert("保存成功!");
						unMaskTop();
						window.close();
					} else if (data.indexOf("fails") >= 0) {
						alert("保存失败!");
					} else {
						alert("操作失败!");
					}
				} catch (Exception) {
				}
			},
			error : function(data) {
				alert("出库失败请联系管理员！");
			}
		};
		
		$("#data_form").ajaxSubmit(options);
	}
</script>
</body>
</html>