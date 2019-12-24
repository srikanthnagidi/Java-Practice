package com.example.monodb.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("members")
@Setter
@Getter
@NoArgsConstructor
public class Member{
    @Id
    private String id;

    @BsonProperty("first_name")
    private String firstName;
    @BsonProperty("last_name")
    private String lastName;

    private String gender;

    private int age;

    public Member(String firstName, String lastName, String gender, int age, Address address, String[] interests, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.interests = interests;
        this.balance = balance;
    }

    private Address address;

    private String [] interests;

    private double balance;

}
