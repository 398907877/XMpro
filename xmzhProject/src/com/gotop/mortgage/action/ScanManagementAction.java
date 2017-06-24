package com.gotop.mortgage.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.Scan;
import com.gotop.mortgage.service.IScanService;
import com.gotop.util.ZipFileUtil;
import com.gotop.util.file.FileUtil;
import com.gotop.util.security.ForUtil;
import com.gotop.vo.system.MUOUserSession;

public class ScanManagementAction extends BaseAction {
	private static final long serialVersionUID = 7883554154104063359L;
	protected static Logger log = Logger.getLogger(ScanManagementAction.class);
	private IScanService scanService;
	private Scan scan;
	private List<Scan> scanList =new ArrayList<Scan>();
	private List<File> upload;
	private List<String> uploadFileName;
	private List<String> uploadContentType;
	
	private String ids;
	
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public IScanService getScanService() {
		return scanService;
	}
	public void setScanService(IScanService scanService) {
		this.scanService = scanService;
	}
	public Scan getScan() {
		return scan;
	}
	public void setScan(Scan scan) {
		this.scan = scan;
	}
	
	public List<Scan> getScanList() {
		return scanList;
	}
	public void setScanList(List<Scan> scanList) {
		this.scanList = scanList;
	}
	
	/**
	 * 跳转到 扫描件上传页面
	 * @return
	 */
	public String toAddScanImport(){
		return "add_scanImport";
	}
	
	/**
	 * 新增扫描件
	 * @return
	 * @throws Exception
	 */
	public String addScan()throws Exception{		

		MUOUserSession muo=getCurrentOnlineUser();
		Long userID=muo.getEmpid();
		//当前时间
		Date d=new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
		String inserttime = sdf2.format(d);
		
		boolean result=false;
		StringBuffer buffer = new StringBuffer(100);
		try{
			//String warrantsID= scan.getWarrantsID();
			//Long pkey=Long.valueOf(warrantsID);			
			buffer.append("<script>");		
			//限制上次个数
			if(upload.size()>10){
				buffer.append("alert('扫描件上传失败，一次上传个数不能超过10个!');");
			}else{
			String sucess="";
			String fail="";
			
			String fileNames="";
			//循环上传文件
			for(int i=0;i<upload.size();i++){
			this.uploadFileToServer(uploadFileName.get(i),upload.get(i));//上传文件到upload文件夹
			//this.getScan().setOperationTime(inserttime);
			int count = this.getScanService().insertScan(this.getScan(),muo);
			
			
			//插入成功
			if(count > 0){
				sucess+=uploadFileName.get(i)+" ";			
				fileNames+=uploadFileName.get(i)+" ";
			}else{
				fail+=uploadFileName.get(i)+" ";
				break;
			}			
		}	
			if(fail==""){
				buffer.append("alert('扫描件上传成功!');");			
				//上传时间
				//scan.setOperationTime(inserttime);
				
//				if(scan.getOperationTime() ==null || "".equals(scan.getOperationTime())){
//					scan.setOperationTime(inserttime);
//				}
//					String operatingType="6";//扫描件上传
//					//插入日志
//					result=this.getScanService().insertMortgageOperatingLog(operatingType, userID, inserttime, fileNames);
			}else{
				buffer.append("扫描件[ "+fail+" ]上传失败);");
				
			}
			}
			buffer.append("window.parent.close();");
		}catch (Exception e) {
			buffer.append("alert('扫描件上传失败!');");
			log.error("[扫描件上传失败！]"+e.getMessage());
			throw e;
		}finally{
			buffer.append("</script>");
			this.write(buffer.toString());
		}
		return null;
	}
	
