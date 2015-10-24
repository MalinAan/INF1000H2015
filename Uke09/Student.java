import java.util.HashMap;

public class Student{
  private String navn;
  private HashMap<String, Fag> fagliste = new HashMap<String, Fag>();

  public Student(String navn){
    this.navn = navn;
  }

  public void leggTilFag(Fag fag){
    fagliste.put(fag.toString(), fag);
  }

  public String toString(){
    return navn;
  }

  public void fjernFagFraStudent(Fag fag){
    if(fagliste.containsValue(fag)){
      fagliste.remove(fag.toString());
    } else {
      System.out.println(this.navn + " har aldri vaert oppmeldt til " + fag.toString());
    }
  }

  public void printUtMineFag(){
    for(String fagkode : fagliste.keySet()){
      System.out.println(fagkode);
    }

    System.out.println("");
  }
}
