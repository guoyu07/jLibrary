package index;

import com.jfinal.core.Controller;
import common.model.Book;
import common.model.Locale;
import common.model.Typee;
import common.viewmodel.NewBook;

import java.util.ArrayList;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class IndexController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", preList);

        ArrayList<Book> books = Book.dao.getNewBooks();
        ArrayList<NewBook> newBooks = new ArrayList<NewBook>();
        for (Book b : books
             ) {
            Typee t = Typee.dao.findById(b.getInt("bType"));
            Locale l = Locale.dao.findById(b.getInt("bLocale"));
            NewBook nb = new NewBook(b.getInt("id"),t.getStr("tName"),t.getStr("tAuthor"),l.getStr("lName"));
            newBooks.add(nb);
        }
        setAttr("newBooks", newBooks);

        render("/index/index.html");
    }
}
