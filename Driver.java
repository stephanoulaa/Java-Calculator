import java.util.Scanner;

public class Driver {
   
    //create variable that make up expression in textfield
    public String expression = "";
    
    //to continue the loop...
    public static int looper = 0;

    public String getText() {
        return expression;
    } 
    
    public static void main(String[] args) {
      
        
      Scanner scanner = new Scanner(System.in);
        
      while(looper == 0) {
      
          System.out.println("Hello! What do you want to calculate today?");
          
          String expression = scanner.nextLine();
          expression = Engine.calc(expression);
          System.out.println(expression);
          
          System.out.println("Would you like to continue using this calculator? (Yes/No)");
          String loopCheck = scanner.nextLine();
          
          if (loopCheck.equals("No")) {
              looper = 1; 
          }
          
      } //end of while loop
      
  }
  
}