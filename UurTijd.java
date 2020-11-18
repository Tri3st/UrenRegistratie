 public class UurTijd {
  private int uren;
  private int minuten;
  private double decimalen;
  
  public UurTijd(int uur, int minuten) {
    this.uren = uur;
    this.minuten = minuten;
    this.decimalen = toDouble();
  }
  
  public UurTijd(int minuten) {
    this(0, minuten);
    this.decimalen = toDouble();
  }

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
  
  
  public String toString() {
    String temp = String.format("%02d:%02d",this.uren,this.minuten);
    return temp;
  }
}