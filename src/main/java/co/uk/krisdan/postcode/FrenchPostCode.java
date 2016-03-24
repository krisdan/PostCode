package co.uk.krisdan.postcode;

import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.FrenchPostCodeValidator;

public class FrenchPostCode extends PostCode {

	private String postCode;
	
	public FrenchPostCode(String postCode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException  {
		
		this.setPostCode(postCode);
		
	}

	private boolean setPostCode(String postCode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		boolean success = false;
		
		if (FrenchPostCodeValidator.validate(postCode)) {
			
			this.postCode = postCode;
			
			success = true;
		}
		
		return success;
	}

	protected String getPostCode() {
		
		return postCode;
	}

	@Override
	public String getAsString() {
		
		String cpPostCode = new String(this.getPostCode());
		
		return cpPostCode;
	}

	@Override
	protected boolean validate() throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException {
		
		boolean valid = false;
		
		String postCode = this.getPostCode();
		
		valid = FrenchPostCodeValidator.validate(postCode);

		return valid;
	}
	
	@Override
	public String toString() {
		
		return this.getAsString();
	}
}
