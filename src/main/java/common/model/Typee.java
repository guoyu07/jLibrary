package common.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class Typee extends Model<Typee> {
    public static final Typee dao = new Typee().dao();
    public List<Typee> getAllTypees() {
        return find("SELECT * FROM typee");
    }
}
