package com.project.steapx.rest.controller.publicapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.steapx.common.bo.JsonEntity;
import com.project.steapx.common.util.ResponseHelper;
import com.project.steapx.rest.dao.entity.project.Project;
import com.project.steapx.rest.util.SystemDataHelper;

@RestController
@RequestMapping("/project")
public class ProjectApi {

	@Autowired
	private SystemDataHelper helper;
	
	@RequestMapping(value = "/action/update")
	public JsonEntity<Project> updateProjectStatus() {
		Project project = new Project();
		project.setStatus(100001);
		project.setProjectName("Machine Learning");
		project.setId("mllib101");
		Project newProject = helper.nextStatus(project);
		return ResponseHelper.of(newProject);
	}
}
