package self.sunng.jfinal.shiro.c;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController extends Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@ActionKey("/user/login")
	public void login() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println("sessionid" + subject.getSession().getId());
		UsernamePasswordToken token = new UsernamePasswordToken("user", "user");
		subject.login(token);
		renderText("user login");
	}

	@RequiresRoles("user")
	@RequiresPermissions("user-test")
	@ActionKey("/user/test")
	public void test() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println("sessionid" + subject.getSession().getId());
		renderText("user test");
	}
}
