package com.harshit.mobileappws.service;

import com.harshit.mobileappws.model.User;
import com.harshit.mobileappws.model.request.UserDetailRequestModel;
import com.harshit.mobileappws.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    Utils util;

    @Override
    public User createUser(UserDetailRequestModel userDetailRequestModel) {
        User newUser = new User();
        newUser.setAge(userDetailRequestModel.getAge());
        newUser.setEmail(userDetailRequestModel.getEmail());
        newUser.setFirstName(userDetailRequestModel.getFirstName());
        newUser.setLastName(userDetailRequestModel.getLastName());
        newUser.setUserId(util.generateUUID());

        return newUser;
    }
}
