<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<%@page import="java.util.*"%>
<h:css href="/css/style1/style-custom.css"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="/css/fileDown.css">
<script type="text/javascript" src="/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript" src="/js/fileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<title>督办单</title>
</head>
  <body>
  <e:datasource name="supervise" type="bean" path="com.gotop.supervise.model.TSuperviseTable" />
    <h:form name="form1" id="form1" action="/supervise/tSuperviseTableAction_insertSuperviseInfo.action" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this);">
         <h:hidden property="supervise.superviseId"/>
         <h:hidden property="supervise.flowId"/>
	     <h:hidden property="supervise.createDate"/>
	     <h:hidden property="supervise.createor" id="createor"/>
        <h:hidden id="executionId" property="taskAssgineeDto.executionId"/>
        <h:hidden id="taskId"  property="taskAssgineeDto.nextTaskId"/>
        <h:hidden id="taskAssingee" property="taskAssgineeDto.taskAssingee"/>
        <h:hidden id="beginOrg" property="taskAssgineeDto.beginOrg"/>
        <h:hidden id="definitionId" property="taskAssgineeDto.definitionId"/>
        <h:hidden id="businessType" property="taskAssgineeDto.businessType"/>
        <h:hidden id="isC" name="isC" property="taskAssgineeDto/isC"/>
		 <input type="hidden" id="btnType" name="btnType" />
		<table align="center" border="0" width="100%" class="form_table" >
       <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px" >
        		 督办单
        </td>
      </tr>
      <tr>
      	<td class="form_label" align="right" style="width:120px;">
                                                     督办事项：
        </td>
        <td colspan="3">
          <h:text property="supervise.superviseItem" id="superviseTitle" validateAttr="allowNull=false" style="width:90%;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right">主办机构：</td>
			<td colspan="3">
			 <h:text id="orgname" property="supervise.impUnitName" readonly="true" />
			  <h:hidden id="orgcode" property="supervise.impUnit" />
			  <h:hidden id="orgid" property="supervise.impOrgid" />
			 <!--  <a id="smain" href="#" onclick="open_newyw_tree_fun1()">选择</a> -->
			</td>
	   </tr>
       <tr>
        <td class="form_label" align="right">协办机构：</td>
			<td colspan="3">
			 <h:text id="orgname1" property="supervise.conUnitName" style="width:50%"  />
			  <h:hidden id="orgcode1" property="supervise.coUnit" />
			   <h:hidden id="orgid1" property="supervise.coOrgid" />
			  <!-- <a id="sother" href="#" onclick="open_newyw_tree_fun2();">选择</a> -->
			</td>
        </tr>
        <tr>
        <td class="form_label" align="right" style="width:14%;">
                                                   完成时限：
        </td>
        <td colspan="1" style="width:36%;">
        <div id="hideDate" >
        <b:write property="supervise.completeDate" formatPattern="yyyy-MM-dd" />
        <h:hidden property="supervise.completeDate"/>
      	<td class="form_label" align="right" style="width:14%;">
                                                    联系电话：
        </td>
        <td colspan="1" style="width:36%;">
          <h:text property="supervise.linkerPhone" id="linkerPhone" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
     <!--  <tr>
       <td class="form_label" align="right" style="width:120px;">
                                                   提醒行领导：
        </td>
        <td colspan="3">
        <div id="rec1">
			 </div>
        </td>
      </tr> -->
      <tr>
     	<td class="form_label" align="right">内容：</td>
     	<td colspan="3">
	     	<h:textarea property="supervise.content"  validateAttr="maxLength=512;allowNull=false" rows="4"  style="width:90%;" />
		    <font style="color: red">*</font>
     	</td>
      </tr>
         <tr id="row1">
      <td class="form_label" align="right">附件下载：</td>
      <td colspan="3">
      <div id="tag"></div>
      </td>
      </tr>
      <tr id="row3">
     	<td class="form_label" align="right">意见：</td>
     	<td colspan="3">
	     	<h:textarea property="supervise.opninion" name="supervise.opninion" id="opinion" validateAttr="maxLength=512;allowNull=false" rows="4"  style="width:90%;"/>
		    <font style="color: red">*</font>
     	</td>
      </tr>
     	<%@include file="/jsp/util/default_opinionUtil.jsp" %>
      <tr class="form_bottom">
        <td colspan="4">
          <input type="button" value="提交" onclick="doSave(2);" class="button" id="smit" />
          <input type="button" value="回退" onclick="doSave2(2);" class="button" id="smit2" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
        </td>
      </tr>
       <tr id="row2">
     <td class="form_label" align="right">流程列表：</td>
     <td colspan="3">
     <%@include file="/jsp/util/opinionUtil.jsp"%>
		</td>
     </tr>
    </table>
    </h:form>
  </body>
 <script type="text/javascript">
 $(document).ready(function(){
	 if('${taskAssgineeDto.isC}'){
			$("#smit").hide();
		}else{
			$("#smit2").hide();
			}
		
	 if('${supFlag}'=='1'){
		 $("#smit").hide();
		 WEB.hideFile();}
	 if('${supervise.superviseId}'!=""){
		 if('${supervise.createor}'!='${sessionScope.login_user.empid}')
		  $("#save1").css("display","none"); 
		 $.ajax({
		        url: '/file/tFileResourceTableAction_queryFileList.action',
		        async: false,
		        type: 'post',
		        data: "resourceType=${taskAssgineeDto.businessType}&resourceId=${supervise.superviseId}",
		        dataType: 'json',
		        timeout: 60000,
		        success: function (files) {
			        if(files!=""){
			         	$.each(files,function( i,item ){
			         		if('${sessionScope.login_user.empid}'!=item.creator)
			    	        	$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
				         	else
				         		 if('${isView}'!=''){
					         			$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
						         	}else{
						         		$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId,remove:1});
							         }
			          		});	
			        }else{
			        	 $("#row1").css("display","none");  
			        }
		        }
	    });	
		 $("#beginOrg").val("${supervise.orgid}");
		 WEB.doDisabledAttr('${isView}','${supervise.createor}','2',"opinion"); 
		 WEB.doConditionDisplay('${supervise.createor}','2',"row3","none");//隐藏意见	
		 if('${supervise.createor}'!='${sessionScope.login_user.empid}'){
			 //$("#opninion").val("已处理");
		 }
	 }else{
		 $("#row1").css("display","none");
		 $("#row2").css("display","none");  
		 $("#row3").css("display","none");  
		 $("#beginOrg").val('${sessionScope.login_user.orgid}');
	 }
	if('${isView}'!=''){
		//$("#smain").hide();
		//$("#sother").hide();
		//$("#comoleteDiv").hide();
		//$("#hideDate").show();
		$("#smit").hide();
		 $("#row3").css("display","none");
	}
});

