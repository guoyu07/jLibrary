package user;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import login.AdminAuthInterceptor;

import java.util.ArrayList;

/**
 * Created by wgz61 on 2017/6/28.
 */
@Before(AdminAuthInterceptor.class)
public class AdminController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "管理员中心");
        setAttr("admin", getSession().getAttribute("adminInfo"));
        render("/center/admin/admin.html");
    }
}
