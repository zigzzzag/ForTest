package com.mnikiforov.javax.validation;

import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class UserTest {

    @Test
    public void constraintTest() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        User user = new User();
        user.setWorking(false);
        user.setAboutMe("about me!");
        user.setAge(9);
        user.setEmail("email");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

}