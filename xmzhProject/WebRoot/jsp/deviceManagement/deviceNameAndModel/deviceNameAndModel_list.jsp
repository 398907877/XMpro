<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>设备名称/设备型号 关系列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/deviceManagement/deviceNameAndModelAction_queryDeviceNameAndModelList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
					<td class="form_label" align="right" >设备名称：</td>
					<td >
			     		<h:hidden id="devicename_id" property="deviceNameAndModel.devicename_id" />  
						<h:text id="devicename" property="deviceNameAndModel.devicename" readonly="true"/>
						<a href="#" onclick="showDevicenameDic();">选择</a>
					</td>
					
					<td class="form_label" align="right" >设备型号：</td>
					<td >
						<h:hidden id="devicemodel_id" property="deviceNameAndModel.devicemodel_id" />
						<h:text id="devicemodel" property="deviceNameAndModel.devicemodel" readonly="true"/>
						<a href="#" onclick="showDevicemodelDic();">选择</a>
					</td>
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button">
							<input type="button" value="清 空" class="button" onclick="clears();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="设备名称/型号关系列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/deviceManagement/deviceNameAndModelAction_queryDeviceNameAndModelList.action" method="post">
			 <h:hiddendata property="deviceNameAndModel"/>  

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
								设备名称
							</th>
							<th nowrap="nowrap">
								设备型号
					       </th>
						</tr>
						<w:checkGroup id="group1">
                           <l:iterate property="deviceNameAndModels" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap">
									<w:rowCheckbox>
										<h:param name='id' iterateId='id1' property='id' />
									</w:rowCheckbox>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1"    property="devicename" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="devicemodel" />
								</td>
							</tr>
						</l:iterate>
						</w:checkGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
							<input type="button" class="button" value="新增" onclick="add();"/>
							
						<l:greaterThan property="page.count" targetValue="0" compareType="number" >
								&nbsp; &nbsp;
							<input type="button" class="button" value="删除" onclick="del();"/>
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
			$id("devicename_id").value="";
			$id("devicename").value="";
			$id("devicemodel_id").value="";
			$id("devicemodel").value="";
		}
		
		//新增
		function add(){
			  var url="/deviceManagement/deviceNameAndModelAction_toAddItem.action";
			  showModalCenter(url, null,callBackFunc, 500, 300, '新增设备名称/型号对应关系');
		}

		//删除
		function del(){
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条或多条记录");
	  			return;
	  		}else{
		  	  if(confirm("确定要删除吗？")){
	  			var rows=gop.getSelectRows();
	  			var ids="";
	  			for(var i=0;i<rows.length;i++){
	  				ids += rows[i].getParam("id")+",";
	  			}
	  			if(ids != ""){
	  				ids=ids.substring(0,ids.length-1);
		  		$.ajax({
				      url: "/deviceManagement/deviceNameAndModelAction_deleteItem.action",
				      async: false,
				      type: 'post',
				      data: "ids="+ids,
				      timeout: 60000,
				      dataType:"text",
				      success: function (data) {
				    	  if (data.indexOf("success") >= 0) {
				    		  alert("删除成功");
				    		  callBackFunc();
						} else if (data.indexOf("fails") >= 0) {
							alert("删除失败!");
						} else {
							alert("操作失败!");
						}
								  	
				      }
				}); 
	  			}
		 	 }	
		  	}
		}
		
		function callBackFunc(){
			var frm = $name("page_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
			}

		// 数据字典 多选按钮显示页面
		function showDevicenameDic() {
			var devicename_id=document.getElementById("devicename_id").value;
			strUrl ="/deviceManagement/deviceNameAndModelAction_showDevicenameDic.action?deviceJson="+devicename_id,
			showModalCenter(strUrl,'',showDevicenameDic_callback ,800,430,'设备名称选择'); 
		} 
		function showDevicenameDic_callback(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("devicename_id").value = array[0];
			 document.getElementById("devicename").value = array[1];
			}
		}

		// 数据字典 多选按钮显示页面
		function showDevicemodelDic() {
			var devicemodel_id=document.getElementById("devicemodel_id").value;
			strUrl ="/deviceManagement/deviceNameAndModelAction_showDevicemodelDic.action?deviceJson="+devicemodel_id,
			showModalCenter(strUrl,'',showDevicemodelDic_callback ,800,500,'设备型号选择'); 
		} 
		function showDevicemodelDic_callback(args){
			if(args!=''){
			var array;
			array = args.split(":");
			 document.getElementById("devicemodel_id").value = array[0];
			 document.getElementById("devicemodel").value = array[1];
			}
		}	
		</script>
		
	</body>
</html>