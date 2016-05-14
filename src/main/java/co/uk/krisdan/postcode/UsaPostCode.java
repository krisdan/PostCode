package co.uk.krisdan.postcode;

import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.UsaPostCodeValidator;

public class UsaPostCode extends PostCode {	
	private String postCode;
	
	public UsaPostCode(String postCode) throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
												UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		this.setPostCode(postCode);
	}
	
	private boolean setPostCode(String postCode) throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
															UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean success = false;
		
		if (UsaPostCodeValidator.validate(postCode)) {
			
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
		
		return PostCodeFormat.usaFormatMsg();
	}

	@Override
	protected boolean validate() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException,
											UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean valid = false;
		
		String postCode = this.getPostCode();
		
		valid = UsaPostCodeValidator.validate(postCode);

		return valid;
	}
	
	@Override
	public String toString() {

		return this.getAsString();
	}
}