<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page  language="java" import="java.util.*,com.gotop.util.time.TimeUtil"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<% 

String str_date = TimeUtil.today();


%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>操作日志查询</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form id="appQuery" name="appQuery"	action="/mortgage/mortgageLogQueryAction_queryMortgageLogList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
				 <td class="form_label" align="right">操作类型：</td>
					<td >
					    <d:select id="operateType" dictTypeId="MORTGAGE_OPERATING_TYPE" name="mortgageLog.operateType" property="mortgageLog.operateType" nullLabel="全部" style="width:150px"></d:select>
		            </td>
		            <td class="form_label" align="right" >库存序号：</td>
					<td>
					 <h:text id="projectNumber"  property="mortgageLog.projectNumber" name="mortgageLog.projectNumber"  style="width:130px;" />	
					</td>
                     <td class="form_label" align="right">操作日期：</td>
					<td>
					从
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="airTime" name="mortgageLog.airTime" 
					property="mortgageLog.airTime" value="<%=str_date%>"/> 
					到
					<w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="stopTime" name="mortgageLog.stopTime" 
					property="mortgageLog.stopTime" value="<%=str_date%>"/></td>				
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text id="pageLeng" size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" onclick="search();">
							<input type="button" value="清 空" class="button" onclick="clears();">
                            <input id="downexl" type="button" class="button" value="导出列表" onclick="excelExport();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="操作日志导出">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/mortgage/mortgageLogQueryAction_queryMortgageLogList.action" method="post">
			 <h:hiddendata property="mortgageLog"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		 
							<th nowrap="nowrap">
								操作时间
							</th>
							<th nowrap="nowrap">
								部门
							</th>
							
							<th nowrap="nowrap">
								操作人员
							</th>
							<th nowrap="nowrap">
								操作类型
							</th>
							<th nowrap="nowrap">
								操作内容（权证内容）
							</th>
							<!-- 
							<th nowrap="nowrap">
								备注
							</th>
						      --> 
						</tr>
                           <l:iterate property="mortgageLogList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="operateTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="orgName" />
								</td>
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="empName" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="operateType" dictTypeId="MORTGAGE_OPERATING_TYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="operateContent" />
								</td>
								<!-- 
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="remark" />
								</td>
								 -->
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
		<script type="text/javascript">

		//清空
		function clears(){

			//清空JSP页面时间控件显示的值,将当前时间填入
			var aaa=<%=str_date%>;
            var date=new Date();
            var year = date.getFullYear();  
            var month = date.getMonth();  
            var day = date.getDate();  
            month = month + 1;  
            if (month < 10) month = '0' + month;  
            if (day < 10) day = '0' + day;  
            var str = year + '-' + month + '-' + day;
            $("#airTime_input").val(str);
            $("#stopTime_input").val(str);

            $id("airTime").value=str;
            $id("stopTime").value=str;

			
			$id("operateType").value="";
			$id("projectNumber").value="";
			$("#operateType").val("");
		
			//清空JSP页面时间控件显示的值
			//$("#airTime_input").val("");
			//$("#stopTime_input").val("");

			//清空传入后台的时间控件的值
			//$name("mortgageLog.airTime").value = "";
			//$name("mortgageLog.stopTime").value = "";
			$name("mortgageLog.airTime").value = aaa;
			$name("mortgageLog.stopTime").value = aaa;
			
		
		}
		
                function search(){
                	//var airTime=$name("mortgageLog.airTime").value;  //获取开始时间
                	//var stopTime=$name("mortgageLog.stopTime").value;  //获取结束时间
                	//if(airTime!="" || stopTime!=""){
                		var frm = $name("appQuery");
                        frm.submit();
                    //}else{
                     //   alert("开始时间和截止日期为必选项！");
                        
                   // }
                	
			}

    		//导出excel 	
             function excelExport(){
    				var airTime = $id("airTime").value;
    				var stopTime = $id("stopTime").value;
    				var options=$("#operateType option:selected");
    				var operateType=options.val();
    				var projectNumber = $id("projectNumber").value;
    				
    				var strUrl = "/mortgage/mortgageLogQueryAction_mortgageLogExcel.action?";
                     if(airTime!=null){
                    	 strUrl=strUrl+"&mortgageLog.airTime="+airTime;
                         }
    				
    				if(stopTime!=null){
    					strUrl=strUrl+"&mortgageLog.stopTime="+stopTime;
        				} 
    				if(operateType!=null){
    					strUrl=strUrl+"&mortgageLog.operateType="+operateType;
        				} 	
    				if(projectNumber!=null){
    					strUrl=strUrl+"&mortgageLog.projectNumber="+projectNumber;
        				} 				
    				
    				window.location.href=strUrl;
    			}
             
		
		</script>
		
	</body>
</html>