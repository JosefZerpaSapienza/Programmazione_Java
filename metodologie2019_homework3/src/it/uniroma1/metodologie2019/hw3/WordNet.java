package it.uniroma1.metodologie2019.hw3;

import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

/**
 * Classe WordNet, raccoglie e gestisce i synset.
 * @author josef
 *
 */
public class WordNet implements Iterable<Synset>
{
	/**
	 *  Percorso relativo alla cartella dove si trovano le varie versioni di WordNet.
	 */
	private static final Path RELEASES_DIR_PATH = Paths.get("wordnet-releases", "releases");

	/**
	 *  Prefisso della cartella relativa ai file di una versione.
	 */
	private static final String VERSION_FOLDER_PREFIX = "WordNet-";

	/**
	 *  Percorso relativo alla cartella dove si trovano le varie versioni di WordNet.
	 */
	private static final String DATA_FOLDER_NAME = "dict";

	/**
	 *  Prefisso dei file data: data.POS
	 */
	private static final String DATA_FILES_PREFIX= "data.";

	/**
	 *  Prefisso che definisce una linea da ignorare nei file.
	 *  Es: Testo della licensa. 
	 */
	private static final String IGNORE_LINE_PREFIX = "  ";

	/**
	 * Carattere da eliminare dalle parole quando vengono cercate nell'index.
	 */
	private final static char PARENTHESIS = '(';
	
	/**
	 *  ArrayList contenente le istanze di WordNet già caricate.
	 */
	private static Map<String, WordNet> BUILT_WORDNETS = new HashMap<>();

	/**
	 *  Mappa che ogni parola alla lista di synset che la contengono.
	 */
	private final Map<String, LinkedList<Synset>> wordIndex;

	/**
	 *  Mappa che associa il ogni synset (valore) al proprio ID.
	 */
	private final Map<String, Synset> idIndex;

	/**
	 *  Versione di WordNet caricata.
	 */
	private final String version;

	/**
	 *  Costruisce l'instanza WordNet relativa alla verione specificata.
	 *  Finchè esiste la cartella relativa alla versione in input, la versione 
	 *  è accettabile. Altrimenti restituisce null.
	 *  @param version versione di WordNet richiesta
	 *  @param path percorso della directory che contiene i file data.POS
	 */
	private WordNet (String version, Path path)
	{
		// Variabili temporanee per i campi final.
		HashMap<String, Synset> idIndex= new HashMap<>();
		HashMap<String, LinkedList<Synset>> wordIndex = new HashMap<>();
		
		// Itera su tutti i file data.pos, costruisce e carica in memoria i synset.
		for (POS pos : POS.values())
		{
			Path dataPath = path.resolve(DATA_FILES_PREFIX + pos.toString());
			try (BufferedReader br = Files.newBufferedReader(dataPath))
			{
				String line;
				while(br.ready())
				{
					line = br.readLine();
					// Ignora le linee della licenza
					if(!line.startsWith(IGNORE_LINE_PREFIX))
					{
						Synset synset = new Synset(line);
						idIndex.put(synset.getID(), synset);
						for (String word : synset.getSynonyms())
							wordIndex.merge(formatWord(word), new LinkedList<Synset>(List.of(synset)), 
									(l1, l2) -> { l1.addAll(l2); return l1; });
					}
				}
			}
			catch (IOException e) { System.out.println("Missing file " + dataPath); /* Missing file */ }
		}
		// Assegno i campi final e salvo la versione appena creata nel registro BUILT_WORDNETS
		this.version = version;
		this.wordIndex = wordIndex;
		this.idIndex = idIndex;
		BUILT_WORDNETS.put(version, this);
	}

	/**
	 *  Restituisce un'instanza della versione di WordNet specificata
	 *  in input, se è valida. Se l'istanza è stata già creata precedentemente, 
	 *  la ri-restituisce, altrimenti chiama il costruttore della classe WordNet.
	 *  @param version versione di WordNet richiesta, in String
	 *  @return instanza WordNet
	 */
	public static WordNet getInstance(String version)
	{
		WordNet instance = BUILT_WORDNETS.get(version);
		if (instance == null)
		{
			Path path = RELEASES_DIR_PATH.resolve(VERSION_FOLDER_PREFIX + version).resolve(DATA_FOLDER_NAME);
			if (Files.exists(path))
				instance = new WordNet(version, path);
		}
		return instance;
	}
	
	/**
	 * Formatta una parola in input per la ricerca nell'index.
	 * @param word parola da formattare
	 * @return parola in lower-case, senza parentesi, ecc.
	 */
	private String formatWord(String word)
	{
		int i = word.indexOf(PARENTHESIS);
		if(i != -1)
			word = word.substring(0, i);
		word = word.toLowerCase();
		return word;
	}

	/**
	 *  Restituisce la lista di tutti i synsets che contengono la parola.
	 *  @param word parola da ricercare
	 *  @return lista di tutti i synset contenenti la parola
	 */	
	public List<Synset> getSynsets(String word)
	{
		return wordIndex.getOrDefault(formatWord(word), new LinkedList<Synset>());
	}

	/**
	 *  Restituisce la lista dei synsets che contengono la parola,
	 *  filtrati per POS.
	 *  @param word parola da ricercare
	 *  @param pos filtro POS
	 *  @return Lista di synset contenenti la parola, nel determinato POS
	 */	
	public List<Synset> getSynsets(String word, POS pos)
	{
		return getSynsets(word).stream()
				.filter(s -> s.getPOS().equals(pos))
				.collect(toList());
	}

	/**
	 *  Restituisce il synset corrispondente all'id in input. 
	 *  Se l'id non corrisponde a nessun synset, restituisce null.
	 *  @param id id del synset richiesto
	 *  @return synset corrispondente all'id specificato
	 */	
	public Synset getSynsetFromID(String id)
	{
		return idIndex.get(id);
	}

	/**
	 *  Restituisce un set contenente i synset che hanno la relazione voluta col synset in input.
	 *  @param synset istanza sulla quale cercare la relazione
	 *  @param relation relazione interessata, istanza di WordNetRelation
	 *  @return set insieme dei synset relazionati
	 */	
	public Set<Synset> getRelatedSynsets(Synset synset, WordNetRelation relation)
	{
		return synset.getRelatedIDs(relation).stream()
											.map(this::getSynsetFromID)
											.collect(toSet());
	}

	/**
	 *  Restituisce un set contenente i synset che hanno la relazione voluta col synset in input.
	 *  @param synset istanza sulla quale cercare la relazione
	 *  @param relation relazione interessata, formato stringa
	 *  @return set insieme dei synset relazionato
	 */	
	public Set<Synset> getRelatedSynsets(Synset synset, String relation)
	{
		return getRelatedSynsets(synset, WordNetRelation.get(relation));
	}

	/**
	 *  Restituisce uno stream di tutti i synset, indipendentemente dal POS.
	 */	
	public Stream<Synset> stream()
	{
		return idIndex.values().stream();
	}
	
	/**
	 * Classe per l'uso dell'Iterator.
	 */
	@Override
	public Iterator<Synset> iterator()
	{
		return idIndex.values().iterator();
	}
	
	/**
	 *  Restituisce la versione dell'istanza WordNet.
	 */	
	public String getVersion()
	{
		return version; 
	}
}