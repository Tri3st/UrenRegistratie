import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    //testblok met data
    ArrayList<Uren> myList = new ArrayList<Uren>();
    myList.add(new Uren());
    Uren uur2 = new Uren("08-06-20", new UurTijd(4,45), new UurTijd(17,30), new UurTijd(0,30));
    myList.add(uur2);
    Uren uur3 = new Uren("09-06-20", new UurTijd(5,45), new UurTijd(15,15), new UurTijd(0,30));
    myList.add(uur3);
    Uren uur4 = new Uren("10-06-20", new UurTijd(4,45), new UurTijd(16,30), new UurTijd(0,30));
    myList.add(uur4);
    Uren uur5 = new Uren("11-06-20", new UurTijd(4,45), new UurTijd(16,00), new UurTijd(0,30));
    myList.add(uur5);
    Uren uur6 = new Uren("12-06-20", new UurTijd(5,45), new UurTijd(16,00), new UurTijd(0,30));
    myList.add(uur6);
    boolean quit = false;
    System.out.println("maand?");
    Scanner scanner = new Scanner(System.in);
    int mnd = scanner.nextInt();
    overZicht(myList);
    System.out.println("overuren van maand " + mnd + "("+ getMaand(mnd, false) +") : " + berekenOverurenMnd(myList, mnd));

    while (true) {
      printMenu();
      int action = scanner.nextInt();
      switch(action){
        case 1:
          overZicht(myList);
          break;
        case 2:
          toevoegen(myList, scanner);
          break;
        case 3:
          overurenBerekenen(myList, scanner);
          break;
        case 0:
          quit = true;
          System.out.println("Bye Bye!!");
          break;
        default:
          System.out.println("Command not recognized. Try Again.");
          break;
      }
      if (quit) break;
    }
   
  }

  public static void overZicht(ArrayList lijstje){
    clrScr();
    System.out.println("===== OVERZICHT =======");
    System.out.printf("=WK=|===DATUM==|==BEGIN==|===EIND==|==PAUZE==|=UREN==|=OVER==|=======OPMERKINGEN======%n");
    for (int i=0; i < lijstje.size();i++){
      System.out.printf(lijstje.get(i).toString());
    }   
  }

  public static void toevoegen(ArrayList lijstje, Scanner scanner) {
    boolean quit = false;
    while(!quit) {
      System.out.print("Datum : ");
     String datum = "";
     scanner.nextLine();
     while (true) {
       datum = scanner.nextLine();
       if (datum.matches("\\d{1,2}-\\d{1,2}-\\d{2}")) {
         break;
       }        
       System.out.println("Wrong date format ! use dd-mm-yy");
     }
     System.out.print("Begintijd (uu:mm) : ");
     String beginT = "";
     while (true) {
       beginT = scanner.nextLine();
        if (beginT.matches("\\d{1,2}:\\d{2}")) {
         break;
       }        
       System.out.println("Wrong time format ! use uu:mm");
     }
     System.out.print("Eindtijd (uu:mm) : ");
     String eindT = "";
     while (true) {
       eindT = scanner.nextLine();
       if (eindT.matches("\\d{1,2}:\\d{2}")) {
         break;
       }        
       System.out.println("Wrong time format ! use uu:mm");
     }
     System.out.print("Pauze (uu:mm) : ");
     String pauzeT = "";
     while (true) {
       pauzeT = scanner.nextLine();
       if (pauzeT.matches("\\d{1,2}:\\d{2}")) {
         break;
       }        
       System.out.println("Wrong time format ! use uu:mm");
     }
     System.out.println("Entered data : ");
     System.out.println(datum + "|" + beginT + "|" + eindT + "|" + pauzeT);
     System.out.println("Correct ? (J/N)"); 
     String inp2 = scanner.nextLine();
     if (inp2.equals("J") || inp2.equals("j")) {
       Uren uurtje = new Uren(datum,new UurTijd(beginT),new UurTijd(eindT),new UurTijd(pauzeT));
       lijstje.add(uurtje);
       System.out.println("OPGESLAGEN!");
       quit = true;
     } else {
       System.out.println("try again");
       scanner.nextLine();
       continue;
     }
    }
  }
  
  public static void overurenBerekenen(ArrayList<Uren> lijstje, Scanner scanner) { 
    double overUren = 0;
    double gewerkt = 0;
    Uren uurtje = new Uren();
    System.out.println("Van welke week wil je de overuren berkenen?");
    int inp = scanner.nextInt();
    for (int i = 0; i < lijstje.size(); i++){
    Uren uurT = lijstje.get(i);
      if (uurT.getWeekNr() == inp){
        overUren += uurT.getOveruren();
        gewerkt += uurT.getUrenGewerkt();
      } 
    }
    System.out.println ("Week : "+inp);
    System.out.println("Gewerkt : "+gewerkt);
    System.out.println("Overuren : "+ overUren);
  //  int test = lijstje.weekNr.indexOf(25);
 //   System.out.println(test);


  }
  //maand 3 = maart dus niet 0-indexed
  public static double berekenOverurenMnd(ArrayList<Uren> lijstje, int maand){
    double sum = 0.0;
    for (int i=0; i<lijstje.size();i++){
      if(Integer.parseInt(lijstje.get(i).getDatum().substring(3,5)) == maand){
      sum += lijstje.get(i).getOveruren();
      }
    }
    return sum;
  }
  
  private static String getMaand(int mnd, boolean zeroIndx){
    String m ="";
    if (zeroIndx) mnd++;
    switch (mnd){
      case 1: 
        m += "Januari";
      break;
      case 2: 
        m += "Februari";
      break;
      case 3: 
        m += "Maart";
      break;
      case 4: 
        m += "April";
      break;
      case 5: 
        m += "Mei";
      break;
      case 6: 
        m += "Juni";
      break;
      case 7: 
        m += "Juli";
      break;
      case 8: 
        m += "Augustus";
      break;
      case 9: 
        m += "September";
      break;
      case 10: 
        m += "Oktober";
      break;
      case 11: 
        m += "November";
      break;
      case 12: 
        m += "December";
      break;
      default: 
        m += "UNKNOW";
      break;
    }
    return m;
  }

  public static void printMenu() {
   // clrScr();
    System.out.println("======= MENU =======");
    System.out.println("1. Overzicht");
    System.out.println("2. Toevoegen");
    System.out.println("3. Overuren berkenen");
    System.out.println("0. EXIT");
  }

  public static void clrScr() {
    System. out. print("\033[H\033[2J");
    System.out.flush();
  }
  
}