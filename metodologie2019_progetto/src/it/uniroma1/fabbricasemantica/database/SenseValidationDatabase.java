package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Database to store SenseValidation task data.
 * @author josef
 *
 */
public class SenseValidationDatabase extends Database
{
	/**
	 * Name of the database file.
	 */
	private static final String FILE_NAME = "senseValidation.json";
	
	private static SenseValidationDatabase singleton = null;
	
	private SenseValidationDatabase() throws JsonSyntaxException, JsonIOException, IOException 
	{
		super(FILE_NAME);
	}
	
	/**
	 * Method to obtain an instance of the database.
	 * @return a singleton.
	 * @throws IOException
	 */
	public static SenseValidationDatabase getDatabase() throws IOException
	{
		if (singleton == null)
			singleton = new SenseValidationDatabase();

		return singleton;
	}
	
	/**
	 * Add the data to the database
	 * @param synsetID
	 * @param word
	 * @param sentence
	 * @param sense
	 * @param correction
	 */
	public void add(String synsetID, String word, String sentence, String sense, String correction)
	{
		JsonObject validation = new JsonObject();
		validation.addProperty("synsetID", synsetID);
		validation.addProperty("word", word);
		validation.addProperty("sentence", sentence);
		validation.addProperty("sense", sense);
		validation.addProperty("correction", correction);
		super.add(validation);
	}
}