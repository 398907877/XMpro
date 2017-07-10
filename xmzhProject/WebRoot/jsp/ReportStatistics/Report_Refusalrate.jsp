<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<script src="<%=request.getContextPath() %>/js/org_public.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>拒贷率统计列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/reportRefusalrateAction_queryReportRefusalRate.action" method="post">
	
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                   <td class="form_label" align="right" >报单日期：</td>
					<td colspan="1"  >
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="stratdate" name="reportRefusalrate.stratdate" 
					property="reportRefusalrate.stratdate" /> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyy-MM-dd" id="enddate" name="reportRefusalrate.enddate" 
					property="reportRefusalrate.enddate" /></td>

					<td class="form_label" align="right" >一级分类：</td>
					<td >
			     		<h:hidden id="oneCategoryId" property="reportRefusalrate.oneCategoryId" />  
						<h:text id="oneCategoryTxt" property="reportRefusalrate.oneCategoryTxt" readonly="true"/>
						<a href="#" onclick="showoneCategory();">选择</a>
					</td>
					
					<td class="form_label" align="right" >贷种分类：</td>
					<td >
						<h:hidden id="loanCategoryId" property="reportRefusalrate.loanCategoryId" />
						<h:text id="loanCategoryTxt" property="reportRefusalrate.loanCategoryTxt" readonly="true"/>
						<a href="#" onclick="showloanCategory();">选择</a>
					</td>
				</tr>
				
				<tr>
					<td class="form_label" align="right" >一级支行：</td>
					<td>
					    <h:text id="orgNameOne" property="reportRefusalrate.orgNameOne" readonly="true"  style="width:130px;"/>
						<h:hidden id="orgCodeOne" property="reportRefusalrate.orgCodeOne" />
					    <a href="#" onclick="open_slzhej_fun(1)">选择</a>
		            </td>	
		            
		            <td class="form_label" align="right" >二级支行：</td>
					<td>
					    <h:text id="orgNameTwo" property="reportRefusalrate.orgNameTwo" readonly="true"  style="width:130px;"/>
						<h:hidden id="orgCodeTwo" property="reportRefusalrate.orgCodeTwo" />
					    <a href="#" onclick="open_slzhej_fun(2)">选择</a>
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
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="downExl();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="拒贷率统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/ReportStatistics/reportRefusalrateAction_queryReportRefusalRate.action" method="post">
			 <h:hiddendata property="reportRefusalrate"/>  
			
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
							<th nowrap="nowrap">
								一级分类
							</th>
							<th nowrap="nowrap">
								贷种
							</th>
							<th nowrap="nowrap">
								区支行
							</th>
							<th nowrap="nowrap">
								二级支行
							</th>
							<th nowrap="nowrap">
								审批通过笔数
							</th>
							<th nowrap="nowrap">
								拒贷笔数
					       </th>
					       <th nowrap="nowrap">
								拒贷率
							</th>
                                                 
						</tr>
						<w:radioGroup id="group1">
                           <l:iterate property="list" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="oneCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="loanCategory" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameOne"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgNameTwo" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="EA_number"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="rejection_number" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="refusalrate" />%
								</td>
							</tr>
						</l:iterate>
						</w:radioGroup>
						
						  <tr>				

						  
								<l:iterate property="listSum" id="id2" >
						  <th align="center" nowrap="nowrap" colspan="4">
								上报审批笔数合计/拒贷笔数合计	/拒贷率合计	
							</th>
							<th >
									<b:write iterateId="id2" property="upnum"/>
								</th>
								<th >
									<b:write iterateId="id2" property="downnum"/>
								</th>
								<th >
								    <b:write iterateId="id2" property="dowup"/>%
								</th>
								</l:iterate>																								
						
						</tr>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<!--  <div class="h3"> 
              	<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
									<input type="button" class="button" value="修改拒贷率信息" onclick="upt_loan_info();"/>
								</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="查看修改明细" onclick="queryLoanUptWater();"/>
								</l:greaterThan>
								</div>-->
							
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
		<script type="text/javascript">

		//清空
		function clears(){
			$("#stratdate_input").val("");
			$("#stratdate_hidden").val("");
			$("#enddate_input").val("");
			$("#enddate_hidden").val("");
			$id("oneCategoryTxt").value="";
			$id("oneCategoryId").value="";
			$id("loanCategoryTxt").value="";
			$id("loanCategoryId").value="";
			$id("orgCodeOne").value="";
			$id("orgNameOne").value="";
			$id("orgCodeTwo").value="";
			$id("orgNameTwo").value="";
		}
                function search(){
			$("#isExport").val("");
			}
               
		//导出excel 	
             function downExl(){
             
             //alert('ssssss');
    				//报单开始日期
    				var stratdate = $name("reportRefusalrate.stratdate").value;
    				//报单结束日期
    				var enddate = $name("reportRefusalrate.enddate").value;
    				//一级分类
    				var oneCategoryTxt = $id("oneCategoryTxt").value;
    				//贷种分类
    				var loanCategoryTxt = $id("loanCategoryTxt").value;
					//一级支行
    				var orgCodeOne = $id("orgCodeOne").value;
					//二级支行
    				var orgCodeTwo = $id("orgCodeTwo").value;
    				
    				var strUrl = "/reportjbpm/reportRefusalrateAction_queryReportRefusalrateExcel.action?"
    				+"&reportRefusalrate.stratdate="+stratdate
    				+"&reportRefusalrate.enddate="+enddate
    				+"&reportRefusalrate.oneCategoryTxt="+oneCategoryTxt
    				+"&reportRefusalrate.loanCategoryTxt="+loanCategoryTxt
    				+"&reportRefusalrate.orgCodeOne="+orgCodeOne
    				+"&reportRefusalrate.orgCodeTwo="+orgCodeTwo;
    				//alert(strUrl);
    				window.location.href=strUrl;
    			}
		
		
		function callBack(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
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
			 document.getElementById("oneCategoryTxt").value = array[1];
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
			 document.getElementById("loanCategoryTxt").value = array[1];
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
		
		</script>
		
	</body>
</html>