package com.eksad.miniproject.scheduler.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eksad.miniproject.scheduler.model.Schedule;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Long> {
	
	public Optional<Schedule> findById(Long id);
//	public List<Schedule> findByJenis(String jenis_kegiatan);
//	
//	@Query("select s from Schedule s where jenis_kegiatan = :search")
//	public List<Schedule> findBySearch(@Param("search") String search);

}
