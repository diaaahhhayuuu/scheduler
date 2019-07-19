package com.eksad.miniproject.scheduler.model;

import java.util.Date;

import javax.annotation.Generated;
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
@Table (name = "schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "jenis_kegiatan", nullable = false)
	private String jenis_kegiatan;
	
	@Column(name = "keterangan")
	private String keterangan;
	
	@Column(name = "jadwal")
	private Date jadwal;

}
