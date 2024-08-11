package com.example.sockets.dto;

import lombok.Data;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private Address address;

}
