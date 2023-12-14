package serenitylabs.tutorials.vetclinic.domain;

import com.google.common.collect.ImmutableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal implements VaccinationEligible {
    private final String name;
    private final String breed;
    private final List<String> colour;
    private LocalDate lastVaccinatedOnDate;

    public Cat(String name, String breed, List<String> colour) {

        this.name = name;
        this.breed = breed;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return name + " the " + (colour + " " + breed).toLowerCase();
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
        return "meow";
    }

    @Override
    public void setLastVaccinatedOnDate(LocalDate lastVaccinatedOnDate){
        this.lastVaccinatedOnDate = lastVaccinatedOnDate;
    }

    @Override
    public LocalDate nextVaccineDueIn() {

        return lastVaccinatedOnDate.plusYears(1);
    }

    public static CatBuilder called(String name) {
        return new CatBuilder(name);
    }


    public static class CatBuilder {
        private final String name;
        private String breed;

        public CatBuilder(String name) {
            this.name = name;
        }

        public CatBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Cat andOfColour(String... colour) {
            return new Cat(name, breed, ImmutableList.copyOf(colour));
        }
    }
}
