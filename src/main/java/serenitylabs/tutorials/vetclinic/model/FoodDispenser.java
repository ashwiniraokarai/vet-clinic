package serenitylabs.tutorials.vetclinic.model;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;
import java.util.Map;

public class FoodDispenser {
    private static Map<Breed, Integer> FOOD_GRAMS = new HashMap<Breed, Integer>();
    private static Map<Breed, PetFood> FOOD_TYPE = new HashMap<Breed, PetFood>();
    static{
        FOOD_GRAMS.put(Breed.Dog, 20);
        FOOD_GRAMS.put(Breed.Cat, 10);

        FOOD_TYPE.put(Breed.Dog, PetFood.FidosFood);
        FOOD_TYPE.put(Breed.Cat, PetFood.KittyKat);
    }

/*
//  this method was eliminated/ replaced with feedAnyPet(Pet pet) that can handle conditions without needing if-ladder
// breed of pet is still inferred via pet.getBreed() but MAPS help pull the right data for the pet instead of the if-ladder
   public void feed(Pet pet) {
        if (pet.getBreed() == Breed.Cat) {
            feedCat(pet);
        } else if (pet.getBreed() == Breed.Dog) {
            feedDog(pet);
        }
    }*/

/*    //this method now acts simply as a wrapper method/ connector from PetHotel to FoodDispenser and does not provide any additional value
    //So we make PetHotel call the pet.eat() method directly
    public void feedAnyPet(Pet pet){
        pet.eat(makeMealForPet(pet));
    }*/

 /*
 // For a scalable design, these two methods were refactored to combine into one common method feed(Pet pet)
    private void feedDog(Pet pet) {
    //refactored below to call pet.eat with a new Meal:   pet.feed(20 * pet.getWeightInKilos(), PetFood.FidosFood);
    //refactored again here below to pull parameter value (new Meal) from another method: pet.eat(new Meal(20 * pet.getWeightInKilos(), PetFood.FidosFood));
        pet.eat(makeMealForPet(pet));
    }

    private void feedCat(Pet pet) {
        pet.eat(makeMealForPet(pet));
    }*/

    public Meal makeMealForPet(Pet pet){
        //refactored below to use Maps to pull parameter values from:   return new Meal(20 * pet.getWeightInKilos(), PetFood.FidosFood);
       //refactored once more to use wrapper methods to pull parameter values from: return new Meal(PET_AND_FOOD_GRAMS.get(pet.getBreed()) * pet.getWeightInKilos());
        return new Meal(withRightQuantity(pet), withRightFoodType(pet));
    }

    private Double withRightQuantity(Pet pet){
        return FOOD_GRAMS.get(pet.getBreed()) * pet.getWeightInKilos();
    }

    private PetFood withRightFoodType(Pet pet){
        return FOOD_TYPE.get(pet.getBreed());
    }

  /*
  //For a scalable design, these two methods were refactored to combine into one common method makeMealForPet(Pet pet)
  private Meal makeMealForDog(Pet pet){
        //refactored:   return new Meal(20 * pet.getWeightInKilos(), PetFood.FidosFood);
        return new Meal(PET_AND_FOOD_GRAMS.get(pet.getBreed()) * pet.getWeightInKilos(), PET_AND_FOOD_TYPE.get(pet.getBreed()));
    }

    private Meal makeMealForCat(Pet pet){
    // refactored:       return new Meal(10 * pet.getWeightInKilos(), PetFood.KittyKat);
        return new Meal(PET_AND_FOOD_GRAMS.get(pet.getBreed()) * pet.getWeightInKilos(), PET_AND_FOOD_TYPE.get(pet.getBreed()));
    }*/
}
