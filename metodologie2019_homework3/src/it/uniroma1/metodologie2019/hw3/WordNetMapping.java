package it.uniroma1.metodologie2019.hw3;

import java.util.Optional;
import java.util.List;

/**
 * classe per la mappatura tra due versioni di WordNet.
 * @author josef
 *
 */
public class WordNetMapping 
{
	/**
	 * Limite minimo sullo score per il mapping.
	 */
	private static final double SCORE_THRESHOLD = 0.8;
	
	private final WordNet sourceWordNet;
	private final WordNet targetWordNet;
	
	public WordNetMapping(WordNet sourceWordNet, WordNet targetWordNet)
	{
		this.sourceWordNet = sourceWordNet; 
		this.targetWordNet = targetWordNet;
	}
	
	/**
	 * Metodo mappante. Mappa un dato synset, appartenente alla sourceWordNet,
	 * con un il synset più somigliante nella targetWordNet. 
	 * @param sourceSynset
	 * @return Optional<SynsetPairing>
	 */
	public Optional<SynsetPairing> getMapping(Synset sourceSynset)
	{
		// Controlla se sourceSynset appartiene a sourceWordNet 
		if(!sourceWordNet.getSynsetFromID(sourceSynset.getID()).equals(sourceSynset))
			return Optional.empty();
		// Se le source e target version sono uguali, risparmio la ricerca.
		if(sourceWordNet == targetWordNet)
			return Optional.of(new SynsetPairing(sourceSynset, sourceSynset));
		
		POS pos = sourceSynset.getPOS();
		return sourceSynset.getSynonyms().stream()
			.map(word -> targetWordNet.getSynsets(word, pos))
			.flatMap(List::stream)
			.map(synset -> new SynsetPairing(sourceSynset, synset))
			.filter(mapping -> mapping.getScore() > SCORE_THRESHOLD)
			.max((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));
	}
}
