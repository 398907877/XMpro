<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>贷种分类列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="贷种分类列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/timeLimitManageAction_queryLoanCategorylist2.action" method="post">
					<%-- <h:hidden property="page.begin" />
					<h:hidden property="page.length" />
					<h:hidden property="page.count" />
					<h:hidden property="page.isCount" /> --%>
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								贷种分类
							</th>
						</tr>
					<w:checkGroup id="group1">
                          <l:iterate property="proLoanBeans" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="15%">
								<w:rowCheckbox>
										<h:param name='loanCategory_name' iterateId='id1' property='loanCategory_name' />
									</w:rowCheckbox>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory_name" />
								</td>
							</tr>
						</l:iterate>
					</w:checkGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
								&nbsp; &nbsp;
							<l:greaterThan property="proLoanBeans.size" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="选择"   onclick="my_select();" />
									</l:greaterThan>
									<input type="button" class="button" value="返回"   onclick="window.close();" />
							</div>
							<%-- <div class="h4">
	                <l:equal property="page.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                  <b:write property="page.totalPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page.isCount" targetValue="false" >
	                  <b:message key="l_NO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'page_form');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div> --%>
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">

		//选择	
	  	function my_select(){
	  		var g = $id("group1");
	  		var len = g.getSelectLength();
		      if (len==0 ) {
		        alert("请选择一条记录！");
		        return; 
		      }else{

		        	var rows=g.getSelectRows();
		  			var objects="";
		  			for(var i=0;i<rows.length;i++){
		  				objects += rows[i].getParam("loanCategory_name")+", ";  //分隔符为：逗号+一个空格
		  			}
		  			if(objects!=""){
		  				objects=objects.substring(0,objects.length-2);  //将最后一个逗号和空格去掉
	        	
			        }
		       }
		   
		  	  window.returnValue=[objects];
		  	  window.close();
		  	  
		 }

		</script>
	</body>
</html>