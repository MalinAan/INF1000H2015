/*
Program som leser inn fra fil og oppretter en Person for hvert
navn og nummer. Personene lagres i en ArrayList.
*/


import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class RepArrayList{

	private ArrayList<Person> personliste = new ArrayList<Person>();

	RepArrayList(String filnavn) throws Exception{
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
		personliste.add(person);
		System.out.println(person.toString() + " ble lagt til i ArrayList");
	}

	public void printUtNavnOgNr(){
		for(Person enPerson : personliste){
			System.out.println("Navn: " + enPerson.toString() +
				"\t Telefon: " + enPerson.hentNr());
		}
	}

	public String hentNrFraNavn(String navn){
		for(int i = 0; i < personliste.size(); i++){
			Person person = personliste.get(i);
			if(person.toString().equalsIgnoreCase(navn)){
				//Match!
				return person.hentNr();
			}
		} return null;
	}


}