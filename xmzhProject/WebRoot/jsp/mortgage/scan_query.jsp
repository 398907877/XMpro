<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<script src="<%=request.getContextPath() %>/js/org_public.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>扫描件查询</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form id="scanQuery" name="scanQuery"	action="/mortgage/scanManagementAction_queryScanList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
                     <td class="form_label" align="right" width="20%">入库时间：</td>
					<td width="30%">
					从	
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="inTimeStart" name="scan.inTimeStart" 
					property="scan.inTimeStart" /> 
                                                            到
					    <w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="inTimeEnd" name="scan.inTimeEnd" 
					property="scan.inTimeEnd" /></td>	
		            
		            <td class="form_label" align="right" width="20%">扫描件种类：</td>
					<td width="30%">
					    <d:select id="scanType" dictTypeId="SCAN_TYPE" name="scan.scanType" property="scan.scanType"  style="width:150px" nullLabel="全部"></d:select>
		            </td>				
				</tr>
				<tr class="form_bottom">
						<td colspan="10" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text id="pageLeng" size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="search();">
							<input id="downs" type="button" value="下载" class="button" onclick="download();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                                                       </td>
					</tr>			
					
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="扫描件查询列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/mortgage/scanManagementAction_queryScanList.action" method="post">
			 <h:hiddendata property="scan"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		           <tr>
		                    <th nowrap="nowrap">
								选择
							</th>
							<th nowrap="nowrap">
								操作日期
							</th>
							
							<th nowrap="nowrap">
								扫描件种类
							</th>
							<th nowrap="nowrap">
								扫描文件名
							</th>
						</tr>
						<w:checkGroup id="xgroup1">
                           <l:iterate property="scanList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td align="center" nowrap="nowrap"><w:rowCheckbox>
									<h:param name='scanID' iterateId='id1' property='scanID' />
								</w:rowCheckbox></td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="operationTime" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="scanType" dictTypeId="SCAN_TYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="fileName" />
								</td>
							</tr>
						</l:iterate>
						</w:checkGroup>
							<tr>
              <td colspan="23" class="command_sort_area">
            <!-- 
				<div class="h3">
					<input type="button" value="扫描件上传" onclick="scan_import();" class="button">				
				</div>	
			-->		
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
		<script type="text/javascript">

		//清空
		function clears(){
			$("#scanType").val("");
			//清空JSP页面时间控件显示的值
			$("#inTimeStart_input").val("");
			$("#inTimeEnd_input").val("");
			//清空传入后台的时间控件的值
			$name("scan.inTimeStart").value = "";
			$name("scan.inTimeEnd").value = "";
		}

		
            function search(){
            	var frm = $name("scanQuery");
                frm.submit();
			}

            //扫描件上传
           function scan_import(){
        	   var strUrl = "/jsp/mortgage/scan_import_manager.jsp?_dates="+ new Date();
        	   showModalCenter(strUrl, "", callBackTypeAdd, 580, 300, '扫描件上传');//增加应用
            }
       	//上传完成回调函数
       	function callBackTypeAdd() {
           	$id("querys").click();
           	//window.parent.parent.parent.frames["IFRAMEAppFuncTree"].DTree.getRootNode().reloadChild();
           }
    		//下载 	
             function download(){
            	 var gop = $id("xgroup1");
     	  		var len = gop.getSelectLength();
     	  		if(len == 0){
     	  			alert("请选择一条或多条记录");
     	  			return;
     	  		}else{
                     
     	  			


         	  		
     	  			var rows=gop.getSelectRows();
     	  			var ids="";
     	  			for(var i=0;i<rows.length;i++){
     	  				ids += rows[i].getParam("scanID")+",";
     	  			}
     	  			if(ids != ""){
     	  				ids=ids.substring(0,ids.length-1);
     	  				var strUrl = "/mortgage/scanManagementAction_download.action?";
        				if(ids != null){strUrl=strUrl+"&ids="+ids;}
        				//alert(ids);
        				window.location.href=strUrl;
     	  			} 	
     		  	}			
    		}
		
		</script>
		
	</body>
</html>