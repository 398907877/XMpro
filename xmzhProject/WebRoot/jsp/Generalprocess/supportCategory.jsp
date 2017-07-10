<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/fileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<title>受理调查</title>

  </head>
  <body>
   <%--  <h:form name="appQuery"	action="/jbpm/tProcessConfigAction_queryMyProcessList.action" method="post">
		<w:panel id="panel1" title="我的流程">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="20%">流程名称：</td>
					<td colspan="1"  width="30%"><h:text id="processName" property="processConfig.processName" /></td>
				</tr>
				<tr class="form_bottom">
						<td colspan="4" class="form_bottom">
							每页显示
							<h:text size="2" property="page.length" value="10"
								validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
							<input type="hidden" name="page.begin" value="0">
							<input type="hidden" name="page.isCount" value="true">
							<input type="submit" id="btn" class="button" value='查询'>
						</td>
					</tr>				
			</table>
		</w:panel>
	</h:form> --%>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="查询结果">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
					<table>
						 <h:hidden id="cdtypeJson" property="cdtypeJson" name="cdtypeJson"/>
						<tr>
						<td>
							<d:checkbox perrow="3" id="oneCategory"    name="generalprocessDto.oneCategory" dictTypeId="PROCESS_pay" property="generalprocessDto.oneCategory"  seperator=","  />
						</td>
						</tr>
						<tr>
						<td align="center">
						<input type="button" class="button" value="选择" onclick="returnValue();"/>
						<input type="button" class="button" value="全选" onclick="chooseall();"/>
						<input type="button" class="button" value="清空" onclick="clearall();"/>
						</td>
						</tr>
					</table>
					<div class="h3"> 
						
					</div>
				</viewlist>
			</w:panel>		
		</DIV>
  </body>
  <script type="text/javascript">
  
			$(function() {
				//当页面加载完成的时候，自动调用该方法
				window.onload = function() {
					//获得所要回显的值，此处为：100,1001,200,1400
					var checkeds = $id("cdtypeJson").value;
					//拆分为字符串数组
					var checkArray = checkeds.split(", ");
					//获得所有的复选框对象
					var checkBoxAll = $("input[name='generalprocessDto.oneCategory']");
					for ( var i = 0; i < checkArray.length; i++) {
						//获取所有复选框对象的value属性，然后，用checkArray[i]和他们匹配，如果有，则说明他应被选中
						$.each(checkBoxAll, function(j, checkbox) {
							//获取复选框的value属性
							var checkValue = $(checkbox).val();
							if (checkArray[i] == checkValue) {
								$(checkbox).attr("checked", true);
							}
						})
					}
				};
			});
			function returnValue() {
				
				var oneCategory = "";
				var oneCategoryTxt = "";
				var plugInLength = $("input[name='generalprocessDto.oneCategory']:checkbox:checked").length;
				$(
						"input[name='generalprocessDto.oneCategory']:checkbox:checked")
						.each(
								function(i, value) {
									if ($(this).attr("checked")) {
										if ((i + 1) == plugInLength) {
											oneCategory += $(this).val();
										} else {
											oneCategory += $(this).val() + ", ";
										}
										if ((i + 1) == plugInLength) {
											oneCategoryTxt += $(this).next(
													'label').text();
										} else {
											oneCategoryTxt += $(this).next(
													'label').text()
													+ ", ";
										}
									}
								});
				var rvalue = oneCategory + ":" + oneCategoryTxt;
				window.returnValue = rvalue;
				window.close();
			}
			  function chooseall(){
				  $("input[name='generalprocessDto.oneCategory']:checkbox").each(function(){ 
			          $(this).attr("checked",true);
			      });	
				  }
			  function clearall(){
				  $("input[name='generalprocessDto.oneCategory']:checkbox").each(function(){ 
			          $(this).attr("checked",false);
			      });	
				  }
		</script>
</html>
