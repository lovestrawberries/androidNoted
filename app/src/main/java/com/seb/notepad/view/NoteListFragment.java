package com.seb.notepad.view;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.seb.notepad.R;
import com.seb.notepad.adapter.NoteListAdapter;
import com.seb.notepad.contract.RecyclerViewClickListenerInterface;
import com.seb.notepad.data.FakeDataSource;
import com.seb.notepad.data.Note;
import com.seb.notepad.logic.Controller;

import java.util.ArrayList;

/**
 * Created by sebastianuchwat on 25/03/2018.
 */

public class NoteListFragment extends Fragment {

    OnNoteSelectedListenerInterface onNoteSelectedListenerInterfaceCallback;
    Controller controller;

    // Interfejs do przesylania danych do NoteDetailFragment przez aktywnosc rodzica (ListActivity)
    public interface OnNoteSelectedListenerInterface {
        void iOnNoteSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //Check if container activity implemented callback interface
        try {
            onNoteSelectedListenerInterfaceCallback = (OnNoteSelectedListenerInterface) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnNoteSelectedListenerInterface");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(layoutInflater, container, savedInstanceState);

        //Inflate fragment layout
        View view = layoutInflater.inflate(R.layout.fragment_note_list, container, false);


        //Provide data
        FakeDataSource fakeDataSource = new FakeDataSource();
        final ArrayList<Note> notes = (ArrayList<Note>) fakeDataSource.iGetListOfData();

        //Interface event transmitter
        RecyclerViewClickListenerInterface recyclerViewClickListenerInterface = (v, position) -> {
            Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            onNoteSelectedListenerInterfaceCallback.iOnNoteSelected(position);
        };

        //Set up the adapter
        // W tym konstruktorze jest ustawiany konkretny interfejs, ktory potem leci jako
        // podajdalej do konstruktora obiektu NoteRowViewHolder w klasie NoteListAdapter
        NoteListAdapter noteListAdapter = new NoteListAdapter(recyclerViewClickListenerInterface);
        noteListAdapter.updateData(notes);

        //Set up the recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.note_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(noteListAdapter);

        return view;
    }

}