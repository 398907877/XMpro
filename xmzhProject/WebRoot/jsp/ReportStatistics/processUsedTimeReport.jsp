<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>激活流程用时临时表统计表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/processUsedTimeReportAction_processUsedTimeReport.action" method="post">
			<table align="center" border="0" width="100%" class="form_table">
				
				
				
				<tr class="form_bottom">
						<td colspan="10" class="form_bottom">
							<input id="querys" type="button" value="激活" class="button" onclick="search();">
					</tr>			
					
			</table>
	</h:form>
	<DIV class="divList">
				
					
                   <b:write  property="reslut" />
           
		</DIV>
		<script type="text/javascript">

	
            function search(){
            	var frm = $name("appQuery");
                frm.submit();
			}
	
		</script>
		
	</body>
</html>