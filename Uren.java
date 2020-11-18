
public class Uren{
  private UurDatum datum;
  private int weekNr;
  private UurTijd beginTijd;
  private UurTijd eindTijd;
  private UurTijd pauze;
  private double urengewerkt;
  private double overuren;
  private String opmerking;
  
  public Uren() {
    this.datum = new UurDatum("02-06-20");
    this.weekNr = datum.getWeek();
    this.beginTijd = new UurTijd(5,0);
    this.eindTijd = new UurTijd(13,30);
    this.pauze = new UurTijd(30);
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }
  
  public Uren(String datumStr, UurTijd beginTijd, UurTijd eindTijd, UurTijd pauze) {
    this.datum = new UurDatum(datumStr);
    this.weekNr = datum.getWeek();
    this.beginTijd = new UurTijd(beginTijd.getUren(),beginTijd.getMinuten());
    this.eindTijd = new UurTijd(eindTijd.getUren(),eindTijd.getMinuten());
    this.pauze = new UurTijd(pauze.getUren(),pauze.getMinuten());
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }
  
  public Uren(UurDatum datumobj, UurTijd beginTijd, UurTijd eindTijd, UurTijd pauze) {
    this.datum = datumobj;
    this.weekNr = datum.getWeek();
    this.beginTijd = new UurTijd(beginTijd.getUren(),beginTijd.getMinuten());
    this.eindTijd = new UurTijd(eindTijd.getUren(),eindTijd.getMinuten());
    this.pauze = new UurTijd(pauze.getUren(),pauze.getMinuten());
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }
  
  public int getWeekNr() {
    return this.weekNr;
  }
  
  public String getDatum(){
    return this.datum.toString();
  }
  public double getOveruren() {
    return this.overuren;
  }
  
  public double getUrenGewerkt() {
    return this.urengewerkt;
  }
  
  

  public String getBeginTijdStr() {
    String temp = String.format("%0d:%0d",this.beginTijd.getUren(),this.beginTijd.getMinuten());
    return temp;
  }

  public String getEindTijdStr() {
    String temp = String.format("%0d:%0d",this.eindTijd.getUren(),this.eindTijd.getMinuten());
    return temp;
  }

  public String getPauzeStr() {
    String temp = String.format("%0d:%0d",this.pauze.getUren(),this.pauze.getMinuten());
    return temp;
  }
  
  private double calculateGewerkt() {
    double temp = 0;
    temp = eindTijd.getDecimalen() - beginTijd.getDecimalen() - pauze.getDecimalen();
    this.urengewerkt = temp;
    this.overuren = this.urengewerkt - 8;
    return this.urengewerkt;
  }
  
  public String toString (){
    String temp = String.format(" %2d | %s |",this.weekNr,this.datum.toString());
    temp += String.format("  %s  |  %s  |  %s  | %5.2f | %5.2f | %-16s%n",this.beginTijd.toString(),this.eindTijd.toString(),this.pauze.toString(),this.urengewerkt,this.overuren,this.opmerking);
    return temp;
  }
  
}