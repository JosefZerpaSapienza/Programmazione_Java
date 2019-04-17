/**
 *  Incrementa o decrementa il punteggio del giocatore.
 */
public class CasellaPunti extends Casella
{
	/**
	 *  Massimo numero di caselle per lo spostamento.
	 */
	private final static int MAX_PUNTI = 5;

	public CasellaPunti(Tabellone tabellone)
	{
		super(tabellone);
	}

	@Override
	public void effetto(Giocatore giocatore)
	{
		System.out.println("E' capitato su una casella punti.");
		int n = RANDOM.nextInt(MAX_PUNTI);
		int segno = RANDOM.nextInt(2);
		giocatore.cambiaPunteggio(segno > 0 ? n : -n);
		System.out.println(giocatore.getNome() + (n > 0 ? " acquisisce " + n :
								" perde " + n) + "punti.");
	}
}