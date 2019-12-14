package cn.edut.util;



import java.beans.PropertyVetoException;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static ComboPooledDataSource pool = null; 
	
	static {
		//连接池
		pool = new ComboPooledDataSource() ;
		//加载配置
		try {
			pool.setDriverClass("com.mysql.jdbc.Driver");
			pool.setJdbcUrl("jdbc:mysql://localhost:3306/u_db?characterEncoding=utf8");
			pool.setUser("root");
			pool.setPassword("root");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.close();
		}
	}
	
	public static Connection getConn() throws SQLException {
		return pool.getConnection() ;
	}
	
	public static <T extends AutoCloseable> void close(T ... c) {
		for (T t : c) {
			if(t!=null) {
				try {
					t.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					t = null ;
				}
			}
		}
	}
}
