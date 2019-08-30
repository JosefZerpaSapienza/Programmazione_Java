package it.uniroma1.fabbricasemantica.languages;

/**
 * Enumeration of languages available as "additional languages".
 * @author josef
 *
 */
public enum AdditionalLanguage 
{
	ENGLISH("englishAdditional", "English"),
	ITALIAN("italianAdditional", "Italian");
	/**
	 * Name to give at objects holding AdditionalLanguage values.
	 */
	private String name;
	/**
	 * String to print the enum.
	 */
	private String string;
	
	private AdditionalLanguage(String name, String string)
	{
		this.name= name;
		this.string = string;
	}
	
	/**
	 * Return the assigned name.
	 * @return
	 */
	public String getName() { return name; }
	
	// toString() gives problems (prints [object Object])
	/**
	 * Return the String representation of the language.
	 * @return
	 */
	public String getString() { return string; }
}
