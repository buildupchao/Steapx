package com.project.steapx.rest.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.project.steapx.rest.bo.SystemDataHolder;
import com.project.steapx.rest.dao.entity.meeting.Meeting;
import com.project.steapx.rest.dao.entity.project.Project;

@Component
public class SystemDataHelper {
	
	@Autowired
	private ApplicationContext ctx;
	
	public Project nextStatus(Project project) {
		return systemDataHolder().nextStatus(project);
	}
	
	public Meeting nextStatus(Meeting meeting) {
		return systemDataHolder().nextStatus(meeting);
	}
	
	private SystemDataHolder systemDataHolder() {
		return ctx.getBean(SystemDataHolder.class);
	}
}
