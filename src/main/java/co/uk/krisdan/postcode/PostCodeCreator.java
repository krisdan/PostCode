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

public class PostCodeCreator implements PostCodeCreatorAPI {
	
	private static PostCodeCreatorAPI instance = null;

	private PostCodeCreator() {
	}
	
	public static PostCodeCreatorAPI getInstance() {
		
		if (instance == null) {
			instance = new PostCodeCreator();
		}
		return instance;
	}

	@Override
	public PostCode getPostCodeObject(String postCode, String country) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, country);
		
		switch(country.toLowerCase()) {
		
			case "ca" :
				
			case "canada": if(isValid) { postCodeObj = 
			this.getCanadianPostCodeObject(postCode);};
				break;
				
			case "fr" :
				
			case "france": if(isValid) { postCodeObj = this.getFrenchPostCodeObject(postCode);};
				break;
				
			case "uk" :
				
			case "united kingdom": if(isValid) { postCodeObj = this.getUkPostCodeObject(postCode);};
				break;
				
			case "us" :
				
			case "usa":
				
			case "united states of america": if(isValid) { postCodeObj = this.getUsaPostCodeObject(postCode);};
				break;
				
			default: isValid = false;
				break;
		}
		
		return postCodeObj;
	}

	@Override
	public PostCode getCanadianPostCodeObject(String postCode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "canada");
		
		if (isValid) {
			
			postCodeObj = new CanadianPostCode(postCode);			
		}
		
		return postCodeObj;
	}

	@Override
	public PostCode getFrenchPostCodeObject(String postCode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {

		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "france");
		
		if (isValid) {
			
			postCodeObj = new FrenchPostCode(postCode);
			
		}
		return postCodeObj;
	}

	@Override
	public PostCode getUkPostCodeObject(String postCode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {

		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "united kingdom");
		
		if (isValid) {
			
			postCodeObj = new UkPostCode(postCode);
			
		}
		return postCodeObj;
	}

	@Override
	public PostCode getUsaPostCodeObject(String postCode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {

		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "united states of america");
		
		if (isValid) {
			
			postCodeObj = new UsaPostCode(postCode);
			
		}
		return postCodeObj;
	}

	@Override
	public PostCodeWrapper getPostCodeWrapper() {
		
		return new PostCodeWrapper();
	}
}
