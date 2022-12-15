package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect1 {

	public static void main(String[] args) {
		Connection connection = DBConnection.getInstance().getConnection(); // database 연결
		//System.out.println(connection);
		
		String sql = "select * from score_mst";	// 인터페이스
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql); // query를 입력하는 공간
			ResultSet rs = pstmt.executeQuery(); // query실행 -> ResultSet은 결과를 가지고있는 Set
												// 한번꺼내쓰면 다시 사용 불가 (iterator와 동일)
			
			System.out.println("id\t\tname\t\tscore");
			
			while(rs.next()) { // resultset의 next가 없을때까지
				System.out.println("id: " + rs.getInt(1) // -> index는 column번호 (1번부터 시작)
				+ "\t name: " + rs.getString(2)   
				+ "\t score: " + rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
