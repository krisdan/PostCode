package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.FrenchPostCodeValidator;


public class FrenchPostCodeValidatorTest {

	@Test
	public void testIsNotTooLong() {
		
		boolean result = false;
		
		String postCode = "18200";
		
		result = !FrenchPostCodeValidator.isTooLong(postCode);
	
		assertEquals(true, result);
	}
	

	@Test
	public void testIsTooLong() {
		
		boolean result = false;
		
		String postCode = "182001";
			
		result = FrenchPostCodeValidator.isTooLong(postCode);
		
		assertEquals(true, result);
		}

	
	@Test
	public void testIsNotTooShort() {
		
		boolean result = false;
		
		String postCode = "18200";
			
		result = FrenchPostCodeValidator.isTooShort(postCode);
		
		assertEquals(false, result);
	}
	
	@Test
	public void testIsTooShort() {
		
		boolean result = false;
		
		String postCode = "1820";
			
		result = FrenchPostCodeValidator.isTooShort(postCode);
		
		assertEquals(true, result);
	}
	
    
	@Test
	public void testIsNotUnused() {
		
		boolean isInvalid = false;
		boolean isUsed = false;
		
        String invalid 	= "73452";
		String used 	= "11111";

		isInvalid = !FrenchPostCodeValidator.unused(invalid);
		isUsed = !FrenchPostCodeValidator.unused(used);
		
		assertEquals(true, isInvalid);
		assertEquals(true, isUsed);

	}
	
	
	
	@Test
	public void testIsUnused() {

		boolean result = false;
		
        String unused 	= "00999";

		result = FrenchPostCodeValidator.unused(unused);
		
		assertEquals(true, result);
		
	}
	
	
	@Test
	public void testMatch() {
		
		String postCode 	= "18200";
		
		boolean isValid = false;
		
		isValid = FrenchPostCodeValidator.match(postCode);
		
		assertEquals(true, isValid);
	}

	
	@Test
	public void testValidateCorrect() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
       
		boolean result = false;
		
		String postcode = "18200";
		
		result = FrenchPostCodeValidator.validate(postcode);
		
		assertEquals(true, result);
	}
	

	@Test(expected = FrTooLongPostCodeException.class)
	public void testValidateTooLong() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
       
		boolean valid = true;
		
		String postcode = "182001";
		
		valid = FrenchPostCodeValidator.validate(postcode);
		
		assertEquals(false, valid);
	}
	
	@Test(expected = FrTooShortPostCodeException.class)
	public void testValidateTooShort() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
       
		boolean valid = true;
		
		String postcode = "1820";
		
		valid = FrenchPostCodeValidator.validate(postcode);
		
		assertEquals(false, valid);
	}
	
	@Test
	public void testValidateUnused() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
       
		boolean result = true;
		
		String postcode = "00999";
		
		result = FrenchPostCodeValidator.validate(postcode);
	
		assertEquals(false, result);
	}
	
	@Test(expected = FrTooHighPostCodeException.class)
	public void testValidateTooHigh() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
       
		boolean valid = true;
		
		String postcode = "73451";
		
		valid = FrenchPostCodeValidator.validate(postcode);
		
		assertEquals(false, valid);
	}
	
	@Test(expected = FrTooLowPostCodeException.class)
	public void testValidateTooLow() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
       
		boolean valid = true;
		
		String postcode = "-0001";
		
        valid = FrenchPostCodeValidator.validate(postcode);
		
		assertEquals(false, valid);
	}    
    
	@Test
	public void testIsTooLow() {
		
		boolean result = false;
     
		String postcode = "-1";
		
		result = FrenchPostCodeValidator.isTooLow(postcode);
		
		assertEquals(true, result);
		
	}
    
	
	@Test
	public void testIsTooHigh() {
		
		boolean valid = false;
		
        String postcode = "73451";
		
		valid = FrenchPostCodeValidator.isTooHigh(postcode);
		
		assertEquals(true, valid);
	}
    
    
}