package controllers;

import models.multidb01.User;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
    	
    	
    	//测试多数据源下 Ebean支持
    	User user = new User();
    	user.name ="sean";
    	user.save("multidb01");
    	
    	User.finder.all();
    	
        return ok("Your new application is ready."+User.finder.all());
    }
  
}
