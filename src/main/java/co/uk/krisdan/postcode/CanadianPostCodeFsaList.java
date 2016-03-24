package co.uk.krisdan.postcode;

import java.util.ArrayList;
import java.util.List;

public class CanadianPostCodeFsaList implements PostCodeElementCollection {
	
	private String name;
	
	private ArrayList<CanadianPostCodeFSA> fsaList;

	public CanadianPostCodeFsaList(String name) {
		
		this.setName(name);
		
		this.fsaList = new ArrayList<CanadianPostCodeFSA>();
	}
	
	public CanadianPostCodeFsaList(String name, ArrayList<CanadianPostCodeFSA> list) {
		
		this.setName(name);
		
		this.setFsaList(list);
	}
	
	public ArrayList<CanadianPostCodeFSA> getFsaList() {
		return fsaList;
	}

	private void setFsaList(ArrayList<CanadianPostCodeFSA> fsaList) {
		this.fsaList = fsaList;
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}
	
	@Override
	public ArrayList<PostCodeElement> getCollection() {
		
		ArrayList<PostCodeElement> genericList = new ArrayList<PostCodeElement>(this.getFsaList());
		
		return genericList;
	}

	@Override
	public boolean add(PostCodeElement canadianPostCodeFSA) {
		
		boolean success = false;
		
		int before = this.fsaList.size();
		
		this.fsaList.add((CanadianPostCodeFSA) canadianPostCodeFSA);
		
		int after = this.fsaList.size();
		
		success = (after > before);
		
		return success;
	}
	
	@Override
	public boolean addAll(ArrayList<PostCodeElement> canadianPostCodeFSA) {
		
		boolean success = false;
		
		int before = this.fsaList.size();
		
		for(PostCodeElement fsa : canadianPostCodeFSA) {
			
			this.fsaList.add((CanadianPostCodeFSA) fsa);
		}
		
		int after = this.fsaList.size();
		
		success = (after > before);
		
		return success;
	}
	
	@Override
	public boolean remove(PostCodeElement canadianPostCodeFSA) {
		
		CanadianPostCodeFSA fsa = (CanadianPostCodeFSA) canadianPostCodeFSA;
		
		boolean success = false;
		
		int before = this.fsaList.size();
		
		this.fsaList.remove(fsa);
		
		int after = this.fsaList.size();
		
		success = (after < before);
		
		return success;
	}
	
	@Override
	public boolean removeAll(ArrayList<PostCodeElement> pceList) {
		
		ArrayList<CanadianPostCodeFSA> fsaList = new ArrayList<CanadianPostCodeFSA>();
		
		for(PostCodeElement pce : pceList) {
			
			fsaList.add((CanadianPostCodeFSA) pce);
		}
		
		boolean success = false;
		
		int before = this.fsaList.size();
		
		this.fsaList.removeAll(fsaList);
		
		int after = this.fsaList.size();
		
		success = (after < before && after == 0);
		
		return success;
	}
	
	public int size() {
		
		return this.getFsaList().size();
	}
	
	public String toString() {
		
		StringBuilder out = new StringBuilder();
		
		List<CanadianPostCodeFSA> list = this.getFsaList();
		
		out.append("\r");
		out.append("----------------------------------");
		out.append("\r");
		out.append("FSA List:");
		out.append("\r");
		out.append("name: " + this.getName() + " ");
		out.append("\r");
		out.append("\r");
		out.append("FSAs: ");
		out.append("\r");
		
		for(CanadianPostCodeFSA canadianPostCodeFSA: list) {
			
			out.append(canadianPostCodeFSA.toString());
		}
		
		out.append("\r");
		out.append("----------------------------------");
		out.append("\r");
		
		return out.toString();
	}
}
