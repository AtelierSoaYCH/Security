package com.auth.demo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.demo.entities.User;
import com.auth.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public User getLoggedInUser(
			HttpServletRequest request) {
		return (User) userService.loadUserByUsername(request.getUserPrincipal().getName());

	}

}
