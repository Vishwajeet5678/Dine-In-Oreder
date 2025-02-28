package com.example.dine_in_order.dto.response;

import com.example.dine_in_order.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Builder
@Getter
@Setter
public class UserResponse {

private long userId;
private String userName;
@Enumerated(EnumType.STRING)
private UserRole role;
private LocalDateTime createdAt;
private LocalDateTime lastModifiedAt;
}
