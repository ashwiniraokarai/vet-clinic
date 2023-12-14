package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDate;

public interface VaccinationEligible {
    void setLastVaccinatedOnDate(LocalDate lastVaccinatedOnDate);

    LocalDate nextVaccineDueIn();
}
