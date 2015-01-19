/**
 * 
 */
package akka;

import scala.Option;
import akka.actor.UntypedActor;

/**
 * @author guangpeng.zhao
 *
 */
public class GreetingActor extends UntypedActor {
	
	
	/* 
	 * 任务开启之前
	 */
	@Override
	public void preRestart(Throwable reason, Option<Object> message) {
//		getContext().actorOf(arg0)
		super.preRestart(reason, message);
	}

	/* 
	 * 
	 */
	@Override
	public void onReceive(Object arg0) throws Exception {
		

	}

}
