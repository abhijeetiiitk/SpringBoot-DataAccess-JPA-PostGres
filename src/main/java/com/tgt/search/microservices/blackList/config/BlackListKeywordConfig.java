package com.tgt.search.microservices.blackList.config;

/**
 * This class is responsible for holding BlackListKeyword Configuration  properties read from config
 * file (config.yaml)
 *
 */
public class BlackListKeywordConfig {
  
  private int blackListEligibleThreshold;
  private float blackListEligibleThresholdPercentage;
  
  public int getBlackListEligibleThreshold() {
    return blackListEligibleThreshold;
  }
  public void setBlackListEligibleThreshold(int blackListEligibleThreshold) {
    this.blackListEligibleThreshold = blackListEligibleThreshold;
  }
  public float getBlackListEligibleThresholdPercentage() {
    return blackListEligibleThresholdPercentage;
  }
  public void setBlackListEligibleThresholdPercentage(float blackListEligibleThresholdPercentage) {
    this.blackListEligibleThresholdPercentage = blackListEligibleThresholdPercentage;
  }

}
