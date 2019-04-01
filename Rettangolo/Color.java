public class Color
{
	private int r, g, b;

	public Color(int red, int green, int blue)
	{
		r = red;
		g = green;
		b = blue;
	}

	public Color()
	{
		this(0, 0, 0);
	}

	public String stampa()
	{
		return "(" + r + ", " + g + ", " + b + " )";
	}
}