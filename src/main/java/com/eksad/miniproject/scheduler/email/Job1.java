package com.eksad.miniproject.scheduler.email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.eksad.miniproject.scheduler.dao.CronDao;
import com.eksad.miniproject.scheduler.model.Content;
import com.eksad.miniproject.scheduler.model.Cron;

public class Job1 implements Job {

	private static final String URL = "jdbc:postgresql://localhost:5432/eksad";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "postgres";

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

	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			Connection con = conn();
			Statement st = con.createStatement();
			
			String pilihEmail = "SELECT * FROM employee";
			ResultSet resultEmail = st.executeQuery(pilihEmail);			

			while (resultEmail.next()) {
				String nama = resultEmail.getString("name");
				String email = resultEmail.getString("email");

					System.out.println("Job has working at " + new Date());
					
					EmailUtil.sendEmail(email, 
							"Holiday Announcement", 
							"Hi, "+nama+ "! "
							+ "Sekedar mengingatkan bahwa besok adalah hari libur diharapkan kepada seluruh karyawan untuk TIDAK DATANG ke kantor ;)");


			resultEmail.close();
			st.close();
			con.close();
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}