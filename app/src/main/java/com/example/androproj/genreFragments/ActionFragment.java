package com.example.androproj.genreFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.androproj.Activitys.UserActivity;
import com.example.androproj.R;

import dm.GameProduct;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActionFragment extends Fragment {
    //    private static final int CONTENT_VIEW_ID = 10101010;
//    private static final int left_action_linear_layout = 0;
//    private static final int right_action_linear_layout = 1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActionFragment newInstance(String param1, String param2) {
        ActionFragment fragment = new ActionFragment();
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
        View view = inflater.inflate(R.layout.fragment_action, container, false);

        LinearLayout right_linearLayout = view.findViewById(R.id.action_right_linear_layout);
        LinearLayout left_linearLayout = view.findViewById(R.id.action_left_linear_layout);

        UserActivity userActivity = (UserActivity) getActivity();
        userActivity.setI(0);
        for (GameProduct gameProduct : userActivity.getDataBaseGames()) {
            if (gameProduct.getGenre().equals("action")) {
                if(userActivity.getI()%2==0) {
                    ImageView imageView = new ImageView(left_linearLayout.getContext());
                    imageView.setImageResource(gameProduct.getImage());

                    imageView.setId(getResources().getIdentifier(gameProduct.getId(), "id", "com.example.androproj"));

                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT, 0.25f);
                    imageView.setLayoutParams(lp);


                    imageView.setClickable(true);
                    imageView.setFocusable(true);
                    imageView.setContentDescription(gameProduct.getName());

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            UserActivity userActivity = (UserActivity) getActivity();
                            for (GameProduct gameProduct : userActivity.getDataBaseGames()) {
//                            if (getResources().getIdentifier(gameProduct.getId(), "id", "com.example.androproj") == (view.getId())) {
                                if (gameProduct.getName().equals(view.getContentDescription())) {

                                    String image = (String.valueOf(gameProduct.getImage()));
                                    Bundle bundle = new Bundle();
                                    bundle.putString("id", gameProduct.getId());
                                    bundle.putString("title", gameProduct.getName());
                                    bundle.putString("publishedCompany", gameProduct.getPublishedCompany());
                                    bundle.putString("genre", gameProduct.getGenre());
                                    bundle.putString("releaseDate", gameProduct.getReleaseDate());
                                    bundle.putString("description", gameProduct.getDescription());
                                    bundle.putString("image", image);

                                    Navigation.findNavController(view).navigate(R.id.action_actionFragment_to_currentGameFragment, bundle);
                                }
                            }
                        }
                    });
                    left_linearLayout.addView(imageView);
                    userActivity.setI(userActivity.getI()+1);
                }
                else{
                    ImageView imageView = new ImageView(left_linearLayout.getContext());
//                ImageView imageView = new ImageView(view.getContext());
                    imageView.setImageResource(gameProduct.getImage());

                    imageView.setId(getResources().getIdentifier(gameProduct.getId(), "id", "com.example.androproj"));

                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT, 0.25f);
                    imageView.setLayoutParams(lp);


                    imageView.setClickable(true);
                    imageView.setFocusable(true);
                    imageView.setContentDescription(gameProduct.getName());

                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            UserActivity userActivity = (UserActivity) getActivity();
                            for (GameProduct gameProduct : userActivity.getDataBaseGames()) {
                                if (gameProduct.getName().equals(view.getContentDescription())) {

                                    String image = (String.valueOf(gameProduct.getImage()));
                                    Bundle bundle = new Bundle();
                                    bundle.putString("id", gameProduct.getId());
                                    bundle.putString("title", gameProduct.getName());
                                    bundle.putString("publishedCompany", gameProduct.getPublishedCompany());
                                    bundle.putString("genre", gameProduct.getGenre());
                                    bundle.putString("releaseDate", gameProduct.getReleaseDate());
                                    bundle.putString("description", gameProduct.getDescription());
                                    bundle.putString("image", image);

                                    Navigation.findNavController(view).navigate(R.id.action_actionFragment_to_currentGameFragment, bundle);
                                }
                            }
                        }
                    });
                    userActivity.setI(userActivity.getI()+1);
                    right_linearLayout.addView(imageView);
                }
            }
        }
        userActivity.setI(0);
        return view;
    }
}
