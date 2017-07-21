package library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONValue;

public class LibraryIO {
	

	/**
	 * Writes an object (hash map) out to a file.
	 * @param o, the object to write to file
	 * @param f, the file location and/or file name
	 * @return, if the operation was successful
	 */
	public static boolean writeObjectJSON(Object o, String f) {

		// Setup the writer
		BufferedWriter writer = null;
		try {
			// Try to write the people list to a JSON feed.
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "utf-8"));
			writer.write(JSONValue.toJSONString(o));
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		finally {
			try {
				writer.close();
				return true;
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "resource" })
	public static Object readObjectJSON(String f) {

		HashMap<Integer, Item> itemList = new HashMap<Integer, Item>();
		
		try { 
			File fileLocation = new File(f);
			FileInputStream fileReader = new FileInputStream(fileLocation);

			byte[] fileData = new byte[(int) fileLocation.length()];
			fileReader.read(fileData);
			
			String rawJson = new String(fileData, "UTF-8");
			System.out.println("[LibraryIO]: Raw JSON: " + rawJson);
			
			try { 
				HashMap<String, ArrayList<String>> decodedJson = (HashMap<String, ArrayList<String>>) JSONValue.parse(rawJson);
				 
				for(Object item : decodedJson.values()) {
					HashMap<String, String> obj = (HashMap<String, String>)item;
					System.out.println("[LibraryIO]: Decoded JSON value found: " + item);
					
					if(obj.containsKey("hardback")) {
						int id = Data.getNewItemId();
						System.out.println("[LibraryIO]: Found a new Book, adding to list with ID: " + id);
						itemList.put(id, new Book(obj.get("name"), Integer.parseInt(obj.get("pages")), Boolean.parseBoolean(obj.get("available")), Boolean.parseBoolean(obj.get("hardback"))));
					}
					else if(obj.containsKey("releasedate")) {
						int id = Data.getNewItemId();
						System.out.println("[LibraryIO]: Found a new Newspaper, adding to list with ID: " + id);
						itemList.put(id, new Newspaper(obj.get("name"), Integer.parseInt(obj.get("pages")), Boolean.parseBoolean(obj.get("available")), obj.get("releasedate"))); 
					}
					else if(obj.containsKey("category")) {
						int id = Data.getNewItemId();
						System.out.println("[LibraryIO]: Found a new Magazine, adding to list with ID: " + id);
						itemList.put(id, new Magazine(obj.get("name"), Integer.parseInt(obj.get("pages")), Boolean.parseBoolean(obj.get("available")), obj.get("category"))); 
					}
					else {
						System.out.println("[LibraryIO]: Item from file does not have custom attributes, unable to determine type.");
					}
				}
				
				System.out.println();
				if(itemList.size() > 0) { 
					return itemList;
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
			fileReader.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return new Object();
	}

}
