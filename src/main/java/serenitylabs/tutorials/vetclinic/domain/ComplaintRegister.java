package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRegister {
    private List<String> listOfComplaints = new ArrayList<String>();

    public void registerComplaintFor(Animal animal) {
        listOfComplaints.add(animal.complain());
    }

    public List<String> getComplaints(){
        return listOfComplaints;
    }
}
