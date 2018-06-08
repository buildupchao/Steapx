package com.project.steapx.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.steapx.rest.bo.DictionaryHierarchyTree;
import com.project.steapx.rest.dao.entity.system.SystemDictionary;
import com.project.steapx.rest.dao.repository.SystemDictionaryRepository;

@Service
public class SystemDictionaryServiceImpl implements SystemDictionaryService {

	@Autowired
	private SystemDictionaryRepository systemDictionaryRepository;
	
	@Override
	public List<SystemDictionary> findByParentId(Integer parentId) {
		return systemDictionaryRepository.findByUpDictionaryOptionId(parentId);
	}
	
	@Override
	public DictionaryHierarchyTree getDictionaryHierarchyTree(Integer id) {
		DictionaryHierarchyTree tree = null;
		Optional<SystemDictionary> hasParent = systemDictionaryRepository.findById(id);
		if (hasParent.isPresent()) {
			tree = new DictionaryHierarchyTree();
			tree.setParent(hasParent.get());
			List<SystemDictionary> children = findByParentId(id);
			if (CollectionUtils.isNotEmpty(children)) {
				List<SystemDictionary> sortChildren = children.stream()
					.sorted((pre, next) -> Integer.compare(pre.getSortNo(), next.getSortNo()))
					.collect(Collectors.toList());
				tree.setChildren(sortChildren);
			}
		}
		return tree;
	}

	@Override
	public List<SystemDictionary> listSystemDictionary() {
		return systemDictionaryRepository.findAll();
	}

}
