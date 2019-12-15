package cn.edut.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;

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
			List<User> users= new ArrayList<User>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name") ;
				String gender = rs.getString("gender") ;
				int age = rs.getInt("age") ; 
				String address = rs.getString("address") ; 
				String qq = rs.getString("QQ"); 
				String email = rs.getString("email");
				User user = new User(id, name, gender, age, address, qq, email) ;
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn , ps , rs);
		}
		return null;
	}

}
