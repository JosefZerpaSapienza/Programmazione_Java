package it.uniroma1.fabbricasemantica.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import it.uniroma1.metodologie2019.hw3.Synset;
import it.uniroma1.metodologie2019.hw3.WordNet;
import it.uniroma1.metodologie2019.hw3.WordNetRelation1905;

/**
 * Provide a Json string containing the information which will
 * be presented to the user. The information is retrieved from WordNet(3.1).
 * */
public class WordNetDataProvider implements DataProvider<String> {
	/**
	 * Instance of WordNet.
	 */
	private static final WordNet WN = WordNet.getInstance();
	/**
	 * Random object to obtain random numbers.
	 */
	private static final Random RANDOM = new Random();
	
	private static final Path TRANSLATIONS_PATH = Paths.get("resources", "database", "translations.json");
	
	private static JsonArray translationSource;
	
	/**
	 * Given a collection, returns a random object from that collection.
	 * @param <T>
	 * @param collection
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static <T> T getRandom(Collection<T> collection)
	{
		if (collection == null || collection.size() == 0)
			return null;
		
		Object[] objects = collection.toArray();
		return (T) objects[RANDOM.nextInt(objects.length)];
	}

	/**
	 * Cleans a string for user presentation.
	 * @param string
	 * @return
	 */
	public static String normalize(String string)
	{
		return string.replace('_', ' ');
	}
	
	/**
	 * Given a task, return a string in Json format with the needed data.
	 * @param task the task to get info for.
	 * @return a Json string.
	 * @throws IOException 
	 */
	@Override 
	public String getData(Task task)
	{
		String synsetID = null;
		String word = null;
		String description = null;
		String hypernym = null;
		String example = null;
		String sentence = null; 
		String sensesJson = null;
		String sensesIDJson = null;
		// exit the while only if the synset satisfies every condition and reaches the end
		while(true)
		{
			if (task == StandardTask.TRANSLATION_VALIDATION)
			{
				if (translationSource == null)
				{
					try(BufferedReader br = Files.newBufferedReader(TRANSLATIONS_PATH, StandardCharsets.UTF_8))
					{ translationSource = new Gson().fromJson(br, JsonArray.class); }
					catch (IOException e)  { e.printStackTrace(); }
				}

				return translationSource.get(RANDOM.nextInt(translationSource.size())).toString();
			}
			
			Synset synset = WN.getRandom();
			if (synset != null)
				System.out.println("Synset retrieved succesfully: " + synset.toString());
			synsetID = synset.getID();
			word = getRandom(synset.getSynonyms());
			word = normalize(word);
			description = synset.getGloss();
			if (task == StandardTask.DEFINITION_ANNOTATION)
			{
				String hypernymID = getRandom(synset.getRelatedIDs(WordNetRelation1905.HYPERNYM));
				if (hypernymID == null)
				{
					System.out.println("hypernymID = null");
					continue;
				}
				hypernym = getRandom(WN.getSynsetFromID(hypernymID).getSynonyms());
				if (hypernym == null)
				{
					System.out.println("hypernym = null");
					continue;
				}
				hypernym = normalize(hypernym);
			}
			if (task == StandardTask.SENSE_VALIDATION )
			{
				example = getRandom(synset.getExamples());
				if (example == null || !example.contains(word))
				{
					System.out.println("example = null OR example doesn't contain word");
					continue;
				}
			}
			if (task == StandardTask.SENSE_ANNOTATION)
			{
				List<Synset> synsets = WN.getSynsets(word);
				if (synsets.size() < 4)
				{
					System.out.println("the picked synset has less than 4 senses");
					continue;
				}
				List<Synset> senses = new LinkedList<>();
				for(int i = 0; i < 4; i++)
				{
					Synset sy = getRandom(synsets);
					senses.add(sy);
					synsets.remove(sy);
				}
				// Set synsetID and sentence of picked sense.
				Synset sense = getRandom(senses);
				synsetID = sense.getID();
				sentence = getRandom(sense.getExamples());
				if (sentence == null|| !sentence.contains(word))
				{
					System.out.println("the picked sense doesn't have an example OR it doesn't contain the word.");
					continue;
				}
				StringJoiner sjSenses = new StringJoiner("\", \"", "[\"", "\"]");
				StringJoiner sjSensesID = new StringJoiner("\", \"", "[\"", "\"]");
				for (Synset sy : senses)
				{
					sjSenses.add(sy.getGloss());
					sjSensesID.add(sy.getID());
				}
				sensesJson = sjSenses.toString();
				sensesIDJson = sjSensesID.toString();
				
			}
			break;
		}
		
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
			return "{" +
					"\"synsetID\": \"" + synsetID + "\"," +
					"\"word\": \"" + word + "\"," +
					"\"description\": \"" + description + "\"" +
					"}";
		}else if (task == StandardTask.WORD_ANNOTATION) {
			return "{" +
					"\"synsetID\": \"" + synsetID + "\"," +
					"\"description\": \"" + description + "\"" +
					"}";
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {
			return "{" + 
					"\"synsetID\": \"" + synsetID + "\"," +
					"\"word\": \"" + word + "\"," +
					"\"hypernym\": \"" + hypernym + "\"" +
					"}";
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			return "{" + 
					"\"synsetID\": \"" + synsetID + "\"," +
					"\"word\":\"" + word + "\"," +
					"\"description\":\"" + sentence + "\"," + 
					"\"senses\": " + sensesJson + "," + 
					"\"sensesID\": " + sensesIDJson + 
					"}";
//		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
//			return "{" +
//					"\"synsetID\": \"00000000n\"," +
//					"\"word\": \"rock\"," +
//					"\"description\": \"A lump or mass of hard consolidated mineral matter\"," + 
//					"\"translations\": [\"Un grumo o una massa di materia minerale consolidata dura\"," +
//										"\"Materiale costituito dall'aggregato di minerali come quelli che formano la crosta terrestre\"," +
//										"\"Un'associazione non ufficiale di persone o gruppi\"]" +
//					"}";
		}else if (task == StandardTask.SENSE_VALIDATION) {
			return "{" + 
					"\"synsetID\": \"" + synsetID + "\"," +
					"\"word\": \"" + word + "\"," +
					"\"example\": \"" + example + "\"," +
					"\"sense\": \"" + description + "\"" +
					"}";
		}else if (task == StandardTask.MY_ANNOTATION) {
			return "{" + 
					"\"synsetID\": \"" + synsetID + "\"," +
					"\"word\": \"" + word + "\"," +
					"\"description\": \"" + description + "\"" +
					"}";
		}
		return null; 
	}
	

}
