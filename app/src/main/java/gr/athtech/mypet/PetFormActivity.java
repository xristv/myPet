package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import gr.athtech.mypet.model.Owner;
import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.model.Vet;
import gr.athtech.mypet.repository.PetRepository;

/**
 * Created by xrist on 27/5/2017.
 */
public class PetFormActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_form);

        Intent intent = getIntent();
        Pet pet = intent.getParcelableExtra("pet");
        if (pet != null) {
            fillForm(pet);
        }
        petRepository = new PetRepository(this);
        setListeners();
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {
        final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = ((EditText) findViewById(R.id.petNameText)).getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(PetFormActivity.this, "Pet should have a name!", Toast.LENGTH_LONG).show();
                    return;
                }

                Pet pet = new Pet();
                pet.setName(name);

                try {
                    String date = ((EditText) findViewById(R.id.dob)).getText().toString();
                    pet.setDateOfBirth(format.parse(date.isEmpty() ? "01/01/1970" : date));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                pet.setGender(((EditText) findViewById(R.id.genderText)).getText().toString());
                pet.setBreed(((EditText) findViewById(R.id.breedText)).getText().toString());
                pet.setColor(((EditText) findViewById(R.id.colorText)).getText().toString());
                pet.setDistinguishingMarks(((EditText) findViewById(R.id.distinguishingMarksText)).getText().toString());
                pet.setChipID(((EditText) findViewById(R.id.chipIdText)).getText().toString());
                String species = ((EditText) findViewById(R.id.speciesText)).getText().toString();
                pet.setSpecies(species.isEmpty() ? "other" : species);
                pet.setComments(((EditText) findViewById(R.id.commentsText)).getText().toString());

                Owner owner = new Owner();
                owner.setFirstName(((EditText) findViewById(R.id.ownerNameText)).getText().toString());
                owner.setLastName(((EditText) findViewById(R.id.ownerLastName)).getText().toString());
                owner.setAddress(((EditText) findViewById(R.id.ownerAddressText)).getText().toString());
                owner.setPhoneNumber(((EditText) findViewById(R.id.ownerPhoneText)).getText().toString());

                Vet vet = new Vet();
                vet.setFirstName(((EditText) findViewById(R.id.vetNameText)).getText().toString());
                vet.setLastName(((EditText) findViewById(R.id.vetLastName)).getText().toString());
                vet.setAddress(((EditText) findViewById(R.id.vetAddressText)).getText().toString());
                vet.setPhoneNumber(((EditText) findViewById(R.id.vetPhoneText)).getText().toString());

                pet.setOwner(owner);
                pet.setVet(vet);

                switch (pet.getSpecies()) {
                    case "dog":
                        pet.setImageUri(R.drawable.default_dog);
                        break;
                    case "cat":
                        pet.setImageUri(R.drawable.default_cat);
                        break;
                    case "other":
                        pet.setImageUri(R.drawable.default_other);
                        break;
                    default:
                        break;
                }

                petRepository.insertPet(pet);

                Intent intent = new Intent(PetFormActivity.this, PetActivity.class);
                intent.putExtra("pet", pet);
                startActivity(intent);
            }
        });
        /*
        private String name;
    private Date dateOfBirth;
    private String gender;
    private String breed;
    private String color;
    private String distinguishingMarks;
    private String chipID;
    private String species;
    private String comments;
    private int imageUri;
    private Owner owner;
    private Vet vet;
         */
    }

    private void fillForm(Pet pet) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        ((EditText) findViewById(R.id.petNameText)).setText(pet.getName());
        ((EditText) findViewById(R.id.dob)).setText(format.format(pet.getDateOfBirth()));
        ((EditText) findViewById(R.id.genderText)).setText(pet.getGender());
        ((EditText) findViewById(R.id.breedText)).setText(pet.getBreed());
        ((EditText) findViewById(R.id.colorText)).setText(pet.getColor());
        ((EditText) findViewById(R.id.distinguishingMarksText)).setText(pet.getDistinguishingMarks());
        ((EditText) findViewById(R.id.chipIdText)).setText(pet.getChipID());
        ((EditText) findViewById(R.id.speciesText)).setText(pet.getSpecies());
        ((EditText) findViewById(R.id.commentsText)).setText(pet.getComments());

        ((EditText) findViewById(R.id.ownerNameText)).setText(pet.getOwner().getFirstName());
        ((EditText) findViewById(R.id.ownerLastName)).setText(pet.getOwner().getLastName());
        ((EditText) findViewById(R.id.ownerAddressText)).setText(pet.getOwner().getAddress());
        ((EditText) findViewById(R.id.ownerPhoneText)).setText(pet.getOwner().getPhoneNumber());

        ((EditText) findViewById(R.id.vetNameText)).setText(pet.getVet().getFirstName());
        ((EditText) findViewById(R.id.vetLastName)).setText(pet.getVet().getLastName());
        ((EditText) findViewById(R.id.vetAddressText)).setText(pet.getVet().getAddress());
        ((EditText) findViewById(R.id.vetPhoneText)).setText(pet.getVet().getPhoneNumber());
    }
}
