package main.java.com.study.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	
	private static DBConnection instance = null;
	
	private DBConnection() {};
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	// Connection: jdk가 가지고있는 sql인터페이스
	public Connection getConnection() {
		Connection connection = null;
		String url = null;
		String username = null;
		String password = null;
		
		try {
			Class.forName(Driver.class.getName()); // Class(Driver객체)를 찾아서 객체 생성 -> mySQL driver load
			//Class.forName("com.mysql.cj.jdbc.Driver"); 이런식으로도 사용가능
			System.out.println("데이터베이스 드라이브 로딩 성공!");
			url = "jdbc:mysql://localhost:3306/subquery_study"; // 프로토콜//port번호/database이름
			username = "root";
			password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) { //Class.forName()에 필요한 try/catch -> 찾고자하는 경로가 존재하지 않았을때
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) { //DriverManager.getConnection(url, username, password)에 필요한 try/catch -> 연결되지 않았을때
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패!");
		}
		
		return connection;
	}
	
}
