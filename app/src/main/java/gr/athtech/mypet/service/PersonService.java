package gr.athtech.mypet.service;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.mypet.model.Owner;
import gr.athtech.mypet.model.Person;
import gr.athtech.mypet.model.Vet;

/**
 * Created by xrist on 23/4/2017.
 */

public class PersonService {

    public List<Person> getOwners() {

        List<Person> owners = new ArrayList<>();

        owners.add(new Owner("Vernon", "Rose", "3854 Elm Dr", "(380)-210-4170"));
        owners.add(new Owner("Diane", "Woods", "7444 Edwards Rd", "(956)-687-2442"));
        owners.add(new Owner("Vernon", "Rose", "3854 Elm Dr", "(380)-210-4170"));

        return owners;
    }

    public List<Person> getVets() {

        List<Person> vets = new ArrayList<>();

        vets.add(new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353"));
        vets.add(new Vet("Fred", "Beck", "3784 View St", "(555)-361-5351"));
        vets.add(new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353"));

        return vets;
    }
}
