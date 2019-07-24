package com.eksad.miniproject.scheduler.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString (callSuper = true)
@EqualsAndHashCode
@Entity
@Table (name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_employee")	
	private Long id;

	@Column(nullable = false)
	private String nama;

	@Column(nullable = false)
	private String email;

}
