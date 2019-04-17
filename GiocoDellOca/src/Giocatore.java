import java.util.Random;

public class Giocatore
{
	private final String nome;

	/**
	 *  Posizione del giocatore nel tabellone.
	 */
	private int posizione;

	/**
	 *  Punti accumulati.
	 */
	private int punti;

	boolean saltaTurno;

	private static Random RANDOM = new Random();

	public Giocatore(String nome)
	{
		this.nome = nome;
		System.out.println("Giocatore " + nome);
	}

	/**
	 *  Simula un lancio di dadi.
	 */
	public int tiraDadi()
	{
		System.out.print("\n" + nome + " tira i dadi. . .");
		// + 2 per spostare il range di generazione da 0-10 a 2-12 
		int risultato = RANDOM.nextInt(6) + RANDOM.nextInt(6) + 2;
		System.out.println("\tE' uscito " + risultato);
		return risultato;
	}

	public void setPosizione(int nuovaPosizione)
	{
		posizione = nuovaPosizione;
	}

	public int getPosizione()
	{
		return posizione;
	}

	public void cambiaPunteggio(int punti)
	{
		this.punti += punti;
	}

	public int getPunti()
	{
		return punti;
	}

	public String getNome()
	{
		return String.valueOf(nome);
		// return nome.substring(0);
	}
}