package com.gopicreations.utb.handlers;

import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public class NavigateToHandler extends KeywordHandler {

  public NavigateToHandler() {
  }

  public NavigateToHandler(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    super(testCase, testStep, driver, testResult);
  }

  @Override
  public Keyword getKeyword() {
    return Keyword.NAVIGATE_TO;
  }

  @Override
  public WebDriver handle() {
    getDriver().get(getTestStep().url);
    getTestResult().isSuccess = true;
    getTestResult().resultStatement = "Navigated to " + getTestStep().url;
    return getDriver();
  }

}
