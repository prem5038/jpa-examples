package com.shreem.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.shreem.jpa.model.User;



public class AppMainTest {
	
	static AppMain appMain;
	
	@BeforeClass
	public static void init() {
		appMain = new AppMain();
	}
	
	@Test
	public void testJpaDemo() {
		User user=new User();
		user.setId(500);
		user.setAge(20);
		user.setName("Sonia");	
		boolean result = appMain.saveUser(user);
		assertEquals(true, result);
	}

}
