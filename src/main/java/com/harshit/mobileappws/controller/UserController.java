package com.harshit.mobileappws.controller;


import com.harshit.mobileappws.exceptions.user.UserServiceException;
import com.harshit.mobileappws.model.User;
import com.harshit.mobileappws.model.request.UserDetailRequestModel;
import com.harshit.mobileappws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users") // http://localhost:8080/users/
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "limit") int limit) {
        return String.format("The requested user page: %d and limit is: %d", page, limit);
    }

    // Now user will get xml or json according to the request header Accept value
    @GetMapping(path = "/{userId}",
                produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        throw new UserServiceException("User Exception has occured");
    }

    // Post Mapping using request body
    @PostMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@Valid @RequestBody UserDetailRequestModel userDetailRequestModel) {
        return ResponseEntity.ok(userService.createUser(userDetailRequestModel));
    }
}
