public class Person{
	private String navn;
	private String telefonnr;

	Person(String navn, String nr){
		this.navn = navn;
		telefonnr = nr;
	}

	public String toString(){
		return navn;
	}

	public String hentNr(){
		return telefonnr;
	}
}