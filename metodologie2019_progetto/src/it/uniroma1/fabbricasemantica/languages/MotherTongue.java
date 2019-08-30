package it.uniroma1.fabbricasemantica.languages;

/**
 * Enumeration of languages available as "mother tongues".
 * @author josef
 *
 */
public enum MotherTongue 
{
	ENGLISH("englishMother", "English"),
	ITALIAN("italianMother", "Italian");

	/**
	 * Name to give at objects holding MotherTongue values.
	 */
	private String name;
	/**
	 * String to print the enum.
	 */
	private String string;
	
	private MotherTongue(String name, String string)
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
