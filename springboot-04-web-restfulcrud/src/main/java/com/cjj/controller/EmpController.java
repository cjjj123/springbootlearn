package com.cjj.controller;

import com.cjj.bean.Department;
import com.cjj.bean.Employee;
import com.cjj.dao.DepartmentDao;
import com.cjj.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmpController {

    private static  final  Logger logger = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String queryEmpList(Map<String, Object> map){
        Collection<Employee> all = employeeDao.getAll();
        map.put("emps", all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        logger.info(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditEmp(@PathVariable("id") Integer id,
                            Model model){
        Employee emp = employeeDao.getEmpById(id);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("emp", emp);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String edit(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        logger.info(String.valueOf(id));
        employeeDao.deleteEmpById(id);
        return "redirect:/emps";
    }
}
