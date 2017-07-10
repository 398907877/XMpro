<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>机动车分类汇总</title>
    
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
   <div id="hh" class="divList">
    <w:panel width="100%" title="机动车库存查询列表">
    <viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
  	<h:form name="form1" action="" method="post">
		<h:hiddendata property="page"  />
	     <table class="EOS_table" width="100%" style="overflow:scroll">
		<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">记录数</th>
		  <th nowrap="nowrap">机动车数</th>
		  <th nowrap="nowrap">他项权证数</th>
		</tr>
		<w:radioGroup id="group1">
			<l:iterate property="sendDataList" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;height: 30px;width:5%">
			  	<w:rowRadio>
	               <h:param name='id' iterateId='issued' property='dsId'/>
	               <h:param name='userId' iterateId='issued' property='dataUser'/>
	            </w:rowRadio>
			  </td>
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="dsTitle"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="sendName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="empName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="userOrg"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="userOrg"/></nobr>
			    </div>
			  </td>
			  
			</tr>
			</l:iterate>
		</w:radioGroup>
		 <tr>
		        <td colspan="9" class="command_sort_area">
		        	<div class="h3">
		          
	              </div>
	              <div class="h4">
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
              </div>
		        </td>
		      </tr>
	      </table>
	   </h:form>
	   </viewlist>
   </w:panel>
   </div>
  </body>
</html>
