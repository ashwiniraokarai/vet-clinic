package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

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
    }
}
