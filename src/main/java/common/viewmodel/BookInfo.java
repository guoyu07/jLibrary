package common.viewmodel;

/**
 * Created by wgz61 on 2017/6/29.
 */
public class BookInfo {
    private int id;
    private String name;
    private String author;
    private String press;
    private String isbn;
    private String locale;
    private String supplier;
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BookInfo(int id, String name, String author, String press, String isbn, String locale, String supplier, String date) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.press = press;
        this.isbn = isbn;
        this.locale = locale;
        this.supplier = supplier;
        this.date = date;
    }
}
