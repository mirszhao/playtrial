/**
 * 
 */
package akka;

import akka.actor.UntypedActor;

/**
 * @author guangpeng.zhao
 *
 */
public class Greeter extends UntypedActor {
	
	public static enum Msg{
		GREET,DONE;
	}
	
	

	/*http://verran.iteye.com/blog/1942393
	 * 接收消息方法
	 */
	@Override
	public void onReceive(Object msg) throws Exception {
		if(msg ==Msg.GREET){
			System.out.println("Hello world!");
			//回应收到的消息。 
			getSender().tell(Msg.DONE, getSelf());
		}else unhandled(msg);
		// TODO Auto-generated method stub

	}

}
