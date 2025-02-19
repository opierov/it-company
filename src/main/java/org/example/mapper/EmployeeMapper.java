package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.models.Employee;
import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper {

    @Insert("INSERT INTO employees (id, name, role, salary) " +
            "VALUES (#{id}, #{name}, #{role}, #{salary})")
    void insert(Employee employee);

    @Select("SELECT * FROM employees WHERE id = #{id}")
    Optional<Employee> getById(Long id);

    @Select("SELECT * FROM employees")
    List<Employee> getAll();

    @Update("UPDATE employees SET name = #{name}, role = #{role}, salary = #{salary} WHERE id = #{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employees WHERE id = #{id}")
    void delete(Long id);
}