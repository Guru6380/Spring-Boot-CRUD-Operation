package com.example.CrudOperation.Controller;

import com.example.CrudOperation.DTO.UpdateAddressDto;
import com.example.CrudOperation.Entity.Employee;
import com.example.CrudOperation.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee created = employeeService.create(employee);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Employee> getByName(@PathVariable String name) {
        Optional<Employee> employee = employeeService.getByName(name);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PutMapping("/update/employee")
    public ResponseEntity<?> update(@RequestBody UpdateAddressDto updateAddressDto) {
        boolean updated = employeeService.updateAddress(updateAddressDto);
        if (updated) {
            return ResponseEntity.ok("Address updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        }
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> delete(@PathVariable String name) {
        boolean deleted = employeeService.deleteEmployee(name);
        if (deleted) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
