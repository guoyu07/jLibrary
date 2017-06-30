package user;

import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import com.jfinal.plugin.activerecord.Record;
import common.model.Book;
import common.model.Circulation;
import common.model.Typee;
import common.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class UserController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "用户中心");
        User user = (User)getSession().getAttribute("userInfo");
        setAttr("user", user);
        List<Record> records = Db.find("SELECT bt.bID, bt.tName, cir.cDate, cir.cDdl, cir.cState FROM (\n" +
                "\tSELECT * FROM circulation WHERE circulation.cUser = " + user.getInt("id") + "\n" +
                ")AS cir\n" +
                "INNER JOIN (\n" +
                "SELECT book.id AS bID, typee.tName FROM book\n" +
                "INNER JOIN typee\n" +
                "ON book.bType = typee.id) AS bt \n" +
                "ON cir.cBook = bt.bID");
        setAttr("myCirs", records);
        render("/center/user/user.html");
    }

    public void check() {
        try {
            int bookID = Integer.parseInt(getPara("bookID"));
            Book book = Book.dao.findById(bookID);
            Typee typee = Typee.dao.findById(book.getInt("bType"));
            setAttr("bookName", typee.getStr("tName"));
        } catch (Exception e) {
            setAttr("bookName", "找不到该书！");
        }
        renderJson();
    }

    public void update() {
        final User user = (User)getSession().getAttribute("userInfo");
        user.set("uName",getPara("name"));
        user.set("uGender",getPara("gender"));
        user.set("uTel",getPara("tel"));
        boolean succeed = Db.tx(new IAtom() {
            public boolean run() throws SQLException {
                boolean count = user.update();
                return count;
            }
        });

        redirect("/user");
    }

    public void borrow() {
        final User user = (User)getSession().getAttribute("userInfo");
        final int bookID = getParaToInt("bookID");

        List<Circulation> cir = Circulation.dao.find("SELECT * FROM circulation WHERE cBook = " +bookID);
        if(cir != null) {
            for (Circulation c : cir
                 ) {
                if(!c.getStr("cState").equals("done")) {
                    setAttr("msg","此书已被借出!");
                }
            }
        }
        Calendar calendar = Calendar.getInstance();
        Date now = calendar.getTime();
        calendar.add(Calendar.DATE, user.getInt("uCredit"));
        Date ddl = calendar.getTime();
        Circulation circulation = new Circulation().set("cUser", user.getInt("id"))
                .set("cBook", bookID)
                .set("cDate", now)
                .set("cDdl", ddl);
        circulation.save();
        redirect("/user");
    }
}
