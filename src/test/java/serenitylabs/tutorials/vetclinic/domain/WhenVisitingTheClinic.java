package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;


//When visiting the vet clinic, Animals complain
//In our test, we want to grab this complaint and register it on a ComplaintRegister
//Tip: There is a single complaint register. Every complaint goes on it. You don't need a new complaint register for every new complaint
//Next, Introduce a VetAssistant who records the complaint and registers it on a Complaint register

public class WhenVisitingTheClinic {
    List<Animal> animals = new ArrayList<Animal>();

    @Before
    public void storeAListOfAnimals(){
       Animal bollo = Dog.called("bollo").ofBreed("husky").andOfColour("black");
        Animal gek = Cat.called("gek").ofBreed("russian cat").andOfColour("ginger");

        animals.add(bollo);
        animals.add(gek);
    }

    //build a complaint register
    @Test
    public void can_register_a_complaint_from_animal(){
        ComplaintRegister complaintRegister = new ComplaintRegister();
        for(Animal animal : animals){
            complaintRegister.register(animal.complain());
        }
        assertThat(complaintRegister.getAllComplaints(), contains("grrr", "meow"));
    }

    //introduce a vetassistant who can collect a complaint from each animal and pass it along to the complaint register
    //we do this so animal can complain to the vetassistant directly
    @Test
    public void vet_assistant_can_record_complaint_and_register_to_complaint_register(){
        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant vetAssistant = new VetAssistant(complaintRegister);

        for(Animal animal: animals){
            vetAssistant.recordComplaintFrom(animal);
        }

        assertThat(complaintRegister.getAllComplaints(), contains("grrr", "meow"));

        //After that works, find a way to make sure ComplaintRegister always has a single instance inside of one of this classes?
    }
}
