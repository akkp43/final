package com.mystore.utility;

import org.apache.log4j.Logger;

public class Log {

	
/**Steps to implement log4j 
 * Add log4j.xml in project
 * Add log class in utility package
 * Configure @beforeSuite in BaseClass to confugure log4j.xml
 *Need to call in methods now in testcases from log class 
 * 
 * **/	
	
	
	
	
	
	// Initialize Log4j logs
	public static Logger Log = Logger.getLogger(Log.class);
	//public static Logger Log= Logger.getLogger(Log.getClass().getName());

		public static void startTestCase(String sTestCaseName){		  
			Log.info("====================================="+sTestCaseName+" TEST START=========================================");
			 }
		
		public static void endTestCase(String sTestCaseName){
			Log.info("====================================="+sTestCaseName+" TEST END=========================================");
			 }
		
		// Need to create below methods, so that they can be called  

		 public static void info(String message) {

			 Log.info(message);

				}

		 public static void warn(String message) {

			 Log.warn(message);

			}

		 public static void error(String message) {

			 Log.error(message);

			}

		 public static void fatal(String message) {

			 Log.fatal(message);

			}

		 public static void debug(String message) {

			 Log.debug(message);

			}
		
	}


