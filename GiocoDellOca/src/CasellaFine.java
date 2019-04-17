/**
 *  Casella di fine percorso. Fa finire il gioco.
 */
public class CasellaFine extends Casella
{
	public CasellaFine(Tabellone tabellone)
	{
		super(tabellone);
	}

	@Override
	public void effetto(Giocatore giocatore)
	{
		tabellone.finito = true;
		tabellone.setVincitore(giocatore);
		System.out.println(giocatore.getNome() + " ha raggiunto la fine!");
	}
}