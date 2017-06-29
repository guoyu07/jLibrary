package starter;

import com.jfinal.core.JFinal;

/**
 * Created by wgz61 on 2017/6/29.
 */
public class Starter {
    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 8008, "/");
    }
}
