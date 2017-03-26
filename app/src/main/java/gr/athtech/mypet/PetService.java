package gr.athtech.mypet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gr.athtech.mypet.model.Cat;
import gr.athtech.mypet.model.Dog;
import gr.athtech.mypet.model.Owner;
import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.model.Vet;


public class PetService {

    public List<Pet> getPets(String species) {

        List<Pet> pets = new ArrayList<>();

        switch (species) {
            case "Dogs":
                getDogs(pets);
                break;
            case "Cats":
                getCats(pets);
                break;
            case "Other":
                getOther(pets);
                break;
            default:
                getDogs(pets);
                getCats(pets);
                getOther(pets);
                break;
        }

        return pets;
    }

    private void getDogs(List<Pet> pets) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            pets.add(new Dog("Hachiko", format.parse("03/12/2007"),
                    "Male", "Akita", "Beige",
                    "Dignified, courageous, and profoundly loyal", "-",
                    R.drawable.hachiko,
                    new Owner("Vernon", "Rose", "3854 Elm Dr", "(380)-210-4170"),
                    new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353")));

            pets.add(new Dog("Cutiepie", format.parse("05/03/2017"),
                    "Male", "Harrier", "White, brown, black",
                    "Outgoing and friendly; true pack hounds", "-",
                    R.drawable.harrier,
                    new Owner("Diane", "Woods", "7444 Edwards Rd", "(956)-687-2442"),
                    new Vet("Fred", "Beck", "3784 View St", "(555)-361-5351")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getCats(List<Pet> pets) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            pets.add(new Cat("Terry", format.parse("14/08/2016"),
                    "Male", "Balinese", "Beige",
                    "Very chatty and social. Ears might work like antennas", "-",
                    R.drawable.balinese,
                    new Owner("Austin", "Cox", "5761 Cherry St", "(577)-632-6763"),
                    new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353")));
            pets.add(new Cat("Suko", format.parse("05/03/2017"),
                    "Female", "Siameze", "Brown",
                    "Gorgeous blue eyes", "-",
                    R.drawable.siamese,
                    new Owner("Dana", "Arnold", "2634 Fifth St", "(470)-226-3658"),
                    new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353")));
            pets.add(new Cat("René", format.parse("05/12/2016"),
                    "Female", "Russian blue", "Grey",
                    "Rich, thick coat", "-",
                    R.drawable.russianblue,
                    new Owner("Vernon", "Rose", "3854 Elm Dr", "(380)-210-4170"),
                    new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void getOther(List<Pet> pets) {
        //commented out for demonstration purposes
       /* SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            pets.add(new Lizard("Komodo", format.parse("05/12/2016"),
                    "Female", "Komodo dragon", "Green",
                    "Just a little dragon", "-",
                    R.drawable.komodo,
                    new Owner("Austin", "Cox", "5761 Cherry St", "(577)-632-6763"),
                    new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353")));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
    }
}
