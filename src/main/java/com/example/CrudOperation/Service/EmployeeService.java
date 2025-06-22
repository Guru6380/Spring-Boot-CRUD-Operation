package com.example.CrudOperation.Service;

import com.example.CrudOperation.DTO.UpdateAddressDto;
import com.example.CrudOperation.Entity.Employee;
import com.example.CrudOperation.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee create(Employee employee){
        return employeeRepo.save(employee);
    }

    public Optional<Employee> getByName(String name){
        return employeeRepo.findByName(name);
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }

    public boolean updateAddress(UpdateAddressDto updateAddressDto){

        Employee Existing = employeeRepo.findByName(updateAddressDto.getName()).orElseThrow(()-> new RuntimeException("vefs"));

        Existing.setAddress(updateAddressDto.getAddress());
        return Existing;
    }
    public Boolean deleteEmployee(String name) {
        Optional<Employee> employee = employeeRepo.findByName(name);
        if(employee.isPresent()){
            employeeRepo.deleteById(employee.get().getId());
            return true;
        }
        else {
            return false;
        }
    }

    }
