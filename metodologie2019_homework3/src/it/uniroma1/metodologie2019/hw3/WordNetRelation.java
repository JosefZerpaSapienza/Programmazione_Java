package it.uniroma1.metodologie2019.hw3;

/**
 * Interfaccia per l'uso delle WordNetRelation.
 * @author josef
 *
 */
public interface WordNetRelation
{
	/**
	 * Restituisce la costante relativa alla stringa in input.
	 * Di default, null.
	 * @param rappresentazione stringa codificante il tipo di relazione.
	 * @return istanza WordNetRelation associata.
	 */
	public static WordNetRelation get(String rappresentazione)
	{
		switch(rappresentazione)
		{
			case "!":	return WordNetRelation1905.ANTONYM;
			case "@":	return WordNetRelation1905.HYPERNYM;
			case "@i":	return WordNetRelation1905.I_HYPERNYM;
			case "~":	return WordNetRelation1905.HYPONYM;
			case "~i":	return WordNetRelation1905.I_HYPONYM;
			case "#m":	return WordNetRelation1905.M_HOLONYM;
			case "#s":	return WordNetRelation1905.S_HOLONYM;
			case "#p":	return WordNetRelation1905.P_HOLONY;
			case "%m":	return WordNetRelation1905.M_MERONYM; 
			case "%s":	return WordNetRelation1905.S_MERONYM;
			case "%p":	return WordNetRelation1905.P_MERONYM;
			case "=":	return WordNetRelation1905.ATTRIBUTE;
			case "+":	return WordNetRelation1905.D_R_FORM;
			case ";c":	return WordNetRelation1905.DOS_TOPIC;
			case "-c":	return WordNetRelation1905.MOD_TOPIC; 
			case ";r":	return WordNetRelation1905.DOS_REGION;
			case "-r":	return WordNetRelation1905.MOD_REGION;
			case ";u":	return WordNetRelation1905.DOS_USAGE; 
			case "-u":	return WordNetRelation1905.MOD_USAGE;
			case "*":	return WordNetRelation1905.ENTAILMENT;
			case ">":	return WordNetRelation1905.CAUSE;
			case "^":	return WordNetRelation1905.ALSO_SEE;
			case "$":	return WordNetRelation1905.VERB_GROUP; 
			case "&":	return WordNetRelation1905.SIMILAR_TO;
			case "<":	return WordNetRelation1905.PARTICIPLE_OF_VERB;
			case "\\":	return WordNetRelation1905.PERTAINYM;
			default:	return null;
		}
	}
}