package com.gopicreations.utb.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public class ClickHandler extends KeywordHandler {
  
  public ClickHandler() {
  }

  public ClickHandler(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    super(testCase, testStep, driver, testResult);
  }

  @Override
  public Keyword getKeyword() {
    return Keyword.CLICK;
  }

  @Override
  public WebDriver handle() throws Exception {
    WebDriverWait wait = new WebDriverWait(getDriver(),5);
    
    switch (getTestStep().locatorType.toLowerCase()) {
    case "xpath":
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getTestStep().locatorValue)));    
      getDriver().findElement(By.xpath(getTestStep().locatorValue)).click();
      getTestResult().isSuccess = true;
      getTestResult().resultStatement = "Clicked";
      break;
    default:
      getTestResult().resultStatement = "Unsupported locatorType:" + getTestStep().locatorType;
      logger.warn("Unsupported locatorType:" + getTestStep().locatorType);
    }
    return getDriver();
  }

}
