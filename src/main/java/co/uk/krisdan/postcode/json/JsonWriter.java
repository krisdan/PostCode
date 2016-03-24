package co.uk.krisdan.postcode.json;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.uk.krisdan.postcode.PostCodeElementCollection;

public class JsonWriter {

	public JsonWriter() {
		
	}
	
	/*private String writeToFile(PostCodeElementCollection pec, String filePath) {
		
		Writer writer = null;
		
		try {
			writer = new FileWriter(filePath);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			if (writer == null) {
				this.closeQuietly(writer);
			}
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		gson.toJson(pec, writer);
		
		try {
			writer.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			if (writer == null) {
				this.closeQuietly(writer);
			}
		}
		
		return gson.toJson(pec);
	}
	
	public String writeOut(PostCodeElementCollection pec) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		gson.toJson(pec, System.out);
		
		return gson.toJson(pec);
		
	}
	
	public String write(PostCodeElementCollection pec, String fileName) {
		
		String path = System.getProperty("user.dir") + "/poo3/CanadianPostCodes/fsa";
		
		String file = path + "/" + fileName + ".json";
		
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String json = this.writeToFile(pec, file);
		
		System.out.println("Data written to file: " + file);
		
		return json;
	}
	
	public String write(PostCodeElementCollection pec, String fileName, String path){
		
		path = path.replaceAll("/$", "");
		
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdirs();
		}
		
		String file = path + "/" + fileName + ".json";
		
		String json = this.writeToFile(pec, file);
		
		System.out.println("Data written to file: " + file);
		
		return json;
		
	}
	
	private void closeQuietly(Closeable closeable) {
	    if (closeable != null) {
	        try {
	            closeable.close();
	        } catch (IOException ex) {
	            // ignore
	        }
	    }
	}*/
}
