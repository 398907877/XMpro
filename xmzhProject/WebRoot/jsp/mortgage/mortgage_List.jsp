<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>库存浏览列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="appQuery"	action="/mortgage/mortgageReserveAction_queryMortgageReserveList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right">押品类型：</td>
					<td >
						<select id="mortgageType" name="mortgageType" onchange= "changeMortgageType(this.value)" style="width:80px;">
						<option value="0">房产</option>
						<option value="1">机动车</option>
						</select>
					</td>
					<td class="form_label" align="right" >项目说明备注：</td>
					<td>
					 <h:text property="mortgageReserve.projectRemark" id="projectRemark" style="width:130px;" />	
					</td>	
					<td class="form_label" align="right" >库存序号：</td>
					<td>
					 <h:text property="mortgageReserve.projectNumber" id="projectNumber" style="width:130px;" />	
					</td>
				</tr>
				<tr>
				<tbody id="tj_fc">
				    <td class="form_label" align="right" >借款人姓名：</td>
					<td>
					<h:text property="mortgageReserve.borrowerName" id="borrowerName" style="width:130px;" />	
					</td>	
				</tbody>
				</tr>
				<tbody id="tj_jdc" style="display:none">
				    <td class="form_label" align="right" >借款人姓名：</td>
					<td>
					<h:text property="mortgageReserve.borrowerName" id="borrowerName" style="width:130px;" />	
					</td>	
				</tbody>
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
			<w:panel id="panel" width="100%" title="库存浏览列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/mortgage/mortgageReserveAction_queryMortgageReserveList.action" method="post">
			 <h:hiddendata property="mortgageReserve"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
		    
						<tr>
						 
						  <th nowrap="nowrap">
								更新时间
						  </th>
						  <l:iterate property="mortgageReserveList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							  
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="updateTime" />
								</td>
								
							</tr>
						</l:iterate>
						</tr>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
							<input type="button" class="button" value="新增入库" onclick="add();"/>
					
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
	
		
       //抵押类型改变事件
       function changeMortgageType(val){
       if(val=="0"){
        $("#tj_fc").show();
        $("#tj_jdc").hide();
       }else if(val=="1"){
       $("#tj_jdc").show();
        $("#tj_fc").hide();
       }
       }


		//清空
		function clears(){
		}
		
		//新增
		function add(){
			
		}

		
		
		</script>
		
	</body>
</html>