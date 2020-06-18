import java.time.*;
import java.time.temporal.IsoFields;
public class Uren{
  private String datum;
  private int weekNr;
  private UurTijd beginTijd;
  private UurTijd eindTijd;
  private UurTijd pauze;
  private double urengewerkt;
  private double overuren;
  private String opmerking;
  
  public Uren() {
    this.datum = "12-06-20";
    this.weekNr = getWeeknr(datum);
    this.beginTijd = new UurTijd(5,0);
    this.eindTijd = new UurTijd(13,30);
    this.pauze = new UurTijd(30);
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }
  
  public Uren(String datum, UurTijd beginTijd, UurTijd eindTijd, UurTijd pauze) {
    this.datum = datum;
    this.weekNr = getWeeknr(datum);
    this.beginTijd = new UurTijd(beginTijd.getUren(),beginTijd.getMinuten());
    this.eindTijd = new UurTijd(eindTijd.getUren(),eindTijd.getMinuten());
    this.pauze = new UurTijd(pauze.getUren(),pauze.getMinuten());
    this.urengewerkt = calculateGewerkt();
    this.opmerking="-";
  }

  public int getWeekNr() {
    return this.weekNr;
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
  
  public String toSimpleString(){
    return this.beginTijd.getTijd()+ " "+this.eindTijd.getTijd();
  }
  
  public double calculateGewerkt() {
    double temp = 0;
    temp = eindTijd.toDouble() - beginTijd.toDouble() - pauze.toDouble();
    if (temp > 8) {
      this.overuren = temp - 8;
    } else this.overuren = 0;
    return temp;
  }
  
  public String toString (){
    String temp = String.format(" %2d | %s |",this.weekNr,this.datum);
    temp += String.format("  %s  |  %s  |  %s  | %5.2f | %5.2f | %-16s%n",this.beginTijd.toString(),this.eindTijd.toString(),this.pauze.toString(),this.urengewerkt,this.overuren,this.opmerking);
    return temp;
  }

  public int getWeeknr(String date) {
    int day = Integer.parseInt(date.substring(0,2));
    int month = Integer.parseInt(date.substring(3,5));
    int year = Integer.parseInt("20"+date.substring(6,8));
    ZoneId zoneId = ZoneId.of ( "Europe/Amsterdam" );
    ZonedDateTime now = ZonedDateTime.now ( zoneId );
    LocalDate localDate = LocalDate.of( year , month , day );
    int week = localDate.get ( IsoFields.WEEK_OF_WEEK_BASED_YEAR );
    return week;
  }
  
  
}