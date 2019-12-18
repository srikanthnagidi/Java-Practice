package com.example.monodb.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

    private String firstName;

    private String lastName;

    private String gender;

    private int age;

    private Address address;

    private String [] interests;

    private double balance;

}
