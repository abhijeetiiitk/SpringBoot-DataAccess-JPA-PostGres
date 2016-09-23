package com.tgt.search.microservices.blackList.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class BlackListGeneratorAppConfig {
  
  private DatabaseConfig databaseConfig;
  private BlackListKeywordConfig config;
  
  public BlackListGeneratorAppConfig(DatabaseConfig databaseConfig, BlackListKeywordConfig keywordConfig) {
    super();
    this.databaseConfig = databaseConfig;
    this.config = keywordConfig;
  }

  public BlackListKeywordConfig getConfig() {
    return config;
  }

  public void setConfig(BlackListKeywordConfig config) {
    this.config = config;
  }

  public DatabaseConfig getDatabaseConfig() {
    return databaseConfig;
  }

  public void setDatabaseConfig(DatabaseConfig databaseConfig) {
    this.databaseConfig = databaseConfig;
  }
  
}
