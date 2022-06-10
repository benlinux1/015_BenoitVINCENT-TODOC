package com.cleanup.todoc.repositories;

import androidx.lifecycle.LiveData;

import com.cleanup.todoc.database.dao.ProjectDao;
import com.cleanup.todoc.model.Project;

import java.util.List;

public class ProjectDataRepository {

    private final ProjectDao projectDao;

    public ProjectDataRepository(ProjectDao projectDao) { this.projectDao = projectDao; }

    // --- GET PROJECTS LIST---
    public LiveData<List<Project>> getProjects(){ return this.projectDao.getProjects(); }

    // --- CREATE PROJECT ---
    public void createProject(Project project){ projectDao.createProject(project); }

    // --- DELETE PROJECT ---
    public void deleteProject(long projectId){ projectDao.deleteProject(projectId); }

    // --- GET PROJECT ---
    public LiveData<Project> getProject(long projectId) { return this.projectDao.getProject(projectId); }
}
