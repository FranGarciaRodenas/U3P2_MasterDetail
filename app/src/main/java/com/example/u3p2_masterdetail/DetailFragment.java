package com.example.u3p2_masterdetail;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailFragment extends Fragment {
    private Libros libro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        libro = getArguments().getParcelable("libro");

        TextView tituloTextView = view.findViewById(R.id.titulo);
        tituloTextView.setText(libro.getTitle());

        TextView autorTextView = view.findViewById(R.id.autor);
        autorTextView.setText(libro.getAuthor());

        TextView resumenTextView = view.findViewById(R.id.resumen);
        resumenTextView.setText(libro.getDescription());

        ImageView imagenImageView = view.findViewById(R.id.imagen);
        return view;
    }
}