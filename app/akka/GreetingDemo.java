/**
 * 
 */
package akka;

import java.io.Serializable;

/**
 * @author guangpeng.zhao
 * akka 多任务 测试 
 */
public class GreetingDemo implements Serializable {
	public final String who;
	public GreetingDemo(String who){
		this.who = who;
	}
}
