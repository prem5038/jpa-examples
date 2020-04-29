package com.shreem.jpa;

import com.shreem.jpa.model.User;
import com.shreem.jpa.repository.JpaRepository;

public class AppMain {
	
	public static void main(String args[]) {			
		System.out.println("Starting AppMain ...");
		User user=new User();
		user.setId(400);
		user.setAge(20);
		user.setName("Puppu");	
		new AppMain().saveUser(user);
	}
	
	public boolean saveUser(User user) {
			

		try(JpaRepository userJpaRepository=new JpaRepository<User, Long>(User.class)){		
			userJpaRepository.save(user);		
		} catch (Exception e) {		
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
