..<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
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
<script type="text/javascript" src="/js/modeFileDown.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<title>受理调查</title>
</head>
  <body>
  <div id='showdiv'>
    	</div>	
    <h:form name="form1" id="form1" action="" method="post" enctype="multipart/form-data" onsubmit="return checkForm(this);">
    <div id="content">
    	<h:hidden id="createor"/>
        <h:hidden id="executionId" property="taskAssgineeDto.executionId"/>
        <h:hidden id="taskId"  property="taskAssgineeDto.nextTaskId"/>
        <h:hidden id="taskAssingee" property="taskAssgineeDto.taskAssingee"/>
        <h:hidden id="definitionId" property="taskAssgineeDto.definitionId"/>
        <h:hidden id="businessType" property="taskAssgineeDto.businessType"/>
        <h:hidden id="processName" property="taskAssgineeDto.processName"/>
        <h:hidden id="templateFileIds" property="taskAssgineeDto.templateFileIds"/>
        <h:hidden id="isC" name="isC" property="taskAssgineeDto/isC"/>
		<h:hidden id="btnType" name="taskAssgineeDto.btnType" />
		<h:hidden name="taskAssgineeDto.isFirst" value="1" />
		
		<h:hidden id="processModelId" name="modelOne.processModelId" property="modelOne.processModelId"/>
		<h:hidden id="taskName" name="modelOne.taskName" property="modelOne.taskName"/>
		<h:hidden id="flowId" name="modelOne.flow_Id" property="modelOne.flow_Id"/>
		
		 <h:hidden id="beginAssingee" name="taskAssgineeDto.beginAssingee" property="taskAssgineeDto.beginAssingee"/>
		<h:hidden id="beginOrg" name="taskAssgineeDto.beginOrg" property="taskAssgineeDto.beginOrg"/>
			
		<table align="center" border="0" width="100%" class="form_table" >
      <tr>
         <td  colspan="4" style="text-align: center;font-weight:bold;font-size:12pt;height:50px;background-color: rgb(145, 186, 221);" >
        		 ${taskName}
        </td>
      </tr>
      <tr>
      	<td class="form_label" align="right" style="width:120px;" >受理支行<br>（一级选项）</td>
      	<td colspan="1">
         <h:text property="modelOne.orgNameOne" id="orgNameOne" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>
         <h:hidden property="modelOne.orgCodeOne" id="orgCodeOne"/>	
         <h:hidden id="startOrgid"/>	
      	</td>
     	<td class="form_label" align="right" style="width:120px;" >受理支行<br>（二级选项）</td>
     	<td colspan="3">
        <h:text id="orgNameTwo" property="modelOne.orgNameTwo" readonly="true" />
		<h:hidden id="orgCodeTwo" property="modelOne.orgCodeTwo" />
	    <a href="#" onclick="open_slzhej_fun()">选择</a>
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   主调信贷员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.creatorName" id="creatorName" validateAttr="allowNull=false" readonly="true" style="width:130px;" /><font style="color: red">*</font>	
         <h:hidden id="creator" property="modelOne.creator" />
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                  辅调信贷员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.fdxdy" id="fdxdy" validateAttr="allowNull=false" style="width:130px;" /><font style="color: red">*</font>	
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                   营业主管：
        </td>
        <td colspan="1">
         <h:text property="modelOne.yxzg" id="yxzg" validateAttr="allowNull=false"  style="width:130px;" /><font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   营销人员：
        </td>
        <td colspan="1">
         <h:text property="modelOne.yxry" id="yxry" validateAttr="allowNull=ture" style="width:130px;" />	
        </td>
      	</tr>
      	
      
      
      	
       <tr>
     	<td class="form_label" align="right" style="width:120px;">客户姓名：</td>
     	<td>
	     	 <h:text property="modelOne.cust_Name" id="cust_Name" validateAttr="allowNull=false" style="width:250px;" />
	     	 <font style="color: red;">*</font>
     	</td>
     	
     	  <td class="form_label" align="right" style="width:120px;">营销人员机构：</td>
     	<td colspan="1">
       <h:text property="modelOne.yxryjg" id="yxryjg" validateAttr="allowNull=ture" style="width:130px;" readonly="false"  />
	    <a href="#" onclick="open_slzhej_fun1()">选择</a>
     	
      </tr>
      <tr>
           	<td class="form_label" align="right" style="width:120px;">是否老顾客：</td>
     	<td colspan="1">
			<h:select  id="old_Cust"  property="modelOne.old_Cust">
			      <h:option label="否" value="n"/>
			     <h:option label="是" value="y"/>
			    
			</h:select> 
		</td>
		
      	<td class="form_label" align="right" style="width:120px;">合作机构：</td>
     	<td>
	     	 <h:text property="modelOne.coOrganization" id="coOrganization" validateAttr="allowNull=ture" style="width:130px;" />
     	</td>
      </tr>
      
      <tr>
      <td class="form_label" align="right" style="width:120px;">
                                                   抵押物权属人名称：
        </td>
        <td colspan="1">

          <h:text property="modelOne.dywx_Name" id="dywx_Name" validateAttr="allowNull=ture" style="width:130px;" />	

        </td>
        
        <td class="form_label" align="right" style="width:120px;">
                                                    调查时间：
        </td>
        <td colspan="1">
        <div id="inputTime"> 
	         <w:date  id="survey_Time" submitFormat="yyyy-MM-dd" format="yyyy-MM-dd" allowNull="false" property="modelOne.survey_Time"/>    <font style="color: red">*</font>	
         </div>
        </td>
      </tr>
             <tr>
     	<td class="form_label" align="right" style="width:120px;">借款人工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.borr_Unit" id="borr_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
     	<td class="form_label" align="right" style="width:120px;">借款人配偶工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.borrSpouse_Unit" id="borrSpouse_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
      </tr>
                   <tr>
     	<td class="form_label" align="right" style="width:120px;">共同借款人工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.comBorr_Unit" id="comBorr_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
     	<td class="form_label" align="right" style="width:120px;">共同借款人配偶工作单位：</td>
     	<td>
	     	 <h:text property="modelOne.comBorrSpouse_Unit" id="comBorrSpouse_Unit" validateAttr="allowNull=ture" style="width:250px;" />
     	</td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 申请金额：
        </td>
        <td colspan="1">
         <h:text property="modelOne.apply_bal" id="apply_bal" validateAttr="allowNull=false;type=float" style="width:130px;" />元<font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   申请币别：
        </td>
					<td colspan="1">
						<d:select  id="currency"  dictTypeId="PROCESS_MONEY" property="modelOne.currency"></d:select>    <font style="color: red">*</font>	
					</td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 一级分类：
        </td>
        <td colspan="1">
        
        <select    id="oneCategorys" onchange="changeoneCategory()"     >
         </select> 
         <h:hidden property="modelOne.oneCategory"  id="oneCategory" />
         <font style="color: red">*</font>	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                   贷种分类：
        </td>
        <td colspan="1">
         <%-- <h:text property="modelOne.loanCategory" id="loanCategory" validateAttr="allowNull=false" style="width:130px;" /> --%>
         <select    id="loanCategorys" onchange="changeloanCategory()" >
         </select> 
         <h:hidden property="modelOne.loanCategory"  id="loanCategory" />
         <font style="color: red">*</font>	
        </td>
      </tr>
      
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 基准利率浮动：
        </td>
        <td colspan="1">
        <d:select    id="basic_rate_float"  dictTypeId="PROCESS_BASICRATEFLOAT"  property="modelOne.basic_rate_float"  nullLabel="请选择"  onchange="rate_judge_fun()"></d:select> 
        </td>
        
        <td class="form_label" align="right" style="width:120px;">
                                                  利率浮动比例：
        </td>
        <td colspan="1">
         <h:text property="modelOne.rate_float_scale" id="rate_float_scale" style="width:60px;"  validateAttr="type=double;fracDigit=2;allowNull=true;"  />	%
        </td>
      </tr>
       <tr>
        <td class="form_label" align="right" style="width:120px;">
                                                 客户评级：
        </td>
        <td colspan="1">
            <h:text id="cust_grade"  style="width:130px;"  property="modelOne.cust_grade"  />	
        </td>
        <td class="form_label" align="right" style="width:120px;">
                                                 
        </td>
        <td colspan="1">
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
     	<td class="form_label" align="right">超限说明：</td>
     	<td colspan="3">
	     	<h:textarea property="modelOne.content" id="content"  extAttr="class='h80' "  validateAttr="maxLength=512;allowNull=ture" rows="4"  style="width:90%;" />
     	</td>
      </tr>
      
            <tr>
     	<td class="form_label" align="right">处理意见：</td>
     	<td colspan="3">
	     	<h:textarea property="modelOne.hanldOption" id="hanldOption"  extAttr="class='h80' "  validateAttr="maxLength=512;allowNull=ture" rows="4"  style="width:90%;" />
     	</td>
      </tr>
      
      
      <!--    <tr id="row1">
      	<td class="form_label" align="right">差错情况：</td>
     	<td colspan="3">
      	<table border=0 id="ccTable">
		</table>
      	</td>
      </tr>-->
      
     <tr id="errorContent" style="display: none">
     	<td class="form_label" align="right">差错情况：</td>
     	<td colspan="3">
				<br/>
				<table border=0 id="tabtest1"   width="100%">
				</table>
     	</td>
     </tr>
      
      <%@include file="/jsp/util/default_gp_opinionUtil.jsp" %>
      
      <tr class="form_bottom">
        <td colspan="4">
        
          <input type="button" value="保存" class="button" id="save1" onclick="doSave(1);"  />
          <input type="button" value="提交" onclick="doSave(2);" class="button" id="smit" />
          <input type="button" value="查看流程" onclick="doflowpic();" class="button" id="flowpic" />
         </td>
      </tr>
      <tr id="row2">
     <td class="form_label" align="right">流 程 列 表：</td>
     <td colspan="3">
     <%@include file="/jsp/util/opinionUtil_generalProcess.jsp"%>
		</td>
     </tr>
    	
    </table>
    </div>
    </h:form>
  </body>
 <script type="text/javascript">

 $("#yxry").blur(function(){
	 
	 var yxry =$("#yxry").val();
	
		$.ajax({
			url : "/Generalprocess//generalProcessAction_queryyxryjg.action",
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

				


				
				if (json == "") {

				} else {
					$.each(json,function(key, value) {
				
					$("#yxryjg").val(value.yxryjgs);
					
						
					});
				}
			}
		});
 });
 function remove(id){
	 $("#"+id).val("");
	

	  }

 function saveRectification(mistakeId,rowId){

		var rectification = $("#rectification"+rowId).val();
		if(rectification==null & rectification==""){alert("请输入整改情况!")}
		$.ajax({//获得当前
			        url: "/Generalprocess/tGeneralprocessModeloneAction_updateProcessMistake.action",
			        async:false,
			        type: 'post',
			        data: "processMistake.mistakeId="+mistakeId+"&processMistake.rectification="+rectification,
			        dataType:"text",
			        timeout: 60000,
			        	 success: function (data) {
					    	  if (data.indexOf("success") >= 0) {
					    		  alert("保存成功");
					    		  
							} else if (data.indexOf("fails") >= 0) {
								alert("保存失败!");
							} else {
								alert("操作失败!");
							}
									  	
					      }
			        
		    });	
 }
 var rowId = 0; 
 $(function (){

		
        var submitter; 
		var currenUser;
		var flowId=$("#executionId");

		if($("#basic_rate_float").val()=="0"){ //初始化数据后，若浮动方向为“不变”，则利率比例 不可输入
			 
		  	   $("#rate_float_scale").attr("readonly","true");
		  	   $("#rate_float_scale").val(0);
		     }
		

		
	 $.ajax({
		 url : "/Generalprocess/tGeneralprocessModeloneAction_querySubmitter.action",
			async : false,
			type : 'post',
			data : "processSubmitter.flowId=${taskAssgineeDto.executionId}",
			timeout : 60000,
			dataType : 'json',
			success : function(json) {
						
				
					 submitter=json.submitter; 
					 currenUser=json.currenUser;
					
					
			}});

		if(submitter==currenUser){

			$("#errorContent").css("display","");
			
			$.ajax({
				
				url : "/Generalprocess/tGeneralprocessModeloneAction_queryProcessMistake.action",
				async : false,
				type : 'post',
				data : "processMistake.flowId=${taskAssgineeDto.executionId}",
				timeout : 60000,
				dataType : 'json',
				success : function(json) {
					if (json == "") {

					} else {

                     $.each(json,function(key, value) {
                    		var money =value.money;
                    		var mistakeContent =value.mistakeContent;
                    		var rectification =value.rectification;
                    		var mistakeId =value.mistakeId;
							if(rectification==null){
								rectification="";

								}
							 var tab,row,td,tdStr;
							 var zs=$("#tabtest1 tbody tr").length;
							 tab = $id("tabtest1"); 
							 row =  tab.insertRow();
							 row.id = "fileRow"+rowId;
							 td = row.insertCell(); 
		tdStr="差错内容：<textarea   rows=\"3\" style=\"width:60%\"  name=\"mistakeContent\" id=\"mistakeContent\" size='70' validateAttr=\"allowNull=false\" readonly=\"true\"        >"+mistakeContent+"</textarea>";
		tdStr+="<input type=\"hidden\" id=\"processMistake.mistakeId\" name=\"mistakeId\" value=\""+mistakeId+"\" />";
		tdStr+="扣罚金额：<input type=\"text\" name=\"money\" value=\""+money+"\" id=\"money\" readonly=\"true\" size='10' validateAttr=\"allowNull=false\">元  <br/>";
		tdStr+="整改情况：<textarea   rows=\"3\" style=\"width:60%\"  size='70'  name=\"rectification\" id=\"rectification\"  >"+rectification+"</textarea>";
			
	    tdStr+= "<input type=\"button\" onclick=\"remove('rectification"+rowId+"');\" name='button"+rowId+"' value=\"清空\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
		tdStr+= "<input type=\"button\" onclick=\"saveRectification("+mistakeId+","+rowId+");\" name='button"+rowId+"' value=\"保存\" style=\"margin-left:2px;vertical-align:middle;cursor:hand;\"/>";
								td.innerHTML = tdStr;
							    rowId = rowId+1;     
				
			
							  	 
						});	
							}}
						});
			     }
	           	});
 
 





 
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

 
 show('${taskAssgineeDto.fxJson}');
 $(document).ready(function(){

	 //获取当前登录者的上级机构code
	 var orgcode = '${sessionScope.login_user.orgcode}';
	 $.ajax({
	        url: '/Generalprocess/generalProcessAction_isHaveParentOrgId.action',
	        async: false,
	        type: 'post',
	        data: "orgcode="+orgcode,
	        dataType: 'text',
	        timeout: 60000,
	        success: function (data) {
		       if(data.indexOf("success")>=0){
		    	 //上级机构为厦门市分行
		  		 //受理支行(一级) 为当前登录者的所属机构
		  		 //受理支行(二级) 的startOrgId为当前登录者的所属机构
		  		 $("#orgNameOne").val('${sessionScope.login_user.orgname}');
		  		 $("#orgCodeOne").val('${sessionScope.login_user.orgcode}');
		  		 $("#startOrgid").val('${sessionScope.login_user.orgid}'); 
		       }else{
		    	 //上级机构非厦门市分行
		  		 //受理支行(一级) 为当前登录者的所属机构的上级机构
		  		 //受理支行(二级) 为当前登录者的所属机构
		  		 var ss= new Array();
		  		 ss = data.split(",");
		  		 $("#orgNameOne").val(ss[2]);
		  		 $("#orgCodeOne").val(ss[1]);
		  		 $("#orgNameTwo").val('${sessionScope.login_user.orgname}');
		  		 $("#orgCodeTwo").val('${sessionScope.login_user.orgcode}');
		  		 $("#startOrgid").val(ss[0]);
		       }
	        }
 	});
	//隐藏结束流程按钮
		$("#deleteProcessBtn").hide();
		if('${sessionScope.login_user.empid}'=='${modelOne.creator}'){
			  if($("#executionId").val()){
				  //当登录人等于发起人，显示结束流程按钮
				  $("#deleteProcessBtn").show();
		  	    }
		}
	 if('${modelOne.processModelId}'!=""){
		 if('${modelOne.creator}'!='${sessionScope.login_user.empid}')
		 $("#save1").css("display","none"); 	

 		 $.ajax({
		        url: '/modeFile/tModelFileAction_selectFiletest.action',
		        async: false,
		        type: 'post',
		        data: "executionId=${taskAssgineeDto.executionId}&modeId=${modelOne.processModelId}&modeType=mod1",
		        dataType: 'json',
		        timeout: 60000,
		        success: function (files) {
			        if(files!=""){
			         	$.each(files,function( i,item ){
				         	if('${isView}'!='')
			    	        	$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId});
				         	else 
				         		$("#tag").fileDown({filename:item.fileName,filevalue:item.fileId,remove:1});
			          		});	
			        } else{    
			        	$("#row1").css("display","none");  
			        } 
		        }
	    }); 

		  //判断
		  WEB.doDisabledAttr('${isView}','${modelOne.creator}','${sessionScope.login_user.empid}',"opinion");  
		  WEB.doConditionDisplay('${modelOne.creator}','${sessionScope.login_user.empid}',"row3,dopiRow","none");//隐藏意见
	 }else{
		 $("#row1").css("display","none");  
		 $("#row2").css("display","none");  
		 $("#row3").css("display","none");  
		 $("#dopiRow").css("display","none");  
		 $("#beginOrg").val('${sessionScope.login_user.orgid}');
		 $("#createor").val('${sessionScope.login_user.empid}');
	 }
	 
	 //主调信贷员	姓名		显示
	 if('${modelOne.creatorName}'==""){
		 $("#creatorName").val('${sessionScope.login_user.empname}');
	 }
	 //主调信贷员	员工号	隐藏
	 if('${modelOne.creator}'==""){
		 $("#creator").val('${sessionScope.login_user.empid}');
	 }

	 setOneSelect('${taskAssgineeDto.processName}');
	 
	 if('${modelOne.oneCategory}'!=""){
		 var oneCategory='${modelOne.oneCategory}';
		 setLcselect(oneCategory);
	 }

	 
	 //查看详情界面
	 if('${isView}'!=''){
		$("#save1").hide();
		$("#smit").hide();
	}
	 
	 if('${taskAssgineeDto.isC}'){
			$("#smit").hide();
			$("#deleteProcessBtn").hide();
		}else{			
			$("#smit2").hide();
	 }
});

