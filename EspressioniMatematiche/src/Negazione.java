/**
 *  Classe per il calcolo della negazione di un'espressione matematica.
 */
public class Negazione extends EspressioneMatematica
{
	EspressioneMatematica e;

	public Negazione(EspressioneMatematica e)
	{
		this.e = e;
	}
	
	public Negazione(double n)
	{
		this(new Costante(n));
	}

	@Override
	public double getValore()
	{
		return -(e.getValore());
	}

}