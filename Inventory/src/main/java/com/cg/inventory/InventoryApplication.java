package com.cg.inventory;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;






/**
 * This is the main class which starts the spring boot application,
 * by auto configuration
 * 
 * @author fsd22
 *
 */
@SpringBootApplication


    

public class InventoryApplication {


    private static final Logger logger = LogManager.getLogger(InventoryApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
		
	    
		logger.info("started");
		
		
//		BasicConfigurator.configure();
//		Logger logger = Logger.getLogger(InventoryApplication.class);
//		logger.info("Open");

	}

}
