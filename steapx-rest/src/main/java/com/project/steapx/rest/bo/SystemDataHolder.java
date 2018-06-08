package com.project.steapx.rest.bo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import com.project.steapx.common.exception.BizException;
import com.project.steapx.common.exception.ErrorMsg;
import com.project.steapx.rest.constant.SystemDictionaryConstants;
import com.project.steapx.rest.dao.entity.meeting.Meeting;
import com.project.steapx.rest.dao.entity.project.Project;
import com.project.steapx.rest.dao.entity.system.SystemDictionary;

public class SystemDataHolder implements Serializable {

	private static final long serialVersionUID = -3292548171218139647L;
	
	private volatile Map<SystemDictionaryConstants, DictionaryHierarchyTree> systemData = new ConcurrentHashMap<>();

	public Map<SystemDictionaryConstants, DictionaryHierarchyTree> getSystemData() {
		return systemData;
	}

	public void setSystemData(Map<SystemDictionaryConstants, DictionaryHierarchyTree> systemData) {
		this.systemData = systemData;
	}
	
	public Project nextStatus(Project project) {
		Objects.requireNonNull(project, "Project info can't be null.");
		Objects.requireNonNull(project.getStatus(), "Status of project can't be null!!!");
		
		Integer nextStatus = findNextStatus(project.getStatus(), SystemDictionaryConstants.PROJECT_STATUE);
		Project next = new Project();
		BeanUtils.copyProperties(project, next);
		next.setStatus(nextStatus);
		
		return next;
	}

	public Meeting nextStatus(Meeting meeting) {
		Objects.requireNonNull(meeting, "Meeting info can't be null.");
		Objects.requireNonNull(meeting.getStatus(), "Status of meeting can't be null!!!");
		
		Integer nextStatus = findNextStatus(meeting.getStatus(), SystemDictionaryConstants.MEETING_STATUS);
		Meeting next = new Meeting();
		BeanUtils.copyProperties(meeting, next);
		next.setStatus(nextStatus);
		return next;
	}
	
	private Integer findNextStatus(Integer status, SystemDictionaryConstants type) {
		if (!systemData.containsKey(type)) {
			throw new BizException(String.format(ErrorMsg.CANNOT_FIND_DATA.getMessage(), type.name()));
		}
		
		Integer target = null;
		DictionaryHierarchyTree dictionaryHierarchyTree = systemData.get(type);
		List<SystemDictionary> children = dictionaryHierarchyTree.getChildren();
		if (CollectionUtils.isNotEmpty(children)) {
			for (int i = 0; i < children.size(); i++) {
				if (Objects.equals(status, children.get(i).getId())) {
					target = children.get(i + 1).getId();
					break;
				}
			}
		}
		return target;
	}
	
	public List<SystemDictionary> list(SystemDictionaryConstants type) {
		List<SystemDictionary> targets = null;
		DictionaryHierarchyTree tree = systemData.get(type);
		if (tree != null) {
			targets = tree.getChildren();
		}
		return targets;
	}
}
