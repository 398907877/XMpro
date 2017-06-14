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
		<th height="34" width="100" align="center" class="form_label">产权证数</th>
		<th height="34" width="200" align="center" class="form_label">他项权证数</th>
		<th height="34" width="100" align="center" class="form_label">操作</th>
	</tr>
	<l:iterate property="mortgageLists" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="operatingType"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="otherWarrantsNums"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="borrowerLog"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="propertyNums"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="propertyNums" />
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="operator"/>
			  </td>
			</tr>
			</l:iterate>
		</table>
   