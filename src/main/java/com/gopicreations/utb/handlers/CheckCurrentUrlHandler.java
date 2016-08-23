package com.gopicreations.utb.handlers;

import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public class CheckCurrentUrlHandler extends KeywordHandler {

  public CheckCurrentUrlHandler() {
  }
  
  public CheckCurrentUrlHandler(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    super(testCase, testStep, driver, testResult);
  }

  @Override
  public Keyword getKeyword() {
    return Keyword.CHECK_CURRENT_URL;
  }

  @Override
  public WebDriver handle() throws Exception {
    
    switch (getTestStep().locatorType.toLowerCase()) {
    case "contains":
      if (getDriver().getCurrentUrl().contains(getTestStep().locatorValue)) {
        getTestResult().isSuccess = true;
        getTestResult().resultStatement = "Current url as expected";
      } else {
        getTestResult().resultStatement = "Current url not as expected. Found: " + getDriver().getCurrentUrl() + " Was expected to contain: " + getTestStep().locatorValue;
      }
      break;
    case "match":
      if (getDriver().getCurrentUrl().equals(getTestStep().locatorValue)) {
        getTestResult().isSuccess = true;
        getTestResult().resultStatement = "Current url as expected";
      } else {
        getTestResult().resultStatement = "Current url not as expected. Found: " + getDriver().getCurrentUrl() + " Expected: " + getTestStep().locatorValue;
      }
      break;
    default:
      logger.warn("Unsupported locatorType:" + getTestStep().locatorType);
    }
    return getDriver();
  }

}
