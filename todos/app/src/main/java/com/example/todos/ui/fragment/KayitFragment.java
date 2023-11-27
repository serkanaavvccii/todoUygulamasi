package com.example.todos.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todos.R;
import com.example.todos.databinding.FragmentKayitBinding;
import com.example.todos.ui.viewmodel.KayitViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class KayitFragment extends Fragment {
    private FragmentKayitBinding binding;
    private KayitViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentKayitBinding.inflate(inflater,container,false);

        binding.buttonKaydet.setOnClickListener(v -> {
            String name = binding.editTextTodo.getText().toString();
            viewModel.kaydet(name);
        });
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(KayitViewModel.class);
    }
}