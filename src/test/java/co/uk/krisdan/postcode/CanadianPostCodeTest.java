package co.uk.krisdan.postcode;

import static org.junit.Assert.*;
import org.junit.Test;

import co.uk.krisdan.postcode.CanadianPostCode;
import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;


public class CanadianPostCodeTest  {
	
	@Test
	public void testGetAsCharArray() throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		String postCode = "T6G 0E6";
		
		CanadianPostCode caPostCode = new CanadianPostCode(postCode);
		
		boolean isCharArray = (caPostCode.getAsCharArray() instanceof char[]);
		
		assertEquals(true, isCharArray);
	}

	
	@Test
	public void testCanadianPostCode() throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean result = false; 
		
		String postCode = "T6G 0E6";
			
		CanadianPostCode caPostCode = new CanadianPostCode(postCode);
		
		if(caPostCode instanceof CanadianPostCode){
			
			result = true;
		}
				
		assertEquals(result, true);
		
	}
    
	@Test
	public void testGetAsString() throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		String postCode = "T6G 0E6";
		
		CanadianPostCode caPostCode = new CanadianPostCode(postCode);
		
		boolean result = postCode.equals(caPostCode.getAsString());
		
		assertEquals(result, true);
	}
    
	@Test
	public void testToString() throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
	    String postCode = "T6G 0E6";
			
		CanadianPostCode caPostCode = new CanadianPostCode(postCode);
			
		boolean result = caPostCode.getAsString().equals(postCode);
			
		assertEquals(result, true);
	}
    
	
    
}