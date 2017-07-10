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
<title>库存变更</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/mortgage/mortgageReserveAction_updColl.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="id" property="mortgageReserve.id"  name="mortgageReserve.id"/>
			<h:hidden id="oldFileLength" value="0"/>
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
					<d:select id="otherType" dictTypeId="OTHER_TYPE_VIEW" property="mortgageReserve.otherType"  nullLabel="请选择" extAttr="validateAttr='allowNull=false'" ></d:select><font style="color: red">*</font>
				</td>						
			</tr>
			<tr>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">库存序号：</td>
				<td colspan="1" width="30%">
				<h:text id="projectNumber" property="mortgageReserve.projectNumber" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>
				<td class="form_label" align="right" width="15%">他项权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="otherWarrantsNumber" property="mortgageReserve.otherWarrantsNumber" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>						
			</tr>
			<tr>			
				<td class="form_label" align="right" width="15%">他项登记日期：</td>
				<td colspan="1" width="30%">
				<w:date id="otherWarrantsDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd"  readonly="true" property="mortgageReserve.otherWarrantsDate" />
				</td>	
				<td class="form_label" align="right" width="15%">借款人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerName" property="mortgageReserve.borrowerName" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right" width="17%">借款人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerCardNo" property="mortgageReserve.borrowerCardNo" validateAttr="allowNull=false;maxLength=18;"/><font style="color: red">*</font>
				</td>		
				<td class="form_label" align="right" width="15%">经办机构：</td>
				<td colspan="1" width="30%">
				<h:hidden id="orgCode" property="mortgageReserve.orgCode" />
				<h:text id="orgName" property="mortgageReserve.orgName"/>
				</td>					
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">经办客户经理：</td>
				<td colspan="1" width="30%">
				<h:text id="mangerName" property="mortgageReserve.mangerName" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">贷款种类：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="loanType" dictTypeId="LOAN_TYPE_VIEW" property="mortgageReserve.loanType" nullLabel="请选择" extAttr="validateAttr='allowNull=false'" ></d:select>
				</td>				
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">借款合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerContractNo" property="mortgageReserve.borrowerContractNo" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">贷款年限：</td>
				<td colspan="1" width="30%">
				<h:text id="loanYears" size="5"  property="mortgageReserve.loanYears" validateAttr="type=naturalNumber;maxLength=3;"/>年
				</td>				
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">入账价值：</td>
				<td colspan="1" width="30%">
				<h:text id="recordValue"   property="mortgageReserve.recordValue"  validateAttr="maxLength=10;"/>
				</td>			
				<td class="form_label" align="right" width="15%">封包编号：</td>
				<td colspan="1" width="30%">
				<h:text id="packetNumber"   property="mortgageReserve.packetNumber" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>			
			</tr>
			<tr>			
				<td class="form_label" align="right" width="15%">交接人：</td>
				<td colspan="1" width="30%">
				<h:text id="nextName"   property="mortgageReserve.nextName" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>			
				<td class="form_label" align="right" width="15%">购房合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="purchaseNumber"   property="mortgageReserve.purchaseNumber" validateAttr="maxLength=125;"/>
				</td>					
			</tr>
		    <tr id="row1">
		      <td class="form_label" align="right">附件下载：</td>
		      <td colspan="3">
		      <div id="tag"></div>
		      </td>
		     </tr>
            <tr id="fujian">
	     	<td class="form_label" align="right">附件：</td>
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
		     <l:iterate property="mortgageReserveListCarInfo" id="id3">
			  <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		抵质押品信息(${id3.NOWCOUNT })
	        		<h:hidden id="id"   iterateId="id3" property="mortgageReserveCar.id"  value="${id3.ID }"/>
	        		
	        		<h:hidden id="warrantsId"   iterateId="id3" property="mortgageReserveCar.warrantsId"  value="${id3.WARRANTSID }"/>
	          </td>
	        </tr>
			<tr>	
				<td class="form_label" align="right" width="15%">车主姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="carName"   iterateId="id3"  property="mortgageReserveCar.carName" value="${id3.CARNAME }"  validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车主身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carCardNo"   iterateId="id3"  property="mortgageReserveCar.carCardNo" value="${id3.CARCARDNO }"  validateAttr="allowNull=false;maxLength=18;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="17%">机动车登记证号：</td>
				<td colspan="1" width="30%">
				<h:text id="carRegisterNo"  iterateId="id3"  property="mortgageReserveCar.carRegisterNo" value="${id3.CARREGISTERNO }" validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">车牌号：</td>
				<td colspan="1" width="30%">
				<h:text id="carNo" iterateId="id3"   property="mortgageReserveCar.carNo" value="${id3.CARNO }" validateAttr="allowNull=false;maxLength=10;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">车架号：</td>
				<td colspan="1" width="30%">
				<h:text id="carFrameNo" iterateId="id3"   property="mortgageReserveCar.carFrameNo" value="${id3.CARNO }"  validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">购车发票号：</td>
				<td colspan="1" width="30%">
				<h:text id="carInvoiceNo"  iterateId="id3"  property="mortgageReserveCar.carInvoiceNo" value="${id3.CARINVOICENO }"  validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">完税证明号：</td>
				<td colspan="1" width="30%">
				<h:text id="carDuesNo" iterateId="id3"   property="mortgageReserveCar.carDuesNo" value="${id3.CARDUESNO }"  validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="15%">保单号：</td>
				<td colspan="1" width="30%">
				<h:text id="carSafeNo"  iterateId="id3"  property="mortgageReserveCar.carSafeNo" value="${id3.CARSAFENO }"  validateAttr="allowNull=false;maxLength=125;"/><font style="color: red">*</font>
				</td>					
			</tr>
			</l:iterate>
			<tr>
				<td colspan="4" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
			
		</table>
	</h:form>
<script type="text/javascript">

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
</script>
</body>
</html>