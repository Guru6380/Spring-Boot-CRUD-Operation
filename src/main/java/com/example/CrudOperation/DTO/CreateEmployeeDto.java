package com.example.CrudOperation.DTO;


import lombok.Data;

@Data
public class CreateEmployeeDto {
    private String name;
    private int age;
    private String address;
}
