package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import constants.Constants;

public class CSVReader {
	
//    private static final String SAMPLE_CSV_FILE_PATH = "./users-with-header.csv";

	/*
	 * public CSVRecord getCSVRecord(String key) throws IOException { Reader reader
	 * = Files.newBufferedReader(Paths.get(Constants.FileNamePath)); CSVParser
	 * csvParser = new CSVParser(reader, CSVFormat.DEFAULT); Boolean
	 * recordFound=false; CSVRecord csvRecord; for (CSVRecord csvRecord : csvParser)
	 * {
	 * 
	 * if(csvRecord.get(key)!=null) { recordFound=true; } } if(recordFound) return
	 * csvRecord;
	 * 
	 * }
	 */

}
