<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/fileDownWarrants.js"></script>
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
					<d:select id="otherTypeFC" dictTypeId="OTHER_TYPE_HOUSE" property="tempMortgage.otherTypeFC"  nullLabel="请选择"  ></d:select><font id="otherTypeFC_msg" style="color: red">*</font>
				</div>
				<div id="otherType_jdc"  style="display:none">
					<d:select id="otherTypeJDC" dictTypeId="OTHER_TYPE_CAR" property="tempMortgage.otherTypeJDC" nullLabel="请选择"  ></d:select><font id="otherTypeJDC_msg" style="color: red">*</font>
				</div>
				</td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">预告登记关联：</td>
				<td colspan="3" width="30%">
				<h:text id="noticeRegisterRelation" property="mortgageReserve.noticeRegisterRelation" />
				<a href="#" onclick="open_generate_fun1()">关联</a> 
				<font id="noticeRegisterRelation_msg"  style="color: red"></font>
				</td>					
			</tr>
			<tr>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">库存序号：</td>
				<td colspan="1" width="30%">
				<h:text id="projectNumber" property="mortgageReserve.projectNumber"/><font style="color: red">*</font>
				</td>
				<td class="form_label" align="right" width="15%">他项权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="otherWarrantsNumber" property="mortgageReserve.otherWarrantsNumber"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">他项登记日期：</td>
				<td colspan="1" width="30%">
				<w:date id="otherWarrantsDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd"  readonly="true" property="mortgageReserve.otherWarrantsDate" />
				</td>			
				<td class="form_label" align="right" width="15%">借款人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerName" property="mortgageReserve.borrowerName"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">借款人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerCardNo" property="mortgageReserve.borrowerCardNo"/><font style="color: red">*</font>
				</td>		
				<td class="form_label" align="right" width="15%">经办机构：</td>
				<td colspan="1" width="30%">
				<h:hidden id="orgCode" property="mortgageReserve.orgCode" />
				<h:text id="orgName" property="mortgageReserve.orgName"  readonly="true" /><font style="color: red">*</font>
				<a href="#" onclick="open_slzhej_fun1()">选择</a>
				</td>				
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">经办客户经理：</td>
				<td colspan="1" width="30%">
				<h:text id="mangerName" property="mortgageReserve.mangerName"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">贷款种类：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
				<div id="loanType_fc">
					<d:select id="loanTypeFC" dictTypeId="LOAN_TYPE_HOUSE" property="tempMortgage.loanTypeFC" nullLabel="请选择" ></d:select><font style="color: red">*</font>
				</div>
				<div id="loanType_jdc"  style="display:none">
					<d:select id="loanTypeJDC" dictTypeId="LOAN_TYPE_CAR" property="tempMortgage.loanTypeJDC" nullLabel="请选择" ></d:select><font style="color: red">*</font>
				</div>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">借款合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerContractNo" property="mortgageReserve.borrowerContractNo"/><font style="color: red">*</font>
				</td>
				<td class="form_label" align="right" width="15%">贷款年限：</td>
				<td colspan="1" width="30%">
				<h:text id="loanYears" size="5"  property="mortgageReserve.loanYears" />年
				</td>					
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">入账价值：</td>
				<td colspan="1" width="30%">
				<h:text id="recordValue"   property="mortgageReserve.recordValue" />
				</td>		
				<td class="form_label" align="right" width="15%">封包编号：</td>
				<td colspan="1" width="30%">
				<h:text id="packetNumber"   property="mortgageReserve.packetNumber" /><font style="color: red">*</font>
				</td>				
			</tr>
			<tr>				
				<td class="form_label" align="right" width="15%">交接人：</td>
				<td colspan="1" width="30%">
				<h:text id="nextName"   property="mortgageReserve.nextName" /><font style="color: red">*</font>
				</td>		
				<td class="form_label" align="right" width="15%">购房合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="purchaseNumber"   property="mortgageReserve.purchaseNumber" />
				</td>					
			</tr>
		    <tr id="row1" style="display:none" >
		      <td class="form_label" align="right">附件下载：</td>
		      <td colspan="3">
		      <div id="tag"></div>
		      </td>
		     </tr>
		     <tr id="rowFile">
		     	<td class="form_label" align="right">上传附件：</td>
		     	<td colspan="3">
						<input type="button" onclick="addFile('tabtest','files');return false;" value="新增附件" 
							style="margin-left:2px;vertical-align:middle;cursor:hand;"/>
						<font style="color: red">(说明：最多上传5个附件)</font>
						<br/>
						<table border=0 id="tabtest">
						</table>
		     	</td>
		     </tr>
			<tr>
				<td class="form_label" align="right" width="15%">备注信息：</td>
				<td colspan="3" width="30%">
				 <h:textarea rows="5"  cols="30"   property="mortgageReserve.remark" />
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
				<h:text id="propertyNo"   property="mortgageReserveHouse.propertyNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyName"   property="mortgageReserveHouse.propertyName" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">产权人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyCardNo"   property="mortgageReserveHouse.propertyCardNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">产权地址：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyAddres"   property="mortgageReserveHouse.propertyAddres" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">产权证本数：</td>
				<td colspan="1" width="30%">
				<h:text id="propertyNums"  size="5"  property="mortgageReserveHouse.propertyNums" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="17%">产权证填发日期：</td>
				<td colspan="1" width="30%">
				<w:date id="propertyDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd"  readonly="true" property="mortgageReserveHouse.propertyDate" />
				</td>					
			</tr>
			</tbody>
			<tbody id="dzypxx_jdc" style="display:none">
			<tr>	
				<td class="form_label" align="right" width="15%">车主姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="carName"   property="mortgageReserveCar.carName" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车主身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carCardNo"   property="mortgageReserveCar.carCardNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">机动车登记证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carRegisterNo"   property="mortgageReserveCar.carRegisterNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车牌号：</td>
				<td colspan="1" width="30%">
				<h:text id="carNo"   property="mortgageReserveCar.carNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">车架号：</td>
				<td colspan="1" width="30%">
				<h:text id="carFrameNo"   property="mortgageReserveCar.carFrameNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">购车发票号：</td>
				<td colspan="1" width="30%">
				<h:text id="carInvoiceNo"   property="mortgageReserveCar.carInvoiceNo" /><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">完税证明号：</td>
				<td colspan="1" width="30%">
				<h:text id="carDuesNo"   property="mortgageReserveCar.carDuesNo" /><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">保单号：</td>
				<td colspan="1" width="30%">
				<h:text id="carSafeNo"   property="mortgageReserveCar.carSafeNo" /><font style="color: red">*</font>
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
 window.onload = function () {
     var parWin = window.dialogArguments;
     $id("mortgageType").value=parWin;
          changeMortgageType(parWin);

        };

