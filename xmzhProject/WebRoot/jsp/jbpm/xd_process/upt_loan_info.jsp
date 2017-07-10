<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>修改贷款信息</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/xdProcessAction_saveUptInfo.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="executionId" property="xdProcessTaskAssignee.executionId"  />
			
			<tr>	
				<td class="form_label" align="right" width="15%">流程名称：</td>
				<td colspan="1" width="30%">
				<h:hidden id="processName" property="xdProcessTaskAssignee.processName"  />
					<b:write property="xdProcessTaskAssignee.processName" />
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">客户姓名：</td>
				<td colspan="1" width="30%">
					<h:text property="xdProcessTaskAssignee.custName" id="cust_Name" validateAttr="allowNull=false"  />
	     	 		<font style="color: red;">*</font>
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">申请金额：</td>
				<td colspan="1" width="30%">
					<h:text property="xdProcessTaskAssignee.apply_bal" id="apply_bal" validateAttr="allowNull=false;type=float" style="width:130px;" />元
					<font style="color: red">*</font>	
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">一级分类：</td>
				<td colspan="1" width="30%">
					<select    id="oneCategorys" onchange="changeoneCategory()"     > </select> 
			         <h:hidden property="xdProcessTaskAssignee.oneCategory"  id="oneCategory" />
			         <font style="color: red">*</font>	
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">贷种分类：</td>
				<td colspan="1" width="30%">
					 <select    id="loanCategorys" onchange="changeloanCategory()" >
			         </select> 
			         <h:hidden property="xdProcessTaskAssignee.loanCategory"  id="loanCategory" />
			         <font style="color: red">*</font>	
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">合作机构：</td>
				<td colspan="1" width="30%"> 
					<h:text property="xdProcessTaskAssignee.coorganization" id="coOrganization"  style="width:130px;" />
				</td>
			</tr>
			<tr>
		<td class="form_label" align="right" style="width:10%;" >营销人员：</td>
      	<td>
      		<h:text id="yxry" property="xdProcessTaskAssignee.yxry"  onblur="yxryjgname();"/>
      	</td>
		  </tr>
		  <tr>
      	     <td class="form_label" align="right" style="width:10%;" >营销人员机构：</td>
      	  <td>
      		<h:text id="yxryjg" property="xdProcessTaskAssignee.yxryjg"  />
      		<a href="#" onclick="open_slzhej_fun1()">选择</a>
      	</td>
			</tr>
			
			  <tr>
      	<td class="form_label" align="right" style="width:10%;" >报单次数：</td>
      	<td>
      		<h:text id="reportcnt" property="xdProcessTaskAssignee.reportcnt" />
      	</td>
      </tr>
			<tr>
				<td colspan="2" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">
//eventManager.add(window, "load", init); //一进JSP页面自动调用初始化函数
		//选择	营销人员机构


		

		//选择	营销人员机构
		function open_slzhej_fun1(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
		//	var startOrgid=$("#startOrgid").val();
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1";
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgname',$id("yxryjg").value);
	//		paramEntity.setProperty('orgcode',$id("orgCodeTwo").value);
				peArgument[3]=[paramEntity];			
			showModalCenter(strUrl,peArgument,open_slzhej_callback1,600,430,objName); 
			}
		
		//选择	营销人员机构	回调方法
		function open_slzhej_callback1(arg){//回调方法
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("yxryjg").value = argRes[1];
					}
		    	}
			}
		
		
		
		
		
function yxryjgname(){
	 var yxry =$("#yxry").val();
		$.ajax({
			url : "/Generalprocess/generalProcessAction_queryyxryjg.action",
			async : false,
			type : 'post',
			data : "yxry=" + yxry,
			timeout : 60000,
			dataType : 'json',
			success : function(json) {
				 $.each(eval(json), function (n, value) {
					 if(n==0){
						 var  orgname = value.YXRYJG;
						 $("#yxryjg").val(orgname);		
						 }	
	              });

			}
		});
	
}




//页面一旦加载读取时，就初始化
$(document).ready(function(){
	 setOneSelect('${xdProcessTaskAssignee.processName}');
});

function changeloanCategory(){
	$("#loanCategory").val($('#loanCategorys option:selected').val());
	}	
function changeoneCategory(){
	$("#oneCategory").val($('#oneCategorys option:selected').val());
	 setLcselect($("#oneCategory").val());
	}

function setLcselect(arg){
	$("#loanCategorys").html("");
	var processName='${xdProcessTaskAssignee.processName}';
	var selecthtml=$("#loanCategorys").html();
	 $.ajax({
	        url: "/Generalprocess/tGeneralprocessCdtypeAction_querycreditType.action?cdtype.firstClass="+encodeURI(arg)+"&cdtype.processName="+encodeURI(processName),
	        async: false,
	        type: 'post',
	        data: "",
	        dataType: 'json',
	        success: function (json) {
	        	if(json==""){
	        	}else {
	        		$.each(json,function(key,value){
		        		selecthtml= selecthtml+"<option value="+value.creditType+">"+value.creditType+"</option>";
		        		});
	        	}
		        }
    });	
	    $("#loanCategorys").html(selecthtml);
	    if($id("loanCategory").value==''){
	    	$("#loanCategory").val($('#loanCategorys option:selected').val());
		    }else{
		    	var all_options = document.getElementById("loanCategorys").options;
				for (var  i=0; i<all_options.length; i++){
					if (all_options[i].value ==$id("loanCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
					{
						all_options[i].selected = true;
					}
				}
		    }
}

function setOneSelect(arg){
	$("#oneCategorys").html("");
	var selecthtml=$("#oneCategorys").html();
	 $.ajax({
	        url: "/Generalprocess/tGeneralprocessCdtypeAction_queryViewList.action?cdtype.processName="+encodeURI(arg),
	        async: false,
	        type: 'post',
	        data: "",
	        dataType: 'json',
	        success: function (json) {
	        	if(json==""){
	        	}else {
	        		$.each(json,function(key,value){
		        		selecthtml= selecthtml+"<option value="+value.firstClass+">"+value.firstClass+"</option>";
		        		});
	        	}
		        }
    });	
	    $("#oneCategorys").html(selecthtml);
	    if($id("oneCategory").value==''){
	    	$("#oneCategory").val($('#oneCategorys option:selected').val());
	    	 setLcselect($("#oneCategory").val());
		    }else{
		    	var all_options = document.getElementById("oneCategorys").options;
				for (var i=0; i<all_options.length; i++){
					if (all_options[i].value ==$id("oneCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
					{
						all_options[i].selected = true;
					}
				}
				$("#oneCategory").val($('#oneCategorys option:selected').val());
				 setLcselect($("#oneCategory").val());
		    }
}

	function save(){

		$("#loanCategory").val($('#loanCategorys option:selected').val());
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

</script>
</body>
</html>