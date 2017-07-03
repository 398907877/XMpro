package com.gotop.mortgage.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
import com.gotop.mortgage.model.MortgageReserveUpdLog;
import com.gotop.mortgage.model.WarrantsFile;
import com.gotop.mortgage.service.IMortgageReserveService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

public class MortgageReserveAction extends BaseAction {
	private MortgageReserve mortgageReserve;
	private MortgageReserveCar mortgageReserveCar;
	private MortgageReserveHouse mortgageReserveHouse;
	private MortgageReserveRes mortgageReserveRes;
	private MortgageReserveOut mortgageReserveOut;
	
	private IMortgageReserveService mortgageReserveService;
	private List<MortgageReserveRes> mortgageReserveList=new ArrayList<MortgageReserveRes>();
	private List<MortgageReserve> mortgageReserveListInfo=new ArrayList<MortgageReserve>();
	private List<MortgageReserveHouse> mortgageReserveListHouseInfo=new ArrayList<MortgageReserveHouse>();
	private List<MortgageReserveCar> mortgageReserveListCarInfo=new ArrayList<MortgageReserveCar>();
	private List<MortgageReserveUpdLog> mortgageReserveListLog=new ArrayList<MortgageReserveUpdLog>();
	  
    private File[] files;
    private String[] filesFileName;
    private List<WarrantsFile> fileResourceTables;
	private String resourceId;
	private String fileId;
    
	public File[] getFiles() {
		return files;
	}
	public String[] getFilesFileName() {
		return filesFileName;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}
	public List<MortgageReserveRes> getMortgageReserveList() {
		return mortgageReserveList;
	}
	public void setMortgageReserveList(List<MortgageReserveRes> mortgageReserveList) {
		this.mortgageReserveList = mortgageReserveList;
	}
	public IMortgageReserveService getMortgageReserveService() {
		return mortgageReserveService;
	}
	public void setMortgageReserveService(
			IMortgageReserveService mortgageReserveService) {
		this.mortgageReserveService = mortgageReserveService;
	}
	public MortgageReserve getMortgageReserve() {
		return mortgageReserve;
	}
	public void setMortgageReserve(MortgageReserve mortgageReserve) {
		this.mortgageReserve = mortgageReserve;
	}
	
	
	public MortgageReserveCar getMortgageReserveCar() {
		return mortgageReserveCar;
	}
	public MortgageReserveHouse getMortgageReserveHouse() {
		return mortgageReserveHouse;
	}
	public void setMortgageReserveCar(MortgageReserveCar mortgageReserveCar) {
		this.mortgageReserveCar = mortgageReserveCar;
	}
	public void setMortgageReserveHouse(MortgageReserveHouse mortgageReserveHouse) {
		this.mortgageReserveHouse = mortgageReserveHouse;
	}
	
	
	public MortgageReserveRes getMortgageReserveRes() {
		return mortgageReserveRes;
	}
	public void setMortgageReserveRes(MortgageReserveRes mortgageReserveRes) {
		this.mortgageReserveRes = mortgageReserveRes;
	}
	
	public List<MortgageReserve> getMortgageReserveListInfo() {
		return mortgageReserveListInfo;
	}
	public List<MortgageReserveHouse> getMortgageReserveListHouseInfo() {
		return mortgageReserveListHouseInfo;
	}
	public List<MortgageReserveCar> getMortgageReserveListCarInfo() {
		return mortgageReserveListCarInfo;
	}
	public void setMortgageReserveListInfo(
			List<MortgageReserve> mortgageReserveListInfo) {
		this.mortgageReserveListInfo = mortgageReserveListInfo;
	}
	public void setMortgageReserveListHouseInfo(
			List<MortgageReserveHouse> mortgageReserveListHouseInfo) {
		this.mortgageReserveListHouseInfo = mortgageReserveListHouseInfo;
	}
	public void setMortgageReserveListCarInfo(
			List<MortgageReserveCar> mortgageReserveListCarInfo) {
		this.mortgageReserveListCarInfo = mortgageReserveListCarInfo;
	}
	
