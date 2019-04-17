public class StringaPlus implements Verificabile
{
	private String stringa;

	private final int MAX_L;

	public StringaPlus(String stringa, int max_l)
	{
		this.stringa = stringa;
		MAX_L = max_l;
	}

	public void append(String stringa) { this.stringa.concat(stringa); }

	@Override
	public boolean verifica()
	{
		if (stringa.length > MAX_L)
			return true;
		return false;
	}
}