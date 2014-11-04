playtrial
=========

play framework 2.1.5 功能尝试

1.Ebean在多数据源下的实现数据持久化。

2.使用原生JDBC方式去查询数据，比较繁琐，但是在对应一些需求时显得比较灵活

3.尝试使用EbeanServer 接口，执行原生的sql语句(不过有些写法和原生的sql还不一样)，相关代码在User下 
	public static void queryUserEbeanServer()，访问根目录既可以进行测试
	