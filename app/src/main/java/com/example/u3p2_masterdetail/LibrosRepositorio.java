package com.example.u3p2_masterdetail;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LibrosRepositorio {

    private LibrosBaseDeDatos.LibrosDao librosDao;

    private Executor executor;

    public LibrosRepositorio(Application application){
        librosDao = LibrosBaseDeDatos
                .getInstance(application).obtenerLibrosDao();

        executor = Executors.newSingleThreadExecutor();
    }

    LiveData<List<Libros>> obtener(){
        return librosDao.getElementos();
    }

    public void insertar(Libros libro){
        executor.execute(()-> {
            librosDao.insertarElemento(libro);
        });
    }

    public void borrar(Libros libro){
        executor.execute(()-> {
            librosDao.borrarElemento(libro);
        });
    }

    public void actualizar(Libros libro){
        executor.execute(()-> {
            librosDao.actualizarElemento(libro);
        });
    }

}
