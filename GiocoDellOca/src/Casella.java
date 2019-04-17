/**
 *  Classe astratta modello di una casella
 */
import java.util.Random;

public abstract class Casella
{
	/**
	 *  Ogni casella fa parte di un tabellone.
	 */
	protected final Tabellone tabellone;

	/**
	 *  Oggetto per la generazione pseudo-casuale di interi.
	 *  Utile alla maggior parte delle caselle.
	 */
	protected final static Random RANDOM = new Random();

	public Casella(Tabellone tabellone)
	{
		this.tabellone = tabellone;
	}

	/**
	 *  Metodo che svolge l'effetto della casella sul giocatore.
	 *  es: lo sposta avanti, gli fa saltare un turno, ecc.
	 *  @param giocatore oggetto sul quale il metodo ha effetto.
	 */
	abstract public void effetto(Giocatore giocatore);
}