package cn.edut.util;

import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class Test_JdbcUtils {
	@Test
	public void test01() {
		Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs  = null; 
		try {
			 conn = JdbcUtils.getConn();
			 System.out.println(conn);
			 
			 String sql = "select * from user ; " ;
			 ps = conn.prepareStatement(sql);
			 rs= ps.executeQuery();
			 System.out.println(rs.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn,ps , rs );
		}
	}

}
