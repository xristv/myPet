package gr.athtech.mypet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.mypet.model.Cat;
import gr.athtech.mypet.model.Dog;
import gr.athtech.mypet.model.Lizard;
import gr.athtech.mypet.model.Pet;

public class MainActivity extends AppCompatActivity {

    private int counter;
    private List<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pets = getPets();
        counter = 0;
        showPet();
    }

    /**
     * Show the pet information
     */
    private void showPet() {
        Pet pet = pets.get(counter);

        //set name
        TextView nameView = (TextView) findViewById(R.id.petNameText);
        nameView.setText(pet.getName());

        //set breed
        TextView breedView = (TextView) findViewById(R.id.petBreedText);
        breedView.setText(pet.getBreed());

        //set age
        TextView ageTextView = (TextView) findViewById(R.id.petAgeText);
        ageTextView.setText(String.valueOf(pet.getAge()));

        //set the image
        ImageView imageView = (ImageView) findViewById(R.id.petImage);
        imageView.setImageResource(pet.getImage());
    }

    /**
     * Show the previous pet on the list
     *
     * @param view
     */
    public void showPrevious(View view) {
        if (counter == 0) {
            counter = pets.size() - 1;
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
        } else {
            counter++;
        }
        showPet();
    }

    /**
     * Create a pet list
     *
     * @return
     */
    private List<Pet> getPets() {

        List<Pet> pets = new ArrayList<>();
        pets.add(new Dog("Willy", "Doge", 5, R.drawable.dogie1));
        pets.add(new Dog("Bob", "Doge", 10, R.drawable.dogie2));
        pets.add(new Cat("Themos", "Orange", 1, R.drawable.themos));
        pets.add(new Dog("Grumpy", "Siameze", 3, R.drawable.grump));
        pets.add(new Dog("Blublu", "Kitty cat", 8, R.drawable.kitty1));
        pets.add(new Lizard("Komodo", "Dragon", 5, R.drawable.komodo));
        pets.add(new Lizard("Lizzy", "Lizard", 2, R.drawable.lizzy));

        return pets;
    }
}
