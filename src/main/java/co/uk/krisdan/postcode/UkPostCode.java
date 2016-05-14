package co.uk.krisdan.postcode;

import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.UkPostCodeValidator;


public class UkPostCode extends PostCode {
	
	private String postCode;
	
	
	public UkPostCode(String postCode) 
			throws UkUnusedPostCodeException, UkTooLongPostCodeException,
			UkTooShortPostCodeException, UkAlphaNumericPostCodeException {
		
		this.setPostCode(postCode);
		
	}

	private boolean setPostCode(String postCode)
			throws UkUnusedPostCodeException, UkTooLongPostCodeException,
			UkTooShortPostCodeException, UkAlphaNumericPostCodeException {
		
		boolean success = false;
		
		if (UkPostCodeValidator.validate(postCode)) {
			
			this.postCode = postCode;
			
			success = true;
		}
		
		return success;
	}

	protected String getPostCode() {
		
		return this.postCode;
	}

	@Override
	public String getAsString() {
		
		String postCode = new String(this.getPostCode());
		
		return postCode;
	}

	@Override
	public String getCountryFormat() {
		
		return PostCodeFormat.ukFormatMsg();
	}

	@Override
	protected boolean validate() 
			throws UkUnusedPostCodeException, UkTooLongPostCodeException,
			UkTooShortPostCodeException, UkAlphaNumericPostCodeException {
		
		boolean valid = false;
		
		String postCode = this.getPostCode();
		
		valid = UkPostCodeValidator.validate(postCode);

		return valid;
	}
	
	@Override
	public String toString() {
		
		return this.getAsString();
	}
}
