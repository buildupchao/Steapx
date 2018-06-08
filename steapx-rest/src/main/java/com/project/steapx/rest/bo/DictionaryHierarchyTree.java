package com.project.steapx.rest.bo;
import java.io.Serializable;
import java.util.List;

import com.project.steapx.rest.dao.entity.system.SystemDictionary;

import lombok.Data;

@Data
public class DictionaryHierarchyTree implements Serializable {

	private static final long serialVersionUID = 9208259461226680846L;

	private SystemDictionary parent;
	private List<SystemDictionary> children;
}