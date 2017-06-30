# jLibrary
A library management system developed with jFinal web framework.

- This is **ONLY** my assignment for J2EE course, not for pratical usage.

## Compile

Using IntelliJ IDEA
1.  Clone this project
2.  Update jars in maven pom.xml.
3.  Find starter.Starter.java.
4.  Run or debug this class (you can change the port in the JFinal.start method).
5.  Checkout in your browser! (localhost:port)

Using Eclipse/MyEclipse
1.  Follow the previous five steps from using IDEA above.
1.  **Additionally**, you need to add another parameter in step 4 into JFinal.start method.
    <code>JFinal.start("src/main/webapp", 80, "/",5);</code> (int)5 is added as the last parameter.

If you want to use Tomcat instead of Jetty bundled with JFinal, you might remove the jetty-server dependency before compiling.

## JFinal Web Framework

- https://github.com/jfinal/jfinal (简体中文) 
- www.JFinal.com (简体中文)
