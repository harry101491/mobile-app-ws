package com.harshit.mobileappws.service;

import com.harshit.mobileappws.model.User;
import com.harshit.mobileappws.model.request.UserDetailRequestModel;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User createUser(UserDetailRequestModel userDetailRequestModel) {
        return new User(userDetailRequestModel.getFirstName(), userDetailRequestModel.getAge());
    }
}
