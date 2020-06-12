package org.dice_research.opal.launuts;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.dice_research.opal.launuts.lau.ExcelParser;
import org.dice_research.opal.launuts.lau.LauContainer;
import org.junit.Test;

import java.io.IOException;
import java.util.List;


/*
 * This class implements the test cases for class ExcelParser.
 * It test for the container size, Header size of input file and available nut codes.
 *
 * Runs test cases sequentially to decrease the runtime
 *
 * Author: Amit Kumar
 *
 *
 * */

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExcelParserTest {
    public static ExcelParser excelParserDE = new ExcelParser();
    public static ExcelParser excelParserUK = new ExcelParser();


    @Test
    public void a_testGetCodes() throws Exception {
        // confirms the number of nuts mapped
        excelParserDE.setLauSourceDirectory();
        assertEquals(401, excelParserDE.getCodes("DE").size());
    }

    @Test
    public void b_testCountryId() throws Exception {
        //confirms the no . of countries in the xlsx
        //excelParser.setLauSourceDirectory();
        //excelParserDE.setLauSourceDirectory();
        List<String> countryIds = excelParserDE.getCountryIds();
        assertEquals(39, countryIds.size());
    }

    @Test
    public void c_testDEContainer1() throws Exception {
        //Test: Checking if the container is fetching correct value
        //excelParserDE.setLauSourceDirectory();
        LauContainer file_name = excelParserDE.getData("DEF04", "01004000");
        assertEquals("Neumünster | Neumünster, Stadt | 01004000", file_name.toString());
    }

    @Test
    public void d_testDEContainer2() throws Exception {
        //Test: Checking if the container is fetching correct value
        //excelParserDE.setLauSourceDirectory();
        LauContainer file_name = excelParserDE.getData("DE93A", "03360006");
        assertEquals("Ebstorf | Ebstorf,Klosterflecken | 03360006", file_name.toString());
    }

    @Test
    public void e_testHeaderSize() throws Exception {
        //Test: Checking the size of header(Number of columns) in container.

        int header_size = excelParserDE.getKeys().size();
        assertEquals(20, header_size);
    }

    @Test
    public void f_testContainerUK() throws Exception {
        //Test: Checking if container is not empty for country code : UK

        excelParserUK.setLauSourceDirectory();
        boolean hm = excelParserUK.getCodes("UK").isEmpty();
        assertEquals(false, hm);
    }

    @Test
    public void g_testGetCodesUK() throws Exception {
        //Test: Checking the number of rows available in country code DE

        assertEquals(179, excelParserUK.getCodes("UK").size());

    }

    @Test
    public void h_testUKContainer1() throws Exception {
        //Test: Checking ifthe container is fetching correct value
        //excelParserUK.setLauSourceDirectory();

        LauContainer file_name = excelParserUK.getData("UKF11", "E06000015");
        assertEquals("Derby |  | E06000015", file_name.toString());
    }

}