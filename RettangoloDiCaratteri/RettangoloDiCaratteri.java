public class RettangoloDiCaratteri
{
	private int xCoord;
	private int yCoord;
	private int lunghezza;
	private int altezza;
	private char carattere = '*';
	private char secondoCarattere = '$';
	private StringBuilder linea = new StringBuilder();

	/** Costruttore del rettangolo. Assegna gli input ai campi
	 *  @param xCoord coordinate x del rettangolo
	 *  @param yCoord coordinate y
	 *  @param lunghezza lunghezza del rettangolo
	 *  @param altezza altezza
	 */
	public RettangoloDiCaratteri(int xCoord, int yCoord, int lunghezza, int altezza)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.lunghezza = lunghezza;
		this.altezza = altezza;
	}

	/** Cambia la posizione del rettangolo, reimpostando le coordinate.
	 *  @param xCoord coordinate x del rettangolo
	 *  @param yCoord coordinate y
	 */
	public setPosition(int xCoord, int yCoord)
	{
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	/** Setta il primo carattere e resetta la linea che forma il rettangolo.
	 *  @param carattere primo carattere con il quale verrà disegnato il rettangolo
	 */
	public void setCarattere(char carattere)
	{
		this.carattere = carattere;
		resetLinea();
	}

	/** Setta sia il primo che il secondo carattere e resetta 
	 *  la linea formante il rettangolo. 
	 *  @param carattere primo carattere con il quale verrà disegnato il rettangolo
	 *  @param secondoCarattere secondo carattere con il quale verrà 
	 *  disegnato il rettangolo
	 */
	public void setCarattere(char carattere, char secondoCarattere)
	{
		this.carattere = carattere;
		this.secondoCarattere = secondoCarattere;
		resetLinea();
	}

	/** Restituisce un array contenente i vari caratteri che vengono
	 *  usati nello sviluppo del rettangolo.
	 *  @return array contentente i caratteri che formano il rettangolo.
	 */
	public char[] getCaratteri()
	{
		char c1 = carattere;
		char c2 = secondoCarattere;
		return new char = { c1, c2};
	}

	/** Resetta la linea con la quale viene composta la figura del rettangolo.
	 */
	private void resetLinea()
	{
		linea = new StringBuilder();
	}

	/** Riempe la linea del rettangolo con spazi che hanno 
	 *  l'effetto di spostare il rettangolo a destra.
	 */
	private void paddingLineaRettangolo()
	{
		for(int i = 0; i < xCoord; i++)
			linea.append(" ");
	}

	/** Compone la linea del rettangolo con il carattere specificato 
	 */
	private void formaLineaRettangolo()
	{
		paddingLineaRettangolo();
		for(int i = 0; i < lunghezza; i++)
			linea.append(carattere);
	}

	/** Compone la linea del rettangolo per uno sviluppo a strisce
	 */
	private void formaLineaRettangoloStripes()
	{
		resetLinea();
		paddingLineaRettangolo();
		for(int i = 0; i < lunghezza; i++)
			linea.append((i % 2 == 0) ? carattere : secondoCarattere);
	}

	/** Stampa a video gli spazi superiori al rettangolo.
	 */
	private void printPaddingSuperiore()
	{
		for(int y = 0; y < yCoord; y++)
			System.out.println(" ");
	}

	/** Stampa il rettangolo, stampando ripetutamente la linea compositrice.
	 */
	private void printRettangolo()
	{
		String linea = this.linea.toString();
		for(int y = 0; y < altezza; y++)
			System.out.println(linea);
	}

	/** Metodo pubblico per stampare il rettangolo
	 */
	public void draw()
	{
		printPaddingSuperiore();
		formaLineaRettangolo();
		printRettangolo();
	}

	/** Metodo pubblico per stampare il rettangolo a strisce di 
	 *  due caratteri distinti
	 */
	public void drawVerticalStripes()
	{
		printPaddingSuperiore();
		formaLineaRettangoloStripes();
		printRettangolo();
	}

	/** Metodo main.
	 *  Prende in input i parametri da prompt.
	 *  Rispettivamente xCoord, yCoord, lunghezza, altezza, secondoCarattere.
	 *  Prima stampa il rettangolo con un solo carattere, quello preimpostato.
	 *  Successivamente lo imposta a quello definito dal prompt e ristampa.
	 *  Poi lo ristampa a strisce alternate.
	 *  
	 */
	public static void main(String[] args)
	{
		RettangoloDiCaratteri rettangolo = new RettangoloDiCaratteri(
			Integer.parseInt(args[0]), Integer.parseInt(args[1]), 
			Integer.parseInt(args[2]), Integer.parseInt(args[3]));

		rettangolo.draw();
		rettangolo.setCarattere(args[4].charAt(0));
		rettangolo.draw();
		rettangolo.drawVerticalStripes();
	}
}