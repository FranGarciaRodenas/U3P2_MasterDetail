package com.example.u3p2_masterdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.example.u3p2_masterdetail.databinding.FragmentMasterBinding;
import com.example.u3p2_masterdetail.databinding.LibroItemBinding;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MasterFragment extends Fragment {
    private static LibrosViewModel viewModel;
    private RecyclerView recyclerView;
    private NavController navController;
    private FragmentMasterBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMasterBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.recyclerView;
        viewModel = new ViewModelProvider(this).get(LibrosViewModel.class);
        navController = NavHostFragment.findNavController(this);

        Libros libro = new Libros("El Quijote", "Miguel de Cervantes", "https://www.planetadelibros.com/usuaris/libros/fotos/34/m_libros/portada_el-quijote-miguel-de-cervantes_201902191157.jpg");
        viewModel.insertar(libro);

        viewModel.getLibros().observe(getViewLifecycleOwner(), books -> {
            LibrosAdapter adapter = new LibrosAdapter(books, libro1 -> navController.navigate(R.id.action_masterFragment_to_detailFragment));
            recyclerView.setAdapter(adapter);
        });

        return view;
    }

    public static class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.LibrosViewHolder> {
        List<Libros> libros = new ArrayList<>();
        private final OnItemClickListener listener;

        public interface OnItemClickListener {
            void onItemClick(Libros libro);
        }

        public LibrosAdapter(List<Libros> libros, OnItemClickListener listener) {
            this.libros = libros;
            this.listener = listener;
        }

        @NotNull
        @Override
        public LibrosViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            LibroItemBinding binding = LibroItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new LibrosViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull LibrosViewHolder holder, int position) {
            Libros libro = libros.get(position);
            holder.binding.titulo.setText(libro.getTitle());
            holder.binding.autor.setText(libro.getAuthor());
            // holder.binding.ivImagen.setImageResource(libro.getCoverImage());

            holder.itemView.setOnClickListener(v -> {
                viewModel.setSeleccionado(libro);
                listener.onItemClick(libro);
            });
        }

        @Override
        public int getItemCount() {
            return libros != null ? libros.size() : 0;
        }

        public class LibrosViewHolder extends RecyclerView.ViewHolder {
            private final LibroItemBinding binding;

            public LibrosViewHolder(LibroItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}