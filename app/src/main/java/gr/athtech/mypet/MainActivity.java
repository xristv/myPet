package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;

import gr.athtech.mypet.repository.PetRepository;
import gr.athtech.mypet.service.PetService;

public class MainActivity extends AppCompatActivity {

    PetRepository petRepository;
    PetService petService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();

        petService = new PetService();
        petRepository = new PetRepository(this);
        petRepository.initDb(petService.getPets(""));
        try {
            petRepository.getPets(null, null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {

        final Button dogsButton = (Button) findViewById(R.id.dogsButton);
        dogsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewPets("dog");
            }
        });

        final Button catsButton = (Button) findViewById(R.id.catsButton);
        catsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewPets("cat");
            }
        });

        final Button otherButton = (Button) findViewById(R.id.otherButton);
        otherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewPets("other");
            }
        });
    }

    /**
     * Call the BrowseActivity and display the selected species
     *
     * @param species
     */
    private void viewPets(String species) {
        Intent intent = new Intent(this, BrowseActivity.class);
        intent.putExtra("species", species);
        startActivity(intent);
    }

}
