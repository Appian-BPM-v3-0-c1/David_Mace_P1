package com.revature.autoparts.services;

import com.revature.autoparts.daos.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService userService = new UserService(new UserDAO());

    @Test
    void isValidUsername() {
        Assertions.assertEquals(false, userService.isValidUsername("jimbo"));
        Assertions.assertEquals(false, userService.isValidUsername(""));
        Assertions.assertEquals(false, userService.isValidUsername("teri74-`"));
        Assertions.assertEquals(false, userService.isValidUsername("Jack Black"));
        Assertions.assertEquals(true, userService.isValidUsername("testAccount"));

    }

    @Test
    void isValidPassword() {
        Assertions.assertEquals(false, userService.isValidUsername("dfsdf"));
        Assertions.assertEquals(false, userService.isValidUsername(""));
        Assertions.assertEquals(false, userService.isValidUsername("fake-password"));
        Assertions.assertEquals(false, userService.isValidUsername("not-a-realPassword"));
        Assertions.assertEquals(true, userService.isValidUsername("123test!@#TEST"));

    }
}