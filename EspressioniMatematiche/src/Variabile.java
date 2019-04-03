/**
 *  Classe per la formazione di un'espressione matematica con valore variabile.
 */
public class Variabile extends EspressioneMatematica
{
	private String nome;
	private double valore;

	public Variabile(String nome)
	{
		this.nome = nome;
	}

	public Variabile(String nome, double valore)
	{
		this(nome);
		setValore(valore);
	}

	public void setValore(double valore)
	{
		this.valore = valore;
	}

	@Override
	public double getValore()
	{
		return valore;
	}
}