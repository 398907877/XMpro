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
		<th height="34" width="100" align="center" class="form_label">他项类型</th>
		<th height="34" width="100" align="center" class="form_label">库存序号</th>
		<th height="34" width="100" align="center" class="form_label">贷款种类</th>
		<th height="34" width="100" align="center" class="form_label">他项权证号</th>
		<th height="34" width="200" align="center" class="form_label">借款人</th>
		<th height="34" width="100" align="center" class="form_label">库存状态</th>
		
	</tr>
	<l:iterate property="mortgageReserveList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<d:write  iterateId="id1" dictTypeId="OTHER_TYPE_VIEW" property="otherType"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="projectNumber"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write  iterateId="id1" dictTypeId="LOAN_TYPE_VIEW" property="loanType"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="otherWarrantsNumber"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="borrowerName"/>
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <d:write  iterateId="id1" dictTypeId="MORTGAG_STATUS" property="status"/>
			  </td>
			  
			</tr>
			</l:iterate>
		</table>
   