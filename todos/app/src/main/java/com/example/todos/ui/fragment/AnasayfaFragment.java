package com.example.todos.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.todos.R;
import com.example.todos.databinding.FragmentAnasayfaBinding;
import com.example.todos.ui.adapter.TodosAdapter;
import com.example.todos.ui.viewmodel.AnasayfaViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false);

        binding.todoRv.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.todoListesi.observe(getViewLifecycleOwner(),todoListesi -> {
            TodosAdapter adapter = new TodosAdapter(todoListesi,requireContext(),viewModel);
            binding.todoRv.setAdapter(adapter);
        });

        binding.fab.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.kayitFragmentGecis);
        });

        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                viewModel.ara(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModel.ara(newText);
                return true;
            }
        });


        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.todosYukle();
    }
}