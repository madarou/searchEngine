/**
 * 
 */
package com.makao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makao.dao.IUserDao;
import com.makao.model.User;
import com.makao.service.IUserService;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	/* (non-Javadoc)
	 * @see com.makao.service.IUserService#insert(com.makao.model.User)
	 */
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IUserService#update(com.makao.model.User)
	 */
	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IUserService#delete(java.lang.String)
	 */
	@Override
	public int delete(String userName) {
		return userDao.delete(userName);
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IUserService#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IUserService#countAll()
	 */
	@Override
	public int countAll() {
		return userDao.countAll();
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IUserService#findByUserName(java.lang.String)
	 */
	@Override
	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}
