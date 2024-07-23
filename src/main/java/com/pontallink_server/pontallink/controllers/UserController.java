package com.pontallink_server.pontallink.controllers;

import com.pontallink_server.pontallink.dtos.UserCreateDTO;
import com.pontallink_server.pontallink.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pontallink_server.pontallink.dtos.UserProfileDTO;
import com.pontallink_server.pontallink.infra.security.TokenService;
import com.pontallink_server.pontallink.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private TokenService tokenService;

	@GetMapping("/me")
	public ResponseEntity<UserProfileDTO> getUserProfile() {
		var currentSubject = tokenService.getSubjectCurrentToken();
		var userProfile = userService.getUserProfile(currentSubject);
		return ResponseEntity.ok(userProfile);
	}

	@PostMapping
	public ResponseEntity<UserProfileDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
		UserProfileDTO user = userService.createUser(userCreateDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
