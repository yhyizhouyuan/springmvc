package com.galaxy.controller;

import com.galaxy.bean.Employee;
import com.galaxy.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 15:52
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping("/")
    public String getEmployeeList(Model model){
        Collection<Employee> employeeDaoAll = employeeDao.getAll();
        model.addAttribute("employeeDaoAll",employeeDaoAll);
        return "list";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "update";
    }
}
