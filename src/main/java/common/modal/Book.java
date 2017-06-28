package common.modal;

import com.jfinal.plugin.activerecord.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class Book extends Model<Book>{
    public static final Book dao = new Book().dao();

    public List<Book> getAllBooks() {
        return find("select * from book");
    }

    public ArrayList<Book> getNewBooks() {
        List<Book> allBooks = getAllBooks();
        ArrayList<Book> newBooks = new ArrayList<Book>();
        for (Book b : allBooks
             ) {
            Date bDate = b.getDate("bDate");
            Calendar toCompare = Calendar.getInstance();
            toCompare.add(Calendar.DATE, -10);
            if(bDate.compareTo(toCompare.getTime()) == 1) {
                newBooks.add(b);
            }
        }
        return newBooks;
    }
}
