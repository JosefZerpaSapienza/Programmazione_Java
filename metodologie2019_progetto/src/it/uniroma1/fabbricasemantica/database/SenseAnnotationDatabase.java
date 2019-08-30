package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Database to store SenseAnnotation task data.
 * @author josef
 *
 */
public class SenseAnnotationDatabase extends Database
{
	/**
	 * Name of the database file.
	 */
	private static final String FILE_NAME = "senseAnnotation.json";
	
	private static SenseAnnotationDatabase singleton = null;
	
	private SenseAnnotationDatabase() throws JsonSyntaxException, JsonIOException, IOException 
	{
		super(FILE_NAME);
	}

	/**
	 * Method to obtain an instance of the database.
	 * @return a singleton.
	 * @throws IOException
	 */
	public static SenseAnnotationDatabase getDatabase() throws IOException
	{
		if (singleton == null)
			singleton = new SenseAnnotationDatabase();

		return singleton;
	}

	/**
	 * Add the data to the database
	 * @param synsetID
	 * @param word
	 * @param sentence
	 * @param sense
	 */
	public void add(String synsetID, String word, String sentence, String sense)
	{
		JsonObject annotation = new JsonObject();
		annotation.addProperty("synsetID", synsetID);
		annotation.addProperty("word", word);
		annotation.addProperty("sentence", sentence);
		annotation.addProperty("sense", sense);
		super.add(annotation);
	}
}