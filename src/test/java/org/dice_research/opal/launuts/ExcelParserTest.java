package org.dice_research.opal.launuts;

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

public class ExcelParserTest {
    public static ExcelParser excelParser =  new ExcelParser();
    
    @Test
    public void testGetCodes() throws Exception {
    excelParser.setLauSourceDirectory();
    Map hm = new HashMap();
    assertEquals(402, excelParser.getCodes("DE").size());
    }
    
    @Test
    public void testCountryId() throws Exception {
        //Test 1: Confirm the no. of rows are equal tot the lauContainerlist value
        // to acheive that , first call  the parse meathod excel parser
    	excelParser.setLauSourceDirectory();
        List<String> countryIds = excelParser.getCountryIds();
        assertEquals(39, countryIds.size());
    }
    
	/*
	 * @Test public void testLauSourceDirectory() throws Exception { //Test 1:
	 * Confirm the no. of rows are equal tot the lauContainerlist value // to
	 * acheive that , first call the parse meathod excel parser
	 * 
	 * // Assert.assertTrue(excelParser.setLauSourceDirectory().matches(
	 * "^org.dice_research.opal.launuts.lau.ExcelParser"));
	 * assertEquals("org.dice_research.opal.launuts.lau.ExcelParser@7ac296f6",
	 * excelParser.setLauSourceDirectory()); }
	 */
	/*
	 * @Test public void testCodeAvailable() throws Exception{ // NUTS code DE:
	 * DEF01 // LAU code DE: 01001000 //Test 2: Test to check if the LAU and NUTS
	 * code are available in list
	 * 
	 * assertEquals(true, excelParser.getData("DEF01", "01001000")); }
	 */
    
    
}

