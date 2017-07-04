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
		    <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		权证的基本信息
				<h:hidden id="warrantsId" property="mortgageReserve.id"  name="mortgageReserve.id"/>
				<h:hidden id="mortgageType" property="mortgageReserve.mortgageType"  name="mortgageReserve.mortgageType"/>
				<h:hidden id="projectNumber" property="mortgageReserve.projectNumber"  name="mortgageReserve.projectNumber"/>
				<h:hidden id="tmpOtherWarrantsNumber" property="mortgageReserve.tmpOtherWarrantsNumber"  name="mortgageReserve.tmpOtherWarrantsNumber"/>
				<h:hidden id="oldFileLength" value="0"/>
	          </td>
	        </tr>
			<tr>	
				<td class="form_label" align="right" width="15%">押品类型：</td>
				<td colspan="1" width="30%">
				  <d:write  dictTypeId="MORTGAGE_RESERVE_TYPE" property="mortgageReserve.mortgageType" />
				</td>		
				<td class="form_label" align="right" width="15%" nowrap="nowrap">他项类型：</td>
				<td colspan="1" width="30%" nowrap="nowrap">
					<div id="otherType_fc">
					<d:select id="otherTypeFC" dictTypeId="OTHER_TYPE_HOUSE" property="mortgageReserve.otherTypeFC"  nullLabel="请选择"  onchange="changeOtherTypeFC(this.value)" ></d:select>
				</div>
				<div id="otherType_jdc"  style="display:none">
					<d:select id="otherTypeJDC" dictTypeId="OTHER_TYPE_CAR" property="mortgageReserve.otherTypeJDC" ></d:select>
				</div>
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
				<h:text id="otherWarrantsNumber" property="mortgageReserve.otherWarrantsNumber" validateAttr="allowNull=false;"/><font style="color: red">*</font>
				</td>						
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">他项登记日期：</td>
				<td colspan="1" width="30%">
				<h:text id="otherWarrantsDate"  property="mortgageReserve.otherWarrantsDate" />
				</td>		
				<td class="form_label" align="right" width="15%">借款人姓名：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerName" property="mortgageReserve.borrowerName" />
				</td>					
			</tr>
			<tr>
				<td class="form_label" align="right" width="17%">借款人身份证号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerCardNo" property="mortgageReserve.borrowerCardNo" />
				</td>			
				<td class="form_label" align="right" width="15%">经办机构：</td>
				<td colspan="1" width="30%">
				<h:hidden id="orgCode" property="mortgageReserve.orgCode" />
				<h:text id="orgName" property="mortgageReserve.orgName"  />
				<a href="#" onclick="open_slzhej_fun1()">支行选择</a>
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">经办客户经理：</td>
				<td colspan="1" width="30%">
				<h:text id="mangerName" property="mortgageReserve.mangerName" />
				</td>	
				<td class="form_label" align="right" width="15%" nowrap="nowrap">贷款种类：</td>
				<td colspan="1" width="30%" nowrap="nowrap"><div id="loanType_fc">
					<d:select id="loanTypeFC" dictTypeId="LOAN_TYPE_HOUSE" property="mortgageReserve.loanTypeFC" nullLabel="请选择" ></d:select>
				</div>
				<div id="loanType_jdc"  style="display:none">
					<d:select id="loanTypeJDC" dictTypeId="LOAN_TYPE_CAR" property="mortgageReserve.loanTypeJDC" nullLabel="请选择" ></d:select>
				</div>
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">借款合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="borrowerContractNo" property="mortgageReserve.borrowerContractNo" />
				</td>
				<td class="form_label" align="right" width="15%">保管年限：</td>
				<td colspan="1" width="30%">
				<h:text id="loanYears" size="5"  property="mortgageReserve.loanYears" validateAttr="fracDigit=2;type=double;" />年
				</td>				
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">入账价值：</td>
				<td colspan="1" width="30%">
				<h:text id="recordValue"   property="mortgageReserve.recordValue"   validateAttr="fracDigit=2;type=double;" />万元
				</td>				
				<td class="form_label" align="right" width="15%">封包编号：</td>
				<td colspan="1" width="30%">
				<h:text id="packetNumber"   property="mortgageReserve.packetNumber" />
				</td>					
			</tr>
			<tr>		
				<td class="form_label" align="right" width="15%">交接人：</td>
				<td colspan="1" width="30%">
				<h:text id="nextName"   property="mortgageReserve.nextName" /><d:select id="proNextName" dictTypeId="MORTGAGE_NEXT_NAME"  property="mortgageReserveOut.proNextName" nullLabel="合作岗" onchange="changeNextNmae(this.value)"   />
				</td>		
				<td class="form_label" align="right" width="15%">购房合同号：</td>
				<td colspan="1" width="30%">
				<h:text id="purchaseNumber"   property="mortgageReserve.purchaseNumber"  />
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
				<h:textarea rows="2"  cols="100"   property="mortgageReserve.remark"   />
				</td>					
			</tr>
			 <tr>
	          <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:35px;background-color: rgb(145, 186, 221);" >
	        		抵质押品信息
	          </td>
	        </tr>
			<tbody id="dzypxx_fc">
			<tr id="row2">
		     <td class="form_label" align="right">抵质押品列表：</td>
		     <td colspan="3">
		     <form id="form1" runat="server">
		     <table width="100%" id="ListArea" border="0" class="EOS_table" >
		      <tr align="center">
		            <th nowrap="nowrap">产权证号</th>
		            <th nowrap="nowrap">产权人姓名</th>
		            <th nowrap="nowrap">产权人身份证号</th>
		            <th nowrap="nowrap">产权地址</th>
		            <th nowrap="nowrap">产权证本数</th>
		            <th nowrap="nowrap">产权证填发日期</th>
		        </tr>
		        <l:iterate property="mortgageReserveListHouseInfo" id="id3" >
		        <tr align="center">
		            <td nowrap="nowrap"> 
	        		 <h:hidden id="idHouse"   iterateId="id3" property="mortgageReserveHouse.id"  value="${id3.ID }"/>
	        		 <h:hidden id="warrantsId"   iterateId="id3" property="mortgageReserveHouse.warrantsId"  value="${id3.WARRANTSID }"/>
			    	 <h:text id="propertyNo"  size="12"  iterateId="id3" property="mortgageReserveHouse.propertyNo"  value="${id3.PROPERTYNO }" validateAttr="allowNull=false;"/><font style="color: red">*</font>
		            </td>
		            <td nowrap="nowrap"> 
		            <h:text id="propertyName"  size="8" iterateId="id3" property="mortgageReserveHouse.propertyName" value="${id3.PROPERTYNAME }" validateAttr="allowNull=false;"/><font style="color: red">*</font>
		            </td>
		            <td nowrap="nowrap"> 
		            <h:text id="propertyCardNo" size="12" iterateId="id3" property="mortgageReserveHouse.propertyCardNo" value="${id3.PROPERTYCARDNO }" />
		            </td>
		            <td nowrap="nowrap"> 
		            <h:text id="propertyAddres"  iterateId="id3" property="mortgageReserveHouse.propertyAddres" value="${id3.PROPERTYADDRES }" validateAttr="allowNull=false;"/><font style="color: red">*</font>
		            </td>
		            <td nowrap="nowrap"> 
		            <h:text id="propertyNums"  size="5"  iterateId="id3" property="mortgageReserveHouse.propertyNums" value="${id3.PROPERTYNUMS }"  validateAttr="type=naturalNumber;"/>
		            </td>
		            <td nowrap="nowrap"> 
		            <h:text  iterateId="id3"    property="mortgageReserveHouse.propertyDate" value="${id3.PROPERTYDATE }" validateAttr="type=naturalNumber;maxLength=8;"/> 
		            </td>
		        </tr>
		       </l:iterate>
		     </table>
		     </form>
			 </td>
            </tr>
			</tbody>
			<tbody id="dzypxx_jdc" style="display:none">
			<tr id="row3">
		     <td class="form_label" align="right">抵质押品列表：</td>
		     <td colspan="3">
		     <form id="form2" runat="server">
		     <table width="100%" id="ListArea" border="0" class="EOS_table" > 
		     <tr align="center">
		            <th nowrap="nowrap">车主姓名</th>
		            <th nowrap="nowrap">车主身份证号</th>
		            <th nowrap="nowrap">机动车登记证号</th>
		            <th nowrap="nowrap">车牌号</th>
		            <th nowrap="nowrap">车架号</th>
		            <th nowrap="nowrap">购车发票号</th>
		            <th nowrap="nowrap">完税证明号</th>
		            <th nowrap="nowrap">保单号</th>
		      </tr>
			  <l:iterate property="mortgageReserveListCarInfo" id="id5">
			   <tr align="center">
		            <td nowrap="nowrap"> 
	        		  <h:hidden id="idCar"   iterateId="id5" property="mortgageReserveCar.id"  value="${id5.ID }"/>
	        		  <h:hidden id="warrantsId"   iterateId="id5" property="mortgageReserveCar.warrantsId"  value="${id5.WARRANTSID }"/>
			    	  <h:text id="carName" size="5"   iterateId="id5"  property="mortgageReserveCar.carName" value="${id5.CARNAME }"  /> 
		            </td>
		            <td nowrap="nowrap"> 
		              <h:text id="carCardNo" size="12"   iterateId="id5"  property="mortgageReserveCar.carCardNo" value="${id5.CARCARDNO }"  />
		            </td>
		            <td nowrap="nowrap"> 
		              <h:text id="carRegisterNo" size="10"  iterateId="id5"  property="mortgageReserveCar.carRegisterNo" value="${id5.CARREGISTERNO }" />
		            </td>
		            <td nowrap="nowrap"> 
		              <h:text id="carNo" iterateId="id5" size="8"   property="mortgageReserveCar.carNo" value="${id5.CARNO }" />
		            </td>
		            <td nowrap="nowrap"> 
		            <h:text id="carFrameNo" iterateId="id5" size="8"   property="mortgageReserveCar.carFrameNo" value="${id5.carFrameNo }"  />
		            </td>
		            <td nowrap="nowrap"> 
		              <h:text id="carInvoiceNo"  iterateId="id5" size="10"  property="mortgageReserveCar.carInvoiceNo" value="${id5.CARINVOICENO }"  />
		            </td>
		            <td nowrap="nowrap"> 
		              <h:text id="carDuesNo" iterateId="id5" size="10"   property="mortgageReserveCar.carDuesNo" value="${id5.CARDUESNO }" />
		            </td>
		            <td nowrap="nowrap"> 
		              <h:text id="carSafeNo"  iterateId="id5" size="10"  property="mortgageReserveCar.carSafeNo" value="${id5.CARSAFENO }"  />
		            </td>
		        </tr>
			</l:iterate>
		    </table>
		    </form>
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
          changeMortgageType(parWin);

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
        
	   
	function changeMortgageType(val){
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
	  var frm=$name("data_form");
		if(!checkForm(frm)){
				 return ;
		 }
		
		 
		 check_ProOthNumber();
		 //ajaxsubmitO();
	}

    function check_ProOthNumber(){
	     var mortgageType=$id("mortgageType").value ;
		 var otherWarrantsNumber= $id("otherWarrantsNumber").value;  //他项权证号
		 var tmpOtherWarrantsNumber= $id("tmpOtherWarrantsNumber").value;  //临时他项权证号
		 if(otherWarrantsNumber!=tmpOtherWarrantsNumber){
		      projectNumber="checkExits";
		    if(otherWarrantsNumber==tmpOtherWarrantsNumber){
		      otherWarrantsNumber="checkExits";
		   }
	    $.ajax({
			      url: "/mortgage/mortgageReserveAction_checkOtherWarrantsNumber.action",
			      async: false,
			      type: 'post',
			      data: "mortgageReserve.otherWarrantsNumber="+otherWarrantsNumber+"&mortgageReserve.projectNumber="+projectNumber+"&mortgageReserve.mortgageType="+mortgageType,
			      timeout: 60000,
			      success: function (data) {
					   if (data.indexOf("noExist") >= 0) {
				    		  ajaxsubmitO();
						} else if (data.indexOf("othexist") >= 0) {
			                 $id("otherWarrantsNumber").focus();	
							alert("操作失败！该他项权证号("+otherWarrantsNumber+")系统中号码重复！请重新填写！");
						} else if (data.indexOf("fails") >= 0) {
							alert("他项权证号校验失败！");
						} else {
							alert("操作失败!");
						}
			      }
			}); 
		 
		 }else{
		 ajaxsubmitO();
		 }
		 
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
			
		function changeNextNmae(param){
		  if(param!="产权人"){
		    $("#nextName").val(param);
		  }else{
		    $("#nextName").val("");
		  }
		}
</script>
</body>
</html>