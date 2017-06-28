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
		<!-- <th height="34" width="100" align="center" class="form_label">流水号</th> -->
		<th height="34" width="100" align="center" class="form_label">操作时间</th>
		<th height="34" width="100" align="center" class="form_label">出入库</th>
		<th height="34" width="100" align="center" class="form_label">操作事项</th>
		<th height="34" width="100" align="center" class="form_label">库存序号</th>
		<th height="34" width="100" align="center" class="form_label">产权证号</th>
		<th height="34" width="100" align="center" class="form_label">产权人</th>
		<th height="34" width="100" align="center" class="form_label">产权证数</th>
		<th height="34" width="100" align="center" class="form_label">他项权证数</th>
		<th height="34" width="200" align="center" class="form_label">他项权证号</th>
		<th height="34" width="100" align="center" class="form_label">操作人员</th>
		<th height="34" width="100" align="center" class="form_label">交接人员</th>
	   <th height="34" width="100" align="center" class="form_label">备注</th>	
	</tr>
	<l:iterate property="mortgageLists" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			 <!-- <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="id"/>
			  </td> -->
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="operatingTime"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" dictTypeId="MORTGAGE_OUT_IN" property="type"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" dictTypeId="OPERATING_MORTGAGE_TYPE" property="operatingMatters"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="projectNumber" />
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="propertyNo"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="propertyName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="propertyNums"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="otherWarrantsNums"/>
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="otherWarrantsNumber"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="operatingUserId"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="nextName"/>
			  </td>
			<td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="operatingRemark"/>
			  </td> 
			</tr>
			</l:iterate>
		</table>
   