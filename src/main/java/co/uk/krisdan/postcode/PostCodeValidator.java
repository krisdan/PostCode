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

public class PostCodeValidator implements PostCodeValidatorAPI {
	
	private static PostCodeValidatorAPI instance = null;

	private PostCodeValidator() {
		
	}
	
	public static PostCodeValidatorAPI getInstance() {
		
		if(instance == null) {
			instance = new PostCodeValidator();
		}
		return instance;
	}

	@Override
	public boolean isValid(String postCode, String country) {
		
		boolean isValid = false;
			
		switch(country.toLowerCase()) {
		
			case "ca":
			case "canada": isValid = this.isCanadianPostCode(postCode);
				break;
				
			case "fr": case "french":
			case "france": isValid = this.isFrenchPostCode(postCode); System.out.println("is valid? " + isValid);
				break;
				
			case "uk":
			case "united kingdom": isValid = this.isUkPostCode(postCode);
				break;
				
			case "us": case "usa":
			case "united states of america": isValid = this.isUsaPostCode(postCode);
				break;
			
			default: isValid = false;
				break;
		}
		return isValid;
	}

	@Override
	public boolean isCanadianPostCode(String postCode) {
		
		boolean isValid = false;
		
		try {
			
			isValid = CanadianPostCodeValidator.validate(postCode);
			
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException | CaTooShortPostCodeException e) {
			//e.printStackTrace();
			isValid = false;
		} finally {
			//System.out.println(this.getClass().getSimpleName() + "is valid?" + isValid);
		}

		return isValid;
	}

	@Override
	public boolean isFrenchPostCode(String postCode) {
		
		boolean isValid = false;
		
		try {
			
			isValid = FrenchPostCodeValidator.validate(postCode);
			
		} catch (FrTooLongPostCodeException | FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException | FrTooLowPostCodeException | FrNumericPostCodeException e) {
			//e.printStackTrace();
			isValid = false;
		} finally {
			System.out.println(this.getClass().getSimpleName() + "is valid?" + isValid);
		}
		return isValid;
	}

	@Override
	public boolean isUkPostCode(String postCode) {
		
		boolean isValid = false;
		
		try {
			
			isValid = UkPostCodeValidator.validate(postCode);
			
		} catch (UkUnusedPostCodeException | UkTooLongPostCodeException | UkTooShortPostCodeException | UkAlphaNumericPostCodeException e) {
			//e.printStackTrace();
			isValid = false;
		} finally {
			//System.out.println(this.getClass().getSimpleName() + "is valid?" + isValid);
		}

		return isValid;
	}

	@Override
	public boolean isUsaPostCode(String postCode) {
		
		boolean isValid = false;
		
		try {
			
			isValid = UsaPostCodeValidator.validate(postCode);
			
		} catch (UsaTooLongPostCodeException | UsaTooShortPostCodeException | UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException | UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException e) {
			//e.printStackTrace();
			isValid = false;
		} finally {
			//System.out.println(this.getClass().getSimpleName() + "is valid?" + isValid);
		}

		return isValid;
	}

}
