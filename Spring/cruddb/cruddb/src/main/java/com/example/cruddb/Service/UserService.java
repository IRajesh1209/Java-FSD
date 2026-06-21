package com.example.cruddb.service;

import com.example.cruddb.entity.User;
import com.example.cruddb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ ALL
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ BY ID
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    // UPDATE
    public User updateUser(String id, User newUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            user.setAge(newUser.getAge());

            return userRepository.save(user);
        }

        return null;
    }

    // DELETE
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

//This is java Apk for The Run of the an error of that with as JPA using crud Operations By as Data
//This is java Apk for The Run of the an error of that with as JPA using crud Operations By as Data
//This is java Apk for The Run of the an error of that with as JPA using crud Operations By as Data
//This is java Apk for The Run of the an error of that with as JPA using crud Operations By as Data
//This is java Apk for The Run of the an error of that with as JPA using crud Operations By as DataV
