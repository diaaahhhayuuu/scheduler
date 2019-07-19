package com.eksad.miniproject.scheduler.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eksad.miniproject.scheduler.model.Cron;

@Repository
public interface CronDao extends JpaRepository<Cron, Long>{

}
