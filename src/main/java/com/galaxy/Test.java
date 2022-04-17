package com.galaxy;

import com.galaxy.bean.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 15:47
 */
public class Test {
    public static void main(String[] args) {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        employeeMap.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employeeMap.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employeeMap.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employeeMap.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employeeMap.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
        Collection<Employee> values = employeeMap.values();
        System.out.println(values);
    }
}
