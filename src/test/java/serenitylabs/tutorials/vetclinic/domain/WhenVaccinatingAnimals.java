package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenVaccinatingAnimals {
    //A cat can find its next vaccination due date

    @Test
    public void cats_have_vaccine_due_in_one_year(){
       LocalDate  expectedVaccineDueDate = LocalDate.now().plusYears(1);

        Cat cat = Cat.called("chook").ofBreed("russian blue").andOfColour("blue");
        cat.setLastVaccinatedOnDate(LocalDate.now());

        assertThat(cat.nextVaccineDueIn(), equalTo(expectedVaccineDueDate));
    }

    @Test
    public void dogs_have_vaccine_due_in_six_months(){
        LocalDate expectedDueDate = LocalDate.now().plusMonths(6);

        Dog dog = Dog.called("bollo").ofBreed("husky").andOfColour("gray");
        dog.setLastVaccinatedOnDate(LocalDate.now());

        assertThat(dog.nextVaccineDueIn(), equalTo(expectedDueDate));
    }

    //Animals Dog and Cat have Vaccine Due Dates
    // both setNextVaccineDue() and nextVaccineDue() methods are now a polymorphic methods through a common VaccinationEligible interface
    @Test
    public void some_animals_have_vaccine_due_dates(){
        //Empty list to store Vaccine Eligibles
        List<VaccinationEligible> vaccinatedAnimals = new ArrayList<VaccinationEligible>();

        //Note how Cat and Dog are referred not by Class Animal type but  by the type of Interface they implement
        VaccinationEligible lucy = Dog.called("lucy").ofBreed("husky").andOfColour("black");
        VaccinationEligible gek = Cat.called("gek").ofBreed("russian blue").andOfColour("green");

        vaccinatedAnimals.add(lucy);
        vaccinatedAnimals.add(gek);

        LocalDate lucyExpectedDueDate = LocalDate.now().plusMonths(6);
        LocalDate gekExpectedDueDate = LocalDate.now().plusYears(1);

        for(VaccinationEligible vaccinated: vaccinatedAnimals){
            vaccinated.setLastVaccinatedOnDate(LocalDate.now());
        }

        assertThat(vaccinatedAnimals.get(0).nextVaccineDueIn(), equalTo(lucyExpectedDueDate));
        assertThat(vaccinatedAnimals.get(1).nextVaccineDueIn(), equalTo(gekExpectedDueDate));
    }

    //This is to clarify that not all Animals (or Animal Sub Types) get vaccines
    @Test
    public void frogs_do_not_have_vaccine_due_dates(){
            Animal hopper  = Frog.called("gek").ofBreed("glass frog").andOfColour("lime green");

/*            //Call to these methods don't resolve because Frog does not implement the VaccineEligible interface
            hopper.setLastVaccinatedOnDate(LocalDate.now());
            hopper.nextVaccineDueIn();*/
    }
}
