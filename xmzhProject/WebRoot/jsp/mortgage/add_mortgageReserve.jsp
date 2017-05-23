<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增入库</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/mortgage/mortgageReserveAction_addItem.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
		    <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		权证的基本信息
	          </td>
	        </tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">押品类型：</td>
				<td colspan="1" width="30%">
				  <d:select id="mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE" property="mortgageReserve.mortgageType" onchange="changeMortgageType(this.value)"  ></d:select>
				</td>		
				<td class="form_label" align="right" width="15%" nowrap="nowrap">他项类型：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
				<div id="otherType_fc">
					<d:select id="otherTypeFC" dictTypeId="OTHER_TYPE_HOUSE" property="tempMortgage.otherTypeFC" ></d:select>
				</div>
				<div id="otherType_jdc"  style="display:none">
					<d:select id="otherTypeJDC" dictTypeId="OTHER_TYPE_CAR" property="tempMortgage.otherTypeJDC" ></d:select>
				</div>
				</td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">预告登记关联：</td>
				<td colspan="1" width="30%">
				<h:text id="noticeRegisterRelation" property="mortgageReserve.noticeRegisterRelation" />
				</td>	
				<td class="form_label" align="right" width="15%">库存序号：</td>
				<td colspan="1" width="30%">
				<h:text id="projectNumber" property="mortgageReserve.projectNumber" validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>
											
			</tr>
			<tr>					
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">他项权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="otherWarrantsNumber" property="mortgageReserve.otherWarrantsNumber" validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>		
				<td class="form_label" align="right" width="15%">他项登记日期：</td>
				<td colspan="1" width="30%">
				<w:date id="otherWarrantsDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="mortgageReserve.otherWarrantsDate" />
				</td>						
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">借款人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerName" property="mortgageReserve.borrowerName" validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="17%">借款人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerCardNo" property="mortgageReserve.borrowerCardNo" validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">经办机构：</td>
				<td colspan="1" width="30%">
				<h:hidden id="orgCode" property="mortgageReserve.orgCode" />
				<h:text id="orgName" property="mortgageReserve.orgName" validateAttr="allowNull=false" /><font style="color: red">*</font>
				<a href="#" onclick="open_slzhej_fun1()">选择</a>
				</td>	
				<td class="form_label" align="right" width="15%">经办客户经理：</td>
				<td colspan="1" width="30%">
				<h:text id="mangerName" property="mortgageReserve.mangerName" validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
										
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">贷款种类：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
				<div id="loanType_fc">
					<d:select id="loanTypeFC" dictTypeId="LOAN_TYPE_HOUSE" property="tempMortgage.loanTypeFC" ></d:select>
				</div>
				<div id="loanType_jdc">
					<d:select id="loanTypeJDC" dictTypeId="LOAN_TYPE_CAR" property="tempMortgage.loanTypeJDC" ></d:select>
				</div>
				</td>	
				<td class="form_label" align="right" width="15%">借款合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerContractNo" property="mortgageReserve.borrowerContractNo" validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">贷款年限：</td>
				<td colspan="1" width="30%">
				<h:text id="loanYears" size="5"  property="mortgageReserve.loanYears" />年
				</td>		
				<td class="form_label" align="right" width="15%">封包编号：</td>
				<td colspan="1" width="30%">
				<h:text id="packetNumber"   property="mortgageReserve.packetNumber"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">交接人：</td>
				<td colspan="1" width="30%">
				<h:text id="nextName"   property="mortgageReserve.nextName"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">备注信息：</td>
				<td colspan="1" width="30%">
				<h:text id="remark"   property="mortgageReserve.remark" />
				</td>					
			</tr>
			  <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		抵质押品信息
	          </td>
	        </tr>
	        <tbody id="dzypxx_fc">
			<tr>	
				<td class="form_label" align="right" width="15%">产权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNo"   property="mortgageReserveHouse.propertyNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyName"   property="mortgageReserveHouse.propertyName"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">产权人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyCardNo"   property="mortgageReserveHouse.propertyCardNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权地址：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyAddres"   property="mortgageReserveHouse.propertyAddres"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">产权证本数：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNums"  size="5"  property="mortgageReserveHouse.propertyNums"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权证填发日期：</td>
				<td colspan="1" width="30%">
				<w:date id="propertyDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="mortgageReserveHouse.propertyDate" />
				</td>					
			</tr>
			</tbody>
			<tbody id="dzypxx_jdc" style="display:none">
			<tr>	
				<td class="form_label" align="right" width="15%">车主姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="carName"   property="mortgageReserveCar.carName"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车主身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carCardNo"   property="mortgageReserveCar.carCardNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">机动车登记证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carRegisterNo"   property="mortgageReserveCar.carRegisterNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车牌号：</td>
				<td colspan="1" width="30%">
				<h:text id="carNo"   property="mortgageReserveCar.carNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">车架号：</td>
				<td colspan="1" width="30%">
				<h:text id="carFrameNo"   property="mortgageReserveCar.carFrameNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">购车发票号：</td>
				<td colspan="1" width="30%">
				<h:text id="carInvoiceNo"   property="mortgageReserveCar.carInvoiceNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">完税证明号：</td>
				<td colspan="1" width="30%">
				<h:text id="carDuesNo"   property="mortgageReserveCar.carDuesNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">保单号：</td>
				<td colspan="1" width="30%">
				<h:text id="carSafeNo"   property="mortgageReserveCar.carSafeNo"  validateAttr="allowNull=false" /><font style="color: red">*</font>
				</td>					
			</tr>
			</tbody>
			<tr>
				<td colspan="4" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
			
		</table>
	</h:form>
<script type="text/javascript">


function changeMortgageType(val){
        if(val=="0"){
	        $("#otherType_fc").show();
	        $("#otherType_jdc").hide();
	        $("#loanType_fc").show();
	        $("#loanType_jdc").hide();
	        $("#dzypxx_fc").show();
	        $("#dzypxx_jdc").hide();
	       }else if(val=="1"){
	        $("#otherType_jdc").show();
	        $("#otherType_fc").hide();
	        $("#loanType_jdc").show();
	        $("#loanType_fc").hide();
	        $("#dzypxx_jdc").show();
	        $("#dzypxx_fc").hide();
	       }
}
	function save(){
	var frm=$name("data_form");
 		if(!checkForm(frm)){
			 return ;
		 }
    ajaxsubmitO();
		
	}


	function ajaxsubmitO() {
		maskTop();
		var options = {
			type : "post",
			cache : "false",
			success : function(data) {
				try {
					if (data.indexOf("success") >= 0) {
						alert("保存成功!");
						unMaskTop();
						window.close();
					} else if (data.indexOf("fails") >= 0) {
						alert("保存失败!");
					} else {
						alert("操作失败!");
					}
				} catch (Exception) {
				}
			},
			error : function(data) {
				alert("添加失败请联系管理员！");
			}
		};
		
		$("#data_form").ajaxSubmit(options);
	}

	    //经办机构
		function open_slzhej_fun1(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1";
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