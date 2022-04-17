package com.galaxy.springmvc;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 19:29
 */
public interface HandlerAdapter {
    public  boolean supports(Object handler);
    public void handle(Object handler);
}
