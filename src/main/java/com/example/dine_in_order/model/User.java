package com.example.dine_in_order.model;

import com.example.dine_in_order.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "phno")
    private String phno;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createAt;

    @Column(name = "last_modified_at")
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;


}
