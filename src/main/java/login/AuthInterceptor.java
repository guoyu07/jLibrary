package login;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

import javax.servlet.http.HttpSession;

/**
 * Created by wgz61 on 2017/6/30.
 */
public class AuthInterceptor implements Interceptor {
    public void intercept(Invocation invocation) {
        HttpSession session = invocation.getController().getSession();
        if(session == null){
            invocation.getController().redirect("/");
        }
        else{
            String nickname = (String) session.getAttribute("isloginned");
            if(nickname != null) {
                invocation.invoke();
            }
            else {
                invocation.getController().redirect("/");
            }
        }
    }
}
