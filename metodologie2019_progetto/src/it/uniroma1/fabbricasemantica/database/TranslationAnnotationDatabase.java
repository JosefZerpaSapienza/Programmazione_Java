package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Database to store TranslationAnnotation task data.
 * @author josef
 *
 */
public class TranslationAnnotationDatabase extends Database
{
	/**
	 * Name of the database file.
	 */
	private static final String FILE_NAME = "translationAnnotation.json";
	
	private static TranslationAnnotationDatabase singleton = null;
	
	private TranslationAnnotationDatabase() throws JsonSyntaxException, JsonIOException, IOException 
	{
		super(FILE_NAME);
	}
	
	/**
	 * Method to obtain an instance of the database.
	 * @return a singleton.
	 * @throws IOException
	 */
	public static TranslationAnnotationDatabase getDatabase() throws IOException
	{
		if (singleton == null)
			singleton = new TranslationAnnotationDatabase();

		return singleton;
	}
	
	/**
	 * Add the data to the database
	 * @param synsetID
	 * @param word
	 * @param translation
	 */
	public void add(String synsetID, String word, String translation)
	{
		JsonObject annotation = new JsonObject();
		annotation.addProperty("synsetID", synsetID);
		annotation.addProperty("word", word);
		annotation.addProperty("translation", translation);
		super.add(annotation);
	}
}