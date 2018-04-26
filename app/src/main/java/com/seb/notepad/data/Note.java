package com.seb.notepad.data;

/**
 * Created by sebastianuchwat on 17/03/2018.
 */

public class Note {

    private String mDateAndTime;
    private String mMessage;
    private int mColourResource;

    public Note(String dateAndTime, String message, int colourResource) {
        this.mDateAndTime = dateAndTime;
        this.mMessage = message;
        this.mColourResource = colourResource;
    }

    public String getmDateAndTime() {
        return mDateAndTime;
    }

    public void setmDateAndTime(String mDateAndTime) {
        this.mDateAndTime = mDateAndTime;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public int getmColourResource() {
        return mColourResource;
    }

    public void setmColourResource(int mColourResource) {
        this.mColourResource = mColourResource;
    }
}
