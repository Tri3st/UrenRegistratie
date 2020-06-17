 public class UurTijd {
  private int uren;
  private int minuten;
  
  public UurTijd(int uur, int minuten) {
    this.uren = uur;
    this.minuten = minuten;
  }
  
  public UurTijd(int minuten) {
    this.uren = 0;
    this.minuten = minuten;
  }
  
  public void setTijd(int uur, int minuten){
    this.uren = uur;
    this.minuten = minuten;
  }
  
  public String getTijd(){
    String temp ="";
    temp += this.uren + ":" + this.minuten; 
    return temp;
  }
  
  public void setUren(int uur) {
    this.uren = uur;
  }
  
  public void setMinuten(int minuten) {
    this.minuten = minuten;
  }
  
  public int getUren() {
    return this.uren;
  }
  
  public int getMinuten() {
    return this.minuten;
  }
  
  public double toDouble() {
    double urenT = this.uren;
    double minutenT = (double) this.minuten/60;
    return urenT + minutenT;
  }
  
  public String toString() {
    String temp = String.format("%02d:%02d",this.uren,this.minuten);
    return temp;
  }
}