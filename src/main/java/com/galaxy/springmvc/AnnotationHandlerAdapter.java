package com.galaxy.springmvc;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 19:36
 */
public class AnnotationHandlerAdapter implements HandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }

    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }
}
