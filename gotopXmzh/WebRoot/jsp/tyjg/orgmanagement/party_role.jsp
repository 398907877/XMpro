<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin1/component.jsp" %>
<%@page import="java.util.*"%>
<h:css href="/css/style1/style-custom.css"/>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>
      选择可授权的角色
    </title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<h:script src="/common/skins/default/scripts/common.js" />
  </head>
  <body style="margin: 0px;">
  <%
	String pnHavenot_roleid=com.eos.foundation.eoscommon.ResourcesMessageUtil.getI18nResourceMessage("orgSubMaintain_pnHavenot.roleid");
	String pnHavenot_rolename=com.eos.foundation.eoscommon.ResourcesMessageUtil.getI18nResourceMessage("orgSubMaintain_pnHavenot.rolename");
	String pnHavenot_appname=com.eos.foundation.eoscommon.ResourcesMessageUtil.getI18nResourceMessage("orgSubMaintain_pnHavenot.appname");
%>
	<h:script src="/common/gotop/datacellCheckBox.js"></h:script><!-- 引用datacell单选函数 -->
	<h:script src="/common/gotop/lookup-group.js"/>
	<script type="text/javascript">
  	var checkgroup = new CheckGroup("dcHavenot_group");
	checkgroup.cellnum = 0;//指定那一个列为复选框
	checkgroup.beforeSelectFunc="lookUp_selectFunc(this)";
	checkgroup.beforeUnSelectFunc="lookUp_unSelectFunc(this)";
	/*
	*	初始化选中框
	*/	
	Datacell.prototype.afterRefresh = function() {
		this.checkgroup.selectBoxID = document.getElementById("selRole");//已选框ID
		this.checkgroup.submitParamName = "roleId";//lookup的值与CheckGroup的对应h:param
		this.checkgroup.displayParamName = "roleName";//lookup的显示名与CheckGroup的对应h:param
		this.checkgroup.hiddenParamName = "auto";//lookup的显示名与CheckGroup的对应h:param
		this.checkgroup.initTitle=true;
		this.checkgroup.initLookUp_Datacell();
		var toolHTML = "<input type='button' class='button' value='确定返回' onclick='rtnSelectVal()' />";
		toolHTML += "<input type='button' class='button' value='删除已选' onclick='checkgroup.batchDeleteOption()' />";
		
		this.setCustomTool(toolHTML);
	}
	function rtnSelectVal() {
		window.returnValue = checkgroup.getReturnValue();//从CheckGroup中取得返回值
		window.closeD();
	}
	rowCheckBox.prototype.reverseSelect = function() {
	    if (this.value){
	    	var roleid = this.getParam("roleType");
			if(roleid=='2'){
				alert(this.getParam("roleName")+'为指定分配角色。不能私自删除');
			}else{
			    this.disSelected();
			}
	    }else{
		    this.setSelected()
	    }
	};
	CheckGroup.prototype.deleteOption = function(selObj){
		var index = selObj.options.selectedIndex;
		if(index>=0){
			var row = selObj.options[index].row;
			if(row){
				selObj.options[index].row.reverseSelect();
			}else{
				var obj = selObj.options[index];
				var value = getOrgdegreeByRoleid(obj.value);
				if(value==0){
					alert(obj.innerText+'为指定分配角色。不能私自删除');
				}else{
				    selObj.options[index]=null;	
				}
			}
		}
	}
	CheckGroup.prototype.selectedDeleteOption = function(selObj){
		for (var i = selObj.options.length-1; i >= 0; i--) {
			if(selObj.options[i].selected){
				var row = selObj.options[i].row;
				if(row){
					selObj.options[i].row.reverseSelect();
				}else{
					var obj = selObj.options[i];
					var value = getOrgdegreeByRoleid(obj.value);
					if(value==0){
						alert(obj.innerText+'为指定分配角色。不能私自删除');
					}else{
					    selObj.options[i]=null;
					}
				}
			} 
		}
	}
	function paramFunc(){
		var strxml = '<jgsx><b:write property="partyRole.jgsx"/></jgsx><roletype><b:write property="partyRole.roleType"/></roletype>';
		strxml += '<orgdegree><b:write property="partyRole.orgDegree"/></orgdegree>';
		return strxml;
	}
	</script>
     <table align="center" border="0" width="100%">
   		<tr>
   			<td valign="top">
  					<r:datacell id="dcHavenot" showIndex="false" initParamFunc="paramFunc"
						paramFormId="qfHavenot" xpath="com.gotop.tyjg.orgmanagement.model.PartyRole" width="100%"
						height="400" pageSize="20"
						queryAction="/orgmanagement/organizationAction_initChangeGrantRole.action"> 
						<r:toolbar tools="nav:first prev next last goto,pagesize,custom,info" location="botton" />
						<r:field fieldName="roleId" label="操作" sortAt="client" width="30" align="center" /> 
						<r:field fieldName="roleId" label="<%=pnHavenot_roleid%>" sortAt="client" width="100" /> 
					    <r:field fieldName="roleName" label="<%=pnHavenot_rolename%>" width="150"/> 
					    <r:field align="left" width="60" align="center"
							fieldName="auto" label="角色等级" allowModify="false" defaultValue="4">
							<!-- 操作等级 --> 
								<d:select id="auto" style="WIDTH:100;" dictTypeId="ABF_ROLEDEGREE"/>
						</r:field>
					</r:datacell>
			</td>
			<td width="50px" valign="top">
			   <table align="center" border="0" width="100%" class="EOS_table">
			       <tr>
				       <td width="100%" class="eos-panel-title">&nbsp;已选项角色</td>
				   </tr>
			       <tr>
			       	   <td width="100%">
						  <SELECT id="selRole" size="24" multiple="multiple" style="width: 200px" ondblclick="checkgroup.deleteOption(this)">
					      </SELECT>
					   </td>
				  </tr>
				</table>
   			</td>
		</tr>
	</table>
  </body>
</html>
