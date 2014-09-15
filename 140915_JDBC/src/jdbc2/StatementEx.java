package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StatementEx {

	public static void main(String[] args) throws Exception {

		// try ~ with Resources(TWR) Auto Closer
		// �̷��� �ڵ��ϸ� Finally �Ƚᵵ �ȴ�. 
		String driverName="oracle.jdbc.OracleDriver";
		String urlPath="jdbc:oracle:thin:@61.72.16.181:5021:orcl";
		String userid = "c##user02";
		String userpw = "user02";

		String sql = "select sysdate from dual";

		Class.forName(driverName);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {

			try(
					// ���Ͽ���
					Connection con = DriverManager.getConnection(urlPath, userid, userpw);
					// OutputStream
					PreparedStatement stmt = con.prepareStatement(sql);
					// InputStream (select �� ����� ���� ResultSet ����Ѵ�.) 
					ResultSet rs = stmt.executeQuery(); 

					){
				System.out.println(con);
				System.out.println("ready.....");

				System.out.println(rs);
				System.out.println(rs.next()); // �� ĭ �ݵ�� �����;� �Ѵ�. (ù ��° ĭ���� ��Ÿ�����Ͱ� �ִ�) 
				System.out.println(rs.getString(1));
				
				// Ŀ�ؼ� �ϳ��� ������ �δ� �ڵ� 
				
			}catch(Exception e){
				e.printStackTrace();
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("�����");
		System.out.println(end-start);

	}

}