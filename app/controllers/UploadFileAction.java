/**
 * 
 */
package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import play.mvc.Controller;
import play.mvc.Result;

/**
 * 上传文件
 * @author guangpeng.zhao
 *
 */
public class UploadFileAction extends Controller{
	
	/**
	 * 加载上传信息页面
	 * @return
	 */
	public static Result loadUploadPage(){
		return TODO;
	}
	
	/**
	 * 上传文件请求
	 * @return
	 */
	public static Result uploadFile(){
		return TODO;
	}
	
	/**
	 * 下载文件
	 * @return
	 * @throws FileNotFoundException 
	 */
	public static Result downloadFile() throws FileNotFoundException{
//		OutputStream out = null;
//		response().setContentType("text/octet-stream;charset=utf-8");
//		try {
//			out = new FileOutputStream("D://myeclipse//workspaces//ExternalFrameTest//cvsfile//csvTest.csv");
//			
//			response().setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("快牙运营平台测试数据.csv", "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		StringWriter out = new StringWriter();
		
		
		
		
		return ok();
	}
}
