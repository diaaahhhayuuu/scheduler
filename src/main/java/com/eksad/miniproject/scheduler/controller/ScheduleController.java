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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;


@RestController
@RequestMapping(value = "/miniprojectapi/schedule")
@Api(tags = "Scheduler")
public class ScheduleController {
	
	@Autowired
	private ScheduleDao scheduleDao;


	@ApiOperation ( 
			value = "API to retrive to all schedule data",
			tags = "Scheduler"
			)
	@GetMapping("/getAll")
	public List<Schedule> getAll(){
		List<Schedule> result = new ArrayList<>();
		scheduleDao.findAll().forEach(result::add);
		
		System.out.println(result);
		return result;
	}
	

	@ApiOperation ( 
			value = "API to get schedule data short by ID",
			tags = "Scheduler"
			)
	@GetMapping("/getOne/{id}")
	public Schedule getOne(@PathVariable Long id) {
		return scheduleDao.findById(id).orElse(null);
	}

	
	@ApiOperation ( 
			value = "API to input new shedule data",
			tags = "Scheduler"
			)
	@PostMapping(value = "/saveschedule")
	public Schedule save(@RequestBody Schedule schedule) { 
		try {
			return scheduleDao.save(schedule);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	@ApiOperation ( 
			value = "API to update schedule data",
			tags = "Scheduler"
			)
	@PutMapping (value = "/updateschedule/{id}")
	public Schedule update(@RequestBody Schedule schedule, @PathVariable Long id) {
		Schedule scheduleSelected = scheduleDao.findById(id).orElse(null);
		if (scheduleSelected != null) {
			scheduleSelected.setJenis_kegiatan(schedule.getJenis_kegiatan());
			
			return scheduleDao.save(scheduleSelected);
		}else {
			return null;
		}
	}
	

	@ApiOperation ( 
			value = "API to delete schedule data",
			tags = "Scheduler"
			)
	@DeleteMapping (value = "/deleteschedule/{id}")
	public HashMap<String, Object> delete(@PathVariable Long id){
		HashMap<String, Object> result = new HashMap<String, Object>();
		scheduleDao.deleteById(id);
		result.put("message", "berhasi dihapus");
		return result;
	}

}
