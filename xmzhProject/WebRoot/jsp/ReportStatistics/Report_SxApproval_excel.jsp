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
	<th height="34" width="100" align="center" class="form_label"  rowspan="3">一级支行</th>
		<th height="34" width="100" align="center" class="form_label"  rowspan="3">二级支行</th>
		<th height="34" width='<b:write property="sxApprovalReportTitleList.size()*200" />' align="center" class="form_label" rowspan="1"   colspan='<b:write property="sxApprovalReportTitleList.size()*2" />' >列出所有一级分类</th>
		 
	
	</tr>
	<tr height="34">
	 <l:iterate property="sxApprovalReportTitleList" id="id1">
			<th height="34"  width="200" align="center" class="form_label"  rowspan="1"   colspan="2">
			<b:write iterateId="id1" property="oneCategory" />
			</th>
		</l:iterate>
	</tr>
	<tr height="34">
	     <l:iterate property="sxApprovalReportTitleList" id="id2">
		<th  height="34" width="100" align="center" class="form_label">
			笔数
	      </th>
	      <th  height="34" width="100" align="center" class="form_label" >
			金额
		</th>
		</l:iterate>
		</tr>
	<l:iterate property="sxApprovalReportList" id="id5">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id5">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id5" property="ORGNAMEONE"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id5" property="ORGNAMETWO"/>
			  </td>
		     <l:iterate property="sxApprovalReportTitleList" id="id4">
			   <td>
			  <b:write iterateId="id5" property='${id4.oneCategoryNum }' />
			  </td>
			   <td>
			   <b:write iterateId="id5" property='${id4.oneCategoryMoney }' />
			  </td>
			</l:iterate>
			</tr>
	</l:iterate>
		</table>
   