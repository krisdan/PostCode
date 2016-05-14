package co.uk.krisdan.postcode;

import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;
import co.uk.krisdan.postcode.validators.CanadianPostCodeValidator;

/**
 * @author Chris Perkins - chris.krisdan@gmail.com
 * 
 * Defines a Concrete PostCode class for Canadian PostCode Classes.
 *
 */
public class CanadianPostCode extends PostCode {
	
	private String postCode;
	
	/**
	 * Constructor for Canadian Post Codes.
	 * 
	 * @param postCode
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 * @throws CaAlphaNumericPostCodeException
	 */
	public CanadianPostCode(String postCode) throws CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, CaAlphaNumericPostCodeException{
		
		this.setPostCode(postCode);
	}

	/** Helper / Setter Method - setPostCode(String postCode)
	 * 
	 * private boolean setPostCode(String postCode)
	 * 
	 * @param postCode
	 * @return boolean
	 * @throws CaUnusedPostCodeException
	 * @throws CaTooLongPostCodeException
	 * @throws CaTooShortPostCodeException
	 * @throws CaAlphaNumericPostCodeException
	 */
	private boolean setPostCode(String postCode) throws CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, CaAlphaNumericPostCodeException {
		
		boolean success = false;
		
		if (CanadianPostCodeValidator.validate(postCode)) {
			
			this.postCode = postCode;
			
			success = true;
		}
		
		return success;
	}

	/** Helper / Getter Method - getPostCode()
	 * 
	 * @return String
	 */
	protected String getPostCode() {
		
		return this.postCode;
	}

	/** Helper / Getter Method - getAsString()
	 * 
	 * @return String
	 */
	@Override
	public String getAsString() {
		
		String postCode = new String(this.getPostCode());
		
		return postCode;
	}
	
	@Override
	public String getCountryFormat() {
		
		return PostCodeFormat.canadianFormatMsg();
	}

	/** Validation Method - validate()
	 * 
	 * @return boolean
	 */
	@Override
	protected boolean validate() throws CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, CaAlphaNumericPostCodeException {

		boolean valid = false;
		
		String postCode = this.getPostCode();
		
		valid = CanadianPostCodeValidator.validate(postCode);

		return valid;
	}
	
	/** toString()
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return this.getAsString();
	}
}
