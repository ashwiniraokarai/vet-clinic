package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenWeCreateANewDog {
//    @Test
//    public void a_new_dog_should_have_a_name(){
//        String dateOfBirth = "Dec-02-2023";
//        Dog fido = new Dog("fido", "labrador", dateOfBirth);
//       Assertions.assertThat(fido.getName()).isEqualTo("fido");
//       Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(dateOfBirth);
//    }

    @Test
    public void can_create_a_dog_with_required_data_using_builder(){
       final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        Dog fido = Dog.called("Fido")
                                 .ofBreed("Labrador")
                                .ofColor("black")
                                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getColor()).isEqualTo("black");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

    @Test
    public void can_add_optional_favorite_food(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")  //caller can either call likesToEat before calling bornOn after setting color
                .likesToEat("banana")
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getColor()).isEqualTo("black");
        Assertions.assertThat(fido.getOptionalFavoriteFood()).isEqualTo("banana");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

    @Test
    public void can_add_optional_favorite_toy(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")   //caller can either call likesToPlayWith or likesToEat before calling  bornOn after setting color
                .likesToPlayWith("ball")
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getColor()).isEqualTo("black");
        Assertions.assertThat(fido.getOptionalFavoriteToy()).isEqualTo("ball");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

    @Test
    public void can_build_dog_without_optional_data(){
        final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        Dog fido = Dog.called("Fido")
                .ofBreed("Labrador")
                .ofColor("black")   //caller can either call likesToPlayWith or likesToEat or neither before calling  bornOn after setting color
//                .likesToEat("banana")     //skip
//                .likesToPlayWith("ball")  //skip
                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getColor()).isEqualTo("black");
        Assertions.assertThat(fido.getOptionalFavoriteFood()).isNull();
        Assertions.assertThat(fido.getOptionalFavoriteToy()).isNull();
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }

}
