/**
 *  Sposta avanti o indietro il giocatore.
 */
public class CasellaSpostaGiocatore extends Casella
{
	/**
	 *  Massimo numero di caselle per lo spostamento.
	 */
	private final int MAX_SPOSTAMENTO = (int)(tabellone.lunghezza * 0.33);

	public CasellaSpostaGiocatore(Tabellone tabellone)
	{
		super(tabellone);
	}

	@Override
	public void effetto(Giocatore giocatore)
	{
		System.out.println("E' capitato su una casella sposta-giocatore.");
		int n = RANDOM.nextInt(MAX_SPOSTAMENTO);
		int segno = RANDOM.nextInt(2);
		tabellone.muovi(giocatore, segno > 0 ? n : -n);
	}
}