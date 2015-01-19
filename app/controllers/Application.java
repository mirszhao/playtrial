package controllers;

import java.util.Date;

import models.AuthAccess;
import models.multidb01.User;
import play.mvc.*;

public class Application extends Controller {
	
	
	
	@AuthAccess("index---")
    public static Result index() {
    	
    	//JUser.testJDBC();
    	String fff = request().getQueryString("fff");
    	System.out.println("^^^^^^^^^^---^^^^^^^^^^^^^^^^--->"+fff);
    	User user = new User();
    	
    	user.name ="mmmmm";
    	user.atime = new Date();
    	User.save(user);
    	//使用EbeanServer
    	User.queryUserEbeanServer();
        return ok("Your new application is ready. ");
    }
    
    public static Result ebeanMultidb(){
    	
    	//测试多数据源下 Ebean支持
    	User user = new User();
    	user.name ="sean";
    	user.save("multidb01");
    	User.finder.all();
    	
    	return redirect(routes.Application.index());
    }
  
}
