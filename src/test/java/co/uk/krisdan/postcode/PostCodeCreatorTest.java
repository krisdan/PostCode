package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

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
		
		PostCode postCode = api.getPostCodeObject("ST1 4BY", "United Kingdom");
		
		if (postCode instanceof PostCode) {
			isPostCodeObj = true;
		}
		
		assertEquals(true, isPostCodeObj);
	}

	@Test
	public void testGetCanadianPostCodeObject() {
		
		boolean isCanadianObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode = api.getCanadianPostCodeObject("H2J 1N3");
		
		if (postCode instanceof CanadianPostCode) {
			isCanadianObj = true;
		}
		
		assertEquals(true, isCanadianObj);
	}

	@Test
	public void testGetFrenchPostCodeObject() {
		
		boolean isFrenchObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode = api.getFrenchPostCodeObject("45000");
		
		if (postCode instanceof FrenchPostCode) {
			isFrenchObj = true;
		}
		
		assertEquals(true, isFrenchObj);
	}

	@Test
	public void testGetUkPostCodeObject() {
		
		boolean isUkObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode = api.getUkPostCodeObject("ST1 4BY");
		
		if (postCode instanceof UkPostCode) {
			isUkObj = true;
		}
		
		assertEquals(true, isUkObj);
	}

	@Test
	public void testGetUsaPostCodeObject() {
		
		boolean isUsaObj = false;
		
		PostCodeCreatorAPI api = PostCodeCreator.getInstance();
		
		PostCode postCode = api.getUsaPostCodeObject("84150");
		
		if (postCode instanceof UsaPostCode) {
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
