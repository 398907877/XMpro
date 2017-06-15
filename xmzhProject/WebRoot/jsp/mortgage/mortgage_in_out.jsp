<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/commonUtil.js"></script>
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/js/org_public.js"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>出入库查询</title>
  </head>
  
  <body>
   <h:form name="appQuery"	action="/mortgage/mortgageReserveHouseAction_queryMortgageInOut.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="result_flag" property="result_flag"  value="1"/>
				<tr>
				<td class="form_label" align="right">押品类型：</td>
					<td >
						<d:select id="mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE" name="mortgageList.mortgageType" property="mortgageList.mortgageType" onchange= "changeMortgageType(this.value)" style="width:80px;">	
						</d:select>
					</td>
					<td class="form_label" align="right" width="20%">开始时间：</td>
					<td colspan="1"  width="30%">
					从<w:date format="yyyy-MM-dd"submitFormat="yyyyMMdd" id="d1" name="mortgageList.operatingTime" property="mortgageList.operatingTime" />
					到
					<w:date format="yyyy-MM-dd"submitFormat="yyyyMMdd" id="d2" name="mortgageList.operatingEndTime" property="mortgageList.operatingEndTime" />
					</td>
					<td class="form_label" align="right">出入库：</td>
					<td >
						<d:select id="operatingType" dictTypeId="MORTGAGE_OPERATING" name="mortgageList.operatingType" style="width:80px;">
						</d:select>
					</td>
				</tr>
				<tr>
				   
					<td class="form_label" align="right">操作事项：</td>
					<td >
						<d:select id="operatingMatters" dictTypeId="OPERATING_MORTGAGE_TYPE" property="mortgageList.operatingMatters" name="mortgageList.operatingMatters"  style="width:80px;">
							
						</d:select>
					</td>
					<td class="form_label" align="right">注销是否完成：</td>
					<td >
					<!-- 状态：正常，注销 -->
					<!-- <input type="hidden" id="status" name="mortgageList.status"> -->
						<d:select id="status" dictTypeId="MORTGAG_STATUS" property="mortgageList.status" value="全部" onchange= "changeCheckSign(this.value)" style="width:80px;">
							
						</d:select>
					</td>
					
				</tr>
				    
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="统计" class="button">
							<input type="button" value="明细" class="button" onclick="detail();">
							<input type="button" value="汇总导出" class="button" onclick="totalDownExl();">
							<input type="button" value="明细导出" class="button" onclick="detailDownExl();">
							<input type="button" value="退出" class="button" onclick="clears();">
						</td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<!-- 房产汇总表 -->
	<div id="houseTotalQuery" class="divList">
    <w:panel width="100%" title="库存查询列表">
    <viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
  	<h:form name="houseTotalQueryForm"  id="houseTotalQueryForm" action="/mortgage/mortgageReserveHouseAction_queryMortgageInOut.action" method="post">
		<h:hiddendata property="mortgageList"/>
		
		 <h:hidden property="page.begin"/>
		 <h:hidden property="page.length"/>
		 <h:hidden property="page.count"/>
		 <h:hidden property="page.isCount"/>
	     <table class="EOS_table" width="100%" style="overflow:scroll">
	     <tbody id="tj_fc">
		<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">记录数</th>
		  <th nowrap="nowrap">产权证数</th>
		  <th nowrap="nowrap">他项权证数</th>
		</tr>
			<l:iterate property="mortgageLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="alls"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyNums"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyNums"/></nobr>
			    </div>
			  </td>
			  
			</tr>
			</l:iterate>
		 
		      </tbody>
		      <tbody id="tj_jdc" style="display:none">
		<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">记录数</th>
		  <th nowrap="nowrap">机动车数</th>
		  <th nowrap="nowrap">他项权证数</th>
		</tr>
			<l:iterate property="mortgageLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="alls"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="cars"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="others"/></nobr>
			    </div>
			  </td>
			  
			</tr>
			</l:iterate>
		 
		      </tbody>
		      <tr>
		        <td colspan="9" class="command_sort_area">
	              <div class="h4">
	                <l:equal property="page.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                  <b:write property="page.totalPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page.isCount" targetValue="false" >
	                  <b:message key="l_NO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'houseTotalQueryForm');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'houseTotalQueryForm');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'houseTotalQueryForm');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'houseTotalQueryForm');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
		        </td>
		      </tr>
	      </table>
	   </h:form>
	   </viewlist>
   </w:panel>
   </div>
  
			
			 <!-- 房产明细表-->
   <div id="houseDetail" class="divList">
    <w:panel width="100%" title="房产的出入库明细列表">
    <viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
  	<h:form name="houseDetailForm" id="houseDetailForm" action="/mortgage/mortgageReserveHouseAction_queryMortgageQueryInOutForDetail.action" method="post">
		<h:hiddendata property="mortgageList"/>
		
		 <h:hidden property="page.begin"/>
		 <h:hidden property="page.length"/>
		 <h:hidden property="page.count"/>
		 <h:hidden property="page.isCount"/>
	     <table class="EOS_table" width="100%" style="overflow:scroll">
	     <tbody id="house_detail">
		<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">流水号</th>
		  <th nowrap="nowrap">操作时间</th>
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">库存序号</th>
		  <th nowrap="nowrap">产权证号</th>
		  <th nowrap="nowrap">产权人</th>
		  <th nowrap="nowrap">他项权证号</th>
		  <th nowrap="nowrap">操作人员</th>
		  <th nowrap="nowrap">交接人员</th>
		  <th nowrap="nowrap">备注</th>
		</tr>
		<w:radioGroup id="group1">
			<l:iterate property="mortgageLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="id"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingTime"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="projectNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyNo"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="otherWarrantsNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingUserId"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="nextName"/></nobr>
			    </div>
			  </td>
			   <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingRemark"/></nobr>
			    </div>
			  </td>
			</tr>
			</l:iterate>
		</w:radioGroup>
		 
		      </tbody>
		      <tbody id="car_detail">
		      	<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">流水号</th>
		  <th nowrap="nowrap">操作时间</th>
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">库存序号</th>
		  <th nowrap="nowrap">车牌号</th>
		  <th nowrap="nowrap">车主姓名</th>
		  <th nowrap="nowrap">操作人员</th>
		  <th nowrap="nowrap">交接人员</th>
		  <th nowrap="nowrap">备注</th>
		</tr>
			<l:iterate property="mortgageLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="id"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingTime"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="projectNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="carNo"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="carName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingUserId"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="nextName"/></nobr>
			    </div>
			  </td>
			   <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingRemark"/></nobr>
			    </div>
			  </td>
			</tr>
			</l:iterate>
		 
		      </tbody>
		      <!-- 房产明细外借情况 -->
		      <tbody id="house_detail1">
		      	<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">流水号</th>
		  <th nowrap="nowrap">操作时间</th>
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">库存序号</th>
		  <th nowrap="nowrap">产权证号</th>
		  <th nowrap="nowrap">产权人</th>
		  <th nowrap="nowrap">外借数量</th>
		  <th nowrap="nowrap">外借是否归还</th>
		  <th nowrap="nowrap">他项权证号</th>
		  <th nowrap="nowrap">操作人员</th>
		  <th nowrap="nowrap">交接人员</th>
		  <th nowrap="nowrap">备注</th>
		</tr>
			<l:iterate property="mortgageLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="id"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingTime"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="projectNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyNo"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="propertyName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="borrowerNum"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="isBorrow"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="otherWarrantsNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingUserId"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="nextName"/></nobr>
			    </div>
			  </td>
			   <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingRemark"/></nobr>
			    </div>
			  </td>
			</tr>
			</l:iterate>
		
		      </tbody>
		      <!-- 机动车明细外借情况 -->
		      <tbody id="car_detail1">
		      	<tr>
		 <!--  <th><b:message key="l_select"></b:message></th> -->
		  <th nowrap="nowrap">流水号</th>
		  <th nowrap="nowrap">操作时间</th>
		  <th nowrap="nowrap">出入库</th>
		  <th nowrap="nowrap">操作事项</th>
		  <th nowrap="nowrap">库存序号</th>
		  <th nowrap="nowrap">车牌号</th>
		  <th nowrap="nowrap">车主姓名</th>
		  <th nowrap="nowrap">外借数量</th>
		  <th nowrap="nowrap">外借是否归还</th>
		  <th nowrap="nowrap">操作人员</th>
		  <th nowrap="nowrap">交接人员</th>
		  <th nowrap="nowrap">备注</th>
		</tr>
			<l:iterate property="mortgageLists" id="issued">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;width: 20%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="id"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingTime"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingType"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingMatters"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="projectNumber"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="carNo"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="carName"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="borrowerNum"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="isBorrow"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingUserId"/></nobr>
			    </div>
			  </td>
			  <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="nextName"/></nobr>
			    </div>
			  </td>
			   <td style="text-align: center;width: 10%">
			    <div style="padding:0px;overflow:hidden" nowrap>
			    	<nobr><b:write iterateId="issued" property="operatingRemark"/></nobr>
			    </div>
			  </td>
			</tr>
			</l:iterate>
		 
		      </tbody>
		     <tr>		
              <td colspan="23" class="command_sort_area">
							
              <div class="h4">
	                <l:equal property="page.isCount" targetValue="true" >
	                  <b:message key="l_total"></b:message>
	                  <b:write property="page.count" />
	                  <b:message key="l_recordNO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>/
	                  <b:write property="page.totalPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page.isCount" targetValue="false" >
	                  <b:message key="l_NO."></b:message>
	                  <b:write property="page.currentPage" />
	                  <b:message key="l_page"></b:message>
	                </l:equal>
	                <l:equal property="page.isCount" targetValue="true">
		                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'houseDetailForm');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'houseDetailForm');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'houseDetailForm');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                  	<input type="button" class="button" onclick="lastPage('page', '', null, null, 'houseDetailForm');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              
              
              </td>
            </tr>
	      </table>
	   </h:form>
	   </viewlist>
   </w:panel>
   </div>

		<script type="text/javascript">
	
	$(document).ready(function(){ 

			//result_flag用于区别是普通查询('1') 还是 汇总查询('2')
			var result_flag = $id("result_flag").value;
			var options=$("#mortgageType option:selected");  //获取选中的项
			var operatingMatters=$("#operatingMatters option:selected");  //获取选中的项
			if(result_flag == '1'){ //默认为1
				$("#houseTotalQuery").attr("style","display:block");
				$("#houseDetail").attr("style","display:none");
				if(options.val()=='1'){
			     $("#tj_fc").show();
			     $("#tj_jdc").hide();
			    }else if(options.val()=='2'){
			     $("#tj_jdc").show();
			     $("#tj_fc").hide();
			    }
			}else{
				$("#houseTotalQuery").attr("style","display:none");
				$("#houseDetail").attr("style","display:block");
				if(options.val()=='1'&&operatingMatters.val()!='1'){
				    $("#house_detail").show();
				    $("#house_detail1").hide();
				    $("#car_detail").hide();
				    $("#car_detail1").hide();
			    }
			    if(options.val()=='1'&&operatingMatters.val()=='1'){
			      	$("#house_detail1").show();
				    $("#car_detail").hide();
				    $("#house_detail").hide();
				    $("#car_detail1").hide();
			    }
			    if(options.val()=='2'&&operatingMatters.val()!='1')
			    {
			    	$("#car_detail").show();
				    $("#house_detail1").hide();
				    $("#house_detail").hide();
				    $("#car_detail1").hide();
			    }
			    if(options.val()=='2'&&operatingMatters.val()=='1')
			    {
			    	$("#car_detail1").show();
				    $("#house_detail1").hide();
				    $("#house_detail").hide();
				    $("#car_detail").hide();
			    }
			}
			
		}); 
	var options=$("#mortgageType option:selected");  //获取选中的项
	// alert(options.val());
	 if(options.val()=="1"){
	     $("#tj_fc").show();
	     $("#tj_jdc").hide();
	     
	    }else if(options.val()=="2"){
	     $("#tj_jdc").show();
	     $("#tj_fc").hide();
	    }

	//抵押类型改变事件
	    function changeMortgageType(val){
	    if(val=="1"){
	     $("#tj_fc").show();
	     $("#tj_jdc").hide();
	    }else if(val=="2"){
	     $("#tj_jdc").show();
	     $("#tj_fc").hide();
	    }
	    }
			
      
		//清空
		function clears(){
			$("#d1_input").val("");
			$("#d2_input").val("");
			$("#status").val("");
			
			$id("d1").value="";
			$id("d2").value="";
			$id("status").value="0";
		}
		
		//汇总导出
		function totalDownExl(){
			//var result_flag = $id("result_flag").value;
			var options=$("#mortgageType option:selected");  //获取选中的项
			var operatingMatters=$("#operatingMatters option:selected");  //获取选中的项
			var operatingTime=$id("d1").value;  //获取选中的项
			var operatingEndTime=$id("d2").value;  //获取选中的项
			var status=$("#status option:selected"); //获取选中的项
				
			alert("汇总导出");
			var strUrl="/mortgage/mortgageReserveHouseAction_queryMortgageTotalInOutForExcel.action?";
			if(options.val()!=null)
			{
			    strUrl=strUrl+"&mortgageList.mortgageType="+options.val();
			}
			if(operatingMatters.val()!=null)
			{
			    strUrl=strUrl+"&mortgageList.operatingMatters="+operatingMatters.val();
			}
			if(operatingTime!=null)
			{
			    strUrl=strUrl+"&mortgageList.operatingTime="+operatingTime;
			}
			if(operatingEndTime!=null)
			{
			    strUrl=strUrl+"&mortgageList.operatingEndTime="+operatingEndTime;
			}
			if(status.val()!=null)
			{
			    strUrl=strUrl+"&mortgageList.status="+status;
			}	
			window.location.href=strUrl;
		}
		//明细导出
		function detailDownExl(){
			
			var options=$("#mortgageType option:selected");  //获取选中的项
			var operatingMatters=$("#operatingMatters option:selected");  //获取选中的项
			var operatingTime=$id("d1").value;  //获取选中的项
			var operatingEndTime=$id("d2").value;  //获取选中的项
			var status=$("#status option:selected");  //获取选中的项

			var strUrl="/mortgage/mortgageReserveHouseAction_queryMortgageDetailInOutForExcel.action?";
			if(options.val()!=null)
			{
			   	strUrl=strUrl+"&mortgageList.mortgageType="+options.val();
			}
			if(operatingMatters.val()!=null)
			{
			   	strUrl=strUrl+"&mortgageList.operatingMatters="+operatingMatters.val();
			}
			if(operatingTime!=null)
			{
			    strUrl=strUrl+"&mortgageList.operatingTime="+operatingTime;
			}
			if(operatingEndTime!=null)
			{
			    strUrl=strUrl+"&mortgageList.operatingEndTime="+operatingEndTime;
			}
			if(status.val()!=null)
			{
			    strUrl=strUrl+"&mortgageList.status="+status;
			}
			window.location.href=strUrl;       		      		    		
	
		}

		//明细
		function detail()
		{
			var frm = $name("appQuery");
			frm.action="/mortgage/mortgageReserveHouseAction_queryMortgageQueryInOutForDetail.action";
			frm.submit();
		 }
			
		</script>
		
  </body>
</html>