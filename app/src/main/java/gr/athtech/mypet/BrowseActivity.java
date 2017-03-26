package gr.athtech.mypet;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;

import gr.athtech.mypet.model.Pet;

public class BrowseActivity extends AppCompatActivity {

    private int counter;
    private PetService petService;
    private List<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        petService = new PetService();
        setContentView(R.layout.activity_browse);
        setListeners();

        Intent intent = getIntent();
        String species = intent != null ? intent.getStringExtra("species") : null;

        counter = savedInstanceState != null ? savedInstanceState.getInt("counter") : 0;
        pets = petService.getPets(species);

        if (!pets.isEmpty())
            showPet();
        else
            showEmpty();
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

    /**
     * Setup the various app listeners
     */
    private void setListeners() {

        final ImageButton prevButton = (ImageButton) findViewById(R.id.dogButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showPrevious(v);
            }
        });

        final ImageButton nextButton = (ImageButton) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showNext(v);
            }
        });
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
}
