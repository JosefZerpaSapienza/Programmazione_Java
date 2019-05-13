package it.uniroma1.metodologie2019.hw3;

/**
 * Costanti enumerative relative ai tipi di POS disponibili.
 */
public enum POS
{
	NOUN("n", "NOUN"), 
	ADJECTIVE("a", "ADJ"),
	VERB("v", "VERB"),
	ADVERB("r", "ADV");

	/**
	 * Rappresentazione ad un solo carattere del tipo POS.
	 */
	private final String ss_type;

	/**
	 * Formato stringa equivalente alle estensioni dei file data e index.
	 */
	private final String stringa;

	/**
	 *  Costruttore dei tipi di POS, salva il tipo in formato stringa.
	 */
	POS (String ss_type, String stringa) { this.ss_type = ss_type; this.stringa = stringa; }

	/**
	 * restituisce una stringa formata da un carattere, rappresentante il tipo POS.
	 * @return ss_type
	 */
	public String toSSType() { return ss_type; }
	
	/**
	 * Restituisce la rappresentazione estesa del POS. Corrisponde 
	 * all'estensione di un file data.pos
	 */
	public String toString() { return stringa; }

	/**
	 * Restituisce l'istanza POS rispettiva alla stringa in input.
	 * Se il valore in input non è valido restituisce null.
	 * @param stringa formata da un solo carattere, anche detta ss_type
	 * @return istanza POS
	 */
	public static POS parseString(String stringa)
	{
		switch (stringa)
		{
			case "n": return POS.NOUN;
			case "a": case "s": return POS.ADJECTIVE;
			case "v": return POS.VERB;
			case "r": return POS.ADVERB;
			default: return null;
		}
	}
}