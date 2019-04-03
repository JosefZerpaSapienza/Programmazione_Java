/**
 *  Classe per il calcolo del modulo tra due espressioni matematiche.
 */
public class Modulo extends EspressioneMatematica
{
	public Modulo (EspressioneMatematica e1, EspressioneMatematica e2)
	{
		super(e1, e2);
	}

	@Override
	public double getValore()
	{
		return super.e1.getValore() % super.e2.getValore();
	}

}