public class SuccessionePeriodica implements Successione
{
	private final static int[] SUCCESSIONE = new int[] {4, 8, 15, 16, 23, 42};

	private int indice = 0;
	
	@Override
	public int next()
	{
		if (indice == SUCCESSIONE.length)
			indice = 0;
		return SUCCESSIONE[indice++];
	}
}