package controllers;

import models.jdbc.JUser;
import models.multidb01.User;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
    	
    	//JUser.testJDBC();
    	String fff = request().getQueryString("fff");
    	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^fff--->"+fff);
    	
    	//使用EbeanServer
    	User.queryUserEbeanServer();
        return ok("Your new application is ready.");
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
