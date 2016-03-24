package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import co.uk.krisdan.postcode.validators.PostCodeValidator;

public class PostCodeValidatorTest {

	@Test
	public void testIsNumeric() {
		
		boolean isNumeric = false;
		
		String num = "010101";
		
		isNumeric = PostCodeValidator.isNumeric(num);
		
		assertEquals(true, isNumeric);
	}
	
	@Test
	public void testIsNotNumeric() {
		
		boolean isNumeric = true;
		
		String alphaNum = "01d0101";
		
		isNumeric = PostCodeValidator.isNumeric(alphaNum);
		
		assertEquals(false, isNumeric);
	}
	

	@Test
	public void testIsAlpha() {
		
		boolean isAlpha = false;
		
		String alpha = "abcdef";
		
		isAlpha = PostCodeValidator.isAlpha(alpha);
		
		assertEquals(true, isAlpha);
	}
	
	@Test
	public void testIsNotAlpha() {
		
		boolean isAlpha = true;
		
		String alphaNum = "abcdef1";
		
		isAlpha = PostCodeValidator.isAlpha(alphaNum);
		
		assertEquals(false, isAlpha);
	}
	

	@Test
	public void testIsAlphaNumeric() {
		
		boolean isAlphaNum = false;
		
		String alphaNum = "ab12c3";
		
		isAlphaNum = PostCodeValidator.isAlphaNumeric(alphaNum);
		
		assertEquals(true, isAlphaNum);
	}
	
	@Test
	public void testIsNotAlphaNumeric() {
		
		boolean numResult = true;
		
		String numeric = "13429";
		
		numResult = PostCodeValidator.isAlphaNumeric(numeric);
		
		assertEquals(false, numResult);
	}

	@Test
	public void testGetForbidenCharsArrayCorrectAmount() {
		
		boolean forbidenChars = false;
		
		  int correctAmount = 33;
		  
		  ArrayList<Character> list = PostCodeValidator.getForbidenCharsArray();
		  
		  int amount = list.size();
		  
		  forbidenChars = (correctAmount == amount);
		  
		  assertEquals(true, forbidenChars);	  
	}
	
	@Test
	public void testGetForbidenCharsCanadaCorrect() {
		
		boolean hasPermittedChars = false;
		
		Character permitted = ' ';
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("Canada");
		
		hasPermittedChars = forbidenChars.contains(permitted);
		
		assertEquals(false, hasPermittedChars);
	}
	
	@Test
	public void testGetForbidenCharsUsCorrect() {
		
		boolean hasPermittedChars = false;
		
		Character permitted = '-';
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United States");
		
		hasPermittedChars = forbidenChars.contains(permitted);
	
		assertEquals(false, hasPermittedChars);
	}

	@Test
	public void testGetForbidenCharsUkCorrect() {
		
		boolean hasPermittedChars = false;
		
		Character permitted = ' ';
		
		ArrayList<Character> forbidenChars = PostCodeValidator.getForbidenCharsByCountry("United Kingdom");
		
		hasPermittedChars = forbidenChars.contains(permitted);
		
		assertEquals(false, hasPermittedChars);
	}

	@Test
	public void testHasForbidenCharsUs() {
		
		boolean hasForbidenChars = false;
		
		String postcode = "73012-1&34";
		
		String country = "united states";
		
		hasForbidenChars = PostCodeValidator.hasForbidenChars(postcode, country);
		
		assertEquals(true, hasForbidenChars);
	}

	@Test
	public void testHasForbidenCharsUk() {
		
		boolean hasForbidenChars = false;
		
		String postcode = "tf16&r";
		
		String country = "united kingdom";
		
		hasForbidenChars = PostCodeValidator.hasForbidenChars(postcode, country);
		
		assertEquals(true, hasForbidenChars);
	}
	
	@Test
	public void testHasForbidenCharsCa() {
		
		boolean hasForbidenChars = false;
		
		String postcode = "T2C 0V%";
		
		String country = "canada";
		
		hasForbidenChars = PostCodeValidator.hasForbidenChars(postcode, country);
		
		assertEquals(true, hasForbidenChars);
	}
	
	@Test
	public void testHasForbidenCharsFr() {
		
		boolean hasForbidenChars = false;
		
		String postcode = "1820£";
		
		String country = "france";
		
		hasForbidenChars = PostCodeValidator.hasForbidenChars(postcode, country);
		
		assertEquals(true, hasForbidenChars);
	}
}