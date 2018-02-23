/**
 * 
 */
package com.raj.sampleprogram.zipcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author raja
 *
 */
public class ZipCodeAnalyserTest {

	static ZipCodeAnalyser zipCodeAnalyser;
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		zipCodeAnalyser = new ZipCodeAnalyser();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		zipCodeAnalyser=null;
	}

	@Test
	public void testNullList() {
		List<Integer[]> zipCodeList=zipCodeAnalyser.removeOverLap(null);
		assertEquals(null, zipCodeList);
	}

	@Test
	public void testNoOverLap() {
		Integer[][] zipCodeRanges = { { 94133, 94133 }, { 94200, 94299 }, { 94400,94499}, { 94670, 94899 } };
		List<Integer[]> zipCodeList=zipCodeAnalyser.removeOverLap(new ArrayList<Integer[]>(Arrays.asList(zipCodeRanges)));
		assertEquals(4, zipCodeList.size());
	}
	
	@Test
	public void testOverLapInEnd() {
		Integer[][] zipCodeRanges = { { 94133, 94133 }, { 94200, 94299 }, { 94600,94699}, { 94670, 94899 } };
		Integer[][] actualzipCodeRanges = { { 94133, 94133 }, { 94200, 94299 }, { 94600,94899}};
		Integer[][] expectedZipCodeRanges = { { 94133, 94133 }, { 94200, 94299 }, { 94600,94899} };
		
		List<Integer[]> zipCodeList=zipCodeAnalyser.removeOverLap(new ArrayList<Integer[]>(Arrays.asList(zipCodeRanges)));
		assertEquals(3, zipCodeList.size());
		
		List<Integer[]> actual = Arrays.asList(actualzipCodeRanges);
        List<Integer[]> expected = Arrays.asList(expectedZipCodeRanges);
        
        assertArrayEquals(actual.toArray(), expected.toArray());
	}
	
	@Test
	public void testConsecutiveOverLap() {
		Integer[][] zipCodeRanges = { { 94133, 94133 },   { 94100, 94300 }, { 94200, 94499 },  { 94410, 94600 },  { 94540, 94699 } };
		Integer[][] actualzipCodeRanges = { { 94100, 94699 }};
		Integer[][] expectedZipCodeRanges = {{ 94100, 94699 } };
		
		List<Integer[]> zipCodeList=zipCodeAnalyser.removeOverLap(new ArrayList<Integer[]>(Arrays.asList(zipCodeRanges)));
		assertEquals(1, zipCodeList.size());
		
		List<Integer[]> actual = Arrays.asList(actualzipCodeRanges);
        List<Integer[]> expected = Arrays.asList(expectedZipCodeRanges);
        
        assertArrayEquals(actual.toArray(), expected.toArray());
	}
	
	@Test
	public void testRandomOverLap() {
		Integer[][] zipCodeRanges = { { 94133, 94133 },   { 94200, 94400 }, { 94100, 94299 },  { 94510, 94670 },  { 94300, 94599 } };
		Integer[][] actualzipCodeRanges = { { 94100, 94670 }};
		Integer[][] expectedZipCodeRanges = {{ 94100, 94670 } };
		
		List<Integer[]> zipCodeList=zipCodeAnalyser.removeOverLap(new ArrayList<Integer[]>(Arrays.asList(zipCodeRanges)));
		assertEquals(1, zipCodeList.size());
		
		List<Integer[]> actual = Arrays.asList(actualzipCodeRanges);
        List<Integer[]> expected = Arrays.asList(expectedZipCodeRanges);
        
        assertArrayEquals(actual.toArray(), expected.toArray());
	}
	
	
	@Test
	public void testMultiRandomOverLap() {
		Integer[][] zipCodeRanges = {{49679, 52015}, {49800, 50000}, {51500, 53479}, {45012, 46937}, {54012, 59607},
				{45500, 45590}, {45999, 47900}, {44000, 45000}, {43012, 45950}};
		
		List<Integer[]> zipCodeList=zipCodeAnalyser.removeOverLap(new ArrayList<Integer[]>(Arrays.asList(zipCodeRanges)));
		assertEquals(3, zipCodeList.size());
		
		
	}
}