/**
 * 查询流程列表
 */
function initPlanCell20(){
		var queryCond="";
			queryCond += "<flowId>${taskAssgineeDto.executionId}</flowId>";
			return queryCond;
}

	 //value 为1		保存
	 //value 为2 	提交
     function doSave(value){
    		$("#btnType").val(value);

    		if(checkForm($id("form1"))){
    			  var   reg = /\-|\+?/;  //匹配正负号
    			  var result = ($("#rate_float_scale").val()).match(reg);  //result可能为+、-、空，空值说明没带符号
    			 
    			  if(result != ""){ 
    				     $("#rate_float_scale").addClass("verify_failure");
    		             alert("利率浮动比例无需输入符号！");
    		             return false;
    	     	  }

    		 		
    	 		//基准利率浮动 和 率浮动比例  必须-->两个要么都不写， 要么都写
    	 		 if($("#basic_rate_float").val() != "" && ($("#rate_float_scale").val()).trim() == ""){

    	 			 $("#rate_float_scale").addClass("verify_failure");
    	 			 $("#rate_float_scale").focus();
    	             alert("当前已选择基准利率浮动，请输入利率浮动比例!");
    	             return false;
    		       }
    		
    		   		if($("#basic_rate_float").val() == "" && ($("#rate_float_scale").val()).trim() != ""){
    		   			  $("#basic_rate_float").focus();
    		               alert("当前已输入利率浮动比例，请选择基准利率浮动!");
    		               return false;
    		          }

    		   		$("#rate_float_scale").val($("#rate_float_scale").val().trim());
    		   		
    		             
    	    		if(value!="1"){  //执行 提交

        		if($("#oneCategory").val($('#oneCategorys option:selected').val())==""||$("#oneCategory").val($('#oneCategorys option:selected').val())==null){
            		alert("请选择一级分类");
            		return false;
            		}

        		if($("#loanCategory").val($('#loanCategorys option:selected').val())=="" || $("#loanCategory").val($('#loanCategorys option:selected').val())==null){
        			alert("请选择贷种分类");
            		return false;
                		}

        		$("#oneCategory").val($('#oneCategorys option:selected').val());
        		$("#loanCategory").val($('#loanCategorys option:selected').val());
        		
    			var strUrl = "/jbpm/jbpmDemoAction_toNextTaskConfig.action?taskAssgineeDto.executionId="+$id("executionId").value+"&taskAssgineeDto.beginOrg="+$("#beginOrg").val()+"&taskAssgineeDto.beginAssingee="+$("#beginAssingee").val()+"&taskAssgineeDto.definitionId=${taskAssgineeDto.definitionId}";
    			showModalCenter(strUrl, null, taskAssigneeCallBack, 700, 400, '节点选择');
    		}else{
    			var _form = $id("form1");
    	  	  	url="/Generalprocess/generalProcessAction_handleModelOne.action";	
    	  	  	_form.action =url;
    			    ajaxsubmitO(0);
    	  	 }
    	}
     }

 	function taskAssigneeCallBack(arg){
  	 	var _form = $id("form1");
  	 	if(arg!=""){
  	  	 	url="/Generalprocess/generalProcessAction_handleModelOne.action?"+arg;	
  	  	    _form.action =url;
  	        // 异步提交请求 
  	  	    ajaxsubmitO(1);
  	 	}
  	 }

  	  function ajaxsubmitO(flag){
  	  	maskTop();
  	  	 var options = {
  		  		type : "post",
  		  		cache : "false",
  			  	success : function(data){
  					try {  
  					  	if(data.indexOf("success")>=0){
      					  	alert("操作成功!");
  					  		unMaskTop();
      					  if(flag==1)
      					  WEB.turnMainFrame();
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


		//选择	受理支行	二级选项
		function open_slzhej_fun(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			var startOrgid=$("#startOrgid").val();
			strUrl ="/tree/initMainTree_mainTree.action?changeTree.showTabOrg=1&changeTree.orgType=4&changeTree.showSelBox=1&changeTree.checkcount=1&changeTree.startOrgid="+startOrgid;
			objName="选择受理支行";  
			var paramEntity = new ParamEntity('Organization');
				paramEntity.setProperty('orgname',$id("orgNameTwo").value);
				paramEntity.setProperty('orgcode',$id("orgCodeTwo").value);
				peArgument[3]=[paramEntity,'orgname','orgcode',"orgid"];			
			showModalCenter(strUrl,peArgument,open_slzhej_callback,600,430,objName); 
			}
		
		//受理支行		二级选项	回调方法
		function open_slzhej_callback(arg){//回调方法
				if(arg!=''){
		    	if(arg['Organization']){ //原写法无需判断是否为空
				  		var sorgidArra  = arg['Organization'].slice(0);//人员数组
				  		argRes=[[],[],[],[]];
						for(var i=0;i<sorgidArra.length;i++){
							argRes[0].push(sorgidArra[i].getProperty("orgcode"));
							argRes[1].push(sorgidArra[i].getProperty("orgname"));
						}
						$id("orgNameTwo").value = argRes[1];
						$id("orgCodeTwo").value = argRes[0];
					}
		    	}
			}


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
		
		/* function open_yjfl_fun(){
			var strUrl ="";
			var objName="";
			var peArgument = [];
			strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_queryViewList.action";
			showModalCenter(strUrl,peArgument,open_yjfl_fun_callback,800,500,"一级分类列表"); 
			}

		function open_yjfl_fun_callback(arg){
				if(arg!=''){
					$id("oneCategory").value=arg;
					var x=document.getElementById("loanCategorys");
					x.options.length=0;  
					setselect(arg);
				} 
			} */
		function changeloanCategory(){
			$("#loanCategory").val($('#loanCategorys option:selected').val());
			}	
		function changeoneCategory(){
			$("#oneCategory").val($('#oneCategorys option:selected').val());
			 setLcselect($("#oneCategory").val());
			

			
			}	
		function setLcselect(arg){
			$("#loanCategorys").html("");
			var processName='${taskAssgineeDto.processName}';
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
						for (i=0; i<all_options.length; i++){
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
						for (i=0; i<all_options.length; i++){
							if (all_options[i].value ==$id("oneCategory").value ) // 根据option标签的ID来进行判断 测试的代码这里是两个等号
							{
								all_options[i].selected = true;
							}
						}
						$("#oneCategory").val($('#oneCategorys option:selected').val());
						 setLcselect($("#oneCategory").val());
				    }
		}

		//判断利率浮动是否选择为“不变”
		function rate_judge_fun(){
			
           if($("#basic_rate_float").val()=="0"){ //若浮动方向为“不变”，则无需输入比例，默认为0
        	   $("#rate_float_scale").attr("readonly","true");
        	   $("#rate_float_scale").val(0);
           }else{  //其他为可输入
        	   $("#rate_float_scale").attr("readonly","");
        	   if($("#rate_float_scale").val() == 0){
        		   $("#rate_float_scale").val("");
            	}
           }
		}
 </script>
</html>