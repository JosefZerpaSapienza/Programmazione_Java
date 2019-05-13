package it.uniroma1.metodologie2019.hw3;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Classe per la creazione dei synset.
 * @author josef
 *
 */
public class Synset
{
	/**
	 *  Posizioni dei campi nelle righe di un file data.POS.
	 *  Riga: synset_offset  lex_filenum  ss_type  w_cnt  word  lex_id  [word  lex_id...]  p_cnt  [ptr...]  [frames...]  |   gloss 
	 */
	private final static int OFFSET_FIELD = 0; // synset_offset
	private final static int SSTYPE_FIELD = 2; // ss_type
	private final static int WORD_COUNT_FIELD = 3; // w_cnt
	private final static int WORD_FIELD = 4; // word
	/**
	 *  Campi pointer.
	 *  Per ogni ptr: pointer_symbol  synset_offset  pos  source/target 
	 */
	private final static int POINTER_FIELDS_NUMBER = 4;
	/**
	 * Base per i numeri w_count = esadecimale.
	 */
	private final static int W_COUNT_BASE = 16;

	/**
	 * Sequenza di caratteri separatori tra dati e glossa.
	 */
	private final static String GLOSS_SEPARATOR = "\\| ";

	/**
	 * Codice synset.
	 */
	private final String offset;

	/**
	 * Tipo di pos del synset.
	 */
	private final POS pos;

	private final String gloss;

	/**
	 *  Insieme delle parole contenute nel synset.
	 */
	private final Set<String> wordSet;

	/**
	 *  Insieme degli esempi contenuti nel synset.
	 */
	private final Set<String> examplesSet;
	
	/**
	 * Id del synset.
	 */
	private final String id;

	/**
	 *  Mappa tra le relazioni del synset e gli IDs.
	 */
	private final Map<WordNetRelation, HashSet<String>> relationsMap;

	/**
	 * Costruittore
	 * @param line linea contenuta in un file data.pos, da dove vengono 
	 * prese le informazioni per la costruzione del synset.
	 */
	public Synset(String line)
	{
		String[] fields = line.split(" ");

		offset = fields[OFFSET_FIELD];
		
		pos = POS.parseString(fields[SSTYPE_FIELD]);
		
		id = IDs.get(offset, pos);
		
		int wordCount = Integer.valueOf(fields[WORD_COUNT_FIELD], W_COUNT_BASE);
		HashSet<String> wordSet = new HashSet<>(); // Temporary WORD_SET
		int c;
		for (c = 0; c < wordCount; c++)
			wordSet.add(fields[WORD_FIELD + c * 2]); // Prendo le parole, saltando i lex_id
		this.wordSet= wordSet;


		// Campi pointer/relation.
		int pointerCount = WORD_FIELD + c * 2; // posizione p_cnt
		int pointerField = pointerCount + 1; // posizione pointer_symbol
		int pointedSynsetField = pointerField + 1; // posizione synset_offset
		int pointedPOSField = pointedSynsetField + 1; // posizione pos
		pointerCount = Integer.parseInt(fields[pointerCount]); // valore p_cnt
		Map<WordNetRelation, HashSet<String>> relationsMap = new HashMap<>(); // temporary RELATIONS_MAP
		for (c = 0; c < pointerCount; c++)
		{
			String relation = fields[pointerField + c * POINTER_FIELDS_NUMBER];
			WordNetRelation wordNetRelation = WordNetRelation.get(relation);
			String offset = fields[pointedSynsetField + c * POINTER_FIELDS_NUMBER];
			String ss_type = fields[pointedPOSField + c * POINTER_FIELDS_NUMBER];
			String id = IDs.get(offset, ss_type);
			relationsMap.merge(wordNetRelation, new HashSet<String>(List.of(id)), (x, y) -> { x.addAll(y); return x; });
		}
		this.relationsMap = relationsMap;


		
		// | medium for radio and television broadcasting; "the program was on the air from 9 
		// til midnight"; "the president used the airwaves to take his message to the people" 
		
		String gloss = line.split(GLOSS_SEPARATOR)[1];
		// Definizione presente?
		if (!gloss.startsWith("\""))
		{
			int endOfDefinition = gloss.indexOf("; \"");
			if (endOfDefinition == -1) endOfDefinition = gloss.length(); 
			this.gloss = gloss.substring(0, endOfDefinition).trim();
			gloss = gloss.substring(endOfDefinition);
		}
		else this.gloss = "";
		examplesSet =Arrays.stream(gloss.split("; | : "))
				.filter(s -> !s.isEmpty())
				.map(s -> s.replace("\"", "").trim())
				.collect(Collectors.toSet());
	}

	/**
	 *  Restituisce l'insieme delle parole contenute nel synset.
	 */	
	public Set<String> getSynonyms()
	{
		return wordSet;
	}

	/**
	 *  Verifica se la parola in input è presente nel synset.
	 */	
	public boolean contains(String word)
	{
		return wordSet.contains(word);
	}

	/**
	 *  Restituisce l'insieme dei synset che hanno una relazione col this,
	 *  sottoforma di ID.
	 */	
	HashSet<String> getRelatedIDs(WordNetRelation relation)
	{
		return relationsMap.getOrDefault(relation, new HashSet<>());
	}

	/**
	 * Restituisce l'offset del synset, come stringa.
	 */
	public String getOffset()
	{
		return offset;
	}

	/**
	 * Restituisce la glossa: stringa contenente la/e definizione/i del synset.
	 */
	public String getGloss()
	{
		return gloss;
	}

	/**
	 *  Restituisce l'insieme degli esempi del synset.
	 */	
	public Set<String> getExamples()
	{
		return examplesSet;
	}

	/**
	 * Restituisce l'istanza POS del synset.
	 */
	public POS getPOS()
	{
		return pos;
	}

	/**
	 *  Restituisce l'ID del synset.
	 */	
	public String getID()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return getID() + "=" + gloss;
	}
}