package com.example.u3p2_masterdetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class LibrosViewModel extends ViewModel {
    private MutableLiveData<List<Libros>> libros;

    private LibrosRepositorio repositorio;
    private MutableLiveData<Libros> libroSeleccionado = new MutableLiveData<>();

    public LibrosViewModel() {
        libros = new MutableLiveData<>();

    }

    void insertar(Libros libro) {
        repositorio.insertar(libro);
    }

    void actualizar(Libros libro) {
        repositorio.actualizar(libro);
    }

    void eliminar(Libros libro) {
        repositorio.borrar(libro);
    }


    MutableLiveData<Libros> getSeleccionado() {
        return libroSeleccionado;
    }

    void setSeleccionado(Libros libro) {
        libroSeleccionado.setValue(libro);
    }



    public LiveData<List<Libros>> getLibros() {
        return libros;
    }

}
