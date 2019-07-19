package com.eksad.miniproject.scheduler.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.miniproject.scheduler.dao.ScheduleDao;
import com.eksad.miniproject.scheduler.model.Schedule;


@RestController
@RequestMapping("schedule/")
public class ScheduleController {
	
	@Autowired
	ScheduleDao scheduleDao;


	@GetMapping("getAll")
	public List<Schedule> getAll(){
		List<Schedule> result = new ArrayList<>();
		scheduleDao.findAll().forEach(result::add);
		
		System.out.println(result);
		return result;
	}

	@GetMapping("getOne/{id}")
	public Schedule getOne(@PathVariable Long id) {
		return scheduleDao.findById(id).orElse(null);
	}

	@PostMapping(value = "saveschedule")
	public Schedule save(@RequestBody Schedule schedule) { 
		try {
			return scheduleDao.save(schedule);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping (value = "updateschedule/{id}")
	public Schedule update(@RequestBody Schedule schedule, @PathVariable Long id) {
		Schedule scheduleSelected = scheduleDao.findById(id).orElse(null);
		if (scheduleSelected != null) {
			scheduleSelected.setJenis_kegiatan(schedule.getJenis_kegiatan());
			
			return scheduleDao.save(scheduleSelected);
		}else {
			return null;
		}
	}

	@DeleteMapping (value = "deleteschedule/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		scheduleDao.deleteById(id);
		result.put("message", "berhasi dihapus");
		return result;
	}

}
