package login;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import common.model.Admin;

import javax.servlet.http.HttpSession;

/**
 * Created by wgz61 on 2017/6/30.
 */
public class AdminAuthInterceptor implements Interceptor {
    public void intercept(Invocation invocation) {
        HttpSession session = invocation.getController().getSession();
        if(session == null){
            invocation.getController().redirect("/");
        }
        else{
            Admin nickname = (Admin) session.getAttribute("adminInfo");
            if(nickname != null) {
                invocation.invoke();
            }
            else {
                invocation.getController().redirect("/");
            }
        }
    }
}
