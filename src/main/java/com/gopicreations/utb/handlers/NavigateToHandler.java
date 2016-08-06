package com.gopicreations.utb.handlers;

import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;

public class NavigateToHandler extends KeywordHandler {

  @Override
  public Keyword getKeyword() {
    return Keyword.NAVIGATE_TO;
  }

  @Override
  public WebDriver handle() {
    driver.get(testStep.url);
    testResult.isSuccess = true;
    testResult.resultStatement = "Navigated to " + testStep.url;
    return driver;
  }

}
