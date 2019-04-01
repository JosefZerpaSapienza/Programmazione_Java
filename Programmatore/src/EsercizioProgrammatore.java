public class EsercizioProgrammatore
{
	public static void main(String[] args)
	{
		esercizio();
	}

	private static void esercizio()
	{
		Programmer p1 = new Programmer("Bjarne", "Stroustrup");
		Programmer p2 = new Programmer("Brian", "Kernighan");
		Programmer p3 = new Programmer("James", "Gosling");

		p1.addLinguaggio("C");
		p1.addLinguaggio("C++");
		p1.setAzienda("Morgan Stanley");

		p2.addLinguaggio("C");
		p2.addLinguaggio("AWK");

		p3.addLinguaggio("Java");
		p3.setAzienda("Oracle");

		System.out.println(p1.getAzienda());
		System.out.println(p2.getLinguaggi());
	}
}