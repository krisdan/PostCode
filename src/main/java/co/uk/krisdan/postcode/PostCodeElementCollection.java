package co.uk.krisdan.postcode;

import java.util.ArrayList;

public interface PostCodeElementCollection {
	
	public String getName();
	
	public ArrayList<PostCodeElement> getCollection();

	public boolean add(PostCodeElement pce);
	
	public boolean addAll(ArrayList<PostCodeElement> pceList);
	
	public boolean remove(PostCodeElement pce);
	
	public boolean removeAll(ArrayList<PostCodeElement> pceList);

}
