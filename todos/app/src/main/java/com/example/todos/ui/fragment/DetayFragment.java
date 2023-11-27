package com.example.todos.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todos.R;
import com.example.todos.data.entity.Todos;
import com.example.todos.databinding.FragmentDetayBinding;
import com.example.todos.ui.viewmodel.DetayViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetayFragment extends Fragment {

    private FragmentDetayBinding binding;
    private DetayViewModel viewModel;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetayBinding.inflate(inflater,container,false);
        DetayFragmentArgs bundle = DetayFragmentArgs.fromBundle(getArguments());
        Todos gelenTodo = bundle.getTodo();

        binding.editTextTodo.setText(gelenTodo.getName());

        binding.buttonGuncelle.setOnClickListener(v -> {
            String name = binding.editTextTodo.getText().toString();

            viewModel.guncelle(gelenTodo.getId(),name);
        });
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetayViewModel.class);
    }
}