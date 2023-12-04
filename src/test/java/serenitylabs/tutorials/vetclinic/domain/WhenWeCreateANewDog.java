package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenWeCreateANewDog {
    @Test
    public void a_new_dog_should_have_a_name(){
        String dateOfBirth = "Dec-02-2023";
        Dog fido = new Dog("fido", "labrador", dateOfBirth);
       Assertions.assertThat(fido.getName()).isEqualTo("fido");
       Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(dateOfBirth);
    }

    @Test
    public void can_create_a_dog_with_builder(){
       final  String THE_FOURTH_OF_JULY = "Jul-04-2023";

        Dog fido = Dog.called("Fido")
                                 .ofBreed("Labrador")
                                .bornOn(THE_FOURTH_OF_JULY);

        Assertions.assertThat(fido.getName()).isEqualTo("Fido");
        Assertions.assertThat(fido.getBreed()).isEqualTo("Labrador");
        Assertions.assertThat(fido.getDateOfBirth()).isEqualTo(THE_FOURTH_OF_JULY);
    }
}
