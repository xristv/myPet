package gr.athtech.mypet.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.text.ParseException;

import gr.athtech.mypet.R;
import gr.athtech.mypet.repository.PetRepository;
import gr.athtech.mypet.service.PetService;

/**
 * Created by xrist on 21/5/2017.
 */

public class PetSpeciesFragment extends Fragment {


    PetRepository petRepository;
    PetService petService;

    public interface OnFragmentInteractionListener {
        void onSpeciesSelected(String species);
    }

    public static PetSpeciesFragment newInstance() {
        return new PetSpeciesFragment();
    }

    private OnFragmentInteractionListener mListener;

    public PetSpeciesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_species_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListeners();

        petService = new PetService();
        petRepository = new PetRepository(getActivity());
        petRepository.initDb(petService.getPets(""));
        try {
            petRepository.getPets(null, null);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    /**
     * Setup the various activity listeners
     */
    private void setListeners() {

        final Button dogsButton = (Button) getActivity().findViewById(R.id.dogsButton);
        dogsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mListener.onSpeciesSelected("dog");
            }
        });

        final Button catsButton = (Button) getActivity().findViewById(R.id.catsButton);
        catsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mListener.onSpeciesSelected("cat");
            }
        });

        final Button otherButton = (Button) getActivity().findViewById(R.id.otherButton);
        otherButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mListener.onSpeciesSelected("other");
            }
        });
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
