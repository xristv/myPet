package gr.athtech.mypet.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.util.List;

import gr.athtech.mypet.PetAdapter;
import gr.athtech.mypet.R;
import gr.athtech.mypet.model.Pet;
import gr.athtech.mypet.repository.PetRepository;

import static gr.athtech.mypet.R.id.list_view;

/**
 * Created by xrist on 21/5/2017.
 */
public class PetListFragment extends Fragment {

    private ListView listView;
    private PetAdapter adapter;
    private List<Pet> pets;
    private PetRepository petRepository;

    public interface OnFragmentInteractionListener {
        void onPetSelected(Pet pet);
    }

    public static PetListFragment newInstance() {
        return new PetListFragment();
    }

    private OnFragmentInteractionListener mListener;

    public PetListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pet_list, container, false);
        petRepository = new PetRepository(getActivity());
        Intent intent = getActivity().getIntent();
        String species = intent != null ? intent.getStringExtra("species") : null;
        try {
            pets = petRepository.getPets(species);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        adapter = new PetAdapter(getActivity(), pets);
        this.listView=(ListView)view.findViewById(R.id.list_view);
        this.listView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListeners();

        if (pets.isEmpty())
            showEmpty();
        else {
            ((TextView) getActivity().findViewById(R.id.speciesText)).setText("");
            showListView();
        }
    }


    private void showListView() {
        this.listView.setAdapter(adapter);
        this.listView.setVisibility(View.VISIBLE);
        this.listView.setDivider(null);
    }

    /**
     * Setup the various activity listeners
     */
    private void setListeners() {
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pet pet = (Pet) parent.getAdapter().getItem(position);
                mListener.onPetSelected(pet);
            }
        });
    }


    private void showEmpty() {
        (getActivity().findViewById(list_view)).setVisibility(View.GONE);
        (getActivity().findViewById(R.id.speciesText)).setVisibility(View.GONE);
        (getActivity().findViewById(R.id.emptyText)).setVisibility(View.VISIBLE);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
