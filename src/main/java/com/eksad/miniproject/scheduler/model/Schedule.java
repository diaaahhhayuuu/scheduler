package com.eksad.miniproject.scheduler.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString (callSuper = true)
@EqualsAndHashCode
@Entity
@Table (name = "schedule")
public class Schedule {
	
	@ApiModelProperty(value = "Schedule ID (Primary key)")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ApiModelProperty(value = "Jenis Kegiatan", dataType = "String", required = true)	
	@Column(name = "jenis_kegiatan", nullable = false)
	private String jenis_kegiatan;
	

	@ApiModelProperty(value = "Keterangan Tentang Kegiatan", dataType = "String", required = true)
	@Column(name = "keterangan")
	private String keterangan;

	@ApiModelProperty(value = "Tanggal Kegiatan", dataType = "String", required = true)
	@Column(name = "jadwal")
	private Date jadwal;

}
