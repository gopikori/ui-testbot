package com.gopicreations.utb.handlers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.gopicreations.utb.Keyword;
import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;
import com.gopicreations.utb.result.TestResult;

public abstract class KeywordHandler {

  protected TestCase testCase;
  protected TestStep testStep;
  protected WebDriver driver;
  protected TestResult testResult;
  
  protected Logger logger = Logger.getLogger(getClass());
  
  abstract public Keyword getKeyword();
  
  abstract public WebDriver handle() throws Exception;
  
  public void init(TestCase testCase, TestStep testStep, WebDriver driver, TestResult testResult) {
    this.testCase = testCase;
    this.testStep = testStep;
    this.driver = driver;
    this.testResult = testResult;
  }
}
