package com.tgt.search.microservices.blackList.config;

/**
 * This class is responsible for holding database Configuration  properties read from config
 * file (config.yaml)
 *
 */
public class DatabaseConfig {
  
  private static final String DATABASE_TYPE = "jdbc:postgresql:";
  
  private String host;
  
  private String port;
  
  private String userName;
  
  private String password;
  
  private String activeDB;
  
  private String driverClassName;
  
  private String initDatabase;

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }
  
  public String getDriverClassName() {
    return driverClassName;
  }
  
  public String getUrl() {
    return DATABASE_TYPE + "/" + port + "/" + host + "/" + activeDB ;
  }
  
  public String isInitDatabase() {
    return initDatabase;
  }

}
