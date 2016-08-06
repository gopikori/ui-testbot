package com.gopicreations.utb;

import java.util.ArrayList;
import java.util.List;

import com.gopicreations.utb.parser.TestCaseRow;

public class TestCase {
  
  public int id;
  public boolean isExecutable;
  public String name;
  
  public List<TestStep> steps = new ArrayList<>();
  
  public TestCase(TestCaseRow testCaseRow) {
    this.id = testCaseRow.testCaseID;
    this.isExecutable = testCaseRow.isExecutable;
    this.name = testCaseRow.testCase;
  }

  public void addStep(TestStep testStep) {
    steps.add(testStep);
  }

  @Override
  public String toString() {
    return "TestCase [id=" + id + ", isExecutable=" + isExecutable + ", name=" + name + ", steps=" + steps + "]";
  }
  
}
