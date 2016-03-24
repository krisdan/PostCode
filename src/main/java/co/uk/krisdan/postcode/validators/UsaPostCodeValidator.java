package co.uk.krisdan.postcode.validators;

import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;

public class UsaPostCodeValidator {

	private UsaPostCodeValidator() {
		
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
		
		boolean isPlusFour = isPlusFour(postCode);
		
		boolean isFiveDigit = isFiveDigit(postCode);
	
		if ((!isFiveDigit && postCode.length() > 10) || (!isPlusFour && postCode.length() > 5)) {
			
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
		
		boolean isPlusFour = isPlusFour(postCode);
		
		boolean isFiveDigit = isFiveDigit(postCode);
	
		if ((!isFiveDigit && postCode.length() > 5 && postCode.length() < 10 ) || (!isPlusFour && postCode.length() < 5)) {
			
			tooShort = true;
		}
		
		return tooShort;
	}
	
	public static boolean isPlusFour(String postCode) {
		
		boolean plusFour = false;
		
		if(postCode.matches("^[0-9]{5}[-]{1}[0-9]{4}$")) {
		
			plusFour = true;
		}
		
		return plusFour;
	}

	public static boolean isFiveDigit(String postCode) {
		
		boolean fiveDigit = false;
		
		if(postCode.matches("^[0-9]{5}$")) {
		
			fiveDigit = true;
		}
		
		return fiveDigit;
	} 
	
	public static String removePlusFour(String postCode) {
		
		boolean plusFour = isPlusFour(postCode);
		
		if(plusFour == true){
			
			postCode = (postCode.substring(0, 5));
		}
		
		return postCode;
	}
	
	
	public static boolean isTooLow(String postCode) {
		
		boolean tooLow = false;
		
		String fiveDigit = (removePlusFour(postCode));
		
		if(postCode.isEmpty()) {
			//Do Nothing.
		} else if (Integer.parseInt(fiveDigit) < 0) {
			 
			tooLow = true;
		}
		
		return tooLow;
	}
	
	public static boolean isTooHigh(String postCode) {
		
		boolean tooHigh = false;
		
		String fiveDigit = (removePlusFour(postCode));
		
		if (postCode.isEmpty()) {
			//Do nothing.
		} else if (Integer.parseInt(fiveDigit) > 99999) {
			
			tooHigh = true;
		}

		return tooHigh;
	}
	
	/**
	 * 
	 * Returns true if the PostCode matches the correct PostCode format and
	 * is in range and is not allocated to a address.
	 * 
	 * If the PostCode is valid but is allocated to an address this method
	 * returns false.
	 * 
	 * If the PostCode has an invalid format or is out of range it will
	 * also return false.
	 * 
	 */
	public static boolean unused(String postCode) {
		
		boolean unused = false;
		
		boolean match = match(postCode);
		
		boolean isAlphaNumeric = PostCodeValidator.isAlphaNumeric(postCode);
		
		boolean inRange = isAlphaNumeric ? false : (!isTooHigh(postCode) && !isTooLow(postCode));
		
		boolean unassigned = isAlphaNumeric ? false : (Integer.parseInt(postCode) >= 1 && Integer.parseInt(postCode) <= 3999);
		
        if(match && inRange && unassigned){
			
			unused = true;
		}
		
		return unused;
	}
	
	public static boolean match(String postCode) {
		
		String regEx = "^[0-9]{5}(-[0-9]{4})?$";
		
		return postCode.matches(regEx);
	}
	
	public static boolean validate(String postCode) throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean valid = false;
		
		
        boolean hasForbidenChars = (PostCodeValidator.hasForbidenChars(postCode, "united states"));
        
        if (hasForbidenChars) { throw new UsaForbidenCharactersPostCodeException(postCode); };
        
        
        boolean isAlpha = PostCodeValidator.isAlpha(postCode);
        
        if (isAlpha) { throw new UsaNumericPostCodeException(postCode); };
		
        
        boolean isAlphaNumeric = PostCodeValidator.isAlphaNumeric(postCode);
        
        if (isAlphaNumeric) { throw new UsaNumericPostCodeException(postCode); };
		
        
        boolean numeric = (!isAlphaNumeric && !isAlpha && !hasForbidenChars);
        
        
	    boolean tooHigh = !numeric ? false : isTooHigh(postCode);
		
		if (tooHigh) { throw new UsaTooHighPostCodeException(postCode); };
		
		
		boolean tooLow = !numeric ? false : isTooLow(postCode); 
		
		if (tooLow) { throw new UsaTooLowPostCodeException(postCode); };
		
		
		boolean tooLong = isTooLong(postCode);
		
		if (tooLong) { throw new UsaTooLongPostCodeException(postCode); };
		
		
		boolean tooShort = isTooShort(postCode); 
		
		if (tooShort) { throw new UsaTooShortPostCodeException(postCode); };
		
		
		boolean unused = unused(postCode); 
		
		boolean inRange = (!tooHigh && !tooLow); 
		
		boolean correct = (match(postCode) && PostCodeValidator.isNumeric(postCode) && !hasForbidenChars);
		
		
		valid = (!tooLong && !tooShort && inRange && !unused && correct);
		
		return valid;
	}
	
}