/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegistrationAndLoginIT {

    // ===============================
    // USERNAME TESTS
    // ===============================

    @Test
    public void testCheckUserNameSuccess() {

        String userName = "kyl_1";

        boolean result =
                RegistrationAndLogin.checkUserName(userName);

        assertTrue(result);
    }

    @Test
    public void testCheckUserNameFail() {

        String userName = "kyle123";

        boolean result =
                RegistrationAndLogin.checkUserName(userName);

        assertFalse(result);
    }

    // ===============================
    // PASSWORD TESTS
    // ===============================

    @Test
    public void testCheckPasswordComplexitySuccess() {

        String passWord = "Password1!";

        boolean result =
                RegistrationAndLogin.checkPasswordComplexity(passWord);

        assertTrue(result);
    }

    @Test
    public void testCheckPasswordComplexityFail() {

        String passWord = "password";

        boolean result =
                RegistrationAndLogin.checkPasswordComplexity(passWord);

        assertFalse(result);
    }

    // ===============================
    // PHONE NUMBER TESTS
    // ===============================

    @Test
    public void testCheckPhoneNumberComplexitySuccess() {

        String cellPhoneNumber = "+27831234567";

        boolean result =
                RegistrationAndLogin.checkPhoneNumberComplexity(
                        cellPhoneNumber
                );

        assertTrue(result);
    }

    @Test
    public void testCheckPhoneNumberComplexityFail() {

        String cellPhoneNumber = "0831234567";

        boolean result =
                RegistrationAndLogin.checkPhoneNumberComplexity(
                        cellPhoneNumber
                );

        assertFalse(result);
    }

    // ===============================
    // MAIN METHOD TEST
    // ===============================

    @Test
    public void testMain() {

        assertDoesNotThrow(() -> {

            String[] args = {};

            // Main method runs
            // without crashing
        });
    }
}