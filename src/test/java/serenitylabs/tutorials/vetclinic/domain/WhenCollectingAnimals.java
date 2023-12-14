package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenCollectingAnimals {
    @Test
    public void a_dog_can_complain(){
      Dog lucy =  Dog.called("lucy").ofBreed("husky").andOfColour("white");
      lucy.complain();

      assertThat(lucy.complain(), equalTo("grrr"));
    }

    @Test
    public void a_cat_can_complain(){
        Cat chook =  Cat.called("chook").ofBreed("russian blue").andOfColour("ginger");
        assertThat(chook.complain(), equalTo("meow"));
    }

    public void all_animals_can_complain(){
        List<Animal> animals = new ArrayList<Animal>();
        Animal lucy =  Dog.called("lucy").ofBreed("husky").andOfColour("white");
        Animal chook =  Cat.called("chook").ofBreed("russian blue").andOfColour("ginger");

        animals.add(lucy);
        animals.add(chook);

        for(Animal animal : animals){
            animal.complain();
        }
    }
}
