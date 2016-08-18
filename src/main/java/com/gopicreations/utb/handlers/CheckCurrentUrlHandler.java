package com.gopicreations.utb.handlers;

import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;

public class CheckCurrentUrlHandler extends KeywordHandler {

  @Override
  public Keyword getKeyword() {
    return Keyword.CHECK_CURRENT_URL;
  }

  @Override
  public WebDriver handle() throws Exception {
    
    switch (testStep.locatorType.toLowerCase()) {
    case "contains":
      if (driver.getCurrentUrl().contains(testStep.locatorValue)) {
        testResult.isSuccess = true;
        testResult.resultStatement = "Current url as expected";
      } else {
        testResult.resultStatement = "Current url not as expected. Found: " + driver.getCurrentUrl() + " Was expected to contain: " + testStep.locatorValue;
      }
      break;
    case "match":
      if (driver.getCurrentUrl().equals(testStep.locatorValue)) {
        testResult.isSuccess = true;
        testResult.resultStatement = "Current url as expected";
      } else {
        testResult.resultStatement = "Current url not as expected. Found: " + driver.getCurrentUrl() + " Expected: " + testStep.locatorValue;
      }
      break;
    default:
      logger.warn("Unsupported locatorType:" + testStep.locatorType);
    }
    return driver;
  }

}
