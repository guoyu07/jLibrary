package index;

import com.jfinal.core.Controller;

/**
 * Created by wgz61 on 2017/6/27.
 */
public class HelloController extends Controller {
    public void index() {
        renderText("Hello jFinal!");
    }
}
