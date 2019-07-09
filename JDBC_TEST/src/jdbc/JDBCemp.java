package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCemp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 데이터베이스 로드
		//커넥션 만들고
		Connection conn = null;
		// 데이터베이스연결
		try {
			 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결 성공");
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				System.out.println("오라클DB 접속");
				//stmt객체생성 테이블 데이터를 읽어온다
				Statement stmt=conn.createStatement();
				System.out.println(stmt+"객체생성");
				String sql1="select * from emp";
				  //exequteQuery는 하나의 리절트set을 만드는 셀렉트 문에서 사용
				  //테이블의 데이터를 불러오고 주로 조회를 위한 용도로 사용
				  //ResultSet으로 get메소드를 ㅣ용해 조회한다
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
