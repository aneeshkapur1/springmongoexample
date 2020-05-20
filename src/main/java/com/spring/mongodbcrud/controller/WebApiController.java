package com.spring.mongodbcrud.controller;

import com.spring.mongodbcrud.model.Department;
import com.spring.mongodbcrud.repositories.DepartmentRepository;
import com.spring.mongodbcrud.repositories.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebApiController {

    @Autowired
    DepartmentRepository departmentRepository;


    @Autowired
    DeptRepository deptRepository;


    @PostMapping
    public Department createDept(@RequestBody Department department) {
        deptRepository.save(department);
        return department;
    }

    @GetMapping
    public List listDepts(){
        return deptRepository.findAll();
    }

    @PutMapping("/{deptId}")
    public Department updateDept(@RequestBody Department department, @PathVariable String deptId) {
        department.setId(deptId);
        deptRepository.save(department);
        return department;
    }

    @DeleteMapping("/{deptId}")
    public String deleteDept(@PathVariable String deptId) {
        deptRepository.deleteById(deptId);
        return deptId;
    }

    @GetMapping("/{deptName}")
    public List findDeptByName(@PathVariable String deptName) {
        return deptRepository.findDepartmentByName(deptName);
    }


}
