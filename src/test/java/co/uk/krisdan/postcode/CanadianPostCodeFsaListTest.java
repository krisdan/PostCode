package co.uk.krisdan.postcode;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import co.uk.krisdan.postcode.json.JsonReader;

public class CanadianPostCodeFsaListTest {

	@Test
	public void testCanadianPostCodeFsaListString() {
		
		boolean isValidInstance = false;
		
		JsonReader reader = new JsonReader();
		
		PostCodeElementCollection fsaListH = reader.readCanadianPostCodeFSA('H');
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName());
		
		if( list instanceof CanadianPostCodeFsaList) {
			isValidInstance = true;
		}
		
		assertEquals(true, isValidInstance);		
	}

	@Test
	public void testCanadianPostCodeFsaListStringArrayListOfCanadianPostCodeFSA() {
		
		boolean isValidInstance = false;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList fsaListH = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName(), fsaListH.getFsaList());
		
		if( list instanceof CanadianPostCodeFsaList) {
			isValidInstance = true;
		}
		
		assertEquals(true, isValidInstance);
	}

	@Test
	public void testGetFsaList() {
		
		boolean isCorrectList = true;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList fsaListH = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		ArrayList<CanadianPostCodeFSA> fsas = fsaListH.getFsaList();
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName(), fsas);
		
		for(CanadianPostCodeFSA fsa : list.getFsaList()) {
			
			if (!fsas.contains(fsa)) {
				isCorrectList = false;
			}
		}
		
		if(fsas.size() != list.getFsaList().size()) {
			isCorrectList = false;
		}
		
		assertEquals(true, isCorrectList);
	}

	@Test
	public void testGetName() {
		
		boolean isValidInstance = false;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList fsaListH = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		ArrayList<CanadianPostCodeFSA> fsaList = fsaListH.getFsaList();
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName(), fsaList);
		
		if( list.getName().equals(fsaListH.getName())) {
			isValidInstance = true;
		}
		
		assertEquals(true, isValidInstance);
	}

	@Test
	public void testGetCollection() {
		
		boolean isCollection = true;
		
		JsonReader reader = new JsonReader();
		
		PostCodeElementCollection fsaListH = reader.readCanadianPostCodeFSA('H');
		
		CanadianPostCodeFsaList fsaList = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		ArrayList<CanadianPostCodeFSA> fsas = fsaList.getFsaList();
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName(), fsas);
		
		for(PostCodeElement f : list.getCollection()){
			
			if(!fsas.contains((CanadianPostCodeFSA) f)){
				isCollection = false;
			}
		}
		
		if(list.getCollection().size() != fsas.size()) {
			isCollection = false;
		}
		
		assertEquals(true, isCollection);
	}

	@Test
	public void testAdd() {
		
		boolean addSuccess = false;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList fsaListH = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName(), fsaListH.getFsaList());
		
		int before = list.size();
		
		list.add(new CanadianPostCodeFSA("H9Z", "A Test"));
		
		int after = list.size();
		
		if(after == (before + 1)) {
			addSuccess = true;
		}
		
		assertEquals(true, addSuccess);
	}

	@Test
	public void testAddAll() {
		
		boolean addSuccess = false;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList fsaListH = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName());
		
		int correctSize = fsaListH.size();
		
		list.addAll(fsaListH.getCollection());
		
		if( list.size() == correctSize) {
			addSuccess = true;
		}
		
		assertEquals(true, addSuccess);
	}

	@Test
	public void testRemove() {
		
		boolean removeSuccess = false;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList list = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		int before = list.size();
		
		CanadianPostCodeFSA fsa = list.getFsaList().get(1);
		
		list.remove(fsa);
		
		int after = list.size();
		
		if(after == (before - 1)) {
			removeSuccess = true;
		}
		
		assertEquals(true, removeSuccess);
	}

	@Test
	public void testRemoveAll() {
		
		boolean removeSuccess = false;
		
		JsonReader reader = new JsonReader();
		
		CanadianPostCodeFsaList fsaListH = (CanadianPostCodeFsaList) reader.readCanadianPostCodeFSA('H');
		
		CanadianPostCodeFsaList list = new CanadianPostCodeFsaList(fsaListH.getName(), fsaListH.getFsaList());
		
		list.removeAll(fsaListH.getCollection());
		
		if( list.size() == 0) {
			removeSuccess = true;
		}
		
		assertEquals(true, removeSuccess);
	}

}
