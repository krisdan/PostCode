package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import co.uk.krisdan.postcode.UsaPostCode;
import co.uk.krisdan.postcode.exceptions.UsaForbidenCharactersPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaNumericPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooHighPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLongPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooLowPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaTooShortPostCodeException;
import co.uk.krisdan.postcode.exceptions.UsaUnusedPostCodeException;

public class UsaPostCodeTest {
	
	@Test
	public void testGetAsCharArray() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean isCharArray = false;
		
		String postCode = "38108";
		
		UsaPostCode usaPostCode = new UsaPostCode(postCode);
		
		isCharArray = (usaPostCode.getAsCharArray() instanceof char[]);
		
		assertEquals(true, isCharArray);
	}
	
	@Test
	public void testUsaPostCode() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		boolean isUsaPostCode = false; 
		
		String postCode = "38108";
		
		UsaPostCode usPostCode = new UsaPostCode(postCode);

		if(usPostCode instanceof UsaPostCode){
			
			isUsaPostCode = true;
		}
		
		assertEquals(true, isUsaPostCode);
	}
	
	
	@Test
	public void testSetPostCode() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
		
		String postCode = "38108";
		
		UsaPostCode usPostCode = new UsaPostCode(postCode);
		
		Class[] methodParameters = new Class[] { String.class };

		Object[] params = new Object[] { new String(postCode) };
		
		Method privateMethod;
		
		try {
			privateMethod = UsaPostCode.class.getDeclaredMethod("setPostCode", methodParameters);
			
			privateMethod.setAccessible(true);
			
			boolean privateReturnValue = (boolean) privateMethod.invoke(usPostCode, params);
			
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
	public void testGetPostCode() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {
 
		String postCode = "38108";
		
		UsaPostCode usPostCode = new UsaPostCode(postCode);
		
		Method protectedMethod;
		
		try {
			protectedMethod = UsaPostCode.class.getDeclaredMethod("getPostCode");
			
			protectedMethod.setAccessible(true);
			
			String protectedReturnValue = (String) protectedMethod.invoke(usPostCode);
			
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
	public void testGetAsString() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {

		boolean sameString = false;
		
		String postCode = "38108";
		
		UsaPostCode usPostCode = new UsaPostCode(postCode);
		
		sameString = postCode.equals(usPostCode.getAsString());
		
		assertEquals(true, sameString);
	}

	@Test
	public void testValidate() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {

		String postCode = "38108";
		
		UsaPostCode usPostCode = new UsaPostCode(postCode);
			
		Method protectedMethod;
			
		try {
			protectedMethod = UsaPostCode.class.getDeclaredMethod("validate");
				
			protectedMethod.setAccessible(true);
				
			boolean protectedReturnValue = (boolean) protectedMethod.invoke(usPostCode);
	
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
	public void testToString() throws UsaTooLongPostCodeException, UsaTooShortPostCodeException, UsaUnusedPostCodeException, UsaTooHighPostCodeException, UsaTooLowPostCodeException, UsaNumericPostCodeException, UsaForbidenCharactersPostCodeException {

		boolean sameString = false;
		
		String postCode = "38108";
		
		UsaPostCode usPostCode = new UsaPostCode(postCode);
			
		sameString = usPostCode.toString().equals(postCode);
			
		assertEquals(true, sameString);
	}

	
	
	
    
}