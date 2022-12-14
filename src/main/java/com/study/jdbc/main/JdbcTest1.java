package main.java.com.study.jdbc.main;

import java.sql.Connection;

import com.mysql.cj.jdbc.Driver;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcTest1 {

	public static void main(String[] args) {
		Connection connection = DBConnection.getInstance().getConnection();
		
		System.out.println(connection);
	}

}
