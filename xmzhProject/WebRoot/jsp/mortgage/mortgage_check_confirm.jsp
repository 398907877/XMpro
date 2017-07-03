<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>补登记确认</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <h:form name="appQuery" id="appQuery" action="" method="post">
     <h:hidden name="mortgageReserveHouseCar.warrantsId" property="mortgageReserveHouseCar.warrantsId" id="warrantsId"/>
		<center>
		<br/>
		<table border="0">
		<tr>	
		   <td class="form_label" align="right" width="15%">产权人姓名：</td>
				<td colspan="1" width="30%">
				${mortgageReserveHouseCar.propertyName} 
				<!--<h:text id="propertyName"   property="mortgageReserveHouseCar.propertyName" readonly="true"/>-->
				</td>
			<td class="form_label" align="right" width="15%">产权证号：</td>
				<td colspan="1" width="30%">
				${mortgageReserveHouseCar.propertyNo}
			<!--  	<h:text id="propertyNo"   property="mortgageReserveHouseCar.propertyNo" readonly="true"/>-->
				</td>	
									
			</tr>
		<tr>
		<td colspan="4" style="text-align: center"><input id="querys" type="button" value="确认" class="button" onclick="confirm();">
		<input id="cancel" type="button" value="退出" class="button" onclick="window.close();">
		</td>
		</tr>
		
		</table>
		</center>
	</h:form>
	
	<script type="text/javascript">
		function confirm()
		{
		//var warrantsId="aaa";
			var warrantsId = $id("warrantsId").value;
			//alert("mortgageReserveHouseCar.getWarrantsId()="+warrantsId);
			$.ajax({
			 url: "/mortgage/mortgageReserveHouseAction_noRegisterSignConfirm.action?warrantsId="+warrantsId,
		      async: false,
		      type: 'post',
		     // data: "aaa="+warrantsId,
		      timeout: 60000,
		      dataType:"text",
		      success: function (data) {
		    	  try {
					if (data.indexOf("success") >= 0) {
						alert("确认成功!");
						//unMaskTop();
						//window.location.reload();
						window.close();
					} else if (data.indexOf("fails") >= 0) {
						alert("确认失败!");
					} else {
						alert("操作失败!");
					}
				} catch (Exception) {
				}
			},
			error : function(data) {
				alert("确认失败请联系管理员！");
			}
		});
		
	}
		
	</script>
  </body>
</html>
