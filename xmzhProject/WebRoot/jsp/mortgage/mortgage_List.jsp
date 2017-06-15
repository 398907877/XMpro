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
					 <h:text property="mortgageReserve.projectNumber" id="projectNumber" style="width:130px;" />	
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
				   <td  colspan="3">
					<h:text property="mortgageReserve.borrowerCardNo" id="borrowerCardNo" style="width:130px;" />	
				   </td>
				</tr>
				<tbody id="tj_fc">
				  <tr>
				    <td class="form_label" align="right" >产权人姓名：</td>
					<td>
					<h:text property="mortgageReserve.propertyName" id="propertyName" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >产权人身份证号：</td>
					<td>
					<h:text property="mortgageReserve.propertyCardNo" id="propertyCardNo" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >产权证号：</td>
					<td>
					<h:text property="mortgageReserve.propertyNo" id="propertyNo" style="width:130px;" />	
					</td>
				  </tr>		
				  <tr>
				    <td class="form_label" align="right" >他项权证号：</td>
					<td>
					<h:text property="mortgageReserve.otherWarrantsNumber" id="otherWarrantsNumber" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >产权地址：</td>
					<td>
					<h:text property="mortgageReserve.propertyAddres" id="propertyAddres" style="width:130px;" />	
					</td>	
					 <td class="form_label" align="right" >贷款种类：</td>
					<td>
					<h:text property="mortgageReserve.loanType" id="loanType" style="width:130px;" />	
					</td>
				  </tr>		
				  <tr>
				    <td class="form_label" align="right" >经办机构：</td>
					<td>
					<h:text property="mortgageReserve.orgCode" id="orgCode" style="width:130px;" readonly="true"/>	
					<a href="#" onclick="open_slzhej_fun1()">选择</a>
					</td>	
					 <td class="form_label" align="right" >已注销未领取：</td>
					<td>
					<d:select id="noRegisterSign" dictTypeId="MORTGAG_REGISTER" property="mortgageReserve.noRegisterSign"  nullLabel="全部" ></d:select>
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
					<h:text property="mortgageReserve.carRegisterno" id="carRegisterNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >车牌号：</td>
					<td>
					<h:text property="mortgageReserve.carNo" id="carNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >车架号：</td>
					<td>
					<h:text property="mortgageReserve.carFrameNo" id="carFrameNo" style="width:130px;" />	
					</td>
				  </tr>		
				  <tr>
				    <td class="form_label" align="right" >购车发票号：</td>
					<td>
					<h:text property="mortgageReserve.carInvoiceNo" id="carInvoiceNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >完税证明号：</td>
					<td>
					<h:text property="mortgageReserve.carDuesNo" id="carDuesNo" style="width:130px;" />	
					</td>
					 <td class="form_label" align="right" >保单号：</td>
					<td>
					<h:text property="mortgageReserve.carSafeNo" id="carSafeNo" style="width:130px;" />	
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
			 <h:hiddendata property="mortgageReserveRes"/>  

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
								贷种
						  </th>
						   <th nowrap="nowrap">
								他项权证号
						  </th>
						   <th nowrap="nowrap">
								借款人
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
							<input type="button" class="button" value="扫描文件上传" onclick="scan_import();"/>
					
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
           init();

        };
		
       //抵押类型改变事件
       function changeMortgageType(val){
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
       $id("borrowerName").value="";
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
			    showModalCenter(url, "",callBackFunc, 1050, 230, '添加押品');
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
			    var url="/mortgage/mortgageReserveAction_toUpdColl.action?mortgageReserveRes.warrantsId="+id+"&mortgageReserveRes.mortgageType="+mortgageType;
			    showModalCenter(url, "",callBackFunc, 1050, 520, '库存变更');
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
			    showModalCenter(url, mortgageType,callBackFunc, 1050, 520, '库存详情');
			  }
		}
		//扫描件上传
		function scan_import(){
		  var gop;
		    gop= $id("group1");
		  var len= gop.getSelectLength();
		  if(len == 0){
	  			alert("请选择一条库存信息");
	  			return;
	  		}else{
	  			var row=gop.getSelectRow();
    			var id = row.getParam("id");
			    var url="/mortgage/scanManagementAction_toAddScanImport.action?scan.warrantsID="+id;
			    showModalCenter(url, "",callBackFunc, 580, 300, '扫描件上传');
			  }
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
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1";
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgname',$id("orgCode").value);
				peArgument[3]=[paramEntity];			
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
						$id("orgCode").value = argRes[1];
					}
		    	}
			}
		</script>
		
	</body>
</html>