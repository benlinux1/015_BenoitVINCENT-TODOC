package com.cleanup.todoc.database.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.cleanup.todoc.model.Task;

import java.util.List;

/**
 * Sets DAO Pattern Interface to group access to persistent data
 */
@Dao
public interface TaskDao {

    // Gets task List
    @Query("SELECT * FROM Task")
    LiveData<List<Task>> getTasks();

    // Gets a given task by id
    @Query("SELECT * FROM Task WHERE id = :id")
    LiveData<Task> getTask(long id);

    // Gets task List for a given project
    @Query("SELECT * FROM Task WHERE projectId = :projectId")
    LiveData<List<Task>> getTasksByProjectId(long projectId);

    // Gets task with cursor for a given project
    @Query("SELECT * FROM Task WHERE projectId = :projectId")
    Cursor getTasksWithCursor(long projectId);

    // Inserts a new task in table
    @Insert
    long createTask(Task task);

    // Deletes a given task in the table
    @Query("DELETE FROM Task WHERE id = :id")
    int deleteTask(long id);
}
