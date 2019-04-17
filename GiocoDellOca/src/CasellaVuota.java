/**
 *  Non ha effetto sul giocatore.
 */
public class CasellaVuota extends Casella
{
	public CasellaVuota(Tabellone tabellone)
	{
		super(tabellone);
	}

	@Override
	public void effetto(Giocatore giocatore) {
			System.out.println("E' capitato su una casella vuota.");
	 }

}