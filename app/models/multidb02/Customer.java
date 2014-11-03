package models.multidb02;

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
@Table(name="customer")
public class Customer  extends Model{
	
	public static Finder<Integer, Customer> finder = new Finder<Integer, Customer>(Integer.class, Customer.class);
	
	@Id
	public int id;
	public String name;
	
	
}
