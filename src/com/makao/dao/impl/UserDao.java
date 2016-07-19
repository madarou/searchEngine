/**
 * 
 */
package com.makao.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.makao.dao.IUserDao;
import com.makao.model.User;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	/* (non-Javadoc)
	 * @see com.makao.dao.IUserDao#insert(com.makao.model.User)
	 */
	@Override
	public int insert(User user) {
		return sqlSessionTemplate.insert("com.makao.model.User.insert", user);
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IUserDao#update(com.makao.model.User)
	 */
	@Override
	public int update(User user) {
		return sqlSessionTemplate.update("com.makao.model.User.update", user);
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IUserDao#delete(java.lang.String)
	 */
	@Override
	public int delete(String userName) {
		return sqlSessionTemplate.delete("com.makao.model.User.delete", userName);
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IUserDao#selectAll()
	 */
	@Override
	public List<User> selectAll() {
		return sqlSessionTemplate.selectList("com.makao.model.User.selectAll");
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IUserDao#countAll()
	 */
	@Override
	public int countAll() {
		return sqlSessionTemplate.update("com.makao.model.User.countAll");
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IUserDao#findByUserName(java.lang.String)
	 */
	@Override
	public User findByUserName(String userName) {
		return sqlSessionTemplate.selectOne("com.makao.model.User.findByUserName", userName);
	}

}
