/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// ===============================
// LOGIN CLASS
// UserLogin.java
// ===============================

package com.mycompany.registrationandlogin;

public class UserLogin {

    private String firstName;
    private String lastName;
    private String validUsername;
    private String validPassword;

    // Register user
    public String registerUser(
            String userName,
            String passWord,
            String firstName,
            String lastName) {

        if (!RegistrationAndLogin.checkUserName(userName)) {

            return "Username is incorrectly formatted.";
        }

        if (!RegistrationAndLogin.checkPasswordComplexity(passWord)) {

            return "Password does not meet complexity requirements.";
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.validUsername = userName;
        this.validPassword = passWord;

        return "User successfully registered.";
    }

    // Login validation
    public boolean loginUser(String userName, String passWord) {

        return userName.equals(validUsername)
                && passWord.equals(validPassword);
    }

    // Return login message
    public String returnLoginStatus(boolean status) {

        if (status) {

            return "Welcome "
                    + firstName
                    + " "
                    + lastName
                    + ", it is great to see you again!";

        } else {

            return "Username or password incorrect.";
        }
    }
}
