package com.shreem.jpa.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public class JpaEntityManager {

	private EntityManagerFactory emFactoryObj;

	private final String PERSISTENCE_UNIT_NAME = "JPATest";	

	String DB_HOST = "localhost";
	
	String DB_DRIVER = "org.mariadb.jdbc.Driver";
	
	String DB_NAME = "pkdb";
	
	String DB_USER = "root";
	
	String DB_PASSWORD = "india";
	
	String DB_USE_SSL = "false";
	
	String DB_REQUIRED_SSL = "false";
	
	String DB_SERVER_TIMEZONE = "";
	
	String DB_JDBC_URL = "jdbc:mariadb://localhost:3306/pkdb";
	

	// 	

	public EntityManager getEntityManager() {		
		Map<String,Object> props = new HashMap<String,Object>();
		props.put("javax.persistence.nonJtaDataSource", dataSource());
	    props.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
		emFactoryObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, props);
		return emFactoryObj.createEntityManager();
	}
	
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUsername(DB_USER);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setUrl(DB_JDBC_URL);
		dataSource.setMaxActive(10);
		dataSource.setMaxIdle(5);
		dataSource.setInitialSize(5);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

}
