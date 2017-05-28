package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;

import gr.athtech.mypet.fragment.PetSpeciesFragment;

public class MainActivity extends BaseActivity implements PetSpeciesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loggedIn = isLoggedIn();

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
