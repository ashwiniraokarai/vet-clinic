package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {
  /*  Stage 1: Letting objects be created with default constructors, then set values thro setters
    private String name, breed, dateOfBirth;
    private LocalDateTime birthday;

    public void setName(String name){
        this.name = name;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }*/

 /*   // Stage 2: Limiting value setting through constructor parameters, no setters to set values a second time
    //We now have an immutable Dog class
    // Not necessary to set em to final but it helps with readability
    private final String name, breed;
    private final LocalDateTime birthday;
    private final String optionalFavoriteFood;

    //this constructor is meant for those callers that only want to initialize the required fields
    public Dog(String name, String breed, LocalDateTime birthday){
//        this.name = name;
//        this.breed = breed;
//        this.birthday = birthday;
//        this.optionalFavoriteFood = null;

        //or you could call the second constructor instead to achieve what the code above did but more concisely
        this(name, breed, birthday, null);
    }

    //this constructor is meant for those callers that would like to initialize optional fields as well
    public Dog(String name, String breed, LocalDateTime birthday, String optionalFavoriteFood){
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.optionalFavoriteFood = optionalFavoriteFood;
    }*/

    //Stage 3: The builder pattern
    //this method is meant for those callers that don't want to call the constructor and prefer the Builder pattern instead
    private String name, breed;
    LocalDateTime birthday;

    //a constructor that the calling code (test) won't call but the Builder class will, via the .build() method
    public Dog (String name, String breed, LocalDateTime birthday){
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
    }

    //the static method that calling code (test) will call
    public static DogBuilder called(String name){
        return new DogBuilder(name);
    }

//  The builder class is an inner class responsible for building a Dog object
    public static class DogBuilder {
    private String name, breed;
    private LocalDateTime birthday;

        public DogBuilder(String name){
            //automatically returns a DogBuilder object (ajka "this") just like any constructor
            this.name = name;
        }

        //set the value, return the current builder object
        public DogBuilder ofBreed(String breed){
            this.breed = breed;
            return this;
        }

    //set the value, return the current builder object
        public DogBuilder bornOn(LocalDateTime birthday){
            this.birthday = birthday;
            return this;
        }

        //instantiate a Dog object with the params bubbled up, and return it to caller code (the test)
        public Dog build(){
            return new Dog(name, breed, birthday);
        }
    }

    //Moved all getters of Dog class to the bottom so they don't interfere when a human reads thro the Builder pattern and overall code evolution
    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public LocalDateTime getBirthday() {
        return this.birthday;
    }

/*    public String getOptionalFavoriteFood() {
        return optionalFavoriteFood;
    }*/

}
