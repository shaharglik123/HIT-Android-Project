package com.example.androproj.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.androproj.Activitys.UserActivity;
import com.example.androproj.R;
import com.example.androproj.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//        List<Button> browsingbuttons=new ArrayList<Button>();
        //button click
        ImageView actionButton = view.findViewById(R.id.actionButton);
        ImageView adventureButton = view.findViewById(R.id.adventureButton);
        ImageView fPSButton = view.findViewById(R.id.fpsButton);
        ImageView puzzleButton = view.findViewById(R.id.puzzleButton);
        ImageView rPGButton = view.findViewById(R.id.rpgButton);
        ImageView sportsButton = view.findViewById(R.id.sportsButton);
        ImageView strategyButton = view.findViewById(R.id.God_of_war);
        ImageView survivalButton = view.findViewById(R.id.survivalButton);

        UserActivity userActivity= (UserActivity)getActivity();
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_actionFragment);
            }
        });
        adventureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_adventureFragment);
            }
        });
        fPSButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_FPSFragment);
            }
        });
        puzzleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_puzzleFragment);
            }
        });
        rPGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_RPGFragment);
            }
        });
        sportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_sportsFragment);
            }
        });
        strategyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_strategyFragment);
            }
        });
        survivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_survivalFragment);
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}