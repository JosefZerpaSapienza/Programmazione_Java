public class Pesce extends EssereVivente
{
	private final static int MASSIMA_PROLE = 100;

	private final static int MINIMA_PROLE = 30;

	public Pesce(String nome, Sesso sesso)
	{
		super(nome, sesso);
	}

	public Pesce(Sesso sesso)
	{
		super(sesso);
	}

	@Override
	protected ArrayList<EssereVivente> generaProle()
	{
		int n = RANDOM.nextInt(MASSIMA_PROLE - MINIMA_PROLE) + MINIMA_PROLE;
		int s = RANDOM.nextInt(2);
		ArrayList<EssereVivente> prole = new ArrayList<EssereVivente>();
		for (int m = 0; m < n; m++)
			prole.add(new Pesce(s > 0 ? Sesso.MASCHILE : Sesso.FEMMINILE));
		return prole;
	}
}