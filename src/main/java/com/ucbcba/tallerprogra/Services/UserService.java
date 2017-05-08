package com.ucbcba.tallerprogra.Services;

import com.ucbcba.tallerprogra.Entities.User;

/**
 * Created by da_20 on 26/4/2017.
 */
public interface UserService {
    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);
}
