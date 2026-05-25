/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserLoginIT {

    // Test successful registration
    @Test
    public void testRegisterUserSuccess() {

        UserLogin instance = new UserLogin();

        String result = instance.registerUser(
                "kyl_1",
                "Password1!",
                "Kyle",
                "Smith"
        );

        assertEquals(
                "User successfully registered.",
                result
        );
    }

    // Test invalid username
    @Test
    public void testRegisterUserUsernameFail() {

        UserLogin instance = new UserLogin();

        String result = instance.registerUser(
                "kyle123",
                "Password1!",
                "Kyle",
                "Smith"
        );

        assertEquals(
                "Username is incorrectly formatted.",
                result
        );
    }

    // Test invalid password
    @Test
    public void testRegisterUserPasswordFail() {

        UserLogin instance = new UserLogin();

        String result = instance.registerUser(
                "kyl_1",
                "password",
                "Kyle",
                "Smith"
        );

        assertEquals(
                "Password does not meet complexity requirements.",
                result
        );
    }

    // Test successful login
    @Test
    public void testLoginUserSuccess() {

        UserLogin instance = new UserLogin();

        // Register first
        instance.registerUser(
                "kyl_1",
                "Password1!",
                "Kyle",
                "Smith"
        );

        boolean result = instance.loginUser(
                "kyl_1",
                "Password1!"
        );

        assertTrue(result);
    }

    // Test failed login
    @Test
    public void testLoginUserFail() {

        UserLogin instance = new UserLogin();

        // Register first
        instance.registerUser(
                "kyl_1",
                "Password1!",
                "Kyle",
                "Smith"
        );

        boolean result = instance.loginUser(
                "wrongUser",
                "wrongPass"
        );

        assertFalse(result);
    }

    // Test login status success
    @Test
    public void testReturnLoginStatusSuccess() {

        UserLogin instance = new UserLogin();

        instance.registerUser(
                "kyl_1",
                "Password1!",
                "Kyle",
                "Smith"
        );

        String result =
                instance.returnLoginStatus(true);

        assertEquals(
                "Welcome Kyle Smith, it is great to see you again!",
                result
        );
    }

    // Test login status fail
    @Test
    public void testReturnLoginStatusFail() {

        UserLogin instance = new UserLogin();

        String result =
                instance.returnLoginStatus(false);

        assertEquals(
                "Username or password incorrect.",
                result
        );
    }
}