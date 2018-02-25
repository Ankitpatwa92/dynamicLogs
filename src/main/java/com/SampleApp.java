package com;

import java.util.Scanner;
import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.first.First;
import com.second.Second;
import com.third.Third;

/**
 * 
 * @author ankit.patwa
 *
 */
public class SampleApp
{
		
  	Logger logger=LoggerFactory.getLogger(this.getClass());
    
    public static void main( String[] args )
    {    	
    	
    	System.out.println("Printing logs reading log levlel from log4j.properties current log level WARN\n");
    	printLogs();
    	
    	Scanner scanner=new Scanner(System.in);
    	System.out.println("\nDo you want to change log level (yes/no)");
    	String answer=scanner.next();
    	if(answer.equalsIgnoreCase("yes")) {    			
    		System.out.println("Enter package name (example com.first/com.second/com.third)");
    		String packageName=scanner.next();
    		boolean isPackageNamevalid=isPackageNameValid(packageName);
    		if(isPackageNamevalid) {
        		System.out.println("Enter log level (example DEBUG/WARN/INFO/ERROR)");
        		String logLevel=scanner.next();
        		if(logLevel==null || logLevel.equals("")) {
        			System.out.println("Invalid input");
        		}
        		setLogLevelByPackage(packageName,logLevel);
        		System.out.println("\nPrinting logs after overriding log4j.properties\n");
        		printLogs();
    		}else {
    			System.out.println("Invalid package name");
    		}
    	}
    	System.out.println("Bye!");
    	scanner.close();    	
     }

    /**
     * 
     * @param packageName
     * @return
     */
    private static boolean isPackageNameValid(String packageName) {

    	if(packageName.equals("com.first")||packageName.equals("com.second")||packageName.equals("com.third")) {
    		return true;
    	}else {
    		return false;
    	}
	}

	/**
     * 
     * @param packageName
     * @param logLevel
     */
	private static void setLogLevelByPackage(String packageName, String logLevel) {		
		org.apache.log4j.Logger customLoggerPackage = org.apache.log4j.Logger.getLogger(packageName);		
		Level loglevel=getLogLevelByName(logLevel.toUpperCase());
		customLoggerPackage.setLevel(loglevel);		
	}
    
   /**
    *  
    * @param levelName
    * @return
    */
	private static Level getLogLevelByName(String levelName) {
		
		Level newLogLevel;
		
		switch(levelName) {
		
		case "DEBUG":
			newLogLevel=Level.DEBUG;
		break;
		case "INFO":
			newLogLevel=Level.INFO;
		break;
		case "WARN":
			newLogLevel=Level.WARN;
		break;
		case "ERROR":
			newLogLevel=Level.ERROR;
		break;
		default:
			newLogLevel=Level.ALL;		
		}
		
		return newLogLevel;
	}


	private static void printLogs(){
		
    	First first=new First();
    	first.diplayLogs();
    	
    	System.out.println("");
    	Second second=new Second();
    	second.diplayLogs();
    	System.out.println("");
    	Third third=new Third();
    	third.diplayLogs();
    	System.out.println("");
	}
}
