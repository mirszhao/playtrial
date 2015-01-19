/**
 * 
 */
package akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * @author guangpeng.zhao
 *
 */
public class HelloWorld extends UntypedActor {

	/* 
	 * create greeter actor
	 */
	@Override
	public void preStart() {
		final ActorRef greeter = getContext().actorOf(new Props(Greeter.class), "greeter");
//		super.preStart();
		greeter.tell(Greeter.Msg.GREET, getSelf());//自己发送给谁消息
	}
	
	/* 
	 * 定时接收方法
	 */
	@Override
	public void onReceive(Object msg) throws Exception {
			if(msg ==Greeter.Msg.DONE){
				System.out.println("已收到消息~ 即将停止Actor~");
				getContext().stop(getSelf());
			}else unhandled(msg);
	}
	

}
