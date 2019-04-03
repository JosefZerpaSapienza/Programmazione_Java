import java.util.Scanner;

public class TestCampoMinato
{
	public static void main (String[] args)
	{
		CampoMinato campo1 = new CampoMinato(Integer.parseInt(args[0]),
			 Integer.parseInt(args[1]), Integer.parseInt(args[2]));

		int x, y;
		while (campo1.vinto() == 0)
		{
			System.out.println(campo1.toString());
			System.out.print("Inserire la coordinata X della prossima casella da scoprire:\t");
			x = new Scanner(System.in).nextInt();
			System.out.print("Inserire la coordinata Y:\t");
			y = new Scanner(System.in).nextInt();
			campo1.scopri(x - 1, y - 1);
			campo1.checkStato();
		}

		System.out.println(campo1.toString());

		if (campo1.vinto() < 0)
			System.out.println("\nHai Perso.");
		else
			System.out.println("\nHai Vinto!");		
		
	}
}