/* 判断当前机构是部门还是支行 */
function judgeIsDept(orgid){
	
	var info = "";
	   
	$.ajax({
	    url: "/reportjbpm/loanRateFloatReportAction_judgeIsDept.action",
	    async: false,
	    type: 'post',
	    data: "orgid="+orgid,
	    timeout: 60000,
	    success: function (data) {
	       info = data;
	    }
	}); 
	
	return info;
	
}