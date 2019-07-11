		package com.cao.web.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cao.web.App;

/**
 * UsersService测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=App.class)
public class UsersServiceTest {

	@Autowired
	private UsersService usersService;
	
	@Test
	public void testFindUserById(){
		//第一次查询
		System.out.println(this.usersService.findUserById(1));
		
		//第二次查询
		System.out.println(this.usersService.findUserById(1));
	}
	
	@Test
	public void testFindUserByPage(){
		Pageable pageable = new PageRequest(0, 2);
		//第一次查询
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
		//第二次查询
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
		
		//第三次查询
		pageable = new PageRequest(1, 2);
		System.out.println(this.usersService.findUserByPage(pageable).getTotalElements());
	}
}