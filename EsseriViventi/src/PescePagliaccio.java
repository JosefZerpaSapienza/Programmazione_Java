public class PescePagliaccio extends Pesce
{
	/**
	 *  Probabilità che il pesce cambi sesso crescendo,
	 *  espressa in centestimi (totale = 100).
	 */
	private final static int PROBABILITA_CAMBIO_SESSO = 33;

	public PescePagliaccio(String nome, Sesso sesso)
	{
		super(nome, sesso);
	}

	public PescePagliaccio(Sesso sesso)
	{
		super(sesso);
	}

	private void cambiaSesso()
	{
		switch (sesso)
		{
			case Sesso.MASCHILE:
				sesso = Sesso.FEMMINILE;
				break;
			case Sesso.FEMMINILE:
				sesso = Sesso.MASCHILE;
				break;
		}
	}

	@Override
	public void cresce()
	{
		// cambia sesso "casualmente"
		if (RANDOM.nextInt(100) < PROBABILITA_CAMBIO_SESSO)
			cambiaSesso();
		super.cresce();
	}
}