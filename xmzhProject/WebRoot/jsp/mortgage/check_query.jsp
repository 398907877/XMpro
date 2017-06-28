<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page  language="java" import="java.util.*,com.gotop.util.time.TimeUtil"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>
<script type="text/javascript" src="/js/commonUtil.js"></script>
<% 

String str_date = TimeUtil.today();


%>
<html>
 <head>
<title>外借情况查询</title>
</head>
<body topmargin="0" leftmargin="0">
	<h:form name="query_formx" id="query_formx" action="/mortgage/loanInfoQueryAction_queryLoanInfoEntryByTime.action"  target="_self" method="post" >
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				<tr>
				    <td class="form_label" align="right">押品类型：</td>
					<td >
						<d:select id="mortgageType" name="loanInfo.mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE" property="loanInfo.mortgageType" onchange="changeMortgageType(this.value)"  ></d:select>
					</td>
                    <!-- <td class="form_label" align="right" >查询日期：</td>
					<td >	
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="queryTime" name="loanInfo.queryTime" 
					property="loanInfo.queryTime"/></td>
					 -->
					<td class="form_label" align="right">查询日期：</td>
					<td width="30%">
					从	
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="inTimeStart" name="loanInfo.inTimeStart" 
					property="loanInfo.inTimeStart"/> 
                                                            到
					    <w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="inTimeEnd" name="loanInfo.inTimeEnd" 
					property="loanInfo.inTimeEnd"/></td>
					<td class="form_label" align="right">是否超限：</td>
					<td >
						<!-- <select id="whetherOverrun" name="loanInfo.whetherOverrun" property="loanInfo.whetherOverrun" style="width:80px;">
						<option value="0">全部</option>
						<option value="1">是</option>
						<option value="2">否</option>
						</select> -->
						<d:select id="whetherOverrun" name="loanInfo.whetherOverrun" dictTypeId="MORTGAGE_OVERRUN_TYPE" nullLabel="全部" property="loanInfo.whetherOverrun"></d:select>
					</td>
                   			
				</tr>
					<tr class="form_bottom">
						<td colspan="6" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text id="pageLeng" size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
					        
					        <input type="hidden" name="page2.begin" value="0">
					        <input type="hidden" name="page2.isCount" value="true">
							<input id="querys" type="submit" value="查 询" class="button">
							<input id="downexl" type="button" class="button" value="导出" onclick="excelExport();">
							<input type="button" value="清 空" class="button" onclick="clears();">
							</td>
					</tr>		
				</table>
				</w:panel>
				</h:form>
		    <DIV class="divList">
			<w:panel id="panel" width="100%" title="外借情况查询列表">
			    <viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="formx_list" id="formx_list"
				action="/mortgage/loanInfoQueryAction_queryLoanInfoEntryByTime.action"  target="_self" method="post" >
				<h:hiddendata property="loanInfo"/>  
               
				
            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
		    <h:hidden property="page2.begin"/>
		    <h:hidden property="page2.length"/>
		    <h:hidden property="page2.count"/>
		    <h:hidden property="page2.isCount"/>
		    
		   
				
				<table align="center" border="0" width="100%" class="EOS_table">
				<tbody id="tj_fc">
					<tr>
						<!-- <th nowrap="nowrap">序号</th> -->
						<th nowrap="nowrap">外借时间</th>
						<!-- <th nowrap="nowrap">他项类型</th> -->
						<th nowrap="nowrap">库存序号</th>
						<th nowrap="nowrap">产权证号</th>
						<th nowrap="nowrap">产权人</th>
						<th nowrap="nowrap">交接人</th>
						<th nowrap="nowrap">外借数量</th>
						<th nowrap="nowrap">经办支行</th>
						<th nowrap="nowrap">经办客户经理</th>
						<th nowrap="nowrap">已借天数</th>
						<th nowrap="nowrap">是否超限</th>
						<th nowrap="nowrap">备注</th>
					</tr>
					
						<l:iterate property="loanInfoList" id="idx" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<!-- <td nowrap="nowrap">
								   <b:write iterateId="idx" property="loanID" />
								</td> -->
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="checkTime" />
								</td>
							   <!-- <td nowrap="nowrap">
								   <d:write iterateId="idx" property="otherType" dictTypeId="OTHER_TYPE_VIEW"/>
								</td> -->
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="repertoryID" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="propertyCardID" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="propertyPerson" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="borrowerNextName" />
								</td>
								
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="checkNums" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="orgnaizationBranch" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="orgnaizationCustomerManager" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="alreadyLoanDay" />
								</td>
								<td nowrap="nowrap">
								  <d:write iterateId="idx" property="whetherOverrun" dictTypeId="MORTGAGE_OVERRUN_TYPE"/>
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idx" property="remark" />
								</td>
							</tr>
						</l:iterate>
						<tr>
						<td colspan="23" class="command_sort_area">
						<div class="h4">
				                <l:equal property="page.isCount" targetValue="true" >
				                  <b:message key="l_total"></b:message>
				                  <b:write property="page.count" />
				                  <b:message key="l_recordNO."></b:message>
				                  <b:write property="page.currentPage" />
				                  <b:message key="l_page"></b:message>/
				                  <b:write property="page.totalPage" />
				                  <b:message key="l_page"></b:message>
				                </l:equal>
				                <l:equal property="page.isCount" targetValue="false" >
				                  <b:message key="l_NO."></b:message>
				                  <b:write property="page.currentPage" />
				                  <b:message key="l_page"></b:message>
				                </l:equal>
				                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'formx_list');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
				                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'formx_list');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
				                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'formx_list');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
				                <l:equal property="page.isCount" targetValue="true">
				                  <input type="button" class="button" onclick="lastPage('page', '', null, null, 'formx_list');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
				                </l:equal>
              			</div>
					    </td>
					    </tr>
				    </tbody>
					<tbody id="tj_jdc" style="display:none">
					
					<tr>
						<!-- <th nowrap="nowrap">序号</th> -->
						<th nowrap="nowrap">外借时间</th>
						<th nowrap="nowrap">库存序号</th>
						<th nowrap="nowrap">车牌号</th>
						<th nowrap="nowrap">车主</th>
						<th nowrap="nowrap">外借数量</th>
						<th nowrap="nowrap">交接人</th>
						<th nowrap="nowrap">经办支行</th>
						<th nowrap="nowrap">经办客户经理</th>
						<th nowrap="nowrap">已借天数</th>
						<th nowrap="nowrap">是否超限</th>
						<th nowrap="nowrap">备注</th>
					</tr>
				
						<l:iterate property="loanInfoNullList" id="idy" indexId="index">
							<tr class="<l:output evenOutput='EOS_table_row' />">
								<!--<td nowrap="nowrap">
								   <b:write iterateId="idy" property="loanID" />
								</td>  -->
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="checkTime" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="repertoryID" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="licensePlateNumber" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="owners" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="checkNums" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="borrowerNextName" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="orgnaizationBranch" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="orgnaizationCustomerManager" />
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="alreadyLoanDay" />
								</td>
								<td nowrap="nowrap">
								   <d:write iterateId="idy" property="whetherOverrun" dictTypeId="MORTGAGE_OVERRUN_TYPE"/>
								</td>
								<td nowrap="nowrap">
								   <b:write iterateId="idy" property="remark" />
								</td>
							</tr>
						</l:iterate>
						
						<tr>
						<td colspan="23" class="command_sort_area">
						<div class="h4">
				                <l:equal property="page2.isCount" targetValue="true" >
				                  <b:message key="l_total"></b:message>
				                  <b:write property="page2.count" />
				                  <b:message key="l_recordNO."></b:message>
				                  <b:write property="page2.currentPage" />
				                  <b:message key="l_page"></b:message>/
				                  <b:write property="page2.totalPage" />
				                  <b:message key="l_page"></b:message>
				                </l:equal>
				                <l:equal property="page2.isCount" targetValue="false" >
				                  <b:message key="l_NO."></b:message>
				                  <b:write property="page2.currentPage" />
				                  <b:message key="l_page"></b:message>
				                </l:equal>
				                <input type="button" class="button" onclick="firstPage('page2', '', null, null, 'formx_list');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page2.isFirst"  targetValue="true">disabled</l:equal> >
				                <input type="button" class="button" onclick="prevPage('page2', '', null, null, 'formx_list');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page2.isFirst"  targetValue="true">disabled</l:equal> >
				                <input type="button" class="button" onclick="nextPage('page2', '', null, null, 'formx_list');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page2.isLast"  targetValue="true">disabled</l:equal> >
				                <l:equal property="page2.isCount" targetValue="true">
				                  <input type="button" class="button" onclick="lastPage('page2', '', null, null, 'formx_list');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page2.isLast"  targetValue="true">disabled</l:equal> >
				                </l:equal>
              			</div>
              			
					    </td>
					    </tr>
					    </tbody>
				</table>
				

				</h:form>
		</viewlist>
	 </w:panel>	
	</DIV>
	<script type="text/javascript">
	 //var aaa=$id("#mortgageType").value;
	 var options=$("#mortgageType option:selected");  //获取选中的项
	// alert(options.val());
	 if(options.val()=="1"){
	     //document.getElementById("tj_jdc").style.display = "none";
	    // document.getElementById("tj_fc").style.display = "block";
	     $("#tj_fc").show();
	     $("#tj_jdc").hide();
	    }else if(options.val()=="2"){
	     //document.getElementById("tj_fc").style.display = "none";
	    // document.getElementById("tj_fc").style.display = "block";
	     $("#tj_jdc").show();
	     $("#tj_fc").hide();
	    }
	
	//抵押类型改变事件
    function changeMortgageType(val){
    if(val=="1"){
     //document.getElementById("tj_jdc").style.display = "none";
    // document.getElementById("tj_fc").style.display = "block";
     $("#tj_fc").show();
     $("#tj_jdc").hide();
    }else if(val=="2"){
     //document.getElementById("tj_fc").style.display = "none";
    // document.getElementById("tj_fc").style.display = "block";
     $("#tj_jdc").show();
     $("#tj_fc").hide();
    }
    }
	//清空
	function clears(){
		//清空JSP页面时间控件显示的值,将当前时间填入
		var aaa=<%=str_date%>;
        var date=new Date();
        var year = date.getFullYear();  
        var month = date.getMonth();  
        var day = date.getDate();  
        month = month + 1;  
        if (month < 10) month = '0' + month;  
        if (day < 10) day = '0' + day;  
        var str = year + '-' + month + '-' + day;
      //  $("#inTimeStart_input").val(str);
      //  $("#inTimeEnd_input").val(str);
      //  $id("inTimeStart").value=str;
      //  $id("inTimeEnd").value=str;
      //  $name("loanInfo.inTimeStart").value =aaa;
	//	$name("loanInfo.inTimeEnd").value =aaa;
		
		
		$id("inTimeStart").value="";
	    $id("inTimeEnd").value="";
	    
		$("#whetherOverrun").val("");
		//清空JSP页面时间控件显示的值
		$("#inTimeStart_input").val("");
		$("#inTimeEnd_input").val("");
		//清空传入后台的时间控件的值
		
		$name("loanInfo.inTimeStart").value ="";	
		$name("loanInfo.inTimeEnd").value ="";
		
	}

	//导出excel 	
    function excelExport(){
			//押品类型
			var options=$("#mortgageType option:selected");
			var mortgageType=options.val();
			//查询日期
			//var queryTime = $id("queryTime").value;
			
			//查询日期 -开始时间
			var inTimeStart = $id("inTimeStart").value;
			//查询日期 -截止时间时间
			var inTimeEnd = $id("inTimeEnd").value;
			
			//是否超限
			var whetherOverrun = $id("whetherOverrun").value;
			
			var strUrl = "/mortgage/loanInfoQueryAction_loanInfoExcel.action?";
			if(mortgageType != null){strUrl=strUrl+"&loanInfo.mortgageType="+mortgageType;}
   		   // if(queryTime != null){strUrl=strUrl+"&loanInfo.queryTime="+queryTime;} 
			if(inTimeStart != null){strUrl=strUrl+"&loanInfo.inTimeStart="+inTimeStart;} 
			if(inTimeEnd != null){strUrl=strUrl+"&loanInfo.inTimeEnd="+inTimeEnd;} 
			if(whetherOverrun != ""){strUrl=strUrl+"&loanInfo.whetherOverrun="+whetherOverrun;}
			//alert(strUrl);
			window.location.href=strUrl;
		}


	</script>
	</body>
</html>
