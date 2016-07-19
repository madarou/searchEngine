/**
 * 
 */
package com.makao.service;

import java.util.List;

import com.makao.model.User;

/**
 * @author LiYanyu
 *
 */
public interface IUserService {

	public abstract int insert(User user);
    
    public abstract int update(User user);
    
    public abstract int delete(String userName);
    
    public abstract List<User> selectAll();
    
    public abstract int countAll();
    
    public abstract User findByUserName(String userName);
}
