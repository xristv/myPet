package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import gr.athtech.mypet.fragment.PetSpeciesFragment;

public class MainActivity extends AppCompatActivity implements PetSpeciesFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.species_fragment, PetSpeciesFragment.newInstance(), "speciesList")
                    .commit();
        }
    }


    @Override
    public void onSpeciesSelected(String species) {
        Intent intent = new Intent(this, BrowseActivity.class);
        intent.putExtra("species", species);
        startActivity(intent);
    }
}
