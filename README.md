# UI Test Bot

UI Test Bot is a XLS driven Keyword based UI Test Automation based on Selenium and Firefox. It takes as input an XLS file in a format as seen in example xls _src/main/resources/input.xlsx_


As of now it supports following keywords -

| Keyword         | Description   | Note   |
| --------------- | ------------- | ------------- |
| CLICK           | Click an element on a page. Supports 'xpath' locator | |
| CLOSE_BROWSER   | Close browser | |
| CHECK_CURRENT_URL | Get and verify the current url the browser is pointing to. Supports 'match' and 'contains' | |
| GET_TEXT        | Get text contents of an element | Not yet supported |
| IS_CLICKABLE    | Check if an element is clickable | Not yet supported |
| IS_DISPLAYED    | Check if an element is displayed | Not yet supported |
| NAVIGATE_TO     | Open a web page| |
| PUT_TEXT        | Set contents of a input/text box | Not yet supported |

#Pre-requisites
Below are example paths that must be set before compiling.

	export JAVA_HOME=/c/Program\ Files/Java/jdk1.8.0_45/
	export M2_HOME=/c/user/installed/apache-maven-3.3.9
	export PATH=$M2_HOME/bin:$JAVA_HOME/bin:$PATH

Note : Maven related paths are not required if you only want to _run_ the project using an already compiled jar.


#To compile
	mvn clean package


# To run
	java -jar target/utb-0.0.1-SNAPSHOT-jar-with-dependencies.jar -f C:\\gopi\\workspace\\utb\\src\\main\\resources\\input.xlsx
	
	
To print help -	

	java -jar target/utb-0.0.1-SNAPSHOT-jar-with-dependencies.jar	-h

Notes :-
	
> Tag #END required in test cases sheet to mark end of the test cases.

# License

UI Test Bot is released under Apache 2.0 License.