import java.io.IOException;
import java.util.NoSuchElementException;

public class errorHand {

  public static void errorHand(Exception ex) {
    x.println("Error: " + ex.getMessage());
  }
  public static void errorHand(StackOverflowError stack){
    x.println("Stack Over Flow error: " + stack.getMessage());
  }
  public static void errorHand(ArithmeticException ar){
    x.println("Arithmetic error: " + ar.getMessage());
  }
  public static void errorHand(IOException io){
    x.println("Input/output error: " + io.getMessage());
  }
  public static void errorHand(NoSuchElementException noEl){
    x.println("No elements error: " + noEl.getMessage());
  }
  public static void errorHand(NullPointerException nullP){
    x.println("Error - Obeject not initialized: " + nullP.getMessage());
  }
  public static void errorHand(NumberFormatException nop){
    x.println("Error - Invalid format entered: " + nop.getMessage());
  }
  public static void errorHand(ArrayIndexOutOfBoundsException ai){
    x.println("Erro r- Out of bounds..!: " + ai.getMessage());
  }
  
} 
