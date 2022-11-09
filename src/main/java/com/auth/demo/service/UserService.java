package com.auth.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.demo.dao.UserRepository;
import com.auth.demo.entities.User;

@Service
// @Slf4j
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Objects.requireNonNull(username);
		User user = userRepository.findUserWithName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return user;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

}
