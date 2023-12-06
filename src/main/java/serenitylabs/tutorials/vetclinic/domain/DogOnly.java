package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class DogOnly {
    //The builder pattern
    private String name, breed, optionalFavoriteFood;
    LocalDateTime birthday;

    //a constructor that the calling code (test) won't call but the Builder class will, via the .build() method
    public DogOnly(String name, String breed, LocalDateTime birthday, String optionalFavoriteFood){
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.optionalFavoriteFood = optionalFavoriteFood;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public LocalDateTime getBirthday() {
        return this.birthday;
    }

    public String getOptionalFavoriteFood() {
        return optionalFavoriteFood;
    }

}
