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
1.  Follow the previous three steps from using IDEA above.
2.  Add another parameter, 5, to JFinal.start method.
    <code>JFinal.start("src/main/webapp", 80, "/",5);</code>
3.  Run or debug this class.
4.  Checkout in your browser! (localhost:port)

If you want to use Tomcat instead of Jetty bundled with JFinal, you might remove the jetty-server dependency before putting the war package into Tomcat.

## JFinal Web Framework

- www.JFinal.com
