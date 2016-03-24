package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import co.uk.krisdan.postcode.UkPostCode;
import co.uk.krisdan.postcode.exceptions.UkAlphaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UkUnusedPostCodeException;

public class UkPostCodeTest {
	
	//String postCode = "M15 6FN";
	
	@Test
	public void testGetAsCharArray() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		boolean isCharArray = false;
		
		String postCode = "TF9 2EF";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
		
		isCharArray = (ukPostCode.getAsCharArray() instanceof char[]);
		
		assertEquals(true, isCharArray);
	}
	
	
	@Test
	public void testUkPostCode() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
        
		boolean result = false;
		
		String postCode = "M15 6FN";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
		
		if(ukPostCode instanceof UkPostCode){
			result = true;
		}
		assertEquals(true, result);
	}
	
	
	@Test
	public void testSetPostCode() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		String postCode = "M15 6FN";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
		
		Class[] methodParameters = new Class[] { String.class };

		Object[] params = new Object[] { new String(postCode) };
		
		Method privateMethod;
		
		try {
			privateMethod = UkPostCode.class.getDeclaredMethod("setPostCode", methodParameters);
			
			privateMethod.setAccessible(true);
			
			boolean privateReturnValue = (boolean) privateMethod.invoke(ukPostCode, params);
			
			assertEquals(true, privateReturnValue);
			
		} catch (NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
	}
	

	@Test
	public void testGetPostCode() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {

		String postCode = "M15 6FN";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
		
		Method protectedMethod;
		
		try {
			protectedMethod = UkPostCode.class.getDeclaredMethod("getPostCode");
			
			protectedMethod.setAccessible(true);
			
			String protectedReturnValue = (String) protectedMethod.invoke(ukPostCode);
			
			boolean result = postCode.equals(protectedReturnValue);
			
			
			assertEquals(true, result);
			
		} catch (NoSuchMethodException | SecurityException e) {
			
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
	}

	
	@Test
	public void testGetAsString() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {

		boolean result = false;
		
		String postCode = "M15 6FN";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
		
		result = postCode.equals(ukPostCode.getAsString());
		
		assertEquals(true, result);
	}

	
	@Test
	public void testValidate() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {
		
		String postCode = "M15 6FN";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
			
		Method protectedMethod;
			
		try {
			protectedMethod = UkPostCode.class.getDeclaredMethod("validate");
				
			protectedMethod.setAccessible(true);
				
			boolean protectedReturnValue = (boolean) protectedMethod.invoke(ukPostCode);
				
				
			assertEquals(true, protectedReturnValue);
				
			} catch (NoSuchMethodException | SecurityException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			}
	}

	
	@Test
	public void testToString() throws UkAlphaNumericPostCodeException, UkUnusedPostCodeException, UkTooLongPostCodeException, UkTooShortPostCodeException {

		boolean result = false;
		
		String postCode = "M15 6FN";
		
		UkPostCode ukPostCode = new UkPostCode(postCode);
			
		result = ukPostCode.getAsString().equals(postCode);
			
		assertEquals(true, result);
	}
}