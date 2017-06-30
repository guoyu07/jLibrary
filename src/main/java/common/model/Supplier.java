package common.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by wgz61 on 2017/6/28.
 */
public class Supplier extends Model<Supplier> {
    public static final Supplier dao = new Supplier().dao();
    public List<Supplier> getAllSupplier() {
        return find("SELECT * FROM supplier");
    }
}
