package com.example.restapi.demo.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Setter
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Setter
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Setter
    @Column(name = "email_address",  nullable = false)
    private String email;

    @Setter
    @Column(name = "username", nullable = false)
    private String username;

    @Setter
    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    private String confirmPassword;

    @Setter
    @Column(name = "created_at", nullable = true)
    @CreatedDate
    private Date createdAt;

    @Setter
    @Column(name = "created_by", nullable = true)
    @CreatedBy
    private String createdBy;

    @Setter
    @Column(name = "updated_at", nullable = true)
    @LastModifiedDate
    private Date updatedAt;

    @Setter
    @Column(name = "updated_by", nullable = true)
    @LastModifiedBy
    private String updatedBy;

}
