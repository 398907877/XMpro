<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>押品浏览列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	action="/mortgage/mortgageReserveAction_toOutInColl.action" method="post">
		                	<h:hidden id="mortgageType" property="mortgageReserveRes.mortgageType"/>
		                	<h:hidden id="warrantsId" property="mortgageReserveRes.warrantsId"/>
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
				   <td class="form_label" align="right" >借款人姓名：</td>
				   <td>
					<h:text property="mortgageReserveRes.borrowerName" id="borrowerName" style="width:130px;" />	
				   </td>
				   <td  class="form_label" align="right" >借款人身份证号：</td>
				   <td  colspan="3">
					<h:text property="mortgageReserveRes.borrowerCardNo" id="borrowerCardNo" style="width:130px;" />	
				   </td>
				</tr>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" >
							<input type="button" value="清 空" class="button" onclick="clears();"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="库存浏览列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/mortgage/mortgageReserveAction_toOutInColl.action" method="post">
			 <h:hiddendata property="mortgageReserveRes"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
					<table align="center" border="0" width="100%" class="EOS_table">
					    <tbody id="list_fc">
						<tr>
						<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
						  <th nowrap="nowrap">
								库存序号
						  </th>
						   <th nowrap="nowrap">
								产权证号
						  </th>
						   <th nowrap="nowrap">
								产权人姓名
						  </th>
						   <th nowrap="nowrap">
								产权人身份证
						  </th>
						   <th nowrap="nowrap">
								产权地址
						  </th>
						  <w:radioGroup id="group1">
						  <l:iterate property="mortgageReserveList" id="id2">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							  
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='id' iterateId='id2' property='WARRANTSID' />
										<h:param name='operatingId' iterateId='id2' property='HOUSEID' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROJECTNUMBER" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYNO" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYCARDNO" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYADDRES" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						</tr>
					</tbody>
					<tbody id="list_jdc" style="display:none">
						<tr>
						<th align="center" nowrap="nowrap">
								<b:message key="l_select"></b:message>
							</th>
						  <th nowrap="nowrap">
								库存序号
						  </th>
						   <th nowrap="nowrap">
								机动车登记号
						  </th>
						   <th nowrap="nowrap">
								车主姓名
						  </th>
						   <th nowrap="nowrap">
								车主身份证
						  </th>
						  <w:radioGroup id="group2">
						  <l:iterate property="mortgageReserveList" id="id3">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							  
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='id' iterateId='id3' property='WARRANTSID' />
										<h:param name='operatingId' iterateId='id3' property='CARID' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="PROJECTNUMBER" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARREGISTERNO" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARCARDNO" />
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						</tr>
					</tbody>
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
							<input type="button" class="button" value="出入处理" onclick="outIn_coll(0);"/>
							<input type="button" class="button" value="入库处理" onclick="outIn_coll(1);"/>
							<input type="button" class="button" value="返回" onclick="back_coll();" />
					
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
	 
	  window.onload = function () {
	     var valType=  $id("mortgageType").value; 
	      init(valType);

        };
		//清空
		function clears(){
          $id("borrowerName").value="";
          $id("borrowerCardNo").value="";
		}
		
		
       //抵押类型改变事件
       function init(val){
	       if(val=="1"){
	        $("#list_fc").show();
	        $("#list_jdc").hide();
	       }else if(val=="2"){
	        $("#list_jdc").show();
	        $("#list_fc").hide();
	       }
       }
        //出库处理
		function outIn_coll(param){
		  var gop;
		  var mortgageType=$("#mortgageType").val();
		  if(mortgageType=="1"){
		    gop= $id("group1");
		  }else if(mortgageType=="2"){
		    gop= $id("group2");
		  }
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
    			var operatingId=row.getParam("operatingId");
    			var textName="出库处理";
    			if(param==1){
    			  textName="入库处理";
    			}
			    var url="/mortgage/mortgageReserveAction_toInsertOutInColl.action?mortgageReserveOut.warrantsId="+id+"&mortgageReserveOut.operatingId="+operatingId+"&mortgageReserveOut.outInType="+param;
			    showModalCenter(url,param,callBackFunc, 700, 230, textName);
			  }
		}
		
		function callBackFunc(){
	  		window.location.reload();
			}
		function back_coll(){
	           var mortgageType=  $id("mortgageType").value; 
			    var url="/mortgage/mortgageReserveAction_queryMortgageReserveList.action?mortgageReserve.mortgageType="+mortgageType;
			    parent.window.frames["mainFrame"].location.href = encodeURI(url);	
	  		//window.history.go(-1);
		 }
		function GetRequest() { 
	    var url = location.search; //获取url中"?"符后的字串   
	    var theRequest = new Object();  
	    if (url.indexOf("?") != -1) {  
	        var str = url.substr(1);  
	        strs = str.split("&");  
	        for (var i = 0; i < strs.length; i++) {  
	            theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);  
	        }  
	    }  
    return theRequest;  
}  
		</script>
		
	</body>
</html>