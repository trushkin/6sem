package by.bsuir.validators;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("zipcodeValidator")
public class ZipCodeValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String zipCodeValue = o.toString();
        try {
            if (zipCodeValue.matches("^[1-9]\\d*$") && zipCodeValue.length() >= 4 && zipCodeValue.length() <= 6) {
                    Integer id = Integer.parseInt(zipCodeValue);
            } else {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ex) {
            FacesMessage facesMessage = new FacesMessage("ZIP CODE must be a positive integer number with length from 4 to 6 symbols!");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
}
