package serenitylabs.tutorials.vetclinic.domain;

public class DogOnly {

    //Constructor is not called directly by the caller (test) but by the builder object (DogBreeder) routed via a static method
    private String name, breed, dateOfBirth, color, optionalFavoriteFood, optionalFavoriteToy;
    public DogOnly(String name, String breed, String color, String optionalFavoriteFood, String optionalFavoriteToy, String dateOfBirth) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.optionalFavoriteFood = optionalFavoriteFood;
        this.optionalFavoriteToy = optionalFavoriteToy;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }

    public String getColor(){
        return color;
    }

   public String getOptionalFavoriteFood(){
        return optionalFavoriteFood;
   }

    public String getOptionalFavoriteToy(){
        return optionalFavoriteToy;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }



}
