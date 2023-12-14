package com.example.u3p2_masterdetail;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

public abstract class LibrosBaseDeDatos extends RoomDatabase {

    private static volatile LibrosBaseDeDatos INSTANCE;

    @Dao
    public interface LibrosDao {
        @Query("SELECT * FROM Libros")
        LiveData<List<Libros>> getElementos();

        @Insert
        void insertarElemento(Libros elemento);

        @Delete
        void borrarElemento(Libros elemento);

        @Update
        void actualizarElemento(Libros elemento);
    }

    public static LibrosBaseDeDatos getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (LibrosBaseDeDatos.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LibrosBaseDeDatos.class, "elementos.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract LibrosDao obtenerLibrosDao();
}

