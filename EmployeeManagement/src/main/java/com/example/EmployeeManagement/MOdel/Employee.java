package com.example.EmployeeManagement.MOdel;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank
    private String lastName;

    @Email
    @Column(unique = true,nullable = false,name = "Email")
    private String email;

    @NotNull
    @Length(min=10,message = "Length must be 10 digits")
    @Column(unique = true,nullable = false,name = "Contact_No")
    private String phoneNumber;

    @NotBlank
    private String jobRole;

    @NotNull
    private double salary;

    @Column
    private String hrd;

    @OneToMany(mappedBy = "employee")
    private List<Record> records;


}

