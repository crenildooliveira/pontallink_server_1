package com.pontallink_server.pontallink.dtos;

import com.pontallink_server.pontallink.entities.User;

import java.util.List;

public record UserCreateDTO(String name, String login, String bio, List<String> interests, String condominium, String userProfileImageMid) {
}
