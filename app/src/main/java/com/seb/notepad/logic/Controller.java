package com.seb.notepad.logic;

import com.seb.notepad.data.DataSourceInterface;
import com.seb.notepad.data.Note;
import com.seb.notepad.view.ViewInterface;

import java.util.List;

/**
 * Created by sebastianuchwat on 24/03/2018.
 */

public class Controller {

    private ViewInterface viewInterface;
    private DataSourceInterface dataSourceInterface;

    public Controller(ViewInterface viewInterface, DataSourceInterface dataSourceInterface) {
        this.viewInterface = viewInterface;
        this.dataSourceInterface = dataSourceInterface;
    }

    public void setListFromDataSource() {
        viewInterface.iSetupAdapterAndView(dataSourceInterface.iGetListOfData());
    }

    public void onListItemClick(Note note) {
        viewInterface.iStartDetailFragment(note.getmDateAndTime(), note.getmMessage(), note.getmColourResource()
        );
    }
}