function initPlanCell20(){
		var queryCond="";
			queryCond += "<resourceId>${supervise.superviseId}</resourceId>";
			queryCond += "<resourceType>${taskAssgineeDto.businessType}</resourceType>";
			return queryCond;
		}

     function doSave(value){
    
    		if($("#orgcode").val()==""){
         	alert("主办单位不能为空！");
        		$("#superviseType").focus();
    			return false;
    		}
/*     		if($("#orgcode1").val()==""){
            	alert("协办单位不能为空！");
        		return false;
        		} */
    		if($("#opinion").val()==""){
    			alert("意见不能为空!");
    			$("#opinion").focus();
    			return false;
    		}    		
    		$("#btnType").val(value);
    		if(value!="1"){
    			if(checkForm($id("form1"))){
        		var dynamicOrgIds=$("#orgid").val()+","+$("#orgid1").val();
    			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.dynamicOrgIds="+dynamicOrgIds+"&taskAssgineeDto.beginAssingee="+$("#createor").val()+"&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
        		showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
    			}
    		}else{
    			var _form = $id("form1");
    	  	  	 	url="/supervise/tSuperviseTableAction_insertSuperviseInfo.action"+ "?supervise.remindId=" + '${supervise.remindId}';	
    	  	  	    _form.action =url
    	  	  	if(checkForm($id("form1")))
    			    ajaxsubmitO();
    	  	 	}
     }

     function doSave2(value){
    	    
 		if($("#orgcode").val()==""){
      	alert("主办单位不能为空！");
     		$("#superviseType").focus();
 			return false;
 		}
 		if($("#opinion").val()==""){
 			alert("意见不能为空!");
 			$("#opinion").focus();
 			return false;
 		}    		
 		$("#btnType").val(value);
 		if(value!="1"){
 			if(checkForm($id("form1"))){
     		var dynamicOrgIds=$("#orgid").val()+","+$("#orgid1").val();
 			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig2.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.dynamicOrgIds="+dynamicOrgIds+"&taskAssgineeDto.beginAssingee="+$("#createor").val()+"&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
     		showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
 			}
 		}else{
 			var _form = $id("form1");
 	  	  	 	url="/supervise/tSuperviseTableAction_insertSuperviseInfo.action"+ "?supervise.remindId=" + '${supervise.remindId}';	
 	  	  	    _form.action =url
 	  	  	if(checkForm($id("form1")))
 			    ajaxsubmitO();
 	  	 	}
  }
 	function taskAssigneeCallBack(arg){
  	 	var _form = $id("form1");
  	 	if(arg!=""){
  	  	 	url="/supervise/tSuperviseTableAction_insertSuperviseInfo.action?"+arg+ "&supervise.remindId=" + '${supervise.remindId}';	
  	  	    _form.action =url
  	        // 异步提交请求 
  	  	    ajaxsubmitO();
  	 	}
  	   }

  	  	function ajaxsubmitO(){
  	  	maskTop();
  	  	 var options = {
  		  		type : "post",
  		  		cache : "false",
  			  	success : function(data){
  					try {  
  					  	if(data.indexOf("success")>=0){
      					  	alert("操作成功!");
      					    unMaskTop();
	 					  		/**
	 					  		*2014.9.1 改成弹出的方式
	 					  		*/
	 					  		window.close();
      					  /* WEB.turnMainFrame(); */
  					  	}else if(data.indexOf("fails")>=0){
  					  	unMaskTop();
      					  	alert("操作失败!");
  					  	}else{	 
  					  	unMaskTop();
  					  	    alert("操作失败!"); 	
  					  	    
  					  	}
  	   				} catch (Exception) {  
  					}  
  				},  
  			  	error : function(data){
  					unMaskTop();
  				  alert("添加失败请联系管理员！");
  			   	}  
  			}; 
  	  	$("#form1").ajaxSubmit(options);
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

		function open_newyw_tree_fun1(){//方法名
			     strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.checkcount=1&changeTree.orgType=4&changeTree.showSelBox=4";
			var peArgument = [];
		    //机构
		    	var paramEntity = new ParamEntity('Organization');
		    	paramEntity.setProperty('orgcode',$id("orgcode").value);
				paramEntity.setProperty('orgname',$id("orgname").value);
				paramEntity.setProperty('orgid',$id("orgid").value);
				peArgument[3]=[paramEntity,'orgname','orgcode','orgid'];
		        //调用并传参
		        strUrl += "&time="+new Date().getTime();
				showModalCenter(strUrl,peArgument,openNewEmpTreeCallBack1,500,430,'选择机构');
		}
		function openNewEmpTreeCallBack1(arg){//回调方法
			if(arg['Organization']){ //原写法无需判断是否为空
		  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
		  		argRes=[[],[],[],[]];
				for(var i=0;i<sorgidArra.length;i++){
					argRes[0].push(sorgidArra[i].getProperty("orgcode"));
					argRes[1].push(sorgidArra[i].getProperty("orgname"));
					argRes[2].push(sorgidArra[i].getProperty("orgid"));
				}
				$id("orgcode").value = argRes[0];
				$id("orgname").value = argRes[1];
				$id("orgid").value = argRes[2];
			}else{
				$id("orgcode").value = "";
				$id("orgname").value = "";
				$id("orgid").value = "";
			}
		}

		function open_newyw_tree_fun2(){//方法名
		     strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=4";
		var peArgument = [];
	    //机构
	    	var paramEntity = new ParamEntity('Organization');
	    	paramEntity.setProperty('orgcode',$id("orgcode1").value);
			paramEntity.setProperty('orgname',$id("orgname1").value);
			paramEntity.setProperty('orgid',$id("orgid1").value);
			peArgument[3]=[paramEntity,'orgname','orgcode','orgid'];
	        //调用并传参
	        strUrl += "&time="+new Date().getTime();
			showModalCenter(strUrl,peArgument,openNewEmpTreeCallBack2,500,430,'选择机构');
	}
	function openNewEmpTreeCallBack2(arg){//回调方法
		if(arg['Organization']){ //原写法无需判断是否为空
	  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
	  		argRes=[[],[],[],[]];
			for(var i=0;i<sorgidArra.length;i++){
				argRes[0].push(sorgidArra[i].getProperty("orgcode"));
				argRes[1].push(sorgidArra[i].getProperty("orgname"));
				argRes[2].push(sorgidArra[i].getProperty("orgid"));
			}
			$id("orgcode1").value = argRes[0];
			$id("orgname1").value = argRes[1];
			$id("orgid1").value = argRes[2];
		}else{
			$id("orgcode1").value = "";
			$id("orgname1").value = "";
			$id("orgid1").value = "";
		}
	}
 </script>
</html>