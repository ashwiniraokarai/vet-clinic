package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

public class WhenVisitingTheClinic {
    @Test
    public void animal_complaints_can_be_registered(){
        List<Animal> animals = new ArrayList<Animal>();
        Dog lucy =  Dog.called("lucy").ofBreed("husky").andOfColour("white");
        Cat chook =  Cat.called("chook").ofBreed("russian blue").andOfColour("ginger");
        ComplaintRegister complaintRegister = new ComplaintRegister();

        animals.add(lucy);
        animals.add(chook);

        for(Animal animal : animals){
            complaintRegister.registerComplaintFor(animal);
        }

         assertThat(complaintRegister.getComplaints(), contains("grrr", "meow"));
    }

    @Test
    public void vet_assistant_can_register_an_animal_complaint(){
        List<Animal> animals = new ArrayList<Animal>();
        Dog lucy =  Dog.called("lucy").ofBreed("husky").andOfColour("white");
        Cat chook =  Cat.called("chook").ofBreed("russian blue").andOfColour("ginger");

        ComplaintRegister complaintRegister = new ComplaintRegister();
       VetAssistant vetAssistant = new VetAssistant(complaintRegister);

        animals.add(lucy);
        animals.add(chook);

        for(Animal animal : animals){
            vetAssistant.record(animal);
        }

        assertThat(complaintRegister.getComplaints(), contains("grrr", "meow"));
    }
}
