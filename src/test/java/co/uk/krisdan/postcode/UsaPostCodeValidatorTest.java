package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.UsaPostCodeValidator;

public class UsaPostCodeValidatorTest {

	@Test
	public void testIsTooLong() {

		boolean tooLong = false;
		
		String postCode = "730112";	
		
	    tooLong = UsaPostCodeValidator.isTooLong(postCode);
	    
		assertEquals(true, tooLong);
	}
	
	@Test
	public void testIsTooLongPlusFour() {

		boolean tooLong = false;
		
		String postCode = "73012-12345";	
	
	    tooLong = UsaPostCodeValidator.isTooLong(postCode);
	   
		assertEquals(true, tooLong);
	}
	
	
	@Test
	public void testIsNotTooLong() {
		
		boolean tooLong = true;

		String postCode = "73012";
		
	    tooLong = UsaPostCodeValidator.isTooLong(postCode);
			
		assertEquals(false, tooLong);
	}
	
	@Test
	public void testIsNotTooLongPlusFour() {
		
		boolean tooLong = true;

		String postCode = "73012-1234";

		tooLong = UsaPostCodeValidator.isTooLong(postCode);

		assertEquals(false, tooLong);
	}
	

	@Test
	public void testIsTooShort() {
		
		 boolean tooShort = false;
		
        String postCode = "7302";
	
	    tooShort = UsaPostCodeValidator.isTooShort(postCode);
	   
		assertEquals(true, tooShort);
		
	}
	
	@Test
	public void testIsTooShortPlusFour() {
		
		boolean tooshort = false;
		
        String postCode = "73012-123";
		
	    tooshort = UsaPostCodeValidator.isTooShort(postCode);
	    
		assertEquals(true, tooshort);		
	}
	
	@Test
	public void testIsNotTooShort() {
		
		boolean tooShort = true;
		
        String postCode = "73012";
		
	    tooShort = UsaPostCodeValidator.isTooShort(postCode);
			
		assertEquals(false, tooShort);
		
	}
	
	@Test
	public void testIsNotTooShortPlusFour() {
		
		boolean tooShort = true;
		
        String postCode = "73012-1234";
		
	    tooShort = UsaPostCodeValidator.isTooShort(postCode);
			
		assertEquals(false, tooShort);
	}
	
	@Test
	public void testIsTooLow() {
		
		boolean tooLow = false;
		
        String postCode = "-2";
		
	    tooLow = UsaPostCodeValidator.isTooLow(postCode);
			
		assertEquals(true, tooLow);
	}
	
	@Test
	public void testIsNotTooLow() {
		
        boolean tooLow = true;
		
        String postCode = "73012";
		
	    tooLow = UsaPostCodeValidator.isTooLow(postCode);
			
		assertEquals(false, tooLow);
	
	}
	
	@Test
	public void testIsNotTooLowPlusFour() {
		
        boolean tooLow = true;
		
        String postCode = "73012-1231";
		
	    tooLow = UsaPostCodeValidator.isTooLow(postCode);
			
		assertEquals(false, tooLow);
	
	}

	@Test
	public void testIsTooHigh() {
		
		boolean tooHigh = false;
		
		String postCode = "100000";
		
		tooHigh = UsaPostCodeValidator.isTooHigh(postCode);
		
		assertEquals(true, tooHigh);
	}

	@Test
	public void testIsNotTooHigh() {
		
		boolean tooHigh = true;
		
		String postCode = "73012";
		
		tooHigh = UsaPostCodeValidator.isTooHigh(postCode);
		
		assertEquals(false, tooHigh);
	}
	
	@Test
	public void testIsNotTooHighPlusFour() {
		
		boolean tooHigh = true;
		
		String postCode = "73012-1234";
		
		tooHigh = UsaPostCodeValidator.isTooHigh(postCode);
		
		assertEquals(false, tooHigh);
	}
	
