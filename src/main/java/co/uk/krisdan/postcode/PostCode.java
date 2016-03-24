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

/**
 * Abstract Class.
 *
 * Implements PostCodeInterface
 *
 * Provides the top level Type PostCode.
 * 
 * 
 *
 */
public abstract class PostCode {

	protected abstract String getPostCode();
	
	public abstract String getAsString();

	public char[] getAsCharArray() {
		
		return this.getAsString().trim().toCharArray();
	}

	protected abstract boolean validate()
			throws UkUnusedPostCodeException, UkTooLongPostCodeException, UkAlphaNumericPostCodeException, UkTooShortPostCodeException,
				CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, CaAlphaNumericPostCodeException,
				FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException,
				UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, FrNumericPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException;

	public abstract String toString();

}
