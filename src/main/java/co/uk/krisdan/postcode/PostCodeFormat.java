package co.uk.krisdan.postcode;

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
import co.uk.krisdan.postcode.validators.CanadianPostCodeValidator;
import co.uk.krisdan.postcode.validators.FrenchPostCodeValidator;
import co.uk.krisdan.postcode.validators.UkPostCodeValidator;
import co.uk.krisdan.postcode.validators.UsaPostCodeValidator;

public abstract class PostCodeFormat {
	
	
	public static boolean isCanadian(String postCode) {
		
		boolean isCanadian = false;
		
		try {
			isCanadian = CanadianPostCodeValidator.validate(postCode);
			
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException
				| CaTooLongPostCodeException | CaTooShortPostCodeException e) {
			
			isCanadian = false;
		}
		
		return isCanadian;
	}

	public static boolean isFrench(String postCode) {
		
		boolean isFrench = false;
		
		try {
			isFrench = FrenchPostCodeValidator.validate(postCode);
			
		} catch (FrNumericPostCodeException | FrTooLongPostCodeException
				| FrTooShortPostCodeException | FrUnusedPostCodeException
				| FrTooHighPostCodeException | FrTooLowPostCodeException e) {
			
			isFrench = false;
		}
		
		return isFrench;
	}

	public static boolean isUsa(String postCode) {
		
		boolean isUsa = false;
		
		try {
			isUsa = UsaPostCodeValidator.validate(postCode);
			
		} catch (UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException |
				UsaTooLongPostCodeException | UsaTooShortPostCodeException |
				UsaUnusedPostCodeException | UsaTooHighPostCodeException |
				UsaTooLowPostCodeException e) {
			
			isUsa = false;
		}
			
		return isUsa;
	}
	
	public static boolean isUk(String postCode) {
		
		boolean isUk = false;
		
		try {
			isUk = UkPostCodeValidator.validate(postCode);
			
		} catch (UkAlphaNumericPostCodeException | UkUnusedPostCodeException
				| UkTooLongPostCodeException | UkTooShortPostCodeException e) {
			
			isUk = false;
		}
		
		return isUk;
	}
	

	public static String canadianFormatMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append(newLine);
		
		message.append("A valid Canadian Post Code format:");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("A = Letter : 0 = Number");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("Acceptable Formats");
		
		message.append(newLine);
		
		message.append("A0A 0A0");
		
		message.append(newLine);
		
		message.append("The First Character must not contain: D F I O Q U W");
		
		message.append(newLine);
		
		return message.toString();
	}

	public static String frenchFormatMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("French Post Code Format");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("Acceptable French Post Codes:");
		
		message.append(newLine);
		
		message.append("00000");
		
		message.append(newLine);
		
		message.append("Any code between 01000 and 73450");
		
		message.append(newLine);
		
		message.append("Post Codes not allowed:");
		
		message.append(newLine);
		
		message.append("Any code between 00001 - 00999");
		
		message.append(newLine);
		
		message.append("Any code over 73450 or less than 00000");
		
		message.append(newLine);
		
		return message.toString();
	}

	public static String ukFormatMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append("UK Post Code Format");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("Acceptable Formats");
		
		message.append(newLine);
		
		message.append("A = Letter : 0 = Number");
		
		message.append(newLine);
		
		message.append("A0 0AA");
		
		message.append(newLine);
		
		message.append("A00 0AA");
		
		message.append(newLine);
		
		message.append("AA0 0AA");
		
		message.append(newLine);
		
		message.append("AA00 0AA");
		
		message.append(newLine);
		
		message.append("A0A 0AA");
		
		message.append(newLine);
		
		message.append("AA0A 0AA");
		
		message.append(newLine);
		
		return message.toString();
	}

	public static String usaFormatMsg() {
		
		String newLine = System.lineSeparator();
		
		StringBuilder message = new StringBuilder();
		
		message.append(newLine);
		
		message.append("A valid United States Post Code.");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("United Staes PostCodes are numeric and 5 digits long.");
		
		message.append(newLine);
		
		message.append("Some United Staes PostCodes have an extention known as 5 dash 4 ");
		
		message.append(newLine);
		
		message.append("which has a dash and an extra 4 digits after the normal 5");
		
		message.append(newLine);
		
		message.append("digit post code.");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("Acceptable United States Post Codes:");
		
		message.append(newLine);
		
		message.append(newLine);
		
		message.append("00000");
		
		message.append(newLine);
		
		message.append("Five dash four: 00000-0000");
		
		message.append(newLine);
		
		message.append("Any code between 04000 and 99999");
		
		message.append(newLine);
		
		message.append("Post Codes not allowed:");
		
		message.append(newLine);
		
		message.append("Any code between 00001 - 03999");
		
		message.append(newLine);
		
		message.append("Any code over 99999 or less than 00000");
		
		message.append(newLine);
		
		return message.toString();
	}

}
