import java.util.ArrayList;

public class EssereUmano extends EssereVivente
{
	private final static int MASSIMA_PROLE = 2;

	public EssereUmano(String nome, Sesso sesso)
	{
		super(nome, sesso);
	}

	public EssereUmano(Sesso sesso)
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
			prole.add(new EssereUmano(s > 0 ? Sesso.MASCHILE : Sesso.FEMMINILE));
		return prole;
	}
}