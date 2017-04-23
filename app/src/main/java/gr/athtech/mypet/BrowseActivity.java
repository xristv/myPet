package gr.athtech.mypet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;

import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.repository.PetRepository;

import static gr.athtech.mypet.R.id.list_view;

/**
 * Browse a list of species
 */
public class BrowseActivity extends AppCompatActivity {

    private ListView listView;
    private GridView gridView;

    private List<Pet> pets;

    private PetRepository petRepository;

    private PetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        setListeners();

        //get a list of the selected species
        petRepository = new PetRepository(this);
        Intent intent = getIntent();
        String species = intent != null ? intent.getStringExtra("species") : null;
        try {
            pets = petRepository.getPets(species);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (pets.isEmpty())
            showEmpty();
        else {
            ((TextView) findViewById(R.id.speciesText)).setText(species);
            adapter = new PetAdapter(this, pets);
            showListView();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_browse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_list_view:
                showListView();
                return true;
            case R.id.menu_item_grid_view:
                showGridView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showListView() {
        this.gridView.setAdapter(null);
        this.gridView.setVisibility(View.GONE);
        (this.findViewById(R.id.emptyText)).setVisibility(View.GONE);

        this.listView.setAdapter(adapter);
        this.listView.setVisibility(View.VISIBLE);
        this.listView.setDivider(null);
    }

    private void showGridView() {
        this.listView.setAdapter(null);
        this.listView.setVisibility(View.GONE);
        (this.findViewById(R.id.emptyText)).setVisibility(View.GONE);

        adapter.setLayout(R.layout.item_pet_grid);
        this.gridView.setAdapter(adapter);
        this.gridView.setVisibility(View.VISIBLE);
    }

    /**
     * Show a pet based on its name
     *
     * @param pet
     */
    private void showPet(Pet pet) {
        Intent intent = new Intent(this, PetActivity.class);
        intent.putExtra("pet", pet);
        startActivity(intent);
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {

        listView = (ListView) findViewById(list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pet pet = (Pet) parent.getAdapter().getItem(position);
                showPet(pet);
            }
        });

        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pet pet = (Pet) parent.getAdapter().getItem(position);
                showPet(pet);
            }
        });
    }


    private void showEmpty() {
        (this.findViewById(R.id.grid_view)).setVisibility(View.GONE);
        (this.findViewById(list_view)).setVisibility(View.GONE);
        (this.findViewById(R.id.speciesText)).setVisibility(View.GONE);
        (this.findViewById(R.id.emptyText)).setVisibility(View.VISIBLE);
    }

}
