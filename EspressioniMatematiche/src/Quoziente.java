/**
 *  Classe per il calcolo del quoziente tra due espressioni matematiche.
 */
public class Quoziente extends EspressioneBinaria
{
	public Quoziente (EspressioneMatematica e1, EspressioneMatematica e2)
	{
		super(e1, e2);
	}

	@Override
	public double getValore()
	{
		return super.e1.getValore() / super.e2.getValore();
	}

}