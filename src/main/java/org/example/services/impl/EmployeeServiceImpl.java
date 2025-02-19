package org.example.services.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.mapper.EmployeeMapper;
import org.example.models.Employee;
import org.example.services.EmployeeService;
import org.example.utils.MyBatisUtil;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void addEmployee(Employee employee) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.insert(employee);
            session.commit();
        }
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            return mapper.getById(id);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            return mapper.getAll();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.update(employee);
            session.commit();
        }
    }

    @Override
    public void deleteEmployee(Long id) {
        try (SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.delete(id);
            session.commit();
        }
    }
}