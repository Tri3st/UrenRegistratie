import java.util.GregorianCalendar;
import java.util.Calendar;
public class UurDatum {
  private int dag;
  private int maand;
  private int jaar;
  private int week;
  private boolean isSchrikkelJaar;
  
  public UurDatum (int dag, int maand, int jaar){
    this.dag = dag;
    this.maand = maand;
    this.jaar = jaar;
    this.week = calculateWeekNr();
  }
  
  public UurDatum (String datum){
    String[] strArr = datum.split("-");
    int dag1 = Integer.parseInt( strArr[0]);
    int maand1 = Integer.parseInt(strArr[1]);
    int jaar1 = Integer.parseInt(strArr[2]);
    this.dag = dag1;
    this.maand = maand1;
    this.jaar = jaar1;
    this.week = calculateWeekNr();
  }
  
  private int calculateWeekNr() {
    GregorianCalendar dat = new GregorianCalendar(jaar, maand, dag);
    this.week = dat.get(Calendar.WEEK_OF_YEAR);
    this.isSchrikkelJaar = dat.isLeapYear(this.jaar);
    return this.week;
  }
  
  public int getWeek() {
    return this.week;
  }
  
  public boolean isSchrikkel () {
    return isSchrikkelJaar;
  }
  
  public String toSqlString() {
    String tmp = "";
    tmp += String.format("%02d-%02d-%02d",jaar , maand, dag);
    return tmp;
  }
  
  public String toString() {
    String tmp = "";
    tmp += String.format("%02d-%02d-%02d",dag, maand, jaar);
    return tmp;
  }
}