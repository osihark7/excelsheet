package com.excelsheet.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelsheet.com.model.UserDetails;
import com.excelsheet.com.service.UserDetailsService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserDetailsController {

	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/createUser")
	public ResponseEntity<UserDetails> createUser(@RequestBody UserDetails user) {
		UserDetails userData = userDetailsService.save(user);
		return ResponseEntity.ok(userData);
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserDetails>> getUserList() {
		List<UserDetails> userData = userDetailsService.getUserList();
		if (userData.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(userData);
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
		Optional<UserDetails> userData = userDetailsService.getUserById(id);
		if (userData.isPresent()) {
			return ResponseEntity.ok(userData.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with ID " + id + " Record not found");
		}
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> getFile() {
		String filename = "user-details.xlsx";
		InputStreamResource file = new InputStreamResource(userDetailsService.load());

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
	}

}
