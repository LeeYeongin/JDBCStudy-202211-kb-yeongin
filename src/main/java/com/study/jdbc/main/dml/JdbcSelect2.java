package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("작성자 id: ");
		int writerId = scanner.nextInt();
		//String writerId = scanner.nextline();
		
		Connection connection = DBConnection.getInstance().getConnection();
		String sql = "select * from board_mst where writer_id = ?";	// 뭐가 들어올지 모를때 ? 사용
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, writerId);// 1은 첫번째 물음표를 의미
			//pstmt.setString(1, writerId);
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("id\t\ttitle\t\tcontent\t\tread_count\t\twriter_id");
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1)
				+ "\ttitle: " + rs.getString(2)
				+ "\tcontent: " + rs.getString(3)
				+ "\tread_count: " + rs.getInt(4)
				+ "\twriter_id: " + rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
