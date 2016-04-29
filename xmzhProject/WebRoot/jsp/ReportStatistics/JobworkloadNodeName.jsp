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
<title>流程节点选择</title>

  </head>
  <body>
			
			<DIV class="divList"  style="overflow:auto;width:100%; height: 310;">
			<w:panel id="panel" width="100%" title="流程节点选择">
			<table align="center" border="0" width="100%" class="form_table">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
         
					<table align="center" border="0" width="100%" class="EOS_table">
						<tr>
							<th align="center" nowrap="nowrap">
								<l:greaterThan property="page.count" targetValue="0" compareType="number">
	                 					<h:checkbox id="selectBox" onclick="allItem();"/>
	             				 </l:greaterThan>
								<b:message key="l_select"></b:message>
							</th>
							<th nowrap="nowrap">
								流程节点
							</th>
							
						</tr>
			
			
			<w:checkGroup id="group1">
                            <l:iterate property="jobWorkloadList" id="id1">
							 <tr class="<l:output oddOutput="EOS_table_row_o" evenOutput='EOS_table_row' />">
								<td align="center" nowrap="nowrap">
									<w:rowCheckbox>
											<h:param name='processNodeName' iterateId='id1' property='processNodeName' />
									</w:rowCheckbox>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="processNodeName" />
								</td>
								
							</tr>
					
						</l:iterate>
						
					</w:checkGroup>
					
					
							
					</table>
			</w:panel>
			</DIV>
			<DIV class="divList"  style="overflow:auto;width:100%; height: 100%;">
						<table align="center" border="0" width="100%" class="EOS_table">
					<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						 
                            <input id="downexl" type="button" class="button" value="确定" onclick="returnValue();">
                            
                            </td>
					</tr>	
					</table>
				    		
		</DIV>
  </body>
  <script type="text/javascript">


  function returnValue(){
		
	    var g = $id("group1");
	      if (g.getSelectLength() ==0 ) {
	        alert("请选择一行记录！");
	        return; 
	        }else{

	        	var rows=g.getSelectRows();
	  			var processNodeName="";
	  			for(var i=0;i<rows.length;i++){
	  				processNodeName += rows[i].getParam("processNodeName")+",";
	  			}
	  			if(processNodeName!=""){
	  				processNodeName=processNodeName.substring(0,processNodeName.length-1);  //将最后一个逗号去掉
        	
		        }
	        }
	   
	  	  window.returnValue=[processNodeName];
	  	  window.close();
	    
	    
	  }

  </script>
</html>
