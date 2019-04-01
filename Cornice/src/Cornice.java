 public class Cornice
{
	// lunghezza del lato della cornice  
	private int n;

	// Messaggio da stampare dentro la cornice
	private String messaggio;

	// Stringa decodificante la cornice, costruita progressivamente
	private StringBuilder stringa = new StringBuilder();

	// Nel costruttore assegno le variabili di istanza 
	// e aggiungo il padding al messaggio
	public Cornice(String messaggio, int lato)
	{
		n = lato;
		// in presenza di scarto tra messaggio e cornice;
		// ovvero la lungheza del messaggio non è multiplo
		// della lunghezza del lato - 2 (spazio entro i bordi).
		int scarto = messaggio.length() % (n - 2);
		if (scarto != 0)
			// Aggiunta padding al messaggio
			for(int c = 0; c < n - 2 - scarto; c++)
				messaggio += " ";
		this.messaggio = messaggio;
		
	}

	public void formaBordo()
	{
		// Forma il bordo cornice superiore/inferiore.
		for(int c = 0; c < n; c++)
			stringa.append("*");
		stringa.append("\n");
	}

	public void formaCorpo()
	{
		// Forma il corpo della cornice, incolonnando 
		// gli asterischi e inserendo il messaggio.
		int slength = messaggio.length();
		for(int i = 0; i < slength; i += n - 2)
			stringa.append("*" + messaggio.substring(i, i + n - 2) + "*\n");
	}

	public String toString()
	{
		formaBordo();
		formaCorpo();
		formaBordo();
		return stringa.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(new Cornice(args[0], Integer.parseInt(args[1])).toString());
	}
}