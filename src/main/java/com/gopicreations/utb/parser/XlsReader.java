package com.gopicreations.utb.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gopicreations.utb.TestCase;
import com.gopicreations.utb.TestStep;

public class XlsReader {

  private XSSFWorkbook workBook;
  private List<TestCase> testCasesInfo;
  
  private Logger logger = Logger.getLogger(XlsReader.class);
  
  public XlsReader(XSSFWorkbook workBook) {
    this.workBook = workBook;
  }

  public XlsReader(String filePath) throws FileNotFoundException, IOException {

    try (XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(filePath))) {
      this.workBook = workBook;
      testCasesInfo = readTestCasesSheet();
    }
  }
  
  public List<TestCase> getTestCases() {
    return testCasesInfo;
  }

  private List<TestCase> readTestCasesSheet() {
    XSSFSheet masterSheet = workBook.getSheet("TestCases");

    Map<String, Integer> headerIndexMap = getHeaderIndexMap(masterSheet.getRow(0));

    logger.debug("TestCasesSheet: Total Columns=" + headerIndexMap.size());
    logger.debug("TestCasesSheet: headerIndexMap=" + headerIndexMap);

    Iterator<Row> rowIterator = masterSheet.rowIterator();
    rowIterator.next(); //Skip header row
    
    List<TestCase> testCases = new ArrayList<>();
    TestCase testCase = null;
    while (rowIterator.hasNext()) {
      Row row = rowIterator.next();
      
      if (row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING && "#END".equals(row.getCell(0).getStringCellValue())) {
        testCases.add(testCase);
        break;
      }
      
      TestCaseRow testCaseRow = new TestCaseRow(row, headerIndexMap);
      
      if (testCaseRow.testCaseID != 0) {
        if (testCase != null) {
          testCases.add(testCase);
        } 
        testCase = new TestCase(testCaseRow);
      }
      testCase.addStep(new TestStep(testCaseRow));
    }
    return testCases;
  }
  
  private Map<String, Integer> getHeaderIndexMap(XSSFRow row) {
    Map<String, Integer> headerIndexMap = new HashMap<>();
    final AtomicInteger columnCount = new AtomicInteger(0);
    row.forEach(cell -> {
      headerIndexMap.put(cell.getStringCellValue().toLowerCase(), columnCount.getAndIncrement());
    });
    return headerIndexMap;
  }

}
