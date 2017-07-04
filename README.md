# jLibrary

A library management system developed with jFinal web framework. 一个使用jFinal的web框架的图书馆信息管理系统。

- This is **ONLY** my assignment for J2EE course, **NOT** for pratical usage.
- 这**仅**是我J2EE课的一项作业，**并不**具有实际用途。

## Compile 编译

### Using IntelliJ IDEA

1.  Clone this project. 克隆这个项目。
2.  Update jars in maven pom.xml. 在Maven中更新jar包。
3.  Find the class starter.Starter. 找到starter.Starter类。
4.  Run or debug this class (you can change the port in the JFinal.start method). 运行或调试该类（你可以在JFinal.start方法中更改端口）。
5.  Checkout in your browser! (localhost:port) 在你的浏览器中查看（localhost:port）

### Using Eclipse/MyEclipse

1.  Follow the previous five steps from using IDEA above. 参照之上IDEA中的五步操作。
2.  **Additionally**, you need to add another parameter in step 4 into JFinal.start method. **另外**，你需要在第四步中，向JFinal.start方法增加一个参数。

    <code>JFinal.start("src/main/webapp", 80, "/",5);</code> (int)5 is added as the last parameter. (int)5被添加为最后一个参数。

### Tomcat

If you want to use Tomcat instead of Jetty bundled with JFinal, you might remove the jetty-server dependency before compiling.

如果你想用Tomcat替代jFinal中自带的Jetty服务器，你需要将jetty-server的包依赖去除。

### Database 数据库

As you can see in config.JLibraryConfig, the information of database connection is saved in "jLibrary.txt", you could alter the properties as you like. You can find "recovery.sql" which is used to build new schema into your MySQL database. MariaDB is compatible, and MSSQLServer is not recommended as it hasn't been tested.

在config.JLibraryConfig类中你可以看到，数据库连接的信息是存在"jLibrary.txt"中的，你可以修改成你所需的参数。你可以找到用来创建MySql数据库的"recovery.sql"。MariaDB兼容，微软SQLServer不建议使用，因为并没有测试过。

### Account 账户

There are two types of users designed. One is ordinary user and the other is admin user. For ordinary one, you could sign in this account given in recovery.sql, wung@live.com with password 123456. And for admin, admin@live.com with password 123321.

有设计两种账户。一是普通用户，二是管理员用户。普通用户请用wung@live.com，密码123456的账户登录，管理员用户请用admin@live.com，密码123321的账户登录。

## JFinal Web Framework

- https://github.com/jfinal/jfinal (Simplified Chinese 简体中文)
- www.JFinal.com (Simplified Chinese 简体中文)
