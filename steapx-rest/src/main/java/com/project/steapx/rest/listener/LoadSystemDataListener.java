package com.project.steapx.rest.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.steapx.rest.service.LoadSystemDataService;

@Component
public class LoadSystemDataListener implements CommandLineRunner {

	@Autowired
	private LoadSystemDataService loadSystemDataService;
	
	@Override
	public void run(String... args) throws Exception {
		loadSystemDataService.loadSystemData();
	}

}
