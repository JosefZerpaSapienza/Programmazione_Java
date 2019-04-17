import java.util.Random;

public class SuccessioneCasuale implements Successione
{
	private final static RANDOM = new Random();
	
	@Override
	public int next()
	{
		return RANDOM.nextInt();
	}
}