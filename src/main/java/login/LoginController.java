package login;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import common.model.Admin;
import common.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class LoginController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "登录");
        render("/login/login.html");
    }

    @Before(LoginValidator.class)
    public void login() {
        List<Admin> adminList = Admin.dao.findByNameAndPwd(getPara("username"), getPara("password"));
        List<User> userList = User.dao.findByNameAndPwd(getPara("username"), getPara("password"));
        if (userList.size() > 0) {
            setSessionAttr("userInfo", userList.get(0));
            redirect("/user");
        } else if (adminList.size() > 0) {
            setSessionAttr("adminInfo", adminList.get(0));
            redirect("/admin");
        } else {
            setAttr("msg", "用户名或密码错误！");
            redirect("/login");
        }
    }
}
