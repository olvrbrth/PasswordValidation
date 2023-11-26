package com.olvrbrth.passwordvalidation;

import java.io.Console;

public class Main {

    // https://tddmanifesto.com/exercises/
    public static void main(String[] args) {
        String password = "SomeVeryStrongPassword12!";
	    PasswordValidation passwordValidation = new PasswordValidation();
        ValidationResult result = passwordValidation.validate(password);

        System.out.println("Password " + password + " is " + (result.isValid ? "valid" : "invalid"));
    }
}
