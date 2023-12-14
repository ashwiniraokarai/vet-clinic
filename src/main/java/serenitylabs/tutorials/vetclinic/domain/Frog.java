package serenitylabs.tutorials.vetclinic.domain;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Frog extends Animal {
    private final String name;
    private final String breed;
    private final List<String> colour;

    public Frog(String name, String breed, List<String> colour) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + " the " + (Joiner.on(" and").join(colour) + " " + breed).toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public List<String> getColour() {
        return new ArrayList(colour);
    }

    @Override
    public String complain() {
        return "croak";
    }


    public static FrogBuilder called(String name) {
        return new FrogBuilder(name);
    }


    public static class FrogBuilder {
        private final String name;
        private String breed;

        public FrogBuilder(String name) {
            this.name = name;
        }

        public FrogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Frog andOfColour(String... colour) {
            return new Frog(name, breed, ImmutableList.copyOf(colour));
        }
    }
}
