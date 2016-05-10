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
		
		boolean failed = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		try {
			wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
			
			wrapper.finalize();
			
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException
				| CaTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			failed = true;
			
		} 
		
		if (!failed && wrapper.getPostCode() == null && wrapper.getMessage() == null) {
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
		
		boolean failed = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		try {
			wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException
				| CaTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			failed = true;
			
			System.out.println(this.getClass().getSimpleName() + ".testGetMessage() has generated an error.");
			
		} 
		
		if(!failed && wrapper.getMessage().equals("CanadianPostCode Post code: H2J 1N3")) {
				messageCorrect = true;
		}

		assertEquals(true, messageCorrect);
	}

	@Test
	public void testWrapPostCode() {
		
		boolean isWrapped = false;
		
		boolean failed = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		try {
			wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException
				| CaTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			failed = true;
			
			System.out.println(this.getClass().getSimpleName() + ".testWrapPostCode() has generated an error.");
			
		} 
		
		if(!failed && wrapper.getPostCode() instanceof PostCode) {
				isWrapped = true;
		}
		
		assertEquals(true, isWrapped);
	}
	
	@Test
	public void testGetAsString() {
		
		boolean isCorrect = false;
		
		boolean failed = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		try {
			wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException
				| CaTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			failed = true;
			
			System.out.println(this.getClass().getSimpleName() + ".testGetAsString() has generated an error.");
			
		} 
		
		if(!failed && wrapper.getAsString().equals("H2J 1N3")) {
				isCorrect = true;
		}
		
		assertEquals(true, isCorrect);
	}
	
	@Test
	public void testGetAsCharArray() {

		boolean isCorrect = true;
		
		boolean failed = false;
		
		String postCode = "H2J 1N3";
		
		char[] code = postCode.toCharArray();
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCodeWrapper wrapper = api.getPostCodeWrapper();
		
		try {
			wrapper.wrapPostCode(api.getCanadianPostCodeObject("H2J 1N3"));
		} catch (CaAlphaNumericPostCodeException | CaUnusedPostCodeException | CaTooLongPostCodeException
				| CaTooShortPostCodeException e) {
			
			//e.printStackTrace();
			
			failed = true;
			
			System.out.println(this.getClass().getSimpleName() + ".testGetAsString() has generated an error.");			
		}
		
		char[] code2 = wrapper.getAsCharArray();
		
		for(int i = 0; i < code.length; i++) {
			
			if (code[i] != code2[i] && !failed ) {
				
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
