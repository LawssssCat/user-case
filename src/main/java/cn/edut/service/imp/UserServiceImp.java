package cn.edut.service.imp;

import java.util.ArrayList;
import java.util.List;

import cn.edut.dao.UserDao;
import cn.edut.dao.imp.UserDaoImp;
import cn.edut.domain.User;
import cn.edut.service.UserService;

public class UserServiceImp implements UserService{

	private UserDao userDao = new UserDaoImp();  
	
	@Override
	public List<User> finAll() {
		return userDao.findAll();
	}

}
