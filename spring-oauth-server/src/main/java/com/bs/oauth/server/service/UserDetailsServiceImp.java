package com.bs.oauth.server.service;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bs.oauth.server.model.User;

public class UserDetailsServiceImp implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = findUserbyUername(username);

		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			
			builder.password(user.getPassword());
			builder.roles(user.getRoles());
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

	private User findUserbyUername(String username) {
		
		System.out.println("validating users in findUserbyUername : "+username);
		if (username.equalsIgnoreCase("admin")) {
			return new User(username, "$2a$10$ibdhLbV1/3Zh1wv8VMTE1esbWN4ePhWMHuK8t.JAIuogB0IUZXM.C", "ADMIN");
		}
		return null;
	}
}
