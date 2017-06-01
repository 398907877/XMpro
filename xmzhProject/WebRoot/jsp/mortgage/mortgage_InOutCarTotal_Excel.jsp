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
		<th height="34" width="100" align="center" class="form_label">出入库</th>
		<th height="34" width="100" align="center" class="form_label">操作事项</th>
		<th height="34" width="100" align="center" class="form_label">记录数</th>
		<th height="34" width="100" align="center" class="form_label">机动车数</th>
		<th height="34" width="200" align="center" class="form_label">他项权证数</th>
	</tr>
	<l:iterate property="mortgageLists" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<d:write iterateId="id1" dictTypeId="MORTGAGE_OUT_IN" property="type"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<d:write iterateId="id1" dictTypeId="OPERATING_MORTGAGE_TYPE" property="operatingMatters"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="alls"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="cars"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="others" />
			</tr>
			</l:iterate>
		</table>
   