package com.seb.notepad.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seb.notepad.R;
import com.seb.notepad.contract.RecyclerViewClickListenerInterface;
import com.seb.notepad.data.Note;
import com.seb.notepad.viewholder.NoteRowViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sebastianuchwat on 25/03/2018.
 */

public class NoteListAdapter extends RecyclerView.Adapter {

    private RecyclerViewClickListenerInterface mRecyclerViewClickListenerInterface;
    private List<Note> mList = new ArrayList<>();

    // Ten konstruktor bedzie z kolei uzyty we fragmencie.
    // A konstruktor obiektu NoteRowViewHolder jest uzyty tutaj ponizej w linii 43
    public NoteListAdapter(RecyclerViewClickListenerInterface recyclerViewClickListenerInterface) {
        mRecyclerViewClickListenerInterface = recyclerViewClickListenerInterface;
    }

    public void updateData(List<Note> dataset) {
        mList.clear();
        mList.addAll(dataset);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        // Konstrukcja obiektu NoteViewHolder z ustawieniem interfejsu, dlatego interfejs jest
        // potrzebny w tej klasie
        return new NoteRowViewHolder(view, mRecyclerViewClickListenerInterface);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NoteRowViewHolder) holder).bindData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.row;
    }
}
