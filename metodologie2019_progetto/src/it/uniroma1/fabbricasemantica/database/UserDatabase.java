package it.uniroma1.fabbricasemantica.database;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonArray;

/**
 * Database to store User data.
 * @author josef
 *
 */
public class UserDatabase extends Database
{
	public static void main (String[] args) 
	{
		System.out.println(Boolean.valueOf("true"));
		
//		try (Database db = new Database())
//		{
//			boolean present = db.isPresent("josef@j.j");
//			// db.add("josef@j.j", "josef", Arrays.asList("English"), Arrays.asList("Italian B2"));
//			boolean check = db.checkCredentials("josef@j.j", "zerpa");
//			int index0 = db.findUser("zerpa@j.j");
//			int index1 = db.findUser("josef@j.j");
//			System.out.println(present + "\n" + check + "\n" + index0 + "\n" + index1);
//		}
//		catch (IOException e) { e.printStackTrace(); }
	}

	/**
	 * Name of the database file.
	 */
	private static final String FILE_NAME = "users.json";
	
	private static UserDatabase singleton = null;
	
	private UserDatabase() throws JsonSyntaxException, JsonIOException, IOException 
	{
		super(FILE_NAME);
	}
	
	/**
	 * Method to obtain an instance of the database.
	 * @return a singleton.
	 * @throws IOException
	 */
	public static UserDatabase getDatabase() throws IOException
	{
		if (singleton == null)
			singleton = new UserDatabase();

		return singleton;
	}
	/**
	 * Returns the user index in the database.
	 * -1 if it is not present
	 * @param email
	 * @return
	 */
	private int findUser(String email)
	{
		Iterator<JsonElement> it = database.iterator();
		for (int c = 0; it.hasNext(); c++)
		{
			JsonObject user = (JsonObject) it.next();
			if(user.get("email").getAsString().equals(email))
				return c;
		}
		
		return -1;
	}
	
	/**
	 * Check if the email given is present in the database
	 * @param email
	 * @return 
	 */
	public boolean isPresent(String email)
	{
		return findUser(email) >= 0;
	}
	
	/**
	 * Check credentials.
	 * @param email
	 * @param password
	 * @return if the credentials are correct.
	 */
	public boolean checkCredentials(String email, String password)
	{
		int index = findUser(email);
		System.out.println("Checking credentials " + email + " : " + password + " : " + index);
		if (index >= 0)
		{
			JsonObject user = (JsonObject) database.get(index);
			if (user.get("password").getAsString().equals(password))
				return true;			
		}
		
		return false;
	}
	
	/**
	 * Add user to the user database.
	 * @param email user's email
	 * @param password user's password
	 * @param mother List of mother tongues
	 * @param additional List of additional languages known
	 */
	public void add(String email, String password, List<String> mother, List<String> additional)
	{
		JsonObject user = new JsonObject();
		JsonArray motherJson = new JsonArray();
		mother.forEach(lang -> motherJson.add(lang));
		JsonArray additionalJson = new JsonArray();
		additional.forEach(lang -> additionalJson.add(lang));
		user.addProperty("email", email);
		user.addProperty("password", password);
		user.add("motherTongue", motherJson);
		user.add("additionalLanguages", additionalJson);
		super.add(user);
	}
}
