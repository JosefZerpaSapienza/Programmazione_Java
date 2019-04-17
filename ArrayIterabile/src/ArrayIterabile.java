import java.util.Iterator;

public class ArrayIterabile implements Iterable<Integer>
{

	class IteratorArrayIterabile implements Iterator<Integer>
	{
		private int i = 0;
		/*
		private int[] array;

		public IteratorArrayIterabile(int[] array)
		{
			this.array = array;
		}*/

		@Override
		public boolean hasNext()
		{
			return i < array.length;
		}

		@Override
		public Integer next()
		{
			return array[i++]; 
		}
	}

	private int[] array;

	public ArrayIterabile(int[] array)
	{
		this.array = array;
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new IteratorArrayIterabile();
	}

	public static void main(String[] args)
	{
		ArrayIterabile a = new ArrayIterabile(new int[] {1, 2, 3, 4, 5});
		for (Integer i : a)
			System.out.println(i);
	}
}