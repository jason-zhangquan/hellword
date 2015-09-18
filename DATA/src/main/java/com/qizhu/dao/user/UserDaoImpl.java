package com.qizhu.dao.user;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qizhu.dao.base.BaseDaoImpl;
import com.qizhu.dao.base.PageResults;
import com.qizhu.dao.base.RowMapper;
import com.qizhu.model.user.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, String> implements IUserDao {

}
