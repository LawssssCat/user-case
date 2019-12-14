package cn.edut.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edut.dao.UserDao;
import cn.edut.domain.User;
import cn.edut.util.JdbcUtils;

public class UserDaoImp implements UserDao{

	@Override
	public List<User> findAll() {
		Connection conn = null ;
		PreparedStatement ps = null ;
		ResultSet rs  = null ;
		try {
			conn = JdbcUtils.getConn();
			ps = conn.prepareStatement("Select * from user");
			rs = ps.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			while(rs.next()) {
				String name = rs.getString("name") ;
				String gender = rs.getString("gender") ; 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn , ps , rs);
		}
		return null;
	}

}
