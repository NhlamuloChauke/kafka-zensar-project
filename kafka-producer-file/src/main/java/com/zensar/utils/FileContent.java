package com.zensar.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author nhlamulo
 * @since  18/07/2021
 */
public class FileContent {

	private static final Logger LOG = LoggerFactory.getLogger(FileContent.class);

	public static String readFileContent(String filePath){
		Path fileName = Path.of(filePath);
		String fileContent = null;
		try {
			fileContent = Files.readString(fileName);
		} catch (IOException e) {
			LOG.error("Error Message {}", e.getMessage());
		}
		return fileContent;
	}
	
	public static void main(String[] args) {
		String filePath = "../data/Person.json";
		System.out.println(readFileContent(filePath));
	}
}
