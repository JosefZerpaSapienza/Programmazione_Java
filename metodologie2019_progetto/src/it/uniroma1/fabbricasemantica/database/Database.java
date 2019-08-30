package it.uniroma1.fabbricasemantica.database;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonArray;

/**
 * Class to define the fundamental functions of a Database.
 * @author josef
 *
 */
public class Database implements AutoCloseable
{
	/**
	 * Path to the folder in which the database will be created.
	 */
	private static final Path DATABASE_FOLDER = Paths.get("resources", "database");
	/**
	 * Path to the database file.
	 */
	private final Path databasePath;
	/**
	 * Database in form of a JsonArray.
	 */
	protected JsonArray database;
	
	/**
	 * Database constructor.
	 * @param fileName name of the file.
	 * @throws JsonSyntaxException
	 * @throws JsonIOException
	 * @throws IOException
	 */
	protected Database (String fileName) throws JsonSyntaxException, JsonIOException, IOException
	{
		// Check if folder and file exist, if not it creates them.
		DATABASE_FOLDER.toFile().mkdirs();
		databasePath = DATABASE_FOLDER.resolve(fileName);
		if (databasePath.toFile().createNewFile()) // return true if the file didn't exist and was created
			database = new JsonArray();
		else
		{
	        BufferedReader br = Files.newBufferedReader(databasePath, StandardCharsets.UTF_8);
	        database = new Gson().fromJson(br, JsonArray.class);
		}
	}
	
	/**
	 * Add JsonObject to the database.
	 * @param JsonObject containing the informatotion.
	 */
	protected void add(JsonObject object)
	{
		database.add(object);
	}
	
	/**
	 * Close database and write changes to disk.
	 */
	@Override
	public void close()
	{
        try (FileWriter file = new FileWriter(databasePath.toString()))
        {
            file.write(new Gson().toJson(database));
            file.flush();
//            System.out.println("written in " + DATABASE_PATH.toAbsolutePath());
        } 
        catch (IOException e) { e.printStackTrace(); }
	}
}
