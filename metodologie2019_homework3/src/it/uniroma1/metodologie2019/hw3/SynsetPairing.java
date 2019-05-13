package it.uniroma1.metodologie2019.hw3;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Classe degli oggetti mappanti: coppia di synset.
 * @author josef
 *
 */
public class SynsetPairing 
{
	/**
	 * Pesi dei vari termini per il calcolo dello score.
	 */
	private final static double SYNSET_WEIGHT = 0.5;
	private final static double DEFINITION_WEIGHT = 0.3;
	private final static double EXAMPLES_WEIGHT = 0.2;
	
	/**
	 * Synset sorgente.
	 */
	private final Synset source;

	/**
	 * Synset target.
	 */
	private final Synset target;
	
	/**
	 * Punteggio di somiglianza dei due synset, source e target.
	 */
	private final double score;
	
	/**
	 * Costruttore.
	 * @param source synset sorgente
	 * @param target synset con il quale valutare l'accoppiamento.
	 */
	public SynsetPairing(Synset source, Synset target)
	{
		this.source = source;
		this.target = target;
		
		double synonymsScore = 
				rateCommonWords(source.getSynonyms(), target.getSynonyms());
		
		Set<String> sourceDefinitionSet = Arrays.stream(source.getGloss().replaceAll("\\p{Punct}", "").split(" "))
				.collect(Collectors.toSet());
		Set<String> targetDefinitionSet = Arrays.stream(target.getGloss().replaceAll("\\p{Punct}", "").split(" "))
				.collect(Collectors.toSet());
		double definitionScore = 
				rateCommonWords(sourceDefinitionSet, targetDefinitionSet);

		Set<String> sourceExamplesSet = source.getExamples().stream()
				.map(s -> s.replaceAll("\\p{Punct}", "").split(" "))
				.flatMap(Arrays::stream)
				.collect(Collectors.toSet());
		Set<String> targetExamplesSet = target.getExamples().stream()
				.map(s -> s.replaceAll("\\p{Punct}", "").split(" "))
				.flatMap(Arrays::stream)
				.collect(Collectors.toSet());
		double examplesScore = 
				rateCommonWords(sourceExamplesSet, targetExamplesSet);
		
		score = synonymsScore * SYNSET_WEIGHT + definitionScore * DEFINITION_WEIGHT + examplesScore * EXAMPLES_WEIGHT;
	}

	public Synset getSource() {return source; }
	
	public Synset getTarget() {return target; }
	
	public double getScore() { return score; }

	/**
	 * Dati in input due Set<String> di parole, restituisce un valore compreso tra
	 * 0 e 1, calcolato come il rapporto tra le parole in comune e le parole in totale.
	 * @return double, grado di somiglianza dei set, in termini di parole in comune.
	 */
	private double rateCommonWords(Set<String> sourceWords, Set<String> targetWords)
	{
		double commonWords = sourceWords.stream()
			.filter(targetWords::contains)
			.count();
		double differentWords = targetWords.stream()
				.filter(word -> !sourceWords.contains(word))
				.count();
		
		double totalWords = sourceWords.size() + differentWords;
		
		return (totalWords == 0.0) ? 1.0 : commonWords / totalWords;
	}
	
	@Override
	public String toString()
	{
		return source + " <> " + target + " = " + score;
	}
}
