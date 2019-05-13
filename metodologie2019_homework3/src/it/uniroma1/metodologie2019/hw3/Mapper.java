package it.uniroma1.metodologie2019.hw3;

/**
 * Classe per la mappatura tra due versioni WordNet
 * @author josef
 *
 */
public class Mapper
{
	/**
	 * Restituisce un'oggetto mappante, definito da una versione source e una versione target
	 * @param source versione sorgente
	 * @param target versione da dove cercare i synset simili
	 * @return istanza WordNetMapping che mappa singoli synset.
	 */
	public static WordNetMapping map(WordNet source, WordNet target)
	{
		return new WordNetMapping(source, target);
	}
}
