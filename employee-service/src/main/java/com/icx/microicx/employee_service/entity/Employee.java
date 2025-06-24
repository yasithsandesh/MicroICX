package com.icx.microicx.employee_service.entity;

import com.icx.microicx.employee_service.entity.enums.DepartmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "employee")
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "first_name", length = 60)
    private String firstName;

    @Column(name = "last_name", length = 60)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "contact_number", length = 11)
    private String contactNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DepartmentType department;

    private String position;

    @Column(precision = 12, scale = 2)
    private BigDecimal salary;

    @Column(nullable = false)
    private boolean status = true;

    private LocalDate hiredDate;

    @Column(nullable = false, name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
