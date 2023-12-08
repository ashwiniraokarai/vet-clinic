package serenitylabs.tutorials.vetclinic.domain;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Dog {
    private final String name;
    private final String breed;
    private final List<String> colour;

    public Dog(String name, String breed, List<String> colour) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public List<String> getColour() {
        return colour;
    }

    @Override
    public String toString(){
//     return "Fido the black labrador";
        return name + " the " + (colour + " "  + breed).toLowerCase();
    }

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {
        private final String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        //the ellipsis denote unspecified number of arguments. Caller can pass any number of colors.
        //the values are recognized as a String array (String []) by default but we choose to copy it  into a List using ImmutableList.copyOf(colour)
        public Dog andOfColour(String... colour) {
            return new Dog(name, breed, ImmutableList.copyOf(colour));
        }
    }
}
