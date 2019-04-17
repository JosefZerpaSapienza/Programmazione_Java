import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

abstract public class ListaDiInteri implements Iterable<Integer>
{
	private List<Integer> lista;

	public ListaDiInteri(int... sequenza) 
	{
		lista = new ArrayList<>();
		for (int x : sequenza) add(x);
	}

	protected void add(int k) 
	{ 
		lista.add(k);
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new ListaDiInteriIterator();
	}

	class  ListaDiInteriIterator implements Iterator<Integer>
	{
		private int i = 0;

		@Override
		public boolean hasNext() { return i < lista.size(); }
		@Override
		public Integer next() { return lista.get(i++); }
	}
}