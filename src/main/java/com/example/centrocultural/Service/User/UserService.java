package com.example.centrocultural.Service.User;

import com.example.centrocultural.Entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deteById(int theId);
}