	/**
	 * 扫描件统计
	 * @return
	 */
	public String queryScanList(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		scanList=scanService.queryScanList(muo,scan,this.getPage());
		this.setPage(page);
		this.setScanList(scanList);
		return  "queryScanList";
	}
	/**
	 * 上传文件到服务器
	 * @param types 类型：用来判断给什么类型赋值
	 * @throws Exception
	 */
	private void uploadFileToServer(String uploadFileName,File upload2) throws Exception{
		if(this.upload.size()>0){
			String fileName = uploadFileName;
			String path = ServletActionContext.getServletContext().getRealPath("/mortgageUpload");
			UUID uuid = UUID.randomUUID();
			long time = System.currentTimeMillis();
			
			//获取当前时间，以便于建立当天的文件夹
			String nowTime="";
			Date date=new Date();  
		    SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");  
		    nowTime=formatter.format(date); 
			
			//存放的目录
			String url = path +"/"+nowTime+ "/"+uuid+"-"+time+"-"+fileName;
            String fileReName=uuid+"-"+time+"-"+fileName;
				this.getScan().setFileName(fileName);
				this.getScan().setFilePath(url);
				this.getScan().setFileReName(fileReName);
			
			
			File uploadFile=new File(url);
			//判断目录是否存在，不存在则创建
			if(!uploadFile.getParentFile().exists()){
				uploadFile.getParentFile().mkdirs();
			}
			FileUtil fileUtil = new FileUtil();
			fileUtil.fileUpload(ForUtil.createFileInputStream((File)upload2), url);
		}
	}
	//单个下载和多个下载
	 public String download() throws Exception {
		 
	    		String[] valueArra = ids.split(",");
	    		if(valueArra.length==1){
	    			if(scan == null){
						scan = new Scan();
					}
					scan.setScanID(valueArra[0]);
					scan=this.scanService.queryScan(scan);
					//单个下载
					this.downloadFile(scan.getFilePath(), scan.getFileName());
	    		}else if(valueArra.length>1){
	    			//多个打包下载
	    			this.downloadMultiFile();
	    		}
			 return "download";
    }
	
	private InputStream global_inputStream;
	private String global_filename;

	public InputStream getTest() {
		return global_inputStream;
	}
	
	public String getGlobal_filename() {
		return global_filename;
	}

	public void setGlobal_filename(String global_filename) {
		this.global_filename = global_filename;
	}
	    /**
	     * 单个文件下载
	     * @return
	     * @throws Exception
	     */
	    public String downloadFile(String fileurl ,String downloadFileName) throws Exception {
	          // 如果下载文件名为中文，进行字符编码转换
	       String aaa="";
	          aaa=fileurl.replace('\\', '/');
	          InputStream inputStream = new FileInputStream(aaa);
	          global_inputStream=inputStream;
	          global_filename=URLEncoder.encode(downloadFileName, "UTF-8");
	          global_filename = global_filename.replaceAll("\\+", "%20").replaceAll("%28", "\\(").replaceAll("%29", "\\)").replaceAll("%3B", ";").replaceAll("%40", "@").replaceAll("%23", "\\#").replaceAll("%26", "\\&");
	         
	          return "download";
	     }
	    /**
	     * 下载多个附件
	     * 实现：将多个附近压缩成zip包,然后再下载zip包
	     */
	    public String downloadMultiFile() throws Exception {
	        //使用当前时间生成文件名称
	        String formatDate =new  SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	        //压缩后的zip文件存放路径
	        global_filename = formatDate + ".zip";
	        
//	        File downFile2=new File(global_filename);
//	      //判断目录是否存在，不存在则创建
//			if(!downFile2.getParentFile().exists()){
//				downFile2.getParentFile().mkdirs();
//			}
	      
	          
	        String[] valueArra = ids.split(",");
	        File[] files = new File[valueArra.length];
	       List<Scan> scanList2 =new ArrayList<Scan>();
			for(int i=0; i<valueArra.length; i++){
				if(scan == null){
					scan = new Scan();
				}
				scan.setScanID(valueArra[i]);
				scan=this.scanService.queryScan(scan);
				  String aaa="";
		          aaa=scan.getFilePath().replace('\\', '/');
		          if(aaa != null) {
                      File file = new File(aaa.trim());
                      if(file.exists()) {
                          files[i] = file;
                         scanList2.add(scan);
                      }
                  }
			}
			
			//将多个附件压缩成zip
            ZipFileUtil.compressFiles2Zip(files,global_filename,scanList2);
            InputStream inputStream;
			inputStream = new FileInputStream(global_filename);
			global_inputStream=inputStream;
	        return "download";
	    }

}
