package com.musicsamplesite.service;

import com.musicsamplesite.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
