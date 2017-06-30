package user;

import com.jfinal.core.Controller;
import common.model.Book;
import common.model.Typee;

import java.util.ArrayList;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class UserController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "用户中心");
        setAttr("user", getSession().getAttribute("userInfo"));
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
}
