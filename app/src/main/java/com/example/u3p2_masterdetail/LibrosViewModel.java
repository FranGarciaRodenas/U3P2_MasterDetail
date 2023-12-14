package com.example.u3p2_masterdetail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class LibrosViewModel extends ViewModel {
    private MutableLiveData<List<Libros>> libros;

    public LibrosViewModel() {
        libros = new MutableLiveData<>();

    }

    public LiveData<List<Libros>> getLibros() {
        return libros;
    }

}
