package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WhenWeCreateANewDogWithExternalBuilder {

    @Test
    public void can_build_dog_from_external_builder(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        DogOnly fido = ExternalDogBreeder.aDog()
                .named("Fido")
                .ofBreed("Labrador")
                .ofColor("black")
                .likesToEat("banana")
                .likesToPlayWith("ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getColor()).isEqualTo("black");
        Assertions.assertThat(fido.getOptionalFavoriteFood()).isEqualTo("banana");
        Assertions.assertThat(fido.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

    @Test
    public void can_build_small_dog_from_prototype_method(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        DogOnly fido = ExternalDogBreeder.aSmallDog()
                .named("Charlie")
//                .ofBreed("Labrador")   //breed comes preset with aSmallDog(), so don't call it again and defeat the purpose
                .ofColor("gray")
                .likesToEat("banana")
                .likesToPlayWith("ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Charlie");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Poodle");
        Assertions.assertThat(fido.getColor()).isEqualTo("gray");
        Assertions.assertThat(fido.getOptionalFavoriteFood()).isEqualTo("banana");
        Assertions.assertThat(fido.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

    @Test
    public void can_build_large_dog_from_prototype_method(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        DogOnly fido = ExternalDogBreeder.aLargeDog()
                .named("Bollo")
                .ofColor("gray")
                .likesToEat("banana")
                .likesToPlayWith("ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Bollo");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Husky");
        Assertions.assertThat(fido.getColor()).isEqualTo("gray");
        Assertions.assertThat(fido.getOptionalFavoriteFood()).isEqualTo("banana");
        Assertions.assertThat(fido.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

    @Test
    public void can_build_guard_dog_from_prototype_method(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        DogOnly fido = ExternalDogBreeder.aGuardDog()
                .named("Atlas")
                .ofColor("gray")
                .likesToEat("banana")
                .likesToPlayWith("ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Atlas");
        Assertions.assertThat(fido.getBreed()).isEqualTo("German Shepherd");
        Assertions.assertThat(fido.getColor()).isEqualTo("gray");
        Assertions.assertThat(fido.getOptionalFavoriteFood()).isEqualTo("banana");
        Assertions.assertThat(fido.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }
}
