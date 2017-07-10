<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>

<h:css href="/css/style1/style-custom.css" />
<script type="text/javascript" src="/js/jquery.form.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>新增 一级分类</title>
</head>
<body topmargin="0" leftmargin="0">
<h:form name="data_form"  id="data_form" action="/jbpm/xdProcessAction_addOneCategory.action"  enctype="multipart/form-data" method="post" >
		<table align="center" border="0" width="100%" class="form_table">
			<h:hidden id="processName" property="xdCdtypeBean.processName"  name="xdCdtypeBean.processName"/>
			
			<tr>	
				<td class="form_label" align="right" width="15%">流程名称：</td>
				<td colspan="1" width="30%">
					<b:write property="xdCdtypeBean.processName" />
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">一级分类：</td>
				<td colspan="1" width="30%">
			<%-- 	<h:hidden id="oneCategoryId" /> --%>
				<h:text id="oneCategory" property="xdCdtypeBean.oneCategory"  readonly="true"  validateAttr="allowNull=false" />
							<a href="#" onclick="showoneCategory();">选择</a>		
				</td>						
			</tr>
			
			<tr>	
				<td class="form_label" align="right" width="15%">贷种分类：</td>
				<td colspan="1" width="30%">
				<%-- <h:hidden id="loanCategoryId" /> --%>
				<h:textarea rows="5" cols="40"  id="loanCategory" property="xdCdtypeBean.loanCategory"  readonly="true"  extAttr="class='h80' "  validateAttr="allowNull=false" />
							<a href="#" onclick="showloanCategory();">选择</a>		
				</td>						
			</tr>
			<tr>
				<td class="form_label" align="right" width="15%">时限参数：</td>
				<td colspan="1" width="30%"> <h:text property="xdCdtypeBean.limit_time"/>   </td>
			</tr>
			
			<tr>
				<td colspan="2" style="text-align: center"><input type="button" value="保存"
					onclick="save();"  class="button"> <input type="button" value="关闭"
					onclick="window.close();" class="button"></td>
			</tr>
		</table>
	</h:form>
<script type="text/javascript">

	function save(){

		var frm=$name("data_form");
 		if(!checkForm(frm)){
			 return ;
		 }

 		var processName = $id("processName").value;
		var oneCategory = $id("oneCategory").value;
 		$.ajax({
		      url: "/jbpm/xdProcessAction_checkOneCategory.action",
		      async: false,
		      type: 'post',
		      data: "xdCdtypeBean.processName="+processName+"&xdCdtypeBean.oneCategory="+oneCategory,
		      timeout: 60000,
		      success: function (data) {
		       if (data.indexOf("success") >= 0) {
		    		  ajaxsubmitO(); 
				} else if (data.indexOf("fails") >= 0){
						alert("该一级分类已存在！请重新选择！");	
				} else {
					alert("操作失败!");
				}
		      }
		}); 
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

	//查数据库表t_model_oneAndLoanCategory，得到一级分类列表， 单选按钮显示页面
	function showoneCategory() {
		/* var oneCategoryId=document.getElementById("oneCategoryId").value;
		strUrl ="/jbpm/xdProcessAction_oneCategoryDic.action?cdtypeJson="+oneCategoryId; 
		showModalCenter(strUrl,'',showoneCategory_callback1 ,800,430,'一级分类选择'); */
		
		strUrl = "/jbpm/timeLimitManageAction_queryOneCategorylist2.action";
		showModalCenter(strUrl,'',showoneCategory_callback1 ,500,430,'一级分类选择'); 
	} 
	function showoneCategory_callback1(args){
		/* if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("oneCategoryId").value = array[0];
		 document.getElementById("oneCategory").value = array[1];
		} */
		
		if(args!= null){
			if($id("oneCategory").value != args[0]){
				$id("loanCategory").value = "";
			}
			 $id("oneCategory").value = args[0];
		}
	}

	function showloanCategory() {
		/* var loanCategoryId=document.getElementById("loanCategoryId").value;
		strUrl ="/Generalprocess/tGeneralprocessCdtypeAction_loanCategoryDic.action?cdtypeJson="+loanCategoryId,
		showModalCenter(strUrl,'',showloanCategory_callback1 ,800,500,'贷种分类选择');  */

		var oneCategory_name = $id("oneCategory").value;
		if(oneCategory_name == ''){
			alert("请先选择一级分类！");
		}else{
			strUrl = "/jbpm/timeLimitManageAction_queryLoanCategorylist2.action?proLoanBean.oneCategory_name="+oneCategory_name;
			showModalCenter(encodeURI(strUrl),'',showloanCategory_callback1 ,500,430,'贷种分类选择'); 
		}
	} 
	function showloanCategory_callback1(args){
		/* if(args!=''){
		var array;
		array = args.split(":");
		 document.getElementById("loanCategoryId").value = array[0];
		 document.getElementById("loanCategory").value = array[1];
		} */

		if(args!=null){
			 $id("loanCategory").value = args;
		}
	}	
</script>
</body>
</html>