	public List<MortgageReserveUpdLog> getMortgageReserveListLog() {
		return mortgageReserveListLog;
	}
	public void setMortgageReserveListLog(
			List<MortgageReserveUpdLog> mortgageReserveListLog) {
		this.mortgageReserveListLog = mortgageReserveListLog;
	}
	public List<WarrantsFile> getFileResourceTables() {
		return fileResourceTables;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setFileResourceTables(List<WarrantsFile> fileResourceTables) {
		this.fileResourceTables = fileResourceTables;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
	
	public MortgageReserveOut getMortgageReserveOut() {
		return mortgageReserveOut;
	}
	public void setMortgageReserveOut(MortgageReserveOut mortgageReserveOut) {
		this.mortgageReserveOut = mortgageReserveOut;
	}
	/**
	 * 查询库存信息
	 * @return
	 */
	public String queryMortgageReserveList(){
		mortgageReserveList=mortgageReserveService.queryMortgageReserveList(mortgageReserve, mortgageReserveHouse, mortgageReserveCar, this.getPage());
		this.setPage(page);
		this.setMortgageReserveList(mortgageReserveList);
		return "mortgageReserveList";
	}
	
	
	/**
	 * 导出库存信息
	 * @return
	 */
	public String queryMortgageReserveListExcel(){
		String res="mortgageReserveListExcel";
		mortgageReserveList=mortgageReserveService.queryMortgageReserveListExcel(mortgageReserve, mortgageReserveHouse, mortgageReserveCar);
		this.setMortgageReserveList(mortgageReserveList);
		if("2".equals(mortgageReserve.getMortgageType())){
			res="mortgageReserveListCarExcel";
		}
		return res;
	}
	
	

	/**
	 * 跳转到 新增 库存页面
	 * @return
	 */
	public String toAddItem(){
		return "add_mortgageReserve";
	}
	

	/**
	 * 跳转到 出入库处理页面
	 * @return
	 */
	public String toOutInColl(){
	    mortgageReserveList=mortgageReserveService.queryMortgageReserveAllList(mortgageReserveRes);
		this.setMortgageReserveList(mortgageReserveList);
		return "out_in_mortgageReserveList";
	}
	

	/**
	 * 跳转到 出入库处理页面
	 * @return
	 */
	public String toInsertOutInColl(){
		return "out_in_mortgageReserve";
	}
	
	

	/**
	 * 跳转到 库存变更明细页面
	 * @return
	 */
	public String toDetailColl(){
		 mortgageReserveListLog=mortgageReserveService.queryDetailColl(mortgageReserveRes);
	     this.setMortgageReserveListLog(mortgageReserveListLog);
		return "mortgage_detail_List";
	}
	
	
	
	
	

	/**
	 * 跳转到 添加押品页面
	 * @return
	 */
	public String toAddColl(){
		String mortgageType=mortgageReserveRes.getMortgageType();
		String id=mortgageReserveRes.getWarrantsId();
		mortgageReserve=mortgageReserveService.queryMortgageReserveListInfo(id,mortgageType);
		this.setMortgageReserve(mortgageReserve);
		return "add_collateral_info";
	}
	

	/**
	 * 跳转到 库存详情页面
	 * @return
	 */
	public String toViewInfos(){
		String id=mortgageReserveRes.getWarrantsId();
		String mortgageType=mortgageReserveRes.getMortgageType();
		mortgageReserveRes.setWarrantsId(id);
		mortgageReserve=mortgageReserveService.queryMortgageReserveListInfo(id,mortgageType);
		mortgageReserveList=mortgageReserveService.queryOutInList(mortgageReserveRes);
		if("1".equals(mortgageType)){
			mortgageReserveListHouseInfo=mortgageReserveService.queryMortgageReserveListHouseInfo(id);
			this.setMortgageReserveListHouseInfo(mortgageReserveListHouseInfo);
		}else if ("2".equals(mortgageType)){
			mortgageReserveListCarInfo=mortgageReserveService.queryMortgageReserveListCarInfo(id);
			this.setMortgageReserveListCarInfo(mortgageReserveListCarInfo);
		}
		this.setMortgageReserve(mortgageReserve);
		this.setMortgageReserveList(mortgageReserveList);
		return "view_collateral_info";
	}
	

	/**
	 * 跳转到 库存变更页面
	 * @return
	 */
	public String toUpdColl(){
		String id=mortgageReserveRes.getWarrantsId();
		String mortgageType=mortgageReserveRes.getMortgageType();
		mortgageReserve=mortgageReserveService.queryMortgageReserveListInfo(id,mortgageType);
		if("1".equals(mortgageType)){
			mortgageReserveListHouseInfo=mortgageReserveService.queryMortgageReserveListHouseInfo(id);
			this.setMortgageReserveListHouseInfo(mortgageReserveListHouseInfo);
		}else if ("2".equals(mortgageType)){
			mortgageReserveListCarInfo=mortgageReserveService.queryMortgageReserveListCarInfo(id);
			this.setMortgageReserveListCarInfo(mortgageReserveListCarInfo);
		}
		this.setMortgageReserve(mortgageReserve);
		return "upd_collateral_info";
	}
	
	/**
	 * 修改库存
	 * @throws Exception
	 */
	public void updColl() throws Exception{
		String info ="fails";
	       boolean reslut=false;
			try {
				MUOUserSession muo=getCurrentOnlineUser();
				reslut=mortgageReserveService.updCollAll(mortgageReserve, mortgageReserveHouse, mortgageReserveCar, files, filesFileName, muo);
				if(reslut){
					info="success";	
				}
				
			} catch (Exception e) {
				info="fails";
				log.error("[失败！]", e);
				throw e;
			}finally{	
				Struts2Utils.renderText(info);
			}
    
	}
	
	/**
	 * 新增入库
	 * @throws Exception
	 */
	public void addItem() throws Exception{
       String info ="fails";
       boolean reslut=false;
		try {
			MUOUserSession muo=getCurrentOnlineUser();
			reslut=mortgageReserveService.insertItemALL(mortgageReserve, mortgageReserveHouse, mortgageReserveCar, files, filesFileName, muo);
			
			if(reslut){
				info="success";	
			}
			
		} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 添加押品信息
	 * @throws Exception
	 */
	public void addCollateral() throws Exception{
	       String info ="success";
	       boolean reslut=false;
			try {
				String mortgageType= mortgageReserveRes.getMortgageType();
				String warrantsId= mortgageReserveRes.getWarrantsId();
				Long pkey=Long.valueOf(warrantsId);
				MUOUserSession muo=getCurrentOnlineUser();
				if("1".equals(mortgageType)){
					reslut=mortgageReserveService.insertCollateralHouse(pkey,mortgageReserveHouse, muo);
				}else if ("2".equals(mortgageType)){
					reslut=mortgageReserveService.insertCollateralCar( pkey,mortgageReserveCar,muo);
				}
				if(reslut){
					info="success";	
				}
				
			} catch (Exception e) {
				info="fails";
				log.error("[失败！]", e);
				throw e;
			}finally{	
				Struts2Utils.renderText(info);
			}
		
	}
	
	/**
	 * 检验 他项权证号是否已存在
	 */
	public void checkOtherWarrantsNumber() throws Exception{
		String 	info ="fails";
    	try {
		String result = this.mortgageReserveService.checkOtherWarrantsNumber(mortgageReserve);
		if("fails".equals(result)){
			info ="fails";
		}else if("0".equals(result)) {
			info = "noExist";
		}else if("othfails".equals(result)){
			info = "othexist";
		}else if("profails".equals(result)){
			info = "proexist";
		}else if("twofails".equals(result)){
			info = "twoexist";
		}else{
			info ="fails";
		}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{

			Struts2Utils.renderText(info);
		}
    	
		
	}
	
	/**
	 * 检验机动车登记证号是否已存在
	 */
	public void checkCarRegisterNo() throws Exception{
		String 	info ="fails";
    	try {
		String result = this.mortgageReserveService.checkCarRegisterNo(mortgageReserveCar);
		if("fails".equals(result)){
			info ="fails";
		}else if("0".equals(result)) {
			info = "noExist";
		}else if("carfails".equals(result)){
			info = "carfails";
		}else{
			info ="fails";
		}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{

			Struts2Utils.renderText(info);
		}
    	
		
	}
	
	
	
	
	
	
	/**
	 * 检验出入库是否已经归还
	 */
	public void checkIsLog() throws Exception{
		String 	info ="fails";
    	try {
		String result = this.mortgageReserveService.checkIsLog(mortgageReserveOut);
		if("fails".equals(result)){
			info ="fails";
		}else if("0".equals(result)) {
			info = "yesexist";
		}else if("1".equals(result)){
			info = "noexist";
		}else if("9".equals(result)){
			info = "yesexist";
		}else{
			info ="fails";
		}
    	} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{
             
			Struts2Utils.renderText(info);
		}
    	
		
	}
	
	
	

	/**
	 * 查看是否可以入库注销
	 */
	public void checkIsBack() throws Exception{
		String 	info ="0";
    	try {
    		info = this.mortgageReserveService.checkIsBack(mortgageReserveOut);
    	} catch (Exception e) {
			info="0";
			log.error("[失败！]", e);
			throw e;
		}finally{
             
			Struts2Utils.renderText(info);
		}
    	
		
	}
	
	
	
	
	
	
	
	
	
	public String queryOrgs(){
		if (mortgageReserve.getOrgName()!=null&!"".equals(mortgageReserve.getOrgName())) {
			mortgageReserveListInfo=mortgageReserveService.queryOrgs(mortgageReserve);
		}
		
		return "orgsList";
	}
	
	/**
	 * 关联系统库存序号是否已存在
	 */
	public void openGenerate() throws Exception{
		//String 	info ="fails";
		String res = "{\"errcode\":\"0001\",\"errmsg\":\"系统查无此记录!\"}";
		try {
			mortgageReserve=mortgageReserveService.openGenerate(mortgageReserve);
			if(mortgageReserve!=null){
				JSONObject jsonObject = JSONObject.fromObject(mortgageReserve);
				res=jsonObject.toString();
			}
		} catch (Exception e) {
			res = "{\"errcode\":\"0001\",\"errmsg\":\"系统查无此记录!\"}";
			e.printStackTrace();
		}
		Struts2Utils.renderText(res);
		
	}

	/**
	 * 出入库处理
	 * @throws Exception
	 */
	public void outInCollateral() throws Exception{
       String info ="fails";
       boolean reslut=false;
		try {

			MUOUserSession muo=getCurrentOnlineUser();
			reslut=mortgageReserveService.insertMortgageReserveOut(mortgageReserveOut, muo);
			if(reslut){
				info="success";	
			}
			
		} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	
	/**
	 * 出入库处理
	 * @throws Exception
	 */
	public void outInCollateralBack() throws Exception{
       String info ="fails";
       boolean reslut=false;
		try {

			MUOUserSession muo=getCurrentOnlineUser();
			reslut=mortgageReserveService.insertMortgageReserveOutBack(mortgageReserveOut, muo);
			if(reslut){
				info="success";	
			}
			
		} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}
	

	 /**
    * 异步加载文件
    * @return
    */
   public String queryFileList() throws Exception{
   	try {
   		if(resourceId!=null&&!"".equals(resourceId))
   		fileResourceTables=	mortgageReserveService.queryFileByIdandType(Long.valueOf(resourceId));
		} catch (Exception e) {
			log.error("查询文件列表失败！！", e);
			e.printStackTrace();
		}
		return "list1";
   }
   /**
	 * 下载文件
	 */
	public void downLoadFile()throws Exception{
		HttpServletResponse response=getResponse();
		if(fileId==null||"".equals(fileId.trim())){
			throw new Exception("要下载是文件编号为空！");
		}
		BufferedInputStream instream = null;
		ServletOutputStream out = response.getOutputStream();
		try{
		
			WarrantsFile tfile=mortgageReserveService.getFileResource(fileId);
			if(tfile!=null){
			String filePath=tfile.getFilePath();
			if(filePath==null || "".equals(filePath)){
				return;
			}
			log.debug("下载渲染结果路径:"+filePath);
			File file = new File(filePath);
			// 清空response
			response.reset();
			//设置下载文件的类型为任意类型
			response.setContentType("application/x-download");
			response.setContentType("octets/stream");  
			response.addHeader("Content-Type", "text/html; charset=utf-8");  
			  String downLoadName = new String(tfile.getFileName().getBytes("gbk"), "iso8859-1"); 
//			response.setContentType("application/zip");
			//添加下载文件的头信息。此信息在下载时会在下载面板上显示，比如：迅雷下载显示的文件名称，就是此处filiname
			response.addHeader("Content-Disposition","attachment;filename="+downLoadName); 
			//添加文件的大小信息
			response.addHeader("Content-Length", "" + file.length()); // 设置返回的文件类型 
			instream = new BufferedInputStream(new FileInputStream(file));
			byte[] b = new byte[1];
			int count;
			while((count = instream.read(b))!=-1){
				out.write(b, 0, count);
			}
			out.flush();
			}
			
		}catch (Exception e) {
			log.error("下载文件异常", e);
			e.printStackTrace();
		}finally{
			if(instream!=null){
				instream.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}
	
	/**
	 * 显示出入库处理信息
	 */
	public void showBorrowerNums() throws Exception{
		String res = "{\"errcode\":\"0001\",\"errmsg\":\"系统操作!\"}";
		try {
			mortgageReserveOut=mortgageReserveService.showBorrowerNums(mortgageReserveOut);
			if(mortgageReserve!=null){
				JSONObject jsonObject = JSONObject.fromObject(mortgageReserveOut);
				res=jsonObject.toString();
			}
		} catch (Exception e) {
			res = "{\"errcode\":\"0001\",\"errmsg\":\"系统查无此记录!\"}";
			e.printStackTrace();
		}
		Struts2Utils.renderText(res);
		
	}
	
	/**
	 * 显示系统状态信息
	 */
	public void showStatus() throws Exception{
		String res = "{\"errcode\":\"0001\",\"errmsg\":\"系统操作!\"}";
		try {
			mortgageReserveRes=mortgageReserveService.showStatus(mortgageReserveOut);
			if(mortgageReserveRes!=null){
				JSONObject jsonObject = JSONObject.fromObject(mortgageReserveRes);
				res=jsonObject.toString();
			}
		} catch (Exception e) {
			res = "{\"errcode\":\"0001\",\"errmsg\":\"系统查无此记录!\"}";
			e.printStackTrace();
		}
		Struts2Utils.renderText(res);
		
	}
	
}
