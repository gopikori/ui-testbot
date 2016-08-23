package com.gopicreations.utb.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public class IsClickableHandler extends KeywordHandler {

  public IsClickableHandler() {
  }

  public IsClickableHandler(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    super(testCase, testStep, driver, testResult);
  }

  @Override
  public Keyword getKeyword() {
    return Keyword.IS_CLICKABLE;
  }

  @Override
  public WebDriver handle() throws Exception {
    
    switch (getTestStep().locatorType.toLowerCase()) {
    case "xpath":
      WebDriverWait wait = new WebDriverWait(getDriver(), 5); 
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getTestStep().locatorValue)));
      
      if (element != null) {
        getTestResult().isSuccess = true;
        getTestResult().resultStatement = "Is Clickable";
      } else {
        getTestResult().resultStatement = "Is Not Clickable";
      }
      
      break;
    default:
      getTestResult().resultStatement = "Unsupported locatorType:" + getTestStep().locatorType;
      logger.warn("Unsupported locatorType:" + getTestStep().locatorType);
    }    
    return getDriver();
  }

}
