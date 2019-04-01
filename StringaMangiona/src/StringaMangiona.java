package es;

public class StringaMangiona
{
	private String stringa;
	private int mangiate;
	
	public StringaMangiona (String stringa)
	{
		this.stringa = stringa;
	}
	
	public String toString()
	{
		return stringa.substring(0);
	}
	
	public int length()
	{
		return stringa.length();
	}
	
	public char getCarattere(int k)
	{
		return stringa.charAt(k);
	}
	
	public void mangiaLettere(char carattere)
	{
		char[] a = new char[stringa.length()];
		int j = 0;
		char c;
		for (int i = 0; i < stringa.length(); i++)
		{
			c = stringa.charAt(i);
			if (c == carattere)
				mangiate++;
			else
				a[j++] = c;
		}
		stringa = String.valueOf(a, 0, j);
	}
	
	public void slurp()
	{
		mangiate += stringa.length();
		stringa = "";
	}
	
	public void mangiaStringaMangiona(StringaMangiona stringa)
	{
		String s = stringa.toString();
		for (int i = 0; i < s.length(); i++)
			mangiaLettere(s.charAt(i));
	}
	
	public int getTotaleMangiate()
	{
		return mangiate;
	}
	
	public static void main (String[] args)
	{
		StringaMangiona s1 = new StringaMangiona("pasta al sugo");
		
		s1.mangiaStringaMangiona(new StringaMangiona("pomodoro"));
		System.out.println(s1.toString()+ "\t" + s1.getTotaleMangiate());
		s1.mangiaLettere('a');
		System.out.println(s1.toString()+ "\t" + s1.getTotaleMangiate());
	}
	
}
