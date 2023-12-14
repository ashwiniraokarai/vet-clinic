package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public interface VaccineEligible {
    void setLastVaccinatedDate(LocalDate lastVaccinatedDate);

    LocalDate nextVaccineDueIn();
}
