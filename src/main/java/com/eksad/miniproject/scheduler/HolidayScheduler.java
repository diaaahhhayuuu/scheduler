package com.eksad.miniproject.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.eksad.miniproject.scheduler.dao.CronDao;
import com.eksad.miniproject.scheduler.model.Content;
import com.eksad.miniproject.scheduler.model.Cron;
import com.eksad.miniproject.scheduler.model.Employee;
import com.eksad.miniproject.scheduler.model.Log;

@RestController
public class HolidayScheduler {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/eksad";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";
	
	@Autowired
	CronDao cronDao;
	
	public Connection conn() { 
		try {
			Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 
			System.out.println("Koneksi berhasil");
			return connection;
		} catch (SQLException e) {
			System.out.println("Koneksi gagal!");
			e.printStackTrace();
			return null;
		}
	}
	
	@Scheduled(cron = "*/10 * * * * ?")
	public void run() throws InterruptedException {
	
			try {
				Connection  con= conn();
				System.out.println("Silakan refresh data base table Log");
				Statement st = con.createStatement();
				Content classContent = new Content();
				Employee classEmployee = new Employee();
				Log classLog = new Log();
				
//				classCron.setCron("Cron scheduler is runing at: ");
//				String sql ="INSERT INTO tb_cron (cron) VALUES ('"+classCron.getCron() +new Date()+"')";
				
				classEmployee.setEmail("SELECT email FROM employee");
				classContent.setContent("SELECT content FROM content");
				String sql = "INSERT INTO log (email, message, date_sent) VALUES ('"+classEmployee.getEmail()+"',"
						+ "'"+classContent.getContent()+"', '"+new Date()+"')";
				int result = st.executeUpdate(sql);

				st.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		

		Thread.sleep(3000);
	}

}
