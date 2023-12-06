package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {
/*
    @Test
    public void it_should_have_a_name(){
        String name = "brownie";
        String breed = "poodle";
        LocalDateTime birthday = LocalDateTime.now();

//   Stage 1: Creating object with default constructors, then set values thro setters
    DogContainingBuilder brownie = new DogContainingBuilder();
   brownie.setName(name);
   brownie.setBreed(breed);
   brownie.setBirthday(birthday);

//       Stage 2: Creating object with constructor parameters, no setters

        DogContainingBuilder brownie = new DogContainingBuilder(name, breed, birthday);

        Assertions.assertThat(brownie.getName()).isEqualTo(name);
        Assertions.assertThat(brownie.getBreed()).isEqualTo(breed);
        Assertions.assertThat(brownie.getBirthday()).isEqualTo(birthday);
    }
*/

/*
    @Test
    public void it_should_have_an_optional_favorite_food(){
        String name = "brownie";
        String breed = "poodle";
        LocalDateTime birthday = LocalDateTime.now();
        String optionalFavoriteFood = "bone";

        DogContainingBuilder olive =new DogContainingBuilder(name, breed,birthday, optionalFavoriteFood);

        Assertions.assertThat(olive.getOptionalFavoriteFood()).isEqualTo(optionalFavoriteFood);
    }
*/

//    Stage 3: The Builder Pattern
//    Rewrite such that DogContainingBuilder instance creation gets routed  to a separate DogBuilder class via the DogContainingBuilder class
    @Test
    public void can_build_dog_from_builder() {
        String name = "brownie";
        String breed = "poodle";
        LocalDateTime birthday = LocalDateTime.now();

      DogContainingBuilder brownie = DogContainingBuilder.named(name)
                            .ofBreed(breed)
                            .bornOn(birthday)
                            .build();

/*      Deconstructed version of the above code - just to help interpert
        DogContainingBuilder.DogBuilder builder = DogContainingBuilder.called(name);
        builder = builder.ofBreed(breed);
        builder = builder.bornOn(birthday);
        brownie = builder.build();*/

        Assertions.assertThat(brownie.getName()).isEqualTo(name);
        Assertions.assertThat(brownie.getBreed()).isEqualTo(breed);
        Assertions.assertThat(brownie.getBirthday()).isEqualTo(birthday);
    }

    //name, breed and birthday are mandatory. favorite food is optional.
    @Test
    public void cannot_build_dog_without_mandatory_fields(){
       DogContainingBuilder cloud = DogContainingBuilder.named("cloud")
                .ofBreed("poodle")      //cannot build dog without breed because it's been converted to mandatory data
                .bornOn(LocalDateTime.now())    //cannot build dog without breed because it's been converted to mandatory data
                //.likesToEat("bread")  //can entirely skip setting this data/ calling this method because it remains optional
                .build();
        Assertions.assertThat(cloud.getName()).isEqualTo("cloud");
        Assertions.assertThat(cloud.getBreed()).isNotNull();
        Assertions.assertThat(cloud.getBirthday()).isNotNull();
        //Assertions.assertThat(cloud.getOptionalFavoriteFood()).isEqualTo("bread");
    }
}
