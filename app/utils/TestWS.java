/**
 * 
 */
package utils;

import play.libs.WS;
import play.libs.F.Promise;
import play.libs.WS.Response;
import play.libs.WS.WSRequestHolder;

/**
 * @author guangpeng.zhao
 *
 */
public class TestWS {
	/**
	 * 远程请求
	 */
	public static void  remoteRequest(){
		String url ="http://101.251.213.54:9035/3y/getActivityGifits";
		String method = "GET";
		WSRequestHolder holder = WS.url(url);
		holder.setContentType("application/json");
		holder.setHeader("X-CC", "WWW");
		
		Promise<Response> future = holder.get();
		//获取响应
		Response response = future.get(20000L);
		System.out.println(response.getStatus());
		System.out.println(response.asJson());
	
	}
	
	public static void main(String[] args) {
		remoteRequest();
	}	

}
