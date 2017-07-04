package config;

import book.BookController;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import common.model.*;
import index.HelloController;
import index.IndexController;
import login.LoginController;
import supplier.SupplierController;
import user.AdminController;
import user.UserController;

/**
 * Created by wgz61 on 2017/6/27.
 */
public class JLibraryConfig extends JFinalConfig {

    public void configConstant(Constants constants) {
        PropKit.use("jLibrary.txt");
        constants.setDevMode(PropKit.getBoolean("devMode"));
    }

    public void configRoute(Routes routes) {
        routes.add("/hello", HelloController.class);
        routes.add("/", IndexController.class);
        routes.add("/login", LoginController.class);
        routes.add("/user", UserController.class);
        routes.add("/admin", AdminController.class);
        routes.add("/book", BookController.class);
        routes.add("/supplier", SupplierController.class);
    }

    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        PropKit.use("jLibrary.txt");
        String mysqlHost = PropKit.get("host");
        String mysqlRoot = PropKit.get("root");
        String mysqlPassword = PropKit.get("password");

        DruidPlugin dp = new DruidPlugin(mysqlHost,mysqlRoot,mysqlPassword);
        plugins.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        plugins.add(arp);

        arp.addMapping("admin", Admin.class);
        arp.addMapping("book", Book.class);
        arp.addMapping("circulation", Circulation.class);
        arp.addMapping("locale", Locale.class);
        arp.addMapping("supplier", Supplier.class);
        arp.addMapping("typee", Typee.class);
        arp.addMapping("user", User.class);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
