package login;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class LoginValidator extends Validator {

    protected void validate(Controller controller) {
        validateRequiredString("username", "usrMsg", "账号不能为空!");
        validateRequiredString("password", "pswMsg", "密码不能为空!");
        validateEmail("username","usrMsg", "邮箱格式不正确!");
    }

    protected void handleError(Controller controller) {
        controller.render("/login/login.html");
    }
}
