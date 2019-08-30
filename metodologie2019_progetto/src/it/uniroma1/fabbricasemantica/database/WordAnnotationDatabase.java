package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Database to store WordAnnotation task data.
 * @author josef
 *
 */
public class WordAnnotationDatabase extends Database
{
	/**
	 * Name of the database file.
	 */
	private static final String FILE_NAME = "wordAnnotation.json";
	
	private static WordAnnotationDatabase singleton = null;
	
	private WordAnnotationDatabase() throws JsonSyntaxException, JsonIOException, IOException 
	{
		super(FILE_NAME);
	}
	
	/**
	 * Method to obtain an instance of the database.
	 * @return a singleton.
	 * @throws IOException
	 */
	public static WordAnnotationDatabase getDatabase() throws IOException
	{
		if (singleton == null)
			singleton = new WordAnnotationDatabase();

		return singleton;
	}
	
	/**
	 * Add the data to the database
	 * @param synsetID
	 * @param description
	 * @param word
	 */
	public void add(String synsetID, String description, String word)
	{
		JsonObject annotation = new JsonObject();
		annotation.addProperty("synsetID", synsetID);
		annotation.addProperty("description", description);
		annotation.addProperty("word", word);
		super.add(annotation);
	}
}
