package com.example.safecity.ui.emergency_contacts;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.safecity.databinding.EmergencyContactsFragmentBinding;

public class EmergencyContactsFragment extends Fragment {

    private EmergencyContactsViewModel emergencyContactsViewModel;
    private EmergencyContactsFragmentBinding binding;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        emergencyContactsViewModel = new ViewModelProvider(this).get(EmergencyContactsViewModel.class);
        binding = EmergencyContactsFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button addNewContactButton = (Button) binding.addContactButton;

        //final TextView textView = binding.textEmergency;
        emergencyContactsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                //textView.setText(s);
            }
        });

        addNewContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.example.safecity.ui.new_emergency_contact.NewEmergencyContactActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}