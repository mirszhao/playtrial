/**
 * 
 */
package models.multidb01;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

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
	
	
}
