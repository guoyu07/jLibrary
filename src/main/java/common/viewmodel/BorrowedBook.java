package common.viewmodel;

/**
 * Created by wgz61 on 2017/6/29.
 */
public class BorrowedBook {
    private int id;
    private String name;
    private String author;
    private String press;
    private String supplier;
    private String date;
    private String ddl;

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

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    public BorrowedBook(int id, String name, String author, String press, String supplier, String date, String ddl) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.press = press;
        this.supplier = supplier;
        this.date = date;
        this.ddl = ddl;
    }
}
