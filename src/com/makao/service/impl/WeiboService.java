/**
 * 
 */
package com.makao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makao.dao.IWeiboDao;
import com.makao.model.Weibo;
import com.makao.service.IWeiboService;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Service
@Transactional
public class WeiboService implements IWeiboService {

	@Autowired
	private IWeiboDao weiboDao;
	/* (non-Javadoc)
	 * @see com.makao.service.IWeiboService#insert(com.makao.model.Weibo)
	 */
	@Override
	public int insert(Weibo weibo) {
		return weiboDao.insert(weibo);
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IWeiboService#update(com.makao.model.Weibo)
	 */
	@Override
	public int update(Weibo weibo) {
		return weiboDao.update(weibo);
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IWeiboService#delete(java.lang.String)
	 */
	@Override
	public int delete(String id) {
		return weiboDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IWeiboService#selectAll()
	 */
	@Override
	public List<Weibo> selectAll() {
		return weiboDao.selectAll();
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IWeiboService#countAll()
	 */
	@Override
	public int countAll() {
		return weiboDao.countAll();
	}

	/* (non-Javadoc)
	 * @see com.makao.service.IWeiboService#findByWeiboId(java.lang.String)
	 */
	@Override
	public Weibo findByWeiboId(String id) {
		return weiboDao.findByWeiboId(id);
	}

}
