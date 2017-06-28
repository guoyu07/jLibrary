package common.viewmodel;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class NewBook {
    private int id;
    private String name;
    private String author;
    private String locale;

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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public NewBook(int id, String name, String author, String locale) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.locale = locale;
    }
}
