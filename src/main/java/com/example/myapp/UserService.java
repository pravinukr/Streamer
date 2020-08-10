package com.example.myapp;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	public boolean find(String username, String password) {
		if(username.equals("pravinukr@gmail.com") && password.equals("12345"))
			return true;
		return false;
	}
}
