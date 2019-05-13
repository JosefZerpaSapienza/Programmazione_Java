package it.uniroma1.metodologie2019.hw3;

/**
 *  Classe di supporto per maneggiare gli IDs.
 *  L'ID di un synset è definito come la stringa risultante dalla concatenazione 
 *  dell'offset e del carattere rappresentante il POS.
 */
public class IDs 
{
	/**
	 *  Preso in input un offset e un POS, restituisce il rispettivo ID.
	 */
	public static String get(String offset, POS pos)
	{
		return get(offset, pos.toSSType());
	}

	/**
	 *  Preso in input un offset e un ss_type, restituisce il rispettivo ID.
	 */
	public static String get(String offset, String ss_type)
	{
		return offset + ss_type;
	}

	/**
	 *  Preso in input un ID, ne restituisce l'offset in String.
	 */
	public static String getOffset(String stringID)
	{
		return stringID.substring(0, stringID.length() - 1);
	}

	/**
	 *  Preso in input un ID, ne restituisce il POS.
	 */
	public static POS getPOS(String stringID)
	{
		try { return POS.parseString(stringID.substring(stringID.length() - 1, stringID.length())); }
		catch (IllegalArgumentException e) { return null; }
	}
}