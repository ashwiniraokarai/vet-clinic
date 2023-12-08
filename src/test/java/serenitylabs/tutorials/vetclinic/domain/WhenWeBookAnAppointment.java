package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class WhenWeBookAnAppointment {

    private static final LocalDateTime TODAY_AT_2_PM = LocalDateTime.now().withHour(2).withMinute(0);

    @Test
    public void an_appointment_has_a_patient_name_an_owner_and_a_date() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").at(TODAY_AT_2_PM);

//         Assertions previously written using junit:
/*        Assert.assertEquals("Fido",appointment.getPetName());
        Assert.assertEquals("Fred",appointment.getOwner());
        Assert.assertEquals(TODAY_AT_2_PM,appointment.getAppointmentTime());*/

//      Assertion refactored to Hamcrest matchers:
        assertThat(appointment.getPetName(), equalTo("Fido"));
        assertThat(appointment.getOwner(), equalTo("Fred"));
        assertThat(appointment.getAppointmentTime(), equalTo(TODAY_AT_2_PM));
    }

    @Test
    public void an_appointment_can_have_an_optional_reason() {
        Appointment appointment = Appointment.forPetCalled("Fido").ownedBy("Fred").because("He is sick").at(TODAY_AT_2_PM);

//         Assertions previously written using junit:
/*        Assert.assertEquals(true,appointment.getReason().isPresent());
        Assert.assertEquals("He is sick",appointment.getReason().get());*/

//      Assertion refactored to Hamcrest matchers:
        assertThat(appointment.getReason().isPresent(), equalTo(true));
        assertThat(appointment.getReason().get(), equalTo("He is sick"));
    }
}
