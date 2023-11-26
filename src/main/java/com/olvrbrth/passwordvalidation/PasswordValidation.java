package com.olvrbrth.passwordvalidation;

public class PasswordValidation {
    public ValidationResult validate(String password) {
        String errorMsg = "";

        if (password.length() < 8) {
            errorMsg = updateErrorMsg(errorMsg, "Password must be at least 8 characters");
        }

        long numberCount = password.chars()
                .filter(Character::isDigit)
                .count();
        if (numberCount < 2) {
            errorMsg = updateErrorMsg(errorMsg, "The password must contain at least 2 numbers");
        }

        long capitalLetterCount = password
                .chars()
                .filter(Character::isUpperCase)
                .count();
        if (capitalLetterCount < 1) {
            errorMsg = updateErrorMsg(errorMsg, "Password must contain at least one capital letter");
        }

        long specialCharacterCount = password
                .chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .count();
        if (specialCharacterCount < 1) {
            errorMsg = updateErrorMsg(errorMsg, "Password must contain at least one special character");
        }

        if (errorMsg.isEmpty()) {
            return ValidationResult.Ok();
        }

        return ValidationResult.Error(errorMsg);
    }

    private String updateErrorMsg(String errorString, String update) {
        if (!errorString.isEmpty()) {
            errorString += "\n";
        }
        errorString += update;
        return errorString;
    }
}
