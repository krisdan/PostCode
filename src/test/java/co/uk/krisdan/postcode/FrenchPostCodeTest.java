package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import co.uk.krisdan.postcode.FrenchPostCode;
import co.uk.krisdan.postcode.exceptions.FrNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.FrUnusedPostCodeException;

public class FrenchPostCodeTest {


	@Test
	public void testGetAsCharArray() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException  {
		
		String postCode = "72100";
		
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
		
		boolean isCharArray = (frPostCode.getAsCharArray() instanceof char[]);
		
		assertEquals(true, isCharArray);
	}
	
	
	@Test
	public void testFrenchPostCode() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {
		
		String postCode = "72100";
		
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
				
		boolean result = false; 
		
		if(frPostCode instanceof FrenchPostCode){
			
			result = true;
			
		}
				
		assertEquals(result, true);
	}
	
	
	@Test
	public void testSetPostCode() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {
		
		String postCode = "72100";
		
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
		
		Class[] methodParameters = new Class[] { String.class };

		Object[] params = new Object[] { new String(postCode) };
		
		Method privateMethod;
		
		try {
			privateMethod = FrenchPostCode.class.getDeclaredMethod("setPostCode", methodParameters);
			
			privateMethod.setAccessible(true);
			
			boolean privateReturnValue = (boolean) privateMethod.invoke(frPostCode, params);
			
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
	public void testGetPostCode() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {

		String postCode = "72100";
		
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
		
		Method protectedMethod;
		
		try {
			protectedMethod = FrenchPostCode.class.getDeclaredMethod("getPostCode");
			
			protectedMethod.setAccessible(true);
			
			String protectedReturnValue = (String) protectedMethod.invoke(frPostCode);
			
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
	public void testGetAsString() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {

		String postCode = "72100";
		
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
		
		boolean result = postCode.equals(frPostCode.getAsString());
		
		assertEquals(result, true);
	}

	
	@Test
	public void testValidate() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {
		 
		String postCode = "72100";
			
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
			
		Method protectedMethod;
			
		try {
			protectedMethod = FrenchPostCode.class.getDeclaredMethod("validate");
				
			protectedMethod.setAccessible(true);
				
			boolean protectedReturnValue = (boolean) protectedMethod.invoke(frPostCode);
				
				
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
	public void testToString() throws FrTooLongPostCodeException, FrTooShortPostCodeException, FrUnusedPostCodeException, FrTooHighPostCodeException, FrTooLowPostCodeException, FrNumericPostCodeException {
		
		String postCode = "72100";
		
		FrenchPostCode frPostCode = new FrenchPostCode(postCode);
			
		boolean result = frPostCode.getAsString().equals(postCode);
			
		assertEquals(result, true);
	}

   
}