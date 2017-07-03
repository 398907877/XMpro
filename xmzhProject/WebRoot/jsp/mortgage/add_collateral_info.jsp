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
<title>添加押品</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/mortgage/mortgageReserveAction_addCollateral.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
		    <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		权证的基本信息
			<h:hidden id="warrantsId" property="mortgageReserveRes.warrantsId"  />
	        <h:hidden id="mortgageType"  property="mortgageReserveRes.mortgageType"/>
	          </td>
	        </tr>
			<tr>	
				<td class="form_label" align="right" width="15%">押品类型：</td>
				<td colspan="1" width="30%">
				   <d:write  dictTypeId="MORTGAGE_RESERVE_TYPE" property="mortgageReserve.mortgageType" />
				</td>		
				<td class="form_label" align="right" width="15%" nowrap="nowrap">他项类型：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					 <d:write  dictTypeId="OTHER_TYPE_VIEW" property="mortgageReserve.otherType" />
				</td>						
			</tr>
			<tr>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">库存序号：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.projectNumber" />
				</td>
				<td class="form_label" align="right" width="15%">他项权证号：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.otherWarrantsNumber" />
				</td>							
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">他项登记日期：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.otherWarrantsDate" />
				</td>		
				<td class="form_label" align="right" width="15%">借款人姓名：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.borrowerName" />
				</td>				
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">借款人身份证号：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.borrowerCardNo" />
				</td>			
				<td class="form_label" align="right" width="15%">经办机构：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.orgName" />
				</td>				
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">经办客户经理：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.mangerName" />
				</td>
				<td class="form_label" align="right" width="15%" nowrap="nowrap">保管期限：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:write dictTypeId="LOAN_TYPE_VIEW" property="mortgageReserve.loanType" />
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">借款合同号：</td>
				<td colspan="1" width="30%">
				<b:write property="mortgageReserve.borrowerContractNo" />
				</td>
				<td class="form_label" align="right" width="15%">保管期限：</td>
				<td colspan="1" width="30%">
				<b:write  property="mortgageReserve.loanYears" />年
				</td>					
			</tr>
			<tr>			
				<td class="form_label" align="right" width="15%">入账价值：</td>
				<td colspan="1" width="30%">
				<b:write  property="mortgageReserve.recordValue" />万元
				</td>	
				<td class="form_label" align="right" width="15%">封包编号：</td>
				<td colspan="1" width="30%">
				<b:write  property="mortgageReserve.packetNumber" />
				</td>				
			</tr>
			<tr>				
				<td class="form_label" align="right" width="15%">交接人：</td>
				<td colspan="1" width="30%">
				<b:write  property="mortgageReserve.nextName" />
				</td>		
				<td class="form_label" align="right" width="15%">购房合同号：</td>
				<td colspan="1" width="30%">
				<b:write  property="mortgageReserve.purchaseNumber" />
				</td>					
			</tr>
			<tr>				
				<td class="form_label" align="right" width="15%">补登记标志：</td>
				<td colspan="1" width="30%">
				<d:write  dictTypeId="MORTGAG_REGISTER" property="mortgageReserve.noRegisterSign"/> 
				</td>		
				<td class="form_label" align="right" width="15%">库存状态：</td>
				<td colspan="1" width="30%">
				<d:write  dictTypeId="MORTGAG_STATUS" property="mortgageReserve.status"/> 
				</td>					
			</tr>
			<tr>				
				<td class="form_label" align="right" width="15%">注销后抵质押品状态：</td>
				<td colspan="3" width="30%">
				<d:write  dictTypeId="AFTER_MORTGAGE_STATUS" property="mortgageReserve.afterMortgageStatus"/>
				</td>				
			</tr>
		    <tr id="row1">
		      <td class="form_label" align="right">附件下载：</td>
		      <td colspan="3">
		      <div id="tag"></div>
		      </td>
		     </tr>
		     <tr>
				<td class="form_label" align="right" width="15%">备注信息：</td>
				<td colspan="3" width="30%">
				  <h:textarea rows="2"  cols="100"   property="mortgageReserve.remark"  disabled="true"/>
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
				<h:text id="propertyDate"   property="mortgageReserveHouse.propertyDate" /> <font style="color: red">(格式：20170101)</font>
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
          var parWin =$id("mortgageType").value;
          init(parWin);

        };
