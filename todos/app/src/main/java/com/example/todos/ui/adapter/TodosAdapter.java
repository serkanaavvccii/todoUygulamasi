package com.example.todos.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todos.data.entity.Todos;
import com.example.todos.databinding.CardTasarimBinding;
import com.example.todos.ui.fragment.AnasayfaFragmentDirections;
import com.example.todos.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.CardTasarimTutucu> {

    private List<Todos> todosListesi;
    private Context mContext;
    private AnasayfaViewModel viewModel;

    public TodosAdapter(List<Todos> todosListesi,Context mContext,AnasayfaViewModel viewModel){
        this.todosListesi = todosListesi;
        this.mContext = mContext;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding tasarim;

        public CardTasarimTutucu(CardTasarimBinding tasarim) {
            super(tasarim.getRoot());
            this.tasarim = tasarim;
        }
    }
    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        CardTasarimBinding binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder,int position) {
        Todos todo = todosListesi.get(position);
        CardTasarimBinding t = holder.tasarim;

        t.textViewTodo.setText(todo.getName());

        t.imageViewSil.setOnClickListener(v -> {
            Snackbar.make(v,todo.getName()+" adlı iş silinsin mi?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET", v1 -> {
                        viewModel.sil(todo.getId());
                    })
                    .show();
        });

        t.cardViewSatir.setOnClickListener(v -> {
            AnasayfaFragmentDirections.DetayFragmentGecis gecis = AnasayfaFragmentDirections.detayFragmentGecis(todo);
            Navigation.findNavController(v).navigate(gecis);
        });


    }
    @Override
    public int getItemCount() { return  todosListesi.size(); }
}
