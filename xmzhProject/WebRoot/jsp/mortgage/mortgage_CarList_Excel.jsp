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
		<th height="34" width="100" align="center" class="form_label">入库时间</th>
		<th height="34" width="100" align="center" class="form_label">他项类型</th>
		<th height="34" width="100" align="center" class="form_label">库存序号</th>
		<th height="34" width="100" align="center" class="form_label">他项权证号</th>
		<th height="34" width="100" align="center" class="form_label">他项登记日期</th>
		<th height="34" width="100" align="center" class="form_label">借款人姓名</th>
		<th height="34" width="100" align="center" class="form_label">借款人身份证</th>
		<th height="34" width="100" align="center" class="form_label">经办机构</th>
		<th height="34" width="100" align="center" class="form_label">经办客户经理</th>
		<th height="34" width="100" align="center" class="form_label">贷款种类</th>
		<th height="34" width="100" align="center" class="form_label">借款合同号</th>
		<th height="34" width="100" align="center" class="form_label">贷款年限</th>
		<th height="34" width="100" align="center" class="form_label">入账价值</th>
		<th height="34" width="100" align="center" class="form_label">封包编号</th>
		<th height="34" width="100" align="center" class="form_label">交接人</th>
		<th height="34" width="100" align="center" class="form_label">购房合同号</th>
		<th height="34" width="100" align="center" class="form_label">备注信息</th>
		<th height="34" width="100" align="center" class="form_label">补登记标志</th>
		<th height="34" width="100" align="center" class="form_label">库存状态</th>
		<th height="34" width="100" align="center" class="form_label">注销后抵质押品状态</th>
		<th height="34" width="100" align="center" class="form_label">车主姓名</th>
		<th height="34" width="100" align="center" class="form_label">车主身份证号</th>
		<th height="34" width="100" align="center" class="form_label">机动车登记证号</th>
		<th height="34" width="100" align="center" class="form_label">车牌号</th>
		<th height="34" width="100" align="center" class="form_label">车架号</th>
		<th height="34" width="100" align="center" class="form_label">购车发票号</th>
		<th height="34" width="100" align="center" class="form_label">完税证明号</th>
		<th height="34" width="100" align="center" class="form_label">保单号</th>
		
	</tr>
	<l:iterate property="mortgageReserveList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write  iterateId="id1"  property="INSERTTIME"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<d:write  iterateId="id1" dictTypeId="OTHER_TYPE_VIEW" property="OTHERTYPE"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="PROJECTNUMBER"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="OTHERWARRANTSNUMBER"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="OTHERWARRANTSDATE"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="BORROWERNAME"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="BORROWERCARDNO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="ORGNAME"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="MANGERNAME"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <d:write  iterateId="id1" dictTypeId="LOAN_TYPE_VIEW" property="LOANTYPE"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="BORROWERCONTRACTNO"/>
			  </td>
			   <td >
			     <b:write iterateId="id1" property="LOANYEARS"/>
			  </td>
			   <td >
			     <b:write iterateId="id1" property="RECORDVALUE"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="PACKETNUMBER"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="NEXTNAME"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="PURCHASENUMBER"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1" property="REMARK"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <d:write iterateId="id1" dictTypeId="MORTGAG_REGISTER"  property="NOREGISTERSIGN" />
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <d:write  iterateId="id1" dictTypeId="MORTGAG_STATUS" property="STATUS"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <d:write iterateId="id1" dictTypeId="AFTER_MORTGAGE_STATUS"  property="AFTER_MORTGAGE_STATUS"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARNAME"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARCARDNO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARREGISTERNO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARNO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARFRAMENO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARINVOICENO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARDUESNO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="CARSAFENO"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			     <b:write iterateId="id1"  property="RN"/>
			  </td>
			  
			</tr>
			</l:iterate>
		</table>
   