/**
 *  Classe per la formazione di un'espressione matematica costante.
 */
public class Costante extends EspressioneMatematica
{
	private double valore;

	public Costante (double valore)
	{
		this.valore = valore;
	}

	@Override
	public double getValore()
	{
		return valore;
	}

}