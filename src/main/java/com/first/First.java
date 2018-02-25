package com.first;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author ankit.patwa
 *
 */
public class First {
	
  	Logger logger=LoggerFactory.getLogger(this.getClass());

  	/**
  	 * diplayLogs
  	 */
	public void diplayLogs() {		
		logger.info("This  is  INFO  from "+this.getClass().getName());
		logger.debug("This is  DEBUG from "+this.getClass().getName());
		logger.error("This is  ERROR from "+this.getClass().getName());
		logger.warn("This  is  WARN  from "+this.getClass().getName());
	}
}
