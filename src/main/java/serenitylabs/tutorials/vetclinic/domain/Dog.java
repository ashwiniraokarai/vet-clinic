package serenitylabs.tutorials.vetclinic.domain;

public class Dog {
    private String name, breed, dateOfBirth, color, optionalFavoriteFood, optionalFavoriteToy;
    public Dog(String name, String breed, String color, String optionalFavoriteFood, String optionalFavoriteToy, String dateOfBirth) {
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

    public interface WithBreed{
        public WithColor ofBreed(String breed);
    }

    public interface WithColor{
        public DogBreeder ofColor(String color);
    }

    //The first method the caller (test) calls to build a Dog object
    public static WithBreed named(String name) {
        return new DogBreeder(name);
    }

    public static class DogBreeder implements WithBreed, WithColor{
        public String name, breed, dateOfBirth, color, optionalFavoriteFood, optionalFavoriteToy;

        public DogBreeder(String name){
            this.name = name;
        }

        public WithColor ofBreed(String breed){
            this.breed  = breed;
            return this;
        }

        public DogBreeder ofColor(String color){
            this.color = color;
            return this;
        }

        public DogBreeder likesToEat(String optionalFavoriteFood){
            this.optionalFavoriteFood = optionalFavoriteFood;
            return this;
        }

        public DogBreeder likesToPlayWith(String optionalFavoriteToy){
            this.optionalFavoriteToy = optionalFavoriteToy;
            return this;
        }

        public Dog bornOn(String dateOfBirth){
            this.dateOfBirth = dateOfBirth;
            return new Dog(name, breed, color, optionalFavoriteFood, optionalFavoriteToy, dateOfBirth);
        }
    }
}
