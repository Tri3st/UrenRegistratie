/**
 * Class for working with time formats. 
 * Normal time : HH:MM
 * sql date : HH:MM:SS (additional :00 )
 * also the possibility to convert time to a decimal value
 * e.g. 4:30 is 4,5
 * 
 * @author Martin van Diest
 *
 */
public class UurTijd {
  /**
   * number of hours in the time format 
   * (HH) (between 0 and 23)
   */
  private int uren;
  /**
   * number of minutes in time format
   * (MM) (between 0 and 59)
   */
  private int minuten;
  /**
   * the time represented in decimals.
   */
  private double decimalen;
  
  /**
   * Constructor with given hours (uur) and minutes (minuten)
   * @param uur the given hours
   * @param minuten the given minutes
   */
  public UurTijd(int uur, int minuten) {
    this.uren = uur;
    this.minuten = minuten;
    this.decimalen = toDouble();
  }
  
  /**
   * Constructor for only minutes. for example the pauze is standard 0:30
   * UurTijd(30) will make a time 00:30 
   * @param minuten the given minutes
   */
  public UurTijd(int minuten) {
    this(0, minuten);
    this.decimalen = toDouble();
  }

  /**
   * Constructor for making a time format from a given string
   * the string must be of the format "HH:MM"
   * TODO : "HH:MM:SS" must be able to work to. and a check for correct format
   * @param tijdStr
   */
  public UurTijd(String tijdStr){
    String[] tijdje = tijdStr.split(":");
    this.uren =  Integer.parseInt(tijdje[0]);
    this.minuten =  Integer.parseInt(tijdje[1]);
    this.decimalen = toDouble();
  }
  
  public int getUren() {
    return this.uren;
  }
  
  public int getMinuten() {
    return this.minuten;
  }
  
  public double getDecimalen(){
    return this.decimalen;
  }
  
  private double toDouble() {
    double urenT = this.uren;
    double minutenT = this.minuten/60.00;
    return urenT + minutenT;
  }
  
  /**
   * return a string format of the object.
   * format : "HH:MM" 
   * if hours is 8 , it will be shown as 08
   */
  public String toString() {
    String temp = String.format("%02d:%02d",this.uren,this.minuten);
    return temp;
  }
}