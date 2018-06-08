package com.project.steapx.rest.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.project.steapx.rest.bo.DictionaryHierarchyTree;
import com.project.steapx.rest.bo.SystemDataHolder;
import com.project.steapx.rest.constant.SystemDictionaryConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoadSystemDataServiceImpl implements LoadSystemDataService, ApplicationContextAware {

	@Autowired
	private SystemDictionaryService systemDictionaryService;
	
	private ApplicationContext ctx;
	
	@Override
	public void loadSystemData() {
		Map<SystemDictionaryConstants, DictionaryHierarchyTree> systemData = null;
		SystemDictionaryConstants[] dictionaryIndexes = SystemDictionaryConstants.values();
		if (ArrayUtils.isNotEmpty(dictionaryIndexes)) {
			systemData = new HashMap<>(dictionaryIndexes.length);
			for (SystemDictionaryConstants dictionaryIndex : dictionaryIndexes) {
				DictionaryHierarchyTree dictionaryHierarchyTree = systemDictionaryService.getDictionaryHierarchyTree(dictionaryIndex.getCode());
				systemData.put(dictionaryIndex, dictionaryHierarchyTree);
			}
			initSystemData(systemData);
		}
	}

	@Override
	public void reloadSystemData() {
		destorySystemData();
		loadSystemData();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
		log.info("Initializing ApplicationContext>>>>>>");
	}

	private void initSystemData(Map<SystemDictionaryConstants, DictionaryHierarchyTree> systemData) {
		log.info("Start loading system data>>>>>>>");
		
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory();
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(SystemDataHolder.class);
		beanDefinitionBuilder.addPropertyValue("systemData", systemData);
		beanFactory.registerBeanDefinition("systemDataHolder", beanDefinitionBuilder.getBeanDefinition());
		
		log.info("Finish loading system data>>>>>>>");
	}
	
	private void destorySystemData() {
		((DefaultListableBeanFactory) ctx.getAutowireCapableBeanFactory()).removeBeanDefinition("systemDataHolder");
		
		log.info("Destory system data>>>>>>>");
	}
}
