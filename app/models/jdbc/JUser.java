/**
 * 
 */
package models.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;

import play.db.DB;

/**
 * 通过JDBC的方式访问数据源  仅用于演示代码
 * @author guangpeng.zhao
 *
 */
public class JUser {
	public int id;
	public String name;
	
	/**
	 * 使用原生JDBC操作数据源
	 */
	public static void testJDBC(){
		Connection connection =null;
		DataSource ds = DB.getDataSource("multidb01");
//		
		
	    try {
			 connection = ds.getConnection();
			
			PreparedStatement pres = connection.prepareStatement("select name from user");
			//执行查询
			ResultSet resSet = pres.executeQuery();
			
			while(resSet.next()){
				System.out.println(resSet.getString(1));//结果集索引 从1开始
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 使用Ebean提供的JDBC接口 实现对底层sql的操作
	 */
	public static void testEbeanJDBC(){
		EbeanServer eServer = Ebean.getServer("multidb01");
		//详细用法参考API
//		http://www.avaje.org/static/javadoc/pub/com/avaje/ebean/EbeanServer.html
		//操作的实体 应该在Ebean中进行注册 http://www.avaje.org/static/javadoc/pub/com/avaje/ebean/Query.html
//		Ebean.createQuery(Order.class, oql);
		
		eServer.beginTransaction();//开启事务
		
		eServer.commitTransaction();
		//finally
		eServer.endTransaction();
		
		
		
	}
}
