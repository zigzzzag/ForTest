package com.mnikiforov.javax.validation;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 100, message = "About Me must be between 10 and 100 characters")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

    @Valid
    private List<String> skills;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return working;
    }

    void setWorking(boolean working) {
        this.working = working;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
