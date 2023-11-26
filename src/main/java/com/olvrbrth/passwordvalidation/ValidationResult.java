package com.olvrbrth.passwordvalidation;

import java.util.Objects;

public class ValidationResult {
    public final boolean isValid;
    public final String errorMsg;

    private ValidationResult() {
        this(true, "");
    }

    private ValidationResult(String errorMsg) {
        this(false, errorMsg);
    }

    public static ValidationResult Ok() {
        return new ValidationResult();
    }

    public static ValidationResult Error(String errorMsg) {
        return new ValidationResult(errorMsg);
    }

    private ValidationResult(boolean isValid, String errorMsg) {
        this.isValid = isValid;
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValidationResult that = (ValidationResult) o;
        return isValid == that.isValid && Objects.equals(errorMsg, that.errorMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isValid, errorMsg);
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "isValid=" + isValid +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
