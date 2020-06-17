import java.util.ArrayList;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    //testblok met data
    ArrayList<Uren> myList = new ArrayList<Uren>();
    myList.add(new Uren());
    Uren uur2 = new Uren("10-05-20", new UurTijd(5,30), new UurTijd(15,00), new UurTijd(0,30));
    myList.add(uur2);
    
    printMenu();
    boolean quit = false;
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int action = scanner.nextInt();
      switch(action){
        case 1:
          overZicht(myList);
          break;
        case 2:
          toevoegen(myList, scanner);
          break;
        case 3:
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
    System.out.printf("=WK=|===DATUM==|==BEGIN==|===EIND==|==PAUZE==|=UREN=|=OVER=|=======OPMERKINGEN======%n");
    for (int i=0; i < lijstje.size();i++){
      System.out.printf(lijstje.get(i).toString());
    }   
  }

  public static void toevoegen(ArrayList lijstje, Scanner scanner) {
    System.out.println("Datum : ");
    String datum = "";
    while (true) {
      datum = scanner.nextLine();
      if (datum.matches("\\d{2}-\\d{2}-\\d{2}")) {
        break;
      }        
      System.out.println("Wrong date format ! use dd-mm-yy");
    }
    System.out.println("Datum ingevoerd : " + datum);
  }
  
  public static void printMenu() {
    clrScr();
    System.out.println("======= MENU =======");
    System.out.println("1. Overzicht");
    System.out.println("2. Toevoegen");
    System.out.println("3. Verwijderen");
    System.out.println("0. EXIT");
  }

  public static void clrScr() {
    System. out. print("\033[H\033[2J");
    System. out. flush();
  }

}