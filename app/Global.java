import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import akka.MyActor;
import akka.actor.Actor;
import akka.actor.ActorContext;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;

import play.Application;
import play.GlobalSettings;
import play.libs.Akka;
import play.mvc.Action;
import play.mvc.Result;
import play.mvc.Http.Context;
import play.mvc.Http.Request;
import play.mvc.Http.RequestBody;
import play.mvc.Http.Session;
import scala.concurrent.duration.Duration;

/**
 * 
 */

/**
 * @author guangpeng.zhao
 *
 */
public class Global extends GlobalSettings {
	
	/* 
	 * 请求过滤器
	 */
	@Override
	public Action onRequest(Request request, Method method) {
		
		System.out.println(request.method());//GET   OR    POST
		
		//is 合法		
		//获取注解值
		
		
		//获取请求URL
		return new Action.Simple() {
			@Override
			public Result call(Context context) throws Throwable {
				Session session = context.session();
				Request request = context.request();

				
				String requestPath = request.path();
				String remoteIp = request.remoteAddress();
				String host = request.host();
				String userId = session.get("userId");
				String roleId = session.get("roleId");
				
				Map<String, String[]> headers = request.headers();
				
				Date curTime = new Date();
				System.out.println(host);
				
				//获取主机IP
				System.out.println("action log:"+request.remoteAddress()+","+requestPath+curTime);
				
				return delegate.call(context);
			}
		};
	}
	/*
	 * 应用启动时执行
	 */
	@Override
	public void onStart(Application arg0) {
		
		ActorRef testActor = Akka.system().actorOf(new Props(MyActor.class));
		
		Akka.system().scheduler().schedule(
		        Duration.create(0, TimeUnit.MILLISECONDS), //Initial delay 0 milliseconds
		        Duration.create(1000, TimeUnit.MILLISECONDS),     //Frequency 30 minutes
		        testActor,
		        "tick",
		        Akka.system().dispatcher()
		);
		
		super.onStart(arg0);
	}
	
	
	
	
	
}
