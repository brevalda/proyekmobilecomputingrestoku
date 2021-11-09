package com.example.proyekmc.ui.account;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyekmc.Login_Activity;
import com.example.proyekmc.MainActivity;
import com.example.proyekmc.R;
import com.example.proyekmc.Register_Activity;
import com.example.proyekmc.databinding.FragmentAccountBinding;
import com.example.proyekmc.databinding.FragmentActivityBinding;
import com.example.proyekmc.ui.activity.ActivityViewModel;

public class AccountFragment extends Fragment {

    private AccountViewModel acountViewModel;
    private FragmentAccountBinding binding;
    Button btnLogin;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        acountViewModel=
                new ViewModelProvider(this).get(AccountViewModel.class);

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textAccount;
        acountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        View view = inflater.inflate(R.layout.fragment_account,
                container, false);
        Button button = (Button) view.findViewById(R.id.button_loginNow);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent(getActivity(), Login_Activity.class);
                startActivity(intent);

            }
        });

        return root;

    }
    public void goToAttract(View v)
    {
        Intent intent = new Intent(getActivity(), Login_Activity.class);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}