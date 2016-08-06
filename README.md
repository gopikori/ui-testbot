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
	
> Tag #END required in master as well as test cases sheet