$(document).ready(function(){
 $.ajax({
	        url: '/mortgage/mortgageReserveAction_queryFileList.action',
	        async: false,
	        type: 'post',
	        data: "resourceId=${mortgageReserve.id}",
	        dataType: 'json',
	        timeout: 60000,
	        success: function (files) {
		        if(files!=""){
		          $("#oldFileLength").val(files.length);
		         	$.each(files,function( i,item ){
		    	        $("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
		          		});	
		        }else{
		        	 $("#row1").css("display","none");  
		        }  
	        }
      });

        });
 function init(val){
        if(val=="1"){
	        $("#dzypxx_fc").show();
	        $("#dzypxx_jdc").hide();
	       }else if(val=="2"){
	        $("#dzypxx_jdc").show();
	        $("#dzypxx_fc").hide();
	       }
}
function save(){
	if(!check_sumbmit()){
			 return ;
		 }
	 ajaxsubmitO();
	}


//验证表单非空
    function check_sumbmit(){
        var flag=false;
		   if($id("mortgageType").value == "1"){
			   if($id("propertyNo").value == ""){
					alert("产权证号不能为空！");
					$id("propertyNo").focus();
					return flag;
				}
				
			   if($id("propertyName").value == ""){
					alert("产权人姓名不能为空！");
					$id("propertyName").focus();
					return flag;
				}
				
			   if($id("propertyCardNo").value == ""){
					alert("产权人身份证号不能为空！");
					$id("propertyCardNo").focus();
					return flag;
				}
				if($id("propertyAddres").value == ""){
					alert("产权地址不能为空！");
					$id("propertyAddres").focus();
					return flag;
				}
				if($id("propertyNums").value == ""){
					alert("产权证本数不能为空！");
					$id("propertyNums").focus();
					return flag;
				}else{
				  if(!validatInteger($id("propertyNums").value))
				  {
	                 alert("请输入正确的产权证本数!");  
				     $id("propertyNums").focus();
				     return flag;
				  }
				}
				var propertyDate=$id("propertyDate").value;
				if(propertyDate!=""){
					if(propertyDate.length !=8||!validatInteger(propertyDate)){
				         alert("请输入正确的产权证填发日期!");  
					     $id("propertyDate").focus();
					     return flag;
				    }
				}
				
			}else if($id("mortgageType").value == "2"){
			   if($id("carName").value == ""){
					alert("车主姓名不能为空！");
					$id("carName").focus();
					return flag;
				}
				if($id("carCardNo").value == ""){
					alert("车主身份证号不能为空！");
					$id("carCardNo").focus();
					return flag;
				}
				if($id("carRegisterNo").value == ""){
					alert("机动车登记证号不能为空！");
					$id("carRegisterNo").focus();
					return flag;
				}
				if($id("carNo").value == ""){
					alert("车牌号不能为空！");
					$id("carNo").focus();
					return flag;
				}
				if($id("carFrameNo").value == ""){
					alert("车架号不能为空！");
					$id("carFrameNo").focus();
					return flag;
				}
				if($id("carInvoiceNo").value == ""){
					alert("购车发票号不能为空！");
					$id("carInvoiceNo").focus();
					return flag;
				}
				if($id("carDuesNo").value == ""){
					alert("完税证明号不能为空！");
					$id("carDuesNo").focus();
					return flag;
				}
				if($id("carSafeNo").value == ""){
					alert("保单号不能为空！");
					$id("carSafeNo").focus();
					return flag;
				}
			}
			flag=true;
			return flag;
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
				alert("修改失败请联系管理员！");
			}
		};
		
		$("#data_form").ajaxSubmit(options);
	}
	
	
	var rowId = 0;
	function addFile(tabid,varName){
	    var tab,row,td,fName,fId,tdStr;
	    var zs=$("#tabtest tbody tr").length;
	    var oldFileLength=$("#oldFileLength").val();
	    var countzs=Number(zs)+Number(oldFileLength);
	    tab = $id(tabid);
	    if (countzs>=5){
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
	
	
		//验证整数判断
		function validatInteger(obj) {
			var result=true;
	        var reg = /^[0-9]\d*$/;
	        if (!reg.test(obj)) {
	            result=false;
	        }
	        return result;
        }
</script>
</body>
</html>