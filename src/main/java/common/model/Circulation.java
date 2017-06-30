package common.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by wung on 2017/6/30.
 */
public class Circulation extends Model<Circulation> {
    public static final Circulation dao = new Circulation().dao();
    public List<Circulation> getAllCirculations() {
        return find("SELECT * FROM circulation");
    }

    public void borrow(int userid, int bookid) {
        List<Circulation> circulations = Circulation.dao.find("SELECT * FROM circulation WHERE cUser = userid");
    }

    public void returnn(int userid, int bookid) {

    }

}
