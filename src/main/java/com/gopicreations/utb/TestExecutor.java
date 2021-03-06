package com.gopicreations.utb;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gopicreations.utb.handlers.CheckCurrentUrlHandler;
import com.gopicreations.utb.handlers.ClickHandler;
import com.gopicreations.utb.handlers.CloseBrowserHandler;
import com.gopicreations.utb.handlers.IsClickableHandler;
import com.gopicreations.utb.handlers.KeywordHandler;
import com.gopicreations.utb.handlers.NavigateToHandler;
import com.gopicreations.utb.parser.XlsReader;
import com.gopicreations.utb.result.TestResult;

public class TestExecutor {

  private List<TestCase> testCases;
  
  private Map<Keyword, Class<? extends KeywordHandler>> keywordHandlers = new HashMap<>();
  
  private Logger logger = Logger.getLogger(XlsReader.class);

  public TestExecutor(List<TestCase> testCases) throws Exception {
    this.testCases = testCases;
    
    List<Class<? extends KeywordHandler>> handlers = new ArrayList<>();
    handlers.add(NavigateToHandler.class);
    handlers.add(CloseBrowserHandler.class);
    handlers.add(ClickHandler.class);
    handlers.add(CheckCurrentUrlHandler.class);
    handlers.add(IsClickableHandler.class);

    for (Class<? extends KeywordHandler> handler : handlers) {
      keywordHandlers.put(handler.newInstance().getKeyword(), handler);
    }
    logger.info("All Active Handlers : " + keywordHandlers);
  }

  public List<TestResult> executeTests() throws Exception {

    List<TestResult> testResults = new ArrayList<>();
    try {

      WebDriver driver = getWebDriver();

      for (TestCase testCase : testCases) {

        if (!testCase.isExecutable) {
          logger.info("Skipping testCase:" + testCase);
          continue;
        }

        if (driver == null) { // This may have been set to null if 'CLOSE_BROWSER' is executed.
          driver = getWebDriver();
        }

        TestResult testResult = new TestResult(testCase);
        testResults.add(testResult);

        logger.info("######## Execuing test case:[" + testCase.id + "]" + testCase.name);

        for (TestStep step : testCase.steps) {
          logger.info("  ###### Execuing test step:[" + step.id + "]" + step.keyword + ":" + step.name);
          try {
            Class<? extends KeywordHandler> handlerClass = keywordHandlers.get(step.keyword);

            if (handlerClass != null) {
              Constructor<? extends KeywordHandler> handlerConstructor = handlerClass.getDeclaredConstructor(TestCase.class, TestStep.class, WebDriver.class, TestResult.class);
              KeywordHandler handler = handlerConstructor.newInstance(testCase, step, driver, testResult);
              driver = handler.handle();
              logger.debug("Result=" + testResult);
            } else {
              logger.warn("Unsupported/Excluded Keyword: " + step.keyword);
            }
          } catch (Exception ex) {
            testResult.isSuccess = false;
            testResult.resultStatement = ex.getMessage();
          }
        }
        
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return testResults;
  }

  
  private WebDriver getWebDriver() throws Exception {
    
    FirefoxProfile profile = new FirefoxProfile();

    addExtenstions(profile);

    DesiredCapabilities cap = DesiredCapabilities.firefox();
    cap.setCapability(FirefoxDriver.PROFILE, profile);
    WebDriver driver = new FirefoxDriver(cap);
    return driver;
  }

  /**
   * Extensions may be added to the Firefox here.
   */
  private void addExtenstions(FirefoxProfile profile) throws IOException, FileNotFoundException {
    //profile.addExtension("/path/to/.xpi file");
  }

}
