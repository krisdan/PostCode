package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

import co.uk.krisdan.postcode.PostCodeFormat;
import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;

public class PostCodeFormatTest {
	

	@Test
	public void testIsCanadian() throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean isCanadian = false;
		
        String caPostCode = "T6H 3C2";
		
		isCanadian = PostCodeFormat.isCanadian(caPostCode);
		
		assertEquals(true, isCanadian);
		
	}

	@Test
	public void testIsFrench() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		boolean isFrench = false;
		
		String frPostCode = "35000";
		
		isFrench = PostCodeFormat.isFrench(frPostCode);
		
		assertEquals(true, isFrench);
	}

	@Test
	public void testIsUsa() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean isUsa = false;
		
		String usPostCode = "66101";
		
		isUsa = PostCodeFormat.isUsa(usPostCode);
		
		assertEquals(true, isUsa);		
	}

	@Test
	public void testIsUk() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean isUk = false;
		
		String ukPostCode = "Tf1 6QR";
		
		isUk = PostCodeFormat.isUk(ukPostCode);
				
	    assertEquals(true, isUk);
		
	}

	@Test
	public void testCanadianFormatMsg() {
		
		boolean isString = false;
		
		isString = PostCodeFormat.canadianFormatMsg() instanceof String;
		
		assertEquals(true, isString);
		
	}

	@Test
	public void testFrenchFormatMsg() {
		
		boolean isString = false;
		
        isString = PostCodeFormat.frenchFormatMsg() instanceof String;
		
		assertEquals(true, isString);
		
	}

	@Test
	public void testUkFormatMsg() {
		
		boolean isString = false;
		
		isString = PostCodeFormat.ukFormatMsg() instanceof String;
		
		assertEquals(true, isString);
	}

	@Test
	public void testUsaFormatMsg() {
		
		boolean isString = false;
		
		isString = PostCodeFormat.usaFormatMsg() instanceof String;
		
		assertEquals(true, isString);
	}

}