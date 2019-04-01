public class Rettangolo
{
	private int height, width, xCoord, yCoord;
	private Color colore = new Color();
	
	public Rettangolo(int xCoordinata, int yCoordinata, int altezza, int larghezza)
	{
		xCoord = xCoordinata;
		yCoord = yCoordinata;
		height = altezza;
		width = larghezza;
	}

	public void trasla(int x, int y)
	{
		xCoord += x;
		yCoord += y;
	}

	public void impostaColore(int r, int g, int b)
	{
		colore = new Color(r, g, b);
	}

	public String toString()
	{
		return "(" + xCoord + ", " + (yCoord + height) + ")->(" + (xCoord + width) + ", " + yCoord + ")\t" + colore.stampa();
	}
}