package by.bsuir.validation;


import by.bsuir.validation.ValidationResult;

public interface EntityValidator<T>
{
    ValidationResult validate(T objectToValidate);
}