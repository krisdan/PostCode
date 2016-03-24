package co.uk.krisdan.postcode.json;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.uk.krisdan.postcode.CanadianPostCodeFsaList;
import co.uk.krisdan.postcode.PostCodeElementCollection;

public class JsonReader {

	public JsonReader() {
		
	}
	
	private PostCodeElementCollection readCanadianPostCodeFSAList(String file) {
		
		Reader reader = null;
		
		try{
			reader = new BufferedReader( new FileReader(file));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (reader == null) {
				this.closeQuietly(reader);
			}
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		PostCodeElementCollection pec = gson.fromJson(reader, CanadianPostCodeFsaList.class);
		
		try {
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (reader != null) {
				this.closeQuietly(reader);
			}
		}

        return pec;
	}
	
	public PostCodeElementCollection readCanadianPostCodeFSA(String fileName) {
		
		String path = System.getProperty("user.dir") + "/data/CanadianPostCodes/fsa";
		
		String file = path + "/" + fileName + ".json";
		
		PostCodeElementCollection pec = this.readCanadianPostCodeFSAList(file);
		
		System.out.println("Data read from file: " + file);

        return pec;
	}
	
	public PostCodeElementCollection readCanadianPostCodeFSA(String fileName, String path) {
		
		path = path.replaceAll("/$", "");
		
		String file = path + "/" + fileName + ".json";
		
		PostCodeElementCollection pec = this.readCanadianPostCodeFSAList(file);
		
		System.out.println("Data read from file: " + file);

        return pec;
	}
	
	public PostCodeElementCollection readCanadianPostCodeFSA(char c) {
		
		String fileName = "FSAList" + c + ".json";
		
		String path = System.getProperty("user.dir") + "/data/CanadianPostCodes/fsa";
		
		String file = path + "/" + fileName;
		//System.out.println("READING FILE: " + file);
		PostCodeElementCollection pec = this.readCanadianPostCodeFSAList(file);
		
		//System.out.println("Data read from file: " + file);

        return pec;
	}
	
	private void closeQuietly(Closeable closeable) {
	    if (closeable != null) {
	        try {
	            closeable.close();
	        } catch (IOException ex) {
	            // ignore
	        }
	    }
	}

}
