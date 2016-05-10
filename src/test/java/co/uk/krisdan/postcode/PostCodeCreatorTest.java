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

public class PostCodeCreatorTest {

	@Test
	public void testGetInstance() {
		
		boolean isInstance = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		if (api instanceof PostCodeCreatorAPI) {
			isInstance = true;
		}
		
		assertEquals(true, isInstance);
	}

	@Test
	public void testGetPostCodeObject() {
		
		boolean isPostCodeObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode;
		
		try {
			postCode = api.getPostCodeObject("ST1 4BY", "United Kingdom");
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
			
			isPostCodeObj = false;
		}
		
		if (postCode != null && postCode instanceof PostCode) {
			isPostCodeObj = true;
		}
		
		assertEquals(true, isPostCodeObj);
	}

	@Test
	public void testGetCanadianPostCodeObject() {
		
		boolean isCanadianObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode;
		try {
			postCode = api.getCanadianPostCodeObject("H2J 1N3");
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException
				| CaTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetCanadianPostCodeObject()");
			
		} finally {
			
			isCanadianObj = false;
		}
		
		if (postCode != null && postCode instanceof CanadianPostCode) {
			isCanadianObj = true;
		}
		
		assertEquals(true, isCanadianObj);
	}

	@Test
	public void testGetFrenchPostCodeObject() {
		
		boolean isFrenchObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode;
		
		try {
			postCode = api.getFrenchPostCodeObject("45000");
		} catch (FrNumericPostCodeException | FrTooLongPostCodeException | FrTooShortPostCodeException
				| FrUnusedPostCodeException | FrTooHighPostCodeException | FrTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetFrenchPostCodeObject()");
			
		} finally {
			
			isFrenchObj = false;
		}
		
		if (postCode != null && postCode instanceof FrenchPostCode) {
			isFrenchObj = true;
		}
		
		assertEquals(true, isFrenchObj);
	}

	@Test
	public void testGetUkPostCodeObject() {
		
		boolean isUkObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode;
		try {
			postCode = api.getUkPostCodeObject("ST1 4BY");
		} catch (UkAlphaNumericPostCodeException | UkUnusedPostCodeException | UkTooLongPostCodeException
				| UkTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetUkPostCodeObject()");
			
		} finally {
			
			isUkObj = false;
		}
		
		if (postCode != null && postCode instanceof UkPostCode) {
			isUkObj = true;
		}
		
		assertEquals(true, isUkObj);
	}

	@Test
	public void testGetUsaPostCodeObject() {
		
		boolean isUsaObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode;
		
		try {
			postCode = api.getUsaPostCodeObject("84150");
		} catch (UsaNumericPostCodeException | UsaForbidenCharactersPostCodeException | UsaTooLongPostCodeException
				| UsaTooShortPostCodeException | UsaUnusedPostCodeException | UsaTooHighPostCodeException
				| UsaTooLowPostCodeException e) {
			
			//e.printStackTrace();
			
			postCode = null;
			
			System.out.println("An exception occured in PostCodeAPIInterfaceTest.testGetUkPostCodeObject()");
			
		} finally {
			
			isUsaObj = false;
		}
		
		if (postCode != null && postCode instanceof UsaPostCode) {
			isUsaObj = true;
		}
		
		assertEquals(true, isUsaObj);
	}

	@Test
	public void testGetPostCodeWrapper() {

		boolean isWrapper = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		if(wrapper instanceof PostCodeWrapper) {
			isWrapper = true;
		}
		
		assertEquals(true, isWrapper);
	}

}
