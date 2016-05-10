package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

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

public class PostCodeAPIInterfaceTest {

	@Test
	public void testGetPostCodeAPI() {
		
		boolean isPostCodeAPI = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		if(api instanceof PostCodeAPI) {
			
			isPostCodeAPI = true;
		}
		
		assertEquals(true, isPostCodeAPI);
	}

	@Test
	public void testGetPostCodeObject() {
		
		boolean isPostCode = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "TF1 6QR";
		
		PostCode postCode;
		
		try {
			postCode = api.getPostCodeObject(code, "United Kingdom");
		} catch (CaAlphaNumericPostCodeException | FrNumericPostCodeException | UkAlphaNumericPostCodeException
				| UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException | CaUnusedPostCodeException
				| CaTooLongPostCodeException | CaTooShortPostCodeException | FrTooLongPostCodeException
				| FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException
				| FrTooLowPostCodeException | UkUnusedPostCodeException | UkTooLongPostCodeException
				| UkTooShortPostCodeException | UsaTooLongPostCodeException | UsaTooShortPostCodeException
				| UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetPostCodeObject()");
			
		} finally {
			
			isPostCode = false;
		}
		
		if(postCode != null && postCode.getAsString().equals(code) && postCode instanceof PostCode) {
			isPostCode = true;
		}
		
		assertEquals(true, isPostCode);
	}

	@Test
	public void testGetCanadianPostCodeObject() {
		
		boolean isCanadian = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "H2J 1N3";
		
		PostCode postCode = null;
		try {
			postCode = api.getPostCodeObject(code, "Canada");
		} catch (CaAlphaNumericPostCodeException | FrNumericPostCodeException | UkAlphaNumericPostCodeException
				| UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException | CaUnusedPostCodeException
				| CaTooLongPostCodeException | CaTooShortPostCodeException | FrTooLongPostCodeException
				| FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException
				| FrTooLowPostCodeException | UkUnusedPostCodeException | UkTooLongPostCodeException
				| UkTooShortPostCodeException | UsaTooLongPostCodeException | UsaTooShortPostCodeException
				| UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetCanadianPostCodeObject()");
			
		} finally {
			
			isCanadian = false;
		}
		
		if(postCode != null && postCode.getAsString().equals(code) && postCode instanceof CanadianPostCode) {
			isCanadian = true;
		}
		
		assertEquals(true, isCanadian);
	}

	@Test
	public void testGetFrenchPostCodeObject() {
		
		boolean isFrench = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "45000";
		
		PostCode postCode;
		
		try {
			postCode = api.getPostCodeObject(code, "France");
		} catch (CaAlphaNumericPostCodeException | FrNumericPostCodeException | UkAlphaNumericPostCodeException
				| UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException | CaUnusedPostCodeException
				| CaTooLongPostCodeException | CaTooShortPostCodeException | FrTooLongPostCodeException
				| FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException
				| FrTooLowPostCodeException | UkUnusedPostCodeException | UkTooLongPostCodeException
				| UkTooShortPostCodeException | UsaTooLongPostCodeException | UsaTooShortPostCodeException
				| UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetFrenchPostCodeObject()");
			
		} finally {
			
			isFrench = false;
		}
		
		if(postCode != null && postCode.getAsString().equals(code) && postCode instanceof FrenchPostCode) {
			isFrench = true;
		}
		
		assertEquals(true, isFrench);
	}

	@Test
	public void testGetUkPostCodeObject() {
		
		boolean isUk = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "ST1 4BY";
		
		PostCode postCode;
		
		try {
			postCode = api.getPostCodeObject(code, "United Kingdom");
		} catch (CaAlphaNumericPostCodeException | FrNumericPostCodeException | UkAlphaNumericPostCodeException
				| UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException | CaUnusedPostCodeException
				| CaTooLongPostCodeException | CaTooShortPostCodeException | FrTooLongPostCodeException
				| FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException
				| FrTooLowPostCodeException | UkUnusedPostCodeException | UkTooLongPostCodeException
				| UkTooShortPostCodeException | UsaTooLongPostCodeException | UsaTooShortPostCodeException
				| UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetUkPostCodeObject()");
			
		} finally {
			
			isUk = false;			
		}
		
		if(postCode != null && postCode.getAsString().equals(code) && postCode instanceof UkPostCode) {
			isUk = true;
		}
		
		assertEquals(true, isUk);
	}

	@Test
	public void testGetUsaPostCodeObject() {
		
		boolean isUsa = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "84150";
		
		PostCode postCode;
		try {
			postCode = api.getPostCodeObject(code, "United States of America");
		} catch (CaAlphaNumericPostCodeException | FrNumericPostCodeException | UkAlphaNumericPostCodeException
				| UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException | CaUnusedPostCodeException
				| CaTooLongPostCodeException | CaTooShortPostCodeException | FrTooLongPostCodeException
				| FrTooShortPostCodeException | FrUnusedPostCodeException | FrTooHighPostCodeException
				| FrTooLowPostCodeException | UkUnusedPostCodeException | UkTooLongPostCodeException
				| UkTooShortPostCodeException | UsaTooLongPostCodeException | UsaTooShortPostCodeException
				| UsaUnusedPostCodeException | UsaTooHighPostCodeException | UsaTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetUkPostCodeObject()");
			
		} finally {
			
			isUsa = false;
		}
		
		if(postCode != null && postCode.getAsString().equals(code) && postCode instanceof UsaPostCode) {
			isUsa = true;
		}
		
		assertEquals(true, isUsa);
	}

	@Test
	public void testGetPostCodeWrapper() {
		
		boolean isWrapper = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		if(wrapper instanceof PostCodeWrapper) {
			isWrapper = true;
		}
		
		assertEquals(true, isWrapper);
	}

	@Test
	public void testIsValid() {
		
		boolean isValid = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "H2J 1N3";
		
		isValid = api.isValid(code, "Canada");
		
		assertEquals(true, isValid);
	}

	@Test
	public void testIsCanadianPostCode() {
		
		boolean isCanadian = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "H2J 1N3";
		
		isCanadian = api.isCanadianPostCode(code);
		
		assertEquals(true, isCanadian);
	}

	@Test
	public void testIsFrench() {
		
		boolean isFrench = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "45000";
		
		isFrench = api.isFrenchPostCode(code);
		
		assertEquals(true, isFrench);
	}

	@Test
	public void testIsUkPostCode() {
		
		boolean isUk = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "ST1 4BY";
		
		isUk = api.isUkPostCode(code);
		
		assertEquals(true, isUk);
	}

	@Test
	public void testIsUsaPostCode() {
		
		boolean isUsa = false;
		
		PostCodeAPI api = PostCodeAPIInterface.getPostCodeAPI();
		
		String code = "84150";
		
		isUsa = api.isUsaPostCode(code);
		
		assertEquals(true, isUsa);
	}

}
