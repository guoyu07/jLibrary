package common.viewmodel;

import java.util.ArrayList;

/**
 * Created by wung on 2017/6/30.
 */
public class TypeInfo {
    private String name;
    private String author;
    private String press;
    private String locale;
    private String supplier;
    private String isbn;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public TypeInfo(String name, String author, String press, String locale, String supplier, String isbn) {
        this.name = name;
        this.author = author;
        this.press = press;
        this.locale = locale;
        this.supplier = supplier;
        this.isbn = isbn;
    }
}
