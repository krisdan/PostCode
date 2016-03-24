package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

import co.uk.krisdan.postcode.exceptions.CaAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.CaUnusedPostCodeException;

public class PostCodeWrapperTest {

	@Test
	public void testFinalize() {
		
		boolean isFinalized = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		
		wrapper.finalize();
		
		if (wrapper.getPostCode() == null && wrapper.getMessage() == null) {
			isFinalized = true;
		}
		assertEquals(true, isFinalized);
	}

	@Test
	public void testPostCodeWrapper() throws CaAlphaNumericPostCodeException, CaUnusedPostCodeException, CaTooLongPostCodeException, CaTooShortPostCodeException {
		
		boolean isInstance = false;
		
		PostCodeWrapper wrapper = new PostCodeWrapper();
		
		if (wrapper instanceof PostCodeWrapper) {
			isInstance = true;
		}
		assertEquals(true, isInstance);
	}

	@Test
	public void testGetMessage() {
		
		boolean messageCorrect = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		
		if(wrapper.getMessage().equals("CanadianPostCode Post code: H2J 1N3")) {
			messageCorrect = true;
		}
		
		assertEquals(true, messageCorrect);
	}

	@Test
	public void testWrapPostCode() {
		
		boolean isWrapped = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		
		if(wrapper.getPostCode() instanceof PostCode) {
			isWrapped = true;
		}
		
		assertEquals(true, isWrapped);
	}
	
	@Test
	public void testGetAsString() {
		
		boolean isCorrect = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		
		if(wrapper.getAsString().equals("H2J 1N3")) {
			isCorrect = true;
		}
		
		assertEquals(true, isCorrect);
	}
	
	@Test
	public void testGetAsCharArray() {

		boolean isCorrect = true;
		
		String postCode = "H2J 1N3";
		
		char[] code = postCode.toCharArray();
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		
		char[] code2 = wrapper.getAsCharArray();
		
		for(int i = 0; i < code.length; i++) {
			
			if (code[i] != code2[i] ) {
				
				isCorrect = false;
			}
		}
		
		assertEquals(true, isCorrect);
	}
/*
	@Test
	public void testExtractPostCode() {
		fail("Not yet implemented"); // TODO
	}*/

}
