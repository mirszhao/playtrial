/**
 * 
 */
package controllers;

import java.io.File;
import java.io.OutputStream;

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
	 */
	public static Result downloadFile(){
		
		
		return ok(new File(""));
	}
}
