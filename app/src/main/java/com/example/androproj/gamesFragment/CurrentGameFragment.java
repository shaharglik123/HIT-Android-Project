package com.example.androproj.gamesFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androproj.Activitys.UserActivity;
import com.example.androproj.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentGameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentGameFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrentGameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentGameFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentGameFragment newInstance(String param1, String param2) {
        CurrentGameFragment fragment = new CurrentGameFragment();
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
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_game, container, false);
        UserActivity userActivity=(UserActivity) getActivity();

        TextView textView =(TextView)(view.findViewById(R.id.title2));
        textView.setText(getArguments().getString("title"));
        textView =(TextView)(view.findViewById(R.id.companyPublish2));
        textView.setText(getArguments().getString("publishedCompany"));
        textView =(TextView)(view.findViewById(R.id.genre2));
        textView.setText(getArguments().getString("genre"));
        textView =(TextView)(view.findViewById(R.id.realeseDate2));
        textView.setText(getArguments().getString("releaseDate"));
        textView =(TextView)(view.findViewById(R.id.description2));
        textView.setText(getArguments().getString("description"));
        view.setBackgroundResource(Integer.parseInt(getArguments().getString("image")));
        return view;
    }

}
