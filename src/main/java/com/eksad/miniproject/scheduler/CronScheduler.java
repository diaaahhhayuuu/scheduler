package com.eksad.miniproject.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.miniproject.scheduler.dao.CronDao;
import com.eksad.miniproject.scheduler.model.Cron;
import com.eksad.miniproject.scheduler.model.Schedule;


//@RestController
public class CronScheduler {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/eksad";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";

	
	public Connection conn() { 
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
//			System.out.println("Koneksi berhasil");
			return connection;
		} catch (SQLException e) {
			System.out.println("Koneksi gagal!");
			e.printStackTrace();
			return null;
		}
	}
		
	
	@Scheduled(cron = "*/5 * * * * ?")
	public void run() throws InterruptedException {
	
			try {
				Connection  con= conn();
				System.out.println("Silakan refresh data base table cron");
				Statement st = con.createStatement();
				Cron classCron = new Cron();
				
				classCron.setCron("Cron scheduler is runing at: ");
				String sql ="INSERT INTO tb_cron (cron) VALUES ('"+classCron.getCron() +new Date()+"')";
				int result = st.executeUpdate(sql);

				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

		Thread.sleep(3000);
	}
}