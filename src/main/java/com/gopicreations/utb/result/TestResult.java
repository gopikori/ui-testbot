package com.gopicreations.utb.result;

import com.gopicreations.utb.TestCase;

public class TestResult {
  
  public TestCase testCase;
  
  public boolean isSuccess;
  public String resultStatement;

  public TestResult(TestCase testCase) {
    this.testCase = testCase;
  }

  @Override
  public String toString() {
    return "TestResult [isSuccess=" + isSuccess + ", resultStatement=" + resultStatement + "]";
  }

}
