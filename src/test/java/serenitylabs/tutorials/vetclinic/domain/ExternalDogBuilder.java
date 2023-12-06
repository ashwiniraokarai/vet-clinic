package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class ExternalDogBuilder implements ExternalInterfaceRequiredBreed, ExternalInterfaceRequiredBirthday {
    private String name, breed, optionalFavoriteFood;
    private LocalDateTime birthday;

    //this static method that is an entry point for the calling code (test) to start its chain of calls with
    public static ExternalDogBuilder aDog(){
        return new ExternalDogBuilder();
    }

    public ExternalDogBuilder named(String name){
        this.name = name;
        return this;
    }

    public ExternalDogBuilder ofBreed(String breed){
        this.breed = breed;
        return this;
    }

    //prototype method (a more specific/ pretailored dog profile
    public static ExternalDogBuilder aLargeDog(){
        return aDog().ofBreed("husky");
    }

    public static ExternalDogBuilder aSmallDog(){
        return aDog().ofBreed("poodle");
    }

    public ExternalDogBuilder bornOn(LocalDateTime birthday){
        this.birthday = birthday;
        return this;
    }

    public ExternalDogBuilder  likesToEat(String optionalFavoriteFood){
        this.optionalFavoriteFood = optionalFavoriteFood;
        return this;
    }

    //instantiate a DogContainingBuilder object with the params bubbled up, and return it to caller code (the test)
    public DogOnly build(){
        return new DogOnly(name, breed, birthday, optionalFavoriteFood);
    }
}
