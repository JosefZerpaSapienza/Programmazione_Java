package es;
import java.util.Arrays;

public class GestoreArray 
{
	private int[] array;
	
	public GestoreArray(int[] array)
	{
		this.array = array;
	}
	
	public static void main(String[] args)
	{
		int[] myarray = {2, 4, 6, 10};
		GestoreArray a = new GestoreArray(new int[] {1, 2, 3});
		GestoreArray b = new GestoreArray(myarray);
		
		System.out.println(a.toString() + "\n" + a.indexOf(3) 
			+ "\n" + a.indexOf(4));
		a.concat(b);
		System.out.println(a.toString());
		a.concat(new int[] {4, 5, 6, 7});
		
		// Disegna Stato Memoria
		System.out.println(a.toString());
		
		GestoreArray a3 = new GestoreArray(new int[] {1, 2});
				
		System.out.println(a3.concatNoDup(new int[] {6, 2, 3})
			+ "\n" + a3.toString());
	}

	/**
	 * Restituisce una stringa rappresentante l'array.
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for (int i: array)
			sb.append(String.valueOf(i) + ", ");
		sb.deleteCharAt(sb.length() - 2);
		sb.append("}");
		return sb.toString();
	}
	
	/**
	 * Restituisce l'indice della prima posizione in cui si 
	 * trova l'intero fornito, nell'array. Se l'intero non
	 * è presente restituisce -1.
	 * @param n Intero da cercare
	 * @return indice, altrimenti -1
	 */
	
	public int indexOf(int n)
	{
		int i;
		for (i = 0; i < array.length; i++)
			if (array[i] == n) return i;
		return -1;
	}
	
	/**
	 * Concatena l'array con quello fornito.
	 * @param array2 Array da concatenare.
	 */
	public void concat(int[] array2)
	{
		int[] arrayConcatenato = new int[array.length + array2.length];
		for (int i = 0; i < array.length; i++)
			arrayConcatenato[i] = array[i];
		for (int j = 0; j < array2.length ; j++)
			arrayConcatenato[array.length + j] = array2[j];
		array = arrayConcatenato;
	}
	
	/**
	 * Metodo per gestire concatenazioni con array di tipo Array
	 * @param a array di tipo Array
	 */
	public void concat(GestoreArray a)
	{
		concat(a.array);
	}
	
	/**
	 * Concatena un array senza concatenare elementi già presenti
	 * nell'array di partenza.
	 * @param array2 array da concatenare
	 */
	public int concatNoDup(int[] array2)
	{
		int scartati = 0;
		for (int n : array2)
			if (indexOf(n) < 0) 
				concat(new int[] {n});
			else
				scartati++;
		return scartati;
	}
	
	public int concatNoDup2(int[] array2)
	{
		int[] arrayNoDup = new int[array2.length];
		
		int i = 0;
		for (int n : array2)
			if (indexOf(n) < 0)
				arrayNoDup[i++] = n;
		concat(Arrays.copyOf(arrayNoDup, i));
		
		return i;
	}
	
	/**
	 * Sostituisce, se presente, un numero dato con un altro.
	 * Restituisce true se l'operazione viene effettuata, 
	 * false altrimenti. 
	 * @param x numero da sostituire
	 * @param y	numero sostituente
	 */
	public boolean replace(int x, int y)
	{
		int i = indexOf(x);
		if (i < 0)
			return false;
		else
		{
			array[i] = y;
			return true;
		}
	}
	
}
