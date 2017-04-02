package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListeners();
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {

        final Button dogsButton = (Button) findViewById(R.id.dogsButton);
        dogsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewPets("Dogs");
            }
        });

        final Button catsButton = (Button) findViewById(R.id.catsButton);
        catsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewPets("Cats");
            }
        });

        final Button otherButton = (Button) findViewById(R.id.otherButton);
        otherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewPets("Other");
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
