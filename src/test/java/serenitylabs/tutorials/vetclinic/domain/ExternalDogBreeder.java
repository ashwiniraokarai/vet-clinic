package serenitylabs.tutorials.vetclinic.domain;

//Builder Class
public class ExternalDogBreeder implements WithBreed, WithColor {
    public String name, breed, dateOfBirth, color, optionalFavoriteFood, optionalFavoriteToy;

    //Add a static entry point method that can be called directly on this class by the test
    //The method will in turn create an object of this very class ("self-instantiated")


    //generic dog
    public static ExternalDogBreeder aDog(){
        return new ExternalDogBreeder();
    }


    //small dog ("prototype")
    public static ExternalDogBreeder aSmallDog(){
        return new ExternalDogBreeder().ofBreed("Poodle");
    }

    public static ExternalDogBreeder aLargeDog(){
        return new ExternalDogBreeder().ofBreed("Husky");
    }

    public static ExternalDogBreeder aGuardDog(){
        return new ExternalDogBreeder().ofBreed("German Shepherd");
    }

    public ExternalDogBreeder named(String name){
        this.name = name;
        return this;
    }

    public ExternalDogBreeder ofBreed(String breed){
        this.breed  = breed;
        return this;
    }

    public ExternalDogBreeder ofColor(String color){
        this.color = color;
        return this;
    }

    public ExternalDogBreeder likesToEat(String optionalFavoriteFood){
        this.optionalFavoriteFood = optionalFavoriteFood;
        return this;
    }

    public ExternalDogBreeder likesToPlayWith(String optionalFavoriteToy){
        this.optionalFavoriteToy = optionalFavoriteToy;
        return this;
    }

    public DogOnly bornOn(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
        return new DogOnly(name, breed, color, optionalFavoriteFood, optionalFavoriteToy, dateOfBirth);
    }
}