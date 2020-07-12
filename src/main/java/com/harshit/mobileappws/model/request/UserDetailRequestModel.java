package com.harshit.mobileappws.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// To validate the UserDetailRequestModel we will use hibernate validator and bean validators
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailRequestModel {
    // adding not null validation that first name should not be null
    // message will be shown when bad request will occur due to
    // wrong value passed by user
    @NotNull(message = "First Name cannot be null")
    private String firstName;

    private String lastName;

    @NotNull(message = "Email cannot be null")
    private String email;

    private Integer age;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, max = 16, message = "Password length should be in 8 to 16 character")
    private String password;
}
