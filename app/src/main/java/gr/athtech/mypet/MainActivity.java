package gr.athtech.mypet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gr.athtech.mypet.model.Cat;
import gr.athtech.mypet.model.Dog;
import gr.athtech.mypet.model.Lizard;
import gr.athtech.mypet.model.Pet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private List<Pet> getPets(){

        List<Pet> pets = new ArrayList<>();
        pets.add(new Dog("Willy", "Doge", 5));
        pets.add(new Dog("Bob", "Doge", 5));
        pets.add(new Cat("Trolli", "Russian blue", 5));
        pets.add(new Dog("Gizmo", "Siameze", 1));
        pets.add(new Lizard("Komodo", "Dragon", 5));

        return pets;
    }
}
