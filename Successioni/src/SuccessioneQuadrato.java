public class SuccessioneQuadrato implements Successione
{
	private int numero = 0;
	
	@Override
	public int next()
	{
		return Math.pow(numero++, 2);
	}
}