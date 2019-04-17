public class Fenice extends EssereVivente
{
	private final static int MASSIMA_PROLE = 5;

	public Fenice(String nome, Sesso sesso)
	{
		super(nome, sesso);
	}

	public Fenice(Sesso sesso)
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
			prole.add(new Fenice(s > 0 ? Sesso.MASCHILE : Sesso.FEMMINILE));
		return prole;
	}

	public void risorgi()
	{
		if (stato != 0)
			return;
		stato = 1;
		eta = 0;

	}
}