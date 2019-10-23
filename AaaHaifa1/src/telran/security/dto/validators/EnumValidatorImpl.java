package telran.security.dto.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

    private List<String> valueList = null;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return null == value || valueList.contains(value.toUpperCase());
    }

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        valueList = new ArrayList<>();
        Class<? extends Enum<?>> enumClazz = constraintAnnotation.enumClass();


        Enum[] enumValArr = enumClazz.getEnumConstants();

        for (Enum enumVal : enumValArr) {
            valueList.add(enumVal.toString().toUpperCase());
        }

    }
}

