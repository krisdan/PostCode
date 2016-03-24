package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.CanadianPostCodeValidator;

public class CanadianPostCodeValidatorTest {

	@Test
	public void testIsNotTooLong() throws CaTooLongPostCodeException {

		boolean result = false;

		String postCode = "T2C 0V3";

		result = !CanadianPostCodeValidator.isTooLong(postCode);

		assertEquals(true, result);
	}

	@Test
	public void testIsTooLong() throws CaTooLongPostCodeException {

		boolean result = false;

		String postCode = "T2C 0V3A";

		result = CanadianPostCodeValidator.isTooLong(postCode);

		assertEquals(true, result);
	}

	@Test
	public void testIsNotTooShort() throws CaTooShortPostCodeException {

		boolean result = false;

		String postCode = "T2C 0V3";

		result = !CanadianPostCodeValidator.isTooShort(postCode);

		assertEquals(true, result);
	}

	@Test
	public void testIsTooShort() {

		boolean result = false;

		String postCode = "T2C";

		result = CanadianPostCodeValidator.isTooShort(postCode);

		assertEquals(true, result);
	}

	@Test
	public void testFirstPositionValid() {
		
		String postCode = "A2V 0V3";
		
		boolean isValid = false;

		isValid = CanadianPostCodeValidator.firstPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testFirstPositionInvalid() {

		String postCode = "D2V 0V3";
		
		boolean isValid = false;

		isValid = CanadianPostCodeValidator.firstPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	@Test
	public void testSecondPositionValid() {

		String postCode = "A2V 0V3";
		
		boolean isValid = false;

		isValid = CanadianPostCodeValidator.secondPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testSecondPositionInvalid() {

		String postCode = "AAV 0V3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.secondPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	@Test
	public void testThirdPositionValid() {

		String postCode = "A2V 0V3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.thirdPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testThirdPositionInvalid() {

		String postCode = "A2D 0V3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.thirdPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	@Test
	public void testFourthPositionValid() {

		String postCode = "A2A 0V3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.fourthPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testFourthPositionInvalid() {

		String postCode = "A2A DV3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.fourthPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	@Test
	public void testFithPositionValid() {

		String postCode = "A2A 0V3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.fithPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testFithPositionInvalid() {

		String postCode = "A2A 0D3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.fithPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	@Test
	public void testSixthPositionValid() {

		String postCode = "A2A 0V3";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.sixthPositionValid(postCode);
		
		assertEquals(true, isValid);
	}

	@Test
	public void testSixthPositionInvalid() {

		String postCode = "A2A 0VA";

		boolean isValid = false;

		isValid = CanadianPostCodeValidator.sixthPositionValid(postCode);
		
		assertEquals(false, isValid);
	}

	@Test
	public void testIsUnused() {

		boolean result = false;

		String postCode = "J4A 1L0";

		result = CanadianPostCodeValidator.unused(postCode);

		assertEquals(true, result);
	}

	@Test
	public void testIsNotUnused() throws CaUnusedPostCodeException {

		boolean used = false;

		String postCode = "T2C 0V3";

		used = !CanadianPostCodeValidator.unused(postCode);

		assertEquals(true, used);
	}

	@Test
	public void testGetFSACode() {

		String postcode = "T2C 0V3";

		String fsa = CanadianPostCodeValidator.getFSACode(postcode);

		boolean ans = (fsa.equals("T2C"));

		assertEquals(true, ans);
	}

	@Test
	public void testGetLDUCode() {

		boolean result = false;

		String postcode = "T2C 0V3";

		String ldu = CanadianPostCodeValidator.getLDUCode(postcode);

		result = (ldu.equals("0V3"));

		assertEquals(true, result);
	}

	@Test
	public void testFsaValid() {

		boolean result = false;

		String postCode = "T2C 0V3";

		result = CanadianPostCodeValidator.fsaValid(postCode);

		assertEquals(true, result);
	}

	@Test
	public void testFsaInvalid() {

		String postCode1 = "D2C 0V3";
		String postCode2 = "TAC 0V3";
		String postCode3 = "T2D 0V3";

		boolean result1 = CanadianPostCodeValidator.fsaValid(postCode1);
		boolean result2 = CanadianPostCodeValidator.fsaValid(postCode2);
		boolean result3 = CanadianPostCodeValidator.fsaValid(postCode3);

		assertEquals(false, result1);
		assertEquals(false, result2);
		assertEquals(false, result3);
	}

	@Test
	public void testLduValid() {

		boolean result = false;

		String postCode = "T2C 0V3";

		result = CanadianPostCodeValidator.lduValid(postCode);

		assertEquals(true, result);
	}

	public void testLduInvalid() {

		String postCode1 = "T2C AV3";
		String postCode2 = "T2C 0D3";
		String postCode3 = "T2C 0VA";

		boolean result1 = CanadianPostCodeValidator.lduValid(postCode1);
		boolean result2 = CanadianPostCodeValidator.lduValid(postCode2);
		boolean result3 = CanadianPostCodeValidator.lduValid(postCode3);

		assertEquals(false, result1);
		assertEquals(false, result2);
		assertEquals(false, result3);
	}

	@Test
	public void testValidate() throws CaAlphaNumericPostCodeException,
			CaUnusedPostCodeException, CaTooLongPostCodeException,
			CaTooShortPostCodeException {

		boolean result = false;

		String postCode = "T2C 0V3";

		result = CanadianPostCodeValidator.validate(postCode);

		assertEquals(true, result);
	}

	@Test(expected = CaAlphaNumericPostCodeException.class)
	public void testValidateIsNotAlpaNum()
			throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException,
			CaTooLongPostCodeException, CaTooShortPostCodeException {

		String postCode = "182000";

		CanadianPostCodeValidator.validate(postCode);
	}

	@Test
	public void testValidateIsUnusd() throws CaAlphaNumericPostCodeException,
			CaUnusedPostCodeException, CaTooLongPostCodeException,
			CaTooShortPostCodeException {

		boolean result = false;

		String postCode = "D2D 0D3";

		result = CanadianPostCodeValidator.validate(postCode);

		assertEquals(false, result);
	}

	@Test(expected = CaTooLongPostCodeException.class)
	public void testValidateIsTooLong() throws CaAlphaNumericPostCodeException,
			CaUnusedPostCodeException, CaTooLongPostCodeException,
			CaTooShortPostCodeException {

		boolean result = false;

		String postCode = "T2C 0V3A";

		result = CanadianPostCodeValidator.validate(postCode);

		assertEquals(false, result);
	}

	@Test(expected = CaTooShortPostCodeException.class)
	public void testValidateIsTooShort()
			throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException,
			CaTooLongPostCodeException, CaTooShortPostCodeException {

		boolean result = false;

		String postCode = "T2C 0V";

		result = CanadianPostCodeValidator.validate(postCode);

		assertEquals(true, result);
	}

}