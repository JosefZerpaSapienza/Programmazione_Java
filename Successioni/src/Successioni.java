import java.util.ArrayList;

public interface Successione 
{
	/**
	 *  Genera e restituisce il prossimo valore della seccessione.
	 */
	int next();

	/**
	 *  Restituisce una lista con i prossimi n valori 
	 *  della successione.
	 *  @param n numero di valori da generare.
	 */
	ArrayList<Integer> nextValues(int n)
	{
		ArrayList<Integer> lista = new ArrayList<>();
		for(int m = 0; m < n; m++)
			lista.add(next());
		return lista;
	}
}