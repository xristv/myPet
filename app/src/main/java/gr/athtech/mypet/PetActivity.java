package gr.athtech.mypet;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.repository.PetRepository;

/**
 * Show one pet
 */
public class PetActivity extends BaseActivity {

    Pet pet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        petRepository = new PetRepository(this);

        Intent intent = getIntent();

        if (intent == null)
            pet = savedInstanceState != null ? (Pet) savedInstanceState.getParcelable("pet") : null;
        else
            pet = intent.getParcelableExtra("pet");

        if (pet != null) {
            showPet(pet);
            this.setPet(pet);
            this.setSpecies(pet.getSpecies());
        } else
            showEmpty();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("pet", pet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        if (loggedIn) {
            menu.findItem(R.id.login).setVisible(false);
        } else {
            menu.findItem(R.id.logout).setVisible(false);
        }
        return true;
    }

    /**
     * Show the pet information
     */
    private void showPet(Pet pet) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        //set the image
        ((ImageView) findViewById(R.id.petImage)).setImageResource(pet.getImageUri());

        //set name
        ((TextView) findViewById(R.id.petNameText)).setText(pet.getName());

        //set pet info
        ((TextView) findViewById(R.id.petInfoText)).setText(pet.getBreed() + ", " + pet.getGender() + ", " + format.format(pet.getDateOfBirth()));

        //set color
        ((TextView) findViewById(R.id.petColorText)).setText(pet.getColor());

        //set chipId
        ((TextView) findViewById(R.id.petChipIDText)).setText(pet.getChipID());

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

    private void showEmpty() {
        if (Configuration.ORIENTATION_PORTRAIT == getResources().getConfiguration().orientation) {
            (this.findViewById(R.id.imageWrapper)).setVisibility(RelativeLayout.INVISIBLE);
            (this.findViewById(R.id.infoWrapper)).setVisibility(RelativeLayout.INVISIBLE);
            (this.findViewById(R.id.emptyWrapper)).setVisibility(RelativeLayout.VISIBLE);
        } else {
            (this.findViewById(R.id.imageWrapperLand)).setVisibility(LinearLayout.INVISIBLE);
            (this.findViewById(R.id.infoWrapperLand)).setVisibility(LinearLayout.INVISIBLE);
            (this.findViewById(R.id.infoWrapper2Land)).setVisibility(LinearLayout.INVISIBLE);
        }
    }

}
