<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>发布流程</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/jbpm/jbpmDemoAction_queryProcessDeployList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right" width="20%">流程名称：</td>
					<td colspan="1"  width="30%"><h:text id="processName" property="processConfig.processName" /></td>
					<td class="form_label" align="right" width="15%">业务类型：</td>
				<td colspan="1" width="30%">
				<d:select dictTypeId="ZHPT_BUSINESS_TYPE" id="businessType" property="processConfig.businessType" nullLabel="请选择"></d:select>
				
				</td>
				</tr>
					<tr>
							<td colspan="4" class="form_bottom">
							每页显示
							<h:text size="2" property="page.length" value="10"
								validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
							<input type="hidden" name="page.begin" value="0">
							<input type="hidden" name="page.isCount" value="true">
							<input type="submit" id="btn" class="button" value='查询'>
						</td>
			</tr>
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="流程发布列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/jbpm/jbpmDemoAction_queryProcessDeployList.action" method="post">
					<h:hidden property="page.begin" />
					<h:hidden property="page.length" />
					<h:hidden property="page.count" />
					<h:hidden property="page.isCount" />
					<h:hiddendata property="processConfig.processName"/>
				    <h:hiddendata property="processConfig.businessType"/>
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								业务类型
							</th>
							<th nowrap="nowrap">
								流程名称
							</th>
							<th nowrap="nowrap">
								状态
							</th>
							<th nowrap="nowrap">
								提交时间
							</th>
						</tr>
					<w:radioGroup id="group1">
                          <l:iterate property="processConfigs" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='processName' iterateId='id1' property='processName' />
										<h:param name='businessType' iterateId='id1' property='businessType' />
										<h:param name='definitionId' iterateId='id1' property='definitionId' />
										<h:param name='state' iterateId='id1' property='state' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<d:write dictTypeId="ZHPT_BUSINESS_TYPE" iterateId="id1" property="businessType" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processName" />
								</td>
								<td nowrap="nowrap"> 
									<d:write dictTypeId="ZHPT_PROCESS_STATE" iterateId="id1" property="state" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="uploadTime" formatPattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						<tr>
              <td colspan="23" class="command_sort_area">
							<div class="h3">
								&nbsp; &nbsp;
								<input type="button" class="button" value="发布流程"
									onclick="deployProcess();" />
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="修改流程"
									onclick="updateProcess();" />
							</l:greaterThan>
							
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="复制流程"
									onclick="copyProcess();" />
									</l:greaterThan>
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="流程节点配置"
									onclick="toProcessTaskConfig();" />
									</l:greaterThan>
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="流程图配置"
									onclick="toProcessImgConfig();" />
							</l:greaterThan>
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="查看流程图"
									onclick="viewProcess();" />
							</l:greaterThan>
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="新增信贷流程配置"
									onclick="addProcessConfig();" />
							</l:greaterThan>
							<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
								<input type="button" class="button" value="信贷流程图配置"
									onclick="toGpImpConfig();"/>
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

		//新增信贷流程配置
 		function addProcessConfig(){
	  		var strUrl = "/jbpm/jbpmCommonConfigAction_toAddProcessConfig.action";
		  	showModalCenter(strUrl, null, null, 700, 300, '新增信贷流程配置');	
 		}
		
		//信贷流程图配置
		function toGpImpConfig(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var businessType=rows.getParam("businessType");
		  		var definitionId=rows.getParam("definitionId");
		  		if("88" == businessType){
		  			var strUrl = "/jbpm/jbpmDemoAction_toGpProcessImgConfig.action?taskAssgineeDto.definitionId="+definitionId;
			  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl);
		  		}else{
		  			alert('该流程不是信贷流程,如需修改流程图,请点击【流程图配置】');
		  		}
	  		}
			
		}
		
		//发布流程
		function deployProcess(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		var strUrl = "/jbpm/jbpmDemoAction_toProcessDeploy.action";
		  	showModalCenter(strUrl, null, null, 700, 300, '发布流程');  
		}

		//流程节点配置	
	  	function toProcessTaskConfig(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var definitionId=rows.getParam("definitionId");
	  			var strUrl = "/jbpm/jbpmDemoAction_toProcessTaskConfig.action?taskAssgineeDto.definitionId="+definitionId;
		  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl);	
		  	}
		 }

		//复制流程
		function copyProcess(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var definitionId=rows.getParam("definitionId");
	  			var strUrl = "/jbpm/jbpmDemoAction_toCopyProcessConfig.action?taskAssgineeDto.definitionId="+definitionId;
	  			showModalCenter(strUrl, null, null, 700, 300, '复制流程');  
		  	}
		}

		//修改流程
		function updateProcess(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var definitionId=rows.getParam("definitionId");
	  			var strUrl = "/jbpm/jbpmDemoAction_toUpdateProcessConfig.action?taskAssgineeDto.definitionId="+definitionId;
	  			showModalCenter(strUrl, null, null, 700, 300, '修改流程');  
		  	}
		}
		
		//流程图配置
 		function toProcessImgConfig(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var definitionId=rows.getParam("definitionId");
		  		var businessType=rows.getParam("businessType");
		  		if("88" == businessType){
		  			alert('该流程是信贷流程,如需修改流程图,请点击【信贷流程图配置】');
		  		}else{
		  			var strUrl = "/jbpm/jbpmDemoAction_toProcessImgConfig.action?taskAssgineeDto.definitionId="+definitionId;
			  		parent.window.frames["mainFrame"].location.href = encodeURI(strUrl);	
		  		}
		  		
		  	}
		} 
		
 		//查看流程图
 		function viewProcess(){
	  		var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条流程信息");
	  			return;
	  		}else{
		  		var rows=gop.getSelectRow();
		  		var definitionId=rows.getParam("definitionId");
		  		var strUrl = "/jbpm/jbpmDemoAction_viewProcess.action?definitionId="+definitionId ;
		  		showModalCenter(strUrl, null, null, clientX*0.8, clientY*0.65, '流程图'); 
			  	}
		  	}
 		
 		
		 
		</script>
	</body>
</html>