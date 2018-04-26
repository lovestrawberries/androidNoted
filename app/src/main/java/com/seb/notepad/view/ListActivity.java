package com.seb.notepad.view;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.seb.notepad.R;
import com.seb.notepad.data.Note;
import com.seb.notepad.viewholder.NoteRowViewHolder;

import java.util.List;


public class ListActivity extends AppCompatActivity implements NoteListFragment.OnNoteSelectedListenerInterface, ViewInterface {

    private NoteRowViewHolder mNoteRowViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check if layout has fragment container
        if (findViewById(R.id.fragment_container) != null) {

            //Don't do anything if being restored from previous state to avoid overlapping fragments
            if(savedInstanceState != null) {
                return;
            }

            //Create new fragment to be placed in activity layout
            NoteListFragment noteListFragment = new NoteListFragment();

            //Add fragment to container
            getFragmentManager().beginTransaction().add(R.id.fragment_container, noteListFragment).commit();

        }


        /*
        recyclerView = findViewById(R.id.rec_activity_list);
        layoutInflater = getLayoutInflater();

        //Dependency Injection
        controller = new Controller(this, new FakeDataSource());
        */
    }

    @Override
    public void iOnNoteSelected(int position) {

        Toast.makeText(this, "listActvitiy", Toast.LENGTH_SHORT).show();
        this.openNoteDetailFragment();

    }

    public void openNoteDetailFragment() {
        NoteDetailFragment noteDetailFragment = new NoteDetailFragment();
        Bundle args = new Bundle();
        noteDetailFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container, noteDetailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void iStartDetailFragment(String dateAndTime, String message, int colourResource) {

    }

    @Override
    public void iSetupAdapterAndView(List<Note> listOfData) {

    }
}
