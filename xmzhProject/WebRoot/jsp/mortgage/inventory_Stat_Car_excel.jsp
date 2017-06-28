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
  <!-- 
	<tr height="34">

		<th height="34" width="100" align="center" class="form_label">统计日期</th>
		<th height="34" width="100" align="center" class="form_label">押品类型</th>
		<th height="34" width="100" align="center" class="form_label">权证种类</th>
		<th height="34" width="100" align="center" class="form_label" colspan="2">贷种/他项类型</th>
		<th height="34" width="100" align="center" class="form_label">数量</th>
		<th height="34" width="100" align="center" class="form_label">合计</th>
	</tr>
	<l:iterate property="inventoryStatList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />">
			  <td style="vnd.ms-excel.numberformat:@" rowspan="14"> 
					<b:write iterateId="id1" property="statTime" />
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="10"> 
					房产
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="8"> 
					他项
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="4"> 
					零售
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					不动产抵押权
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num1" />
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="8"> 
					<b:write iterateId="id1" property="total1" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@"> 
					不动产登记预告
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num2" />
				</td>
			</tr>
			
		   <tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@"> 
					预告登记证明
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num3" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			    <td style="vnd.ms-excel.numberformat:@"> 
					小计
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num4" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" rowspan="4"> 
					小企业
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					不动产抵押权
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num5" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" > 
					不动产登记预告
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num6" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" > 
					预告登记证明
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num7" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" > 
					小计
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num8" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			    <td style="vnd.ms-excel.numberformat:@" rowspan="2"> 
					产权证
				</td>
				<td style="vnd.ms-excel.numberformat:@" colspan="2"> 
					零售
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num9" />
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="2"> 
					<b:write iterateId="id1" property="total2" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" colspan="2"> 
					小企业
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num10" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" rowspan="4"> 
					机动车
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="2"> 
					他项
				</td>
				<td style="vnd.ms-excel.numberformat:@" colspan="2"> 
					汽车消费
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num11" />
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="2"> 
					<b:write iterateId="id1" property="total3" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" colspan="2"> 
					经营性车辆
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num12" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" rowspan="2"> 
					机动车登记
				</td>
				<td style="vnd.ms-excel.numberformat:@" colspan="2"> 
					汽车消费
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num13" />
				</td>
				<td style="vnd.ms-excel.numberformat:@" rowspan="2"> 
					<b:write iterateId="id1" property="total4" />
				</td>
			</tr>
			<tr class="<l:output evenOutput='EOS_table_row' />">
			 <td style="vnd.ms-excel.numberformat:@" colspan="2"> 
					经营性车辆
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num14" />
				</td>
			</tr>
			</l:iterate>
			  -->
		<!-- 	 
			 <tr height="34">

		<th height="34" width="100" align="center" class="form_label">统计日期</th>
		<th height="34" width="100" align="center" class="form_label">押品类型</th>
		<th height="34" width="100" align="center" class="form_label">他项类型</th>
		<th height="34" width="100" align="center" class="form_label">贷款种类</th>
		<th height="34" width="100" align="center" class="form_label">数量</th>
	</tr>
	<l:iterate property="inventoryStatList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />">
			  <td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="statTime" />
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<d:write iterateId="id1" property="mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE"/>
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<d:write iterateId="id1" property="otherType" dictTypeId="OTHER_TYPE_VIEW"/>
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<d:write iterateId="id1" property="loanType" dictTypeId="LOAN_TYPE_VIEW"/>
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="num" />
				</td>
			</tr>
			</l:iterate>
			 -->
			 <tr height="34">

		<th height="34" width="100" align="center" class="form_label">统计日期</th>
		<th height="34" width="100" align="center" class="form_label">押品类型</th>
		<th height="34" width="100" align="center" class="form_label">权证种类</th>
		<th height="34" width="100" align="center" class="form_label">贷款种类</th>
	<!-- 	<th height="34" width="100" align="center" class="form_label">他项类型</th> -->
		<th height="34" width="100" align="center" class="form_label">数量</th>
	</tr>
	<l:iterate property="inventoryStatList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />">
			  <td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="statTime" />
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="mortgageType" />
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="warrantsType" />
				</td>
				<td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="loanType" />
				</td>
				<!-- <td style="vnd.ms-excel.numberformat:@"> 
					<b:write iterateId="id1" property="otherType" />
				</td> -->
				<td> 
					<b:write iterateId="id1" property="num" />
				</td>
			</tr>
			</l:iterate>
		</table>
   