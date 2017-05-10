package gr.athtech.mypet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.text.ParseException;

import gr.athtech.mypet.repository.PetRepository;
import gr.athtech.mypet.service.PetService;

public class MainActivity extends AppCompatActivity {

    PetRepository petRepository;
    PetService petService;
    boolean loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
        loggedIn = isLoggedIn();

        petService = new PetService();
        petRepository = new PetRepository(this);
        petRepository.initDb(petService.getPets(""));
        try {
            petRepository.getPets(null, null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        if (loggedIn) {
            menu.findItem(R.id.login).setVisible(false);
        } else {
            menu.findItem(R.id.logout).setVisible(false);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.login:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.logout:
                SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
                sharedPreferences.edit().remove("username").apply();
                return true;
            default:
                return super.onOptionsItemSelected(item);
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

    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null);
        return username == null ? false : true;
    }

}
