<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>超限情况统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/jbpm/xdProcessAction_queryXdStartProcessList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                                         
                                  
					<td class="form_label" align="right">报表：</td>
					
			  
                                     <td align="left"  >
                            
                                     <select   name="ym" size="1" id="ym" style="width:120px;" onchange="window.location.href=this.options[selectedIndex].value">  
                           <option>请选择</option>  
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_ErrorCondition.jsp" target="_blank">差错情况统计表</option>    
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_DealApproval.jsp"   target="_self">受理审批台账</option>  
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_Jobworkload.jsp"   target="_self">岗位工作量统计表</option>  
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_Rateofreturn.jsp"   target="_self">退单率统计表</option> 
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_Refusalrate.jsp"   target="_self">拒贷率统计表</option> 
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_CooperateInstitution.jsp"   target="_self">合作机构业务发展台账</option> 
                           <option   value="http://localhost:8088/jsp/ReportStatistics/Report_OverrunCondition.jsp"   target="_self">超限情况统计表</option> 
                           </select> 
                           </td>
					
					
					
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                        <input id="downexl" type="submit" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="超限情况统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/xdProcessAction_queryXdStartProcessList.action" method="post">
			 <h:hiddendata property="xdProcessTaskAssignee"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							
							<th nowrap="nowrap">
								时间
							</th>
							<th nowrap="nowrap">
								超限环节
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								机构
					       </th>
					       <th nowrap="nowrap">
								超限人员
							</th>
                                                 <th nowrap="nowrap">
								超限时长
							</th>
                                                 <th nowrap="nowrap">
								备注
							</th>
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="xdProcessTaskAssignees" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowRadio>
										<h:param name='executionId' iterateId='id1' property='executionId' />
										<h:param name='processName' iterateId='id1' property='processName' />
										<h:param name='custName' iterateId='id1' property='custName' />
										<h:param name='apply_bal' iterateId='id1' property='apply_bal' />
										<h:param name='oneCategory' iterateId='id1' property='oneCategory' />
										<h:param name='loanCategory' iterateId='id1' property='loanCategory' />
										<h:param name='coorganization' iterateId='id1' property='coorganization' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="apply_bal" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="coorganization" />
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改超限情况信息" onclick="upt_loan_info();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看修改明细" onclick="queryLoanUptWater();"/>
								</l:greaterThan>
								</div>
							
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
	                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
	                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                <l:equal property="page.isCount" targetValue="true">
	                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'page_form');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">

		//清空
		function clears(){
			$id("custName").value="";
			$id("oneCategory").value="";
			$id("oneCategoryId").value="";
			$id("loanCategory").value="";
			$id("loanCategoryId").value="";
		}
                function search(){
			$("#isExport").val("");
			}
                function downExl() {
			$("#isExport").val("1");
		}
		
		function upt_loan_info(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
		  		var executionId = row.getParam("executionId");
		  		var processName = row.getParam("processName");
		  		var custName = row.getParam("custName");
		  		var apply_bal = row.getParam("apply_bal");
		  		var oneCategory = row.getParam("oneCategory");
		  		var loanCategory = row.getParam("loanCategory");
		  		var coorganization = row.getParam("coorganization");

	            var strUrl = "/jbpm/xdProcessAction_toUptLoanInfo.action?xdProcessTaskAssignee.executionId="+executionId+"&xdProcessTaskAssignee.processName="+processName;
	            strUrl = strUrl+"&xdProcessTaskAssignee.custName="+custName
	            +"&xdProcessTaskAssignee.apply_bal="+apply_bal
	            +"&xdProcessTaskAssignee.oneCategory="+oneCategory
	            +"&xdProcessTaskAssignee.loanCategory="+loanCategory
	            +"&xdProcessTaskAssignee.coorganization="+coorganization;
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改超限情况信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改超限情况信息');*/	
			}
		}
		function callBack(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
			}

	  	function queryLoanUptWater(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var executionId = rows.getParam("executionId");
		  		var strUrl = "/jbpm/xdProcessAction_queryLoanUptWater.action?waterInfo.flow_id="+executionId;
		  		showModalCenter(strUrl,'',null ,1200,500,'超限情况修改流水明细');
			  	}
		  	}

	  	function showoneCategory() {
			var oneCategoryId=document.getElementById("oneCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_oneCategoryDic.action?cdtypeJson="+oneCategoryId,
			showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); 
		} 
		function showoneCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("oneCategoryId").value = array[0];
			 document.getElementById("oneCategory").value = array[1];
			}
		}	

		function showloanCategory() {
			var loanCategoryId=document.getElementById("loanCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategoryId,
			showModalCenter(strUrl,'',showloanCategory_callback1 ,800,500,'贷种选择'); 
		} 
		function showloanCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("loanCategoryId").value = array[0];
			 document.getElementById("loanCategory").value = array[1];
			}
		}
		</script>
		
	</body>
</html>