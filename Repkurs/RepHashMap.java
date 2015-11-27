/*
Program som leser inn fra fil og oppretter en Person for hvert
navn og nummer. Personene lagres i en HashMap.
*/

import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class RepHashMap{

	private HashMap<String, Person> personliste = new HashMap<String, Person>();
	
	RepHashMap(String filnavn) throws Exception{
		lesFraFil(filnavn);
	}

	private void lesFraFil(String filnavn) throws Exception{
		File file = new File(filnavn);
		Scanner innFil = new Scanner(file);

		while(innFil.hasNextLine()){
			String navn = innFil.nextLine();
			String telefonnr = innFil.nextLine();
			Person nyPerson = new Person(navn, telefonnr);
			leggTilPerson(nyPerson);
		}
	}

	public void leggTilPerson(Person person){
		personliste.put(person.toString(), person);
		System.out.println(person.toString() + " ble lagt til i HashMap");
	}

	public void printUtNavnOgNr(){
		for(Person person : personliste.values()){
			System.out.println("Navn: " + person.toString() + 
				"\t Telefon: " + person.hentNr());
		}

	}

	public String hentNrFraNavn(String navn){
		Person hentPerson = personliste.get(navn);
		if(hentPerson != null){
			//Person finnes
			return hentPerson.hentNr();
		} return null;
	}


	
}