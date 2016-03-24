package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.UkPostCodeValidator;

public class UkPostCodeValidator2Test {

	
	
	@Test
	public void testIsNotTooLong() throws UkTooLongPostCodeException {
		
		boolean tooLong = true;
		
		String postCode = "TF10 6QR";
	
		tooLong = UkPostCodeValidator.isTooLong(postCode);
			
		assertEquals(false, tooLong);
	}
	
	@Test 
	public void testIsToolong() {
		
		boolean result = false;
		
        String postCode = "TF1111A 6QR";
		
	    result = UkPostCodeValidator.isTooLong(postCode);
			
		assertEquals(true, result);

	}
    
	
	@Test
	public void testIsNotTooShort() {
    
		boolean tooShort = true;
		
		String postCode = "TF10 6QR";
		
	    tooShort = UkPostCodeValidator.isTooShort(postCode);
			
		assertEquals(false, tooShort);
	
	}
	

	@Test
	public void testIsTooShort() {
		
		boolean tooShort = false;
		
        String postCode = "TF 6R";
		
	    tooShort = UkPostCodeValidator.isTooShort(postCode);
			
		assertEquals(true, tooShort);

	}

	
	@Test
	public void testUnusedValid() {
		
		boolean isUnused = false;
		
		String valid 	= "QF1 6QR";
		
		isUnused = UkPostCodeValidator.unused(valid);
		
		assertEquals(true, isUnused);
	}

	@Test
	public void testUnusedInvalid() {
		
		boolean isUnused = false;
		
		String invalid 	= "QFS1 6QR";
		
		isUnused = UkPostCodeValidator.unused(invalid);
		
		assertEquals(false, isUnused);
	}
	
	@Test
	public void testUnusedIsUsed() {
		
		boolean isUsed = false;
		
		String valid = "TF1 6QR";
		
		isUsed = UkPostCodeValidator.unused(valid);
		
		assertEquals(false, isUsed);
	}
	
	@Test
	public void testValidateCorrect() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean valid = false;
		
		String postcode = "TF1 6QR";
		
		valid = UkPostCodeValidator.validate(postcode);
		
		assertEquals(true, valid);
	}
	
	@Test(expected = UkAlphaNumericPostCodeException.class)
	public void testValidateAlphaNumeric() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean valid = true;
		
		String postcode = "QJA ACC";
		
		valid = UkPostCodeValidator.validate(postcode);

		assertEquals(false, valid);
	}
	
	@Test(expected = UkTooLongPostCodeException.class)
	public void testValidateTooLong() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean valid = true;
		
		String postcode = "ABBB3 4DLLL";
		
		valid = UkPostCodeValidator.validate(postcode);
		
		assertEquals(false, valid);
	}
	
	@Test(expected = UkTooShortPostCodeException.class)
	public void testValidateTooShort() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean valid = true;
		
		String postcode = "A3 4D";
		
	    valid = UkPostCodeValidator.validate(postcode);
		
		assertEquals(false, valid);
	}
	
	@Test
	public void testMatch() {
		
		String postCode 	= "TF1 6QR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.match(postCode);
		
		assertEquals(true, isValid);
	}
	
	@Test
	public void testFirstPositionValid() {
		
		String postCode = "TF1 6QR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.firstPositionValid(postCode);
		
		assertEquals(true, isValid);
	}
	
	
	
	@Test
	public void testFirstPositionInvalid() {
		
		String postCode = "QF1 6QR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.firstPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	
	@Test
	public void testSecondPositionValid() {
		
		String postCode = "TF1 6QR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.secondPositionValid(postCode);
		
		assertEquals(true, isValid);
	}
	
	
	@Test
	public void testSecondPositionInvalid() {
		
		String postCode = "TI1 6QR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.secondPositionValid(postCode);
		
		assertEquals(false, isValid);
	}
	
	
	@Test
	public void testThirdPositionValid() {
		
		String postCode = "TF1 6QR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.thirdPositionValid(postCode);
		
		assertEquals(true, isValid);
	}
	
	
	@Test
	public void testThirdPositionInvalid() {
		
		String postCode = "TFI 6IR";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.thirdPositionValid(postCode);
		
		assertEquals(false, isValid);
	}
	
	
	@Test
	public void testFourthPositionValid() {
		
		String postCode = "TF10 7DN";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.fourthPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testFourthPositionInvalid() {
		
		String postCode = "TF1C 7DN";
		
		boolean isValid = false;
		
		isValid = UkPostCodeValidator.fourthPositionValid(postCode);
		System.out.println("4" + isValid);
		assertEquals(false, isValid);
	}
	
	@Test
	public void testGetOutwardCode() {
		
		boolean correct = false;
		
		String postcode = "TF2 4LR";
		
		String outwardCode = UkPostCodeValidator.getOutwardCode(postcode);
		
		if(outwardCode.equals("TF2")){
			correct = true;
		}
	
		assertEquals(true, correct);
	}
    
    
	@Test
	public void testGetInwardCode() {
    
		boolean correct = false;
		
		String postcode = "TF2 4LR";
		
		String inwardCode = UkPostCodeValidator.getInwardCode(postcode);
		
		if(inwardCode.equals("4LR")){
			correct = true;
		}
		
		assertEquals(true, correct);
	}
	
    
	@Test
	public void testOutwardValid() {
	
		boolean valid = false;
		
		String postcode1 = "TF2 7BA";
		
		valid = UkPostCodeValidator.outwardValid(postcode1);
		
		assertEquals(true, valid);	
	}
	
	
	@Test
	public void testOutwardValidIncorrect() {
	
		boolean valid = true;
		
		String postcode1 = "TTTT 7BA";
	
		valid = UkPostCodeValidator.outwardValid(postcode1);

		assertEquals(false, valid);
	}

    
	@Test
	public void testInwardValid() {
		
		boolean valid = false;
		
        String postcode = "TF2 7BA";
		
		valid = UkPostCodeValidator.inwardValid(postcode);
		
		assertEquals(true, valid);
	}
	
	
	@Test
	public void testInwardValidIncorrect() {
		
		boolean correct = true;
		
		String postcode = "TF2 ABA";
		
		correct = UkPostCodeValidator.inwardValid(postcode);
		
		assertEquals(false, correct);
	}

    
	@Test
	public void testIsBFPO() {
		
		boolean isBfpo = false;
		
		String postcode = "BFPO 678";
		
		isBfpo = UkPostCodeValidator.isBFPO(postcode);
		
		assertEquals(true, isBfpo);
	}

	@Test
	public void testIsBF1() {
		
		boolean isBf1 = false;
		
		String postcode = "BF1 3AA";
		
		isBf1 = UkPostCodeValidator.isBF1(postcode);
		
		assertEquals(true, isBf1);
	}
	
	@Test
	public void testIsNotBFPO() {
		
		boolean isBfpo = true;
		
		String postcode = "BFP 628";
		
		isBfpo = UkPostCodeValidator.isBFPO(postcode);
		
		assertEquals(false, isBfpo);
	}
}