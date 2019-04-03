/**
 *  Classe per il calcolo della sottrazione tra due espressioni matematiche.
 */
public class Sottrazione extends EspressioneBinaria
{
	public Sottrazione(EspressioneMatematica e1, EspressioneMatematica e2)
	{
		super(e1, e2);
	}	

	@Override
	public double getValore()
	{
		return super.e1.getValore() - super.e2.getValore();
	}
}