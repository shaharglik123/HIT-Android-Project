package com.example.androproj.loginFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.androproj.Activitys.MainActivity;
import com.example.androproj.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
        View fragmentLoginView = inflater.inflate(R.layout.fragment_login, container, false);
        boolean loginTry;

        //button click
        Button regButtonFirstReg = fragmentLoginView.findViewById(R.id.regButton);
        regButtonFirstReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });
        Button buttonWithoutLoginFirstFreg = fragmentLoginView.findViewById(R.id.Logbutton);
        buttonWithoutLoginFirstFreg.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                String email = ((EditText) mainActivity.findViewById(R.id.UsernameLoginPage)).getText().toString();
                String password = ((EditText) mainActivity.findViewById(R.id.passwordLoginPage)).getText().toString();
                mainActivity.getmAuth().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(mainActivity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("", "signInWithCredential:success");
                                    Toast.makeText(getContext(), "Logged in successfully ", Toast.LENGTH_LONG).show();
                                    Navigation.findNavController(getView()).navigate(R.id.action_loginFragment_to_userActivity);

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("", "signInWithCredential:failure", task.getException());
                                    Toast.makeText(getContext(), "Logged in failed!! ", Toast.LENGTH_LONG).show();
                                }

                            }
                        });
            }
        });

        return fragmentLoginView;
    }
}