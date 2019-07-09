package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample1 {

	public static void main(String[] args) {
		// 1. 데이터베이스 드라이버 로드
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			System.out.println("오라클 데이터베이스에 접속했습니다");
			// 3. Statement 객체를 셍상
			Statement stmt =conn.createStatement();
			//insert 구문
			String sqlInsert="insert into dept values(?,?,?)";
			PreparedStatement pstmt= conn.prepareStatement(sqlInsert);
			pstmt.setInt(1, 90);
			pstmt.setString(2, "MARKETING");
			pstmt.setString(3, "JEJU");
			int resultCnt=pstmt.executeUpdate();
			if(resultCnt>0) {
				System.out.println("정상적으로입력되었습니다");
			};
			// 4. SQL문을 실행 :select/insert/update/delete
			String sql1="select *from dept order by deptno";
			
			ResultSet rs= stmt.executeQuery(sql1);
			// 5. 결과 출력
			System.out.println("----------------------");
			while(rs.next()) {
				System.out.println("부서번호"+rs.getInt("deptno"));
				System.out.println("부서이름"+rs.getString(2));
				System.out.println("부서위치"+rs.getString(3));
				System.out.println("----------------------");
			}
			
		
		
			// 6. 사용 객체 CLOSE : ResultSet, Statement, Connection
			rs.close();
			stmt.close();
			conn.close();
			pstmt.close();
			
			} 
			catch (SQLException e) {

				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
