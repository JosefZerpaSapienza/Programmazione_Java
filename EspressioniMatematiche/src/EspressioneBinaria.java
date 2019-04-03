/**
 *  Classe per la formazione di un'espressione matematica binaria.
 */
abstract public class EspressioneBinaria extends EspressioneMatematica
{
	EspressioneMatematica e1;
	EspressioneMatematica e2;	

	public EspressioneBinaria (EspressioneMatematica e1, EspressioneMatematica e2)
	{
		this.e1 = e1;
		this.e2 = e2;
	}

}