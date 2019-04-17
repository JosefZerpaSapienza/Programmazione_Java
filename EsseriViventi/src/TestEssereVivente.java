public class TestEssereVivente
{
	public static void main (String[] args)
	{
		EssereVivente e = new EssereUmano("Mike", Sesso.MASCHILE);
		System.out.println(e.getNome());
	}
}