package com.seb.notepad.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.seb.notepad.R;
import com.seb.notepad.contract.RecyclerViewClickListenerInterface;
import com.seb.notepad.data.Note;

/**
 * Created by sebastianuchwat on 25/03/2018.
 */

public class NoteRowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private View mColourCircle;
    private TextView mDateAndTime;
    private TextView mMessage;
    private ViewGroup mRow;
    private RecyclerViewClickListenerInterface mRecyclerViewClickListenerInterface;

    // Ten konstruktor bedzie uzyty w adapterze w metodzie onCreateViewHolder
    public NoteRowViewHolder(View itemView, RecyclerViewClickListenerInterface recyclerViewClickListenerInterface) {
        super(itemView);

        this.mColourCircle = itemView.findViewById(R.id.iv_list_item_circle);
        this.mDateAndTime = itemView.findViewById(R.id.tv_date_and_time);
        this.mMessage = itemView.findViewById(R.id.tv_message);
        this.mRow = itemView.findViewById(R.id.root_row);

        mRecyclerViewClickListenerInterface = recyclerViewClickListenerInterface;
        itemView.setOnClickListener(this);

    }

    public void bindData(Note note) {
        mColourCircle.setBackgroundResource(note.getmColourResource());
        mDateAndTime.setText(note.getmDateAndTime());
        mMessage.setText(note.getmMessage());
    }

    @Override
    public void onClick(View view) {
        // Tight coupling from when adapter and viewholder where subclasses of ListActivity
        //Note note = listOfData.get(this.getAdapterPosition());
        //controller.onListItemClick(note);

        //Toast.makeText(view.getContext(), "hello", Toast.LENGTH_SHORT).show();

        // Interface wysyla pozycje do NoteListFragment
        mRecyclerViewClickListenerInterface.onClick(view, getAdapterPosition());
    }
}
