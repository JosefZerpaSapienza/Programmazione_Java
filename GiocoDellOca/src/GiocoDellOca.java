public class GiocoDellOca
{
	private final Tabellone tabellone;

	private final Giocatore[] giocatori;

	private int turno = 0;

	public GiocoDellOca(int l, Giocatore... giocatori)
	{
		tabellone = new Tabellone(l, giocatori);
		this.giocatori = giocatori;
		System.out.println("\nMolto bene... Il Gioco Dell'Oca comincia!");
	}

	public void giocaUnTurno()
	{
		System.out.println("\n\nTurno: " + ++turno);
		for(Giocatore giocatore : giocatori)
		{
			if (!giocatore.saltaTurno)
			{
				int n = giocatore.tiraDadi();
				tabellone.muovi(giocatore, n);
			}
			else
				giocatore.saltaTurno = false;
		}
	}

	public boolean inGioco()
	{
		return !tabellone.isFinito();
	}

	public void printClassifica()
	{
		System.out.println("\n\nIl gioco è finito.\n Il vincitore è :\t" + 
						 tabellone.getVincitore().getNome());
		System.out.println("\n\nClassifica:");
		for(Giocatore giocatore : giocatori)
		{
			System.out.println("\t" + giocatore.getNome() + ": " + giocatore.getPunti() 
				+ " punti." + (giocatore.equals(tabellone.getVincitore()) ? " Vincitore!" : ""));
		}
	}

	public static void main(String[] args)
	{
		GiocoDellOca gioco = new GiocoDellOca(Integer.parseInt(args[0]),
				new Giocatore("Mario"), new Giocatore("Luigi"), 
				new Giocatore("Deasy"), new Giocatore("Peach"));

		while (gioco.inGioco())
		{
			gioco.giocaUnTurno();
		}
		gioco.printClassifica();

	}
}