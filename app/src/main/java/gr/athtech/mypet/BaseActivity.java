package gr.athtech.mypet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.repository.PetRepository;

/**
 * Created by xrist on 28/5/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected boolean loggedIn;
    protected Pet pet;
    protected String species;
    protected PetRepository petRepository;

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
            case R.id.addPet:
                Intent intent1 = new Intent(this, PetFormActivity.class);
                startActivity(intent1);
                return true;
            case R.id.editPet:
                Intent intent2 = new Intent(this, PetFormActivity.class);
                intent2.putExtra("pet", this.getPet());
                startActivity(intent2);
                return true;
            case R.id.deletePet:
                petRepository.deletePet(this.getPet().getName());
                Toast.makeText(this, "Pet deleted!", Toast.LENGTH_LONG).show();
                Intent intent3 = new Intent(this, BrowseActivity.class);
                intent3.putExtra("species", this.getSpecies());
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        if (pet == null) {
            menu.findItem(R.id.editPet).setVisible(false);
            menu.findItem(R.id.deletePet).setVisible(false);
        }
        if (loggedIn) {
            menu.findItem(R.id.login).setVisible(false);
        } else {
            menu.findItem(R.id.logout).setVisible(false);
        }
        return true;
    }

    protected boolean isLoggedIn() {
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", null);
        return username == null ? false : true;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
