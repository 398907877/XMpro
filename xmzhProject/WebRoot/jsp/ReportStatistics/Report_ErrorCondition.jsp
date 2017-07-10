<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<script src="<%=request.getContextPath() %>/js/org_public.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>差错情况统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportjbpm/errorStatisticAction_queryErrorStatistic.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<h:hidden id="result_flag" property="result_flag"  value="1"/>
				<tr>
                    <td class="form_label" align="right" >报单日期：</td>
					<td colspan="1" >
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="startTime" name="errorStatistic.startTime" 
					property="errorStatistic.startTime" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="endTime" name="errorStatistic.endTime" 
					property="errorStatistic.endTime" /></td>

					<td class="form_label" align="right" >客户姓名：</td>
					<td colspan="1" ><h:text id="custName" property="errorStatistic.custName" />
					</td>
					
					<td class="form_label" align="right" >差错环节：</td>
					<td >
						<h:text id="taskName" property="errorStatistic.taskName" readonly="true" name="errorStatistic.taskName"/>
						<a href="#" onclick="showErrorlink();">选择</a>
					</td>
				</tr>
				
				<tr>	
					<td class="form_label" align="right" >一级分类：</td>
					<td >
			     		<h:hidden id="oneCategoryId" />  
						<h:text id="oneCategory" property="errorStatistic.oneCategory" readonly="true"  style="width:130px;"/>
						<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:hidden id="loanCategoryId"/>
						<h:text id="loanCategory" property="errorStatistic.loanCategory" readonly="true"   style="width:130px;"/>
						<a href="#" onclick="showloanCategory();">选择</a>
					</td>
				
				    <td class="form_label" align="right" >营业主管：</td>
					<td >
			     		<h:text id="yxzg" property="errorStatistic.yxzg" id="yxzg"  style="width:130px;" />
					</td>
				</tr>
				
				<tr>
					<td class="form_label" align="right" >一级支行：</td>
					<td>
					    <h:text id="orgNameOne" property="errorStatistic.orgNameOne" readonly="true"  style="width:130px;"/>
						<h:hidden id="orgCodeOne" property="errorStatistic.orgCodeOne" />
					    <a href="#" onclick="open_slzhej_fun(1)">选择</a>
		            </td>	
		            
		            <td class="form_label" align="right" >二级支行：</td>
					<td>
					    <h:text id="orgNameTwo" property="errorStatistic.orgNameTwo" readonly="true"  style="width:130px;"/>
						<h:hidden id="orgCodeTwo" property="errorStatistic.orgCodeTwo" />
					    <a href="#" onclick="open_slzhej_fun(2)">选择</a>
		            </td>	
		            
		            <td class="form_label" align="right" >主调信贷员：</td>
					<td>
					 <h:text property="errorStatistic.creatorName" id="creatorName" style="width:130px;" />	
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
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="excelExport();">
                            <input type="button" class="button" value="汇总查询" onclick="summaryQuery();">
                            <input type="button" class="button" value="汇总导出" onclick="summaryExport();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV id="result_div1"  class="divList"  style="overflow:auto;width:100%; height:355px;display:block">
			<w:panel id="panel" width="100%" title="差错情况统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/reportjbpm/errorStatisticAction_queryErrorStatistic.action" method="post">
			 <h:hiddendata property="errorStatistic"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table"  >
		 			
		 			<tr>
							<th nowrap="nowrap">
								一级支行
							</th>
							<th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								主调信贷员
							</th>
							<th nowrap="nowrap">
								辅调信贷员
							</th>
							<th nowrap="nowrap">
								营业主管
					       </th>
					       <th nowrap="nowrap">
								差错情况
							</th>
                           <th nowrap="nowrap">
								扣罚金额
							</th>
                            <th nowrap="nowrap">
								差错次数
							</th>
                            <th nowrap="nowrap">
								差错环节
							</th>
                             <th nowrap="nowrap">
								提出差错人
							</th>
                           <th nowrap="nowrap">
								提出差错时间
							</th>
						</tr>
                           <l:iterate property="errorStatisticList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="creatorName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="fdxdy" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="yxzg" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mistakeContent" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="punishBal" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mistakeNumber" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="taskName" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empName" />
								</td>
