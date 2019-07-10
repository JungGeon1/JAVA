package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCemp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 데이터베이스 로드
		Connection conn = null;
		// 데이터베이스연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				System.out.println("오라클DB 접속");
				//stmt객체생성 테이블 데이터를 읽어온다

				String sql1="select * from emp01";
			    String sql2="update emp set sal=1000 where ename='SCOTT'";
				Statement stmt=conn.createStatement(); 
			
				ResultSet rs= stmt.executeQuery(sql1);
				System.out.println("-----------------------------");
				
				while(rs.next()){
					System.out.println("사원번호 :"+rs.getInt("empno"));
					System.out.println("사원이름 :"+rs.getString("ename"));
					System.out.println("직업 :"+rs.getString(3));
					System.out.println("관리자번호 :"+rs.getInt(4));
					System.out.println("입사날짜 :"+rs.getString(5));
					System.out.println("급여 :"+rs.getInt(6));
					System.out.println("커미션 :"+rs.getInt(7));
					System.out.println("부서번호 :"+rs.getInt(8));
					System.out.println("-----------------------------");
				};
				
				int cnt=stmt.executeUpdate(sql2);
				if(cnt>0) {
					System.out.println("스캇아 월급올랐다!");
				};
				rs.close();
				stmt.close();
				
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

}
