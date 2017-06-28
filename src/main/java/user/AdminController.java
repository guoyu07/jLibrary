package user;

import com.jfinal.core.Controller;

import java.util.ArrayList;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class AdminController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "管理员中心");
        render("/center/admin/admin.html");
    }
}
