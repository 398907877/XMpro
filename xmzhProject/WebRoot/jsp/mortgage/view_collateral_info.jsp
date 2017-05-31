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
<title>库存详情</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/mortgage/mortgageReserveAction_addItem.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="id" property="mortgageReserve.id"  name="mortgageReserve.id"/>
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
					<d:select id="otherType" dictTypeId="OTHER_TYPE_VIEW" property="mortgageReserve.otherType"  nullLabel="请选择"></d:select><font style="color: red">*</font>
				</td>						
			</tr>
			<tr>	
				<td class="form_label" align="right" width="15%">预告登记关联：</td>
				<td colspan="1" width="30%">
				<h:text id="noticeRegisterRelation" property="mortgageReserve.noticeRegisterRelation" />
				</td>	
				<td class="form_label" align="right" width="15%">库存序号：</td>
				<td colspan="1" width="30%">
				<h:text id="projectNumber" property="mortgageReserve.projectNumber"/><font style="color: red">*</font>
				</td>
											
			</tr>
			<tr>					
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">他项权证号：</td>
				<td colspan="1" width="30%">
				<h:text id="otherWarrantsNumber" property="mortgageReserve.otherWarrantsNumber"/><font style="color: red">*</font>
				</td>		
				<td class="form_label" align="right" width="15%">他项登记日期：</td>
				<td colspan="1" width="30%">
				<w:date id="otherWarrantsDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="mortgageReserve.otherWarrantsDate" />
				</td>						
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">借款人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerName" property="mortgageReserve.borrowerName"/><font style="color: red">*</font>
				</td>	
				<td class="form_label" align="right" width="17%">借款人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerCardNo" property="mortgageReserve.borrowerCardNo"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">经办机构：</td>
				<td colspan="1" width="30%">
				<h:hidden id="orgCode" property="mortgageReserve.orgCode" />
				<h:text id="orgName" property="mortgageReserve.orgName"/><font style="color: red">*</font>
				<a href="#" onclick="open_slzhej_fun1()">选择</a>
				</td>	
				<td class="form_label" align="right" width="15%">经办客户经理：</td>
				<td colspan="1" width="30%">
				<h:text id="mangerName" property="mortgageReserve.mangerName"/><font style="color: red">*</font>
				</td>	
										
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">贷款种类：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<d:select id="loanType" dictTypeId="LOAN_TYPE_VIEW" property="mortgageReserve.loanType" nullLabel="请选择"></d:select>
				</td>	
				<td class="form_label" align="right" width="15%">借款合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerContractNo" property="mortgageReserve.borrowerContractNo"/><font style="color: red">*</font>
				</td>					
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">贷款年限：</td>
				<td colspan="1" width="30%">
				<h:text id="loanYears" size="5"  property="mortgageReserve.loanYears" />年
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
				<td class="form_label" align="right" width="15%">备注信息：</td>
				<td colspan="1" width="30%">
				<h:text id="remark"   property="mortgageReserve.remark" />
				</td>					
			</tr>
		    <tr id="row1">
		      <td class="form_label" align="right">附件下载：</td>
		      <td colspan="3">
		      <div id="tag"></div>
		      </td>
		     </tr>
		     <l:iterate id=""></l:iterate>
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
				<w:date id="propertyDate" submitFormat="yyyyMMdd" format="yyyy-MM-dd" property="mortgageReserveHouse.propertyDate" />
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
		         	$.each(files,function( i,item ){
		    	        $("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
		          		});	
		        }else{
		        	 $("#row1").css("display","none");  
		        }  
	        }
      });
     var parWin = window.dialogArguments;
          init(parWin);

        });
        
function init(val){
        if(val=="0"){
	        $("#dzypxx_fc").show();
	        $("#dzypxx_jdc").hide();
	       }else if(val=="1"){
	        $("#dzypxx_jdc").show();
	        $("#dzypxx_fc").hide();
	       }
}
</script>
</body>
</html>