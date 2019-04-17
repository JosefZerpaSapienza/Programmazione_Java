public class Gatto extends EssereVivente
{
	/**
	 *  Vite disponibili al gatto.
	 */
	private int vite = 7;

	private final static int MASSIMA_PROLE = 5;

	public Gatto(String nome, Sesso sesso)
	{
		super(nome, sesso);
	}

	public Gatto(Sesso sesso)
	{
		super(sesso);
	}

	@Override
	protected ArrayList<EssereVivente> generaProle()
	{
		int n = RANDOM.nextInt(MASSIMA_PROLE);
		int s = RANDOM.nextInt(2);
		ArrayList<EssereVivente> prole = new ArrayList<EssereVivente>();
		for (int m = 0; m < n; m++)
			prole.add(new Gatto(s > 0 ? Sesso.MASCHILE : Sesso.FEMMINILE));
		return prole;
	}

	@Override
	public void muore()
	{
		if(vite > 0)
			// Riduce il numero di vite disponibili 
			// e continua la sua esistenza.
			vite--;
		else
			super.muore();
	}
}