package org.se.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Registry
{
	private static final Registry INSTANCE = new Registry();
	private final static String PROPERTY_FILE_NAME = "jdbc.properties";

	private String driver;
	private String url;
	private String username;
	private String password;

	public static Registry getInstance(){
		System.out.println("getInstance()");
		return INSTANCE;
	}



	public Registry()
	{
		createProperties();
	}

	private void createProperties(){
		Properties jdbcProperties = new Properties();
		try{
			jdbcProperties.load(new FileInputStream(PROPERTY_FILE_NAME));
			driver = jdbcProperties.getProperty("jdbc.driver");
			url = jdbcProperties.getProperty("jdbc.url");
			username = jdbcProperties.getProperty("jdbc.username");
			password = jdbcProperties.getProperty("jdbc.password");

		}catch(IOException e){
			throw new IllegalArgumentException("Cann access properties file!" + e);
		}
	}

	public String getJdbcDriver(){
		return driver;
	}

	public String getJdbcUrl(){
		return url;
	}

	public String getJdbcUsername(){
		return username;
	}

	public String getJdbcPassword(){
		return password;
	}
}
