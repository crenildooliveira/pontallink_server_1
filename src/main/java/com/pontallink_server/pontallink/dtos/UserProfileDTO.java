package com.pontallink_server.pontallink.dtos;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.pontallink_server.pontallink.entities.User;

public record UserProfileDTO(String name, String bio, List<String> interesses, String condominio, Integer friendsCount, String userProfileImage) {

	public UserProfileDTO(UserDetails user) {
		//User userProfile = (User) user;
        this(null, null, List.of("All"), null, null, null);
    }
	

}
