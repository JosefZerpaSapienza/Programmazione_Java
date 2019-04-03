public class CampoMinato
{
	/** 
	 *  Stato del gioco: -1 = perso, 0 = in gioco, 1 = vinto
	 */
	private int stato = 0;
	/** 
	 *  Matrice rappresentante il campo da gioco.
	 */
	private int[][] campo;
	/**
	 *  Maschera del campo, indica le caselle scoperte.
	 */
	private boolean[][] mask;
	/**
	 *  Numero di colonne.
	 */
	private final int N;
	/**
	 *  Numero di linee.
	 */
	private final int M;
	/**
	 *  Numero di mine.
	 */
	private final int NUM_MINE;

	/**
	 *  Costruttore del campo. Inizializza i campi e costruisce
	 *  il campo e la maschera 
	 *  @param N numero di colonne nel campo
	 *  @param M numero di linee nel campo
	 *  @param m numero di bombe nel campo
	 */
	public CampoMinato(int N, int M, int m)
	{
		campo = new int[M][N];
		mask = new boolean[M][N];
		this.N = N;
		this.M = M;
		NUM_MINE = m;
		makeCampo();
	}
	
	/**
	 *  Costruisce il campo, posizionando le mine e impostando i 
	 *  numeri nelle caselle adiacenti.
	 */
	private void makeCampo()
	{
		for (int m = 0; m < NUM_MINE; m++)
		{
			int x = (int)(Math.random() * N);
			int y = (int)(Math.random() * M);
			if (campo[y][x] != -1)
			{
				for (int i = -1; i < 2; i++)
					for(int j = -1; j < 2; j++)
					{
						try
						{ 
							if (campo[y + i][x + j] != -1)
								campo[y + i][x + j]++; 
						}
						catch (ArrayIndexOutOfBoundsException e) { }
					}
				campo[y][x] = -1;
			}
			else m--;
		}
	}

	/**
	 *  Metodo per scoprire le caselle.
	 *  @param x coordinata x della casella da scoprire
	 *  @param y coordinata y
	 *  @return intero indicante lo stato della casella:
	 *  -1 in caso di bomba, altrimenti il numero di bombe 
	 *  presenti nelle caselle adiacenti.
	 */
	public int scopri(int x, int y)
	{
		try
		{
			if (mask[y][x] == false)
			{
				// Segno di aver scoperto la casella.
				mask[y][x] = true;
				// Scopro le caselle adiacenti.
				// Se contengono 0 invoco il metodo scopri ricorsivamente,
				// altrimenti cambio il loro stato.
				for (int i = -1; i < 2; i++)
						for (int j = -1; j < 2; j++)
						{
							try
							{
								if(campo[y + i][x + j] == 0)
									scopri(y + i, x + j);
								mask[y + i][x + j] = true;
								if (campo[y + i][x + j] == -1)
								{
									mask[y + i][x + j] = false;
								}
							}
							catch (ArrayIndexOutOfBoundsException e) { }
						}
				}
				// Aggiorno lo stato in caso di mina.
				if (campo[y][x] < 0)	
				{
					stato = -1;
					mask[y][x] = true;
				}
		return campo[y][x];
		}
		catch(ArrayIndexOutOfBoundsException e) { return 0; }
	}


	/**
	 *  Restituisce una stringa rappresentante il campo
	 *  con l'attuale stato del gioco.
	 *  @return stringa rappresentante il campo.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		// Indici delle colonne
		sb.append("    ");
		for (int i = 1; i <= N; i++)
			sb.append(" " + i + "  ");
		//Matrice
		sb.append("\n    " + "--- ".repeat(M) + "\n");
		for ( int y = 0; y < M; y++)
		{
			sb.append(" " + (y + 1) + " |");
			for (int x = 0; x < N; x++)
			{
				if (mask[y][x])
				{
					String s;
					switch (campo[y][x])
					{
						case -1: s = "X"; break;
						case 0: s = " "; break;
						default: s = String.valueOf(campo[y][x]); break;
					}
					sb.append(" " + s + " |");
				}
				else
					sb.append(" o |");
			}
			sb.append("\n    " + "--- ".repeat(M) + "\n");
		}
		return sb.toString();
	}


	/**
	 *  Restituisce lo stato del gioco.
	 *  @return -1 in caso di perdita, 0 gioco in esecuzione, 1 vincita.
	 */
	public int vinto() { return stato; }

	/**
	 *  Controlla se il gioco è finito.
	 */
	public void checkStato()
	{
		int counter = 0;
		for (int y = 0; y < M; y++)
			for (int x = 0; x < N; x++)
				if (mask[y][x] == false)
					counter++; 
		if (counter == NUM_MINE)
			stato = 1;
	}
}