<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="addTime" />
								</td>

							</tr>
						</l:iterate>
					
							
					
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
		                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
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
		
		<DIV id="result_div2" class="divList" style="overflow:auto;width:100%; height:355px;display:none">
			<w:panel id="panel2" width="100%" title="差错情况汇总列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form2"
					action="/reportjbpm/errorStatisticAction_queryErrorStatisticSummary.action" method="post">
			 <h:hiddendata property="errorStatistic"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table"  >
						<tr>	
							<th nowrap="nowrap">
								一级支行
							</th>
							<th nowrap="nowrap">
								二级支行
							</th>
							<th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								客户名称
							</th>
							<th nowrap="nowrap">
								主调信贷员
							</th>
							<th nowrap="nowrap">
								辅调信贷员
							</th>
							<th nowrap="nowrap">
								营业主管
					       </th>
                            <th nowrap="nowrap">
								差错环节
							</th>
                             <th nowrap="nowrap">
								提出差错人
							</th>
                           <th nowrap="nowrap">
								差错次数
							</th>
							<th nowrap="nowrap">
								扣罚金额
							</th>
						</tr>
                           <l:iterate property="errorStatisticList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameOne" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="custName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="creatorName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="fdxdy" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="yxzg" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="taskName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empName" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mistakeNumber" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="punishBal" />
								</td>
							</tr>
						</l:iterate>
							
					
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
		                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form2');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form2');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form2');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                  	<input type="button" class="button" onclick="lastPage('page', '', null, null, 'page_form2');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
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
//初始化 页面处理
		$(document).ready(function(){ 

			//result_flag用于区别是普通查询('1') 还是 汇总查询('2')
			var result_flag = $id("result_flag").value;
			
			if(result_flag == '1'){ //默认为1
				$("#result_div1").attr("style","display:block");
				$("#result_div2").attr("style","display:none");
			}else{
				$("#result_div1").attr("style","display:none");
				$("#result_div2").attr("style","display:block");
			}
			
		}); 

		
		//清空
		function clears(){
			$id("custName").value="";
			$id("taskName").value="";
			$("#orgNameOne").val("");
			$("#orgCodeOne").val("");
			$("#orgNameTwo").val("");
			$("#orgCodeTwo").val("");
			$("#oneCategory").val("");
			$("#oneCategoryId").val("");
			$("#loanCategory").val("");
			$("#loanCategoryId").val("");
			$("#creatorName").val("");
			$("#yxzg").val("");

			//清空JSP页面时间控件显示的值
			$("#startTime_input").val("");
			$("#endTime_input").val("");

			//清空传入后台的时间控件的值
			$name("errorStatistic.startTime").value = "";
			$name("errorStatistic.endTime").value = "";
			
		}
           function search(){
			  $("#isExport").val("");
			}

    		//导出excel 	
             function excelExport(){
    				//报单开始日期
    				var startTime = $id("startTime").value;
    				//报单结束日期
    				var endTime = $id("endTime").value;
    				//客户名称
    				var custName = $id("custName").value;
    				//差错环节
    				var taskName = $id("taskName").value;

    				//一级支行 code
    				var orgCodeOne = $id("orgCodeOne").value;
    				//二级支行 code
    				var orgCodeTwo = $id("orgCodeTwo").value;
					//一级分类
    				var oneCategory = $id("oneCategory").value;
    				//贷种分类
    				var loanCategory = $id("loanCategory").value;
    				//主调信贷员
    				var creatorName = $id("creatorName").value;
    				//营业主管
    				var yxzg = $id("yxzg").value;
    				
    				
    				var strUrl = "/reportjbpm/errorStatisticAction_queryErrorStatisticForExcel.action?";
    					  if(startTime!=null){
    	                    	 strUrl=strUrl+"&errorStatistic.startTime="+startTime;
    	                         }
    	    				
    	    				if(endTime!=null){
    	    					strUrl=strUrl+"&errorStatistic.endTime="+endTime;
    	        				} 
    				if(custName!=null){strUrl=strUrl+"&errorStatistic.custName="+custName;}
    				if(taskName!=null){strUrl=strUrl+"&errorStatistic.taskName="+taskName;}
    				if(orgCodeOne != ""){strUrl=strUrl+"&errorStatistic.orgCodeOne="+orgCodeOne;}
    				if(orgCodeTwo != ""){strUrl=strUrl+"&errorStatistic.orgCodeTwo="+orgCodeTwo;}
    				if(oneCategory != ""){strUrl=strUrl+"&errorStatistic.oneCategory="+oneCategory;} 
    				if(loanCategory != ""){strUrl=strUrl+"&errorStatistic.loanCategory="+loanCategory;} 
    				if(creatorName != ""){strUrl=strUrl+"&errorStatistic.creatorName="+creatorName;} 
    				if(yxzg != ""){strUrl=strUrl+"&errorStatistic.yxzg="+yxzg;} 
    				
    				window.location.href=strUrl;
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
		  		var InstitutionName = row.getParam("InstitutionName");
		  		var Loan = row.getParam("Loan");
		  		var homophony_loanteller = row.getParam("homophony_loanteller");
var AT_loanteller = row.getParam("AT_loanteller");
		  		var BranchProcessOfficer = row.getParam("BranchProcessOfficer");
		  		var ErrorCondition = row.getParam("ErrorCondition");
		  		var finedsum = row.getParam("finedsum");
var Errornumber = row.getParam("Errornumber");
var Errorlink = row.getParam("Errorlink");
var proposeWP = row.getParam("proposeWP");
var proposeET = row.getParam("proposeET");

	            var strUrl = "/jbpm/xdProcessAction_toUptLoanInfo.action?xdProcessTaskAssignee.executionId="+executionId+"&xdProcessTaskAssignee.InstitutionName="+InstitutionName;
	            strUrl = strUrl +"&xdProcessTaskAssignee.Loan="+Loan
	            +"&xdProcessTaskAssignee.homophony_loanteller="+homophony_loanteller
	            +"&xdProcessTaskAssignee.AT_loanteller="+AT_loanteller
	            +"&xdProcessTaskAssignee.BranchProcessOfficer="+BranchProcessOfficer
                    +"&xdProcessTaskAssignee.ErrorCondition="+ErrorCondition
+"&xdProcessTaskAssignee.finedsum="+finedsum
+"&xdProcessTaskAssignee.Errornumber="+Errornumber
+"&xdProcessTaskAssignee.Errorlink="+Errorlink
+"&xdProcessTaskAssignee.proposeWP="+proposeWP
+"&xdProcessTaskAssignee.proposeET="+proposeET;
	            
				  showModalCenter(encodeURI(strUrl), null,callBack, 500, 300, '修改差错情况信息');
				  
				  /* 	var url="/jbpm/xdProcessAction_toAddOneCategory.action?xdCdtypeBean.processName="+encodeURI(processName);
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl); 
		  		
		  		showModalCenter(encodeURI(strUrl), null, callBack, clientX*0.9, clientY*0.9, ''修改差错情况信息');*/	
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
		  		showModalCenter(strUrl,'',null ,1200,500,'差错情况修改流水明细');
			  	}
		  	}

	  	

	  	function showErrorlink() {
	  		var taskName=document.getElementById("taskName").value;
			strUrl ="/reportjbpm/errorStatisticAction_querytaskNameList.action?errorStatistic.taskName="+taskName;
			showModalCenter(encodeURI(strUrl),'',showErrorlink_callback1 ,900,500,'差错环节选择'); 
		} 
		function showErrorlink_callback1(returnValue){
			if(returnValue == ""){
				//点击右上角关闭时,returnValue为null
				//不做操作
				$id("taskName").value="";
			}else{
				$id("taskName").value= returnValue[0];
			

			}
			}

		//选择  一级分类
		function showoneCategory() {
			var oneCategoryId=document.getElementById("oneCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_oneCategoryDic.action?cdtypeJson="+oneCategoryId,
			showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); 
		} 
		//一级分类 回调函数
		function showoneCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("oneCategoryId").value = array[0];
			 document.getElementById("oneCategory").value = array[1];
			}
		}	

		// 选择  贷种分类
		function showloanCategory() {
			var loanCategoryId=document.getElementById("loanCategoryId").value;
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategoryId,
			showModalCenter(strUrl,'',showloanCategory_callback1 ,800,500,'贷种选择'); 
		} 
		//贷种分类 回调函数
		function showloanCategory_callback1(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("loanCategoryId").value = array[0];
			 document.getElementById("loanCategory").value = array[1];
			}
		}

		//选择	受理支行 
 		function open_slzhej_fun(param){
 			var strUrl ="";
 			var objName="";
 			var peArgument = [];
 			var startOrgid= '${sessionScope.login_user.orgid}'; 

 			 //调用org_public.js公共函数，判断当前机构是部门还是机构
 			var info = judgeIsDept(startOrgid); 
 			
 			if(info == "yes"){ //说明是部门，显示全部机构树
 				strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1";
     		}else{ //说明是支行，显示本级及下级机构树
     			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1&changeTree.startOrgid="+startOrgid;
         	}
         	
 			objName="选择受理支行";  
 			var paramEntity = new ParamEntity('Organization');
     			if(param==1){
     				paramEntity.setProperty('orgname',$id("orgNameOne").value);
     				paramEntity.setProperty('orgcode',$id("orgCodeOne").value);
     				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];	
     						
     				showModalCenter(strUrl,peArgument,open_slzhej_callback1,600,430,objName);  //一级支行 机构树回调
             	}else{
             		paramEntity.setProperty('orgname',$id("orgNameTwo").value);
     				paramEntity.setProperty('orgcode',$id("orgCodeTwo").value);
     				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];	
     				
             		showModalCenter(strUrl,peArgument,open_slzhej_callback2,600,430,objName);  //二级支行 机构树回调
             	}
 			}

 		//一级支行	回调方法
		function open_slzhej_callback1(arg){//回调方法

			if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgNameOne").value = argRes[1];
						$id("orgCodeOne").value = argRes[0];
					}
		    	}
			}

		//二级支行	回调方法
		function open_slzhej_callback2(arg){//回调方法

			if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgNameTwo").value = argRes[1];
						$id("orgCodeTwo").value = argRes[0];
					}
		    	}
			}

		
		//汇总查询
		function summaryQuery(){
			
			var frm = $name("appQuery");
			frm.action="/reportjbpm/errorStatisticAction_queryErrorStatisticSummary.action";
			frm.submit();
		}

		//汇总导出
		function summaryExport(){
			//报单开始日期
			var startTime = $id("startTime").value;
			//报单结束日期
			var endTime = $id("endTime").value;
			//客户名称
			var custName = $id("custName").value;
			//差错环节
			var taskName = $id("taskName").value;

			//一级支行 code
			var orgCodeOne = $id("orgCodeOne").value;
			//二级支行 code
			var orgCodeTwo = $id("orgCodeTwo").value;
			//一级分类
			var oneCategory = $id("oneCategory").value;
			//贷种分类
			var loanCategory = $id("loanCategory").value;
			//主调信贷员
			var creatorName = $id("creatorName").value;
			//营业主管
			var yxzg = $id("yxzg").value;
			
			
			var strUrl = "/reportjbpm/errorStatisticAction_queryErrorStatisticSummaryForExcel.action?";
			if(startTime!=null){
                strUrl=strUrl+"&errorStatistic.startTime="+startTime;
             }
    				
    		if(endTime!=null){
    			strUrl=strUrl+"&errorStatistic.endTime="+endTime;
        	} 
			if(custName!=null){strUrl=strUrl+"&errorStatistic.custName="+custName;}
			if(taskName!=null){strUrl=strUrl+"&errorStatistic.taskName="+taskName;}
			if(orgCodeOne != ""){strUrl=strUrl+"&errorStatistic.orgCodeOne="+orgCodeOne;}
			if(orgCodeTwo != ""){strUrl=strUrl+"&errorStatistic.orgCodeTwo="+orgCodeTwo;}
			if(oneCategory != ""){strUrl=strUrl+"&errorStatistic.oneCategory="+oneCategory;} 
			if(loanCategory != ""){strUrl=strUrl+"&errorStatistic.loanCategory="+loanCategory;} 
			if(creatorName != ""){strUrl=strUrl+"&errorStatistic.creatorName="+creatorName;} 
			if(yxzg != ""){strUrl=strUrl+"&errorStatistic.yxzg="+yxzg;} 
			
			window.location.href=strUrl;
		}
		</script>
		
	</body>
</html>