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

public class PostCodeAPIInterface implements PostCodeAPI {

	private static PostCodeAPI instance = null;
	
	private PostCodeAPIInterface() {		
		
	}
	
	public static PostCodeAPI getPostCodeAPI() {
		
		if (instance == null) {
			instance = new PostCodeAPIInterface();
		}
		return instance;
	}

	@Override
	public PostCode getPostCodeObject(String postCode, String country) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getPostCodeObject(postCode, country);
		
		return postCodeObj;
	}

	@Override
	public PostCode getCanadianPostCodeObject(String postCode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getCanadianPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCode getFrenchPostCodeObject(String postCode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getFrenchPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCode getUkPostCodeObject(String postCode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getUkPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCode getUsaPostCodeObject(String postCode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException {
		
		PostCode postCodeObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		postCodeObj = creator.getUsaPostCodeObject(postCode);
		
		return postCodeObj;
	}

	@Override
	public PostCodeWrapper getPostCodeWrapper() {
		
		PostCodeWrapper wrapperObj = null;
		
		PostCodeCreatorAPI creator = PostCodeCreator.getInstance();
		
		wrapperObj = creator.getPostCodeWrapper();
		
		return wrapperObj;
	}

	@Override
	public boolean isValid(String postCode, String country) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isValid(postCode, country);
		
		return isValid;
	}

	@Override
	public boolean isCanadianPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isCanadianPostCode(postCode);
		
		return isValid;
	}

	@Override
	public boolean isFrenchPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isFrenchPostCode(postCode);
		
		return isValid;
	}

	@Override
	public boolean isUkPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isUkPostCode(postCode);
		
		return isValid;
	}

	@Override
	public boolean isUsaPostCode(String postCode) {
		
		boolean isValid = false;
		
		PostCodeValidatorAPI validator = PostCodeValidator.getInstance();
		
		isValid = validator.isUsaPostCode(postCode);
		
		return isValid;
	}

}
