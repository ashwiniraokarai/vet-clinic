package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;

public class FoodDispenser {

    static final HashMap<Breed, Double> GRAMS_PER_KILO_BY_PET = new HashMap<Breed, Double>();

    static {
        GRAMS_PER_KILO_BY_PET.put(Breed.Dog, 20.00);
        GRAMS_PER_KILO_BY_PET.put(Breed.Cat, 10.00);
    }

    static HashMap<Breed, PetFood> FOOD_TYPE_BY_PET = new HashMap<Breed, PetFood>();
    static{
        FOOD_TYPE_BY_PET.put(Breed.Dog, PetFood.FidosFood);
        FOOD_TYPE_BY_PET.put(Breed.Cat, PetFood.KittyKat);
    }

    public Meal prepareMeal(Pet pet) {
        return new Meal(appropriateAmountOfFoodFor(pet), appropriateTypeOfFoodFor(pet));
    }

    public double appropriateAmountOfFoodFor(Pet pet){
        return GRAMS_PER_KILO_BY_PET.get(pet.getBreed()) * pet.getWeightInKilos();
    }

    public PetFood appropriateTypeOfFoodFor(Pet pet){
       return FOOD_TYPE_BY_PET.get(pet.getBreed());
    }
}
