/**
 * 
 */
package akka;

import java.util.Date;
import akka.actor.UntypedActor;

/**
 * @author guangpeng.zhao
 *
 */
public class MyActor extends UntypedActor {
	/**
	 *任务接收消息  
	 *@param arg0  任务名称
	 */
	@Override
	public void onReceive(Object arg0) throws Exception {
//		System.out.println("akka recivere---------------------"+arg0+new Date().getSeconds());
		if(arg0 instanceof String){
			
		}
		
	}



}
