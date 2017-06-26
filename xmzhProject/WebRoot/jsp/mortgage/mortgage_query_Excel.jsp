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
	<!-- 
		<th height="34" width="100" align="center" class="form_label">他项类型</th>
		<th height="34" width="100" align="center" class="form_label">库存序号</th>
		<th height="34" width="100" align="center" class="form_label">贷种</th>
		<th height="34" width="100" align="center" class="form_label">他项权证号</th>
		<th height="34" width="200" align="center" class="form_label">借款人</th>
		<th height="34" width="100" align="center" class="form_label">库存状态</th>
	 -->
	 <th height="34" width="100" align="center" class="form_label">他项权限号</th>
		<th height="34" width="100" align="center" class="form_label">贷款种类</th>
		<th height="34" width="100" align="center" class="form_label">借款人姓名 </th>
		<th height="34" width="100" align="center" class="form_label"> 借款人身份证号</th>
		<th height="34" width="100" align="center" class="form_label">借款合同号</th>
		<th height="34" width="200" align="center" class="form_label">产权人姓名</th>
		<th height="34" width="100" align="center" class="form_label">产权证号码</th>
		<th height="34" width="100" align="center" class="form_label">入库时间</th>
		<th height="34" width="100" align="center" class="form_label">补登记标志</th>
	</tr>
	<l:iterate property="mortgageReserveHouseList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <!--  <td style="vnd.ms-excel.numberformat:@">
			    	<d:write iterateId="id1" dictTypeId="OTHER_TYPE_VIEW" property="otherType"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="projectNumber"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write iterateId="id1" dictTypeId="LOAN_TYPE_VIEW"  property="loanType"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="otherWarrantsNumber"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="borrowerName" />
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" dictTypeId="MORTGAG_STATUS" property="status"/>
			  </td>-->
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="otherWarrantsNumber"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<d:write iterateId="id1" dictTypeId="LOAN_TYPE_VIEW"  property="loanType"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="borrowerName"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="borrowerCardNo"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="borrowerContractno"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="propertyName"/>
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="propertyNo"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="insertTime"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			   <d:write iterateId="id1" property="noRegisterSign" dictTypeId="MORTGAG_REGISTER"/>
			  </td>
			</tr>
			</l:iterate>
		</table>
   