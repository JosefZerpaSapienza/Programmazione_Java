import java.util.Iterator;

public class MyList implements Iterable<Integer>
{
	private Elemento first;

	static private class Elemento
	{
		private int val;

		private Elemento next;

		public Elemento(int val, Elemento next)
		{
			this.val = val; 
			this.next = next;
		}
	}

	public MyList(int... interi)
	{
		for (int k : interi)
			first = new Elemento(k, first);
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new MyListIterator();
	}

	class MyListIterator implements Iterator<Integer>
	{
		private Elemento last;

		public MyListIterator()
		{
			last = first;
		}

		@Override
		public boolean hasNext() { return last != null; }
		@Override
		public Integer next()
		{
			int next = last.val;
			last = last.next;
			return next;
		}
	}

	public static void main(String[] args)
	{
		MyList e = new MyList(new int[] {1,2,3,4});
		for(Integer i : e)
			System.out.println(i);
	}
}