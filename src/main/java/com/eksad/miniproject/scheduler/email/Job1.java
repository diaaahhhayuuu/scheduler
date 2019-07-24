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

	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			Connection con = conn();
			Statement st = con.createStatement();

			String pilihEmail = "SELECT email FROM employee";
			ResultSet resultEmail = st.executeQuery(pilihEmail);

			String pilihContent = "SELECT content FROM content";
			ResultSet resultContent = st.executeQuery(pilihContent);

			while (resultEmail.next() && resultContent.next()) {
				String email = resultEmail.getString("email");
				String content = resultContent.getString("content");

					System.out.println("Job has working at " + new Date());

					EmailUtil.sendEmail(email, "Holiday Announcement", content);
			}
			

			resultContent.close();
			resultEmail.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = conn();
			Statement st = con.createStatement();

			String pilihEmail = "SELECT email FROM employee";
			ResultSet resultEmail = st.executeQuery(pilihEmail);

			String pilihContent = "SELECT content FROM content";
			ResultSet resultContent = st.executeQuery(pilihContent);

			while (resultEmail.next() && resultContent.next()) {
				String email = resultEmail.getString("email");
				String content = resultContent.getString("content");

					System.out.println("Job has working at " + new Date());

					EmailUtil.sendEmail(email, "Holiday Announcement", content);
			}
			

			resultContent.close();
			resultEmail.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}