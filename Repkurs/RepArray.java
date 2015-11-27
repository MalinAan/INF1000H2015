/*
Program som leser inn fra fil og oppretter en Person for hvert
navn og nummer. Personene lagres i en ordinaer array.
*/

import java.util.Scanner;
import java.io.File;

public class RepArray{
	
	private Person[] personArray = new Person[100];

	RepArray(String filnavn) throws Exception{
		lesFraFil(filnavn);
	}

	public void lesFraFil(String filnavn) throws Exception{
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
		for(int i = 0; i < personArray.length; i++){
			if(personArray[i] == null){
				//Plass er ledig!
				personArray[i] = person;
				System.out.println(person.toString() + " ble lagt til paa plass "
				 + i + " i arrayen");
				return;
			}
		} System.out.println(person.toString() + " ble ikke lagt til.");
	}

	public void printUtNavnOgNr(){
		for(int i = 0; i < personArray.length; i++){
			if(personArray[i] != null){
				System.out.println("Navn: " + personArray[i].toString() +
				"\t Telefonnr: " + personArray[i].hentNr());
			}
		}
	}

	public String hentNrFraNavn(String navn){
		for(int i = 0; i < personArray.length; i++){
			if(personArray[i] != null && 
				personArray[i].toString().equalsIgnoreCase(navn)){
				return personArray[i].hentNr();
			}
		} return null;
	}
}