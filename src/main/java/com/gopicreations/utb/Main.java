package com.gopicreations.utb;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.log4j.Logger;

import com.gopicreations.utb.parser.XlsReader;
import com.gopicreations.utb.result.TestResult;

public class Main {
  
  public static void main(String[] args) throws Exception {
    
    Logger logger = Logger.getLogger(Main.class);
    
    Options options = new Options();

    options.addOption("f",  "automation-xlsx", true, "Required. Input xlsx file full path.");
    options.addOption("h", "help", false, "Print this help");

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse( options, args);
    

    if (cmd.hasOption('h')) {

      HelpFormatter formatter = new HelpFormatter();
      formatter.printHelp( "java -jar target/uta-0.0.1-SNAPSHOT-jar-with-dependencies.jar", options);
      System.exit(0); //Exit after printing help

    }

    if (!cmd.hasOption('f')) {
      System.out.println("Automation xlsx must be specified.");
      System.exit(0);
    }

    String filePath = cmd.hasOption("f") ? cmd.getOptionValue('f') : "";
    logger.info("Executing tests from "+ filePath);
    
    XlsReader xlsReader = new XlsReader(filePath);
    List<TestCase> testCases = xlsReader.getTestCases();
    
    logger.info("Test cases read\n" + testCases);
    
    TestExecutor testExecutor = new TestExecutor(testCases);
    List<TestResult> results = testExecutor.executeTests();
    
    System.out.println(" ########################### TEST REPORT ##################################");
    results.forEach(result -> System.out.println(result));
    
    System.out.println("");
    System.out.println("Total Tests Executed : " + results.size());
    System.out.println("Tests Successful     : " + results.stream().filter(r -> r.isSuccess).count());
    System.out.println("Tests Failed         : " + results.stream().filter(r -> !r.isSuccess).count());
    System.out.println(" ##########################################################################");

  }

}
