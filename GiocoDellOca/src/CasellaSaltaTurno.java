/**
 *  Fa saltare al giocatore un turno.
 */
public class CasellaSaltaTurno extends Casella
{
	public CasellaSaltaTurno(Tabellone tabellone)
	{
		super(tabellone);
	}

	@Override
	public void effetto(Giocatore giocatore)
	{
		giocatore.saltaTurno = true;
	}
}