package com.cleanup.todoc.database.dao;

import android.database.Cursor;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cleanup.todoc.model.Project;
import com.cleanup.todoc.model.Task;

import java.util.List;

@Dao
public interface ProjectDao {

    // Gets projects List
    @Query("SELECT * FROM Project")
    LiveData<List<Project>> getProjects();

    // Gets a given project by id
    @Query("SELECT * FROM Project WHERE id = :id")
    LiveData<Project> getProject(long id);

    // Gets a project with cursor for a given project
    @Query("SELECT * FROM Project WHERE id = :id")
    Cursor getProjectWithCursor(long id);

    // Inserts a new project in table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long createProject(Project project);

    // Deletes a given project in the table
    @Query("DELETE FROM Project WHERE id = :id")
    int deleteProject(long id);
}
