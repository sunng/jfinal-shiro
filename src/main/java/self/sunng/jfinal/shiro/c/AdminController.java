package self.sunng.jfinal.shiro.c;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdminController extends Controller {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@ActionKey("/admin/login")
	public void login() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println("sessionid" + subject.getSession().getId());
		UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
		subject.login(token);

		renderText("admin login");
	}

	@RequiresAuthentication
	@ActionKey("/admin/test")
	public void test() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println("sessionid" + subject.getSession().getId());
		renderText("admin test");
	}
}
