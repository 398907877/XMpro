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
				<td class="form_label" align="right" width="15%">车主姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="carName"   property="mortgageReserveCar.carName" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车主身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carCardNo"   property="mortgageReserveCar.carCardNo" validateAttr="allowNull=false;maxLength=18;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">机动车登记证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carRegisterNo"   property="mortgageReserveCar.carRegisterNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车牌号：</td>
				<td colspan="1" width="30%">
				<h:text id="carNo"   property="mortgageReserveCar.carNo" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">车架号：</td>
				<td colspan="1" width="30%">
				<h:text id="carFrameNo"   property="mortgageReserveCar.carFrameNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">购车发票号：</td>
				<td colspan="1" width="30%">
				<h:text id="carInvoiceNo"   property="mortgageReserveCar.carInvoiceNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">完税证明号：</td>
				<td colspan="1" width="30%">
				<h:text id="carDuesNo"   property="mortgageReserveCar.carDuesNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">保单号：</td>
				<td colspan="1" width="30%">
				<h:text id="carSafeNo"   property="mortgageReserveCar.carSafeNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
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
		var carRegisterNo= $id("carRegisterNo").value;  //机动车登记证号
	    $.ajax({
			      url: "/mortgage/mortgageReserveAction_checkCarRegisterNo.action",
			      async: false,
			      type: 'post',
			      data: "mortgageReserveCar.carRegisterNo="+carRegisterNo,
			      timeout: 60000,
			      success: function (data) {
					   if (data.indexOf("noExist") >= 0) {
				    		  ajaxsubmitO();
						} else if (data.indexOf("carfails") >= 0) {
			                 $id("carRegisterNo").focus();	
							alert("操作失败！机动车登记证号("+carRegisterNo+")系统中号码重复！请重新填写！");
						} else if (data.indexOf("fails") >= 0) {
							alert("机动车登记证号校验失败！");
						} else {
							alert("操作失败!");
						}
			      
			      }
			}); 
		
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