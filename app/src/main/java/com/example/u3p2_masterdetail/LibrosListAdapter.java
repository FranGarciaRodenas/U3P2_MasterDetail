package com.example.u3p2_masterdetail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LibrosListAdapter extends RecyclerView.Adapter<LibrosListAdapter.LibrosViewHolder> {

    private List<Libros> libros;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Libros libro);
    }

    public LibrosListAdapter(List<Libros> libros, OnItemClickListener listener) {
        this.libros = libros;
        this.listener = listener;
    }

    @NonNull
    @Override
    public LibrosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.libro_item, parent, false);
        return new LibrosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibrosViewHolder holder, int position) {
        Libros libro = libros.get(position);
        ImageView imagenImageView = holder.itemView.findViewById(R.id.imagen);
        TextView tituloTextView = holder.itemView.findViewById(R.id.titulo);
        tituloTextView.setText(libro.getTitle());
        TextView autorTextView = holder.itemView.findViewById(R.id.autor);
        autorTextView.setText(libro.getAuthor());
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public class LibrosViewHolder extends RecyclerView.ViewHolder {
        public LibrosViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(libros.get(position));
                    }
                }
            });
        }
    }
}
