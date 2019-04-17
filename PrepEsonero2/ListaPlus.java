import java.util.ArrayList;

public class ListaPlus implements Verificabile
{
	private ArrayList<Integer> lista = new ArrayList<>();

	public void add(int k) { lista.add(k); }

	@Override
	public boolean verifica()
	{
		for (Integer i : lista)
			if (i % 2 == 1)
				return false;
		return true;
	}
}