function changeMortgageType(val){
        //$(".alert_message").hide();
	       // $("#otherTypeFC").attr("validateAttr",""); 
	      //  $("#otherTypeJDC").attr("validateAttr",""); 
        $("#otherTypeFC").val("");
        $("#otherTypeJDC").val("");
        //$("#otherTypeFC_msg").text("*");
        //$("#otherTypeJDC_msg").text("*");
        $("#otherTypeJDC").val("");
        $("#loanTypeFC").val("");
        $("#loanTypeJDC").val("");
        if(val=="1"){
	        $("#otherType_fc").show();
	        $("#otherType_jdc").hide();
	        $("#loanType_fc").show();
	        $("#loanType_jdc").hide();
	        $("#dzypxx_fc").show();
	        $("#dzypxx_jdc").hide();
	       }else if(val=="2"){
	        $("#otherType_jdc").show();
	        $("#otherType_fc").hide();
	        $("#loanType_jdc").show();
	        $("#loanType_fc").hide();
	        $("#dzypxx_jdc").show();
	        $("#dzypxx_fc").hide();
	       }
}
	function save(){
	     if($id("mortgageType").value == "1"){
			if($id("otherTypeFC").value == ""){
			 alert("他项类型不能为空！");
			 return;
			}
		}else if($id("mortgageType").value == "2"){
			if($id("otherTypeJDC").value == ""){
				 alert("他项类型不能为空！");
				 return;
			}
		}
	   if($id("projectNumber").value == ""){
			alert("库存序号不能为空！");
			$id("projectNumber").focus();
			return;
		}
	   if($id("otherWarrantsNumber").value == ""){
			alert("他项权证号不能为空！");
			$id("otherWarrantsNumber").focus();
			return;
		}
	   if($id("borrowerName").value == ""){
			alert("借款人姓名不能为空！");
			$id("borrowerName").focus();
			return;
		}
	   if($id("borrowerCardNo").value == ""){
			alert("借款人身份证号不能为空！");
			$id("borrowerCardNo").focus();
			return;
		}
	   if($id("orgCode").value == ""){
			alert("经办机构不能为空！");
			$id("orgCode").focus();
			return;
		}
	   if($id("mangerName").value == ""){
			alert("经办客户经理不能为空！");
			$id("mangerName").focus();
			return;
		}
		
	   if($id("mortgageType").value == "1"){
			if($id("loanTypeFC").value == ""){
			 alert("贷款种类不能为空！");
			 return;
			}
		}else if($id("mortgageType").value == "2"){
			if($id("loanTypeJDC").value == ""){
				 alert("贷款种类不能为空！");
				 return;
			}
		}
		
		
	   if($id("borrowerContractNo").value == ""){
			alert("借款合同号不能为空！");
			$id("borrowerContractNo").focus();
			return;
		}
		
	   if($id("packetNumber").value == ""){
			alert("封包编号不能为空！");
			$id("packetNumber").focus();
			return;
		}
	   if($id("nextName").value == ""){
			alert("交接人不能为空！");
			$id("nextName").focus();
			return;
		}
		
		
	   if($id("mortgageType").value == "1"){
		   if($id("propertyNo").value == ""){
				alert("产权证号不能为空！");
				$id("propertyNo").focus();
				return;
			}
			
		   if($id("propertyName").value == ""){
				alert("产权人姓名不能为空！");
				$id("propertyName").focus();
				return;
			}
			
		   if($id("propertyCardNo").value == ""){
				alert("产权人身份证号不能为空！");
				$id("propertyCardNo").focus();
				return;
			}
			if($id("propertyAddres").value == ""){
				alert("产权地址不能为空！");
				$id("propertyAddres").focus();
				return;
			}
			if($id("propertyNums").value == ""){
				alert("产权证本数不能为空！");
				$id("propertyNums").focus();
				return;
			}
		}else if($id("mortgageType").value == "2"){
		   if($id("carName").value == ""){
				alert("车主姓名不能为空！");
				$id("carName").focus();
				return;
			}
			if($id("carCardNo").value == ""){
				alert("车主身份证号不能为空！");
				$id("carCardNo").focus();
				return;
			}
			if($id("carRegisterNo").value == ""){
				alert("机动车登记证号不能为空！");
				$id("carRegisterNo").focus();
				return;
			}
			if($id("carNo").value == ""){
				alert("车牌号不能为空！");
				$id("carNo").focus();
				return;
			}
			if($id("carFrameNo").value == ""){
				alert("车架号不能为空！");
				$id("carFrameNo").focus();
				return;
			}
			if($id("carInvoiceNo").value == ""){
				alert("购车发票号不能为空！");
				$id("carInvoiceNo").focus();
				return;
			}
			if($id("carDuesNo").value == ""){
				alert("完税证明号不能为空！");
				$id("carDuesNo").focus();
				return;
			}
			if($id("carSafeNo").value == ""){
				alert("保单号不能为空！");
				$id("carSafeNo").focus();
				return;
			}
		}
 		///if(!checkForm(frm)){
		//	 return ;
		// }
	   
		 var otherWarrantsNumber= $id("otherWarrantsNumber").value;  //他项权证号
		 var projectNumber= $id("projectNumber").value;  //库存序号
	    $.ajax({
			      url: "/mortgage/mortgageReserveAction_checkOtherWarrantsNumber.action",
			      async: false,
			      type: 'post',
			      data: "mortgageReserve.otherWarrantsNumber="+otherWarrantsNumber+"&mortgageReserve.projectNumber="+projectNumber,
			      timeout: 60000,
			      success: function (data) {
					   if (data.indexOf("noExist") >= 0) {
				    		  ajaxsubmitO();
						} else if (data.indexOf("twoexist") >= 0) {
			                 $id("otherWarrantsNumber").focus();	
							alert("操作失败！该他项权证号("+otherWarrantsNumber+")和库存序号("+projectNumber+")系统中号码重复！请重新填写！");
						} else if (data.indexOf("othexist") >= 0) {
			                 $id("otherWarrantsNumber").focus();	
							alert("操作失败！该他项权证号("+otherWarrantsNumber+")系统中号码重复！请重新填写！");
						} else if (data.indexOf("proexist") >= 0) {
			                 $id("projectNumber").focus();	
							alert("操作失败！库存序号("+projectNumber+")系统中号码重复！请重新填写！");
						} else if (data.indexOf("fails") >= 0) {
							alert("库存序号和他项权证号校验失败！");
						} else {
							alert("操作失败!");
						}
			      
			      }
			}); 
		
	}
	
	//验证表单非空
    function check_sumbmit(){
	
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
	
	
	function open_generate_fun1(){
		 var noticeRegisterRelation= $id("noticeRegisterRelation").value;  //库存序号
		 var mortgageType= $id("mortgageType").value;  //库存序号
		 if(noticeRegisterRelation!=null&&noticeRegisterRelation!=""){
		  $.ajax({
				      url: "/mortgage/mortgageReserveAction_openGenerate.action",
				      async: false,
				      type: 'post',
				      data: "mortgageReserve.noticeRegisterRelation="+noticeRegisterRelation,
				      timeout: 60000,
				      dataType: "json",
				      success: function (data) {
					      var obj= eval(data);
					      var code=obj.errcode;
					      var errmsg=obj.errmsg;
					      if(code=="0001"){
					       $("#noticeRegisterRelation_msg").text(errmsg);
					      }else{
					       $("#noticeRegisterRelation_msg").text("");
					       $("#borrowerName").val(obj.borrowerName);
					       $("#borrowerCardNo").val(obj.borrowerCardNo);
					       $("#borrowerContractNo").val(obj.borrowerContractNo);
					       $("#orgCode").val(obj.orgCode);
					       $("#orgName").val(obj.orgName);
					       $("#mangerName").val(obj.mangerName);
					       $("#loanYears").val(obj.loanYears);
					       if(mortgageType=="1"){
					         $("#loanTypeFC").val(obj.loanType);
					       }else if(mortgageType=="2"){
					         $("#loanTypeJDC").val(obj.loanType);
					       }
					       $("#recordValue").val(obj.recordValue);
					       file_app(obj.id)
					      }
				      
				      },
					error : function(data) {
						$("#noticeRegisterRelation_msg").text("系统查无此记录!");
					}
				});
		 }else{
		  $("#noticeRegisterRelation_msg").text("系统查无此记录!");
		 }
        
	}
	
	function file_app(param){
	  $.ajax({
	        url: '/mortgage/mortgageReserveAction_queryFileList.action',
	        async: false,
	        type: 'post',
	        data: "resourceId="+param,
	        dataType: 'json',
	        timeout: 60000,
	        success: function (files) {
		        if(files!=""){
		         	$.each(files,function( i,item ){
		        	    $("#row1").show(); 
		    	        $("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
		          		});	
		        }else{
		        	 $("#row1").css("display","none");  
		        }  
	        }
      });
	  
	
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
			
		var rowId = 0;
		function addFile(tabid,varName){
		    var tab,row,td,fName,fId,tdStr;
		    var zs=$("#tabtest tbody tr").length;
		    tab = $id(tabid);
		    if (zs>=5){
		    	alert("新增附件不能超过5个");
		    	return false;
		    }
		    fName = varName;
		    fId = varName+rowId;
		    row =  tab.insertRow();
		    row.id = "fileRow"+rowId;
		    td = row.insertCell(); 
		    
		    tdStr="<input type=\"file\" name=\""+fName+"\" id=\""+fId+"\" onchange=\"CheckUpLoadFile(this,2);\" size='70' class=smallInput validateAttr=\"allowNull=false\">";
		    tdStr += "<input type=\"button\" onclick=\"delTr('fileRow"+rowId+"');\" name='button"+rowId+"' value=\"删除\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
		    td.innerHTML = tdStr;
		    rowId = rowId+1;    
		}
			
		function delTr(id){
			$("#"+id).remove();
		}
</script>
</body>
</html>