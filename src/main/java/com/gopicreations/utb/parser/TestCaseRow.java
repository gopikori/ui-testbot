package com.gopicreations.utb.parser;

import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

import com.gopicreations.utb.Keyword;

public class TestCaseRow {
  
  public int testCaseID;
  public boolean isExecutable;
  public String testCase;
  
  public int testStepID;
  public String testStep;
  public Keyword keyword;
  public String url;
  public String locatorType;
  public String locatorValue;
  
  public TestCaseRow(Row row, Map<String, Integer> headerIndexMap) {
    
    Cell testCaseIdCell = row.getCell(headerIndexMap.get("testCaseID".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK);
    testCaseID = (testCaseIdCell.getCellType() == Cell.CELL_TYPE_NUMERIC) ? (int)testCaseIdCell.getNumericCellValue() : 0;
    
    testCaseID = (int)row.getCell(headerIndexMap.get("testCaseID".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
    
    String strIsExecutable = row.getCell(headerIndexMap.get("isExecutable".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
    isExecutable = strIsExecutable.equals("Y");
    testCase = row.getCell(headerIndexMap.get("testCase".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
    
    testStepID = (int)row.getCell(headerIndexMap.get("testStepID".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
    testStep = row.getCell(headerIndexMap.get("testStep".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
    
    String strKeyword = row.getCell(headerIndexMap.get("keyword".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
    keyword = Keyword.valueOf(strKeyword);
    
    url = row.getCell(headerIndexMap.get("url".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
    locatorType = row.getCell(headerIndexMap.get("locatorType".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
    
    Cell locatorValueCell = row.getCell(headerIndexMap.get("locatorValue".toLowerCase()), MissingCellPolicy.CREATE_NULL_AS_BLANK);
    locatorValue  = (locatorValueCell.getCellType() == Cell.CELL_TYPE_NUMERIC) ? 
        (int)locatorValueCell.getNumericCellValue() + "" : locatorValueCell.getStringCellValue();
    
  }

  @Override
  public String toString() {
    return "TestCaseRow [testCaseID=" + testCaseID + ", isExecutable=" + isExecutable + ", testCaseName=" + testCase
        + ", testStepNo=" + testStepID + ", testStep=" + testStep + ", keyword=" + keyword + ", url=" + url
        + ", locatorType=" + locatorType + ", locatorValue=" + locatorValue + "]";
  }
  
}
