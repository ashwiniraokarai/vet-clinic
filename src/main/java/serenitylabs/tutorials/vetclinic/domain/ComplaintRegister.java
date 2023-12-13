package serenitylabs.tutorials.vetclinic.domain;

import java.util.ArrayList;
import java.util.List;

public class ComplaintRegister {
    List<String> listOfComplaints = new ArrayList<String>();
    public void register(String complaint){
        listOfComplaints.add(complaint);
    }

    public List<String> getAllComplaints() {
        return listOfComplaints;
    }
}
