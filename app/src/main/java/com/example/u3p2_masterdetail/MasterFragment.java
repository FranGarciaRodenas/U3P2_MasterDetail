package com.example.u3p2_masterdetail;

import android.os.Bundle;
import android.widget.AdapterView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MasterFragment extends Fragment {
    private LibrosViewModel viewModel;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        viewModel = new ViewModelProvider(this).get(LibrosViewModel.class);

        viewModel.getLibros().observe(getViewLifecycleOwner(), new Observer<List<Libros>>() {
            @Override
            public void onChanged(List<Libros> books) {
                recyclerView.setAdapter(new LibrosListAdapter(books, new LibrosListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Libros libro) {
                        NavController navController = NavHostFragment.findNavController(MasterFragment.this);
                        navController.navigate(R.id.action_masterFragment_to_detailFragment);
                    }
                }));
            }
        });

        return view;
    }
}