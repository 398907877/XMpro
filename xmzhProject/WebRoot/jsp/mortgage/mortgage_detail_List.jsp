<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>库存变更浏览列表</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form name="query_form"	>
		                	<h:hidden id="mortgageType" property="mortgageReserveRes.mortgageType"/>
		                	<h:hidden id="warrantsId" property="mortgageReserveRes.warrantsId"/>
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom"></td>
					</tr>			
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList" style="overflow:auto;width:100%; height: 380;">
			<w:panel id="panel" width="100%" title="库存变更浏览列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/mortgage/mortgageReserveAction_queryDetailColl.action" method="post">
			 <h:hiddendata property="mortgageReserveRes"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
					<table align="center" border="0" width="100%" class="EOS_table">
					    <tbody id="list_fc">
						<tr>
						  <th nowrap="nowrap">
								押品类型
						  </th>
						   <th nowrap="nowrap">
								他项类型
						  </th>
						   <th nowrap="nowrap">
								操作时间
						  </th>
						   <th nowrap="nowrap">
								操作人员
						  </th>
						   <th nowrap="nowrap">
								库存序号
						  </th>
						   <th nowrap="nowrap">
								他项权证号
						  </th>
						   <th nowrap="nowrap">
								他项登记日期
						  </th>
						   <th nowrap="nowrap">
								借款人姓名
						  </th>
						   <th nowrap="nowrap">
								借款人身份证
						  </th>
						   <th nowrap="nowrap">
								经办机构
						  </th>
						   <th nowrap="nowrap">
								经办客户经理
						  </th>
						   <th nowrap="nowrap">
								贷款种类
						  </th>
						   <th nowrap="nowrap">
								借款合同号
						  </th>
						   <th nowrap="nowrap">
								贷款年限
						  </th>
						   <th nowrap="nowrap">
								入账价值
						  </th>
						   <th nowrap="nowrap">
								封包编号
						  </th>
						   <th nowrap="nowrap">
								交接人
						  </th>
						   <th nowrap="nowrap">
								购房合同号
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
						   <th nowrap="nowrap">
								产权证本数
						  </th>
						   <th nowrap="nowrap">
								产权证填发日期
						  </th>
						  <w:radioGroup id="group1">
						  <l:iterate property="mortgageReserveListLog" id="id2">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							   <td nowrap="nowrap"> 
									<d:write  iterateId="id2" dictTypeId="MORTGAGE_RESERVE_TYPE" property="MORTGAGETYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<d:write  iterateId="id2" dictTypeId="OTHER_TYPE_VIEW" property="OTHERTYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="INSERTTIME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="EMPNAME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROJECTNUMBER"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="OTHERWARRANTSNUMBER" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="OTHERWARRANTSDATE" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="BORROWERNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="BORROWERCARDNO" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="ORGNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="MANGERNAME" />
								</td>
								<td nowrap="nowrap"> 
									<d:write  iterateId="id2" dictTypeId="LOAN_TYPE_VIEW" property="LOANTYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="BORROWERCONTRACTNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="LOANYEARS"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="RECORDVALUE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PACKETNUMBER"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="NEXTNAME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PURCHASENUMBER"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYNAME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYCARDNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYADDRES"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYNUMS"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROPERTYDATE"/>
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						</tr>
					</tbody>
					<tbody id="list_jdc" style="display:none">
						<tr>
						  <th nowrap="nowrap">
								押品类型
						  </th>
						   <th nowrap="nowrap">
								他项类型
						  </th>
						   <th nowrap="nowrap">
								操作时间
						  </th>
						   <th nowrap="nowrap">
								操作人员
						  </th>
						   <th nowrap="nowrap">
								库存序号
						  </th>
						   <th nowrap="nowrap">
								他项权证号
						  </th>
						   <th nowrap="nowrap">
								他项登记日期
						  </th>
						   <th nowrap="nowrap">
								借款人姓名
						  </th>
						   <th nowrap="nowrap">
								借款人身份证
						  </th>
						   <th nowrap="nowrap">
								经办机构
						  </th>
						   <th nowrap="nowrap">
								经办客户经理
						  </th>
						   <th nowrap="nowrap">
								贷款种类
						  </th>
						   <th nowrap="nowrap">
								借款合同号
						  </th>
						   <th nowrap="nowrap">
								贷款年限
						  </th>
						   <th nowrap="nowrap">
								入账价值
						  </th>
						   <th nowrap="nowrap">
								封包编号
						  </th>
						   <th nowrap="nowrap">
								交接人
						  </th>
						   <th nowrap="nowrap">
								购房合同号
						  </th>
						   <th nowrap="nowrap">
								车主姓名
						  </th>
						   <th nowrap="nowrap">
								车主身份证
						  </th>
						   <th nowrap="nowrap">
								机动车登记号
						  </th>
						   <th nowrap="nowrap">
								车牌号
						  </th>
						   <th nowrap="nowrap">
								车架号
						  </th>
						   <th nowrap="nowrap">
								购车发票号
						  </th>
						   <th nowrap="nowrap">
								完税证明号
						  </th>
						   <th nowrap="nowrap">
								保单号
						  </th>
						  <w:radioGroup id="group2">
						  <l:iterate property="mortgageReserveListLog" id="id3">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
								 <td nowrap="nowrap"> 
									<d:write  iterateId="id3" dictTypeId="MORTGAGE_RESERVE_TYPE" property="MORTGAGETYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<d:write  iterateId="id3" dictTypeId="OTHER_TYPE_VIEW" property="OTHERTYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="INSERTTIME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="EMPNAME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="PROJECTNUMBER"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="OTHERWARRANTSNUMBER" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="OTHERWARRANTSDATE" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="BORROWERNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="BORROWERCARDNO" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="ORGNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="MANGERNAME" />
								</td>
								<td nowrap="nowrap"> 
									<d:write  iterateId="id3" dictTypeId="LOAN_TYPE_VIEW" property="LOANTYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="BORROWERCONTRACTNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="LOANYEARS"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="RECORDVALUE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="PACKETNUMBER"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="NEXTNAME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="PURCHASENUMBER"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARNAME"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARCARDNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARREGISTERNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARFRAMENO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARINVOICENO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARDUESNO"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id3" property="CARSAFENO"/>
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						</tr>
					</tbody>
              <td colspan="23" class="command_sort_area">
							
               
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
    			var logRemark=row.getParam("logRemark");
    			var logRemark;
    			var textName="出库处理";
    			if(param==1&&mortgageType==1){
    			  logRemark=row.getParam("logRemark");
    			  if(logRemark<=0){
    			   alert("产权证本数未超过1本,不进行出库处理");
    			   return;
    			  }
    			}
    			var inBorrowerNums="";
    			var inBorrowerLogInfo="";
    			var insertTime="";
			    var url="/mortgage/mortgageReserveAction_toInsertOutInColl.action?mortgageReserveOut.warrantsId="+id+"&mortgageReserveOut.operatingId="+operatingId+"&mortgageReserveOut.outInType="+param+"&mortgageReserveOut.logRemark="+logRemark;
			  
    			if(!checkIsLog(id,operatingId,param)){
    			  return;
    			}
    			if(param==2){
    			    textName="入库处理";
    			    showBorrowerNums(id,operatingId,param);
    			    inBorrowerNums=$("#inBorrowerNums").val();
    			    inBorrowerLogInfo=$("#inBorrowerLogInfo").val();
    			    insertTime=$("#insertTime").val();
			        url=url+"&mortgageReserveOut.inBorrowerNums="+inBorrowerNums+"&mortgageReserveOut.inBorrowerLogInfo="+inBorrowerLogInfo+"&mortgageReserveOut.insertTime="+insertTime;
    			  
    			}
			    showModalCenter(url,param,callBackFunc, 700, 300, textName);
			  }
		}
		
		function checkIsLog(id,operatingId,outInType){
		    var flag=false;
			$.ajax({
				      url: "/mortgage/mortgageReserveAction_checkIsLog.action",
				      async: false,
				      type: 'post',
				      data: "mortgageReserveOut.warrantsId="+id+"&mortgageReserveOut.operatingId="+operatingId+"&mortgageReserveOut.outInType="+outInType,
				      timeout: 60000,
				      success: function (data) {
						   if (data.indexOf("yesexist") >= 0) {
						     if(outInType==1){
						         flag=true;
						     }else{
						       alert("未进行过出库操作,不能进行入库操作！");
						     }
							} else if (data.indexOf("noexist") >= 0) {
							    if(outInType==1){
								 alert("外借未归还或者已注销,不能再进行出库操作！");
							    }else if(outInType==2){
							      flag=true;
							    }
							}else if (data.indexOf("fails") >= 0) {
								alert("操作失败！");
							} else {
								alert("操作失败!");
							}
				      
				      }
				}); 
				
				return flag;
		}
		
		
		
		function showBorrowerNums(id,operatingId,outInType){
		 var flag=false;
			$.ajax({
				      url: "/mortgage/mortgageReserveAction_showBorrowerNums.action",
				      async: false,
				      type: 'post',
				      data: "mortgageReserveOut.warrantsId="+id+"&mortgageReserveOut.operatingId="+operatingId+"&mortgageReserveOut.outInType="+outInType,
				      timeout: 60000,
				      dataType: "json",
				      success: function (data) {
					        var obj= eval(data);
					       $("#inBorrowerNums").val(obj.inBorrowerNums);
					       $("#inBorrowerLogInfo").val(obj.inBorrowerLogInfo);
					       $("#insertTime").val(obj.insertTime);
					       flag=true;
					      
				      }
				}); 
			return flag;	
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