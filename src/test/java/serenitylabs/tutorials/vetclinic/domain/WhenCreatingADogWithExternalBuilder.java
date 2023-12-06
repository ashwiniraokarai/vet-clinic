package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

//Calls an external builder in the test directory that's separate from the domain class
//The mandatory and optional fields logic isn't a focus here therefore that logic has been tweaked to remove complications
public class WhenCreatingADogWithExternalBuilder {
    @Test
    public void can_build_dog_from_external_builder() {
        String name = "brownie";
        String breed = "poodle";
        LocalDateTime birthday = LocalDateTime.now();

        DogOnly brownie = ExternalDogBuilder.aDog()
                                                    .named(name)
                                                    .ofBreed(breed)
                                                    .bornOn(birthday)
                                                    .build();

        Assertions.assertThat(brownie.getName()).isEqualTo(name);
        Assertions.assertThat(brownie.getBreed()).isEqualTo(breed);
        Assertions.assertThat(brownie.getBirthday()).isEqualTo(birthday);
    }

    //Calls an external builder and a prototype method meant to build a large dog conveniently
    @Test
    public void can_build_large_dog_from_prototype_builder_method() {
        String name = "bollo";
        String breed = "husky";
        LocalDateTime birthday = LocalDateTime.now();

        DogOnly brownie = ExternalDogBuilder.aLargeDog()
                .named(name)  //no longer forcing .named() to return a breeder interface type (to accommodate the prototype method demo)
               // .ofBreed(breed)  //skip calling this because breed is already pre-integrated in the prototype method
                .bornOn(birthday) //no longer forcing .named() to return a breeder interface type (to accommodate the prototype method demo)
                .build();

        Assertions.assertThat(brownie.getName()).isEqualTo(name);
        Assertions.assertThat(brownie.getBreed()).isEqualTo(breed);
        Assertions.assertThat(brownie.getBirthday()).isEqualTo(birthday);
    }

    //Cal;s an external builder and a prototype method meant to build a small dog conveniently
    @Test
    public void can_build_small_dog_from_prototype_builder_method() {
        String name = "charlie";
        String breed = "poodle";
        LocalDateTime birthday = LocalDateTime.now();

        DogOnly brownie = ExternalDogBuilder.aSmallDog()
                .named(name)  //no longer forcing .named() to return a breeder interface type (to accommodate the prototype method demo)
                // .ofBreed(breed)  //skip calling this because breed is already pre-integrated in the prototype method
                .bornOn(birthday) //no longer forcing .named() to return a breeder interface type (to accommodate the prototype method demo)
                .build();

        Assertions.assertThat(brownie.getName()).isEqualTo(name);
        Assertions.assertThat(brownie.getBreed()).isEqualTo(breed);
        Assertions.assertThat(brownie.getBirthday()).isEqualTo(birthday);
    }
}
