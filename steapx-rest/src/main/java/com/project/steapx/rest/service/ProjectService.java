package com.project.steapx.rest.service;

import java.util.List;

import com.project.steapx.rest.dao.entity.project.Project;

public interface ProjectService {

    List<Project> listProjects();

    boolean insert(Project project);

    boolean update(Project project);

    boolean deleteByPrimaryKey(String projectId);
}
