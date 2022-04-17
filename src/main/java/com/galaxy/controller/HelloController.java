package com.galaxy.controller;

import com.galaxy.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 10:54
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/target")
    public String hello(){
        return "target";
    }

    @RequestMapping(value = {"/defaultCharset","/test"},params = {"username","password"})
    public String testRequestMapping(){
        return "success";
    }

    @RequestMapping("/testRest/{id}/{username}")
    public String testRest(@PathVariable("id")String id,
                           @PathVariable("username")String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/testpojo")
    public String testpojo(User user){
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request){
        request.setAttribute("username","Hance");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("test","testModelAndView,hance");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("test","testModel,hance");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> map){
        map.put("test","testMap，hance");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("test","testModelMap,hance");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("test","testApplication,hance");
        return "success";
    }
    
    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServlet servlet){
        ServletContext servletContext = request.getServletContext();
        servlet.getServletContext();
        return null;
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope","hello,session,hance");
        return "success";
    }
}
