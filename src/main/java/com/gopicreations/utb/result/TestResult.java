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
    return null;
//    String result = isSuccess ? "Success" : "Failure";
//    String trimmedResultStatement = (resultStatement != null && resultStatement.length() > 30) ? resultStatement.substring(0, 30) + "..." : resultStatement;
//    String logString = "[" + testCase.id + "](" + testCase.name + ") " + testStepNo + " " + testStep + ": "
//        + "\t RESULT=" + result + " (" + trimmedResultStatement + ")";
//    
//    return logString;
  
  }
  
  

  
}
