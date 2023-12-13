package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

//This test class shows how to work your way up to accomplish Basic Polymorphism with Inheritance
public class WhenCollectingAnimals {
    @Test
    public void aListOfAnimalsCanContainBothCatAndDog(){
        List<Animal> animals = new ArrayList<Animal>();

        Animal bollo = Dog.called("bollo").ofBreed("husky").andOfColour("black");
        Animal gek = Cat.called("gek").ofBreed("russian cat").andOfColour("ginger");

        animals.add(bollo);
        animals.add(gek);

        //hamcrest matcher
        assertThat(animals, contains(bollo, gek));

        //can access stored animals in the list
        for(Animal animal : animals){
    /*    //  to get this to work, the methods would have to be defined on the Parent type but they are defined on the sub types
            animal.getName();
            animal.getBreed();
            animal.getColour();*/
        }
    }

  /*  //this test no longer passes after refactoring  the complain() method to polymorph()
    //complain() method is now an abstract method on the Animal with concrete implementations on the sub types
    @Test
    public void allAnimalsComplainTheSameWay(){
        List<Animal> animals = new ArrayList<Animal>();

        Animal bollo = Dog.called("bollo").ofBreed("husky").andOfColour("black");
        Animal gek = Cat.called("gek").ofBreed("russian cat").andOfColour("ginger");

        animals.add(bollo);
        animals.add(gek);

        //hamcrest matcher
        assertThat(animals, contains(bollo, gek));

        for(Animal animal : animals){
            //can call animal.complain() because complain is defined on the animal class
            //the downside is that there's only one behavior so all Animals behave the same way (Dogs and Cats are limited to complaining in one way)
            assertThat(animal.complain(), equalTo("generic animal noise"));
        }
    }*/

    @Test
    public void eachAnimalInTheListComplainsInItsOwnStyle(){
        List<Animal> animals = new ArrayList<Animal>();

        Animal bollo = Dog.called("bollo").ofBreed("husky").andOfColour("black");
        Animal gek = Cat.called("gek").ofBreed("russian cat").andOfColour("ginger");

        animals.add(bollo);
        animals.add(gek);

        //hamcrest matcher
        assertThat(animals, contains(bollo, gek));

        for(Animal animal : animals){
            //complain() is a polymorphic method
            animal.complain();
            assertThat(animal.complain(), not(equalTo("generic animal noise")));
        }

        assertThat(bollo.complain(), equalTo("grrr"));
        assertThat(gek.complain(), equalTo("meow"));
    }

}
