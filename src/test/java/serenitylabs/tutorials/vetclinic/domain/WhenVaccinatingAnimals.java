package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenVaccinatingAnimals {
    @Test
    public void dogs_have_vaccination_due_date(){
        Dog lucy = Dog.called("lucy").ofBreed("husky").andOfColour("white");
        LocalDate expectedDueDate = LocalDate.now().plusMonths(6);

        lucy.setLastVaccinatedDate(LocalDate.now());
        assertThat(lucy.nextVaccineDueIn(), equalTo(expectedDueDate));
    }

    @Test
    public void cats_have_vaccination_due_date(){
        Cat chook = Cat.called("chook").ofBreed("russian blue").andOfColour("ginger");
        LocalDate expectedDueDate = LocalDate.now().plusYears(1);

        chook.setLastVaccinatedDate(LocalDate.now());
        assertThat(chook.nextVaccineDueIn(), equalTo(expectedDueDate));
    }

    @Test
    public void vaccine_eligible_animals_have_vaccination_due_date(){
        List<VaccineEligible> vaccineEligibleAnimals = new ArrayList<VaccineEligible>();
        Dog lucy = Dog.called("lucy").ofBreed("husky").andOfColour("white");
        Cat chook = Cat.called("chook").ofBreed("russian blue").andOfColour("ginger");

        vaccineEligibleAnimals.add(lucy);
        vaccineEligibleAnimals.add(chook);

        for(VaccineEligible vaccineEligibleAnimal : vaccineEligibleAnimals){
            vaccineEligibleAnimal.setLastVaccinatedDate(LocalDate.now());
        }

        assertThat(vaccineEligibleAnimals.get(0).nextVaccineDueIn(), equalTo(LocalDate.now().plusMonths(6)));
        assertThat(vaccineEligibleAnimals.get(1).nextVaccineDueIn(), equalTo(LocalDate.now().plusYears(1)));

    }

    @Test
    public void frogs_do_not_have_vaccination_due_date(){

    }
}
