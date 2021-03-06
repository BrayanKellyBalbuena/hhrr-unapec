package edu.unapec.hhrr.core.entities;

import edu.unapec.hhrr.core.entities.abstracts.AdultPerson;
import edu.unapec.hhrr.core.entities.abstracts.AuditableEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Employee")
@Table(name = "employees", indexes = {@Index(name = "idx_employees_isActive", columnList = "is_active"),
        @Index(name = "idx_employees_first_name", columnList = "first_name"),
        @Index(name = "idx_employees_last_name", columnList = "last_name")})
@Where(clause = "is_active = true")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Employee extends AdultPerson<Long> {

    @Column
    private String email;

    private LocalDate hireDate = LocalDate.now();
    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",foreignKey = @ForeignKey(name = "fk_employee_department"),
            insertable=false, updatable = false)
    private Department department;

    @Column(name = "montly_salary", columnDefinition="Decimal(10,2)", nullable = false, precision = 10, scale = 2)
    private Double montlySalary = 50000.00;
}
