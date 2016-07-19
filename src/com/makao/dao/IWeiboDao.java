package com.makao.dao;

import java.util.List;

import com.makao.model.Weibo;

/**
 * @author LiYanyu
 *
 */
public interface IWeiboDao {

	public abstract int insert(Weibo weibo);
    
    public abstract int update(Weibo weibo);
    
    public abstract int delete(String id);
    
    public abstract List<Weibo> selectAll();
    
    public abstract int countAll();
    
    public abstract Weibo findByWeiboId(String id);
}
