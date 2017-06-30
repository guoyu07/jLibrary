package book;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import common.model.Book;
import common.model.Locale;
import common.model.Supplier;
import common.model.Typee;
import common.viewmodel.BookInfo;
import common.viewmodel.TypeInfo;
import login.AuthInterceptor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wgz61 on 2017/6/29.
 */
@Before(AuthInterceptor.class)
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
            String keyword = getPara("keyword");

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
            } else {
                if(queryType.equals("id") || queryType.equals("name") || queryType.equals("author")) {
                    if(queryType.equals("name")) {
                        queryType = "tName";
                    }
                    if(queryType.equals("author")) {
                        queryType = "tAuthor";
                    }
                    List<Typee> typees = Typee.dao.find("SELECT * FROM typee WHERE " + queryType + " LIKE ?", "%" + keyword + "%");
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
                if(queryType.equals("locale") || queryType.equals("supplier")) {
                    List<Record> records = null;
                    if(queryType.equals("locale")) {
                        queryType = "bLocale";
                        records = Db.find("SELECT blsu.bookID, blsu.bType, blsu.bDate, blsu.lName, blsu.sName, typee.tName FROM\n" +
                                "(\n" +
                                "\t(SELECT bl.id AS bookID, bl.bType, bl.bDate, bl.lName, supplier.sName FROM\n" +
                                "\t\n" +
                                "\t\t(\n" +
                                "\t\t\tSELECT book.id, book.bType, book.bSupplier, book.bDate, locale.lName FROM\n" +
                                "\t\t\t(\n" +
                                "\t\t\t\t\n" +
                                "\t\t\t\tbook INNER JOIN locale ON  locale.id = book.bLocale \n" +
                                "\t\t\t) WHERE locale.id = " + keyword + "\n" +
                                "\t\t) AS bl\n" +
                                "\t\tINNER JOIN supplier ON bl.bSupplier = supplier.id\n" +
                                "\t) AS blsu\n" +
                                "    INNER JOIN typee ON typee.id = blsu.bType\n" +
                                ")");
                    }
                    if(queryType.equals("supplier")) {
                        queryType = "sName";
                        records = Db.find("SELECT blsu.bookID, blsu.bType, blsu.bDate, blsu.lName, blsu.sName, typee.tName FROM\n" +
                                "(\n" +
                                "\t(SELECT bl.id AS bookID, bl.bType, bl.bDate, bl.lName, supplier.sName FROM\n" +
                                "\t\n" +
                                "\t\t(\n" +
                                "\t\t\tSELECT book.id, book.bType, book.bSupplier, book.bDate, locale.lName FROM\n" +
                                "\t\t\t(\n" +
                                "\t\t\t\tbook INNER JOIN locale ON book.bLocale = locale.id\n" +
                                "\t\t\t)\n" +
                                "\t\t) AS bl\n" +
                                "\t\tINNER JOIN supplier ON bl.bSupplier = supplier.id WHERE bl.bSupplier = " + keyword + "\n" +
                                "\t) AS blsu\n" +
                                "    INNER JOIN typee ON typee.id = blsu.bType\n" +
                                ")");
                    }
                    setAttr("sta", "success");
                    setAttr("res", records);
                }
            }
        } catch (Exception e) {
            setAttr("sta", "fail");
        }
        renderJson();
    }
}
