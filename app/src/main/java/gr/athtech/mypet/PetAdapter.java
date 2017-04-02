package gr.athtech.mypet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gr.athtech.mypet.model.Pet;

/**
 * Created by xrist on 1/4/2017.
 */
public class PetAdapter extends BaseAdapter {

    private Context context;
    private List<Pet> pets;
    private int layout;

    public PetAdapter(Context context, List<Pet> pets) {
        this.context = context;
        this.pets = pets;
        this.layout = R.layout.item_pet_list;
    }

    @Override
    public int getCount() {
        return pets.size();
    }

    @Override
    public Object getItem(int position) {
        return pets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            convertView = inflater.inflate(layout, parent, false);
        }

        Pet pet = (Pet) getItem(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.petName);
        TextView breedText = (TextView) convertView.findViewById(R.id.petBreed);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.petImage);

        nameText.setText(pet.getName());
        breedText.setText(pet.getBreed());
        imageView.setImageResource(pet.getImage());

        return convertView;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }
}
