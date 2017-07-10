<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://eos.primeton.com/tags/logic" prefix="l"%>
<%@ taglib uri="http://eos.primeton.com/tags/bean" prefix="b"%>
<%@ taglib uri="http://eos.primeton.com/tags/dict" prefix="d"%>
<%@ taglib uri="http://eos.primeton.com/tags/html" prefix="h"%>
<%@page import="com.gotop.util.time.TimeUtil"%>
<%@page import="com.gotop.reportjbpm.model.LoanRateFloatReport" %>
<%
	response.setContentType("application/x-msdownload;charset=UTF-8");
	//设置Excel的名称;	
	String date = TimeUtil.today()+TimeUtil.now();
	response.setHeader("Content-Disposition",
			"attachment; filename=\""+date+".xls\"");
	out.flush();
%>
<table width="100%" border="1" cellspacing="1" cellpadding="1">
	<tr height="34">
		<th height="34" width="200" align="center" class="form_label">放款日期</th>
		<th height="34" width="100" align="center" class="form_label">一级支行</th>
		<th height="34" width="150" align="center" class="form_label">二级支行</th>
		<th height="34" width="200" align="center" class="form_label">一级分类</th>
		<th height="34" width="200" align="center" class="form_label">贷种分类</th>
		<th height="34" width="80" align="center" class="form_label">主调信贷员</th>
		<th height="34" width="80" align="center" class="form_label">营业主管</th>
		<th height="34" width="50" align="center" class="form_label">笔数</th>
		<th height="34" width="100" align="center" class="form_label">金额</th>
		
	</tr>
	<l:iterate property="loanRateFloatReportList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' />" id="id1">
			  <td style="vnd.ms-excel.numberformat:@">
			    				<%
									LoanRateFloatReport loanRateFloatReport = (LoanRateFloatReport) request.getAttribute("loanRateFloatReport");
									if( !"".equals(loanRateFloatReport.getMakeLoansDateStart()) || !"".equals(loanRateFloatReport.getMakeLoansDateEnd() )){
									%>
										${loanRateFloatReport.makeLoansDateStart} ~ ${loanRateFloatReport.makeLoansDateEnd}
									<%
									}
									%>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="orgNameOne"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    	<b:write iterateId="id1" property="orgNameTwo"/>
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="oneCategory" />
			  </td>
			  <td style="vnd.ms-excel.numberformat:@">
			    <b:write iterateId="id1" property="loanCategory"/>
			  </td>
			   <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="creatorName"/>
			  </td>
			    <td style="vnd.ms-excel.numberformat:@">
			   <b:write iterateId="id1" property="yyzg"/>
			  </td>
			   <td>
			   <b:write iterateId="id1" property="nums"/>
			  </td>
			   <td>
			    <b:write iterateId="id1" property="amount"/>
			  </td>
			</tr>
			</l:iterate>
		</table>
   