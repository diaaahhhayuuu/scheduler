package com.eksad.miniproject.scheduler.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString (callSuper = true)
@EqualsAndHashCode
@Entity
@Table (name = "content")
public class Content {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_content")
	private Long id;
	
	@Column(nullable = false)
	private Date calendar;
	
	@Column(nullable = false)
	private String message;

}
