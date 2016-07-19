/**
 * 
 */
package com.makao.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.makao.dao.IWeiboDao;
import com.makao.model.Weibo;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Repository
public class WeiboDao implements IWeiboDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	/* (non-Javadoc)
	 * @see com.makao.dao.IWeiboDao#insert(com.makao.model.Weibo)
	 */
	@Override
	public int insert(Weibo weibo) {
		return sqlSessionTemplate.insert("com.makao.model.Weibo.insert", weibo);
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IWeiboDao#update(com.makao.model.Weibo)
	 */
	@Override
	public int update(Weibo weibo) {
		return sqlSessionTemplate.update("com.makao.model.Weibo.update", weibo);
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IWeiboDao#delete(java.lang.String)
	 */
	@Override
	public int delete(String id) {
		return sqlSessionTemplate.delete("com.makao.model.Weibo.delete", id);
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IWeiboDao#selectAll()
	 */
	@Override
	public List<Weibo> selectAll() {
		return sqlSessionTemplate.selectList("com.makao.model.Weibo.selectAll");
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IWeiboDao#countAll()
	 */
	@Override
	public int countAll() {
		return sqlSessionTemplate.update("com.makao.model.Weibo.countAll");
	}

	/* (non-Javadoc)
	 * @see com.makao.dao.IWeiboDao#findByWeiboId(java.lang.String)
	 */
	@Override
	public Weibo findByWeiboId(String id) {
		return sqlSessionTemplate.selectOne("com.makao.model.Weibo.findByWeiboId", id);
	}

}
