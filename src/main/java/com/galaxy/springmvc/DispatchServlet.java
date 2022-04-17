package com.galaxy.springmvc;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 19:37
 */
public class DispatchServlet {
    public static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatchServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch(){
        SimpleController controller = new SimpleController();
        HandlerAdapter adapter = getHandler(controller);
        adapter.handle(controller);
    }

    public HandlerAdapter getHandler(Controller controller){
        for (HandlerAdapter adapter : this.handlerAdapters) {
            if (adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatchServlet().doDispatch();
    }
}
