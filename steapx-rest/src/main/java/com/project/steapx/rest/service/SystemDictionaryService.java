package com.project.steapx.rest.service;

import java.util.List;

import com.project.steapx.rest.bo.DictionaryHierarchyTree;
import com.project.steapx.rest.dao.entity.system.SystemDictionary;

public interface SystemDictionaryService {

	List<SystemDictionary> findByParentId(Integer parentId);
	
	DictionaryHierarchyTree getDictionaryHierarchyTree(Integer id);
	
	List<SystemDictionary> listSystemDictionary();
}
