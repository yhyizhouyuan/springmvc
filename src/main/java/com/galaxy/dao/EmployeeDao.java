package com.galaxy.dao;

import com.galaxy.bean.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author Hance
 * @version V1.0.0
 * @date 2022/4/13 15:40
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;

    static {
        employeeMap = new HashMap<>();
        employeeMap.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1));
        employeeMap.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1));
        employeeMap.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0));
        employeeMap.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0));
        employeeMap.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1));
    }

    private static Integer initId = 1006;

    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employeeMap.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll() {
        return employeeMap.values();
    }

    public Employee get(Integer id) {
        return employeeMap.get(id);
    }

    public void delete(Integer id) {
        employeeMap.remove(id);
    }
}
