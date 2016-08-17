package com.gopicreations.utb.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gopicreations.utb.Keyword;

public class ClickHandler extends KeywordHandler {

  @Override
  public Keyword getKeyword() {
    return Keyword.CLICK;
  }

  @Override
  public WebDriver handle() throws Exception {
    WebDriverWait wait = new WebDriverWait(driver,5);
    
    switch (testStep.locatorType) {
    case "xpath":
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(testStep.locatorValue)));    
      driver.findElement(By.xpath(testStep.locatorValue)).click();
      testResult.isSuccess = true;
      testResult.resultStatement = "Clicked";
      break;
    default:
      testResult.resultStatement = "Unsupported locatorType:" + testStep.locatorType;
      logger.warn("Unsupported locatorType:" + testStep.locatorType);
    }
    return driver;
  }

}
