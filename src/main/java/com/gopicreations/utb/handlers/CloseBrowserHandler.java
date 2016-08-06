package com.gopicreations.utb.handlers;

import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;

public class CloseBrowserHandler extends KeywordHandler {

  @Override
  public Keyword getKeyword() {
    return Keyword.CLOSE_BROWSER;
  }

  @Override
  public WebDriver handle() {
    driver.close();
    testResult.isSuccess = true;
    testResult.resultStatement = "Browser closed";
    return driver;
  }

}
