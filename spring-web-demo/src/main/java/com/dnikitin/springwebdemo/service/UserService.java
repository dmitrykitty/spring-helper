package com.dnikitin.springwebdemo.service;

import com.dnikitin.springwebdemo.exception.UserNotFoundException;
import com.dnikitin.springwebdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserService {

    private static final Map<String, User> USERS = new HashMap<>();

    public Collection<User> findAll() {
        return USERS.values();
    }

    public User findById(String id){
        var user =  USERS.get(id);

        if(user == null){
            throw new UserNotFoundException("User not found: ID = " + id);
        }
        return user;
    }

    public User create(User user){
        var id = UUID.randomUUID().toString();
        user.setId(id);

        USERS.put(id, user);
        return user;
    }

    public User update(String id, User userForUpdate){
        if(!USERS.containsKey(id)){
            throw new UserNotFoundException("User not found: ID = " + id);
        }
        userForUpdate.setId(id);
        USERS.put(id, userForUpdate);
        return userForUpdate;
    }

    public void deleteById(String id){
        USERS.remove(id);
    }
}
