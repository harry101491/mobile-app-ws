package controller;

import com.harshit.mobileappws.controller.UserController;
import com.harshit.mobileappws.model.User;
import com.harshit.mobileappws.model.request.UserDetailRequestModel;
import com.harshit.mobileappws.service.UserService;
import com.harshit.mobileappws.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private UserController underTest;

    @BeforeEach
    public void setup() {
        this.underTest = new UserController(userService);
    }

    @Test
    public void updateUserCallCreateUser() throws Exception {
        // Given
        UserDetailRequestModel userDetailRequestModel = new UserDetailRequestModel();
        User user = new User();
        user.setFirstName("Harshit");
        user.setLastName("Pareek");
        user.setAge(28);
        Mockito.when(userService.createUser(userDetailRequestModel)).thenReturn(user);

        // When
        ResultActions resultActions = mockMvc.perform(post("/users/1"));

        // Then
        resultActions.andExpect(status().isOk());
    }
}

