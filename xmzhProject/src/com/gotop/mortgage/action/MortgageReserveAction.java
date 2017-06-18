package com.gotop.mortgage.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import com.fr.base.core.json.JSONArray;
import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
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
	
	private Map<String, String> tempMortgage;
	  
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
	public Map<String, String> getTempMortgage() {
		return tempMortgage;
	}
	public void setTempMortgage(Map<String, String> tempMortgage) {
		this.tempMortgage = tempMortgage;
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
	 * 查询库存信息
	 * @return
	 */
	public String queryMortgageReserveListExcel(){
		System.out.println("11111");
		mortgageReserveList=mortgageReserveService.queryMortgageReserveListExcel(mortgageReserve, mortgageReserveHouse, mortgageReserveCar);
		this.setMortgageReserveList(mortgageReserveList);
		return "mortgageReserveListExcel";
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
	    mortgageReserveList=mortgageReserveService.queryMortgageReserveAllList(mortgageReserveRes,this.getPage());
		this.setPage(page);
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
	 * 跳转到 添加押品页面
	 * @return
	 */
	public String toAddColl(){
		String res="add_collateral_house_info";
		String mortgageType=mortgageReserveRes.getMortgageType();
		if("1".equals(mortgageType)){
			res="add_collateral_house_info";
		}else if("2".equals(mortgageType)){
			res="add_collateral_car_info";
		}
		return res;
	}
	

	/**
	 * 跳转到 库存详情页面
	 * @return
	 */
	public String toViewInfos(){
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
		return "view_collateral_info";
	}
	

	/**
	 * 跳转到 库存变更页面
	 * @return
	 */
	public String toUpdColl(){
		String res="upd_collateral_house_info";
		String id=mortgageReserveRes.getWarrantsId();
		String mortgageType=mortgageReserveRes.getMortgageType();
		mortgageReserve=mortgageReserveService.queryMortgageReserveListInfo(id,mortgageType);
		if("1".equals(mortgageType)){
			mortgageReserveListHouseInfo=mortgageReserveService.queryMortgageReserveListHouseInfo(id);
			this.setMortgageReserveListHouseInfo(mortgageReserveListHouseInfo);
			res="upd_collateral_house_info";
		}else if ("2".equals(mortgageType)){
			mortgageReserveListCarInfo=mortgageReserveService.queryMortgageReserveListCarInfo(id);
			this.setMortgageReserveListCarInfo(mortgageReserveListCarInfo);
			res="upd_collateral_car_info";
		}
		this.setMortgageReserve(mortgageReserve);
		return res;
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
	 * 关联系统库存序号是否已存在
	 */
	public void openGenerate() throws Exception{
		//String 	info ="fails";
		String res = "{\"errcode\":\"0001\",\"errmsg\":\"系统查无此记录!\"}";
		try {
			String  noticeRegisterRelation=mortgageReserve.getNoticeRegisterRelation();
			mortgageReserve=mortgageReserveService.queryMortgageReserveListInfo(noticeRegisterRelation);
			JSONObject jsonObject = JSONObject.fromObject(mortgageReserve);
			res=jsonObject.toString();
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
	
}
