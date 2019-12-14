package cn.edut.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class Test_JdbcUtils {
	@Test
	public void test01() {
		Connection conn = null; 
		try {
			 conn = JdbcUtils.getConn();
			 System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
	}
}
