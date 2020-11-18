/**
 * Base Class for handeling the date, times and time calculations.
 * 
 * @author Martin van Diest
 *
 */
public class Uren{
  /**
   * UurDatum object to handle the date
   */
  private UurDatum datum;
  /**
   * week number. is retrieved from the UurDatum class
   */
  private int weekNr;
  /**
   * start time
   */
  private UurTijd beginTijd;
  /**
   * end time
   */
  private UurTijd eindTijd;
  /**
   * break time
   */
  private UurTijd pauze;
  /**
   * total hours of worked time. eindtijd - begintijd - pauze = URENGEWERKT
   */
  private double urengewerkt;
  /**
   * calculated over hours. urengewerkt - 8 .. everything over 8 hours of work is OVERUREN
   * is also possible to be a negative number.
   */
  private double overuren;
  /**
   * comment
   */
  private String opmerking;
  
  /**
   * empty Constructor
   * makes a test case
   */
  public Uren() {
    this.datum = new UurDatum("02-06-20");
    this.weekNr = datum.getWeek();
    this.beginTijd = new UurTijd(5,0);
    this.eindTijd = new UurTijd(13,30);
    this.pauze = new UurTijd(30);
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }
  
  /**
   * String date constructor.
   * @param datumStr date in string format
   * @param beginTijd start time in UurTijd format
   * @param eindTijd end time in UurTijd format
   * @param pauze break time in UurTijd format
   */
  public Uren(String datumStr, UurTijd beginTijd, UurTijd eindTijd, UurTijd pauze) {
    this.datum = new UurDatum(datumStr);
    this.weekNr = datum.getWeek();
    this.beginTijd = new UurTijd(beginTijd.getUren(),beginTijd.getMinuten());
    this.eindTijd = new UurTijd(eindTijd.getUren(),eindTijd.getMinuten());
    this.pauze = new UurTijd(pauze.getUren(),pauze.getMinuten());
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }
  
  /**
   * UurDatum date constructor. 
  * @param datumStr date in string format
   * @param beginTijd start time in UurTijd format
   * @param eindTijd end time in UurTijd format
   * @param pauze break time in UurTijd format
   */
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
  
  /**
   * returns a nice string representative of a whole Uren Object.
   * weeknr | date | begintime | endtime | breaktime | workedhours | overhours
   */
  public String toString (){
    String temp = String.format(" %2d | %s |",this.weekNr,this.datum.toString());
    temp += String.format("  %s  |  %s  |  %s  | %5.2f | %5.2f | %-16s%n",this.beginTijd.toString(),this.eindTijd.toString(),this.pauze.toString(),this.urengewerkt,this.overuren,this.opmerking);
    return temp;
  }
  
}