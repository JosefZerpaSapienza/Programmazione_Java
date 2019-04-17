import java.util.Random;

public class GeneraCasella
{
	private final static Random RANDOM = new Random();
	/** 
	 *  Restituisce un nuovo oggetto casella definito nel tabellone in input.
	 * @param tabellone oggetto Tabellone sul quale la casella avrà effetto.
	 * @return instanza del tipo casella assegnato al valore immesso.
	 */
	public static Casella getCasella(Tabellone tabellone) throws GenerazioneCasellaException
	{
		// System.out.println("Generata ");
		int n = RANDOM.nextInt(10);

		switch (n)
		{
			case 0: case 1: case 2: case 3:
				// System.out.println("casella vuota.");
				return new CasellaVuota(tabellone);
			case 4: case 5:
				// System.out.println("casella sposta-giocatore.");
				return new CasellaSpostaGiocatore(tabellone);
			case 6: case 7: 
				// System.out.println("casella punti.");
				return new CasellaPunti(tabellone);
			case 8: case 9: 
				// System.out.println("casella salta-turno.");
				return new CasellaSaltaTurno(tabellone);
			default: 
				// System.out.println(n);
				throw new GenerazioneCasellaException();
		}
	}
}