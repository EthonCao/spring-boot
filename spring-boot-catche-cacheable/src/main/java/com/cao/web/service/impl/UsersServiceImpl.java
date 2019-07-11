package com.cao.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cao.web.dao.UsersRepository;
import com.cao.web.domain.Users;
import com.cao.web.service.UsersService;

/**
 * UsersService接口实现类
 *
 *
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public List<Users> findUserAll() {
		return this.usersRepository.findAll();
	}

	@Override
	//@Cacheable:对当前查询的对象做缓存处理
	@Cacheable(value="users")
	public Users findUserById(Integer id) {
		return this.usersRepository.findOne(id);
	}

	@Override
	@Cacheable(value="users",key="#pageable.pageSize")
	public Page<Users> findUserByPage(Pageable pageable) {
		return this.usersRepository.findAll(pageable);
	}

	@Override
	public void saveUsers(Users users) {
		this.usersRepository.save(users);
	}

}
