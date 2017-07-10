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
		<th height="34" width="100" align="center" class="form_label">一级支行</th>
		<th height="34" width="100" align="center" class="form_label">二级支行</th>
		<th height="34" width="100" align="center" class="form_label">一级分类</th>
		<th height="34" width="100" align="center" class="form_label">贷种分类</th>
		<th height="34" width="200" align="center" class="form_label">时限类型</th>
		<th height="34" width="100" align="center" class="form_label">1天处理单数</th>
		<th height="34" width="100" align="center" class="form_label">2天处理单数</th>
		<th height="34" width="100" align="center" class="form_label">3天以上处理单数</th>
		
	</tr>
	<l:iterate property="processUsedTimeReportList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="orgNameOne"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="orgNameTwo"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="oneCategory"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="loanCategory"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <d:write  iterateId="id1" dictTypeId="TIME_LIMIT_TYPE" property="timeLimitType"/>
			  </td>
			    <td>
			   <b:write iterateId="id1" property="onedaysDealNum"/>
			  </td>
			   <td>
			   <b:write iterateId="id1" property="twodaysDealNum"/>
			  </td>
			   <td>
			   <b:write iterateId="id1" property="threedaysDealNum"/>
			  </td>
			</tr>
			</l:iterate>
		</table>
   