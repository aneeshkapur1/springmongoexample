package com.spring.mongodbcrud.repositories;

import com.spring.mongodbcrud.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository <Department, String>{

    List findDepartmentByName(String name);
}