	@Test
	public void testIsPlusFour(){
		
		boolean plusFour = false;
		
		 String postCode = "73012-1234";
		 
		 plusFour = UsaPostCodeValidator.isPlusFour(postCode);
		 
		 assertEquals(true, plusFour);
		
	}
	
	@Test
	public void testIsNotPlusFour(){
		
		 boolean plusFour = true;
		
		 String postCode = "73012-12";
		 
		 plusFour = UsaPostCodeValidator.isPlusFour(postCode);
		 
		 assertEquals(false, plusFour);
		
	}
	
	@Test
	public void testRemovePlusFour(){
		
		 boolean removed = false;
		
		 String postCodeIn = "73012-1234";
		 
		 String postCodeOut = UsaPostCodeValidator.removePlusFour(postCodeIn);
		 
		 removed = (postCodeOut.equals("73012"));
		 
		 assertEquals(true, removed);
		
	}
	

	@Test
	public void testUnusedValid() {

		boolean unused = false;
		
		String postCode = "01000";
		
		unused = UsaPostCodeValidator.unused(postCode);
		
		assertEquals(true, unused);
		
	}
	
	@Test
	public void testUnusedInvalid() throws UsaUnusedPostCodeException {
		
		boolean valid = true;

		String unused 	= "4A00";
		
		valid = UsaPostCodeValidator.unused(unused);
		
		assertEquals(false, valid);
		
	}
	
	@Test
	public void testMatch() {
		
		String postCode 	= "73012";
		
		boolean isValid = false;
		
		isValid = UsaPostCodeValidator.match(postCode);
		
		assertEquals(true, isValid);
	}
    
	@Test
	public void testValidateValid() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean valid = false;
      
		String postcode = "73012";
		
		valid = UsaPostCodeValidator.validate(postcode);

		assertEquals(true, valid);
	}
	
	@Test (expected = UsaNumericPostCodeException.class)
	public void testValidateUsaAlphaNumeric() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean isNumeric = true;
      
		String postcode = "7A012";
		
		isNumeric = UsaPostCodeValidator.validate(postcode);

		assertEquals(false, isNumeric);
	}
	
	@Test (expected = UsaNumericPostCodeException.class)
	public void testValidateUsaAlpha() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean isNumeric = true;
      
		String postcode = "AAAAA";
		
		isNumeric = UsaPostCodeValidator.validate(postcode);

		assertEquals(false, isNumeric);
	}
	
	@Test (expected = UsaForbidenCharactersPostCodeException.class)
	public void testValidateUsaForbidenChars() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean hasForbidenChars = false;
      
		String postcode = "7&012";
		
		hasForbidenChars = UsaPostCodeValidator.validate(postcode);

		assertEquals(true, hasForbidenChars);
	}
	
	@Test (expected = UsaTooLongPostCodeException.class)
	public void testValidateUsaTooLong() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean tooLong = false;
      
		String postcode = "000000012";
		
		tooLong = UsaPostCodeValidator.validate(postcode);

		assertEquals(true, tooLong);
	}
	
	@Test (expected = UsaTooShortPostCodeException.class)
	public void testValidateUsaTooShort() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean tooShort = false;
      
		String postcode = "712";
		
		tooShort = UsaPostCodeValidator.validate(postcode);

		assertEquals(true, tooShort);
	}
	
	@Test (expected = UsaTooHighPostCodeException.class)
	public void testValidateUsaTooHigh() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean tooHigh = false;
      
		String postcode = "1000000";
		
		tooHigh = UsaPostCodeValidator.validate(postcode);

		assertEquals(true, tooHigh);
	}
	
	@Test (expected = UsaTooLowPostCodeException.class)
	public void testValidateUsaTooLow() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
	UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean tooLow = false;
      
		String postcode = "-10000";
		
		tooLow = UsaPostCodeValidator.validate(postcode);

		assertEquals(true, tooLow);
	}
}