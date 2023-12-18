package com.example.minichat.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.minichat.Adapters.ChatMiniatureAdapter;
import com.example.minichat.Classes.ChatMiniature;
import com.example.minichat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    EditText search_line;
    RecyclerView lMiniatures;
    List<ChatMiniature> miniatures = new ArrayList<>();

    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        search_line = v.findViewById(R.id.search_line);
        lMiniatures = v.findViewById(R.id.MiniaturesRecyclerView);

        miniatures.add(new ChatMiniature(R.drawable.ic_acc_filled_purple, "boris", "borisov", "12.12.1212"));
        miniatures.add(new ChatMiniature(R.drawable.ic_acc_filled_purple, "boris", "borisov", "12.12.1212"));
        miniatures.add(new ChatMiniature(R.drawable.ic_acc_filled_purple, "boris", "borisov", "12.12.1212"));
        miniatures.add(new ChatMiniature(R.drawable.ic_acc_filled_purple, "boris", "borisov", "12.12.1212"));

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        lMiniatures.setLayoutManager(layoutManager);
        lMiniatures.setAdapter(new ChatMiniatureAdapter(getContext(), miniatures));

        return v;
    }
}