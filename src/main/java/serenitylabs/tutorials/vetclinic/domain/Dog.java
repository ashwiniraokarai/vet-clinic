package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {
    private String name, breed, dateOfBirth ;
    public Dog(String name, String breed, String dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName(){
        return name;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getBreed(){
        return breed;
    }

    public static DogBreeder called(String name) {
        return new DogBreeder(name);
    }

    public static class DogBreeder {
        public String name, breed, dateOfBirth;

        public DogBreeder(String name){
            this.name = name;
        }

        public DogBreeder ofBreed(String breed){
            this.breed  = breed;
            return this;
        }

        public Dog bornOn(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return new Dog(name, breed, dateOfBirth);
        }
    }
}
