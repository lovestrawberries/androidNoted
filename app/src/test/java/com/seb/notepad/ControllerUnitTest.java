package com.seb.notepad;

import com.seb.notepad.data.DataSourceInterface;
import com.seb.notepad.data.Note;
import com.seb.notepad.logic.Controller;
import com.seb.notepad.view.ViewInterface;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    /**
     * Test Double:
     * Specifically a "Mock"
     */
    @Mock
    DataSourceInterface dataSourceInterface;

    @Mock
    ViewInterface viewInterface;

    Controller controller;

    private static final Note note = new Note(
            "11:20AM 25th March 2018",
            "Lorem ipsum...",
            R.color.BLUE
    );

    @Before
    public void setUpTest() {
        MockitoAnnotations.initMocks(this);
        controller = new Controller(viewInterface, dataSourceInterface);
    }

    @Test
    public void onGetNoteSuccessful() {
        // Set up data needed for test
        ArrayList<Note> list = new ArrayList<>();
        list.add(note);

        //Set up our Mocks to return the Data we want
        Mockito.when(dataSourceInterface.iGetListOfData())
                .thenReturn(list);

        //Call the unit we're testing
        controller.setListFromDataSource();

        //Check how the tested class responds to the data it receives
        //or test it's behaviour
        Mockito.verify(viewInterface).iSetupAdapterAndView(list);
    }

    @Test
    public void onNoteClicked() {
        controller.onListItemClick(note);

        Mockito.verify(viewInterface).iStartDetailActivity(
                note.getmDateAndTime(),
                note.getmMessage(),
                note.getmColourResource()
        );
    }
}