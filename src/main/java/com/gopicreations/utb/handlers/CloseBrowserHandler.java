package com.gopicreations.utb.handlers;

import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public class CloseBrowserHandler extends KeywordHandler {

  public CloseBrowserHandler() {
  }

  public CloseBrowserHandler(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    super(testCase, testStep, driver, testResult);
  }

  @Override
  public Keyword getKeyword() {
    return Keyword.CLOSE_BROWSER;
  }

  @Override
  public WebDriver handle() {
    getDriver().close();
    getTestResult().isSuccess = true;
    getTestResult().resultStatement = "Browser closed";
    return getDriver();
  }

}
