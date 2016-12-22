package self.sunng.jfinal.shiro;

import com.jfinal.config.*;
import com.jfinal.ext.plugin.shiro.ShiroInterceptor;
import com.jfinal.ext.plugin.shiro.ShiroPlugin;
import self.sunng.jfinal.shiro.c.AdminController;
import self.sunng.jfinal.shiro.c.UserController;

public class Config extends JFinalConfig {

	Routes routes;

	@Override
	public void beforeJFinalStop() {
		super.beforeJFinalStop();
	}

	public void configConstant(Constants me) {
		me.setDevMode(false);
	}
	
	public void configRoute(Routes me) {
		this.routes = me;
		me.add("/admin", AdminController.class);
		me.add("/user", UserController.class);
	}

	public void configPlugin(Plugins me) {
		//config shiro
		ShiroPlugin shiroPlugin = new ShiroPlugin(this.routes);
		shiroPlugin.setLoginUrl("/login.html");
		shiroPlugin.setSuccessUrl("/success.html");
		shiroPlugin.setUnauthorizedUrl("/unauthorized.html");
		me.add(shiroPlugin);

	}
	
	public void configInterceptor(Interceptors me) {

		me.add(new ShiroInterceptor());
	}
	
	public void configHandler(Handlers me) {
	}
}
