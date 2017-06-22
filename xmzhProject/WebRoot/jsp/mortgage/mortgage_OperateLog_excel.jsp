<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://eos.primeton.com/tags/logic" prefix="l"%>
<%@ taglib uri="http://eos.primeton.com/tags/bean" prefix="b"%>
<%@ taglib uri="http://eos.primeton.com/tags/dict" prefix="d"%>
<%@ taglib uri="http://eos.primeton.com/tags/html" prefix="h"%>
<%@page import="com.gotop.util.time.TimeUtil"%>
<%
	response.setContentType("application/x-msdownload;charset=UTF-8");
	//设置Excel的名称;	
	String date = TimeUtil.today()+TimeUtil.now();
	response.setHeader("Content-Disposition",
			"attachment; filename=\""+date+".xls\"");
	out.flush();
%>
<table width="98%" border="1" cellspacing="1" cellpadding="1">
	<tr height="34">

		<th height="34" width="100" align="center" class="form_label">操作时间</th>
		<th height="34" width="100" align="center" class="form_label">部门</th>
		<th height="34" width="100" align="center" class="form_label">操作人员</th>
		<th height="34" width="100" align="center" class="form_label">操作类型</th>
		<th height="34" width="100" align="center" class="form_label">操作内容(权证内容)</th>
		<!-- <th height="34" width="100" align="center" class="form_label">备注</th> -->
	</tr>
	<l:iterate property="mortgageLogList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="operateTime"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="orgName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="empName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" property="operateType" dictTypeId="MORTGAGE_OPERATING_TYPE"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="operateContent"/>
			  </td>
			  <!-- 
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="remark" />
			  </td>
			   -->
			</tr>
			</l:iterate>
		</table>
   