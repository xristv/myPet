package gr.athtech.mypet.model;

import java.util.Date;

/**
 * Created by xrist on 9/3/2017.
 */

public class Lizard extends Pet {

    public Lizard(String name, Date dateOfBirth, String sex, String breed, String color, String distinguishingMarks, String chipId, int image, Owner owner, Vet vet) {
        super(name, dateOfBirth, sex, breed, color, distinguishingMarks, chipId, image, owner, vet);
    }

    @Override
    public String getSpecies() {
        return "lizard";
    }
}
