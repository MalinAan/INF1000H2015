/* 
Oppgave: 
"telefonliste.txt" inneholder en liste av personer. For hvert navn
kommer det tilhorende telefonnummeret paa linjen under. Det skal opprettes
en Person med et navn og telefonnummer. Lag et program som bruker ordinaere arrays,
en som bruker ArrayList og en som bruker HashMap. Alle programmene skal lese fra fil.
*/

public class RepKurs{
	public static void main(String[] args) throws Exception{
		
		//Testing av RepArray-klassen.
		RepArray repArray = new RepArray("telefonliste.txt");
		repArray.printUtNavnOgNr();
		String hentNr = repArray.hentNrFraNavn("Mathias");
		if(hentNr != null){
			System.out.println("Mathias har nr " + hentNr);
		} else {
			System.out.println("Mathias er ikke i lista");
		}

		//Testing av RepArrayList-klassen.
		RepArrayList repArrayList = new RepArrayList("telefonliste.txt");
		repArrayList.printUtNavnOgNr();

		//Testing av RepHashMap-klassen.
		RepHashMap repHashMap = new RepHashMap("telefonliste.txt");
		repHashMap.printUtNavnOgNr();
		hentNr = repHashMap.hentNrFraNavn("Trine");
		if(hentNr != null){
			System.out.println("Trine har nr " + hentNr);
		} else {
			System.out.println("Trine er ikke i lista");
		}

	}
}