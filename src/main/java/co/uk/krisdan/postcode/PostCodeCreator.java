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
	public PostCode getPostCodeObject(String postCode, String country) {
		
		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, country);
		
		switch(country.toLowerCase()) {
		
			case "ca" :
				
			case "canada": if(isValid) { postCodeObj = this.getCanadianPostCodeObject(postCode);};
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
	public PostCode getCanadianPostCodeObject(String postCode) {
		
		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "canada");
		
		if (isValid) {
			
			try {
				postCodeObj = new CanadianPostCode(postCode);
			} catch (CaUnusedPostCodeException | CaTooLongPostCodeException | CaTooShortPostCodeException | CaAlphaNumericPostCodeException e) {
				//e.printStackTrace();
				postCodeObj = null;
			} finally {
				//System.out.println(this.getClass().getSimpleName() + postCodeObj);
			}
			
		}
		return postCodeObj;
	}

	@Override
	public PostCode getFrenchPostCodeObject(String postCode) {

		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "france");
		
		if (isValid) {
			
			try {
				postCodeObj = new FrenchPostCode(postCode);
			} catch (FrNumericPostCodeException | FrTooLongPostCodeException | FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException | FrTooLowPostCodeException e) {
				//e.printStackTrace();
				postCodeObj = null;
			} finally {
				//System.out.println(this.getClass().getSimpleName() + postCodeObj);
			}
		}
		return postCodeObj;
	}

	@Override
	public PostCode getUkPostCodeObject(String postCode) {

		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "united kingdom");
		
		if (isValid) {
			
			try {
				postCodeObj = new UkPostCode(postCode);
			} catch (UkUnusedPostCodeException | UkTooLongPostCodeException |UkTooShortPostCodeException | UkAlphaNumericPostCodeException e) {
				//e.printStackTrace();
				postCodeObj = null;
			} finally {
				//System.out.println(this.getClass().getSimpleName() + postCodeObj);
			}
		}
		return postCodeObj;
	}

	@Override
	public PostCode getUsaPostCodeObject(String postCode) {

		PostCode postCodeObj = null;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		boolean isValid = validator.isValid(postCode, "united states of america");
		
		if (isValid) {
			
			try {
				postCodeObj = new UsaPostCode(postCode);
			} catch (UsaTooLongPostCodeException | UsaTooShortPostCodeException | UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException | UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException e) {
				//e.printStackTrace();
				postCodeObj = null;
			} finally {
				//System.out.println(this.getClass().getSimpleName() + postCodeObj);
			}
		}
		return postCodeObj;
	}

	@Override
	public PostCodeWrapper getPostCodeWrapper() {
		
		return new PostCodeWrapper();
	}
}
