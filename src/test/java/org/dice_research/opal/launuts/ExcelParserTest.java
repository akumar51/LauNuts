package org.dice_research.opal.launuts;

import org.apache.poi.ss.usermodel.Row;
import org.dice_research.opal.launuts.dbpedia.DbpediaPlaceContainer;
import org.dice_research.opal.launuts.lau.ExcelParser;
import org.dice_research.opal.launuts.lau.LauContainer;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
 * This class implements the test cases for class ExcelParser. 
 * It test for the container size, Header size of input file and available nut codes.
 * 
 * Author: Amit Kumar
 * 
 * 
 * */

public class ExcelParserTest {

    public static ExcelParser excelParser =  new ExcelParser();
	
    public static void intialMethodCallExcelParser() throws IOException {
    	// This method is initial starting point for ExcelParser. 
    	// Call this function first if individual test cases needs to be executed
    	
    	excelParser.setLauSourceDirectory();
    }
    @Test
	public void testContainerDE() throws Exception {
		//Test : Checking if container is not empty for country code : DE 
    	
    	intialMethodCallExcelParser();
		boolean hm = excelParser.getCodes("DE").isEmpty();
		assertEquals(false, hm);
	}
    
    @Test
    public void testGetCodesDE() throws Exception {
    	//Test: Checking the number of rows available in country code DE
    	
    	assertEquals(402, excelParser.getCodes("DE").size());
    }
    
    @Test
	public void testContainerUK() throws Exception {
		//Test: Checking if container is not empty for country code : UK
    	
		boolean hm = excelParser.getCodes("UK").isEmpty();
		assertEquals(false, hm);
	}
    
    @Test
	public void testGetCodesUK() throws Exception {
		//Test: Checking the number of rows available in country code DE
    	
		assertEquals(402, excelParser.getCodes("UK").size());
		
	}
    
    @Test
    public void testCountryId() throws Exception {
        //Test: Checking the number of country id's fetched
    	
        List<String> countryIds = excelParser.getCountryIds();
        assertEquals(39, countryIds.size());
    }

	@Test
	public void testHeaderSize() throws Exception {
		//Test: Checking the size of header(Number of columns) in container. 
		
		int header_size = excelParser.getKeys().size();
		assertEquals(20, header_size);
	}
	
	@Test
	public void testFileName() throws Exception {
		//Test: Checking if the file name parsed is correct
		
		String file_name = excelParser.FILE_NAME;
		assertEquals("EU-28-LAU-2019-NUTS-2016.xlsx", file_name);
	}
}