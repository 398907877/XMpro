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
	<h:form name="query_form"	action="/mortgage/mortgageReserveAction_queryMortgageReserveList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
					<td class="form_label" align="right">押品类型：</td>
					<td >
						<d:select id="mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE" property="mortgageReserve.mortgageType" onchange="changeMortgageType(this.value)"  ></d:select>
					</td>
					<td class="form_label" align="right" >库存序号：</td>
					<td>
					 <h:text property="mortgageReserve.projectNumber" id="projectNumber"  style="width:130px;" />	
					</td>
					<td class="form_label" align="right">库存状态：</td>
					<td >
						<d:select id="status" dictTypeId="MORTGAG_STATUS" property="mortgageReserve.status"  nullLabel="全部" ></d:select>
					</td>
				</tr>
				<tr>
				   <td class="form_label" align="right" >借款人姓名：</td>
				   <td>
					<h:text property="mortgageReserve.borrowerName" id="borrowerName" style="width:130px;" />	
				   </td>
				   <td  class="form_label" align="right" >借款人身份证号：</td>
				   <td >
					<h:text property="mortgageReserve.borrowerCardNo" id="borrowerCardNo" style="width:130px;" />	
				   </td>
					<td class="form_label" align="right">他项类型：</td>
					<td >
						<d:select id="otherType" dictTypeId="OTHER_TYPE_VIEW" property="mortgageReserve.otherType"  nullLabel="全部"  ></d:select>
					</td>
				</tr>
				<tbody id="tj_fc">
				  <tr>
				    <td class="form_label" align="right" >产权人姓名：</td>
					<td>
					<h:text property="mortgageReserveHouse.propertyName" id="propertyName" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >产权人身份证号：</td>
					<td>
					<h:text property="mortgageReserveHouse.propertyCardNo" id="propertyCardNo" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >产权证号：</td>
					<td>
					<h:text property="mortgageReserveHouse.propertyNo" id="propertyNo" style="width:130px;" />	
					</td>
				  </tr>		
				  <tr>
				    <td class="form_label" align="right" >他项权证号：</td>
					<td>
					<h:text property="mortgageReserve.otherWarrantsNumber" id="otherWarrantsNumber" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >产权地址：</td>
					<td>
					<h:text property="mortgageReserveHouse.propertyAddres" id="propertyAddres" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >贷款种类：</td>
					<td>
					<d:select id="loanType" dictTypeId="LOAN_TYPE_HOUSE" property="mortgageReserve.loanType" nullLabel="全部" ></d:select>
					</td>
				  </tr>		
				  <tr>
				    <td class="form_label" align="right" >经办机构：</td>
					<td>
					<h:hidden id="orgCode" property="mortgageReserve.orgCode" />
					<h:text id="orgName" property="mortgageReserve.orgName"  style="width:130px;"/>
					<a href="#" onclick="open_slzhej_fun1()">支行选择</a>
					</td>	
					 <td class="form_label" align="right" >已注销未领取：</td>
					<td>
					<d:select id="logOutSign" dictTypeId="LOGOUT_MORTGAG_REGISTER" property="mortgageReserve.logOutSign"  nullLabel="全部" ></d:select>
					</td>
					 <td class="form_label" align="right" >补登记标志：</td>
					<td>
					<d:select id="noRegisterSign" dictTypeId="MORTGAG_REGISTER" property="mortgageReserve.noRegisterSign"  nullLabel="全部" ></d:select>
					</td>
				  </tr>		
				</tbody>
				<tbody id="tj_jdc" style="display:none">	
				  <tr>
				    <td class="form_label" align="right" >机动车登记证号：</td>
					<td>
					<h:text property="mortgageReserveCar.carRegisterNo" id="carRegisterNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >车牌号：</td>
					<td>
					<h:text property="mortgageReserveCar.carNo" id="carNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >车架号：</td>
					<td>
					<h:text property="mortgageReserveCar.carFrameNo" id="carFrameNo" style="width:130px;" />	
					</td>
				  </tr>		
				  <tr>
				    <td class="form_label" align="right" >购车发票号：</td>
					<td>
					<h:text property="mortgageReserveCar.carInvoiceNo" id="carInvoiceNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >完税证明号：</td>
					<td>
					<h:text property="mortgageReserveCar.carDuesNo" id="carDuesNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >保单号：</td>
					<td>
					<h:text property="mortgageReserveCar.carSafeNo" id="carSafeNo" style="width:130px;" />	
					</td>
				  </tr>			
				</tbody>
				<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button" >
							<input type="button" value="清 空" class="button" onclick="clears();">
                           <input id="downexl" type="button" class="button" value="导出列表" onclick="excelExport();"></td>
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
			 <h:hiddendata property="mortgageReserveHouse"/> 
			 <h:hiddendata property="mortgageReserveCar"/> 

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
								他项类型
						  </th>
						   <th nowrap="nowrap">
								库存序号
						  </th>
						   <th nowrap="nowrap">
								贷款种类
						  </th>
						   <th nowrap="nowrap">
								他项权证号
						  </th>
						   <th nowrap="nowrap">
								借款人姓名
						  </th>
						   <th nowrap="nowrap">
								借款人身份证号
						  </th>
						   <th nowrap="nowrap">
								库存状态
						  </th>
						  <w:radioGroup id="group1">
						  <l:iterate property="mortgageReserveList" id="id2">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />">
							  
								<td align="center" nowrap="nowrap" width="5%">
								<w:rowRadio>
										<h:param name='id' iterateId='id2' property='WARRANTSID' />
										<h:param name='warrantsidStatus' iterateId='id2' property='STATUS' />
									</w:rowRadio>
								</td>
								<td nowrap="nowrap"> 
								 <d:write  iterateId="id2" dictTypeId="OTHER_TYPE_VIEW" property="OTHERTYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="PROJECTNUMBER" />
								</td>
								<td nowrap="nowrap"> 
									<d:write  iterateId="id2" dictTypeId="LOAN_TYPE_VIEW" property="LOANTYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="OTHERWARRANTSNUMBER" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="BORROWERNAME" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id2" property="BORROWERCARDNO" />
								</td>
								<td nowrap="nowrap"> 
									<d:write  iterateId="id2" dictTypeId="MORTGAG_STATUS" property="STATUS"/>
								</td>
							</tr>
						</l:iterate>
					</w:radioGroup>
						</tr>
					
              <td colspan="23" class="command_sort_area">
              	<div class="h3"> 
							<input type="button" class="button" value="新增入库" onclick="add();"/>
							<input type="button" class="button" value="添加押品" onclick="add_coll();"/>
							<input type="button" class="button" value="库存详情" onclick="view_Infos();"/>
							<input type="button" class="button" value="出入库处理" onclick="outIn_coll();"/>
							<input type="button" class="button" value="库存变更" onclick="upd_coll();"/>
							<input type="button" class="button" value="库存变更明细" onclick="detail_coll();"/>
					
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
	     var val=$("#mortgageType").val();
           init();

        };
		
       //抵押类型改变事件
       function changeMortgageType(val){
       if(val=="1"){
        //document.getElementById("tj_jdc").style.display = "none";
       // document.getElementById("tj_fc").style.display = "block";
        $("#tj_fc").show();
        $("#tj_jdc").hide();
        $("#loanType_fc").show();
        $("#loanType_jdc").hide();
       }else if(val=="2"){
        //document.getElementById("tj_fc").style.display = "none";
       // document.getElementById("tj_fc").style.display = "block";
        $("#tj_jdc").show();
        $("#tj_fc").hide();
        $("#loanType_jdc").show();
        $("#loanType_fc").hide();
       }
        clears();
        callBackFunc();
       }



       //抵押类型改变事件
       function init(){
       var val=$("#mortgageType").val();
       if(val=="1"){
        //document.getElementById("tj_jdc").style.display = "none";
       // document.getElementById("tj_fc").style.display = "block";
        $("#tj_fc").show();
        $("#tj_jdc").hide();
       }else if(val=="2"){
        //document.getElementById("tj_fc").style.display = "none";
       // document.getElementById("tj_fc").style.display = "block";
        $("#tj_jdc").show();
        $("#tj_fc").hide();
       }
       
       }

		//清空
		function clears(){
           $id("otherType").value="";
           $id("projectNumber").value="";
           $id("status").value="";
           $id("borrowerName").value="";
           $id("borrowerCardNo").value="";
           $id("propertyName").value="";
           $id("propertyCardNo").value="";
           $id("propertyNo").value="";
           $id("otherWarrantsNumber").value="";
           $id("propertyAddres").value="";
           $id("loanType").value="";
           $id("orgCode").value="";
           $id("orgName").value="";
           $id("logOutSign").value="";
           $id("noRegisterSign").value="";
           $id("carRegisterNo").value="";
           $id("carNo").value="";
           $id("carFrameNo").value="";
           $id("carInvoiceNo").value="";
           $id("carDuesNo").value="";
           $id("carSafeNo").value="";
		}
		function add1(){
		  var gop;
		  var mortgageType=$("#mortgageType").val();
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var rows=gop.getSelectRow();
		  		var updateTime=rows.getParam("updateTime");
		  		alert(updateTime);
		  	}
		}
		
		
		//新增
		function add(){
		  var mortgageType=$("#mortgageType").val();
			 var url="/mortgage/mortgageReserveAction_toAddItem.action";
			  showModalCenter(url, mortgageType,callBackFunc, 1050, 520, '新增入库');
		}
        //添加押品
		function add_coll(){
		  var gop;
		  var mortgageType=$("#mortgageType").val();
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
			    var url="/mortgage/mortgageReserveAction_toAddColl.action?mortgageReserveRes.warrantsId="+id+"&mortgageReserveRes.mortgageType="+mortgageType;
			    showModalCenter(url, mortgageType,"", 1050, 520, '添加押品');
			  }
		}
		
		
		
        //出入库处理
		function outIn_coll(){
		  var gop;
		  var mortgageType=$("#mortgageType").val();
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
			    var url="/mortgage/mortgageReserveAction_toOutInColl.action?mortgageReserveRes.warrantsId="+id+"&mortgageReserveRes.mortgageType="+mortgageType;
			    parent.window.frames["mainFrame"].location.href = encodeURI(url);	
			    //showModalCenter(url, mortgageType,callBackFunc, 1050, 520, '出入库处理');
			  }
		}
		
		
		
		//库存变更
		function upd_coll(){
		 var gop;
		  var mortgageType=$("#mortgageType").val();
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
    			var warrantsidStatus=row.getParam("warrantsidStatus");
    			if(warrantsidStatus==2){
    			 alert("库存状态为注销,不能进行库存变更操作!");
    			 return;
    			}
			    var url="/mortgage/mortgageReserveAction_toUpdColl.action?mortgageReserveRes.warrantsId="+id+"&mortgageReserveRes.mortgageType="+mortgageType;
			    showModalCenter(url, mortgageType,callBackFunc, 1050, 520, '库存变更');
			  }
		}
		
		//库存详情
		function view_Infos(){
		 var gop;
		  var mortgageType=$("#mortgageType").val();
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
			    var url="/mortgage/mortgageReserveAction_toViewInfos.action?mortgageReserveRes.warrantsId="+id+"&mortgageReserveRes.mortgageType="+mortgageType;
			    showModalCenter(url, mortgageType,"", 1050, 520, '库存详情');
			  }
		}
		
		 //库存变更明细
		function detail_coll(){
		 var gop;
		  var mortgageType=$("#mortgageType").val();
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
			    var url="/mortgage/mortgageReserveAction_toDetailColl.action?mortgageReserveRes.warrantsId="+id+"&mortgageReserveRes.mortgageType="+mortgageType;
			    showModalCenter(url, mortgageType,"", 1000, 500, '库存变更明细');
			  }
		}   
             
   $("#orgName").blur(function(){
   
        var orgName =$("#orgName").val();
		$.ajax({
			url : "/mortgage/mortgageReserveAction_queryOrgs.action",
			async : false,
			type : 'post',
			data : "mortgageReserve.orgName=" + orgName,
			timeout : 60000,
			dataType : 'json',
			success : function(json) {

				if (json == ""||json==null) { 
				  $("#orgName").val("");
			      $("#orgCode").val("");
				}else {
				   $.each(eval(json), function (n, value) {
					 if(n==0){
						 var  orgname = value.orgName;
						 var  orgCode = value.orgCode;
						 $("#orgName").val(orgname);
						 $("#orgCode").val(orgCode);
					
						 }
	              });
				
				}

				

			}
		});
    });
        
			

            //导出excel 	
             function excelExport(){
                    //押品类型
    				var mortgageType = $id("mortgageType").value;
                    //库存序号
    				var projectNumber = $id("projectNumber").value;
                    //库存状态
    				var status = $id("status").value;
                    //借款人姓名
    				var borrowerName = $id("borrowerName").value;
                    //借款人姓名
    				var borrowerCardNo = $id("borrowerCardNo").value;
                    //产权人姓名
    				var propertyName = $id("propertyName").value;
                    //产权人身份证号
    				var propertyCardNo = $id("propertyCardNo").value;
                    //产权证号
    				var propertyNo = $id("propertyNo").value;
                    //他项权证号
    				var otherWarrantsNumber = $id("otherWarrantsNumber").value;
                    //产权地址
    				var propertyAddres = $id("propertyAddres").value;
                    //贷款种类
    				var loanType = $id("loanType").value;
                    //经办机构
    				var orgCode = $id("orgCode").value;
                    //注销未领取
    				var logOutSign = $id("logOutSign").value;
                    //注销未领取
    				var noRegisterSign = $id("noRegisterSign").value;
                    //机动车登记证号
    				var carRegisterNo = $id("carRegisterNo").value;
                    //车牌号
    				var carNo = $id("carNo").value;
                    //车架号
    				var carFrameNo = $id("carFrameNo").value;
                    //购车发票号
    				var carInvoiceNo = $id("carInvoiceNo").value;
                    //完税证明号
    				var carDuesNo = $id("carDuesNo").value;
                    //保单号
    				var carSafeNo = $id("carSafeNo").value;
    				var strUrl = "/mortgage/mortgageReserveAction_queryMortgageReserveListExcel.action?";
    	    		strUrl=strUrl+"&mortgageReserve.mortgageType="+mortgageType;
    				if(projectNumber != ""){strUrl=strUrl+"&mortgageReserve.projectNumber="+projectNumber;}
    				if(status != ""){strUrl=strUrl+"&mortgageReserve.status="+status;}
    				if(borrowerName != ""){strUrl=strUrl+"&mortgageReserve.borrowerName="+borrowerName;}
    				if(borrowerCardNo != ""){strUrl=strUrl+"&mortgageReserve.borrowerCardNo="+borrowerCardNo;}
    				if(propertyName != ""){strUrl=strUrl+"&mortgageReserveHouse.propertyName="+propertyName;} 
    				if(propertyCardNo != ""){strUrl=strUrl+"&mortgageReserveHouse.propertyCardNo="+propertyCardNo;} 
    				if(propertyNo != ""){strUrl=strUrl+"&mortgageReserveHouse.propertyNo="+propertyNo;}
    				if(otherWarrantsNumber != ""){strUrl=strUrl+"&mortgageReserve.otherWarrantsNumber="+otherWarrantsNumber;}
    				if(propertyAddres != ""){strUrl=strUrl+"&mortgageReserveHouse.propertyAddres="+propertyAddres;}
    				if(loanType != ""){strUrl=strUrl+"&mortgageReserve.loanType="+loanType;}
    				if(orgCode != ""){strUrl=strUrl+"&mortgageReserve.orgCode="+orgCode;}
    				if(logOutSign != ""){strUrl=strUrl+"&mortgageReserve.logOutSign="+logOutSign;}
    				if(noRegisterSign != ""){strUrl=strUrl+"&mortgageReserve.noRegisterSign="+noRegisterSign;}
    				if(carRegisterNo != ""){strUrl=strUrl+"&mortgageReserveCar.carRegisterNo="+carRegisterNo;}
    				if(carNo != ""){strUrl=strUrl+"&mortgageReserveCar.carNo="+carNo;}
    				if(carFrameNo != ""){strUrl=strUrl+"&mortgageReserveCar.carFrameNo="+carFrameNo;}
    				if(carInvoiceNo != ""){strUrl=strUrl+"&mortgageReserveCar.carInvoiceNo="+carInvoiceNo;}
    				if(carDuesNo != ""){strUrl=strUrl+"&mortgageReserveCar.carDuesNo="+carDuesNo;}
    				if(carSafeNo != ""){strUrl=strUrl+"&mortgageReserveCar.carSafeNo="+carSafeNo;}
    				
    				//alert(strUrl);
    				window.location.href=strUrl;
             
             }


		
		function callBackFunc(){
			var frm = $name("query_form");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
			}
		//经办机构
		function open_slzhej_fun1(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			strUrl = "/deviceManagement/myMainTreeAction_initMainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=4&orgflag=2&changeTree.checkcount=1";
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgcode',$id("orgCode").value);
				paramEntity.setProperty('orgname',$id("orgName").value);
				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];	
			showModalCenter(strUrl,peArgument,open_slzhej_callback1,600,430,objName); 
			}
		
		//选择经办机构回调方法
		function open_slzhej_callback1(arg){//回调方法
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgCode").value = argRes[0];
						$id("orgName").value = argRes[1];
					}
		    	}
			}
		</script>
		
	</body>
</html>