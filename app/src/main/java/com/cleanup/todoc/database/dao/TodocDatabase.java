package com.cleanup.todoc.database.dao;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.cleanup.todoc.model.Task;

import java.util.concurrent.Executors;


@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class TodocDatabase extends RoomDatabase {

    // --- SINGLETON ---
    private static volatile TodocDatabase INSTANCE;

    // --- DAO ---
    public abstract TaskDao taskDao();

    // --- INSTANCE ---
    public static TodocDatabase getInstance(Context context) {

        if (INSTANCE == null) {
            synchronized (TodocDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    TodocDatabase.class, "TodocDatabase.db")
                            .addCallback(prepopulateDatabase())
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Insert 4 tasks as examples in Database [2 tasks in first project, 1 task in projects 2 & 3]
     */
    private static Callback prepopulateDatabase() {

        return new Callback() {

            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {

                super.onCreate(db);
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task( 1, "Nettoyer les vitres de la salle de réunion", 1654684380)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task( 2, "Nettoyer la porte d'entrée du local", 1654684390)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task( 3, "Nettoyer le réfrigérateur de la salle de pause", 1654684400)));
                Executors.newSingleThreadExecutor().execute(() -> INSTANCE.taskDao().createTask(new Task( 1, "Nettoyer le réfrigérateur de la cuisine", 1654684410)));
            }
        };
    }
}
