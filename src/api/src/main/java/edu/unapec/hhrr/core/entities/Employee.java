package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Employee")
@Table(name = "employees", indexes = {@Index(name = "idx_employees_isActive", columnList = "is_active"),
        @Index(name = "idx_employees_firstName", columnList = "first_name"),
        @Index(name = "idx_employees_last_name", columnList = "last_name")})
@Where(clause = "is_active = true")
public class Employee extends AuditableEntity<Long> {

    @Column(name = "identity_card", nullable = false)
    private Integer identityCard;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    private LocalDate hireDate;
    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",foreignKey = @ForeignKey(name = "fk_employee_department"),
            insertable=false, updatable = false)
    private Department department;

    @Column(name = "montly_salary", columnDefinition="Decimal(10,2)", nullable = false, precision = 10, scale = 2)
    private Double montlySalary;
}
