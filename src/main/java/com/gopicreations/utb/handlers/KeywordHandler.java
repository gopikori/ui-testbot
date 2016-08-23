package com.gopicreations.utb.handlers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public abstract class KeywordHandler {

  private TestCase testCase;
  private TestStep testStep;
  private WebDriver driver;
  private TestResult testResult;
  
  protected Logger logger = Logger.getLogger(getClass());
  
  abstract public Keyword getKeyword();
  
  abstract public WebDriver handle() throws Exception;
  
  public KeywordHandler() {
  }

  public KeywordHandler(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    this.testCase = testCase;
    this.testStep = testStep;
    this.driver = driver;
    this.testResult = testResult;
  }

  public TestCase getTestCase() {
    return testCase;
  }

  public TestStep getTestStep() {
    return testStep;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public TestResult getTestResult() {
    return testResult;
  }
  
}
