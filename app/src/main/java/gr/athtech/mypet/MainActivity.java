package gr.athtech.mypet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import gr.athtech.mypet.model.Cat;
import gr.athtech.mypet.model.Dog;
import gr.athtech.mypet.model.Owner;
import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.model.Vet;

public class MainActivity extends AppCompatActivity {

    private int counter;
    private List<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = savedInstanceState != null ? savedInstanceState.getInt("counter") : 0;
        pets = getPets();
        showPet();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counter);
    }

    /**
     * Show the pet information
     */
    private void showPet() {
        Pet pet = pets.get(counter);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        //set the image
        ((ImageView) findViewById(R.id.petImage)).setImageResource(pet.getImage());

        //set name
        ((TextView) findViewById(R.id.petNameText)).setText(pet.getName());

        //set pet info
        ((TextView) findViewById(R.id.petInfoText)).setText(pet.getBreed() + ", " + pet.getSex() + ", " + format.format(pet.getDateOfBirth()));

        //set color
        ((TextView) findViewById(R.id.petColorText)).setText(pet.getColor());

        //set petigree
        ((TextView) findViewById(R.id.petPetigreeText)).setText(pet.getPetigree());

        //set marks
        ((TextView) findViewById(R.id.petMarksText)).setText(pet.getDistinguishingMarks());

        //set owner
        ((TextView) findViewById(R.id.ownerName)).setText(pet.getOwner().getFirstName() + " " + pet.getOwner().getLastName());
        ((TextView) findViewById(R.id.ownerNumber)).setText(pet.getOwner().getPhoneNumber());
        ((TextView) findViewById(R.id.ownerAddress)).setText(pet.getOwner().getAddress());

        //set vet
        ((TextView) findViewById(R.id.vetName)).setText(pet.getVet().getFirstName() + " " + pet.getOwner().getLastName());
        ((TextView) findViewById(R.id.vetNumber)).setText(pet.getVet().getPhoneNumber());
        ((TextView) findViewById(R.id.vetAddress)).setText(pet.getVet().getAddress());

    }

    /**
     * Show the previous pet on the list
     *
     * @param view
     */
    public void showPrevious(View view) {
        if (counter == 0) {
            counter = pets.size() - 1;
            Toast.makeText(this, "End of list!", Toast.LENGTH_SHORT).show();
        } else {
            counter--;
        }
        showPet();
    }

    /**
     * Show the next pet on the list
     *
     * @param view
     */
    public void showNext(View view) {
        if (counter == pets.size() - 1) {
            counter = 0;
            Toast.makeText(this, "Start of list!", Toast.LENGTH_SHORT).show();
        } else {
            counter++;
        }
        showPet();
    }

    /**
     * Create a pet list
     *
     * @return
     */
    private List<Pet> getPets() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        List<Pet> pets = new ArrayList<>();
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

            pets.add(new Cat("Komodo", format.parse("05/12/2016"),
                    "Female", "Komodo dragon", "Green",
                    "Just a little dragon", "-",
                    R.drawable.komodo,
                    new Owner("Austin", "Cox", "5761 Cherry St", "(577)-632-6763"),
                    new Vet("Janice", "Pearson", "3217 Golf Course Rd", "(754)-859-2353")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return pets;
    }
}
