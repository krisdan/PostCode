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

public interface PostCodeCreatorAPI {
	
	public PostCode getPostCodeObject(String postCode, String country) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException, FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException;
	
	public PostCode getCanadianPostCodeObject(String postCode) throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException;
	
	public PostCode getFrenchPostCodeObject(String postCode) throws FrNumericPostCodeException, FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException;
	
	public PostCode getUkPostCodeObject(String postCode) throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException;
	
	public PostCode getUsaPostCodeObject(String postCode) throws UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException, UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException;
	
	public PostCodeWrapper getPostCodeWrapper();

}
