package com.olvrbrth.passwordvalidation;

import org.junit.Assert;
import org.junit.Test;

public class PasswordValidationTest {

    @Test
    public void shouldClassExists() {
        PasswordValidation passwordValidation = new PasswordValidation();

        Assert.assertNotNull(passwordValidation);
    }

    @Test
    public void shouldReturnErrorIfLessThan8Chars() {
        PasswordValidation passwordValidation = new PasswordValidation();

        ValidationResult r = passwordValidation.validate("12345!A");

        ValidationResult expected = ValidationResult.Error("Password must be at least 8 characters");
        Assert.assertEquals(expected, r);
    }

    @Test
    public void shouldReturnNoErrorIfGreaterThanOrEquals8Chars() {
        PasswordValidation passwordValidation = new PasswordValidation();

        ValidationResult r = passwordValidation.validate("123456*A");

        ValidationResult expected = ValidationResult.Ok();
        Assert.assertEquals(expected, r);
    }

    @Test
    public void shouldReturnErrorIfLessThan2Numbers() {
        PasswordValidation passwordValidation = new PasswordValidation();

        ValidationResult r = passwordValidation.validate("1Abcdefg*");

        ValidationResult expected = ValidationResult.Error("The password must contain at least 2 numbers");
        Assert.assertEquals(expected, r);
    }

    @Test
    public void shouldReturnCombinedErrorsIfLessThan2NumbersAndLessThan8Chars() {
        PasswordValidation passwordValidation = new PasswordValidation();

        ValidationResult r = passwordValidation.validate("1abcD*");

        ValidationResult expected = ValidationResult.Error("Password must be at least 8 characters\nThe password must contain at least 2 numbers");
        Assert.assertEquals(expected, r);
    }

    @Test
    public void shouldReturnErrorIfNotContainsCapitalLetter() {
        PasswordValidation passwordValidation = new PasswordValidation();

        ValidationResult r = passwordValidation.validate("12abcdef*");

        ValidationResult expected = ValidationResult.Error("Password must contain at least one capital letter");
        Assert.assertEquals(expected, r);
    }

    @Test
    public void shouldReturnErrorIfNotContainsSpecialCharacter() {
        PasswordValidation passwordValidation = new PasswordValidation();

        ValidationResult r = passwordValidation.validate("12Abcdef");

        ValidationResult expected = ValidationResult.Error("Password must contain at least one special character");
        Assert.assertEquals(expected, r);
    }

}
