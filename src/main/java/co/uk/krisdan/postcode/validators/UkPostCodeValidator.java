package co.uk.krisdan.postcode.validators;

import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;

/**
 * 
 * @File UkPostCodeValidator.java
 * @author Chris
 *
 *	A usefull RegEx for UK Post Codes but not as comprehensive as the
 *	combined use of the methods in this class:
 *	"^[A-Za-z]{1,2}[0-9FP]{1,2}[A-Za-z]?[ \\t\\n\\f\\r]?[0-9]{1}[A-Za-z]{2}$"
 */


public class UkPostCodeValidator {
	
	private UkPostCodeValidator() {
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
		
		String nospace = postCode.replaceAll("^[\u0020]", "");
	
		if (nospace.length() > 9) {
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
		
		String nospacecode = postCode.replaceAll("\\s+", "");

		if (nospacecode.length() < 5) {
			tooShort = true;
		}
		
		return tooShort;
	}
	
	public static boolean numDigitsCorrect(String postCode) {
		
		boolean isCorrect = false;
		
		String numsOnly = postCode.replaceAll("[\\D]", "");
		
		if (numsOnly.length() < 4 && numsOnly.length() > 1) {
			isCorrect = true;
		}
		
		return isCorrect;
	}
	
	public static String getOutwardChars(String postCode) {
		
		int start = 0;
		
		int end = postCode.length() - 3;
		
		String chars = postCode.substring(start, end).replaceAll(" ", "").replaceAll("\\d","");
		
		return chars;
	}
	
	public static String getOutwardNums(String postCode) {
		
		int start = 0;
		
		int end = postCode.length() - 2;
		
		String digits = postCode.substring(start, end).replaceAll("\\s", "").replaceAll("\\D","");
		
		if(digits.length() == 2) {
			
			digits = String.valueOf(digits.charAt(0));
		}
		
		if(digits.length() == 3) {
			
			digits = digits.substring(0, 2);
		}
		
		return digits;
	}
	
	/**- class method
	 * 
	 * Receives a string representation of postcode and
	 * removes the last three characters and then returns the remaining characters.
	 * 
	 * @param postCode String
	 * @return String
	 */
	public static String getOutwardCode(String postCode) {
		
		StringBuilder out = new StringBuilder();
		
		out.append(getOutwardChars(postCode));
		out.append(getOutwardNums(postCode));
		
		return out.toString();
	}
	
	public static String getInwardChars(String postCode) {
		
		int start = postCode.length() - 3;
		
		int end = postCode.length();
		
		String chars = postCode.substring(start, end).replaceAll(" ", "").replaceAll("\\d", "");
		
		return chars;
	}
	
	public static String getInwardNum(String postCode) {
		
		int start = postCode.length() - 3;
		
		int end = postCode.length();
		
		String digits = postCode.substring(start, end).replaceAll("\\s", "").replaceAll("\\D","");
		
		return digits;
	}
	
	/**- class method
	 * 
	 * Receives a string representation of postcode and
	 * extracts the last three characters and then returns them.
	 * 
	 * @param postCode String
	 * @return String
	 */
	public static String getInwardCode(String postCode) {
		
		StringBuilder out = new StringBuilder();
		
		out.append(getInwardNum(postCode));
		out.append(getInwardChars(postCode));
		
		return out.toString();
	}
	
	/** - class method
	 * 
	 * Receives a String representation of postcode and
	 * checks the characters within it against a regex of acceptable characters and then returns true if it matches.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean match(String postCode) {
		
		String regEx = "^[A-Za-z]{1,2}[0-9FP]{1,2}[A-Za-z]?[ \\t\\n\\f\\r]?[0-9]{1}[A-Za-z]{2}$";
		
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
		
		boolean match = match(postCode);
		
		boolean valid = (outwardValid(postCode) && inwardValid(postCode));
		
		if (match && !valid) {
			unused = true;
		}
		
		return unused;
	}
	
	/** - class method
	 * 
	 * Receives a string representation of postcode and
	 * extracts the first character and then checks it against a regex of acceptable characters
	 * and then returns true if it matches.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean firstPositionValid(String postCode) {
		
		boolean isValid = false;
		
		String permitted = "[ABCDEFGHIJKLMNOPRSTUWYZabcdefghijklmnoprstuwyz]{1}";
		
		//String forbiden = "QVXqvx";
		
		String ch = "" + postCode.charAt(0);
		
		isValid = ch.matches(permitted);
		
		return isValid;
	}
	
	/**- class method
	 * 
	 * Receives a string representation of postcode and
	 * extracts the second character and then checks it against a regex of acceptable characters
	 * and then returns true if it matches.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean secondPositionValid(String postCode) {
		
		boolean isValid = false;
		
		String permitted = "[ABCDEFGHKLMNOPQRSTUVWXYabcdefghklmnopqrstuvwxy0-9]{1}";
		
		//String forbiden = "IJZijz";
		
		String ch = "" + postCode.charAt(1);
		
		isValid = ch.matches(permitted);
		
		return isValid;
	}
	
	/** - class method
	 * 
	 * Receives a string representation of postcode and
	 * extracts the third character and then checks it against a regex of acceptable characters
	 * and then returns true if it matches.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean thirdPositionValid(String postCode) {
		
		boolean isValid = false;
		
		String permitted = "[ABCDEFGHJKPSTUWabcdefghjkpstuw0-9]{1}";
		
		//String forbidden = "ILMNOQRVXYZilmnoqrvxyz";
		
		boolean oneIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(0)));
		boolean twoIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(1)));
		boolean threeIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(2)));
		boolean threeEmpty = (postCode.charAt(2) == 0  || postCode.charAt(2) == ' ');
		boolean fourIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(3)));
		boolean fourEmpty = (postCode.charAt(3) == 0 || postCode.charAt(3) == ' ');
		boolean isForces = isForces(postCode);
		
		boolean an = (!oneIsNum && twoIsNum && threeEmpty && fourEmpty);
		boolean ann = (!oneIsNum && twoIsNum && threeIsNum && fourEmpty);
		boolean aan = (!oneIsNum && !twoIsNum && threeIsNum && fourEmpty);
		boolean aann = (!oneIsNum && !twoIsNum && threeIsNum && fourIsNum);
		
		String ch = "" + postCode.charAt(2);
		
		if(an) {
			isValid = true;
		}
		if(ann || aan || aann) {
			isValid = ch.matches(permitted);
		}
		if(isForces) {
			isValid = true;
		}
		
		return isValid;
	}
	
	/**class method
	 * 
	 * Receives a string representation of postcode and
	 * extracts the fourth character and then checks it against a regex of acceptable characters
	 * and then returns true if it matches.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean fourthPositionValid(String postCode) {
		
		boolean isValid = false;
		
		String permitted = "[ABEHMNPRVWXYabehmnprvwxy0-9]{1}";
		//String forbiden = "CDFGIJKLOQSTUcdfgijkloqstu";
		
		boolean oneIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(0)));
		boolean twoIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(1)));
		boolean threeIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(2)));
		boolean threeEmpty = (postCode.charAt(2) == 0  || postCode.charAt(2) == ' ');
		boolean fourIsNum = PostCodeValidator.isNumeric(String.valueOf(postCode.charAt(3)));
		boolean fourEmpty = (postCode.charAt(3) == 0 || postCode.charAt(3) == ' ');
		boolean isForces = isForces(postCode);
		
		boolean an = (!oneIsNum && twoIsNum && threeEmpty && fourEmpty);
		boolean ann = (!oneIsNum && twoIsNum && threeIsNum && fourEmpty);
		boolean aan = (!oneIsNum && !twoIsNum && threeIsNum && fourEmpty);
		boolean aann = (!oneIsNum && !twoIsNum && threeIsNum && fourIsNum);
		
		String ch = "" + postCode.charAt(3);
		
		if(an || ann || aan) {
			isValid = true;
		}
		if(aann) {
			isValid = ch.matches(permitted);
		}
		if(isForces && ch.toLowerCase().equals("o")) {
			isValid = true;
		}
		
		return isValid;
	}
	
	/** - static method
	 * 
	 * Receives a string representation of postcode and extracts the outwardCode
	 * then checks the first and second characters
	 * and the third and fourth if applicable to see if they are permitted
	 * and then returns true if all the applicable characters are permitted.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean outwardValid(String postCode) {
		
		boolean valid = false;
		
		boolean first, second, third = false, fourth = false;
		
		String outward = getOutwardCode(postCode);
		
		first  = firstPositionValid(postCode);
		
		second = secondPositionValid(postCode);

		//checks the amount of digits in the postCode then validates them.
		if(outward.length() == 3) {
			
			third  = thirdPositionValid(postCode);
			
		} else if(outward.length() == 4) {
			
			third  = thirdPositionValid(postCode);
			fourth = fourthPositionValid(postCode);
		}
		
		//Assesses the outward codes validity based of how many positions it has. 
		if (first && second && outward.length() == 2) {
			
			valid = true;
			
		} else if (first && second && third && outward.length() == 3) {
			
			valid = true;
			
		} else if (first && second && third && fourth && outward.length() == 4) {
			
			valid = true;
		}
		
		return valid;
	}
	
	/** - class method
	 * 
	 * receives a String representation of postcode and extracts the inwardCode (the last three characters)
	 * and checks them against a regex to see if they are permitted characters and
	 * then checks that the first character is a number and that the total amount of characters is three
	 * and then if all these conditions are met it will return true.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean inwardValid(String postCode) {
		
		boolean valid = false;
		
		String permitted = "[ABDEFGHJLNPQRSTUWXYZabdefghjlnpqrstuwxyz]{2}";
		
		String inward = getInwardCode(postCode);
		
		String alphas = inward.substring(1, 3);

		String num = "" + inward.charAt(0);

		if (alphas.matches(permitted) && PostCodeValidator.isNumeric(num) && inward.length() == 3) {
			
			valid = true;
		}

		return valid;
	}
	
	public static boolean isBF1(String postCode) {
		
		boolean isBF1 = false;
		
		//Get Outward code for BF1 post Codes
		int start = 0;
		
		int end = postCode.length() - 3;
		
		String code = postCode.substring(start, end);
		
		//Remove all whitespace
		code = code.replaceAll("\\s", "");
		
		//Remove all digits
		code = code.replaceAll("\\d", "");
		
		isBF1 = code.toLowerCase().equals("bf");
		
		return isBF1;
	}
	
	/** - Class method
	 * 
	 * receives a String representation of postcode and
	 * Extracts the first 5 characters (the letters BFPO) and
	 * then extracts all the characters from the fourth character onwards
	 * and stores them in a variable for numbers
	 * then it checks to see if those numbers are in range (more than 0 less than 5)
	 * and then checks that the fist set of characters are "bfpo"
	 * and that the number is in range and that it is numeric
	 * if these conditions are met then it returns true else it ruturns false.
	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean isBFPO(String postCode) {
		
		boolean isBFPO = false;
		
		// Obtain the beginning of the postCode
		String bfpo = postCode.substring(0, 5).trim();
		
		String num = postCode.substring(4, postCode.length()).trim();
		
		boolean numInRange = (num.length() > 0 && num.length() < 5);
		
		// Check if it is a BFPO
		if(bfpo.toLowerCase().equals("bfpo") && numInRange && PostCodeValidator.isNumeric(num)) {
			
			isBFPO = true;
		}
		
		return isBFPO;
	}
	
	public static boolean isForces(String postCode) {
		
		boolean isForces = false;
		
		boolean isBF1 = isBF1(postCode);
		
		boolean isBFPO = isBFPO(postCode);
		
		isForces = (isBF1 || isBFPO);
		
		return isForces;
	}
	
	/** - class method
	 * 
	 * receives a String representation of postcode and checks to see if it is too long, too short or is an unused postcode
	 * and also checks that the outward and inward codes are both valid and if all of these conditions are met it returns true.
 	 * 
	 * @param postCode String
	 * @return boolean
	 */
	public static boolean validate(String postCode) throws UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException, UkAlphaNumericPostCodeException {
		
		boolean valid = false;
		
		boolean alphaNumeric = PostCodeValidator.isAlphaNumeric(postCode);
		
		boolean correctNumDigits = numDigitsCorrect(postCode);
		
		if (!alphaNumeric || !correctNumDigits) { throw new UkAlphaNumericPostCodeException(postCode); }
		
		boolean tooLong = isTooLong(postCode);
		
		if(tooLong) { throw new UkTooLongPostCodeException(postCode); }
		
		boolean tooShort = isTooShort(postCode);
		
		if(tooShort) { throw new UkTooShortPostCodeException(postCode); }
		
		boolean unused = unused(postCode);
		
		boolean correct = (outwardValid(postCode) && inwardValid(postCode) && correctNumDigits);
		
		valid = (alphaNumeric && !tooLong && !tooShort && !unused && correct);
		
		return valid;
	}

}