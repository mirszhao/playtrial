/**
 * 
 */
package models.multidb01;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

/**
 * Ebean 使用多数据库
 * 多数据源时，Ebean支持的实体 应该在 finder save update delete等操作时指定 对应的数据源名称
 * @author guangpeng.zhao
 *
 */
@Entity
@Table(name="user")
public class User extends Model{
	public static final String DataSourceName ="multidb01";
	
	public static Finder<Integer, User> finder = new Finder<Integer, User>(DataSourceName,Integer.class, User.class);
	
	@Id
	public int id;
	public String name;
	public Date atime;
	
	/**
	 * 保存
	 * @param user
	 */
	public static void save(User user){
		user.save(DataSourceName);
	}
	
	/**
	 * 更新
	 * @param user
	 */
	public static void update(User user){
		user.update(DataSourceName);
	}
	
	/**
	 * 删除
	 * @param user
	 */
	public static void delete(User user){
		user.delete(DataSourceName);
	}
	
	/**
	 * 使用EbeanServer 实现灵活查询
	 */
	public static void queryUserEbeanServer(){
		//1.获取当前Ebean实体的数据源
		EbeanServer curServer = Ebean.getServer(DataSourceName);
		
		curServer.beginTransaction();//开始一个事务  查询一般不基于事务
		//具体用法参考Ebean API
		SqlQuery query = curServer.createSqlQuery("select * from user");
		
		List<SqlRow> list = query.findList();
		
//		for(SqlRow row:list){
//			System.out.println(row.get("name")+"-----------"+row.getString("id"));
//		}
		
		//curServer.delete(User.class, ids); 根据id来删除一些东西
		
		curServer.commitTransaction();//提交一个事务  or rollbackTransaction 回滚当前事务
		
		curServer.endTransaction();//如果已经提交不做任何事情  或者回滚事务
		
		
		
	}
	
	
}
