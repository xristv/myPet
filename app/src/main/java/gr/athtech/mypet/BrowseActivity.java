package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;

import gr.athtech.mypet.fragment.PetListFragment;
import gr.athtech.mypet.model.Pet;

/**
 * Browse a list of species
 */
public class BrowseActivity extends BaseActivity implements PetListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.petlist_fragment, PetListFragment.newInstance(), "petList")
                    .commit();
        }
    }


    @Override
    public void onPetSelected(Pet pet) {
        Intent intent = new Intent(this, PetActivity.class);
        intent.putExtra("pet", pet);
        startActivity(intent);
    }

}
