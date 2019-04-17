public class SuccessioneFibonacci implements Successione
{
	private int lastNumber1 = 1;

	private int lastNumber2 = 1;
	
	@Override
	public int next()
	{
		int next = lastNumber1 + lastNumber2;
		lastNumber1 = lastNumber2;
		lastNumber2 = next;
		return next;
	}
}