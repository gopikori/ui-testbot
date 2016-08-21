package com.gopicreations.utb.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gopicreations.utb.Keyword;

public class IsClickableHandler extends KeywordHandler {

  @Override
  public Keyword getKeyword() {
    return Keyword.IS_CLICKABLE;
  }

  @Override
  public WebDriver handle() throws Exception {
    
    switch (testStep.locatorType.toLowerCase()) {
    case "xpath":
      WebDriverWait wait = new WebDriverWait(driver, 5); 
      WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(testStep.locatorValue)));
      
      if (element != null) {
        testResult.isSuccess = true;
        testResult.resultStatement = "Is Clickable";
      } else {
        testResult.resultStatement = "Is Not Clickable";
      }
      
      break;
    default:
      testResult.resultStatement = "Unsupported locatorType:" + testStep.locatorType;
      logger.warn("Unsupported locatorType:" + testStep.locatorType);
    }    
    return driver;
  }

}
