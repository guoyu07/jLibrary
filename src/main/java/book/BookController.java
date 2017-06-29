package book;

import com.jfinal.core.Controller;
import common.modal.Book;
import common.modal.Locale;
import common.modal.Supplier;
import common.modal.Typee;
import common.viewmodel.BookInfo;
import common.viewmodel.TypeInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", "图书查询");
        setAttr("now", "图书详情");
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

    public void search() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "图书查询");
        render("/book/bookSearch.html");
    }

    public void query() {
        List<TypeInfo> toReturn = new ArrayList<TypeInfo>();
        try {
            String isAll = getPara("isAll");
            String queryType = getPara("queryType");
            if(isAll.equals("yes")) {

                List<Typee> typees = Typee.dao.getAllTypees();
                for (Typee t : typees
                     ) {
                    List<Book> books = Book.dao.find("SELECT * FROM book WHERE bType = " + t.getInt("id"));
                    ArrayList<String> l = new ArrayList<String>();
                    ArrayList<String> s = new ArrayList<String>();
                    for (Book b : books
                         ) {
                        List<Locale> locale = Locale.dao.find("SELECT * FROM locale WHERE id = " + b.getInt("bLocale"));
                        List<Supplier> supplier = Supplier.dao.find("SELECT * FROM supplier WHERE id = " + b.getInt("bSupplier"));
                        String loc = locale.get(0).getStr("lName");
                        String sup = supplier.get(0).getStr("sName");
                        l.add(loc);
                        s.add(sup);
                    }
                    HashSet<String> set = new HashSet<String>(l);
                    l = new ArrayList<String>(set);
                    set = new HashSet<String>(s);
                    s = new ArrayList<String>(set);
                    String lString = "";
                    for (String ls : l
                         ) {
                        lString += ls + ",";
                    }
                    String sString = "";
                    for (String ss : s
                            ) {
                        sString += ss + ",";
                    }
                    lString = lString.substring(0, lString.length()-1);
                    sString = sString.substring(0, sString.length()-1);
                    toReturn.add(new TypeInfo(
                            t.getStr("tName"),
                            t.getStr("tAuthor"),
                            t.getStr("tPress"),
                            lString,
                            sString,
                            t.getStr("tISBN")
                            )
                    );
                }
                setAttr("res", toReturn);
                setAttr("sta", "success");
            }
        } catch (Exception e) {
            setAttr("sta", "fail");
        }
        renderJson();
    }
}
