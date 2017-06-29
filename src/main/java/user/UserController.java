package user;

import com.jfinal.core.Controller;
import common.modal.Book;
import common.modal.Typee;

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
        render("/center/reader/user.html");
    }

    public void check() {
        int bookID = Integer.parseInt(getPara("bookID"));
        Book book = Book.dao.findById(bookID);
        Typee typee = Typee.dao.findById(book.getInt("bType"));
        setAttr("bookName", typee.getStr("tName"));
        renderJson();
    }
}
