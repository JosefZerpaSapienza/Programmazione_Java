public class TestRettangolo
{
	public static void main(String[] args)
	{
		Rettangolo rett1 = new Rettangolo(0, 0, 10, 20);
		
		System.out.println(rett1.toString());
		rett1.trasla(10, -5);
		rett1.impostaColore(1, 2, 3);
		System.out.println(rett1.toString());

	}
}