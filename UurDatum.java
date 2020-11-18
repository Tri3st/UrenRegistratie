import java.util.GregorianCalendar;
/**
 * Class for working with date formats.
 * Also getting the weeknumber and checking for leapYear 
 */
import java.util.Calendar;
public class UurDatum {
  /** day of the date
   */
  private int dag;
  /** month of the date
   */
  private int maand;
  /** year of the date
   */
  private int jaar;
  /** weeknumber of the date.
   */
  private int week;
  /** isLeapYear ? boolean representative for checking if it is a leapyear or not.
   * true : yes, it is. false : no, it's not.
   */
  private boolean isSchrikkelJaar;
  
  /**
   * Constructor with int values of day, month and year 
   * TODO : validation check
   * @param dag day (integer)
   * @param maand month (integer)
   * @param jaar year (integer)
   */
  public UurDatum (int dag, int maand, int jaar){
    this.dag = dag;
    this.maand = maand;
    this.jaar = jaar;
    this.week = calculateWeekNr();
  }
  
  /**
   *  Constructor with a string of a date. String must be in "DD-MM-YY" format.
   *  TODO : be able to check if it is in DDMMYY or in YYMMDD format
   * @param datum date in String format. DD-MM-YY is required.
   */
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
  
  /**
   * Gives the object in a nice string. to be used for SQL. in format YY-MM-DD
   * @return the date in string format for SQL. YY-MM-DD
   */
  public String toSqlString() {
    String tmp = "";
    tmp += String.format("%02d-%02d-%02d",jaar , maand, dag);
    return tmp;
  }
  
  /**
   * Gives the object in a nice string. to be used for whatever. in format DD-MM-YY
   * @return the date in string format. DD-MM-YY
   */
  public String toString() {
    String tmp = "";
    tmp += String.format("%02d-%02d-%02d",dag, maand, jaar);
    return tmp;
  }
}