package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
  
	ComputationCoordinatorImplementation compC = new ComputationCoordinatorImplementation();
	compC.beginComputation();
	
	
	//    Scanner scanner = new Scanner(System.in);
    //Ask User input and output type
//    System.out.println("Input 0 for User input, or 1 for File Input");
//    
//    int userInput = scanner.nextInt();
//    System.out.println("")
//      String filePath = scanner.next();
//      
//      try {
//          File file = new File(filePath);
//          Scanner fileScanner = new Scanner(file);
//
//          System.out.println("Integers in the file:");
//          while (fileScanner.hasNextInt()) {
//              int fileInt = fileScanner.nextInt();
//              System.out.println(fileInt);
//          }
//          fileScanner.close();
//      } catch (FileNotFoundException e) {
//          System.out.println("File not found. Please check the file path.");
//      }
//
//      scanner.close();

  }

}
