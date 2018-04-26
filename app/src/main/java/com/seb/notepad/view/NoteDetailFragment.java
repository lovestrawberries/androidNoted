package com.seb.notepad.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seb.notepad.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sebastianuchwat on 25/03/2018.
 */

public class NoteDetailFragment extends Fragment {

    @BindView(R.id.tv_date_and_time_header)
    TextView mDateAndTime;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        View view = layoutInflater.inflate(R.layout.fragment_note_detail, container, false);

        ButterKnife.bind(getActivity());

        return view;
    }
}
