package common.modal;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class User extends Model<User> {
    public static final User dao = new User().dao();
    public List<User> findByNameAndPwd(String name, String password){
        return find("select * from user where uUsername='" + name + "' and uPassword='" + password + "'");
    }
}
