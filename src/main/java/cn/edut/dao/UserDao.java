package cn.edut.dao;

import java.util.List;

import cn.edut.domain.User;

/**
 * 用户操作的Dao
 */
public interface UserDao {
	public List<User> findAll() ;
}
