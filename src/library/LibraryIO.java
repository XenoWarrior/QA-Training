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

import main.Person;

public class LibraryIO {
	
	public static boolean WriteObjectJSON(HashMap o, String f) {

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
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		return false;
	}
	
	/*
	public static Object ReadObjectJSON(String f) {

		// Now read them back and convert to objects
		try { 
			File fileLocation = new File(f);
			FileInputStream fileReader = new FileInputStream(fileLocation);

			byte[] fileData = new byte[(int) fileLocation.length()];
			
			fileReader.read(fileData);
			
			String rawJson = new String(fileData, "UTF-8");
			System.out.println("[LibraryIO] Raw JSON: " + rawJson);
			
			try { 
				ArrayList<String> decodedJson = (ArrayList<String>) JSONValue.parse(rawJson);
				 
				for(String s : decodedJson) {
					System.out.println("Decoded JSON value found: " + s);
					HashMap<String, String> attribs = (HashMap<String, String>) JSONValue.parse(s);
					personList.add(new Person(attribs.get("name"), Integer.parseInt(attribs.get("age")), attribs.get("job")));
				}
				
				System.out.println();
				
				for(Person p : personList) {
					System.out.println("Converted JSON -> Person gives: " + p.stringify());
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
	*/

}
