package com.example.employeems.service;

import com.example.employeems.entity.Employee;
import com.example.employeems.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public void deleteEmployee (Long id){
        if(!employeeRepository.existsById(id)){
            throw new EntityNotFoundException("employee with "+id +"not found");
        }
        employeeRepository.deleteById(id);
    }
}
