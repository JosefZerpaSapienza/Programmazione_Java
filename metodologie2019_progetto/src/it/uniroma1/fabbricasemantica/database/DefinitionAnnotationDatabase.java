package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonObject;

/**
 * Database to store DefinitionAnnotation task data.
 * @author josef
 *
 */
public class DefinitionAnnotationDatabase extends Database
{
	/**
	 * Name of the database file.
	 */
	private static final String FILE_NAME = "definitionAnnotation.json";
	
	private static DefinitionAnnotationDatabase singleton = null;
	
	private DefinitionAnnotationDatabase() throws JsonSyntaxException, JsonIOException, IOException 
	{
		super(FILE_NAME);
	}
	
	/**
	 * Method to obtain an instance of the database.
	 * @return a singleton.
	 * @throws IOException
	 */
	public static DefinitionAnnotationDatabase getDatabase() throws IOException
	{
		if (singleton == null)
			singleton = new DefinitionAnnotationDatabase();

		return singleton;
	}
	
	/**
	 * Add the data to the database
	 * @param synsetID
	 * @param word
	 * @param definition
	 */
	public void add(String synsetID, String word, String definition)
	{
		JsonObject annotation = new JsonObject();
		annotation.addProperty("synsetID", synsetID);
		annotation.addProperty("word", word);
		annotation.addProperty("definition", definition);
		super.add(annotation);
	}

}
