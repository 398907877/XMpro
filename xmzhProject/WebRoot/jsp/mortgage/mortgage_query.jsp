<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>库存查询</title>
  </head>
  
  <body>
    <h:form name="houseQuery"action="/mortgage/mortgageReserveHouseAction_queryMortgageHouseReserveList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right">补登记标志：</td>
					<td >
						<select id="noRegisterSign" name="mortgageReserveHouse.noRegisterSign" onchange= "changeCheckSign(this.value)" style="width:80px;">
						<option value="">全部</option>
						<option value="1">未确认</option>
						<option value="2">已确认</option>
						</select>
					</td>
					<td class="form_label" align="right" >产权人姓名：</td>
					<td>
					 <h:text property="mortgageReserveHouse.propertyName" id="propertyName" style="width:130px;" />	
					</td>	
					<td class="form_label" align="right" >产权人身份证号：</td>
					<td>
					 <h:text property="mortgageReserveHouse.propertyCardNo" id="propertyCardNo" style="width:130px;" />	
					</td>
					
				</tr>
				<tr>
				    <td class="form_label" align="right" >产权证号：</td>
					<td>
					<h:text property="mortgageReserveHouse.propertyNo" id="propertyNo" style="width:130px;" />	
					</td>	
					<td class="form_label" align="right" >产权地址：</td>
					<td>
					<h:text property="mortgageReserveHouse.propertyAddres" id="propertyAddres" style="width:130px;" />	
					</td>
				</tr>
				    
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="query" type="submit" value="查 询" class="button">
							<input type="button" value="退出" class="button" onclick="clears();">
							<input type="button" value="导出" class="button" onclick="downExl();">
							<input type="button" value="补登记确认" class="button" onclick="checkConfirm();">
						</td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<div id="hh" class="divList">
    <w:panel width="100%" title="库存查询列表">
    <viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
  	<h:form name="form1" action="/mortgage/mortgageReserveHouseAction_queryMortgageHouseReserveList.action" method="post">
		  <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
	     <table class="EOS_table" width="100%" style="overflow:scroll">
		<tr>
		  <th nowrap="nowrap">选择</th>
		  <th nowrap="nowrap">库存序号</th>
		  <th nowrap="nowrap">货种</th>
		  <th nowrap="nowrap">他项权证号</th>
		  <th nowrap="nowrap">借款人</th>
		  <th nowrap="nowrap">库存状态</th>
		  <th nowrap="nowrap">产权证号</th>
		  <th nowrap="nowrap">产权人</th>
		  <th nowrap="nowrap">产权地址</th>
		  <th nowrap="nowrap">操作</th>
		</tr>
		<w:radioGroup id="group1">
			<l:iterate property="mortgageReserveHouseList" id="id1">
			<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" id="issuedTr">
			  <td style="text-align: center;height: 30px;width:5%">
			  	<w:rowRadio>
			  		<h:param name='id' iterateId='id1' property='id'/>
	               <h:param name='warrantsId' iterateId='id1' property='warrantsId'/>
	               <h:param name='noRegisterSign' iterateId='id1' property='noRegisterSign'/>
	            </w:rowRadio>
			  </td>
			  <td nowrap="nowrap">
                	<b:write iterateId="id1" property="projectNumber"/> 
                </td>
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="loanType"/> 
                </td>
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="otherWarrantsNumber"/> 
                </td>
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="borrowerName"/> 
                </td> 
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="status"/> 
                </td>  
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="propertyNo"/> 
                </td>
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="propertyName"/> 
                </td>
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="propertyAddres"/> 
                </td>
                <td nowrap="nowrap">
                	<b:write iterateId="id1" property="operator"/> 
                </td>
			</tr>
			</l:iterate>
		</w:radioGroup>
		 <tr>
		        <td colspan="9" class="command_sort_area">
		        	<div class="h3">
		          
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
   </div>
		<script type="text/javascript">
	
		
       //补登记标记改变事件
       function changeCheckSign(val){
       if(val=="0"){
	        $("#tj_fc").show();
	        $("#tj_jdc").hide();
	       }else if(val=="1"){
	       $("#tj_jdc").show();
	        $("#tj_fc").hide();
	       }
	       else if(val=="2"){
	       $("#tj_jdc").show();
	        $("#tj_fc").hide();
	       }
       }


		//清空
		function clears(){
		}
		
		//导出
		function downExl(){
			var noRegisterSign = $id("noRegisterSign").value;
			var propertyName = $id("propertyName").value;
			var propertyCardNo = $id("propertyCardNo").value;
			var propertyNo = $id("propertyNo").value;
			var propertyAddres = $id("propertyAddres").value;
			var strUrl = "/mortgage/mortgageReserveHouseAction_queryMortgageQueryForExcel.action?";
			if(noRegisterSign!=null)
			{
				strUrl=strUrl+"&mortgageReserveHouse.noRegisterSign="+noRegisterSign;
			}
			if(propertyName!=null)
			{
				strUrl=strUrl+"&mortgageReserveHouse.propertyName="+propertyName;
			}
			if(propertyCardNo!=null)
			{
				strUrl=strUrl+"&mortgageReserveHouse.propertyCardNo="+propertyCardNo;
			}
			if(propertyNo!=null)
			{
				strUrl=strUrl+"&mortgageReserveHouse.propertyNo="+propertyNo;
			}
			if(propertyAddres!=null)
			{
				strUrl=strUrl+"&mortgageReserveHouse.propertyAddres="+propertyAddres;
			}
			window.location.href=strUrl;
		}
		
		//补登记确认
		function checkConfirm()
		{
			var gop = $id("group1");
	  		var len = gop.getSelectLength();
	  		if(len == 0){
	  			alert("请选择一条记录");
	  			return;
	  		}else{
	  		
	  			var rows=gop.getSelectRow();
		  		var warrantsId=rows.getParam("warrantsId");
	  			var strUrl = "/mortgage/mortgageReserveHouseAction_toRegisterSignConfirm.action?mortgageReserveHouse.warrantsId="+warrantsId;
	  			showModalCenter(strUrl, null, null, 300, 100, '补登记确认');  
		  	}
			
		}
		
		
		</script>
  </body>
</html>
