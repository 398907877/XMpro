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
	        <tbody id="dzypxx_fc">
			<tr>	
				<td class="form_label" align="right" width="15%">产权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNo"   property="mortgageReserveHouse.propertyNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyName"   property="mortgageReserveHouse.propertyName" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">产权人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyCardNo"   property="mortgageReserveHouse.propertyCardNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权地址：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyAddres"   property="mortgageReserveHouse.propertyAddres" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">产权证本数：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNums"  size="5"  property="mortgageReserveHouse.propertyNums" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="17%">产权证填发日期：</td>
				<td colspan="1" width="30%">
				<w:date id="propertyDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="mortgageReserveHouse.propertyDate" />
				</td>					
			</tr>
			</tbody>
			<tbody id="dzypxx_jdc" style="display:none">
			<tr>	
				<td class="form_label" align="right" width="15%">车主姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="carName"   property="mortgageReserveCar.carName" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车主身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carCardNo"   property="mortgageReserveCar.carCardNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">机动车登记证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carRegisterNo"   property="mortgageReserveCar.carRegisterNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车牌号：</td>
				<td colspan="1" width="30%">
				<h:text id="carNo"   property="mortgageReserveCar.carNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">车架号：</td>
				<td colspan="1" width="30%">
				<h:text id="carFrameNo"   property="mortgageReserveCar.carFrameNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">购车发票号：</td>
				<td colspan="1" width="30%">
				<h:text id="carInvoiceNo"   property="mortgageReserveCar.carInvoiceNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">完税证明号：</td>
				<td colspan="1" width="30%">
				<h:text id="carDuesNo"   property="mortgageReserveCar.carDuesNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">保单号：</td>
				<td colspan="1" width="30%">
				<h:text id="carSafeNo"   property="mortgageReserveCar.carSafeNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			</tbody>
			<tr>
				<td colspan="4" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
			
		</table>
	</h:form>
<script type="text/javascript">

 window.onload = function () {
     var parWin = window.dialogArguments;
     $id("mortgageType").value=parWin;
          init(parWin);

        };
        
function init(val){
        if(val=="0"){
	        $("#dzypxx_fc").show();
	        $("#dzypxx_jdc").hide();
	       }else if(val=="1"){
	        $("#dzypxx_jdc").show();
	        $("#dzypxx_fc").hide();
	       }
}
	function save(){
	   var frm=$name("data_form");
	   if($id("mortgageType").value == "0"){
		   if($id("propertyNo").value == ""){
				alert("产权证号不能为空！");
				$id("propertyNo").focus();
				return;
			}
			
		   if($id("propertyName").value == ""){
				alert("产权人姓名不能为空！");
				$id("propertyName").focus();
				return;
			}
			
		   if($id("propertyCardNo").value == ""){
				alert("产权人身份证号不能为空！");
				$id("propertyCardNo").focus();
				return;
			}
			if($id("propertyAddres").value == ""){
				alert("产权地址不能为空！");
				$id("propertyAddres").focus();
				return;
			}
			if($id("propertyNums").value == ""){
				alert("产权证本数不能为空！");
				$id("propertyNums").focus();
				return;
			}
		}else if($id("mortgageType").value == "1"){
		   if($id("carName").value == ""){
				alert("车主姓名不能为空！");
				$id("carName").focus();
				return;
			}
			if($id("carCardNo").value == ""){
				alert("车主身份证号不能为空！");
				$id("carCardNo").focus();
				return;
			}
			if($id("carRegisterNo").value == ""){
				alert("机动车登记证号不能为空！");
				$id("carRegisterNo").focus();
				return;
			}
			if($id("carNo").value == ""){
				alert("车牌号不能为空！");
				$id("carNo").focus();
				return;
			}
			if($id("carFrameNo").value == ""){
				alert("车架号不能为空！");
				$id("carFrameNo").focus();
				return;
			}
			if($id("carInvoiceNo").value == ""){
				alert("购车发票号不能为空！");
				$id("carInvoiceNo").focus();
				return;
			}
			if($id("carDuesNo").value == ""){
				alert("完税证明号不能为空！");
				$id("carDuesNo").focus();
				return;
			}
			if($id("carSafeNo").value == ""){
				alert("保单号不能为空！");
				$id("carSafeNo").focus();
				return;
			}
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