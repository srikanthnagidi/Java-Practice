package com.example.restapi.demo.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address",  nullable = false)
    private String email;

    @Column(name = "created_at", nullable = true)
    @CreatedDate
    private Date createdAt;

    @Column(name = "created_by", nullable = true)
    @CreatedBy
    private String createdBy;

    @Column(name = "updated_at", nullable = true)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "updated_by", nullable = true)
    @LastModifiedBy
    private String updatedBy;
}
