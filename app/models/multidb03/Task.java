package models.multidb03;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Ebean 使用多数据库
 * @author guangpeng.zhao
 *
 */
@Entity
@Table(name="task")
public class Task  extends Model{
	
	public static Finder<Integer, Task> finder = new Finder<Integer, Task>(Integer.class, Task.class);
	
	@Id
	public int id;
	public String name;
	
}
