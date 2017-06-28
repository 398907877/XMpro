<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page  language="java" import="java.util.*,com.gotop.util.time.TimeUtil"%>
<%@include file="/common/common.jsp"%>
<%@include file="/common/skins/skin0/component.jsp"%>
<h:css href="/css/style1/style-custom.css" />
<script src="<%=request.getContextPath() %>/common/gotop/jquery.min.js"></script>

<script src="<%=request.getContextPath() %>/js/org_public.js"></script>
<% 

String str_date = TimeUtil.today();


%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>库存统计</title>
	</head>
	<body topmargin="0" leftmargin="0">
	<h:form id="statQuery" name="statQuery"	action="/mortgage/inventoryStatQueryAction_queryInventoryStatList.action" method="post">
		<w:panel id="panel1" title="查询条件">
			<table align="center" border="0" width="100%" class="form_table">
				
				<tr>
				   <td class="form_label" align="right" width="20%">押品类型</td>
					<td width="20%">
						<d:select id="mortgageType" name="inventoryStat.mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE" property="inventoryStat.mortgageType" onchange="changeMortgageType(this.value)"  ></d:select>
					</td>
                    <!--  <td class="form_label" align="right" width="20%">统计日期：</td>
					<td width="30%">	
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="statTime" name="inventoryStat.statTime" 
					property="inventoryStat.statTime" /></td>-->
					<td class="form_label" align="right" width="20%">统计日期：</td>
					<td width="30%">
					从	
					<w:date  format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="inTimeStart" name="inventoryStat.inTimeStart" 
					property="inventoryStat.inTimeStart" value="<%=str_date%>"/> 
                                                            到
					    <w:date format="yyyy-MM-dd" submitFormat="yyyyMMdd" id="inTimeEnd" name="inventoryStat.inTimeEnd" 
					property="inventoryStat.inTimeEnd" value="<%=str_date%>"/></td>
                   			
				</tr>
				<tr class="form_bottom">
						<td colspan="8" class="form_bottom">
						    <b:message key="l_display_per_page"></b:message>
					        <h:text id="pageLeng" size="2" property="page.length" value="10" validateAttr="minValue=1;maxValue=100;type=integer;isNull=true" />
					        <input type="hidden" name="page.begin" value="0">
					        <input type="hidden" name="page.isCount" value="true">
							<input id="querys" type="button" value="查 询" class="button" onclick="search();">
                                   <input id="downexl" type="button" class="button" value="导出" onclick="excelExport();">
                                   <input type="button" value="清 空" class="button" onclick="clears();"></td>
					</tr>			
					
			</table>
		</w:panel>
	</h:form>
	<DIV class="divList">
			<w:panel id="panel" width="100%" title="库存统计列表">
				<viewlist id="e2c61865-3b56-470d-bd42-fff792fb9493">
				<h:form name="page_form"
					action="/mortgage/inventoryStatQueryAction_queryInventoryStatList.action" method="post">
			 <h:hiddendata property="inventoryStat"/>  

            <h:hidden property="page.begin"/>
		    <h:hidden property="page.length"/>
		    <h:hidden property="page.count"/>
		    <h:hidden property="page.isCount"/>
		    
					<table align="center" border="0" width="100%" class="EOS_table">
					<!--
		           <tr>
							<th nowrap="nowrap">
								统计日期
							</th>
							<th nowrap="nowrap">
								押品类别
							</th>
							<th nowrap="nowrap">
								权证种类
							</th>
							<th nowrap="nowrap" colspan="2">
								贷种/他项类型
							</th>
							<th nowrap="nowrap">
								数量
							</th>
							<th nowrap="nowrap">
								合计
							</th>
							
						</tr>
                           <l:iterate property="inventoryStatList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" rowspan="14"> 
									<b:write iterateId="id1" property="statTime" />
								</td>
								<td nowrap="nowrap" rowspan="10"> 
									房产
								</td>
								<td nowrap="nowrap" rowspan="8"> 
									他项
								</td>
								<td nowrap="nowrap" rowspan="4"> 
									零售
								</td>
								<td nowrap="nowrap"> 
									不动产抵押权
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num1" />
								</td>
								<td nowrap="nowrap" rowspan="8"> 
									<b:write iterateId="id1" property="total1" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									不动产登记预告
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num2" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" align="center">
								<td nowrap="nowrap"> 
									预告登记证明
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num3" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									小计
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num4" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" rowspan="4"> 
									小企业
								</td>
								<td nowrap="nowrap"> 
									不动产抵押权
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num5" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									不动产登记预告
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num6" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'  />" align="center">
								<td nowrap="nowrap"> 
									预告登记证明
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num7" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									小计
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num8" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" rowspan="2"> 
									产权证
								</td>
								<td nowrap="nowrap" colspan="2"> 
									零售
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num9" />
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									<b:write iterateId="id1" property="total2" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" colspan="2"> 
									小企业
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num10" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" rowspan="4"> 
									机动车
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									他项
								</td>
								<td nowrap="nowrap" colspan="2"> 
									汽车消费
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num11" />
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									<b:write iterateId="id1" property="total3" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" colspan="2"> 
									经营性车辆
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num12" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" rowspan="2"> 
									机动车登记
								</td>
								<td nowrap="nowrap" colspan="2"> 
									汽车消费
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num13" />
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									<b:write iterateId="id1" property="total4" />
								</td>
							</tr>
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap" colspan="2"> 
									经营性车辆
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num14" />
								</td>
							</tr>
						</l:iterate>
						  -->
						<!-- 
						
							  <tr align="center">
								<td nowrap="nowrap" rowspan="11"> 
									--
								</td>
								<td nowrap="nowrap" rowspan="7"> 
									房产
								</td>
								<td nowrap="nowrap" rowspan="5"> 
									他项
								</td>
								<td nowrap="nowrap" rowspan="4"> 
									零售
								</td>
								<td nowrap="nowrap"> 
									不动产抵押权
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
								<td nowrap="nowrap" rowspan="5"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap"> 
									不动产登记预告
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap"> 
									预告登记证明
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap"> 
									小计
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap"> 
									小企业
								</td>
								<td nowrap="nowrap"> 
									/
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap" rowspan="2"> 
									产权证
								</td>
								<td nowrap="nowrap" colspan="2"> 
									零售
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap" colspan="2"> 
									小企业
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap" rowspan="4"> 
									机动车
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									他项
								</td>
								<td nowrap="nowrap" colspan="2"> 
									汽车消费
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap" colspan="2"> 
									经营性车辆
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap" rowspan="2"> 
									机动车登记
								</td>
								<td nowrap="nowrap" colspan="2"> 
									汽车消费
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
								<td nowrap="nowrap" rowspan="2"> 
									--
								</td>
							</tr>
							<tr align="center">
								<td nowrap="nowrap" colspan="2"> 
									经营性车辆
								</td>
								<td nowrap="nowrap"> 
									--
								</td>
							</tr>
						 -->
				<!-- 
						 <tr>
							<th nowrap="nowrap">
								统计日期
							</th>
							<th nowrap="nowrap">
								押品类别
							</th>
							<th nowrap="nowrap">
								贷款种类
							</th>
							<th nowrap="nowrap">
								他项类型
							</th>
							
							<th nowrap="nowrap">
								数量
							</th>
							
						</tr>
                           <l:iterate property="inventoryStatList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="statTime" />
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="mortgageType" dictTypeId="MORTGAGE_RESERVE_TYPE"/>
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="loanType" dictTypeId="LOAN_TYPE_VIEW"/>
								</td>
								<td nowrap="nowrap"> 
									<d:write iterateId="id1" property="otherType" dictTypeId="OTHER_TYPE_VIEW"/>
								</td>
								
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num" />
								</td>
							</tr>
						</l:iterate> --> 
						<tbody id="tj_fc">	
						<tr>
							<th nowrap="nowrap">
								统计日期
							</th>
							<th nowrap="nowrap">
								押品类型
							</th>
							<th nowrap="nowrap">
								权证种类
							</th>
							<th nowrap="nowrap">
								贷款种类
							</th>
						   <th nowrap="nowrap">
								他项类型
							</th>
							<th nowrap="nowrap">
								数量
							</th>
						</tr>
                           <l:iterate property="inventoryStatList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="statTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mortgageType" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="warrantsType" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanType"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="otherType"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num" />
								</td>
							</tr>
						</l:iterate>
						</tbody>
						<tbody id="tj_jdc" style="display:none">
						<tr>
							<th nowrap="nowrap">
								统计日期
							</th>
							<th nowrap="nowrap">
								押品类型
							</th>
							<th nowrap="nowrap">
								权证种类
							</th>
							<th nowrap="nowrap">
								贷款种类
							</th>
							<th nowrap="nowrap">
								数量
							</th>
						</tr>
                           <l:iterate property="inventoryStatList" id="id1">
							<tr class="<l:output evenOutput='EOS_table_row' oddOutput='EOS_table_row_o'/>" align="center">
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="statTime" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="mortgageType" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="warrantsType" />
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="loanType"/>
								</td>
								<td nowrap="nowrap"> 
									<b:write iterateId="id1" property="num" />
								</td>
							</tr>
						</l:iterate>
						</tbody>
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
	                <l:equal property="page.isCount" targetValue="true">
		                <input type="button" class="button" onclick="firstPage('page', '', null, null, 'page_form');" value='<b:message key="l_firstPage"></b:message>'  <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="prevPage('page', '', null, null, 'page_form');" value='<b:message key="l_upPage"></b:message>' <l:equal property="page.isFirst"  targetValue="true">disabled</l:equal> >
		                <input type="button" class="button" onclick="nextPage('page', '', null, null, 'page_form');" value='<b:message key="l_nextPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                  	<input type="button" class="button" onclick="lastPage('page', '', null, null, 'page_form');" value='<b:message key="l_lastPage"></b:message>' <l:equal property="page.isLast"  targetValue="true">disabled</l:equal> >
	                </l:equal>
              </div>
              
              
              </td>
            </tr>
					</table>
				</h:form>
				</viewlist>
			</w:panel>		
		</DIV>
		<script type="text/javascript">
		var options=$("#mortgageType option:selected");  //获取选中的项
		// alert(options.val());
		 if(options.val()=="1"){
		     $("#tj_fc").show();
		     $("#tj_jdc").hide();
		     
		    }else if(options.val()=="2"){
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
	    callBackFunc();
	    }
	    function callBackFunc(){
			var frm = $name("statQuery");
            frm.submit();
			//  location.reload(); //就算页面直接关闭，也会重新加载页面
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
              $("#inTimeStart_input").val(str);
              $("#inTimeEnd_input").val(str);

              $id("inTimeStart").value=str;
              $id("inTimeEnd").value=str;
              
              $("#mortgageType").val("");
             // $("#statTime_input").val("");
			//清空传入后台的时间控件的值,将当前时间填入
			$name("inventoryStat.inTimeStart").value =aaa;
			$name("inventoryStat.inTimeEnd").value =aaa;
			//$name("inventoryStat.statTime").value ="";
			
			//$name("scan.repTimeEnd").value = "";

			//$("#scanType").val("");
			//$(':input','#statQuery').not(':button,:submit,#pageLeng')
			//.val("")
			//.removeAttr("checked");
			
		}

		
            function search(){
            	//alert($id("inTimeStart").value);
        		if($id("inTimeStart").value == "" || $id("inTimeStart").value ==null ){                
        			 alert("开始时间不能为空！");
        			 return;
        		}else{
        			if($id("inTimeEnd").value == "" || $id("inTimeEnd").value ==null){
              			 alert("截止时间不能为空！");
              			 return;
              		}else{
              			document.getElementById("statQuery").submit();
                  		}
            		}
        
			}

          //导出excel 	
        function excelExport(){
          if($id("inTimeStart").value == "" || $id("inTimeStart").value ==null ){                
   			 alert("开始时间不能为空！");
			 return;
		    }
			if($id("inTimeEnd").value == "" || $id("inTimeEnd").value ==null){
      			 alert("截止时间不能为空！");
      			 return;
      		}
    		
   				//var statTime = $id("statTime").value;
   				var inTimeStart = $id("inTimeStart").value;
   				var inTimeEnd = $id("inTimeEnd").value;
   			   //押品类型
   				var options=$("#mortgageType option:selected");
   				var mortgageType=options.val();
   				
   				var strUrl = "/mortgage/inventoryStatQueryAction_inventoryStatExcel.action?";
                   // if(statTime!=null){
                   //	 strUrl=strUrl+"&inventoryStat.statTime="+statTime;
                  //  }
                    if(inTimeStart!=null){
                      	 strUrl=strUrl+"&inventoryStat.inTimeStart="+inTimeStart;
                       }
                    if(inTimeEnd!=null){
                     	 strUrl=strUrl+"&inventoryStat.inTimeEnd="+inTimeEnd;
                      }	
                    if(mortgageType!=null){
                      	 strUrl=strUrl+"&inventoryStat.mortgageType="+mortgageType;
                       }		
   				
   				window.location.href=strUrl;
   			}

		
		</script>
		
	</body>
</html>