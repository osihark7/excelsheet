package com.excelsheet.com.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsheet.com.helper.ExcelHelper;
import com.excelsheet.com.model.UserDetails;
import com.excelsheet.com.repository.UserDetailsRepository;

@Service
public class UserDetailsService {
	
	@Autowired
	UserDetailsRepository  userDetailsRepository;

	public InputStream load() {
		List<UserDetails> userData = userDetailsRepository.findAll();
		ByteArrayInputStream in = ExcelHelper.userDataToExcel(userData);
		return in;
	}

	public UserDetails save(UserDetails user) {
		return userDetailsRepository.save(user);
	}

	public List<UserDetails> getUserList() {
		return userDetailsRepository.findAll();
	}

	public Optional<UserDetails> getUserById(Long id) {
		return userDetailsRepository.findById(id);
	}

}
