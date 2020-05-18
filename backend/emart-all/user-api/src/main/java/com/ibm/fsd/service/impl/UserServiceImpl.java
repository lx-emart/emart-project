package com.ibm.fsd.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fsd.dto.UserDto;
import com.ibm.fsd.entity.User;
import com.ibm.fsd.repository.UserRepository;
import com.ibm.fsd.service.UserService;

/**
 * user Info
 */
@Service
class UserServiceImpl implements UserService {
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    UserRepository userRepository;

	/**
	 * get login user 
	 * 
	 * @param email
	 * @param password
	 * 
	 * @return user info
	 */
	@Override
	public UserDto login(String email, String password) {
		 
		UserDto dto = new UserDto();
		
		// get login info
		User user = userRepository.findByEmail(email);
		
		// result copy
		BeanUtils.copyProperties(user, dto);
		
		return dto;
	}

	/**
	 * signup
	 * 
	 * @param dto
	 */
	@Override
	@Transactional
	public UserDto signup(UserDto dto) {
		
		// password
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		// user
		User user = new User();
		// result copy
		BeanUtils.copyProperties(dto, user);
		// save
		user = userRepository.save(user);
		// UserDto
		UserDto userDto = new UserDto();
		// result copy
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
	
	/**
	 * password update
	 * 
	 * @param dto
	 */
	@Override
	@Transactional
	public int password(UserDto dto) {
		// password
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		return userRepository.update(dto);
	}

}
