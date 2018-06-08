package com.project.steapx.rest.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.steapx.rest.dao.entity.system.SystemDictionary;

@Repository
public interface SystemDictionaryRepository extends JpaRepository<SystemDictionary, Integer> {

	List<SystemDictionary> findByUpDictionaryOptionId(Integer parentId);
}
