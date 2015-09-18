package com.qizhu.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qizhu.dao.base.IBaseDao;
import com.qizhu.dao.user.IUserDao;
import com.qizhu.model.user.User;
import com.qizhu.service.base.BaseServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements
		IUserService {

	/**
	 * 注入userDao
	 */
	@Autowired
	private IUserDao userDao ;

	@Autowired
	public void setBaseDao(IBaseDao<User, String> baseDao) {
		super.setBaseDao(baseDao);
	}

}
