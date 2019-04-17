public class Tabellone
{
	/**
	 *  Punti guadagnati da un giocatore che finisce il percorso.
	 */
	private final static int PUNTI_FINE_PERCORSO = 10;

	/** 
	 *  Percorso di gioco sul quale si muovono i giocatori.
	 */
	private Casella[] percorso;

	/**
	 *  Permette alle caselle di definire i loro effetti tenendo 
	 *  conto della lunghezza del tabellone.
	 *  es: CasellaSpostaGiocatore sceglierà uno spostamento proporzionato.
	 */
	public int lunghezza;

	private Giocatore[] giocatori;

	/**
	 *  Stato del gioco. Finisce quando un giocatore capita esattamente 
	 *  sull'ultima casella.
	 */
	public boolean finito = false;

	private Giocatore vincitore;

	public Tabellone(int lunghezza, Giocatore... giocatori)
	{
		percorso = new Casella[lunghezza];
		this.lunghezza = lunghezza;
		this.giocatori = giocatori;
		posizionaCaselle();
	}

	/**
	 *  Riempie il percorso di caselle.
	 */
	private void posizionaCaselle() 
	{
		for (int k = 0; k < lunghezza - 1; k++)
		{
			try { percorso[k] = GeneraCasella.getCasella(this); }
			catch (GenerazioneCasellaException e) { System.out.println("ops"); }
		}
		percorso[lunghezza - 1] = new CasellaFine(this);
	}

	/**
	 *  Posiziona i giocatori nel tabellone, considerando "l'effetto Oca".
	 */
	public void muovi(Giocatore giocatore, int spostamento)
	{
		System.out.println(giocatore.getNome() + (spostamento > 0 ? " avanza di " + spostamento :
					" indietreggia di " + -spostamento) + " caselle.");
		int nuovaPosizione = giocatore.getPosizione() + spostamento;

		if (nuovaPosizione < 0)
			nuovaPosizione += lunghezza;
		else if (nuovaPosizione >= lunghezza)
		{
			nuovaPosizione -= lunghezza;
			giocatore.cambiaPunteggio(PUNTI_FINE_PERCORSO);
		}

		giocatore.setPosizione(nuovaPosizione);

		// la casella in posizione [nuovaPosizione] svolge il suo effetto.
		percorso[nuovaPosizione].effetto(giocatore);
	}

	/**
	 *  Restituisce lo stato del gioco: false "in gioco", true "finito".
	 */
	public boolean isFinito()
	{
		return finito;
	}
	
	public Giocatore getVincitore()
	{
		return vincitore;
	}	

	public void setVincitore(Giocatore vincitore)
	{
		this.vincitore = vincitore;
	}
}