package org.dice_research.opal.launuts;

import org.dice_research.opal.launuts.dbpedia.DbpediaPlaceContainer;
import org.dice_research.opal.launuts.lau.ExcelParser;
import org.dice_research.opal.launuts.lau.LauContainer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;

public class ExcelParserTest {
    ExcelParser excelParser =  new ExcelParser();

    @Test
    public void testCountryId() throws Exception {
        //Test 1: Confirm the no. of rows are equal tot the lauContainerlist value
        // to acheive that , first call  the parse meathod excel parser

        List<String> countryIds = excelParser.getCountryIds();
        assertEquals(39, countryIds.size());
    }

    @Test
    public void testCodeAvailable() throws Exception{
        // NUTS code DE: DEF01
        // LAU code DE: 01001000
        //Test 2: Test to check if the LAU and NUTS code are available in list

        assertEquals(true, excelParser.getData("DEF01", "01001000"));
    }

}
