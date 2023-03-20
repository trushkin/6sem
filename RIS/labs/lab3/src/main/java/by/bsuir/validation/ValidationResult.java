package by.bsuir.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

    private List<ValidationError> errors = new ArrayList<>();

    public List<ValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<ValidationError> errors) {
        this.errors = errors;
    }

    public static class ValidationError {
        private String fieldIdentifier;
        private String errorMessage;

        public String getFieldIdentifier() {
            return fieldIdentifier;
        }

        public void setFieldIdentifier(String fieldIdentifier) {
            this.fieldIdentifier = fieldIdentifier;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
