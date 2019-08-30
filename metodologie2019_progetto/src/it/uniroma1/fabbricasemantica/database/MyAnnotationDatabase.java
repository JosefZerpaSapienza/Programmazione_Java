package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

/**
 * Database to store MyAnnotation task data.
 * @author josef
 *
 */
public class MyAnnotationDatabase extends Database
	{
		/**
		 * Name of the database file.
		 */
		private static final String FILE_NAME = "myAnnotation.json";
		
		private static MyAnnotationDatabase singleton = null;
		
		private MyAnnotationDatabase() throws JsonSyntaxException, JsonIOException, IOException 
		{
			super(FILE_NAME);
		}

		/**
		 * Method to obtain an instance of the database.
		 * @return a singleton.
		 * @throws IOException
		 */
		public static MyAnnotationDatabase getDatabase() throws IOException
		{
			if (singleton == null)
				singleton = new MyAnnotationDatabase();

			return singleton;
		}

		/**
		 * Add the data to the database
		 * @param synsetID
		 * @param word
		 * @param definition
		 */
		public void add(String synsetID, String word, String example)
		{
			JsonObject annotation = new JsonObject();
			annotation.addProperty("synsetID", synsetID);
			annotation.addProperty("word", word);
			annotation.addProperty("example", example);
			super.add(annotation);
		}
	}