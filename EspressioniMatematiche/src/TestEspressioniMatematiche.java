public class TestEspressioniMatematiche
{
	public static void main (String[] args)
	{
		Variabile x = new Variabile("x", 4.0);
		Variabile y = new Variabile("y", 5.0);
		Costante a = new Costante(2.0);
		Costante b = new Costante(3.0);
		Costante c = new Costante(5.0);

		// (4 + 2 - 3) * 5 = 15
		Somma e1 = new Somma(x, a);
		Negazione e2 = new Negazione(b);
		Somma e3 = new Somma(e1, e2);
		Prodotto e4 = new Prodotto(e3, c);
		System.out.println(e4.getValore());

		// -(4 + 2 - 3) * 10 / 5 = -9
		Negazione e5 = new Negazione(e3);
		Prodotto e6 = new Prodotto(e5, e4);
		Quoziente e7 = new Quoziente(e6, c);
		System.out.println(e7.getValore());

		// 5 * z / (z + x) = 4 | z = 8, x = 2
		Variabile z = new Variabile("z");
		Prodotto e8 = new Prodotto(new Costante(5.0), z);
		Somma e9 = new Somma(z, x);
		Quoziente e10 = new Quoziente(e8, e9);
		x.setValore(2.0);
		z.setValore(8.0);
		System.out.println(e10.getValore());

		// –(5+(3/2)-2)*x 
		Quoziente e11 = new Quoziente(b, a);
		Somma e12 = new Somma(c, e11);
		Sottrazione e13 = new Sottrazione(e12, a);
		Negazione e14 = new Negazione(e13);
		Prodotto e15 = new Prodotto(e14, x);
		x.setValore(3.0);
		System.out.println(e15.getValore()); // -13.5
		x.setValore(6.0);
		System.out.println(e15.getValore()); // -27

	}
}