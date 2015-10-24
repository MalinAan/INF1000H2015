import java.util.HashMap;

public class Fag{
  private String fagkode;
  private HashMap<String, Student> studenter = new HashMap<String, Student>();

  public Fag(String fagkode){
    this.fagkode = fagkode;
  }

  public String toString(){
    return fagkode;
  }

  public void leggTilStudent(Student student){
    studenter.put(student.toString(), student);
  }

  public void fjernStudentFraFag(Student student){
    if(studenter.containsKey(student.toString())){
      studenter.remove(student.toString());
    } else {
      System.out.println(student.toString() + " har aldri vaert oppmeldt til " + this.fagkode);
    }
  }

  public void skrivUtMineStudenter(){
    for(String navnTilStudent : studenter.keySet()){
      System.out.println(navnTilStudent);
    }
  }
}
