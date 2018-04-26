package com.seb.notepad.view;

import com.seb.notepad.data.Note;

import java.util.List;

/**
 * Created by sebastianuchwat on 24/03/2018.
 */

public interface ViewInterface {

    void iStartDetailFragment(String dateAndTime, String message, int colourResource);

    void iSetupAdapterAndView(List<Note> listOfData);

}
