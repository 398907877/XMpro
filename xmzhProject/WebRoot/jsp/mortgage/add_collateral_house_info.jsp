<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>添加押品</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/mortgage/mortgageReserveAction_addCollateral.action"  enctype="multipart/form-data" method="post" >
		<h:hidden id="id" property="mortgageReserveRes.warrantsId"  />
	    <h:hidden id="mortgageType"  property="mortgageReserveRes.mortgageType"/>
		<table align="center" border="0" width="100%" class="form_table">
			  <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		抵质押品信息
	          </td>
	        </tr>
			<tr>	
				<td class="form_label" align="right" width="15%">产权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNo"   property="mortgageReserveHouse.propertyNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyName"   property="mortgageReserveHouse.propertyName" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">产权人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyCardNo"   property="mortgageReserveHouse.propertyCardNo" validateAttr="allowNull=false;maxLength=18;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权地址：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyAddres"   property="mortgageReserveHouse.propertyAddres" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">产权证本数：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNums"  size="5"  property="mortgageReserveHouse.propertyNums" validateAttr="allowNull=false;type=naturalNumber;maxLength=5;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="17%">产权证填发日期：</td>
				<td colspan="1" width="30%">
				<w:date id="propertyDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd"  readonly="true" property="mortgageReserveHouse.propertyDate" />
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
				alert("添加失败请联系管理员！");
			}
		};
		
		$("#data_form").ajaxSubmit(options);
	}

	  
</script>
</body>
</html>