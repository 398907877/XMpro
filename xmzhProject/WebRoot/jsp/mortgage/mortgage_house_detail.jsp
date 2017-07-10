<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>房产的出入库明细表</title>
    
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
  
   <!-- 房产明细表-->
   <div id="houseDetail" class="divList">
    <w:panel width="100%" title="房产的出入库明细列表">
    <viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
  	<h:form name="houseDetailForm" id="houseDetailForm" action="/mortgage/mortgageReserveHouseAction_queryMortgageQueryInOutForDetail.action" method="post">
		<h:hiddendata property="page"  />
	     <table class="EOS_table" width="100%" style="overflow:scroll">
	     <tbody id="house_detail">
		<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">流水号</th>
		  <th nowrap="nowrap">操作时间</th>
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">库存序号</th>
		  <th nowrap="nowrap">产权证号</th>
		  <th nowrap="nowrap">产权人</th>
		  <th nowrap="nowrap">他项权证号</th>
		  <th nowrap="nowrap">操作人员</th>
		  <th nowrap="nowrap">交接人员</th>
		  <th nowrap="nowrap">备注</th>
		</tr>
		<w:radioGroup id="group1">
			<l:iterate property="mortgageHouseDetailLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="id"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingTime"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="projectNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyNo"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="otherWarrantsNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingUserId"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="nextName"/></nobr>
			    </div>
			  </td>
			   <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingRemark"/></nobr>
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
		      </tbody>
		      
	      </table>
	   </h:form>
	   </viewlist>
   </w:panel>
   </div>
   
   <script type="text/javascript">
   		
   	
   </script>
  </body>
</html>
