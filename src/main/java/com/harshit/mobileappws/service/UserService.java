package com.harshit.mobileappws.service;

import com.harshit.mobileappws.model.User;
import com.harshit.mobileappws.model.request.UserDetailRequestModel;

public interface UserService {
    User createUser(UserDetailRequestModel userDetailRequestModel);
}
