public class TestClasseAnonima
{
	public void stampa()
	{
		System.out.println("Stampa");

		TestClasseAnonima test = new TestClasseAnonima()
		{
			@Override
			public void stampa()
			{
				System.out.println("Yuppy!");
			}
		};
		test.stampa();
	}

	public static void main (String[] args)
	{
		TestClasseAnonima t = new TestClasseAnonima();
		t.stampa();
	}

}