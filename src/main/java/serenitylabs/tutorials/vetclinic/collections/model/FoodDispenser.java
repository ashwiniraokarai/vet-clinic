package serenitylabs.tutorials.vetclinic.collections.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;
import java.util.Map;

public class FoodDispenser {
    private static Map<Breed , Integer> PET_AND_FOOD_WEIGHT_MAP = new HashMap<Breed, Integer>();
    private static Map<Breed, PetFood> PET_AND_FOOD_TYPE_MAP = new HashMap<Breed, PetFood>();

    static{
        PET_AND_FOOD_WEIGHT_MAP.put(Breed.Dog, 20);
        PET_AND_FOOD_WEIGHT_MAP.put(Breed.Cat, 10);
    }

    static{
        PET_AND_FOOD_TYPE_MAP.put(Breed.Dog, PetFood.FidosFood);
        PET_AND_FOOD_TYPE_MAP.put(Breed.Cat, PetFood.KittyKat);
    }

//    public void feed(Pet pet) {
//        pet.eat(makeNewMealFor(pet));
//    }

    public Meal makeNewMealFor(Pet pet){
        return new Meal(getRightQuantityOfFood(pet), getRightTypeOfFood(pet));
    }

    private Double getRightQuantityOfFood(Pet pet){
        return PET_AND_FOOD_WEIGHT_MAP.get(pet.getBreed()) * pet.getWeightInKilos();
    }

    private PetFood getRightTypeOfFood(Pet pet){
        return PET_AND_FOOD_TYPE_MAP.get(pet.getBreed());
    }
}
