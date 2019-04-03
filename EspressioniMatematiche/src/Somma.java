/**
 *  Classe per il calcolo della somma tra due espressioni matematiche.
 */
public class Somma extends EspressioneBinaria
{
	public Somma(EspressioneMatematica e1, EspressioneMatematica e2)
	{
		super(e1, e2);
	}

	@Override
	public double getValore()
	{
		return super.e1.getValore() + super.e2.getValore();
	}

}