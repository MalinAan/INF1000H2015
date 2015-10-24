import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class Skole{
  private HashMap<String, Student> studenter = new HashMap<String, Student>();
  private HashMap<String, Fag> kurs = new HashMap<String, Fag>();
  private Scanner tastatur = new Scanner(System.in);

  public void meny(){
    System.out.println("**************STUDENTSYSTEM***************");
    System.out.println("1: Legg til ny student.");
    System.out.println("2: Legg til nytt fag.");
    System.out.println("3: Skriv ut alle studenter som tar et fag.");
    System.out.println("4: Meld opp student til et fag.");
    System.out.println("5: Meld av en student til et fag.");
    System.out.println("6: Fjern en student fra systemet.");
    System.out.println("7: Fjern et fag fra systemet.");
    System.out.println("8: Finn ut hvilket fag som blir tatt av flest studenter.");
    System.out.println("9: Finn ut hvilken student som tar flest fag.");
    System.out.println("10: Skriv ut alle fag og hvilke studenter som tar de.");
    System.out.println("11: Skriv ut alle fag en student tar.");
    System.out.println("12. Avslutt program.\n");

  }

  public void ordrelokke() throws Exception{
    int valg = -1;
    lesFraFil();

    while(valg != 12){
      meny();
      valg = Integer.parseInt(tastatur.nextLine());
      if(valg == 1){
        leggTilStudent();
      } else if(valg == 2){
        leggTilNyttFag();
      } else if(valg == 3){
        skrivUtAlleStudenterSomTarEtFag();
      } else if(valg == 4){
        meldOppStudentTilFag();
      } else if(valg == 5){
        meldAvStudentTilFag();
      } else if(valg == 6){
        slettStudent();
      } else if(valg == 7){
        slettFag();
      } else if(valg == 8){
        finnMestPopulaereFag();
      } else if(valg == 9){
        finnMestArbeidsommeStudent();
      } else if(valg == 10){
        skrivUtAlleFagOgDeresStudenter();
      } else if(valg == 11){
        skrivUtAlleFagEnStudentTar();
      }
    }

    avslutt();
  }

  public void skrivUtAlleFagEnStudentTar(){
    System.out.println("Hvilken student vil du se fagene til?");
    String navn = tastatur.nextLine();

    if(!finnesStudent(navn)){
      System.out.print(navn  + " finnes ikke");
      return;
    }

    Student student = studenter.get(navn);
    student.printUtMineFag();

  }

  public void lesFraFil() throws Exception{
    File file = new File("emnestudenter.txt");
    Scanner fil = new Scanner(file);
    Fag fag = null;
    while(fil.hasNextLine()){
      String linje = fil.nextLine();
      if(linje.charAt(0) == '*'){
        //Linje er et fag.
        fag = new Fag(linje.substring(1));
        kurs.put(fag.toString(), fag);
      } else {
        Student student = null;
        if(studenter.containsKey(linje)){
          //Student finnes allerede.
          student = studenter.get(linje);
        } else {
          //Student finnes ikke - opprett ny student.
          student = new Student(linje);
          studenter.put(linje, student);
        }
        fag.leggTilStudent(student);
        student.leggTilFag(fag);
      }
    }
  }

  public void leggTilStudent(){
    System.out.println("Hva heter studenten du vil legge til?");
    String navn = tastatur.nextLine();

    if(studenter.containsKey(navn)){
      System.out.println(navn + " finnes allerede i systemet.");
    } else {
      Student student = new Student(navn);
      studenter.put(navn, student);
    }
  }

  public void leggTilNyttFag(){
    System.out.println("Hva kalles faget du vil legge til?");
    String fagkode = tastatur.nextLine();

    if(kurs.containsKey(fagkode)){
      System.out.println(fagkode + " finnes allerede i systemet.");
    } else {
      Fag fag = new Fag(fagkode);
      kurs.put(fagkode, fag);
    }
  }

  public void skrivUtAlleStudenterSomTarEtFag(){
    System.out.println("Hvilket fag vil skrive ut studenten til?");
    String fagnavn = tastatur.nextLine();

    if(kurs.containsKey(fagnavn)){
      Fag fag = kurs.get(fagnavn);
      fag.skrivUtMineStudenter();
    } else {
      System.out.println(fagnavn + " finnes ikke i systemet.");
    }

  }

  public boolean finnesStudent(String navn){
    if(studenter.containsKey(navn)){
      return true;
    } return false;
  }

  public boolean finnesFag(String fagkode){
    if(kurs.containsKey(fagkode)){
      return true;
    } return false;
  }

  public void meldOppStudentTilFag(){
    System.out.println("Hvilken student vil du melde opp?");
    String navnTilStudent = tastatur.nextLine();
    if(!finnesStudent(navnTilStudent)){
      System.out.println(navnTilStudent + " finnes ikke.");
      return;
    }

    System.out.println("Hvilket fag vil du melde opp studenten til?");
    String fagkode = tastatur.nextLine();
    if(!finnesFag(fagkode)){
      System.out.println(fagkode + " finnes ikke.");
      return;
    }

    Fag fag = kurs.get(fagkode);
    Student student = studenter.get(navnTilStudent);

    fag.leggTilStudent(student);
    student.leggTilFag(fag);

  }

  public void meldAvStudentTilFag(){
    System.out.println("Hvilken student vil du melde av?");
    String navnTilStudent = tastatur.nextLine();
    if(!finnesStudent(navnTilStudent)){
      System.out.println(navnTilStudent + " finnes ikke.");
      return;
    }

    System.out.println("Hvilket fag vil du melde av studenten til?");
    String fagkode = tastatur.nextLine();
    if(!finnesFag(fagkode)){
      System.out.println(fagkode + " finnes ikke.");
      return;
    }

    Fag fag = kurs.get(fagkode);
    Student student = studenter.get(navnTilStudent);

    fag.fjernStudentFraFag(student);
    student.fjernFagFraStudent(fag);

  }

  public void slettStudent(){

  }

  public void slettFag(){

  }

  public void finnMestPopulaereFag(){

  }

  public void finnMestArbeidsommeStudent(){

  }

  public void skrivUtAlleFagOgDeresStudenter(){
    for(Fag fag : kurs.values()){
      System.out.println("FAG: " + fag.toString());
      fag.skrivUtMineStudenter();
      System.out.println("");
    }
  }

  public void avslutt(){

  }


}
