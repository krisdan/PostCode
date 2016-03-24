package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class CanadianPostCodeFSATest {

	@Test
	public void testCanadianPostCodeFSA() {
		
		boolean isValidInstance = false;
		
		String code = "H2J";
		
		String description = "Plateau Mont-Royal, North Central";
		
		CanadianPostCodeFSA fsa = new CanadianPostCodeFSA(code, description);
		
		if (fsa instanceof CanadianPostCodeFSA) {
			isValidInstance = true;
		}
		
		assertEquals(true, isValidInstance);
	}

	@Test
	public void testGetCode() {
		
		boolean codeCorrect = false;
		
		String code = "H2J";
		
		String description = "Plateau Mont-Royal, North Central";
		
		CanadianPostCodeFSA fsa = new CanadianPostCodeFSA(code, description);
		
		if (fsa.getCode().equals(code)) {
			codeCorrect = true;
		}
		
		assertEquals(true, codeCorrect);
	}

	@Test
	public void testGetDescription() {
		
		boolean descCorrect = false;
		
		String code = "H2J";
		
		String description = "Plateau Mont-Royal, North Central";
		
		CanadianPostCodeFSA fsa = new CanadianPostCodeFSA(code, description);
		
		if (fsa.getDescription().equals(description)) {
			descCorrect = true;
		}
		
		assertEquals(true, descCorrect);
	}

	@Test
	public void testCompareTo() {
		
		boolean isAfter = false;
		
		String code1 = "H1C";
		
		String description1 = "Rivière-des-Prairies, Northeast";
		
		String code2 = "H2J";
		
		String description2 = "Plateau Mont-Royal, North Central";
		
		CanadianPostCodeFSA fsa1 = new CanadianPostCodeFSA(code1, description1);
		
		CanadianPostCodeFSA fsa2 = new CanadianPostCodeFSA(code2, description2);
		
		int position = fsa2.compareTo(fsa1);
		
		System.out.println(position);
		
		if (position > 0) {
			isAfter = true;
		}
		
		assertEquals(true, isAfter);
	}

}
