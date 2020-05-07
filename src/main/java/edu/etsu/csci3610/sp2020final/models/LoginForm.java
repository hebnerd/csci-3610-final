/*
 * ---------------------------------------------------------------------------
 * File name: PersonForm.java
 * Project name: sp2020final
 * ---------------------------------------------------------------------------
 * Creator's name and email: Matt Harrison, harrisonms1@etsu.edu
 * Course:  CSCI 3610
 * Creation Date: 4/7/2020
 * ---------------------------------------------------------------------------
 */

package edu.etsu.csci3610.sp2020final.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotNull
    private String email;
    @NotNull
    private String password;
    private boolean wasSuccessful = true;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isWasSuccessful() {
        return wasSuccessful;
    }

    public void setWasSuccessful(boolean wasSuccessful) {
        this.wasSuccessful = wasSuccessful;
    }
}