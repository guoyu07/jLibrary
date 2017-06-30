package supplier;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.IAtom;
import common.model.Supplier;
import login.AdminAuthInterceptor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wgz61 on 2017/6/30.
 */
@Before(AdminAuthInterceptor.class)
public class SupplierController extends Controller {
    public void index() {
        ArrayList<String> preList = new ArrayList<String>();
        setAttr("preList", null);
        setAttr("now", "供应商管理");
        render("/supplier/supplier.html");
    }

    public void query() {
        String keyword = getPara("keyword");
        if(getPara("isAll").equals("yes")) {
            List<Supplier> toReturn = Supplier.dao.getAllSupplier();
            setAttr("res", toReturn);
            renderJson();
        } else  {
            if(getPara("queryType").equals("id")) {
                List<Supplier> toReturn = new ArrayList<Supplier>();
                toReturn.add(Supplier.dao.findById(keyword));
                setAttr("res", toReturn);
                renderJson();
            } else {
                List<Supplier> toReturn = Supplier.dao.find("SELECT * FROM supplier WHERE sName LIKE ?", "%" + keyword + "%");
                setAttr("res", toReturn);
                renderJson();
            }
        }
    }

    public void remove() {
        final int id = getParaToInt("id");
        boolean succeed = Db.tx(new IAtom() {
            public boolean run() throws SQLException {
                int flag1 = Db.update("DELETE FROM book WHERE bSupplier = " + id);
                boolean flag2 = Db.deleteById("supplier", id);
                setAttr("msg", "删除成功!");
                return flag1 >= 0 && flag2;
            }
        });
        renderJson();
    }
}
