public class ListaDiInteriTranneUno extends ListaDiInteri
{
	private final int tranneN;

	public ListaDiInteriTranneUno(int tranneN)
	{
		super(new int[0]);
		this.tranneN = tranneN;
	}

	@Override
	protected void add(int k)
	{
		if(k != tranneN)
			super.add(k);
	}

	public static void main (String[] args)
	{
		ListaDiInteri lista = new ListaDiInteriTranneUno(1);
		lista.add(2);
		lista.add(1);
		lista.add(0);
		for(Integer i : lista)
			System.out.println(i);
	}
}