package com.gopicreations.utb;

import com.gopicreations.utb.parser.TestCaseRow;

public class TestStep {
  
  public int id;
  public String name;
  public Keyword keyword;
  public String url;
  public String locatorType;
  public String locatorValue;
  
  public TestStep(TestCaseRow testCaseRow) {
    this.id = testCaseRow.testStepID;
    this.name = testCaseRow.testStep;
    this.keyword = testCaseRow.keyword;
    this.url = testCaseRow.url;
    this.locatorType = testCaseRow.locatorType;
    this.locatorValue = testCaseRow.locatorValue;
  }

  @Override
  public String toString() {
    return "TestStep [id=" + id + ", name=" + name + ", keyword=" + keyword + ", url=" + url + ", locatorType="
        + locatorType + ", locatorValue=" + locatorValue + "]";
  }
  
}
