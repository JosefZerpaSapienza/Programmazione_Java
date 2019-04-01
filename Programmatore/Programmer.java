public class Programmer
{
	private String name, surname, company, langs = "";

	public Programmer(String nome, String cognome)
	{
		name = nome;
		surname = cognome;
	}

	public void setAzienda(String azienda)
	{
		company = azienda;
	}

	public void addLinguaggio(String linguaggio)
	{
		langs += linguaggio + " ";
	}

	public String getNome()
	{
		return name;
	}
	public String getCognome()
	{
		return surname;
	}
	public String getAzienda()
	{
		return company;
	}

	public String getLinguaggi()
	{
		return langs;
	}
}