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

		<!-- <th height="34" width="100" align="center" class="form_label">序号</th> -->
		<th height="34" width="100" align="center" class="form_label">外借时间</th>
		<th height="34" width="100" align="center" class="form_label">库存序号</th>
		<th height="34" width="100" align="center" class="form_label">车牌号</th>
		<th height="34" width="100" align="center" class="form_label">车主</th>
		<th height="34" width="100" align="center" class="form_label">外借数量</th>
		<th height="34" width="100" align="center" class="form_label">交接人</th>
		<th height="34" width="200" align="center" class="form_label">经办支行</th>
		<th height="34" width="100" align="center" class="form_label">经办客户经理</th>
		<th height="34" width="100" align="center" class="form_label">已借天数</th>
		<th height="34" width="100" align="center" class="form_label">是否超限</th>
		<th height="34" width="100" align="center" class="form_label">备注</th>
	</tr>
	<l:iterate property="loanInfoList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			 <!--  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="loanID"/>
			  </td> -->
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="checkTime"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="repertoryID"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="licensePlateNumber"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="owners"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="checkNums" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="borrowerNextName" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgnaizationBranch"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="orgnaizationCustomerManager"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="alreadyLoanDay"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <d:write iterateId="id1" property="whetherOverrun" dictTypeId="MORTGAGE_OVERRUN_TYPE"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="remark"/>
			  </td>
			</tr>
			</l:iterate>
		</table>
   