package common.modal;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class Admin extends Model<Admin> {
    public static final Admin dao = new Admin().dao();
    public List<Admin> findByNameAndPwd(String name, String password) {
        return find("select * from admin where aUsername='" + name + "' and aPassword='" + password + "'");
    }
}
