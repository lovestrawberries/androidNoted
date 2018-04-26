package com.seb.notepad.data;

import com.seb.notepad.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Test Double
 * (Specifically a "Fake")
 * Created by sebastianuchwat on 24/03/2018.
 */

public class FakeDataSource implements DataSourceInterface {

    private static final int SIZE_OF_COLLECTION = 12;

    private final String[] datesAndTimes = {
            "5:31PM 24th March 2018",
            "5:36PM 25th March 2018",
            "2:11PM 26th March 2018",
            "10:20AM 27th March 2018",
            "22:55PM 28th March 2018",

    };

    private final String[] messages = {
            "Cras facilisis leo sed mauris eleifend, vitae luctus mi auctor. In imperdiet" +
                    "sollicitudin sapien ut cursus. Integer tincidunt orci a neque rhoncus" +
                    "rutrum ac sit amet velit",
            "Aliquam tincidunt, nibh non blandit malesuada, dui purus ultricies purus, et feugiat" +
                    "eros nibh eget arcu. Nullam a leo erat. Donec vitae nisi arcu. In sed fermentum lorem",
            "Sed mattis, tortor in faucibus pretium, ex turpis tempus enim, sit amet volutpat" +
                    "libero purus vitae justo.",
            "Nullam a leo erat. Donec vitae nisi arcu. In sed fermentum lorem"
    };

    private final int[] colours = {
            R.color.RED,
            R.color.BLUE,
            R.color.GREEN,
            R.color.YELLOW
    };

    @Override
    public List<Note> iGetListOfData() {
        ArrayList<Note> listOfData = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 12; i++) {
            int randomOne = random.nextInt(4);
            int randomTwo = random.nextInt(4);
            int randomThree = random.nextInt(4);

            Note note = new Note(datesAndTimes[randomOne], messages[randomTwo], colours[randomThree]);

            listOfData.add(note);
        }

        return listOfData;
    }
}
