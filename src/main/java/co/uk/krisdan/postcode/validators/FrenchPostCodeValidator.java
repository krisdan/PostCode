package co.uk.krisdan.postcode.validators;

import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;

public class FrenchPostCodeValidator {

	private FrenchPostCodeValidator() {
		
	}
	
	
	/** - abstract Method
	 * 
	 * receives a String representation of the postCode 
	 * and checks its length to see if it is too long.
	 * 
	 * if the String is too long an exception is thrown.
	 * 
	 * @param postCode String
	 * @return boolean
	 * @throws CaTooLongPostCodeException
	 * @throws FrTooLongPostCodeException
	 * @throws UkTooLongPostCodeException
	 * @throws UsaTooLongPostCodeException
	 */
	public static boolean isTooLong(String postCode) {
		
		boolean tooLong = false;
	
		if (postCode.length() > 5) {
			
			tooLong = true;
		}
		
		return tooLong;
	}
	
	/** - abstract Method
	 * 
	 * receives a String representation of the postCode 
	 * and checks its length to see if it is too short.
	 * 
	 * if the String is too short an exception is thrown.
	 * 
	 * 
	 * @param postCode String
	 * @return boolean
	 * @throws CaTooShortPostCodeException
	 * @throws FrTooShortPostCodeException
	 * @throws UkTooShortPostCodeException
	 * @throws UsaTooShortPostCodeException
	 */
	public static boolean isTooShort(String postCode) {
		
		boolean tooShort = false;
		
		postCode = postCode.replaceAll("\\s+", "");
	
		if (postCode.length() < 5) {
			
			tooShort = true;
		}
		
		return tooShort;
	}
	

	
	public static boolean isTooLow(String postCode) {
		
		boolean bellow = false;
		
		if (Integer.parseInt(postCode) < 0) {
			
			bellow = true;
		}
		
		return bellow;
	}
	
	public static boolean isTooHigh(String postCode) {
		
		boolean tooHigh = false;
		
		if (Integer.parseInt(postCode) > 98499) {
			
			tooHigh = true;
		}
		
		return tooHigh;
	}
	
	
	
	public static boolean match(String postCode) {
		
		String regEx = "^[0-9]{5}$";
		
		return postCode.matches(regEx);
	}

	/** - abstract Method
	 * 
	 * receives a String representation of the postCode 
	 * and checks to see if it is an actual post code.
	 * 
	 * if the String is not an actual post code an exception is thrown.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
    public static boolean unused(String postCode) {
		
		boolean unused = false;
		
		boolean tooShort = isTooShort(postCode);
		
		boolean tooLong = isTooLong(postCode);
		
		boolean correctFormat = match(postCode);
		
		boolean validFormat = (correctFormat && !tooShort && !tooLong);
		
		boolean unassigned = (Integer.parseInt(postCode) > 0 &&
				Integer.parseInt(postCode) <= 999);
		
		if(validFormat && unassigned){
			
			unused = true;
		}
		
		return unused;
	}
    
	public static boolean validate(String postCode) throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {
		
		boolean valid = false;
		
		boolean isAlphaNumeric = PostCodeValidator.isAlphaNumeric(postCode);
		
		if (isAlphaNumeric) { throw new FrNumericPostCodeException(postCode); };
		
		boolean tooLong = isTooLong(postCode);
		
		if (tooLong) {throw new FrTooLongPostCodeException(postCode); };
		
		boolean tooShort = isTooShort(postCode);
		
		if (tooShort) {throw new FrTooShortPostCodeException(postCode); };
		
		boolean tooLow = isTooLow(postCode);
		
		if (tooLow) {throw new FrTooLowPostCodeException(postCode); };
		
		boolean tooHigh = isTooHigh(postCode);
		
		if (tooHigh) {throw new FrTooHighPostCodeException(postCode); };
		
		boolean unused = unused(postCode);
		
		boolean inRange = (!tooHigh && !tooLow);
		
		boolean correct = (match(postCode) && PostCodeValidator.isNumeric(postCode) && !PostCodeValidator.hasForbidenChars(postCode, "France"));
		
		valid = (!tooLong && !tooShort && inRange && !unused && correct && !isAlphaNumeric);
	
		return valid;
	}
}