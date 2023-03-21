package by.bsuir.validation;

import by.bsuir.Customer;

import java.util.function.BiPredicate;
import java.util.regex.Pattern;

public class CustomerValidator implements EntityValidator<Customer> {

    private static final String TEXT_PATTERN = "[A-Za-z]{2,40}";
    private static final String ADDRESS_PATTERN = "[0-9A-Za-z]{2,40}";

    @Override
    public ValidationResult validate(Customer customer) {
        ValidationResult result = new ValidationResult();
        BiPredicate<String, String> validationPredicate = (pattern, valueToCheck) -> !Pattern.matches(pattern, valueToCheck);
            if (validationPredicate.test(TEXT_PATTERN, customer.getName())) {
                ValidationResult.ValidationError error = new ValidationResult.ValidationError();
                error.setFieldIdentifier("NameErr");
                error.setErrorMessage("Invalid name, it should contain only latin characters");
                result.getErrors().add(error);
            }
            if (validationPredicate.test(TEXT_PATTERN, customer.getSurname())) {
                ValidationResult.ValidationError error = new ValidationResult.ValidationError();
                error.setFieldIdentifier("SurnameErr");
                error.setErrorMessage("Invalid surname, it should contain only latin characters");
                result.getErrors().add(error);
            }
            if (validationPredicate.test(TEXT_PATTERN, customer.getCity())) {
                ValidationResult.ValidationError error = new ValidationResult.ValidationError();
                error.setFieldIdentifier("CityErr");
                error.setErrorMessage("Invalid city, it should contain only latin characters");
                result.getErrors().add(error);
            }
            if (customer.getCreditLimit() < 0 || customer.getCreditLimit() > 100000) {
                ValidationResult.ValidationError error = new ValidationResult.ValidationError();
                error.setFieldIdentifier("CreditLimitErr");
                error.setErrorMessage("Invalid credit limit, it should be greater than 0 and less than 100000");
                result.getErrors().add(error);
            }
            if (validationPredicate.test(ADDRESS_PATTERN, customer.getMainAddress())) {
                ValidationResult.ValidationError error = new ValidationResult.ValidationError();
                error.setFieldIdentifier("MainAddressErr");
                error.setErrorMessage("Invalid main address, it should contain only latin characters and digits");
                result.getErrors().add(error);
            }
            if (!customer.getAdditionalAddress().isBlank() && validationPredicate.test(ADDRESS_PATTERN, customer.getAdditionalAddress())) {
                ValidationResult.ValidationError error = new ValidationResult.ValidationError();
                error.setFieldIdentifier("AdditionalAddressErr");
                error.setErrorMessage("Invalid additional address, it should contain only latin characters and digits");
                result.getErrors().add(error);
            }
        return result;
    }
}
