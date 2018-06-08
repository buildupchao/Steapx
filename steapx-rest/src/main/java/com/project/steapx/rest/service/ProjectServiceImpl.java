package com.project.steapx.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.steapx.rest.dao.entity.project.Project;
import com.project.steapx.rest.dao.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> listProjects() {
        return projectRepository.findAll();
    }

    @Override
    public boolean insert(Project project) {
        projectRepository.save(project);
        return true;
    }

    @Override
    public boolean update(Project project) {
        projectRepository.save(project);
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String projectId) {
        projectRepository.deleteById(projectId);
        return true;
    }
}
