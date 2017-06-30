package common.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class Locale extends Model<Locale> {
    public static final Locale dao = new Locale().dao();
    public List<Locale> getAllLocale() {
        return find("SELECT * FROM locale");
    }
}
