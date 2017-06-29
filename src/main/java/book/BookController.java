package book;

import com.jfinal.core.Controller;
import common.modal.Book;
import common.modal.Locale;
import common.modal.Supplier;
import common.modal.Typee;
import common.viewmodel.BookInfo;

import java.util.ArrayList;

/**
 * Created by wgz61 on 2017/6/29.
 */
public class BookController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "404");
        render("/common/404.html");
    }

    public void info() {
        int bookID = Integer.parseInt(getPara(0));
        Book b = Book.dao.findById(bookID);
        Typee t = Typee.dao.findById(b.getInt("bType"));
        Locale l = Locale.dao.findById(b.getInt("bLocale"));
        Supplier s = Supplier.dao.findById(b.getInt("bSupplier"));
        BookInfo bi = new BookInfo(
                bookID,
                t.getStr("tName"),
                t.getStr("tAuthor"),
                t.getStr("tPress"),
                t.getStr("isbn"),
                l.getStr("lName"),
                s.getStr("sName"),
                b.getDate("bDate").toString()
        );
        setAttr("bookInfo", bi);
        render("/book/book.html");
    }
}
