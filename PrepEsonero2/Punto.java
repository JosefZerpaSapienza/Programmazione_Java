public class Punto implemets Comparable
{
	private int x;
	private int y;
	private int z;

	public Punto(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z; 
	}

	@Override
	public int compareTo(Object o) throws NullPointerException, ClassCastException
	{
		if (o == null) throw new NullPointerException();
		if (!(o isinstance Punto)) throw new ClassCastException();
		return x + y + z - o.x + o.y + o.z;

	}
}