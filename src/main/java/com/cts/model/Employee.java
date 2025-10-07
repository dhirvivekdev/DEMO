package com.cts.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private int id;
	@Pattern(regexp = "[A-Z][A-Za-z\\s]{3,}",message="Name should start with a capital letter followed by only alphabets")
	private String name;
	@Pattern(regexp = "(Male|Female)",message = "Invalid Gender")
	private String gender;
	@Min(18)
	@Max(60)
	private int age;
	private double salary;
	private String city;
	@Past
	private LocalDate dateOfJoining;
}
