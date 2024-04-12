package com.sdet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Step definitions for multi-currency conversion feature.
 * Author: Lovekesh Patel
 * Date: 04/11/2024
 */

public class ConfigReader {

	private static final Logger LOG = LogManager.getLogger(ConfigReader.class);
	private static FileInputStream fis;
	private static Properties prop = null;

	public static String getProperty(String property) {

		try {
			fis = new FileInputStream(new File("config.properties"));
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnf) {
			LOG.error("Config File Not Found", fnf);
		} catch (IOException ioe) {
			LOG.error("IO Exception while loading Config File", ioe);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				LOG.error("IO Exception while closing file input stream", e);
			}
		}
		return prop.getProperty(property).trim();
	}

}
