import java.util.Random;
import java.util.ArrayList;

abstract public class EssereVivente
{
	private String nome;

	private Sesso sesso;
	
	private int eta = 0;

	private final static int PROBABILITA_DECESSO = 33;

	protected final static Random RANDOM = new Random();

	/**
	 *  Codifica lo stato dell'essere vivente.
	 *  es: 0 "morto", 1 "in vita", 2 "malato", ecc.
	 */
	private int stato = 1;

	public EssereVivente(String nome, Sesso sesso)
	{
		this.nome =  nome;
		this.sesso = sesso;
	}

	public EssereVivente(Sesso sesso)
	{
		this.sesso = sesso;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public Sesso getSesso()
	{
		return sesso;
	}

	public int getEta()
	{
		return eta;
	}

	public void cresce() throws DecessoException
	{
		if (stato == 0)
			throw new DecessoException();
		eta++;
		if (RANDOM.nextInt(100) < PROBABILITA_DECESSO)
			muore();
	}

	public void muore()
	{
		stato = 0;
	}

	public void mangia() throws DecessoException
	{
		if (stato == 0)
			throw new DecessoException();
		// Essere vivente mangia. Gnam!
	}

	public ArrayList<EssereVivente> siRiproduceCon(EssereVivente essere) throws RiproduzioneException, DecessoException
	{
		if (stato == 0)
			throw new DecessoException();
		if (sesso != essere.sesso)
		{
			// Controllo che l'essere possa generare.
			if (sesso.equals(Sesso.MASCHILE))
				return essere.siRiproduceCon(this);
			return generaProle();
		}
		else
			throw new RiproduzioneException();
	}

	abstract protected ArrayList<EssereVivente> generaProle();
}