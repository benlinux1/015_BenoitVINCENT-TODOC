package com.cleanup.todoc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.cleanup.todoc.database.dao.TodocDatabase;
import com.cleanup.todoc.model.Project;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)

public class ProjectDaoTest {

    // FOR DATA
    private TodocDatabase database;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void initDb() throws Exception {

        this.database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                        TodocDatabase.class)
                .allowMainThreadQueries()
                .build();

    }

    @After
    public void closeDb() throws Exception {
        database.close();
    }


    // DATA SET FOR TEST
    private static final int PROJECT_ID = 1;
    private static final Project PROJECT_DEMO = new Project(PROJECT_ID, "Pierpoljak", 0xFFe942f5);

    @Test
    public void insertAndGetProject() throws InterruptedException {

        // BEFORE : Adding a new project
        this.database.projectDao().createProject(PROJECT_DEMO);

        // TEST : check if project data is in the database (id / name / color)
        Project project = LiveDataTestUtil.getValue(this.database.projectDao().getProject(PROJECT_ID));
        assertTrue(project.getName().equals(PROJECT_DEMO.getName())
                && project.getId() == PROJECT_ID
                && project.getColor() == PROJECT_DEMO.getColor());

    }

    @Test
    public void insertAndDeleteItem() throws InterruptedException {

        // BEFORE : Adding demo project. Next, get the item added & delete it.
        this.database.projectDao().createProject(PROJECT_DEMO);
        Project projectAdded = LiveDataTestUtil.getValue(this.database.projectDao().getProject(PROJECT_ID));
        this.database.projectDao().deleteProject(projectAdded.getId());

        //TEST : check if project was removed from projects list (so if projects list is empty)
        List<Project> projects = LiveDataTestUtil.getValue(this.database.projectDao().getProjects());
        assertTrue(projects.isEmpty());

    }

}
