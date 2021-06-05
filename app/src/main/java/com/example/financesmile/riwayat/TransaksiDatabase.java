package com.example.financesmile.riwayat;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.financesmile.Transaksi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Transaksi.class}, version = 1, exportSchema = false)
public abstract class TransaksiDatabase extends RoomDatabase {

    public abstract TransaksiDAO transaksiDAO();

    private static volatile TransaksiDatabase instance;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static synchronized TransaksiDatabase getInstance(final Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TransaksiDatabase.class, "transaksi_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
